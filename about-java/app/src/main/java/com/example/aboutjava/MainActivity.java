package com.example.aboutjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.midi.MidiDeviceService;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button inheritance;
    Button abstraction;
    Button polymorphism;
    Button encapsulation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inheritance = (Button) findViewById(R.id.inheritance);
        inheritance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1 = new Intent(MainActivity.this, InheritanceJava.class);
                startActivity(i1);
            }
        });

        abstraction = (Button) findViewById(R.id.abstraction);
        abstraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(MainActivity.this, AbstractionJava.class);
                startActivity(i2);
            }
        });

        polymorphism = (Button) findViewById(R.id.polymorhism);
        polymorphism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i3 = new Intent(MainActivity.this, PolymorsphismJava.class);
                startActivity(i3);
            }
        });

        encapsulation = (Button) findViewById(R.id.encapsulation);
        encapsulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i4 = new Intent(MainActivity.this, EncapsulationJava.class);
                startActivity(i4);
            }
        });
    }
}
