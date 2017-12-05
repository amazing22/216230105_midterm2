package com.example.user.midtem_ver2;

import android.app.TabActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Third1 extends AppCompatActivity {

    Handler mHandler = new Handler();
    TextView idView;
    EditText productBox;
    EditText quantityBox;
    TextView textView, textView2;
    EditText editText, editText2;
    MainHandler mainHandler;
    ProcessThread thread1;
    ImageSwitcher switcher;
    boolean running;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_third1);

            TabHost tabb = (TabHost)findViewById(R.id.tab);
            tabb.setup();

            TabHost.TabSpec tab1 = tabb.newTabSpec("1").setContent(R.id.tab1).setIndicator("one");
            TabHost.TabSpec tab4 = tabb.newTabSpec("2").setContent(R.id.tab4).setIndicator("two");
            TabHost.TabSpec tab2 = tabb.newTabSpec("4").setContent(R.id.tab2).setIndicator("three");
            TabHost.TabSpec tab3 = tabb.newTabSpec("5").setContent(R.id.tab3).setIndicator("four");


            tabb.addTab(tab1);
            tabb.addTab(tab4);
            tabb.addTab(tab2);
            tabb.addTab(tab3);

            // db생성
            idView = (TextView) findViewById(R.id.productID);
            productBox = (EditText) findViewById(R.id.productName);
            quantityBox =
                    (EditText) findViewById(R.id.productQuantity);

            // 두 개의 입력상자와 한개의 버튼을 포함하고 있으며, 첫번째 입력상자에 글자를 넣고 버튼을 누르면 입력된 메시지에 hye jin이라는 문자열을 덧붙여 두 번째 입력상자에 보여줍니다.
            // 메인 스레드에서 새로 만든 별도의 스레드로 Message 객체를 전송하고, 별도의 스레드에서 전달받은 문자열에 다른 문자열을 덧붙여 메인 스레드 쪽으로 다시 전송한다
            mainHandler = new MainHandler();
            thread1 = new ProcessThread(); // 새로 저의한 스레드 객체 생성

            textView = (TextView) findViewById(R.id.textView);
            textView2 = (TextView) findViewById(R.id.textView2);
            editText = (EditText) findViewById(R.id.editText);
            editText2 = (EditText) findViewById(R.id.editText2);


            Button processButton = (Button) findViewById(R.id.processButton);
            processButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String inStr = editText.getText().toString();
                    Message msgToSend = Message.obtain();
                    msgToSend.obj = inStr;

                    thread1.handler.sendMessage(msgToSend); // 버튼을 눌렀을 때 스레드 내의 핸들러로 메시지를 전송
                }
            });

            thread1.start();





    } //oncreate끝

    // thread예제2
    class ProcessThread extends Thread {
        ProcessHandler handler; // 스레드 내에 선언된 핸들러 객체

        public ProcessThread() {
            handler = new ProcessHandler();
        }

        public void run() { // 스레드의 run()메소드 안에서 루퍼 실행
            Looper.prepare(); // 무한 리프 방식을
            Looper.loop();
        }

    }

    class ProcessHandler extends Handler {
        public void handleMessage(Message msg) {
            Message resultMsg = Message.obtain();
            resultMsg.obj = msg.obj + " Hye jin!!!";

            mainHandler.sendMessage(resultMsg); // 스레드 내의 핸들러에서 메인 스레드의 핸들러로 메시지 전송
        }
    }

    class MainHandler extends Handler {
        public void handleMessage(Message msg) {
            String str = (String) msg.obj;
            editText2.setText(str); // 메인 스레드의 핸들러 내에서 입력상자의 메시지 표시
        }
    }
    //thread1 예제
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            String string = bundle.getString("myKey");
            TextView myTextView = (TextView)findViewById(R.id.myTextView3);
            myTextView.setText(string);
        }
    };

    public void buttonClick(View view) {
        Runnable runnable = new Runnable() {
            public void run() {
                Message msg = handler.obtainMessage();
                Bundle bundle = new Bundle();
                SimpleDateFormat dateformat =
                        new SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
                                Locale.US);
                String dateString =
                        dateformat.format(new Date());
                bundle.putString("myKey", dateString);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        };
        Thread myThread = new Thread(runnable);
        myThread.start();
    }
    // 추가
    public void newProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int quantity =
                Integer.parseInt(quantityBox.getText().toString());
        Product product =
                new Product(productBox.getText().toString(), quantity);
        dbHandler.addProduct(product);
        productBox.setText("");
        quantityBox.setText("");
    }
    // 찾기
    public void lookupProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Product product =
                dbHandler.findProduct(productBox.getText().toString());
        if (product != null) {
            idView.setText(String.valueOf(product.getID()));
            quantityBox.setText(String.valueOf(product.getQuantity()));
        } else {
            idView.setText("No Match Found");
        }
    }
    // 지우기
    public void removeProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);
        boolean result = dbHandler.deleteProduct(
                productBox.getText().toString());
        if (result)
        {
            idView.setText("Record Deleted");
            productBox.setText("");
            quantityBox.setText("");
        }
        else
            idView.setText("No Match Found");
    }
    // webview
    public void goURL(View view){
        TextView tvURL = (TextView)findViewById(R.id.txtURL);
        String url = tvURL.getText().toString();
        Log.i("URL", "Opening URL with WebView :" + url);

        final long startTime = System.currentTimeMillis();
        WebView webView = (WebView)findViewById(R.id.webView);

        // 하드웨어 가속
        // 캐쉬 끄기
        //webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                long elapsedTime = System.currentTimeMillis()-startTime;
                TextView tvSec = (TextView) findViewById(R.id.tvSec);
                tvSec.setText(String.valueOf(elapsedTime));
            }
        });
        webView.loadUrl(url);
    }

}