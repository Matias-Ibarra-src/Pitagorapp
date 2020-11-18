package com.software.pitagora_app_201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

public class PreguntaScreenActivity extends AppCompatActivity {
    String categoria;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public List<Pregunta> listPreguntas = new ArrayList<Pregunta>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta_screen);

        Button btn_salir = (Button) findViewById(R.id.btn_quit_pregunta);
        Button btn_glosario = (Button) findViewById(R.id.btn_pregunta_glosario);
        recogerExtras();
        inicializarFirebase();
        /*
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

         */
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


        public void onClick(View v) {
            Persona P = (Persona) getIntent().getSerializableExtra("usuario");
            switch (v.getId()) {

                case R.id.: {

                    databaseReference.child("Preguntas").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            listPreguntas.clear();
                            for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()) {
                                Pregunta pta = objSnaptshot.getValue(Pregunta.class);
                                if(categoria.equals(pta.getCategoria())) {
                                    listPreguntas.add(pta);
                                }

                            }




                            Intent intent = new Intent(SelectorPreguntaActivity.this, SelectorPreguntaActivity.class);
                            intent.putExtra("usuario",P);
                            intent.putExtra("cate",categoria);
                            startActivity(intent);


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    break;
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