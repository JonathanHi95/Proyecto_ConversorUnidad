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

public class Conversor_3 extends AppCompatActivity implements View.OnClickListener {

    Spinner lista1, lista2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_3);

        ImageButton btnatras = (ImageButton) findViewById(R.id.btn_atras3);
        Button btnpunto = (Button) findViewById(R.id.btnpunto3);
        Button btn0 = (Button) findViewById(R.id.btncero3);
        Button btn1 = (Button) findViewById(R.id.btnuno3);
        Button btn2 = (Button) findViewById(R.id.btndos3);
        Button btn3 = (Button) findViewById(R.id.btntres3);
        Button btn4 = (Button) findViewById(R.id.btncuatro3);
        Button btn5 = (Button) findViewById(R.id.btncinco3);
        Button btn6 = (Button) findViewById(R.id.btnseis3);
        Button btn7 = (Button) findViewById(R.id.btnsiete3);
        Button btn8 = (Button) findViewById(R.id.btnocho3);
        Button btn9 = (Button) findViewById(R.id.btnnueve3);
        Button btnigual = (Button) findViewById(R.id.btnresultado3);
        Button btnlimpiar = (Button) findViewById(R.id.btnlimpiar3);

        lista1 = findViewById(R.id.lista3);
        lista2 = findViewById(R.id.lista33);

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
                Resultado3();
            }
        });

        String[] items = new String[]{"Centímetro", "Metro", "Kilómetro"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        lista1.setAdapter(adapter);
        lista2.setAdapter(adapter);

        lista1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView txtentrada3 = (TextView) findViewById(R.id.txtentrada3);
                TextView txtsalida3 = (TextView) findViewById(R.id.txtsalida3);
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
                TextView txtentrada3 = (TextView) findViewById(R.id.txtentrada3);
                TextView txtsalida3 = (TextView) findViewById(R.id.txtsalida3);
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
        TextView txtentrada = (TextView) findViewById(R.id.txtentrada3);
        TextView txtsalida = (TextView) findViewById(R.id.txtsalida3);

        switch (v.getId()) {
            case R.id.btn_atras3:

                Intent i = new Intent(Conversor_3.this, principal.class);
                startActivity(i);
                break;
            case R.id.btncero3:
                txtentrada.append("0");
                break;
            case R.id.btnpunto3:
                txtentrada.append(".");
                break;
            case R.id.btnuno3:
                txtentrada.append("1");
                break;
            case R.id.btndos3:
                txtentrada.append("2");
                break;
            case R.id.btntres3:
                txtentrada.append("3");
                break;
            case R.id.btncuatro3:
                txtentrada.append("4");
                break;
            case R.id.btncinco3:
                txtentrada.append("5");
                break;
            case R.id.btnseis3:
                txtentrada.append("6");
                break;
            case R.id.btnsiete3:
                txtentrada.append("7");
                break;
            case R.id.btnocho3:
                txtentrada.append("8");
                break;
            case R.id.btnnueve3:
                txtentrada.append("9");
                break;
            case R.id.btnlimpiar3:
                txtentrada.setText("");
                txtsalida.setText("");
                break;
        }


    }

    public void Resultado3() {
        TextView txtentradas = (TextView) findViewById(R.id.txtentrada3);
        TextView txtresultado = (TextView) findViewById(R.id.txtsalida3);

        if (txtentradas.getText().equals("")) {

            Toast.makeText(Conversor_3.this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
            txtentradas.setText("");
            txtresultado.setText("");

        } else {
            //Centímetro", "Metro", "Kilómetro

            Double valorentrada = Double.valueOf(txtentradas.getText().toString());
            Double resultado = null;

            if (lista1.getSelectedItemId() == 0 && lista2.getSelectedItemId() == 0) {
                resultado = valorentrada;
            } else if (lista1.getSelectedItemId() == 0 && lista2.getSelectedItemId() == 1) {
                resultado = valorentrada / 100;
            } else if (lista1.getSelectedItemId() == 0 && lista2.getSelectedItemId() == 2) {
                resultado = valorentrada / 10000;
            } else if (lista1.getSelectedItemId() == 1 && lista2.getSelectedItemId() == 0) {
                resultado = valorentrada * 100;
            } else if (lista1.getSelectedItemId() == 1 && lista2.getSelectedItemId() == 1) {
                resultado = valorentrada;
            } else if (lista1.getSelectedItemId() == 1 && lista2.getSelectedItemId() == 2) {
                resultado = valorentrada / 1000;
            } else if (lista1.getSelectedItemId() == 2 && lista2.getSelectedItemId() == 0) {
                resultado = valorentrada * 10000;
            } else if (lista1.getSelectedItemId() == 2 && lista2.getSelectedItemId() == 1) {
                resultado = valorentrada * 1000;
            } else if (lista1.getSelectedItemId() == 2 && lista2.getSelectedItemId() == 2) {
                resultado = valorentrada;
            }

            txtresultado.setText(resultado.toString());
        }
    }

}
