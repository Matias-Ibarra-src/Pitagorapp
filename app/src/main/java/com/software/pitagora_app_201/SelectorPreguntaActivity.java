package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectorPreguntaActivity extends AppCompatActivity {

    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector_pregunta);

        titulo = (TextView) findViewById(R.id.titulo_selector_preguntas);
        Button btn_1 = (Button) findViewById(R.id.btn_pregunta_1_1);

        recogerExtras();

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), PreguntaScreenActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    public void recogerExtras() {
        //Aquí recogemos y tratamos los parámetros
        Bundle extras= getIntent().getExtras();
        String datox= extras.getString("id");
        titulo.setText(datox);
    }
}