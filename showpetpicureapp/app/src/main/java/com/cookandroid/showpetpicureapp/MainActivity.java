package com.cookandroid.showpetpicureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox check1;
    TextView text1, text2;
    RadioGroup radioGroup;
    RadioButton rbtn1, rbtn2, rbtn3;
    Button btn1;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("애완동물 사진보기");
        check1=(CheckBox) findViewById(R.id.check1);
        text1= (TextView) findViewById(R.id.Text1);
        text2= (TextView) findViewById(R.id.Text2);
        radioGroup= (RadioGroup) findViewById(R.id.Rgroup1);
        rbtn1= findViewById(R.id.rbtn1);
        rbtn2= findViewById(R.id.rbtn2);
        rbtn3= findViewById(R.id.rbtn3);
        btn1=findViewById(R.id.btn1);
        image=findViewById(R.id.image);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rbtn1)
                {
                    image.setImageResource(R.drawable.dog);
                }
                else if(i==R.id.rbtn2)
                {
                    image.setImageResource(R.drawable.cat);
                }
                else
                {
                    image.setImageResource(R.drawable.rabbit);
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioGroup.getCheckedRadioButtonId())
                {
                    case R.id.rbtn1 : image.setImageResource(R.drawable.dog);
                    break;
                    case R.id.rbtn2 : image.setImageResource(R.drawable.cat);
                    break;
                    case R.id.rbtn3 : image.setImageResource(R.drawable.rabbit);
                    break;
                }
            }
        });

        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==true)
                {
                    text2.setVisibility((View.VISIBLE));
                    radioGroup.setVisibility(View.VISIBLE);
                    btn1.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                }
                else
                {
                    text2.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    btn1.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}