package com.example.oliver.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);  final String ACTIVITY_NAME = "CreateActivity";
        Log.i(ACTIVITY_NAME, "In onCreate()");

        Button b1=(Button) findViewById(R.id.buttonGL);
        b1.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(StartActivity.this,LoginActivity.class);
                startActivity(i1);
            }
        });
        Button b2=(Button) findViewById(R.id.buttonGI);
        b2.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View view) {
                Intent i2= new Intent(StartActivity.this,ListItemsActivity.class);
                startActivityForResult(i2,50);

            }
        });
    }

    @Override
    protected  void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 50 )
        {      Log.i("ListItemActivity", "Returned to StartActivity.onActivityResult");
    }
    }

    protected void 	onResume(){super.onResume();
       final String ACTIVITY_NAME = "ResumeActivity";
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    protected void onStart(){super.onStart();  final String ACTIVITY_NAME = "StartActivity";
        Log.i(ACTIVITY_NAME, "In onStart()");}
    protected void 	onPause(){super.onPause();
         final String ACTIVITY_NAME = "PauseActivity";
        Log.i(ACTIVITY_NAME, "In onPause()");}
    protected void 	onStop(){super.onStop();
        final String ACTIVITY_NAME = "StopActivity";
        Log.i(ACTIVITY_NAME, "In onStop()");}
    protected void 	onDestroy(){super.onDestroy();
        final String ACTIVITY_NAME = "DestroyActivity";
        Log.i(ACTIVITY_NAME, "In onDestroy()");}

}
