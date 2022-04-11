package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loopgame.database.BancoSQLite;
import com.example.loopgame.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    Button btnCadastro_Login, btnEsqueciASenha_Login, btnLoginParaBemVindo_Login;
    CheckBox chkVerSenha_Login;
    EditText edtNomeUsuario_Login, edtSenha_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtSenha_Login = findViewById(R.id.EdtSenha_Login);
        edtNomeUsuario_Login = findViewById(R.id.EdtNomeUsuario_Login);


        btnCadastro_Login = findViewById(R.id.BtnCadastro_Login);
        btnCadastro_Login.setOnClickListener(view -> {
            Intent iniciarcadastro = new Intent(getApplicationContext(), Cadastro.class);
            startActivity(iniciarcadastro);
        });

        btnEsqueciASenha_Login = findViewById(R.id.BtnEsqueciASenha_Login);
        btnEsqueciASenha_Login.setOnClickListener(view -> {
            Intent esquecisenha = new Intent(getApplicationContext(), EsqueciSenha.class);
            startActivity(esquecisenha);
        });

        btnLoginParaBemVindo_Login = findViewById(R.id.BtnLoginParaBemVindo_Login);
        btnLoginParaBemVindo_Login.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);
            try{
                Usuario usuario = db.selecionarUsuario(edtNomeUsuario_Login.getText().toString());
                if(usuario.getSenha().equals(edtSenha_Login.getText().toString())){
                    Intent logar = new Intent(getApplicationContext(), BemVindo.class);
                    startActivity(logar);
                }
                else
                    Toast.makeText(this, "Usuário não cadastrado", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(this, "Usuário não cadastrado", Toast.LENGTH_SHORT).show();
            }

        });
        chkVerSenha_Login = findViewById(R.id.ChkVerSenha_Login);
        edtSenha_Login.setVisibility(View.VISIBLE);

        chkVerSenha_Login.setOnClickListener(view -> {
            if(chkVerSenha_Login.isChecked()){
                edtSenha_Login.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else
                edtSenha_Login.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        });


    }


}