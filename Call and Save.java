package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
Button call_button,save_button;
EditText phoneNumberEditText;
Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call_button=(Button) findViewById(R.id.CALL);
        save_button=(Button) findViewById(R.id.SAVE);
        bt1=(Button)findViewById(R.id.b1);
        phoneNumberEditText=(EditText) findViewById(R.id.Phone_Number);
        ////bt1.setOnClickListener(new View.OnClickListener());
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call_intent=new Intent(Intent.ACTION_DIAL);
                call_intent.setData(Uri.parse("tel:8971197216"));
                startActivity(call_intent);
            }
        });
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,"8971197217");
                startActivity(intent);
            }
        });
    }
    public void entered_number(View V){
        Button button=(Button) V;
        String digit=button.getText().toString();
        String phonenumber=phoneNumberEditText.getText().toString();
    phoneNumberEditText.setText(phonenumber +digit);
    }
}