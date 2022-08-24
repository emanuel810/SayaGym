package com.example.saiya_gym.Activities.Inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.saiya_gym.R;

public class InicioActivity extends AppCompatActivity {

    ProgressBar splashProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        splashProgress=findViewById(R.id.splashProgress);
        ObjectAnimator.ofInt(splashProgress,"progress",100).setDuration(5000).start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(InicioActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}