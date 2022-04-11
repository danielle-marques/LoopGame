package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BemVindo extends AppCompatActivity {

    Button btnIniciarTeste_BemVindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bem_vindo);

        btnIniciarTeste_BemVindo = findViewById(R.id.BtnIniciarTeste_BemVindo);
        btnIniciarTeste_BemVindo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent iniciarteste = new Intent(getApplicationContext(), TesteNivel.class);
                startActivity(iniciarteste);
            }
        });
    }
}