package com.software.pitagora_app_201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.software.pitagora_app_201.model.Persona;
import com.software.pitagora_app_201.model.Pregunta;

public class SelectorNivelActivity extends AppCompatActivity {

    String contenido1="Numeros";
    String contenido2="Geometria";
    String contenido3="Algebra";
    String contenido4="Probabilidad";
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Integer Cant_alg;
    Integer Cant_pro;
    Integer Cant_num;
    Integer Cant_geo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector_nivel);

        inicializarFirebase();

        Button btn_geo = (Button) findViewById(R.id.btn_geometria_selector);
        Button btn_alg = (Button) findViewById(R.id.btn_algebra_selector);
        Button btn_num = (Button) findViewById(R.id.btn_numeros_selector);
        Button btn_pro = (Button) findViewById(R.id.btn_probabilidad_selector);

        Button btn_random = (Button) findViewById(R.id.btn_random_selector);
        /*
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
        });*/
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_algebra_selector: {
            }

            case R.id.btn_geometria_selector:{
                Log.d("sisisisi", "si entra al activity");
                Intent intent = new Intent (v.getContext(), SelectorPreguntaActivity.class);
                intent.putExtra("id",contenido2);
                startActivityForResult(intent, 0);
            }


        }
    }

}