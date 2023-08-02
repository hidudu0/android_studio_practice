package com.cookandroid.project9_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(50);
            canvas.drawLine(50, 50, 600, 50, paint);

            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(50, 150, 600, 150, paint);

            RectF rectF = new RectF();
            rectF.set(100, 200, 100 + 400, 100 + 200);
            canvas.drawOval(rectF, paint);

            rectF.set(100, 300, 100 + 200, 300 + 200);
            canvas.drawArc(rectF, 40, 110, true, paint);

            paint.setColor(Color.BLUE);
            rectF.set(100, 600, 100 + 200, 600 + 200);
            canvas.drawRect(rectF, paint);

            paint.setColor(Color.argb(0x88, 0xff, 0x00, 0x00));
            rectF.set(150, 650, 150 + 200, 650 + 200);
            canvas.drawRect(rectF, paint);
        }
    }
}