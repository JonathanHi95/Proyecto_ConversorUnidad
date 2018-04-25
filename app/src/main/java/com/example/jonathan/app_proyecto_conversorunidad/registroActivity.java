package com.example.jonathan.app_proyecto_conversorunidad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class registroActivity extends AppCompatActivity {

    AutoCompleteTextView txnombre_r,txcorreo_r,txclave_r,txconfclave_r;
    Button btnregistrar;
    TextView tx_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txnombre_r = (AutoCompleteTextView) findViewById(R.id.txnombre);
        txcorreo_r = (AutoCompleteTextView) findViewById(R.id.txusuario);
        txclave_r = (AutoCompleteTextView) findViewById(R.id.txclave);
        txconfclave_r = (AutoCompleteTextView) findViewById(R.id.txrepitaclave);
        btnregistrar = (Button) findViewById(R.id.btn_registro);
        tx_login = (TextView) findViewById(R.id.txnuevo);



    }
}
