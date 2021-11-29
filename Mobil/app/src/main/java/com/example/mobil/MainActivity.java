package com.example.mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_adsoyad;
    TextView tv_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_adsoyad=(TextView) findViewById(R.id.tv_adsoyad);
        tv_adsoyad.setText("Esma Barutcu");

        tv_no=(TextView) findViewById(R.id.tv_no);
        tv_no.setText("201813709029");
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(MainActivity.this, Kisiler.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();


    }
}


