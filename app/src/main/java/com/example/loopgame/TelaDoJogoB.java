package com.example.loopgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaDoJogoB extends AppCompatActivity {
    ImageButton btnImgRetornarParaHome_JogoB, btnImgProximaQuestao_JogoB;
    RadioButton rBtnPrimeiraAlternativa_JogoB, rBtnSegundaAlternativa_JogoB, rBtnTerceiraAlternativa_JogoB, rBtnQuartaAlternativa_JogoB, rBtnQuintaAlternativa_JogoB;
    RadioGroup rgRespostas_TelaJogoB;
    TextView txtEnunciadoQuestao_JogoB, txtPontuacao_JogoB;
    int respostaCerta = R.id.RBtnPrimeiraAlternativa_JogoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_do_jogo_b);

        btnImgProximaQuestao_JogoB = findViewById(R.id.BtnImgProximaQuestao_JogoB);
        rBtnPrimeiraAlternativa_JogoB = findViewById(R.id.RBtnPrimeiraAlternativa_JogoB);
        rBtnSegundaAlternativa_JogoB = findViewById(R.id.RBtnSegundaAlternativa_JogoB);
        rBtnTerceiraAlternativa_JogoB = findViewById(R.id.RBtnTerceiraAlternativa_JogoB);
        rBtnQuartaAlternativa_JogoB = findViewById(R.id.RBtnQuartaAlternativa_JogoB);
        rBtnQuintaAlternativa_JogoB = findViewById(R.id.RBtnQuintaAlternativa_JogoB);
        txtEnunciadoQuestao_JogoB = findViewById(R.id.TxtEnunciadoQuestao_JogoB);
        rgRespostas_TelaJogoB = findViewById(R.id.RgRespostas_TelaJogoB);
        btnImgRetornarParaHome_JogoB = findViewById(R.id.BtnImgRetornarParaHome_JogoB);
        txtPontuacao_JogoB = findViewById(R.id.TxtPontuacao_JogoB);

        btnImgRetornarParaHome_JogoB.setOnClickListener(view -> {
            Intent retornarhome = new Intent(getApplicationContext(), Home.class);
            startActivity(retornarhome);


        });


        btnImgProximaQuestao_JogoB.setOnClickListener(view -> {

            if(rgRespostas_TelaJogoB.getCheckedRadioButtonId() == respostaCerta){
                Toast.makeText(this, "Acertou! + 30 pontos", Toast.LENGTH_SHORT).show();
                String pontuacao = txtPontuacao_JogoB.getText().toString();
                int numero1 = Integer.parseInt(pontuacao);
                int pontos = numero1 + 30;
                txtPontuacao_JogoB.setText(String.valueOf(pontos));

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
            txtEnunciadoQuestao_JogoB.setText(q.getPergunta());
            List<String> resposta = q.getRespostas();
            rBtnPrimeiraAlternativa_JogoB.setText(resposta.get(0));
            rBtnSegundaAlternativa_JogoB.setText(resposta.get(1));
            rBtnTerceiraAlternativa_JogoB.setText(resposta.get(2));
            rBtnQuartaAlternativa_JogoB.setText(resposta.get(3));
            rBtnQuintaAlternativa_JogoB.setText(resposta.get(4));
            respostaCerta = q.getRespostaCerta();
            rgRespostas_TelaJogoB.clearCheck();
        }
        else{ //acabaram as questões
            Intent nivelc = new Intent(getApplicationContext(), ResultadoNivelC.class);
            startActivity(nivelc);

        }


    }
    List<Questao> questoes = new ArrayList<Questao>(){
        {
            add(new Questao("Um ciclo de processamento é composto por quais sequências de etapas:", R.id.RBtnSegundaAlternativa_JogoB, "Entrada / Algoritmo / Saída.", "Entrada / Processamento / Saída.", "Entrada / Saída / Processamento.", "Algoritmo / Entrada / Saída.", "Entrada / Processamento / Algoritmo."));
            add(new Questao("Escolha a alternativa que NÃO contém um par respectivo de dado e informação:", R.id.RBtnTerceiraAlternativa_JogoB, " Notas de um aluno / Média escolar.", " Contas a pagar e a receber / Lucro da empresa.", " Ano de admissão do funcionário / Salário do funcionário.", " Saldo anterior, saques e depósitos / Saldo atualizado.", " Dias trabalhados e holerite / Salário do funcionário."));
            add(new Questao("Dadas as seguintes instruções, em qual ordem elas deveriam ser executadas em um algoritmo para tomar banho? I. Se secar II. Ligar o chuveiro III. Se enxaguar IV. Se ensaboar V. Desligar o chuveiro:", R.id.RBtnTerceiraAlternativa_JogoB, "I, II, III, IV, V.", "II, V, I, III, IV.", "II, IV, III, V, I.", "V, IV, III, II, I.", "II, I, III, IV, V."));

        }

    };



}