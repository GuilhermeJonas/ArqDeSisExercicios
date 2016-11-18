package com.usjt.guilherme.caixaeletronico.caixaeletronico.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.usjt.guilherme.caixaeletronico.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        //ReferÃªncia da intent da tela do menu
        final Intent intentMenu = new Intent(this, MenuActivity.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intentMenu);
            }
        });
    }

}
