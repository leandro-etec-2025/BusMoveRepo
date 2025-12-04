package br.edu.etec.busmoveapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HLogicaDescricaoHorarios extends AppCompatActivity {

    TextView txvDescricao;

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

        txvDescricao = findViewById(R.id.txv_descricao);

        String horario = getIntent().getStringExtra("horario_escolhido");

        String textoFinal = gerarDescricao(horario);

        txvDescricao.setText(textoFinal);
    }

    private String gerarDescricao(String horario) {

        if (horario.endsWith(":30")) {
            return "O horário selecionado é " + horario + ".\n\n" +
                    "Nessa linha, os ônibus passam apenas de hora em hora. " +
                    "Por isso, os horários marcados com minutos servem apenas como referência. " +
                    "Recomendamos chegar com antecedência para evitar imprevistos.";
        }

        if (horario.startsWith("07") ||
                horario.startsWith("08") ||
                horario.startsWith("17") ||
                horario.startsWith("18")) {

            return "Você selecionou o horário " + horario + ".\n\n" +
                    "Esse é um período de maior movimentação, o que pode gerar atrasos. " +
                    "O ônibus pode levar alguns minutos a mais para chegar. " +
                    "Fique atento e chegue ao ponto com antecedência.";
        }

        return "Horário escolhido: " + horario + ".\n\n" +
                "Neste período, os ônibus costumam circular normalmente, " +
                "com pouca chance de atraso. Ainda assim, é recomendável " +
                "aguardar no ponto alguns minutos antes do horário previsto.";
    }
}
