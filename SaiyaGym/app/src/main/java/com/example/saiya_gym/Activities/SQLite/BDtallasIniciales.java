package com.example.saiya_gym.Activities.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.saiya_gym.Activities.Inicio.TallasFinales.TallasF;
import com.example.saiya_gym.Activities.Inicio.TallasIniciales.TallasI;

import java.util.ArrayList;
import java.util.List;

public class BDtallasIniciales extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="devererss.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_TALLASINICIALES = "CREATE TABLE TALLASINICIALES(USUARIO TEXT PRIMARY KEY,HOMBROS TEXT,PECHO TEXT,ESPALDA TEXT, BRAZOS TEXT, ABDOMEN TEXT, PIERNA TEXT)";


    public BDtallasIniciales(Context context){
        super(context,NOMBRE_BD,null,VERSION_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_TALLASINICIALES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLA_TALLASINICIALES);
        sqLiteDatabase.execSQL(TABLA_TALLASINICIALES);
    }

    public void agregarTallasIniciales(String usuario,String hombros, String pecho,String espalda,String brazos,String abdomen, String pierna) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("INSERT INTO TALLASINICIALES VALUES('" + usuario + "','" + hombros + "','" + pecho + "','" + espalda + "','" + brazos + "','" + abdomen + "','" + pierna + "')");
            bd.close();
        }
    }

    public void buscarTallasIniciales(TallasI tallasIniciales, String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM TALLASINICIALES WHERE USUARIO='"+usuario+"'", null);
        if(cursor.moveToFirst()){
            do {
                tallasIniciales.setHombros(cursor.getString(1));
                tallasIniciales.setPecho(cursor.getString(2));
                tallasIniciales.setEspalda(cursor.getString(3));
                tallasIniciales.setBrazos(cursor.getString(4));
                tallasIniciales.setAbdomen(cursor.getString(5));
                tallasIniciales.setPierna(cursor.getString(6));
            }while (cursor.moveToNext());
        }
    }


    public void editarTallasIniciales(String usuario,String hombros, String pecho,String espalda,String brazos,String abdomen, String pierna) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("UPDATE TALLASINICIALES SET USUARIO='" + usuario + "',HOMBROS='" + hombros + "',PECHO='" + pecho + "',ESPALDA='" + espalda + "',BRAZOS='" + brazos + "',ABDOMEN='" + abdomen + "',PIERNA='" + pierna + "' WHERE USUARIO='"+usuario+"'");
            bd.close();
        }
    }

    public List<TallasI> mostrarTallas(String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM TALLASINICIALES WHERE USUARIO='"+usuario+"'", null);
        List<TallasI> cursoList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                cursoList.add(new TallasI(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
            }while (cursor.moveToNext());
        }
        return cursoList;
    }



    public void eliminarTallasIniciales(String codigo){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("DELETE FROM TALLASINICIALES WHERE USUARIO='"+codigo+"'");
            bd.close();
        }
    }


}
