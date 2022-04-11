package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaDoJogo extends AppCompatActivity {

    ImageButton btnImgRetornarParaHome_Jogo, btnImgProximaQuestao_Jogo;
    RadioButton rBtnPrimeiraAlternativa_Jogo, rBtnSegundaAlternativa_Jogo, rBtnTerceiraAlternativa_Jogo, rBtnQuartaAlternativa_Jogo, rBtnQuintaAlternativa_Jogo;
    RadioGroup rgRespostas_TelaJogo;
    TextView txtEnunciadoQuestao_Jogo, txtPontuacao_Jogo;
    ProgressBar pBTempo_Jogo;
    int respostaCerta = R.id.RBtnPrimeiraAlternativa_Jogo;
    int indice = 0;
    int pontos = 0;
    List<Questao> questoes = new ArrayList<Questao>(){
        {
            add(new Questao("Um ciclo de processamento é composto por quais sequências de etapas:", R.id.RBtnSegundaAlternativa_Jogo, "Entrada / Algoritmo / Saída.", "Entrada / Processamento / Saída.", "Entrada / Saída / Processamento.", "Algoritmo / Entrada / Saída.", "Entrada / Processamento / Algoritmo."));
            add(new Questao("Escolha a alternativa que NÃO contém um par respectivo de dado e informação:", R.id.RBtnTerceiraAlternativa_Jogo, " Notas de um aluno / Média escolar.", " Contas a pagar e a receber / Lucro da empresa.", " Ano de admissão do funcionário / Salário do funcionário.", " Saldo anterior, saques e depósitos / Saldo atualizado.", " Dias trabalhados e holerite / Salário do funcionário."));
            add(new Questao("Dadas as seguintes instruções, em qual ordem elas deveriam ser executadas em um algoritmo para tomar banho? I. Se secar II. Ligar o chuveiro III. Se enxaguar IV. Se ensaboar V. Desligar o chuveiro:", R.id.RBtnTerceiraAlternativa_Jogo, "I, II, III, IV, V.", "II, V, I, III, IV.", "II, IV, III, V, I.", "V, IV, III, II, I.", "II, I, III, IV, V."));

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_do_jogo);

        btnImgProximaQuestao_Jogo = findViewById(R.id.BtnImgProximaQuestao_Jogo);
        rBtnPrimeiraAlternativa_Jogo = findViewById(R.id.RBtnPrimeiraAlternativa_Jogo);
        rBtnSegundaAlternativa_Jogo = findViewById(R.id.RBtnSegundaAlternativa_Jogo);
        rBtnTerceiraAlternativa_Jogo = findViewById(R.id.RBtnTerceiraAlternativa_Jogo);
        rBtnQuartaAlternativa_Jogo = findViewById(R.id.RBtnQuartaAlternativa_Jogo);
        rBtnQuintaAlternativa_Jogo = findViewById(R.id.RBtnQuintaAlternativa_Jogo);
        txtEnunciadoQuestao_Jogo = findViewById(R.id.TxtEnunciadoQuestao_Jogo);
        rgRespostas_TelaJogo = findViewById(R.id.RgRespostas_TelaJogo);
        btnImgRetornarParaHome_Jogo = findViewById(R.id.BtnImgRetornarParaHome_Jogo);
        txtPontuacao_Jogo = findViewById(R.id.TxtPontuacao_Jogo);


        btnImgRetornarParaHome_Jogo.setOnClickListener(view -> {
            Intent retornarhome = new Intent(getApplicationContext(), Home.class);
            startActivity(retornarhome);

        });

        btnImgProximaQuestao_Jogo.setOnClickListener(view -> {

            if(rgRespostas_TelaJogo.getCheckedRadioButtonId() == respostaCerta){
                Toast.makeText(this, "Acertou! + 20 pontos", Toast.LENGTH_SHORT).show();
                String pontuacao = txtPontuacao_Jogo.getText().toString();
                int numero1 = Integer.parseInt(pontuacao);
                int pontos = numero1 + 20;
                txtPontuacao_Jogo.setText(String.valueOf(pontos));
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
                txtEnunciadoQuestao_Jogo.setText(q.getPergunta());
                List<String> resposta = q.getRespostas();
                rBtnPrimeiraAlternativa_Jogo.setText(resposta.get(0));
                rBtnSegundaAlternativa_Jogo.setText(resposta.get(1));
                rBtnTerceiraAlternativa_Jogo.setText(resposta.get(2));
                rBtnQuartaAlternativa_Jogo.setText(resposta.get(3));
                rBtnQuintaAlternativa_Jogo.setText(resposta.get(4));
                respostaCerta = q.getRespostaCerta();
                rgRespostas_TelaJogo.clearCheck();
           }
           else{finish();
               Intent nivelb = new Intent(getApplicationContext(), ResultadoNivelB.class);
               startActivity(nivelb);


           }


    }





}