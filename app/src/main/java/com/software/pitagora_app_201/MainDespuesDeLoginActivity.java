package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.software.pitagora_app_201.model.Persona;

public class MainDespuesDeLoginActivity extends AppCompatActivity {
TextView nombre;
TextView puntaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_despues_de_login);
        nombre= (TextView) findViewById(R.id.text_nombre_usuario);
        puntaje= (TextView) findViewById(R.id.text_puntaje);
        Persona  usuarioLogueado = (Persona) getIntent().getSerializableExtra("usuario");
        nombre.setText(usuarioLogueado.getNombre());
        puntaje.setText(usuarioLogueado.getPuntajeTotal());
    }
}