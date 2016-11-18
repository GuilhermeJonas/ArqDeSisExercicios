package com.usjt.guilherme.caixaeletronico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by guilherme on 23/10/16.
 */
public class MenuActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_menu);

        Button buttonExtrato = (Button) findViewById(R.id.buttonExtrato);
        buttonExtrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ExtratoActivity.class);
                startActivity(intent);
            }
        });

        Button buttonSaque = (Button) findViewById(R.id.buttonSaque);
        buttonSaque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SaqueActivity.class);
                startActivity(intent);
            }
        });
    }
}