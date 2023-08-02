package com.cookandroid.practice8_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class myPictureView extends View {

    // myPictureView 에 보여줄 이미지 파일의 경로 및 파일 이름을 저장할 변수
    String imagePath = null;

    public myPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // imagePath 에 값이 있으면 화면에 그림 파일을 출력함
        if(imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            canvas.drawBitmap(bitmap, 0, 0, null);
            bitmap.recycle();
        }
    }
