package com.example.oliver.androidlabs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import java.security.Key;

/**
 * Created by oliver on 2/25/2018.
 */
public class ChatDatabaseHelper extends SQLiteOpenHelper {

   public static final String DATABASE_NAME = "Messages.db";
    public static final  int VERSION_NUM = 101;
    public static final   String KEY_ID = "_id";
    public static final  String KEY_MESSAGE="Message" ;
    public static final String TABLE_NAME ="messages_table";
    private static final String TABLE_CREATE = "CREATE TABLE "
            + TABLE_NAME
            + "( "
            + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_MESSAGE
              + " text ,"
              + ");";

    ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE messages_table (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_MESSAGE + " text);");
        Log.i("ChatDatabaseHelper", "Calling onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS messages_table");
        onCreate(sqLiteDatabase);
        Log.i("ChatDatabaseHelper", "Calling onUpgrade, oldVersion=" + i + " newVersion=" + i1);
    }
}