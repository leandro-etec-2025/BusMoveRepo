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

public class ILogicaInformacoes extends AppCompatActivity {

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

        botao_voltar.setOnClickListener(view -> {
            Intent intent = new Intent(ILogicaInformacoes.this, ELogicaHome.class);
            startActivity(intent);
        });

        txvDescricao = findViewById(R.id.txv_descricao);

        String horario = getIntent().getStringExtra("horario_escolhido");

        String textoFinal = gerarDescricao(horario);

        txvDescricao.setText(textoFinal);
    }

    private String gerarDescricao(String horario) {

        Random random = new Random();
        int tipoAviso = random.nextInt(4); // 0 a 3

        String aviso;

        switch (tipoAviso) {

            case 0:
                aviso = "⚠️ Atualização importante!\n\n" +
                        "A empresa informa que está realizando ajustes nos horários para melhorar a pontualidade. " +
                        "O horário das " + horario + " pode sofrer pequenas alterações durante os próximos dias.";
                break;

            case 1:
                aviso = "🚍 Novidade na frota!\n\n" +
                        "A linha correspondente ao horário das " + horario +
                        " recebeu novos veículos, oferecendo mais conforto e segurança para todos os passageiros.";
                break;

            case 2:
                aviso = "🔄 Manutenção programada\n\n" +
                        "Devido a melhorias na infraestrutura, o horário das " + horario +
                        " poderá ter pequenos atrasos. A empresa agradece sua compreensão.";
                break;

            default:
                aviso = "ℹ️ Informações atualizadas\n\n" +
                        "A empresa está monitorando a demanda de passageiros. " +
                        "O horário das " + horario +
                        " continua ativo e com funcionamento normal. Fique atento às próximas atualizações!";
                break;
        }

        return aviso;
    }
}
