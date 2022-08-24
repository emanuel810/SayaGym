package com.example.saiya_gym.Activities.Inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.saiya_gym.R;

public class ActivityIntegrantes extends AppCompatActivity implements View.OnClickListener {
    Button regresarLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integrantes);
        regresarLogin = findViewById(R.id.buttonRegresarLogin);
        regresarLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(ActivityIntegrantes.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

}