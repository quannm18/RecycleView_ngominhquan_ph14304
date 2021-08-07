package com.example.recycleview_ngominhquan_ph14304;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentSQLite extends SQLiteOpenHelper {
    public static final String TABLE_NAME ="student";
    public static final String ID ="id";
    public static final String NAME ="name";
    public static final String NUMBER ="number";

    public static String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("
            +ID+" VARCHAR PRIMARY KEY,"+NAME+" VARCHAR,"+NUMBER+" INT)";

    public StudentSQLite(Context context){
        super(context,"student.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
}
