package com.example.oliver.androidlabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    setupGL();
    setupGI();
    }

    private void setupGL(){
        Button b1=(Button) findViewById(R.id.buttonGL);
        b1.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(StartActivity.this,LoginActivity.class);
                startActivity(i1);
            }
        });}
    private void setupGI(){
        Button b1=(Button) findViewById(R.id.buttonGI);
        b1.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(StartActivity.this,ListItemsActivity.class);
                startActivity(i1);
            }
        });
        
    }
}
