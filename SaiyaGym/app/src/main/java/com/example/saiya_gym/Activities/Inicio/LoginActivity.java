package com.example.saiya_gym.Activities.Inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.DashboardFragment;
import com.example.saiya_gym.Activities.Principal.PrincipalActivity;
import com.example.saiya_gym.Activities.SQLite.BDtallasFinales;
import com.example.saiya_gym.Activities.SQLite.BDusuario;
import com.example.saiya_gym.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnlogin;
    private ImageButton btnIntregantes;
    private TextView tvIrRegistro;
    private EditText etUsuario, etContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnlogin = findViewById(R.id.button_login);
        tvIrRegistro = findViewById(R.id.textViewRegistro);
        btnIntregantes = findViewById(R.id.imageButtonIntegrantes);
        etUsuario = findViewById(R.id.editTextUsuario);
        etContraseña = findViewById(R.id.editTextContraseña);
        final BDtallasFinales developersBD = new BDtallasFinales(getApplicationContext());

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String contraseña = etContraseña.getText().toString();

                if(usuario.isEmpty()){
                    etUsuario.setError("Nombre del usuario requerido");
                }else if(contraseña.isEmpty()){
                    etContraseña.setError("Contraseña Requerida");
                }
                else{
                    final BDusuario bDusuario = new BDusuario(getApplicationContext());

                    if(bDusuario.verificarUsuario(usuario,contraseña)){
                        Bundle bundle = new Bundle();
                        Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                        //envio el dato al activity principal
                        String titulo = etUsuario.getText().toString();
                        intent.putExtra("llave",titulo);

                        startActivity(intent);
                        finish();
                    }else {
                        etUsuario.setError("Usuario Invalido");
                    }

                }
            }
        });
        tvIrRegistro.setOnClickListener(this);
        btnIntregantes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.button_login:
                ir_paginaPrincipal();
                break;
            case R.id.textViewRegistro:
                ir_Regisro();
                break;
            case R.id.imageButtonIntegrantes:
                ir_Integrante();
                break;
        }
    }

    private void ir_paginaPrincipal() {

    }

    private void ir_Integrante() {
        Intent i = new Intent(LoginActivity.this, ActivityIntegrantes.class);
        startActivity(i);
    }

    private void ir_Regisro() {
        Intent i = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivity(i);
    }
}