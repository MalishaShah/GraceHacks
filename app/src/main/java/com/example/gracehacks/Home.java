package com.example.gracehacks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    TextView receive_name;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        receive_name = (TextView)findViewById(R.id.username2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        receive_name.setText(name);

        search = findViewById(R.id.searchDoc);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), DocList.class);
                startActivity(intent1);
            }
        });
    }
}

