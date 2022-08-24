package com.example.saiya_gym.Activities.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.saiya_gym.Activities.Inicio.Entrenadores.Entrenadores;
import com.example.saiya_gym.Activities.Inicio.TallasIniciales.TallasI;

import java.util.ArrayList;
import java.util.List;

public class BDentrenadores extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="developers3.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_ENTRENADORES = "CREATE TABLE ENTRENADORES(USUARIO TEXT PRIMARY KEY,ENTRENADORES TEXT,LUNES TEXT,MARTES TEXT, MIERCOLES TEXT, JUEVES TEXT, VIERNES TEXT)";


    public BDentrenadores(Context context){super(context,NOMBRE_BD,null,VERSION_BD);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_ENTRENADORES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  "+TABLA_ENTRENADORES);
        sqLiteDatabase.execSQL(TABLA_ENTRENADORES);
    }

    public void agregarEntrenadores(String usuario,String entrenador, String lunes,String martes,String miercoles,String jueves, String viernes) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("INSERT INTO ENTRENADORES VALUES('" + usuario + "','" + entrenador + "','" + lunes + "','" + martes + "','" + miercoles + "','" + jueves + "','" + viernes + "')");
            bd.close();
        }
    }

    public void buscarEntrenadores(Entrenadores entrenadores, String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM ENTRENADORES WHERE USUARIO='"+usuario+"'", null);
        if(cursor.moveToFirst()){
            do {
                entrenadores.setEntrenadoresE(cursor.getString(1));
                entrenadores.setLunes(cursor.getString(2));
                entrenadores.setMartes(cursor.getString(3));
                entrenadores.setMiercoles(cursor.getString(4));
                entrenadores.setJueves(cursor.getString(5));
                entrenadores.setViernes(cursor.getString(6));
            }while (cursor.moveToNext());
        }
    }


    public List<TallasI> mostrarEntrenadores(String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM ENTRENADORES WHERE USUARIO='"+usuario+"'", null);
        List<TallasI> cursoList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                cursoList.add(new TallasI(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
            }while (cursor.moveToNext());
        }
        return cursoList;
    }

    public boolean verificarEntrenador(String usuario){
        SQLiteDatabase bd = getWritableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM ENTRENADORES WHERE USUARIO='"+usuario+"'", null);
        if(cursor.moveToFirst()){
            return true;
        }while (cursor.moveToNext());
        return false;
    }

    public void eliminarentrenadores(String codigo){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("DELETE FROM ENTRENADORES WHERE USUARIO='"+codigo+"'");
            bd.close();
        }
    }

}
