package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Dicas extends AppCompatActivity {

    Button btnIniciarJogo_Dicas;
    ImageButton btnImgRetornarParaHome_Dicas;
    TextView txtDicasDoNivel_Dicas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicas);

        btnImgRetornarParaHome_Dicas = findViewById(R.id.BtnImgRetornarParaHome_Dicas);
        btnImgRetornarParaHome_Dicas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent dicasparahome = new Intent(getApplicationContext(), Home.class);
                startActivity(dicasparahome);
            }
        });
        btnIniciarJogo_Dicas = findViewById(R.id.BtnIniciarJogo_Dicas);
        btnIniciarJogo_Dicas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent iniciarjogo = new Intent(getApplicationContext(), TelaDoJogo.class);
                startActivity(iniciarjogo);
            }
        });
        txtDicasDoNivel_Dicas = findViewById(R.id.TxtDicasDoNivel_Dicas);

    }
}