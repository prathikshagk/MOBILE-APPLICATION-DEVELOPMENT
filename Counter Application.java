package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText cnt;
Button start;
Button stop;
int i=1;
Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnt=(EditText) findViewById(R.id.Counter);
        start=(Button) findViewById(R.id.Start);
        stop=(Button) findViewById(R.id.Stop);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(runnable,0);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
            }
        });
    }
    private final Runnable runnable=new Runnable() {
        @Override
        public void run() {
            cnt.setText(""+i);
            handler.postDelayed(runnable,1000);
            i++;
        }
    };
}