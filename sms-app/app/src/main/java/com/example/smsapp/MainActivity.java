package com.example.smsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.btnSms);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage("9172500576", null, "Hello Aditya", null, null);
                Intent i1 = new Intent(Intent.ACTION_CALL);
                i1.setData((Uri.parse("tel:9359342557")));

                startActivity(i1);
            }
        });
    }
}