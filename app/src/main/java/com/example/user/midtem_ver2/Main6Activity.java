package com.example.user.midtem_ver2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Timer;
import java.util.TimerTask;


public class Main6Activity extends AppCompatActivity implements View.OnClickListener {
    DatePicker mDate;
    TimePicker mTime;
    TextView mTxtDate;
    Switch startswitch,endswitch;
    FrameLayout framelayout;
    int page = 0;
    int tt = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        findViewById(R.id.button10).setOnClickListener(this);
        mDate = (DatePicker)findViewById(R.id.datepicker);
        mTime = (TimePicker)findViewById(R.id.timePicker2 );
        startswitch = (Switch)findViewById(R.id.switch1);
        endswitch = (Switch)findViewById(R.id.switch2);
        framelayout = (FrameLayout)findViewById(R.id.frame);

       startswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(startswitch.isChecked())
                {
                    tt = 0;
                    page = 0;
                    framelayout.setVisibility(View.VISIBLE);
                    mDate.setVisibility(View.VISIBLE);
                    mTime.setVisibility(View.INVISIBLE);

                }
                else
                {
                    tt = 0;
                    page = 0;
                    framelayout.setVisibility(View.INVISIBLE);
                    mDate.setVisibility(View.INVISIBLE);
                    mTime.setVisibility(View.INVISIBLE);
                }
            }
    });

        endswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(endswitch.isChecked())
                {
                    tt = 0;
                    page = 0;
                    framelayout.setVisibility(View.VISIBLE);
                    mDate.setVisibility(View.INVISIBLE);
                    mTime.setVisibility(View.VISIBLE);

                }
                else
                {
                    tt = 0;
                    page = 0;
                    framelayout.setVisibility(View.INVISIBLE);
                    mDate.setVisibility(View.INVISIBLE);
                    mTime.setVisibility(View.INVISIBLE);
                }
            }
        });

        //처음 DatePicker를 오늘 날짜로 초기화한다.
        //그리고 리스너를 등록한다.


    }
    public void onClick(View v){


        switch (v.getId()){
            case R.id.button10:
                new AlertDialog.Builder(this)
                        .setTitle("알림 팝업")
                        .setMessage("정보가 입력되었습니다. \n\n 감사합니다!")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dig, int sumthin){
                                Intent intent = new Intent(Main6Activity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .show();
                break;
        }
    }
}
// survey페이지 2번째꺼