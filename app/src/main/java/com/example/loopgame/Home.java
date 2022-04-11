package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;


public class Home extends AppCompatActivity {

    ImageButton btnImgDeslogar_Home;
    Button btnIniciarJogo_Home, btnDicas_Home;
    TextView txtDicas_Home, txtPrimeiroJogador_Home, txtSegundoJogador_Home, txtTerceiroJogador_Home, txtQuartoJogador_Home, txtQuintoJogador_Home;
    ScrollView scrollRanking_Home;

    String[] arrayTexto = {"PRIMEIRA GERAÇÃO: Linguagem máquina", "SEGUNDA GERAÇÃO: Criaram-se as primeiras linguagens assembler", "TERCEIRA GERAÇÃO: Criam-se as primeiras linguagens de alto nível.", "QUARTA GERAÇÃO: São linguagens capazes de gerar código por si só.", "QUINTA GERAÇÃO: Encontram-se as linguagens orientadas à inteligência artificial.", "Dica 6", "Dica 7", "Dica 8"};
    int indice = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        scrollRanking_Home = findViewById(R.id.ScrollRanking_Home);
        txtPrimeiroJogador_Home = findViewById(R.id.TxtPrimeiroJogador_Home);
        txtSegundoJogador_Home = findViewById(R.id.TxtSegundoJogador_Home);
        txtTerceiroJogador_Home = findViewById(R.id.TxtTerceiroJogador_Home);
        txtQuartoJogador_Home = findViewById(R.id.TxtQuartoJogador_Home);
        txtQuintoJogador_Home = findViewById(R.id.TxtQuintoJogador_Home);

        btnDicas_Home = findViewById(R.id.BtnDicas_Home);
        btnDicas_Home.setOnClickListener(view -> {

            Texto();

        });


        btnImgDeslogar_Home = findViewById(R.id.BtnImgDeslogar_Home);
        btnImgDeslogar_Home.setOnClickListener(view -> {
            Intent sairdahome = new Intent(getApplicationContext(), Deslogar.class);
            startActivity(sairdahome);
        });
        btnIniciarJogo_Home = findViewById(R.id.BtnIniciarJogo_Home);
        btnIniciarJogo_Home.setOnClickListener(view -> {
            Intent jogardahome = new Intent(getApplicationContext(), Dicas.class);
            startActivity(jogardahome);
        });



    }


    private void Texto() {
        if(indice < 8){
            indice = indice +1;
            Log.d("indice", String.valueOf(indice));
        }
        txtDicas_Home = findViewById(R.id.TxtDicas_Home);
        txtDicas_Home.setText(arrayTexto[indice]);



    }


}