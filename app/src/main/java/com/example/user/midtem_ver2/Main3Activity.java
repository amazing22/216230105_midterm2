package com.example.user.midtem_ver2;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.i("Debug", "on create slider");

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(6);
        Adapter adapter = new Adapter(this);
        viewPager.setAdapter(adapter);
    }
    protected void onPause(){
        super.onPause();
        Log.i("Debug", "on Pause slider");
    }

    protected void onStop(){
        super.onStop();
        Log.i("Debug", "on Stop slider");
    }
}
// 1. 슬라이드를 만들기 위해 viewPager을 만든다.
// 2. setOffscreanPageLimit(6)을 하여 양쪽으로 유지되는 페이지를 만든다. 나는 6개의 페이지가 있기때문에 6이라 하였다.
// 3. Adapter을 불러와 viewPager에 올리게 한다.