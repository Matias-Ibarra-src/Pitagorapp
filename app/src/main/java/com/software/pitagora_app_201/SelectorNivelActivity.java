package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectorNivelActivity extends AppCompatActivity {

    String contenido1="Numeros";
    String contenido2="Geometria";
    String contenido3="Algebra";
    String contenido4="Probabilidad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector_nivel);

        Button btn_geo = (Button) findViewById(R.id.btn_geometria_selector);
        Button btn_alg = (Button) findViewById(R.id.btn_algebra_selector);
        Button btn_num = (Button) findViewById(R.id.btn_numeros_selector);
        Button btn_pro = (Button) findViewById(R.id.btn_probabilidad_selector);

        Button btn_random = (Button) findViewById(R.id.btn_random_selector);

        btn_geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SelectorPreguntaActivity.class);
                intent.putExtra("id",contenido2);
                startActivityForResult(intent, 0);
            }
        });

        btn_alg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SelectorPreguntaActivity.class);
                intent.putExtra("id",contenido3);
                startActivityForResult(intent, 0);
            }
        });

        btn_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SelectorPreguntaActivity.class);
                intent.putExtra("id",contenido1);
                startActivityForResult(intent, 0);
            }
        });

        btn_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SelectorPreguntaActivity.class);
                intent.putExtra("id",contenido4);
                startActivityForResult(intent, 0);
            }
        });

        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), PreguntaScreenActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}