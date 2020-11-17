package com.software.pitagora_app_201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.software.pitagora_app_201.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class SelectorPreguntaActivity extends AppCompatActivity {

    TextView titulo;
    public List<Button> lista_Botonera = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector_pregunta);
        Integer total_correctas = (Integer) getIntent().getSerializableExtra("Correctas");
        Persona P = (Persona) getIntent().getSerializableExtra("usuario");
        P.setCorrectas_en_geo(10);
        Integer Control = 0;
        for (Button Btn : lista_Botonera){
            if (Control>total_correctas){
                break;
            }else{
                Btn.setBackgroundColor("#39CA11");
            }
        }

        titulo = (TextView) findViewById(R.id.titulo_selector_preguntas);
        recogerExtras();
        setiarBotones();

    }

    public void setiarBotones(){
        Button btn1 = (Button) findViewById(R.id.btn_pregunta_1_1);
        Button btn2 = (Button) findViewById(R.id.btn_pregunta_1_2);
        Button btn3 = (Button) findViewById(R.id.btn_pregunta_1_3);
        Button btn4 = (Button) findViewById(R.id.btn_pregunta_1_4);

        Button btn5 = (Button) findViewById(R.id.btn_pregunta_2_1);
        Button btn6 = (Button) findViewById(R.id.btn_pregunta_2_2);
        Button btn7 = (Button) findViewById(R.id.btn_pregunta_2_3);
        Button btn8 = (Button) findViewById(R.id.btn_pregunta_2_4);

        Button btn9 = (Button) findViewById(R.id.btn_pregunta_3_1);
        Button btn10 = (Button) findViewById(R.id.btn_pregunta_3_2);
        Button btn11 = (Button) findViewById(R.id.btn_pregunta_3_3);
        Button btn12 = (Button) findViewById(R.id.btn_pregunta_3_4);

        Button btn13 = (Button) findViewById(R.id.btn_pregunta_4_1);
        Button btn14 = (Button) findViewById(R.id.btn_pregunta_4_2);
        Button btn15 = (Button) findViewById(R.id.btn_pregunta_4_3);
        Button btn16 = (Button) findViewById(R.id.btn_pregunta_4_4);

        Button btn17 = (Button) findViewById(R.id.btn_pregunta_5_1);
        Button btn18 = (Button) findViewById(R.id.btn_pregunta_5_2);
        Button btn19 = (Button) findViewById(R.id.btn_pregunta_5_3);
        Button btn20 = (Button) findViewById(R.id.btn_pregunta_5_4);

        Button[] buttonArray = {btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20};
        for (int i = 0; i < 21; i++){
                lista_Botonera.add(buttonArray[i]);
        }
    }

    public void recogerExtras() {
        //Aquí recogemos y tratamos los parámetros
        Bundle extras= getIntent().getExtras();
        String datox= extras.getString("id");
        titulo.setText(datox);
    }

    public void onClick(View v) {

    }
}