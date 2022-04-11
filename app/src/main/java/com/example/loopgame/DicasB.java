package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DicasB extends AppCompatActivity {
    Button btnIniciarJogo_DicasB;
    ImageButton btnImgRetornarParaHome_DicasB;
    TextView txtDicasDoNivel_DicasB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicas_b);

        btnImgRetornarParaHome_DicasB = findViewById(R.id.BtnImgRetornarParaHome_DicasB);
        btnImgRetornarParaHome_DicasB.setOnClickListener(view -> {
            Intent dicasparahome = new Intent(getApplicationContext(), Home.class);
            startActivity(dicasparahome);
        });
        btnIniciarJogo_DicasB = findViewById(R.id.BtnIniciarJogo_DicasB);
        btnIniciarJogo_DicasB.setOnClickListener(view -> {
            Intent iniciarjogo = new Intent(getApplicationContext(), TelaDoJogoB.class);
            startActivity(iniciarjogo);
        });
        txtDicasDoNivel_DicasB = findViewById(R.id.TxtDicasDoNivel_DicasB);
    }
}