package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ResultadoNivel extends AppCompatActivity {

        Button btnContinuarJogando_ResultadoNivel;
        ImageButton btnImgRetornarParaHome_ResultadoNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_nivel);

        btnContinuarJogando_ResultadoNivel = findViewById(R.id.BtnContinuarJogando_ResultadoNivel);
        btnContinuarJogando_ResultadoNivel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent continuarjogo = new Intent(getApplicationContext(), Dicas.class);
                startActivity(continuarjogo);
            }
        });

        btnImgRetornarParaHome_ResultadoNivel = findViewById(R.id.BtnImgRetornarParaHome_ResultadoNivel);
        btnImgRetornarParaHome_ResultadoNivel.setOnClickListener(view -> {
            Intent voltarhome = new Intent(getApplicationContext(), Home.class);
            startActivity(voltarhome);
        });


    }
}