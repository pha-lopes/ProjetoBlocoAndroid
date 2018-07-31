package com.example.pedro.projetoblocoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //elementos da tela duh, nome como final para ser acessado dentro da ação do button
        final EditText nome = findViewById(R.id.edtNome);
        EditText cpf = findViewById(R.id.edtCpf);
        Button cadastrar = findViewById(R.id.btnCadastrar);

        //chamada do builder passando o campo a ser observado pelo TextWatcher para adicionar a mascara
        cpf.addTextChangedListener(EditTextMask.construirCPF());

        //Metodo onclick do button com intenção para a tela de status, bundle utilizado para passar dados desta para a proxima tela
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Username", nome.getText().toString());
                Intent intent = new Intent(CadastroActivity.this, StatusActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
