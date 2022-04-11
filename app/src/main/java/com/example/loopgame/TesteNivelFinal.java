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

public class TesteNivelFinal extends AppCompatActivity {

    ImageButton btnImgResultadoTesteNivel_ProvaNivelFinal;
    RadioButton rBtnPrimeiraAlternativa_ProvaNivelFinal, rBtnSegundaAlternativa_ProvaNivelFinal, rBtnTerceiraAlternativa_ProvaNivelFinal, rBtnQuartaAlternativa_ProvaNivelFinal, rBtnQuintaAlternativa_ProvaNivelFinal;
    RadioGroup rGRespostas_TesteNivelFinal;
    TextView txtEnunciadoQuestao_ProvaNivelFinal;

    int respostaCerta = R.id.RBtnSegundaAlternativa_ProvaNivelFinal;

    List<Questao> questoes = new ArrayList<Questao>(){
        {
            add(new Questao("A cidade de Florianópolis foi fundada no dia 23/03/1726, que caiu em um sábado. Após 90 dias, no dia 21 de junho, a data assinalou o início do inverno. Esse dia caiu em uma:", R.id.RBtnQuintaAlternativa_ProvaNivelFinal, "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira"));
            add(new Questao("Sabendo que é verdadeira a afirmação 'Todos os alunos de Fulano foram aprovados no concurso', então é necessariamente verdade:", R.id.RBtnQuartaAlternativa_ProvaNivelFinal, " Fulano não foi aprovado no concurso.", "Se Roberto não é aluno de Fulano, então ele não foi aprovado no concurso.", "Fulano foi aprovado no concurso.", "Se Carlos não foi aprovado no concurso, então ele não é aluno de Fulano.", "Se Elvis foi aprovado no concurso, então ele é aluno de Fulano."));
            add(new Questao("Considere a afirmação: “Se hoje é sábado, amanhã não trabalharei.” A negação dessa afirmação é:", R.id.RBtnPrimeiraAlternativa_ProvaNivelFinal, "Hoje é sábado e amanhã trabalharei.", "Hoje não é sábado e amanhã trabalharei.", "Hoje não é sábado ou amanhã trabalharei.", "Se hoje não é sábado, amanhã trabalharei.", "Se hoje não é sábado, amanhã não trabalharei."));

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_nivel_final);

        btnImgResultadoTesteNivel_ProvaNivelFinal = findViewById(R.id.BtnImgResultadoTesteNivel_ProvaNivelFinal);
        rBtnPrimeiraAlternativa_ProvaNivelFinal = findViewById(R.id.RBtnPrimeiraAlternativa_ProvaNivelFinal);
        rBtnSegundaAlternativa_ProvaNivelFinal = findViewById(R.id.RBtnSegundaAlternativa_ProvaNivelFinal);
        rBtnTerceiraAlternativa_ProvaNivelFinal = findViewById(R.id.RBtnTerceiraAlternativa_ProvaNivelFinal);
        rBtnQuartaAlternativa_ProvaNivelFinal = findViewById(R.id.RBtnQuartaAlternativa_ProvaNivelFinal);
        rBtnQuintaAlternativa_ProvaNivelFinal = findViewById(R.id.RBtnQuintaAlternativa_ProvaNivelFinal);
        txtEnunciadoQuestao_ProvaNivelFinal = findViewById(R.id.TxtEnunciadoQuestao_ProvaNivelFinal);
        rGRespostas_TesteNivelFinal = findViewById(R.id.RGRespostas_TesteNivelFinal);

        btnImgResultadoTesteNivel_ProvaNivelFinal.setOnClickListener(view -> {

            if(rGRespostas_TesteNivelFinal.getCheckedRadioButtonId() == respostaCerta){
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
            txtEnunciadoQuestao_ProvaNivelFinal.setText(q.getPergunta());
            List<String> resposta = q.getRespostas();
            rBtnPrimeiraAlternativa_ProvaNivelFinal.setText(resposta.get(0));
            rBtnSegundaAlternativa_ProvaNivelFinal.setText(resposta.get(1));
            rBtnTerceiraAlternativa_ProvaNivelFinal.setText(resposta.get(2));
            rBtnQuartaAlternativa_ProvaNivelFinal.setText(resposta.get(3));
            rBtnQuintaAlternativa_ProvaNivelFinal.setText(resposta.get(4));
            respostaCerta = q.getRespostaCerta();
            rGRespostas_TesteNivelFinal.clearCheck();
        }
        else{finish();
            Intent nivelfinal = new Intent(getApplicationContext(), Desempenho.class);
            startActivity(nivelfinal);


        }


    }

}