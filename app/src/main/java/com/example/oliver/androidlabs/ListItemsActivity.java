package com.example.oliver.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListItemsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        goL();
        goA();
    }


    private void goL(){
        Button b1=(Button) findViewById(R.id.buttonGL);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(ListItemsActivity.this,LoginActivity.class);
                startActivity(i1);
            }
        });}
        private void goA(){
    Button b1=(Button) findViewById(R.id.buttonGA);
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i1=new Intent(ListItemsActivity.this,StartActivity.class);
            startActivity(i1);
        }
    });


    }


}
