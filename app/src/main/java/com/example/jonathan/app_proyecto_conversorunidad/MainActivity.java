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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button btningresar;
    private ProgressBar barraprogreso;
    private AutoCompleteTextView txusuario, txclave;
    private TextView et1;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txusuario = (AutoCompleteTextView) findViewById(R.id.userEmail);
        txclave = (AutoCompleteTextView) findViewById(R.id.userPassword);
        et1 = (TextView) findViewById(R.id.txnuevo);
        barraprogreso = (ProgressBar) findViewById(R.id.barracarga);
        btningresar = (Button) findViewById(R.id.btningresar);

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        barraprogreso.setVisibility(View.INVISIBLE);
        btningresar.setVisibility(View.VISIBLE);
        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, registroActivity.class);
                startActivity(intent);
            }
        });

        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = txusuario.getText().toString();
                password = txclave.getText().toString();

                email = email.trim();
                password = password.trim();


                if (email.isEmpty() || password.isEmpty()) {
                    barraprogreso.setVisibility(View.INVISIBLE);
                    btningresar.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Completar campos", Toast.LENGTH_SHORT).show();
                } else {

                  mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this,new  OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {

                          try {
                              throw task.getException();
                          } catch (FirebaseAuthInvalidUserException e) {
                              Toast.makeText(MainActivity.this, "Usuario inválido", Toast.LENGTH_SHORT).show();
                          } catch (FirebaseAuthInvalidCredentialsException e) {

                              Toast.makeText(MainActivity.this, "Clave inválida ", Toast.LENGTH_SHORT).show();
                          } catch (FirebaseNetworkException e) {
                              Toast.makeText(MainActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
                          } catch (Exception e) {
                              Log.i("Error,reiniciar", e.getMessage());
                          }

                      }

                  });

                    barraprogreso.setVisibility(View.INVISIBLE);
                    btningresar.setVisibility(View.VISIBLE);
                }

            }


        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                    Toast.makeText(MainActivity.this, "Bienvenido!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, principal.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {

                }
            }
        };


    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
