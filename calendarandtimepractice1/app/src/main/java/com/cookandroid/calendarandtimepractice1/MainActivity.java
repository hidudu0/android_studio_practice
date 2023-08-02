package com.cookandroid.calendarandtimepractice1;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer1;
    Button btnStart, btnEnd;
    RadioButton rbCal, rbTime;
    CalendarView calendarView1;
    TimePicker timePicker1;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");
        chronometer1 = findViewById(R.id.chronometer1);
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        rbCal = findViewById(R.id.rdoCal);
        rbTime = findViewById(R.id.rdoTime);
        calendarView1 = findViewById(R.id.calendarView1);
        timePicker1 = findViewById(R.id.timePicker1);
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        timePicker1.setVisibility(View.INVISIBLE);
        calendarView1.setVisibility(View.INVISIBLE);

        rbCal.setOnClickListener(v -> {
            timePicker1.setVisibility(View.INVISIBLE);
            calendarView1.setVisibility(View.VISIBLE);
        });
        rbTime.setOnClickListener(v -> {
            timePicker1.setVisibility(View.VISIBLE);
            calendarView1.setVisibility(View.INVISIBLE);
        });

        btnStart.setOnClickListener(v -> {
            chronometer1.setBase(SystemClock.elapsedRealtime());
            chronometer1.start();
            chronometer1.setTextColor(Color.RED);
        });
        btnEnd.setOnClickListener(v -> {
            chronometer1.stop();
            chronometer1.setTextColor(Color.BLUE);

            tvYear.setText(Integer.toString(selectYear));
            tvMonth.setText(Integer.toString(selectMonth));
            tvDay.setText(Integer.toString(selectDay));

            tvHour.setText(Integer.toString(timePicker1.getCurrentHour()));
            tvMinute.setText(Integer.toString(timePicker1.getCurrentMinute()));
        });
        calendarView1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });
    }
}