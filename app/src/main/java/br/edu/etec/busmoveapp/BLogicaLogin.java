package br.edu.etec.busmoveapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BLogicaLogin extends AppCompatActivity {

    EditText cpf, senha;
    Button botao_entrar;
    Button botao_esquci_senha;
    Button botao_nova_conta;   // <────── novo botão

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.b_tela_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cpf = findViewById(R.id.etx_cpf);
        senha = findViewById(R.id.etx_senha);
        botao_entrar = findViewById(R.id.btn_entrar);
        botao_esquci_senha = findViewById(R.id.btn_esqueci);
        botao_nova_conta = findViewById(R.id.btn_nova_conta);

        botao_entrar.setOnClickListener(v -> validarLogin());

        botao_esquci_senha.setOnClickListener(v -> {
            Intent intent = new Intent(BLogicaLogin.this, CLogicaRedefinirSenha.class);
            startActivity(intent);
        });

        botao_nova_conta.setOnClickListener(v -> {
            Intent intent = new Intent(BLogicaLogin.this, DLogicaCadastro.class);
            startActivity(intent);
        });
    }

    private void validarLogin() {
        String conteudo_cpf = cpf.getText().toString().trim();
        String conteudo_senha = senha.getText().toString().trim();

        if (!conteudo_cpf.matches("^[0-9]{11}$")) {
            Toast.makeText(this, "CPF inválido! Digite 11 números.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!conteudo_senha.matches("^[0-9]{6}$")) {
            Toast.makeText(this, "Senha inválida! Deve conter 6 dígitos numéricos.", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Login válido!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(BLogicaLogin.this, ELogicaHome.class);
        startActivity(intent);


        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

}
