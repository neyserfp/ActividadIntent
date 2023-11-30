package com.neyser.actividadintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView t01, t02, t03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t01 = findViewById(R.id.t01);
        t02 = findViewById(R.id.t02);
        t03 = findViewById(R.id.t03);

        Intent miintent2 = getIntent();

        String valor1 = miintent2.getStringExtra("valor1");
        String valor2 = miintent2.getStringExtra("valor2");
        String resultado = miintent2.getStringExtra("resultado");

        t01.setText("Número 1: "+valor1);
        t02.setText("Número 2: "+valor2);
        t03.setText("Resultado : "+resultado);

    }

    public void volver(View view){
        finish();
    }

}