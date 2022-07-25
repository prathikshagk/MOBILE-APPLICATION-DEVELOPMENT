package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1,e2;
    String entered_username;
    String entered_password;
    Pattern pattern;
    Matcher matcher;
    private static final String PREG="^((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@%#]).{6,10})";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.bt1);
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        pattern=Pattern.compile(PREG);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                entered_username=e1.getText().toString();
                entered_password=e2.getText().toString();
                matcher= pattern.matcher(entered_password);
                if(!matcher.matches())
                {
                    System.out.println("WRONG PASSWORD");

                }
                else
                {
                    System.out.println("CORRECT PASSWORD");
                    intent.putExtra("un",entered_username);
                    intent.putExtra("pwd",entered_password);
                    startActivity(intent);
                }
            }
        });
    }
}