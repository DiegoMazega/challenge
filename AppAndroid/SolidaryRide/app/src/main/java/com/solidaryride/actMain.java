package com.solidaryride;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.solidaryride.database.DadosOpenHelper;
import com.solidaryride.dominio.entidades.Carona;
import com.solidaryride.dominio.repositorio.RideRepositorio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class actMain extends AppCompatActivity {

    private RecyclerView lstRides;
    private FloatingActionButton fab;
    private SQLiteDatabase db;
    private DadosOpenHelper dadosOpenHelper;

    private RideAdapter rideAdapter;
    private RideRepositorio rideRepositorio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        lstRides = (RecyclerView)findViewById(R.id.lstRides);

        buildConection();

        lstRides.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstRides.setLayoutManager(linearLayoutManager);

        rideRepositorio = new RideRepositorio(db);
            List<Carona> dados = rideRepositorio.searchAll();

            rideAdapter = new RideAdapter(dados);
            lstRides.setAdapter(rideAdapter);

    }

    private void buildConection(){
        try{
            dadosOpenHelper = new DadosOpenHelper(this);
            db = dadosOpenHelper.getWritableDatabase();
            Snackbar.make(lstRides, R.string.message_conection_ok, Snackbar.LENGTH_SHORT).setAction("OK", null).show();

        }catch (SQLException event){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle(R.string.tittle_erro);
            dialog.setMessage(event.getMessage());
            dialog.setNeutralButton(R.string.action_ok, null);
            dialog.show();
        }
    }

    public void showRide(View view){
        //chama a partir do botão a outra tela
        Intent it = new Intent(actMain.this, ActRide.class);
        startActivityForResult(it, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        List<Carona> dados = rideRepositorio.searchAll();
        rideAdapter = new RideAdapter(dados);
        lstRides.setAdapter(rideAdapter);
    }
}
