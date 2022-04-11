package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DicasC extends AppCompatActivity {

    Button btnIniciarJogo_DicasC;
    ImageButton btnImgRetornarParaHome_DicasC;
    TextView txtDicasDoNivel_DicasC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicas_c);

        btnImgRetornarParaHome_DicasC = findViewById(R.id.BtnImgRetornarParaHome_DicasC);
        btnImgRetornarParaHome_DicasC.setOnClickListener(view -> {
            Intent dicasparahome = new Intent(getApplicationContext(), Home.class);
            startActivity(dicasparahome);
        });
        btnIniciarJogo_DicasC = findViewById(R.id.BtnIniciarJogo_DicasC);
        btnIniciarJogo_DicasC.setOnClickListener(view -> {
            Intent iniciarjogo = new Intent(getApplicationContext(), TelaDoJogoC.class);
            startActivity(iniciarjogo);
        });
        txtDicasDoNivel_DicasC = findViewById(R.id.TxtDicasDoNivel_DicasC);
    }
}