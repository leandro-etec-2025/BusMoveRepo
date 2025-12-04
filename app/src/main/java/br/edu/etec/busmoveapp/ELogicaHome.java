package br.edu.etec.busmoveapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ELogicaHome extends AppCompatActivity {

    ImageButton botao_horarios, botao_atualizacoes, botao_pontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.e_tela_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao_horarios = findViewById(R.id.btn_horarios);
        botao_atualizacoes = findViewById(R.id.btn_atualizacoes);
        botao_pontos = findViewById(R.id.btn_pontos);

        botao_horarios.setOnClickListener(v -> {
            Intent intent = new Intent(ELogicaHome.this, FLogicaCidades.class);
            startActivity(intent);
        });

        botao_atualizacoes.setOnClickListener(v -> {
            Intent intent = new Intent(ELogicaHome.this, ILogicaInformacoes.class);
            startActivity(intent);
        });

        botao_pontos.setOnClickListener(v -> {
            Intent intent = new Intent(ELogicaHome.this, JLogicaMapa.class);
            startActivity(intent);
        });
    }
}
