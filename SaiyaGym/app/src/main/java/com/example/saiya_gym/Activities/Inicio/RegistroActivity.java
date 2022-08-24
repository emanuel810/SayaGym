package com.example.saiya_gym.Activities.Inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saiya_gym.Activities.Principal.PrincipalActivity;
import com.example.saiya_gym.Activities.SQLite.BDusuario;
import com.example.saiya_gym.R;

public class RegistroActivity extends AppCompatActivity  {
    private Button btnRegistro;
    private TextView tvIrlogin;
    private EditText etnombre, etusuario,etcontraseña,etedad,etpesoInicial,etpesoMeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistro = findViewById(R.id.buttonRegistrarme);
        tvIrlogin = findViewById(R.id.textViewRegresar);

        etnombre = findViewById(R.id.editTextNombre);
        etusuario = findViewById(R.id.editTexUsers);
        etcontraseña = findViewById(R.id.editTextPassword);
        etedad = findViewById(R.id.editTextEdad);
        etpesoInicial = findViewById(R.id.editTextPesoInicial);
        etpesoMeta = findViewById(R.id.editTextPesoMeta);


        final BDusuario bDusuario = new BDusuario(getApplicationContext());


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etnombre.getText().toString();
                String usuario = etusuario.getText().toString();
                String contraseña = etcontraseña.getText().toString();
                String edad = etedad.getText().toString();
                String pesoInical = etpesoInicial.getText().toString();
                String pesoMeta = etpesoMeta.getText().toString();
                if(nombre.isEmpty()){
                    etnombre.setError("Nombre requerido");
                }else if(usuario.isEmpty()){
                    etusuario.setError("usuario requerido");
                } else if(contraseña.isEmpty()){
                    etcontraseña.setError("Contraseña requerida");
                }else if(edad.isEmpty()){
                    etedad.setError("Edad requerido");
                }else if(pesoInical.isEmpty()){
                    etedad.setError("Peso inicial requerido");
                }else if(pesoMeta.isEmpty()){
                    etedad.setError("Peso Meta  requerido");
                }else{
                    bDusuario.agregarUsuario(usuario,contraseña,nombre,edad,pesoInical,pesoMeta);
                    Toast.makeText(getApplicationContext(), "Se agrego correctamente", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(RegistroActivity.this, TallasActivity.class);
                    i.putExtra("llave",usuario);
                    startActivity(i);
                    finish();
                }
            }
        });
        tvIrlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }









}