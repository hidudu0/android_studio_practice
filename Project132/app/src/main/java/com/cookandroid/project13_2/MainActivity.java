package com.cookandroid.project13_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(this, R.raw.song1);

        final Switch switch1 = (Switch) findViewById(R.id.switch1);
        SeekBar pbMP3 = (SeekBar) findViewById(R.id.pbMP3);


        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch1.isChecked()){
                    mPlayer.start();

                    new Thread() {
                        public void run() {
                            if (mPlayer == null) return;
                            pbMP3.setMax(mPlayer.getDuration());
                            while (mPlayer.isPlaying()) {
                                pbMP3.setProgress(mPlayer.getCurrentPosition());
                                SystemClock.sleep(200);
                            }
                            pbMP3.setProgress(0);
                        }
                    }.start();

                }
                else{mPlayer.stop();}
            }
        });
        pbMP3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){mPlayer.seekTo(progress);}
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });
    }
}