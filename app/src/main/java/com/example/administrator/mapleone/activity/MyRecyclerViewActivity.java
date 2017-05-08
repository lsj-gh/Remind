package com.example.administrator.mapleone.activity;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.administrator.mapleone.R;
import com.example.administrator.mapleone.adapter.MyRecyclerViewAdapter;
import com.example.administrator.mapleone.bean.People;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewActivity extends AppCompatActivity {
    private List<People> peopleList;
    private MyRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private static final String TAG = "MyRecyclerViewActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycle_view);
        peopleList = new ArrayList<>();
        initPeople();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MyRecyclerViewAdapter(peopleList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnClick(View view, int position) {
                Log.d(TAG,position+"");
            }
        });
    }

    private void initPeople() {
        for (int i = 0; i < 100; i++) {
            People people = new People("people---" + i, i);
            peopleList.add(people);
        }
    }
}
