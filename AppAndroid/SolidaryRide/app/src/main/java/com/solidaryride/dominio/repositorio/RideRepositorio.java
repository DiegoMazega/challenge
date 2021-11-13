package com.solidaryride.dominio.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.solidaryride.dominio.entidades.Carona;

import java.util.ArrayList;
import java.util.List;
//CRUD
public class RideRepositorio {

    private SQLiteDatabase db;

    public RideRepositorio(SQLiteDatabase db){
        this.db = db;
    }

    public void insert(Carona carona){
        //inserção no db
        ContentValues values = new ContentValues();
        //insere valores na tabela.
        values.put("NAME", carona.getName());
        values.put("INIT", carona.getInit());
        values.put("DESTINY", carona.getDestiny());
        values.put("NEXTTO", carona.getNextTo());
        values.put("NUMBER", carona.getNumber());

        //insere os valores do db e caso haja erro nos informa
        db.insertOrThrow("RIDE", null, values);
    }

    public void delete(int codigo){

        String[] codigos = new String[1];
        codigos[0] = String.valueOf(codigo);

        //deleta os valores do db do codigo digitado
        db.delete("RIDE", "CODIGO = ?", codigos);
    }

    public void uppdate(Carona carona){
        //update no db
        ContentValues values = new ContentValues();
        //atualiza os valores na tabela.
        values.put("NAME", carona.getName());
        values.put("INIT", carona.getInit());
        values.put("DESTINY", carona.getDestiny());
        values.put("NEXTTO", carona.getNextTo());
        values.put("NUMBER", carona.getNumber());

        String[] codigo = new String[1];
        codigo[0] = String.valueOf(carona.getCodigo());

        //atualiza os valores do db
        db.update("RIDE", values, "CODIGO = ?", codigo);
    }

    public List<Carona> searchAll(){
        List<Carona> caronas = new ArrayList<Carona>();

        StringBuilder sql = new StringBuilder();
        sql.append("  SELECT CODIGO, NAME, INIT, DESTINY, NEXTTO, NUMBER");
        sql.append("  FROM RIDE");

        Cursor result = db.rawQuery(sql.toString(), null);

        if(result.getCount() > 0) {
            result.moveToFirst();

            do {
                Carona ride = new Carona();
                ride.setCodigo(result.getInt(result.getColumnIndexOrThrow("CODIGO")));
                ride.setName(result.getString(result.getColumnIndexOrThrow("NAME")));
                ride.setInit(result.getString(result.getColumnIndexOrThrow("INIT")));
                ride.setDestiny(result.getString(result.getColumnIndexOrThrow("DESTINY")));
                ride.setNextTo(result.getString(result.getColumnIndexOrThrow("NEXTTO")));
                ride.setNumber(result.getString(result.getColumnIndexOrThrow("NUMBER")));
                caronas.add(ride);
            } while (result.moveToNext());
        }

        return caronas;
    }

    public Carona search(int codigo){
        Carona ride = new Carona();
        StringBuilder sql = new StringBuilder();

        sql.append("  SELECT CODIGO, NAME, INIT, DESTINY, NEXTTO, NUMBER");
        sql.append("  FROM RIDE");
        sql.append("WHERE CODIGO = ?");

        String[] codigos = new String[1];
        codigos[0] = String.valueOf(codigo);

        Cursor result = db.rawQuery(sql.toString(), codigos);

        if(result.getCount()> 0) {
            ride.setCodigo(result.getInt(result.getColumnIndexOrThrow("CODIGO")));
            ride.setName(result.getString(result.getColumnIndexOrThrow("NAME")));
            ride.setInit(result.getString(result.getColumnIndexOrThrow("INIT")));
            ride.setDestiny(result.getString(result.getColumnIndexOrThrow("DESTINY")));
            ride.setNextTo(result.getString(result.getColumnIndexOrThrow("NEXTTO")));
            ride.setNumber(result.getString(result.getColumnIndexOrThrow("NUMBER")));
            return ride;
        }

        return null;
    }
}
