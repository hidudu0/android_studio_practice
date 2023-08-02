package com.cookandroid.practice8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btnPrev, btnNext;
    myPictureView myPictureView;
    int num = 1;
    File[] imageFiles;
    String imageFname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        myPictureView = findViewById(R.id.myPictureView);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/Pictures").listFiles();
        imageFname = imageFiles[1].toString();
        myPictureView.imagePath = imageFname;

        btnPrev.setOnClickListener(v -> {
            if(num <= 1){
                Toast.makeText(getApplicationContext(), "첫번째 그림입니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                num--;
                imageFname = imageFiles[num].toString();
                myPictureView.imagePath = imageFname;
                myPictureView.invalidate();
            }
        });

        btnNext.setOnClickListener(v -> {
            if(num >= imageFiles.length - 1){
                Toast.makeText(getApplicationContext(), "마지막 그림입니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                num++;
                imageFname = imageFiles[num].toString();
                myPictureView.imagePath = imageFname;
                myPictureView.invalidate();
            }
        });
    }
}