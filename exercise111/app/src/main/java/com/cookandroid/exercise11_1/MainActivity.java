package com.cookandroid.exercise11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private ListView listView;
    final String[] mid = {"히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크", "빅뱅이론",
            "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "내추럴", "브이"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, mid);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), mid[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}