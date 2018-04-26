package com.example.jonathan.app_proyecto_conversorunidad;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class registroActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    AutoCompleteTextView txnombre_r, txcorreo_r, txclave_r, txconfclave_r;
    Button btnregistrar;
    TextView tx_login;
    ProgressBar barra_carganuevo;

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
        barra_carganuevo = (ProgressBar) findViewById(R.id.barra_carganuevo);

        mAuth = FirebaseAuth.getInstance();

        tx_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(registroActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarusuario();
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null) {
                    Abrircuenta();
                }

            }
        };


    }

    private void Abrircuenta() {
        Intent i = new Intent(registroActivity.this, principalActivity.class);
        startActivity(i);
        finish();
    }

    private void registrarusuario() {
        final String usuario = txcorreo_r.getText().toString();
        final String clave = txclave_r.getText().toString();
        final String confclave = txconfclave_r.getText().toString();

        if (!usuario.isEmpty() || !clave.isEmpty() || !confclave.isEmpty()) {
            barra_carganuevo.setVisibility(View.VISIBLE);

            if (clave.length() <= 5 || confclave.length() <= 5) {

                Toast.makeText(registroActivity.this, "La clave debe contener al menos 6 dígitos", Toast.LENGTH_LONG).show();

            } else {
                if (clave.equals(confclave) || confclave.equals(clave)) {

                    Toast.makeText(registroActivity.this, "Registrando...", Toast.LENGTH_SHORT).show();

                    mAuth.createUserWithEmailAndPassword(usuario, clave).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent i = new Intent(registroActivity.this, MainActivity.class);
                                startActivity(i);

                            } else {
                                try {
                                    throw task.getException();
                                } catch (FirebaseAuthUserCollisionException e) {
                                    Toast.makeText(registroActivity.this, "El correo ya se encuentra registrado", Toast.LENGTH_SHORT).show();
                                } catch (FirebaseNetworkException e) {
                                    Toast.makeText(registroActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Log.i("Error,reiniciar", e.getMessage());
                                }

                            }
                        }
                    });

                } else {
                    Toast.makeText(registroActivity.this, "Las claves no coinciden", Toast.LENGTH_SHORT).show();

                }

            }

        } else {
            Toast.makeText(registroActivity.this, "Completar campos", Toast.LENGTH_SHORT).show();

        }

    }


}
