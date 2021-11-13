package com.solidaryride;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.solidaryride.database.DadosOpenHelper;
import com.solidaryride.dominio.entidades.Carona;
import com.solidaryride.dominio.repositorio.RideRepositorio;

public class ActRide extends AppCompatActivity {

    private EditText edtName;
    private EditText edtFrom;
    private EditText edtTo;
    private EditText edtNextTo;
    private EditText edtNumber;

    private RideRepositorio rideRepositorio;
    private SQLiteDatabase db;
    private DadosOpenHelper dadosOpenHelper;
    private ConstraintLayout layoutContentCadRide;
    private Carona ride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_ride);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //fazemos um cast para o tipo de arquivo que queremos salvar e usamos o ID para pegar o valor alvo
        edtName = (EditText)findViewById(R.id.edtName);
        edtFrom = (EditText)findViewById(R.id.edtFrom);
        edtTo = (EditText)findViewById(R.id.edtTo);
        edtNextTo = (EditText)findViewById(R.id.edtNextTo);
        edtNumber = (EditText)findViewById(R.id.edtNumber);
        layoutContentCadRide = (ConstraintLayout)findViewById(R.id.layoutContentCadRide);
        buildConection();
        verify();

    }

    private void verify(){
        Bundle bundle = getIntent().getExtras();
        ride = new Carona();
        if((bundle!=null)&&(bundle.containsKey("RIDE"))){
            ride = (Carona) bundle.getSerializable("RIDE");
            edtName.setText(ride.getName());
            edtFrom.setText(ride.getInit());
            edtTo.setText(ride.getDestiny());
            edtNextTo.setText(ride.getNextTo());
            edtNumber.setText(ride.getNumber());
            }
    }

    private void confirm(){

        if(validatingFields() == false){
            try{
                if(ride.getCodigo() == 0) {
                    rideRepositorio.insert(ride);
                }else{
                    rideRepositorio.uppdate(ride);
                }
                finish();
            }catch (SQLException event){
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle(R.string.tittle_erro);
                dialog.setMessage(event.getMessage());
                dialog.setNeutralButton(R.string.action_ok, null);
                dialog.show();
            }

        }
    }

    private boolean validatingFields(){
        boolean result = false;
        //recupera os valores das caixas de texto para validação
        String name = edtName.getText().toString();
        String from = edtFrom.getText().toString();
        String to = edtTo.getText().toString();
        String nextTo = edtNextTo.getText().toString();
        String number = edtNumber.getText().toString();

        ride.setName(name);
        ride.setInit(from);
        ride.setDestiny(to);
        ride.setNextTo(nextTo);
        ride.setNumber(number);

        if(result = isEmpty(name)){
            edtName.requestFocus();
        }
        else if(result = isEmpty(from)){
            edtFrom.requestFocus();
        }
        else if(result = isEmpty(to)){
            edtTo.requestFocus();
        }
        else if(result = isEmpty(nextTo)){
            edtNextTo.requestFocus();
        }
        else if(result = isEmpty(number)){
            edtNumber.requestFocus();
        }
        else if(result = number.length()<10){
                edtNumber.requestFocus();
        }

        if(result){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle(R.string.title_aviso);
            dialog.setMessage(R.string.title_mensagem);
            dialog.setNeutralButton(R.string.action_ok, null);
            dialog.show();
        }
        return result;
    }

    public boolean isEmpty(String value){
        boolean result = (TextUtils.isEmpty(value) || value.trim().isEmpty());
        return result;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_cad_ride, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void buildConection(){
        try{
            dadosOpenHelper = new DadosOpenHelper(this);
            db = dadosOpenHelper.getWritableDatabase();
            rideRepositorio = new RideRepositorio(db);
        }catch (SQLException event){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle(R.string.tittle_erro);
            dialog.setMessage(event.getMessage());
            dialog.setNeutralButton(R.string.action_ok, null);
            dialog.show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_ok:
                confirm();
                break;
            case R.id.action_excluir:
                rideRepositorio.delete(ride.getCodigo());
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
