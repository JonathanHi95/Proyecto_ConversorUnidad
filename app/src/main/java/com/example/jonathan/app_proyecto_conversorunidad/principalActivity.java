package com.example.jonathan.app_proyecto_conversorunidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class principalActivity extends AppCompatActivity {

    Button btn1;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btn1 = (Button) findViewById(R.id.button2);
        mAuth = FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(principalActivity.this,MainActivity.class);
                Toast.makeText(principalActivity.this,"Saliendo...",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }
}
