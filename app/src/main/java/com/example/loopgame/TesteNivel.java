package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TesteNivel extends AppCompatActivity {

    ImageButton btnImgResultadoTesteNivel_ProvaNivel;
    RadioButton rBtnPrimeiraAlternativa_ProvaNivel, rBtnSegundaAlternativa_ProvaNivel, rBtnTerceiraAlternativa_ProvaNivel, rBtnQuartaAlternativa_ProvaNivel, rBtnQuintaAlternativa_ProvaNivel;
    RadioGroup rGRespostas_ProvaNivel;
    TextView txtEnunciadoQuestao_ProvaNivel;

    int respostaCerta = R.id.RBtnSegundaAlternativa_ProvaNivel;

    List<Questao> questoes = new ArrayList<Questao>(){
        {
            add(new Questao("A cidade de Florianópolis foi fundada no dia 23/03/1726, que caiu em um sábado. Após 90 dias, no dia 21 de junho, a data assinalou o início do inverno. Esse dia caiu em uma:", R.id.RBtnQuintaAlternativa_ProvaNivel, "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira"));
            add(new Questao("Sabendo que é verdadeira a afirmação 'Todos os alunos de Fulano foram aprovados no concurso', então é necessariamente verdade:", R.id.RBtnQuartaAlternativa_ProvaNivel, " Fulano não foi aprovado no concurso.", "Se Roberto não é aluno de Fulano, então ele não foi aprovado no concurso.", "Fulano foi aprovado no concurso.", "Se Carlos não foi aprovado no concurso, então ele não é aluno de Fulano.", "Se Elvis foi aprovado no concurso, então ele é aluno de Fulano."));
            add(new Questao("Considere a afirmação: “Se hoje é sábado, amanhã não trabalharei.” A negação dessa afirmação é:", R.id.RBtnPrimeiraAlternativa_ProvaNivel, "Hoje é sábado e amanhã trabalharei.", "Hoje não é sábado e amanhã trabalharei.", "Hoje não é sábado ou amanhã trabalharei.", "Se hoje não é sábado, amanhã trabalharei.", "Se hoje não é sábado, amanhã não trabalharei."));

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_nivel);

        btnImgResultadoTesteNivel_ProvaNivel = findViewById(R.id.BtnImgResultadoTesteNivel_ProvaNivel);
        rBtnPrimeiraAlternativa_ProvaNivel = findViewById(R.id.RBtnPrimeiraAlternativa_ProvaNivel);
        rBtnSegundaAlternativa_ProvaNivel = findViewById(R.id.RBtnSegundaAlternativa_ProvaNivel);
        rBtnTerceiraAlternativa_ProvaNivel = findViewById(R.id.RBtnTerceiraAlternativa_ProvaNivel);
        rBtnQuartaAlternativa_ProvaNivel = findViewById(R.id.RBtnQuartaAlternativa_ProvaNivel);
        rBtnQuintaAlternativa_ProvaNivel = findViewById(R.id.RBtnQuintaAlternativa_ProvaNivel);
        txtEnunciadoQuestao_ProvaNivel = findViewById(R.id.TxtEnunciadoQuestao_ProvaNivel);
        rGRespostas_ProvaNivel = findViewById(R.id.RGRespostas_ProvaNivel);

        btnImgResultadoTesteNivel_ProvaNivel.setOnClickListener(view -> {

            if(rGRespostas_ProvaNivel.getCheckedRadioButtonId() == respostaCerta){
                Toast.makeText(this, "Acertou!", Toast.LENGTH_SHORT).show();

            }
            else{

                Toast.makeText(this, "Errou!", Toast.LENGTH_SHORT).show();
            }

            carregarQuestao();

        });


    }


    private void carregarQuestao(){
        if(questoes.size() > 0) {
            Questao q = questoes.remove(0);
            txtEnunciadoQuestao_ProvaNivel.setText(q.getPergunta());
            List<String> resposta = q.getRespostas();
            rBtnPrimeiraAlternativa_ProvaNivel.setText(resposta.get(0));
            rBtnSegundaAlternativa_ProvaNivel.setText(resposta.get(1));
            rBtnTerceiraAlternativa_ProvaNivel.setText(resposta.get(2));
            rBtnQuartaAlternativa_ProvaNivel.setText(resposta.get(3));
            rBtnQuintaAlternativa_ProvaNivel.setText(resposta.get(4));
            respostaCerta = q.getRespostaCerta();
            rGRespostas_ProvaNivel.clearCheck();
        }
        else{finish();
            Intent nivel = new Intent(getApplicationContext(), ResultadoNivel.class);
            startActivity(nivel);


        }


    }





}