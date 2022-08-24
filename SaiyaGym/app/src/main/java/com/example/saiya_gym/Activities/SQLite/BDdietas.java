package com.example.saiya_gym.Activities.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.saiya_gym.Activities.Inicio.Entrenadores.Entrenadores;
import com.example.saiya_gym.Activities.Inicio.TallasIniciales.TallasI;

import java.util.ArrayList;
import java.util.List;

public class BDdietas extends SQLiteOpenHelper {


    private static final String NOMBRE_BD="developers4.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_ENTRENADORESDIETA = "CREATE TABLE ENTRENADORESDIETA(USUARIO TEXT PRIMARY KEY,ENTRENADORES TEXT,LUNES TEXT,MARTES TEXT, MIERCOLES TEXT, JUEVES TEXT, VIERNES TEXT)";


    public BDdietas(Context context){super(context,NOMBRE_BD,null,VERSION_BD);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_ENTRENADORESDIETA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  "+TABLA_ENTRENADORESDIETA);
        sqLiteDatabase.execSQL(TABLA_ENTRENADORESDIETA);
    }

    public void agregarEntrenadoresDieta(String usuario,String entrenador, String lunes,String martes,String miercoles,String jueves, String viernes) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("INSERT INTO ENTRENADORESDIETA VALUES('" + usuario + "','" + entrenador + "','" + lunes + "','" + martes + "','" + miercoles + "','" + jueves + "','" + viernes + "')");
            bd.close();
        }
    }


    public List<TallasI> mostrarDietas(String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM ENTRENADORESDIETA WHERE USUARIO='"+usuario+"'", null);
        List<TallasI> cursoList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                cursoList.add(new TallasI(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
            }while (cursor.moveToNext());
        }
        return cursoList;
    }


    public void buscarEntrenadoresDieta(Entrenadores entrenadores, String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM ENTRENADORESDIETA WHERE USUARIO='"+usuario+"'", null);
        if(cursor.moveToFirst()){
            do {
                entrenadores.setEntrenadoresE(cursor.getString(1));
                entrenadores.setLunesD(cursor.getString(2));
                entrenadores.setMartesD(cursor.getString(3));
                entrenadores.setMiercolesD(cursor.getString(4));
                entrenadores.setJuevesD(cursor.getString(5));
                entrenadores.setViernesD(cursor.getString(6));
            }while (cursor.moveToNext());
        }
    }

    public void eliminareEntrenadoresDieta(String codigo){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("DELETE FROM ENTRENADORESDIETA WHERE USUARIO='"+codigo+"'");
            bd.close();
        }
    }


}
