package com.example.user.midtem_ver2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.transition.Scene;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i("Debug", "on create my app");
    }


    public void PB2(View view){

        Toast toast = Toast.makeText(getApplicationContext(), "This is after clicked in PB2", Toast.LENGTH_SHORT);
        toast.show();

        EditText aa = (EditText) findViewById((R.id.editText5));
        aa.getText();

        TextView bb = (TextView) findViewById(R.id.textView43);
        bb.setText(aa.getText());
    }

    public void PB3(View view){

        Toast toast = Toast.makeText(getApplicationContext(), "This is after clicked in PB2", Toast.LENGTH_SHORT);
        toast.show();

        EditText aa = (EditText) findViewById((R.id.editText8));
        aa.getText();

        TextView bb = (TextView) findViewById(R.id.textView44);
        bb.setText(aa.getText());
    }

    public void PB4(View view){

        Toast toast = Toast.makeText(getApplicationContext(), "This is after clicked in PB2", Toast.LENGTH_SHORT);
        toast.show();

        EditText aa = (EditText) findViewById((R.id.editText7));
        aa.getText();

        TextView bb = (TextView) findViewById(R.id.textView45);
        bb.setText(aa.getText());
    }
    public void next(View v){
        Intent i = new Intent(this, Main6Activity.class);  // 이것이 인텐트, 메시지 객체이다.
        startActivity(i);
        Log.i("Debug" , "my_app_first_create");

       }


    protected void onPause(){
        super.onPause();
        Log.i("Debug", "on Pause my app");
    }

    protected void onStop(){
        super.onStop();
        Log.i("Debug", "on Stop my app");
    }



}
