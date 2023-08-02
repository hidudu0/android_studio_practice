package com.cookandroid.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNewActivity = findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent);
        });
    }
    }