package com.example.administrator.mapleone.activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.mapleone.R;
import com.example.administrator.mapleone.dao.MyOpenHelper;

public class MyDataBase extends AppCompatActivity {
    private MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data_base);
        myOpenHelper = new MyOpenHelper(this, "mapleoutcast.db", null, 2);
        findViewById(R.id.bt_database).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOpenHelper.getReadableDatabase();
            }
        });
        findViewById(R.id.bt_add_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myOpenHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                for (int i = 1; i < 15; i++) {
                    contentValues.put("name", "naruto" + i);
                    contentValues.put("age", 11 + i);
                    contentValues.put("class", i);
                    db.insert("Student",null,contentValues);
                    contentValues.clear();
                }
            }
        });
    }
}
