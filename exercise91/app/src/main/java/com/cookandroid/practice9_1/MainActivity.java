package com.cookandroid.practice9_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // XML 파일 대신 재정의한 클래스를 화면에 보여줌
        setContentView(new MyGraphicView(this));
    }

    // View 클래스를 상속받아 MyGraphicView 클래스를 재정의
    private static class MyGraphicView extends View {
        // 재정의한 클래스의 생성자
        public MyGraphicView(Context context) {
            super(context);
        }

        // 클래스가 생성되거나 무효화(invalidate)되면 호출되는 메서드
        // 일반적으로 화면에 그려질 내용을 이곳에 코딩함
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            // 도형의 끝을 부드럽게 처리해줌
            paint.setAntiAlias(true);
            // 그려질 도형의 색을 paint 에 지정
            paint.setColor(Color.GREEN);
            // 선을 그림. 시작x, 시작y, 끝x, 끝y, Paint 로 파라미터는 5개임
            canvas.drawLine(10, 10, 300, 10, paint);

            paint.setColor(Color.BLUE);
            // 그려질 도형 또는 글자 외곽선의 두께를 설정함. 0으로 설정하면 기본인 1px로 지정됨
            paint.setStrokeWidth(10);
            canvas.drawLine(20, 60, 600, 60, paint);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(0);

            paint.setStyle(Paint.Style.FILL);
            Rect rect1 = new Rect(20, 100, 20 + 200, 100 + 200);
            canvas.drawRect(rect1, paint);

            paint.setStyle(Paint.Style.STROKE);
            Rect rect2 = new Rect(260, 100, 260 + 200, 100 + 200);
            canvas.drawRect(rect2, paint);

            RectF rect3 = new RectF(500, 100, 500 + 200, 100 + 200);
            // 사각형의 모서리를 둥글게 처리함
            canvas.drawRoundRect(rect3, 40, 40, paint);

            // 원을 그림, 중심x, 중심y, 반지름, Paint 로 파라미터는 4개임
            canvas.drawCircle(120, 440, 100, paint);
            paint.setStrokeWidth(10);

            // Path 는 연결된 여러 점을 가진 클래스
            // moveTo( ) 메서드로 해당 점으로 이동한 다음 lineTo( ) 메서드로 점을 계속 추가함
            Path path = new Path();
            path.moveTo(20, 580);
            path.lineTo(20 + 100, 580 + 100);
            path.lineTo(20 + 200, 580);
            path.lineTo(20 + 300, 580 + 100);
            path.lineTo(20 + 400, 580);
            // 생성한 Path 를 그림
            canvas.drawPath(path, paint);

            paint.setStrokeWidth(0);
            paint.setTextSize(60);
            canvas.drawText("안드로이드", 20, 780, paint);
        }
    }
}