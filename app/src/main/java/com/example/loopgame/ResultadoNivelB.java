package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class ResultadoNivelB extends AppCompatActivity {

    ImageButton btnImgRetornarParaHome_ResultadoNivelB;
    Button btnContinuarJogando_ResultadoNivelB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_nivel_b);

        btnImgRetornarParaHome_ResultadoNivelB = findViewById(R.id.BtnImgRetornarParaHome_ResultadoNivelB);

        btnImgRetornarParaHome_ResultadoNivelB.setOnClickListener(view -> {
            Intent voltarhome = new Intent(getApplicationContext(), Home.class);
            startActivity(voltarhome);
        });

        btnContinuarJogando_ResultadoNivelB = findViewById(R.id.BtnContinuarJogando_ResultadoNivelB);

        btnContinuarJogando_ResultadoNivelB.setOnClickListener(view -> {
            Intent continuarb = new Intent(getApplicationContext(), DicasB.class);
            startActivity(continuarb);
        });
    }
}