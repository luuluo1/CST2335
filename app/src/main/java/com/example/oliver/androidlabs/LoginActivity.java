package com.example.oliver.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupGI();
        setupGA();
    }

    private void setupGA() {
        Button b1 = (Button) findViewById(R.id.ga);
        b1.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(i1);
            }
        });
    }

    private void setupGI() {
        Button b1 = (Button) findViewById(R.id.gi);
        b1.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(LoginActivity.this, ListItemsActivity.class);
                startActivity(i1);
            }
        });
    }
}