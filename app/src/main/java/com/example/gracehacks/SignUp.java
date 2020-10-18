package com.example.gracehacks;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    EditText Email;
    EditText Pass;
    EditText Name;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.regEmail);
        Pass = findViewById(R.id.regPass);
        Name = findViewById(R.id.regName);
        signIn = findViewById(R.id.signIn);

    }
}
