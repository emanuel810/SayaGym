package com.example.saiya_gym.Activities.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.saiya_gym.Activities.Inicio.TallasFinales.TallasF;
import com.example.saiya_gym.Activities.Inicio.TallasIniciales.TallasI;
import com.example.saiya_gym.Activities.Inicio.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;


public class BDtallasFinales extends SQLiteOpenHelper {


    private static final String NOMBRE_BD="developers2.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_TALLASFINALES = "CREATE TABLE TALLASFINALES(USUARIO TEXT PRIMARY KEY,HOMBROS TEXT,PECHO TEXT,ESPALDA TEXT, BRAZOS TEXT, ABDOMEN TEXT, PIERNA TEXT)";


    public BDtallasFinales(Context context){
        super(context,NOMBRE_BD,null,VERSION_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_TALLASFINALES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_TALLASFINALES);
        sqLiteDatabase.execSQL(TABLA_TALLASFINALES);
    }

    public void agregarTallasFinales(String usuario,String hombros, String pecho,String espalda,String brazos,String abdomen, String pierna) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("INSERT INTO TALLASFINALES VALUES('" + usuario + "','" + hombros + "','" + pecho + "','" + espalda + "','" + brazos + "','" + abdomen + "','" + pierna + "')");
            bd.close();
        }
    }

    public void buscarTallasFinales(TallasF tallasFinales, String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM TALLASFINALES WHERE USUARIO='"+usuario+"'", null);
        if(cursor.moveToFirst()){
            do {
                tallasFinales.setHombros(cursor.getString(1));
                tallasFinales.setPecho(cursor.getString(2));
                tallasFinales.setEspalda(cursor.getString(3));
                tallasFinales.setBrazos(cursor.getString(4));
                tallasFinales.setAbdomen(cursor.getString(5));
                tallasFinales.setPierna(cursor.getString(6));
            }while (cursor.moveToNext());
        }
    }


    public void editarTallasFinales(String usuario,String hombros, String pecho,String espalda,String brazos,String abdomen, String pierna) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("UPDATE TALLASFINALES SET USUARIO='" + usuario + "',HOMBROS='" + hombros + "',PECHO='" + pecho + "',ESPALDA='" + espalda + "',BRAZOS='" + brazos + "',ABDOMEN='" + abdomen + "',PIERNA='" + pierna + "' WHERE USUARIO='"+usuario+"'");
            bd.close();
        }
    }


    public List<TallasF> mostrarTallasFinales(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM TALLASFINALES", null);
        List<TallasF> cursoList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                cursoList.add(new TallasF(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
            }while (cursor.moveToNext());
        }
        return cursoList;
    }


    public void eliminarTallasFinales(String codigo){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("DELETE FROM TALLASFINALES WHERE USUARIO='"+codigo+"'");
            bd.close();
        }
    }

}
