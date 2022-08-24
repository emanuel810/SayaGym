package com.example.saiya_gym.Activities.Inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saiya_gym.Activities.Principal.PrincipalActivity;
import com.example.saiya_gym.Activities.SQLite.BDtallasFinales;
import com.example.saiya_gym.Activities.SQLite.BDtallasIniciales;
import com.example.saiya_gym.R;

public class TallasActivity extends AppCompatActivity {
    Intent intent;
    String usuario;
    TextView ejemplo;
    Button btnRegistrar;
    TextView hombrosI,pechoI,espaldaI,brazosI,abdomenI,piernaI,hombrosF,pechoF,espaldaF,brazosF,abdomenF,piernaF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tallas);
        intent =getIntent();
        usuario=intent.getStringExtra("llave");
        ejemplo=(TextView) findViewById(R.id.usuarioTextView);
        ejemplo.setText(usuario);

        hombrosI=(TextView) findViewById(R.id.hombrosInicial);
        pechoI=(TextView) findViewById(R.id.pechoInicial);
        pechoI=(TextView) findViewById(R.id.espaldaInicial);
        espaldaI=(TextView) findViewById(R.id.hombrosInicial);
        brazosI=(TextView) findViewById(R.id.brazosInicial);
        abdomenI=(TextView) findViewById(R.id.abdomenInicial);
        piernaI=(TextView) findViewById(R.id.piernaInicial);
        hombrosF=(TextView) findViewById(R.id.hombrosFinal);
        pechoF=(TextView) findViewById(R.id.pechoFinal);
        espaldaF=(TextView) findViewById(R.id.espaldaFinal);
        brazosF=(TextView) findViewById(R.id.brazosFinal);
        abdomenF=(TextView) findViewById(R.id.abdomenFinal);
        piernaF=(TextView) findViewById(R.id.piernaFinal);

        btnRegistrar=(Button) findViewById(R.id.btnRegistrarTallas);

        final BDtallasIniciales bDtallasIniciales = new BDtallasIniciales(getApplicationContext());
        final BDtallasFinales bDtallasFinales = new BDtallasFinales(getApplicationContext());

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hombrosinicial = hombrosI.getText().toString();
                String pechoInicial = pechoI.getText().toString();
                String espaldaInicial = espaldaI.getText().toString();
                String brazosInicial = brazosI.getText().toString();
                String abdomenInicial = abdomenI.getText().toString();
                String piernaInicial = piernaI.getText().toString();

                String hombrosFinal=hombrosF.getText().toString();
                String pechoFinal = pechoF.getText().toString();
                String espaldaFinal = espaldaF.getText().toString();
                String brazosFinal= brazosF.getText().toString();
                String abdomenFinal = abdomenF.getText().toString();
                String piernaFinal = abdomenF.getText().toString();

                if(hombrosinicial.isEmpty()){
                    hombrosI.setError("Campo Requerido");
                }else if(pechoInicial.isEmpty()){
                    pechoI.setError("Campo Requerido");
                }else if(espaldaInicial.isEmpty()){
                    espaldaI.setError("Campo Requerido");
                }else if(brazosInicial.isEmpty()){
                    brazosI.setError("Campo Requerido");
                }else if(abdomenInicial.isEmpty()){
                    abdomenI.setError("Campo Requerido");
                }else if(piernaInicial.isEmpty()){
                    piernaI.setError("Campo Requerido");
                }else if(hombrosFinal.isEmpty()){
                    hombrosF.setError("Campo Requerido");
                }else if(pechoInicial.isEmpty()){
                    pechoI.setError("Campo Requerido");
                }else if(espaldaFinal.isEmpty()){
                    espaldaF.setError("Campo Requerido");
                }else if(brazosFinal.isEmpty()){
                    brazosF.setError("Campo Requerido");
                }else if(abdomenFinal.isEmpty()){
                    abdomenF.setError("Campo Requerido");
                }else if(piernaFinal.isEmpty()){
                    piernaF.setError("Campo Requerido");
                }else{
                    //bDtallasIniciales.agregarTallasIniciales(usuario,hombrosinicial,pechoInicial,espaldaInicial,brazosInicial,abdomenInicial,piernaInicial);
                    bDtallasFinales.agregarTallasFinales(usuario,hombrosFinal,pechoFinal,espaldaFinal,brazosFinal,abdomenFinal,piernaFinal);
                    Toast.makeText(getApplicationContext(), "Se agrego correctamente", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(TallasActivity.this, PrincipalActivity.class);
                    i.putExtra("llave",usuario);
                    startActivity(i);
                    finish();

                }


            }
        });


    }
}