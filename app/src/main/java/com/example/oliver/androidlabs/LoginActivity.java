package com.example.oliver.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    EditText username;
    final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = (EditText) findViewById(R.id.userName1);

        SharedPreferences sp1=getSharedPreferences("MyData", MODE_PRIVATE);
        final  SharedPreferences.Editor ed1=sp1.edit();
        ed1.commit();
       String s1=sp1.getString("name","email@domain.com");
       username.setText(s1);

        Button lg1=(Button) findViewById(R.id.lgn1);

        lg1.setOnClickListener(new View.OnClickListener(){
          public void onClick(View view){
              Intent ll=new Intent(getApplicationContext(),StartActivity.class);
              startActivity(ll);
              ed1.putString("name",username.getText().toString());
              ed1.commit();
            }
        });

    }

    protected void 	onResume(){super.onResume();

        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    protected void onStart(){super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");}
    protected void 	onPause(){super.onPause();

        Log.i(ACTIVITY_NAME, "In onPause()");}
    protected void 	onStop(){super.onStop();

        Log.i(ACTIVITY_NAME, "In onStop()");}
    protected void 	onDestroy(){super.onDestroy();

        Log.i(ACTIVITY_NAME, "In onDestroy()");}

}





