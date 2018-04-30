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

public class Conversor_2 extends AppCompatActivity implements View.OnClickListener {

    Spinner lista1, lista2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_2);

        ImageButton btnatras = (ImageButton) findViewById(R.id.btn_atras2);
        Button btnpunto = (Button) findViewById(R.id.btnpunto2);
        Button btn0 = (Button) findViewById(R.id.btncero2);
        Button btn1 = (Button) findViewById(R.id.btnuno2);
        Button btn2 = (Button) findViewById(R.id.btndos2);
        Button btn3 = (Button) findViewById(R.id.btntres2);
        Button btn4 = (Button) findViewById(R.id.btncuatro2);
        Button btn5 = (Button) findViewById(R.id.btncinco2);
        Button btn6 = (Button) findViewById(R.id.btnseis2);
        Button btn7 = (Button) findViewById(R.id.btnsiete2);
        Button btn8 = (Button) findViewById(R.id.btnocho2);
        Button btn9 = (Button) findViewById(R.id.btnnueve2);
        Button btnigual = (Button) findViewById(R.id.btnresultado2);
        Button btnlimpiar = (Button) findViewById(R.id.btnlimpiar2);

        lista1 = findViewById(R.id.lista2);
        lista2 = findViewById(R.id.lista22);

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
                Resultado2();
            }
        });

        String[] items = new String[]{"Kilogramo", "Libra", "Tonelada"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        lista1.setAdapter(adapter);
        lista2.setAdapter(adapter);

        lista1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView txtentrada3 = (TextView) findViewById(R.id.txtentrada2);
                TextView txtsalida3 = (TextView) findViewById(R.id.txtsalida2);
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
                TextView txtentrada3 = (TextView) findViewById(R.id.txtentrada2);
                TextView txtsalida3 = (TextView) findViewById(R.id.txtsalida2);
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
        TextView txtentrada = (TextView) findViewById(R.id.txtentrada2);
        TextView txtsalida = (TextView) findViewById(R.id.txtsalida2);

        switch (v.getId()) {
            case R.id.btn_atras2:

                Intent i = new Intent(Conversor_2.this, principal.class);
                startActivity(i);
                break;
            case R.id.btncero2:
                txtentrada.append("0");
                break;
            case R.id.btnpunto2:
                txtentrada.append(".");
                break;
            case R.id.btnuno2:
                txtentrada.append("1");
                break;
            case R.id.btndos2:
                txtentrada.append("2");
                break;
            case R.id.btntres2:
                txtentrada.append("3");
                break;
            case R.id.btncuatro2:
                txtentrada.append("4");
                break;
            case R.id.btncinco2:
                txtentrada.append("5");
                break;
            case R.id.btnseis2:
                txtentrada.append("6");
                break;
            case R.id.btnsiete2:
                txtentrada.append("7");
                break;
            case R.id.btnocho2:
                txtentrada.append("8");
                break;
            case R.id.btnnueve2:
                txtentrada.append("9");
                break;
            case R.id.btnlimpiar2:
                txtentrada.setText("");
                txtsalida.setText("");
                break;
        }

    }

    public void Resultado2() {
        TextView txtentradas = (TextView) findViewById(R.id.txtentrada2);
        TextView txtresultado = (TextView) findViewById(R.id.txtsalida2);

        if (txtentradas.getText().equals("")) {

            Toast.makeText(Conversor_2.this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
            txtentradas.setText("");
            txtresultado.setText("");

        } else {

            Double valorentrada = Double.valueOf(txtentradas.getText().toString());
            Double resultado = null;
            //"Kilogramo", "Libra", "Tonelada"}
            if (lista1.getSelectedItemId() == 0 && lista2.getSelectedItemId() == 0) {
                resultado = valorentrada;
            } else if (lista1.getSelectedItemId() == 0 && lista2.getSelectedItemId() == 1) {
                resultado = valorentrada * 2.2;
            } else if (lista1.getSelectedItemId() == 0 && lista2.getSelectedItemId() == 2) {
                resultado = valorentrada /1000;
            } else if (lista1.getSelectedItemId() == 1 && lista2.getSelectedItemId() == 0) {
                resultado = valorentrada / 2.2;
            } else if (lista1.getSelectedItemId() == 1 && lista2.getSelectedItemId() == 1) {
                resultado = valorentrada;
            } else if (lista1.getSelectedItemId() == 1 && lista2.getSelectedItemId() == 2) {
                resultado = valorentrada /453592;
            } else if (lista1.getSelectedItemId() == 2 && lista2.getSelectedItemId() == 0) {
                resultado = valorentrada * 1000;
            } else if (lista1.getSelectedItemId() == 2 && lista2.getSelectedItemId() == 1) {
                resultado = valorentrada * 2204;
            } else if (lista1.getSelectedItemId() == 2 && lista2.getSelectedItemId() == 2) {
                resultado = valorentrada;
            }

            txtresultado.setText(resultado.toString());
        }

    }

}
