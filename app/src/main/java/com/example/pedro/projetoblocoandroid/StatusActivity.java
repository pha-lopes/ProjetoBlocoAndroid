package com.example.pedro.projetoblocoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class StatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        TextView Nome = findViewById(R.id.txtNome);

        Intent intent = getIntent();
        Bundle dados;
        dados = intent.getExtras();
        assert dados != null;
        Nome.setText(Objects.requireNonNull(dados.get("Username")).toString());
    }
}
