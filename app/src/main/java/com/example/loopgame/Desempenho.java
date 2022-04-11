package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Desempenho extends AppCompatActivity {

    Button btnVoltarHome_Desempenho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desempenho);

        btnVoltarHome_Desempenho = findViewById(R.id.BtnVoltarHome_Desempenho);
        btnVoltarHome_Desempenho.setOnClickListener(view -> {
            Intent nivel = new Intent(getApplicationContext(), Home.class);
            startActivity(nivel);
        });
    }
}