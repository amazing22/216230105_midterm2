package com.example.user.midtem_ver2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Toast;
 // scene exam 이용
public class Activity_Scene extends AppCompatActivity {
    ViewGroup lay1;
    Scene scene1;
    Scene scene2;
    Scene scene3;
     Scene scene4;
    Transition transitionMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__scene);

        lay1 =(ViewGroup) findViewById(R.id.lay1);

        transitionMgr = TransitionInflater.from(this).inflateTransition(R.transition.transition);

        scene1 = Scene.getSceneForLayout(lay1, R.layout.scene1, this);

        scene2 = Scene.getSceneForLayout(lay1, R.layout.scene2, this);

        scene3 = Scene.getSceneForLayout(lay1, R.layout.scene3, this);

        scene4 = Scene.getSceneForLayout(lay1, R.layout.scene4, this);

        scene4.enter();

    }

     public void goToScene6 (View view)
     {
         TransitionManager.go(scene4);
//        Toast.makeText(getApplicationContext(),
//                "장면 전환 2에 도달함", Toast.LENGTH_LONG).show();

     }

     public void goToScene4 (View view)
     {
         TransitionManager.go(scene1, transitionMgr);
//        Toast.makeText(getApplicationContext(),
//                "장면 전환 2에 도달함", Toast.LENGTH_LONG).show();

     }

    public void goToScene2 (View view)
    {
        TransitionManager.go(scene2, transitionMgr);
//        Toast.makeText(getApplicationContext(),
//                "장면 전환 2에 도달함", Toast.LENGTH_LONG).show();

    }

    public void goToScene3 (View view)
    {
        TransitionManager.go(scene3, transitionMgr);
//        Toast.makeText(getApplicationContext(),
//                "장면 전환 2에 도달함", Toast.LENGTH_LONG).show();

    }

    public void goToScene1 (View view)
    {
        TransitionManager.go(scene1, transitionMgr);
    }
}
// scene 이용 예제
// 0. trasition.xml과 함께 이용한다.