package com.cookandroid.practice9_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton zoomin,zoomout,zoombright,zoomdark,zoomrotate,b,e;
    MyGraphicView graphicView;
    static float scaleX=1,scaleY=1,angle=0,color=1,satur=1;
    static boolean blur=false;
    static boolean em=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        LinearLayout pictureLayout=(LinearLayout)findViewById(R.id.pictureLayout);
        graphicView=(MyGraphicView)new MyGraphicView(this);
        pictureLayout.addView(graphicView);
        clickIcons();
    }

    public void clickIcons() {
        zoomin=(ImageButton)findViewById(R.id.zoomin);
        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX=scaleX+0.2f;
                scaleY=scaleY+0.2f;
                graphicView.invalidate();
            }
        });
        zoomout=(ImageButton)findViewById(R.id.zoomout);
        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleX=scaleX-0.2f;
                scaleY=scaleY-0.2f;
                graphicView.invalidate();
            }
        });
        zoomrotate=(ImageButton)findViewById(R.id.rotate);
        zoomrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle=angle+20;
                graphicView.invalidate();
            }
        });
        zoombright=(ImageButton)findViewById(R.id.zoombright);
        zoombright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                satur=satur+0.2f;
                graphicView.invalidate();
            }
        });
        zoomdark=(ImageButton)findViewById(R.id.zoomdark);
        zoomdark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                satur=satur-0.2f;
                graphicView.invalidate();
            }
        });
        b=(ImageButton)findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(blur==true){
                  blur=false;
              }
              else{
                  blur=true;
              }
              graphicView.invalidate();
            }
        });

        e=(ImageButton)findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(em=true){
                    em=false;
                }
                else{
                    em=true;
                }
                graphicView.invalidate();
            }
        });
    }


    private class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX=this.getWidth()/2;
            int cenY=this.getHeight()/2;
            canvas.scale(scaleX,scaleY,cenX,cenY);
            canvas.rotate(angle,cenX,cenY);

            Paint paint=new Paint();
            float[] array={color,0,0,0,0,
                    0,color,0,0,0,
                    0,0,color,0,0,
                    0,0,0,1,0};
            ColorMatrix cm=new ColorMatrix(array);
            cm.setSaturation(satur);

            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            if(blur==true)
            {
                BlurMaskFilter bMask;
                bMask = new BlurMaskFilter(30,BlurMaskFilter.Blur.NORMAL);
                paint.setMaskFilter(bMask);
            }
            if(em==true)
            {
                EmbossMaskFilter eMask;
                eMask=new EmbossMaskFilter(new float[] {3,3,3}, 0.5f, 5, 10);
                paint.setMaskFilter(eMask);
            }

            Bitmap picture= BitmapFactory.decodeResource(getResources(),R.drawable.hip);
            int picX=(this.getWidth()-picture.getWidth())/2;
            int picY=(this.getHeight()-picture.getHeight())/2;
            canvas.drawBitmap(picture,picX,picY,paint);
            picture.recycle();
        }
    }
}