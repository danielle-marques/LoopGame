package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Deslogar extends AppCompatActivity {

    Button btnSairDoJogo_Deslogar;
    Button btnContinuarJogando_Deslogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deslogar);

        btnSairDoJogo_Deslogar = findViewById(R.id.BtnSairDoJogo_Deslogar);
        btnSairDoJogo_Deslogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent sairjogo = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(sairjogo);
            }
        });

        btnContinuarJogando_Deslogar = findViewById(R.id.BtnContinuarJogando_Deslogar);
        btnContinuarJogando_Deslogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent voltarjogo = new Intent(getApplicationContext(), Home.class);
                startActivity(voltarjogo);
            }
        });
    }
}