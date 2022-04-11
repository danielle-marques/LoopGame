package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.loopgame.database.BancoSQLite;
import com.example.loopgame.modelos.Usuario;

public class Cadastro extends AppCompatActivity {

    ImageButton btnImgVoltarLogin_Cadastro, btnImgCriarConta_Cadastro;
    EditText edtNomeUsuario_Cadastro, edtSenha_Cadastro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnImgVoltarLogin_Cadastro = findViewById(R.id.BtnImgVoltarLogin_Cadastro);

        btnImgVoltarLogin_Cadastro.setOnClickListener(view -> {
            Intent voltarcadastro = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(voltarcadastro);
        });
        btnImgCriarConta_Cadastro = findViewById(R.id.BtnImgCriarConta_Cadastro);

        btnImgCriarConta_Cadastro.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);

            if(db.inserirUsuario(new Usuario(
                    edtNomeUsuario_Cadastro.getText().toString(),
                    edtSenha_Cadastro.getText().toString()))
            ) {
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                Intent cadastrar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(cadastrar);

            } else {
                Toast.makeText(this, "Não foi possivel realizar o cadastro!", Toast.LENGTH_LONG).show();
            }

        });


        edtNomeUsuario_Cadastro = findViewById(R.id.EdtNomeUsuario_Cadastro);
        edtSenha_Cadastro = findViewById(R.id.EdtSenha_Cadastro);




    }
}