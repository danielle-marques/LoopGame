package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AlterarSenha extends AppCompatActivity {

    Button btnRedefinirSenha_AlterarSenha;
    ImageButton btnImgVoltarParaEsqueciSenha_AlterarSenha;
    EditText edtCodigoValidacao_AlterarSenha, edtNovaSenha_AlterarSenha, edtConfirmarNovaSenha_AlterarSenha;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_senha);

        edtCodigoValidacao_AlterarSenha = findViewById(R.id.EdtCodigoValidacao_AlterarSenha);
        edtNovaSenha_AlterarSenha = findViewById(R.id.EdtNovaSenha_AlterarSenha);
        edtConfirmarNovaSenha_AlterarSenha = findViewById(R.id.EdtConfirmarNovaSenha_AlterarSenha);

        btnRedefinirSenha_AlterarSenha = findViewById(R.id.BtnRedefinirSenha_AlterarSenha);
        btnRedefinirSenha_AlterarSenha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = getApplicationContext();
                CharSequence text = "Senha Redefinida!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Intent mudasenha = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mudasenha);
            }
        });
        btnImgVoltarParaEsqueciSenha_AlterarSenha = findViewById(R.id.BtnImgVoltarParaEsqueciSenha_AlterarSenha);
        btnImgVoltarParaEsqueciSenha_AlterarSenha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent voltaesquecisenha = new Intent(getApplicationContext(), EsqueciSenha.class);
                startActivity(voltaesquecisenha);
            }
        });
    }
}