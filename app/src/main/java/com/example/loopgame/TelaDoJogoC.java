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

public class TelaDoJogoC extends AppCompatActivity {
    ImageButton btnImgRetornarParaHome_JogoC, btnImgProximaQuestao_JogoC;
    RadioButton rBtnPrimeiraAlternativa_JogoC, rBtnSegundaAlternativa_JogoC, rBtnTerceiraAlternativa_JogoC, rBtnQuartaAlternativa_JogoC, rBtnQuintaAlternativa_JogoC;
    RadioGroup rgRespostas_TelaJogoC;
    TextView txtEnunciadoQuestao_JogoC, txtPontuacao_JogoC;
    int respostaCerta = R.id.RBtnPrimeiraAlternativa_JogoC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_do_jogo_c);
        btnImgProximaQuestao_JogoC = findViewById(R.id.BtnImgProximaQuestao_JogoC);
        rBtnPrimeiraAlternativa_JogoC = findViewById(R.id.RBtnPrimeiraAlternativa_JogoC);
        rBtnSegundaAlternativa_JogoC = findViewById(R.id.RBtnSegundaAlternativa_JogoC);
        rBtnTerceiraAlternativa_JogoC = findViewById(R.id.RBtnTerceiraAlternativa_JogoC);
        rBtnQuartaAlternativa_JogoC = findViewById(R.id.RBtnQuartaAlternativa_JogoC);
        rBtnQuintaAlternativa_JogoC = findViewById(R.id.RBtnQuintaAlternativa_JogoC);
        txtEnunciadoQuestao_JogoC = findViewById(R.id.TxtEnunciadoQuestao_JogoC);
        rgRespostas_TelaJogoC = findViewById(R.id.RgRespostas_TelaJogoC);
        btnImgRetornarParaHome_JogoC = findViewById(R.id.BtnImgRetornarParaHome_JogoC);
        txtPontuacao_JogoC = findViewById(R.id.TxtPontuacao_JogoC);

        btnImgRetornarParaHome_JogoC.setOnClickListener(view -> {
            Intent retornarhomec = new Intent(getApplicationContext(), Home.class);
            startActivity(retornarhomec);


        });


        btnImgProximaQuestao_JogoC.setOnClickListener(view -> {

            if(rgRespostas_TelaJogoC.getCheckedRadioButtonId() == respostaCerta){
                Toast.makeText(this, "Acertou! + 40 pontos", Toast.LENGTH_SHORT).show();
                String pontuacao = txtPontuacao_JogoC.getText().toString();
                int numero1 = Integer.parseInt(pontuacao);
                int pontos = numero1 + 40;
                txtPontuacao_JogoC.setText(String.valueOf(pontos));
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
            txtEnunciadoQuestao_JogoC.setText(q.getPergunta());
            List<String> resposta = q.getRespostas();
            rBtnPrimeiraAlternativa_JogoC.setText(resposta.get(0));
            rBtnSegundaAlternativa_JogoC.setText(resposta.get(1));
            rBtnTerceiraAlternativa_JogoC.setText(resposta.get(2));
            rBtnQuartaAlternativa_JogoC.setText(resposta.get(3));
            rBtnQuintaAlternativa_JogoC.setText(resposta.get(4));
            respostaCerta = q.getRespostaCerta();
            rgRespostas_TelaJogoC.clearCheck();
        }
        else{ //acabaram as questões
            Intent nivelc = new Intent(getApplicationContext(), Conclusao.class);
            startActivity(nivelc);

        }


    }
    List<Questao> questoes = new ArrayList<Questao>(){
        {
            add(new Questao("Um ciclo de processamento é composto por quais sequências de etapas:", R.id.RBtnSegundaAlternativa_JogoC, "Entrada / Algoritmo / Saída.", "Entrada / Processamento / Saída.", "Entrada / Saída / Processamento.", "Algoritmo / Entrada / Saída.", "Entrada / Processamento / Algoritmo."));
            add(new Questao("Escolha a alternativa que NÃO contém um par respectivo de dado e informação:", R.id.RBtnTerceiraAlternativa_JogoC, " Notas de um aluno / Média escolar.", " Contas a pagar e a receber / Lucro da empresa.", " Ano de admissão do funcionário / Salário do funcionário.", " Saldo anterior, saques e depósitos / Saldo atualizado.", " Dias trabalhados e holerite / Salário do funcionário."));
            add(new Questao("Dadas as seguintes instruções, em qual ordem elas deveriam ser executadas em um algoritmo para tomar banho? I. Se secar II. Ligar o chuveiro III. Se enxaguar IV. Se ensaboar V. Desligar o chuveiro:", R.id.RBtnTerceiraAlternativa_JogoC, "I, II, III, IV, V.", "II, V, I, III, IV.", "II, IV, III, V, I.", "V, IV, III, II, I.", "II, I, III, IV, V."));

        }

    };



}