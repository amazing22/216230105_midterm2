package com.example.user.midtem_ver2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondTabbed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_tabbed);
    }
    public void one(View v) {
        Intent i = new Intent(this, MainActivity.class);  // 이것이 인텐트, 메시지 객체이다.
        startActivity(i);
    }
    public void two(View v) {
        Intent i = new Intent(this, Third1.class);  // 이것이 인텐트, 메시지 객체이다.
        startActivity(i);
    }


}


