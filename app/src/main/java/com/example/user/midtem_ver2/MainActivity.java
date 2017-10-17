package com.example.user.midtem_ver2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Debug" , "on createindex");
    }
    public void inrtoduce(View v){
        Intent i = new Intent(this, introduce.class);  // 이것이 인텐트, 메시지 객체이다.
        startActivity(i);
    }

    public void app(View v){
        Intent i = new Intent(this, Main2Activity.class);  // 이것이 인텐트, 메시지 객체이다.
        startActivity(i);
    }
    public void fragment(View v){
        Intent i = new Intent(this, Main4Activity.class);  // 이것이 인텐트, 메시지 객체이다.
        startActivity(i);
    }

    public void scene(View v){
        Intent i = new Intent(this, Activity_Scene.class);  // 이것이 인텐트, 메시지 객체이다.
        startActivity(i);
    }

    public void next(View v){
        Intent i = new Intent(this, Main5Activity.class);  // 이것이 인텐트, 메시지 객체이다.
        startActivity(i);
    }

    protected void onPause(){
        super.onPause();
        Log.i("Debug", "on Pause index");
    }

    protected void onStop(){
        super.onStop();
        Log.i("Debug", "on Stop index");
    }
}
