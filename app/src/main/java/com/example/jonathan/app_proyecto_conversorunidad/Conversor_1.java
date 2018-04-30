package com.example.jonathan.app_proyecto_conversorunidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Conversor_1 extends AppCompatActivity implements View.OnClickListener {

    Spinner lista1, lista2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_1);

        ImageButton btnatras = (ImageButton) findViewById(R.id.btn_atras1);
        Button btnpunto = (Button) findViewById(R.id.btnpunto);
        Button btn0 = (Button) findViewById(R.id.btncero);
        Button btn1 = (Button) findViewById(R.id.btnuno);
        Button btn2 = (Button) findViewById(R.id.btndos);
        Button btn3 = (Button) findViewById(R.id.btntres);
        Button btn4 = (Button) findViewById(R.id.btncuatro);
        Button btn5 = (Button) findViewById(R.id.btncinco);
        Button btn6 = (Button) findViewById(R.id.btnseis);
        Button btn7 = (Button) findViewById(R.id.btnsiete);
        Button btn8 = (Button) findViewById(R.id.btnocho);
        Button btn9 = (Button) findViewById(R.id.btnnueve);
        Button btnigual = (Button) findViewById(R.id.btnresultado);
        Button btnlimpiar = (Button) findViewById(R.id.btnlimpiar);

        lista1 = findViewById(R.id.lista1);
        lista2 = findViewById(R.id.lista11);

        btnatras.setOnClickListener(this);
        btnpunto.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnigual.setOnClickListener(this);
        btnlimpiar.setOnClickListener(this);

        btnigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resultado();
            }
        });

        String[] items = new String[]{"Kelvin", "Celsius", "Fahrenheit"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        lista1.setAdapter(adapter);
        lista2.setAdapter(adapter);

        lista1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView txtentrada3 = (TextView) findViewById(R.id.txtentrada);
                TextView txtsalida3 = (TextView) findViewById(R.id.txtsalida);
                txtentrada3.setText("");
                txtsalida3.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lista2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView txtentrada3 = (TextView) findViewById(R.id.txtentrada);
                TextView txtsalida3 = (TextView) findViewById(R.id.txtsalida);
                txtentrada3.setText("");
                txtsalida3.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        TextView txtentrada = (TextView) findViewById(R.id.txtentrada);
        TextView txtsalida = (TextView) findViewById(R.id.txtsalida);

        switch (v.getId()) {
            case R.id.btn_atras1:

                Intent i = new Intent(Conversor_1.this, principal.class);
                startActivity(i);
                break;
            case R.id.btncero:
                txtentrada.append("0");
                break;
            case R.id.btnpunto:
                txtentrada.append(".");
                break;
            case R.id.btnuno:
                txtentrada.append("1");
                break;
            case R.id.btndos:
                txtentrada.append("2");
                break;
            case R.id.btntres:
                txtentrada.append("3");
                break;
            case R.id.btncuatro:
                txtentrada.append("4");
                break;
            case R.id.btncinco:
                txtentrada.append("5");
                break;
            case R.id.btnseis:
                txtentrada.append("6");
                break;
            case R.id.btnsiete:
                txtentrada.append("7");
                break;
            case R.id.btnocho:
                txtentrada.append("8");
                break;
            case R.id.btnnueve:
                txtentrada.append("9");
                break;
            case R.id.btnlimpiar:
                txtentrada.setText("");
                txtsalida.setText("");
                break;
        }
    }

    public void Resultado() {
        TextView txtentradas = (TextView) findViewById(R.id.txtentrada);
        TextView txtresultado = (TextView) findViewById(R.id.txtsalida);

        if (txtentradas.getText().equals("")) {

            Toast.makeText(Conversor_1.this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
            txtentradas.setText("");
            txtresultado.setText("");

        } else {

            Double valorentrada = Double.valueOf(txtentradas.getText().toString());
            Double resultado = null;

            if (lista1.getSelectedItemId() == 0 && lista2.getSelectedItemId() == 0) {
                resultado = valorentrada;
            } else if (lista1.getSelectedItemId() == 0 && lista2.getSelectedItemId() == 1) {
                resultado = valorentrada - 273.15;
            } else if (lista1.getSelectedItemId() == 0 && lista2.getSelectedItemId() == 2) {
                resultado = (9 / 5 * valorentrada) - 459.67;
            } else if (lista1.getSelectedItemId() == 1 && lista2.getSelectedItemId() == 0) {
                resultado = valorentrada + 273.15;
            } else if (lista1.getSelectedItemId() == 1 && lista2.getSelectedItemId() == 1) {
                resultado = valorentrada;
            } else if (lista1.getSelectedItemId() == 1 && lista2.getSelectedItemId() == 2) {
                resultado = (9 / 5 * valorentrada) + 32;
            } else if (lista1.getSelectedItemId() == 2 && lista2.getSelectedItemId() == 0) {
                resultado = 5 / 9 * (valorentrada + 459.67);
            } else if (lista1.getSelectedItemId() == 2 && lista2.getSelectedItemId() == 1) {
                resultado = 5 / 9 * (valorentrada - 32);
            } else if (lista1.getSelectedItemId() == 2 && lista2.getSelectedItemId() == 2) {
                resultado = valorentrada;
            }

            txtresultado.setText(resultado.toString());
        }

    }


}
