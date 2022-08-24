package com.example.saiya_gym.Activities.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.saiya_gym.Activities.Inicio.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;


public class BDusuario extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="developers.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_USUARIOS = "CREATE TABLE USUARIO(USUARIO TEXT PRIMARY KEY,CONTRASEÑA TEXT,NOMBRE TEXT,EDAD TEXT, PESOI TEXT, PESOF TEXT)";

    public BDusuario(Context context){
        super(context,NOMBRE_BD,null,VERSION_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_USUARIOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLA_USUARIOS);
        sqLiteDatabase.execSQL(TABLA_USUARIOS);
    }

    public void agregarUsuario(String usuario,String contraseña, String nombre,String edad,String pesoI, String pesoF) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("INSERT INTO USUARIO VALUES('" + usuario + "','" + contraseña + "','" + nombre + "','" + edad + "','" + pesoI + "','" + pesoF + "')");
            bd.close();
        }
    }

    public void buscarUsuario(Usuario usuarioPerfil, String usuario){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM USUARIO WHERE USUARIO='"+usuario+"'", null);
        if(cursor.moveToFirst()){
            do {
                usuarioPerfil.setContraseña(cursor.getString(1));
                usuarioPerfil.setNombre(cursor.getString(2));
                usuarioPerfil.setEdad(cursor.getString(3));
                usuarioPerfil.setPesoInicial(cursor.getString(4));
                usuarioPerfil.setPesoFinal(cursor.getString(5));
            }while (cursor.moveToNext());
        }
    }



    public void editarUsuario(String usuario,String contraseña, String nombre,String edad,String pesoI, String pesoF){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("UPDATE  USUARIO SET USUARIO='"+usuario+"',CONTRASEÑA='"+contraseña+"',NOMBRE='"+nombre+"',EDAD='"+edad+"',PESOI='"+pesoI+"',PESOF='"+pesoF+"' WHERE USUARIO='"+usuario+"'");
            bd.close();
        }
    }

    public boolean verificarUsuario(String usuario,String contraseña){
        SQLiteDatabase bd = getWritableDatabase();
        Cursor cursor =bd.rawQuery("SELECT * FROM USUARIO WHERE USUARIO='"+usuario+"'AND CONTRASEÑA='"+contraseña+"'", null);
        if(cursor.moveToFirst()){
            return true;
        }while (cursor.moveToNext());
        return false;
    }

    public void eliminarUsuario(String codigo){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("DELETE FROM USUARIO WHERE USUARIO='"+codigo+"'");
            bd.close();
        }
    }


}
