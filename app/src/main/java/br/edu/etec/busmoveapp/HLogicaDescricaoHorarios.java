package br.edu.etec.busmoveapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class HLogicaDescricaoHorarios extends AppCompatActivity {

    TextView txvDescricao;
    Button botao_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.h_tela_descricao_horarios);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao_voltar = findViewById(R.id.btn_voltar);

        botao_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HLogicaDescricaoHorarios.this, ELogicaHome.class);
                startActivity(intent);
            }
        });

        txvDescricao = findViewById(R.id.txv_descricao);

        String horario = getIntent().getStringExtra("horario_escolhido");

        String textoFinal = gerarDescricao(horario);

        txvDescricao.setText(textoFinal);
    }

    private String gerarDescricao(String horario) {

        String motorista;

        switch (horario) {
            case "06:00": motorista = "José Carlos"; break;
            case "06:30": motorista = ""; break;
            case "07:00": motorista = "Ricardo Silva"; break;
            case "07:30": motorista = ""; break;
            case "08:00": motorista = "Paulo Mendes"; break;
            case "08:30": motorista = ""; break;
            case "09:00": motorista = "André Souza"; break;
            case "09:30": motorista = ""; break;
            case "10:00": motorista = "Fábio Henrique"; break;
            case "10:30": motorista = ""; break;
            case "11:00": motorista = "Daniel Moreira"; break;
            case "11:30": motorista = ""; break;
            case "12:00": motorista = "Gustavo Dias"; break;
            case "12:30": motorista = ""; break;
            case "13:00": motorista = "Alexandre Gomes"; break;
            case "13:30": motorista = ""; break;
            case "14:00": motorista = "Rafael Antunes"; break;
            case "14:30": motorista = ""; break;
            case "15:00": motorista = "Eduardo Campos"; break;
            case "15:30": motorista = ""; break;
            case "16:00": motorista = "Carlos Eduardo"; break;
            case "16:30": motorista = ""; break;
            case "17:00": motorista = "Márcio Rogério"; break;
            case "17:30": motorista = ""; break;
            default: motorista = "Não cadastrado"; break;
        }

        Random random = new Random();
        int numeroOnibus = random.nextInt(50) + 1;  // 1 a 50

        if (horario.endsWith(":30")) {
            return "O horário selecionado é " + horario + ".\n\n" +
                    "Nessa linha, os ônibus passam apenas de hora em hora. " +
                    "Por isso, os horários marcados com minutos servem apenas como referência. " +
                    "Recomendamos chegar com antecedência para evitar imprevistos.\n\n" +
                    "Ônibus: " + numeroOnibus + "\n" +
                    "Motorista responsável: " + motorista + ".";
        }

        if (horario.startsWith("07") ||
                horario.startsWith("08") ||
                horario.startsWith("17") ||
                horario.startsWith("18")) {

            return "Você selecionou o horário " + horario + ".\n\n" +
                    "Esse é um período de maior movimentação, o que pode gerar atrasos. " +
                    "O ônibus pode levar alguns minutos a mais para chegar. " +
                    "Fique atento e chegue ao ponto com antecedência.\n\n" +
                    "Ônibus: " + numeroOnibus + "\n" +
                    "Motorista responsável: " + motorista + ".";
        }

        return "Horário escolhido: " + horario + ".\n\n" +
                "Neste período, os ônibus costumam circular normalmente, " +
                "com pouca chance de atraso. Ainda assim, é recomendável " +
                "aguardar no ponto alguns minutos antes do horário previsto.\n\n" +
                "Ônibus: " + numeroOnibus + "\n" +
                "Motorista responsável: " + motorista + ".";
    }
}
