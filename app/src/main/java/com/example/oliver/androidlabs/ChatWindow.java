package com.example.oliver.androidlabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.FontsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.nio.charset.spi.CharsetProvider;
import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {
     EditText editText1;
    ArrayList<String> ChatList;
    LayoutInflater inflater;
    Button send;
    Cursor cursor;
    SQLiteDatabase database;
    ContentValues contentValues = new ContentValues();

String ACTIVITY_NAME ="ChatWindow";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        final ListView listview1=findViewById(R.id.ListView);


        ChatDatabaseHelper chatDatabaseHelper= new ChatDatabaseHelper(this);
        String[] allColumns = { ChatDatabaseHelper.KEY_ID, ChatDatabaseHelper.KEY_MESSAGE };
        database=chatDatabaseHelper.getWritableDatabase();
        cursor=database.query(ChatDatabaseHelper.TABLE_NAME,allColumns,null,null,null,null,null);


        editText1=findViewById(R.id.editTextChat);
        ChatList=new ArrayList<String>();
        final ChatAdapter messageAdapter =new ChatAdapter(ChatWindow.this);
        listview1.setAdapter (messageAdapter);
        messageAdapter.notifyDataSetChanged();


        cursor.moveToFirst();
        while(!cursor.isAfterLast() ) {
            Log.i(ACTIVITY_NAME, "SQL MESSAGE:" + cursor.getString(cursor.getColumnIndex(ChatDatabaseHelper.KEY_MESSAGE)));
            String ms = cursor.getString(1);
            ChatList.add(ms);
            cursor.moveToNext();
        }
        Log.i(ACTIVITY_NAME, "Cursor’s  column count =" + cursor.getColumnCount());
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatList.add(editText1.getText().toString());
                contentValues.put(ChatDatabaseHelper.KEY_MESSAGE, editText1.getText().toString());
                database.insert(ChatDatabaseHelper.TABLE_NAME, "null", contentValues);
                editText1.setText("");
                messageAdapter.notifyDataSetChanged();

            }
        });



    }
    private class ChatAdapter extends ArrayAdapter<String> {

        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        public int getCount() {
            return ChatList.size();
        }

        public String getItem(int position) {
            return ChatList.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            inflater = ChatWindow.this.getLayoutInflater();
            View result = null;
            if (position % 2 == 0)
                result = inflater.inflate(R.layout.content_chat_row_incoming, null);
            else
                result = inflater.inflate(R.layout.content_chat_row_outgoing, null);
            TextView message = (TextView) result.findViewById(R.id.message_text);
            message.setText(getItem(position)); // get the string at position
            return result;

        }

        long getId(int position) {
            return position;
        }

    }
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");}
    }
