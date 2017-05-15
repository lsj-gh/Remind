package com.example.administrator.mapleone.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    public static final String CREAT_BOOK = "create table Book (" + "id integer primary key autoincrement, " +
            "author text," + "price real," + "pages integer," + "name text)";
    public static final String CREAT_STUDENT = "create table Student (" + "id integer primary key autoincrement," +
            "name text," + "age integer," + "class integer)";
    private Context mContext;

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_BOOK);

        Toast.makeText(mContext, "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CREAT_STUDENT);
        Toast.makeText(mContext, "success update", Toast.LENGTH_SHORT).show();
    }
}
