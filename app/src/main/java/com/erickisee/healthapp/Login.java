package com.erickisee.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btnLogin;
    TextView tvRegister;

    private final String TAG = "LOGIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init(){
        edPassword = findViewById(R.id.editTextPassword);
        edUsername = findViewById(R.id.editTextUsername);
        btnLogin = findViewById(R.id.buttonLogin);
        tvRegister = findViewById(R.id.textViewRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: Button clicked");

                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "HealthCare" , null , 1);

                if(username.length()==0||password.length()==0){
                    Log.d(TAG, "onClick: No text provided");
                }else{
                    Log.d(TAG, "onClick: Text provided");
                    if(db.login(username,password)==1) {
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username" , username);
                        editor.apply();
                        startActivity(new Intent(Login.this, MainActivity.class));
                    } else {
                        Log.d(TAG, "onClick: Invalid Username or Password");
                    }
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, RegisterActivity.class));
            }
        });
    }
}