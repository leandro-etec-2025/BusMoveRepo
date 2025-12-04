package br.edu.etec.busmoveapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GLogicaHorarios extends AppCompatActivity {

    Button botao_voltar;
    Button btn_6, btn_65, btn_7, btn_75,
            btn_8, btn_85, btn_9, btn_95,
            btn_10, btn_105, btn_11, btn_115,
            btn_12, btn_125, btn_13, btn_135,
            btn_14, btn_145, btn_15, btn_155;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.g_tela_horarios);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao_voltar = findViewById(R.id.btn_voltar);

        botao_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GLogicaHorarios.this, ELogicaHome.class);
                startActivity(intent);
            }
        });

        btn_6   = findViewById(R.id.btn_6);
        btn_65  = findViewById(R.id.btn_65);

        btn_7   = findViewById(R.id.btn_7);
        btn_75  = findViewById(R.id.btn_75);

        btn_8   = findViewById(R.id.btn_8);
        btn_85  = findViewById(R.id.btn_85);

        btn_9   = findViewById(R.id.btn_9);
        btn_95  = findViewById(R.id.btn_95);

        btn_10  = findViewById(R.id.btn_10);
        btn_105 = findViewById(R.id.btn_105);

        btn_11  = findViewById(R.id.btn_11);
        btn_115 = findViewById(R.id.btn_115);

        btn_12  = findViewById(R.id.btn_12);
        btn_125 = findViewById(R.id.btn_125);

        btn_13  = findViewById(R.id.btn_13);
        btn_135 = findViewById(R.id.btn_135);

        btn_14  = findViewById(R.id.btn_14);
        btn_145 = findViewById(R.id.btn_145);

        btn_15  = findViewById(R.id.btn_15);
        btn_155 = findViewById(R.id.btn_155);

        btn_6.setOnClickListener(v -> abrirDescricao("06:00"));
        btn_65.setOnClickListener(v -> abrirDescricao("06:30"));

        btn_7.setOnClickListener(v -> abrirDescricao("07:00"));
        btn_75.setOnClickListener(v -> abrirDescricao("07:30"));

        btn_8.setOnClickListener(v -> abrirDescricao("08:00"));
        btn_85.setOnClickListener(v -> abrirDescricao("08:30"));

        btn_9.setOnClickListener(v -> abrirDescricao("09:00"));
        btn_95.setOnClickListener(v -> abrirDescricao("09:30"));

        btn_10.setOnClickListener(v -> abrirDescricao("10:00"));
        btn_105.setOnClickListener(v -> abrirDescricao("10:30"));

        btn_11.setOnClickListener(v -> abrirDescricao("11:00"));
        btn_115.setOnClickListener(v -> abrirDescricao("11:30"));

        btn_12.setOnClickListener(v -> abrirDescricao("12:00"));
        btn_125.setOnClickListener(v -> abrirDescricao("12:30"));

        btn_13.setOnClickListener(v -> abrirDescricao("13:00"));
        btn_135.setOnClickListener(v -> abrirDescricao("13:30"));

        btn_14.setOnClickListener(v -> abrirDescricao("14:00"));
        btn_145.setOnClickListener(v -> abrirDescricao("14:30"));

        btn_15.setOnClickListener(v -> abrirDescricao("15:00"));
        btn_155.setOnClickListener(v -> abrirDescricao("15:30"));
    }


    private void abrirDescricao(String horarioSelecionado) {
        Intent intent = new Intent(GLogicaHorarios.this, HLogicaDescricaoHorarios.class);
        intent.putExtra("horario_escolhido", horarioSelecionado);
        startActivity(intent);
    }



}
