package com.software.pitagora_app_201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.software.pitagora_app_201.model.Persona;
import com.software.pitagora_app_201.model.Pregunta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PreguntaScreenActivity extends AppCompatActivity {
    String categoria;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Pregunta pregunta;
    public List<Pregunta> listPreguntas = new ArrayList<Pregunta>();
    public List<String> list_contestadas = new ArrayList<String>();
    public Integer length_lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta_screen);

        length_lista=0;

        Button btn_salir = (Button) findViewById(R.id.btn_quit_pregunta);
        Button btn_glosario = (Button) findViewById(R.id.btn_pregunta_glosario);
        Button btn_next = (Button) findViewById(R.id.btn_next);

        recogerExtras();
        inicializarFirebase();
        llenar_contestadas();
        llenar_preguntas();
        pregunta=llenar_Textos();

        btn_next.setEnabled(false);

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

        btn_next.setOnClickListener(new View.OnClickListener() {
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
        String datox= extras.getString("cate");
        categoria=datox;
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    private void llenar_contestadas(){
        Persona P = (Persona) getIntent().getSerializableExtra("usuario");
        databaseReference.child("Persona").child(P.getLocalid()).child("preguntasContestadas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list_contestadas.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()) {
                    String id_pregunta = objSnaptshot.getValue(String.class);
                    list_contestadas.add(id_pregunta);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void llenar_preguntas(){
        databaseReference.child("Preguntas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listPreguntas.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()) {
                    Pregunta pregunta = objSnaptshot.getValue(Pregunta.class);
                    if(categoria.equals(pregunta.getCategoria())) {
                        listPreguntas.add(pregunta);
                        length_lista= length_lista+1;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private Pregunta llenar_Textos(){
        TextView Pregunta = findViewById(R.id.text_pregunta);
        Button respuesta1 = (Button) findViewById(R.id.btn_respuesta_1);
        Button respuesta2 = (Button) findViewById(R.id.btn_respuesta_2);
        Button respuesta3 = (Button) findViewById(R.id.btn_respuesta_3);
        Button respuesta4 = (Button) findViewById(R.id.btn_respuesta_4);
        Pregunta P = new Pregunta();
        Boolean Mostrar = true;

        while(Mostrar){
            Random random = new Random();
            Integer selected = random.nextInt(length_lista);
            P = listPreguntas.get(selected);
            if(list_contestadas.contains(P.getLocalId())){
            }else{
                Mostrar= false;
                Pregunta.setText(P.getPregunta());
                respuesta1.setText(P.getRespuesta1());
                respuesta2.setText(P.getRespuesta2());
                respuesta3.setText(P.getRespuesta3());
                respuesta4.setText(P.getRespuesta4());
            }
        }
        return P;
    }

    public void onClick(View v) {
        Persona P = (Persona) getIntent().getSerializableExtra("usuario");
        Button respuesta1 = (Button) findViewById(R.id.btn_respuesta_1);
        Button respuesta2 = (Button) findViewById(R.id.btn_respuesta_2);
        Button respuesta3 = (Button) findViewById(R.id.btn_respuesta_3);
        Button respuesta4 = (Button) findViewById(R.id.btn_respuesta_4);

        Button btn_next = (Button) findViewById(R.id.btn_next);

        switch (v.getId()) {
            case R.id.btn_respuesta_1: {
                if(respuesta1.getText().toString().equals(pregunta.getRespuestaCorrecta())){
                    respuesta1.setBackgroundColor(Color.parseColor("#1AFF00"));
                    databaseReference.child("Persona").child(P.getLocalid()).child("preguntasContestadas").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String id_pregunta = pregunta.getLocalId();
                            databaseReference.child("Persona").child(P.getLocalid()).child("preguntasContestadas").child(id_pregunta).push();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    break;
                }else{
                    respuesta1.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                btn_next.setEnabled(true);
            }

            case R.id.btn_respuesta_2:{
                if(respuesta2.getText().toString().equals(pregunta.getRespuestaCorrecta())){
                    respuesta2.setBackgroundColor(Color.parseColor("#1AFF00"));
                    databaseReference.child("Persona").child(P.getLocalid()).child("preguntasContestadas").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String id_pregunta = pregunta.getLocalId();
                            databaseReference.child("Persona").child(P.getLocalid()).child("preguntasContestadas").child(id_pregunta).push();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    break;
                }else{
                    respuesta2.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                btn_next.setEnabled(true);
            }

            case R.id.btn_respuesta_3:{
                if(respuesta3.getText().toString().equals(pregunta.getRespuestaCorrecta())){
                    respuesta3.setBackgroundColor(Color.parseColor("#1AFF00"));
                    databaseReference.child("Persona").child(P.getLocalid()).child("preguntasContestadas").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String id_pregunta = pregunta.getLocalId();
                            databaseReference.child("Persona").child(P.getLocalid()).child("preguntasContestadas").child(id_pregunta).push();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    break;
                }else{
                    respuesta3.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                btn_next.setEnabled(true);
            }

            case R.id.btn_respuesta_4:{
                if(respuesta4.getText().toString().equals(pregunta.getRespuestaCorrecta())){
                    respuesta4.setBackgroundColor(Color.parseColor("#1AFF00"));
                    databaseReference.child("Persona").child(P.getLocalid()).child("preguntasContestadas").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String id_pregunta = pregunta.getLocalId();
                            databaseReference.child("Persona").child(P.getLocalid()).child("preguntasContestadas").child(id_pregunta).push();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    break;
                }else{
                    respuesta4.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                btn_next.setEnabled(true);
            }
        }
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