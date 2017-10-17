package com.example.user.midtem_ver2;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class introduce extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        Log.i("Debug", "introduce_start");
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(introduce.this, Main3Activity.class);
                startActivity(intent);
            }
        });


    }


    public void who(View v) {
        Intent i = new Intent(this, WhoamI.class);  // 이것이 인텐트, 메시지 객체이다.
        Log.i("Debug" , "personality_create");
        startActivity(i);
    }

//    public void who(View v){ // 이건 그냥 메소드이름이예요.
//        ViewGroup vg = (ViewGroup) findViewById(R.id.lay1);
//        Scene s = Scene.getSceneForLayout(vg, R.layout.activity_personality, this);
//        Log.i("Debug" , "personality_create");
//        s.enter();
//    }

    public void per(View v) {
        Intent i = new Intent(this, Personality.class);  // 이것이 인텐트, 메시지 객체이다.
        startActivity(i);
    }

    public void goo(View v) {
        Intent i = new Intent(this, Map.class);  // 이것이 인텐트, 메시지 객체이다.
        startActivity(i);
        Log.i("Debug", "introduce_page_create");
    }

    protected void onPause(){
        super.onPause();
        Log.i("Debug", "on Pause");
    }

    protected void onStop(){
        super.onStop();
        Log.i("Debug", "on Stop");
    }



}

