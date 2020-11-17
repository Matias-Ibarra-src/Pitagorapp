package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.software.pitagora_app_201.model.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class PreguntaScreenActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public List<Pregunta> lista_Preguntas = new ArrayList<Pregunta>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta_screen);

        Button btn_salir = (Button) findViewById(R.id.btn_quit_pregunta);
        Button btn_glosario = (Button) findViewById(R.id.btn_pregunta_glosario);

        inicializarFirebase();

        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainDespuesDeLoginActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        btn_glosario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), GlosarioInicioActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
/*
    private List<Pregunta>  rellenar_lista(){

    }*/
/*
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.: {
            }

            case R.id.: {
            }

            case R.id.: {
            }

            case R.id.: {
            }
        }
    }*/
}