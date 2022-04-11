package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class ResultadoNivelC extends AppCompatActivity {

    Button btnContinuarJogando_ResultadoNivelC;
    ImageButton btnImgRetornarParaHome_ResultadoNivelC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_nivel_c);


        btnContinuarJogando_ResultadoNivelC = findViewById(R.id.BtnContinuarJogando_ResultadoNivelC);
        btnContinuarJogando_ResultadoNivelC.setOnClickListener(view -> {
            Intent jogarc = new Intent(getApplicationContext(), DicasC.class);
            startActivity(jogarc);
        });

        btnImgRetornarParaHome_ResultadoNivelC = findViewById(R.id.BtnImgRetornarParaHome_ResultadoNivelC);
        btnImgRetornarParaHome_ResultadoNivelC.setOnClickListener(view -> {
            Intent voltarhome = new Intent(getApplicationContext(), Home.class);
            startActivity(voltarhome);
        });
    }
}