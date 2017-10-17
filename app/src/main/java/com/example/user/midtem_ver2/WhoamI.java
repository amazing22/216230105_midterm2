package com.example.user.midtem_ver2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class WhoamI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whoam_i);
        Log.i("Debug", "on create who am i");

    }
    protected void onPause(){
        super.onPause();
        Log.i("Debug", "on Pause who am i");
    }

    protected void onStop(){
        super.onStop();
        Log.i("Debug", "on Stop who am i");
    }
}
