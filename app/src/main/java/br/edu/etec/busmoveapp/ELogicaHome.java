package br.edu.etec.busmoveapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ELogicaHome extends AppCompatActivity {

    ImageButton botao_mapa, botao_home;

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

        botao_mapa = findViewById(R.id.btn_mapa);

        botao_mapa.setOnClickListener(v -> {
            Intent intent = new Intent(ELogicaHome.this, FLogicaCidades.class);
            startActivity(intent);
        });

        botao_home = findViewById(R.id.btn_home);

        botao_home.setOnClickListener(view -> botao_mapa.setOnClickListener(v -> {

        }));



    }
}
