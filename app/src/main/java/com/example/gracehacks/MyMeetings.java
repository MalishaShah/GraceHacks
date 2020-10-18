package com.example.gracehacks;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyMeetings extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymeeitngd);

        TextView infoo =  findViewById(R.id.infoo);
        Intent i = getIntent();
        String str = i.getStringExtra("info");
        infoo.setText(str);

    }
}
