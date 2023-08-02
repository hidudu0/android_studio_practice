package com.cookandroid.project10_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;


public class SecondActivity extends Activity {

    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(v -> {
            finish();
        });
    }
    }