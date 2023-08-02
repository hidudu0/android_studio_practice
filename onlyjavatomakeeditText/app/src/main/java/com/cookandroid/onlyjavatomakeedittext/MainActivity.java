package com.cookandroid.onlyjavatomakeedittext;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout,params);

        EditText edt = new EditText(this);
        baseLayout.addView(edt);

        Button btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn);

        TextView text1 = new TextView(this);
        baseLayout.addView(text1);
        text1.setVisibility(View.INVISIBLE);
        text1.setTextColor(Color.MAGENTA);
        text1.setTextSize(Dimension.SP,40);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                text1.setVisibility(View.VISIBLE);
                String num1 = edt.getText().toString();
                text1.setText(num1.toString());
            }
        });
    }
}