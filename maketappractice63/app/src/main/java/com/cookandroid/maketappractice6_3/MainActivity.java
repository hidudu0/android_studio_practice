package com.cookandroid.maketappractice6_3;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabDog = tabHost.newTabSpec("Dog").setIndicator("강아지");
        tabDog.setContent(R.id.tabDog);
        tabHost.addTab(tabDog);

        TabHost.TabSpec tabCat = tabHost.newTabSpec("Cat").setIndicator("고양이");
        tabCat.setContent(R.id.tabCat);
        tabHost.addTab(tabCat);

        TabHost.TabSpec tabRabbit = tabHost.newTabSpec("Rabbit").setIndicator("토끼");
        tabRabbit.setContent(R.id.tabRabbit);
        tabHost.addTab(tabRabbit);

        tabHost.setCurrentTab(0);
    }
}