package com.example.oliver.androidlabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ListItemsActivity extends Activity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageButton b1;
    Switch s1;
    CheckBox ch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        goL();
        goA();


      b1=(ImageButton) findViewById(R.id.img1);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }

            }
        });

        s1=(Switch) findViewById(R.id.switch3);
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CharSequence text;
                int duration ;

                if(s1.isChecked()) {
                    text = "Switch is On";
                    duration = Toast.LENGTH_SHORT;
                }else {
                    text = "Switch is Off";
                    duration = Toast.LENGTH_LONG;
                }
                 //this is the ListActivity
                Toast toast = Toast.makeText(getApplicationContext(),text,duration);
                toast.show(); //display your message box

            }
        });

        ch1=(CheckBox) findViewById(R.id.checkBox6);
        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(ch1.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                        // 2. Chain together various setter methods to set the dialog characteristics
                    TextView t1 = findViewById(R.id.tv1);
                    Button b1=findViewById(R.id.bb1);
                    Button b2=findViewById(R.id.bb2);

                    builder.setMessage("quiting?")
                            .setTitle("are you")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User clicked OK button
                                    finish();
                                }
                            })
                            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User cancelled the dialog
                                }
                            })
                            .show();


                }
            }
        });


    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
          b1.setImageBitmap(imageBitmap);
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




    private void goL(){
        Button b1=(Button) findViewById(R.id.buttonGL);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i1=new Intent(getApplicationContext(),LoginActivity.class);
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
