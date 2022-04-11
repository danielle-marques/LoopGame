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

public class EsqueciSenha extends AppCompatActivity {
    Button btnEnviarEmail_EsqueciSenha;
    ImageButton btnImgRetornarParaLogin_EsqueciSenha;
    EditText edtDigitarEmail_EsqueciSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);

        edtDigitarEmail_EsqueciSenha = findViewById(R.id.EdtDigitarEmail_EsqueciSenha);

        btnEnviarEmail_EsqueciSenha = findViewById(R.id.BtnEnviarEmail_EsqueciSenha);
        btnEnviarEmail_EsqueciSenha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context context = getApplicationContext();
                CharSequence text = "E-mail Enviado!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent enviaremail = new Intent(getApplicationContext(), AlterarSenha.class);
                startActivity(enviaremail);
            }
        });
        btnImgRetornarParaLogin_EsqueciSenha = findViewById(R.id.BtnImgRetornarParaLogin_EsqueciSenha);
        btnImgRetornarParaLogin_EsqueciSenha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent sairdoesquecisenha = new Intent(getApplicationContext(), Home.class);
                startActivity(sairdoesquecisenha);
            }
        });

    }
}