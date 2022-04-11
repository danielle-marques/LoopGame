package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.loopgame.Home;
import com.example.loopgame.R;

public class Conclusao extends AppCompatActivity {
    
    ImageButton btnImgRetornarParaHome_Conclusao;
    Button btnInciarTeste_Conclusao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusao);
        
        btnImgRetornarParaHome_Conclusao = findViewById(R.id.BtnImgRetornarParaHome_Conclusao);
        btnImgRetornarParaHome_Conclusao.setOnClickListener(view -> {
            Intent voltarhome = new Intent(getApplicationContext(), Home.class);
            startActivity(voltarhome);
        });

        btnInciarTeste_Conclusao = findViewById(R.id.BtnInciarTeste_Conclusao);
        btnInciarTeste_Conclusao.setOnClickListener(view -> {
            Intent testefinal = new Intent(getApplicationContext(), TesteNivelFinal.class);
            startActivity(testefinal);
        });
        
    }
}