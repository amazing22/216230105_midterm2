package com.example.user.midtem_ver2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class Personality extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality);
        Log.i("Debug", "on create personality");


    }


    protected void onPause(){
        super.onPause();
        Log.i("Debug", "on Pause personality");
    }

    protected void onStop(){
        super.onStop();
        Log.i("Debug", "on Stop personality");
    }
}
