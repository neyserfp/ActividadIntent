package com.neyser.actividadintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText e1, e2;
    private Button b1;
    private Spinner sp1;

    private List operaciones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.sp1);

        String[] operaciones = {"sumar", "restar", "multiplicar", "dividir"};

        //Utilizamos  el objeto ArrayAdapter para leer los datos
        ArrayAdapter<String> adaptador1 =new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,operaciones);
        sp1.setAdapter(adaptador1);

    }

    public void mostrarDatos(View view){

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);

        Integer valor1 = Integer.valueOf(e1.getText().toString());
        Integer valor2 = Integer.valueOf(e2.getText().toString());
        Integer operacion = 0;

        String resultado = "";

        String valor = sp1.getSelectedItem().toString();

        if (valor=="sumar"){
            operacion = valor1+valor2;
            resultado = String.valueOf(operacion);
        } else if (valor=="multiplicar") {
            operacion = valor1*valor2;
            resultado = String.valueOf(operacion);
        } else if (valor=="dividir") {
            try {
                operacion = valor1/valor2;
                resultado = String.valueOf(operacion);
            } catch (Exception e){
                resultado = "El valor: " + valor2 + " no es válido";
                e2.setText("");
            }
        } else if (valor=="restar") {
            operacion = valor1-valor2;
            resultado = String.valueOf(operacion);
        } else {
            Toast.makeText(this,"Debe elegir alguna opción válida", Toast.LENGTH_LONG).show();
        }

        Intent miintent=new Intent(this,MainActivity2.class);

        miintent.putExtra("valor1",valor1.toString());
        miintent.putExtra("valor2",valor2.toString());
        miintent.putExtra("resultado",resultado);
        startActivity(miintent);


    }


}