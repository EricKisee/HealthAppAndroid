package com.erickisee.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText edFirstName, edLastName, edEmail, edUsername, edPassword;
    Button btnRegister;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init () {
        edFirstName = findViewById(R.id.editTextFirstName);
        edLastName = findViewById(R.id.editTextLastName);
        edEmail = findViewById(R.id.editTextEmail);
        edUsername = findViewById(R.id.editTextUsername);
        edPassword = findViewById(R.id.editTextPassword);
        tvLogin = findViewById(R.id.textViewLogin);
        btnRegister = findViewById(R.id.buttonRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName, lastName, email, username, password;
                firstName = edFirstName.getText().toString();
                lastName = edLastName.getText().toString();
                email = edEmail.getText().toString();
                username = edUsername.getText().toString();
                password = edPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "HealthCare", null, 1);
                if(firstName.length()==0 ||lastName.length()==0 ||email.length()==0 ||username.length()==0 ||password.length()==0){

                }else{
                    db.register(username,email,password);

                    startActivity(new Intent(RegisterActivity.this, Login.class));
                }

            }
        });
    }
}