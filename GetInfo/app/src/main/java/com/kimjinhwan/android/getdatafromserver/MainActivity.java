package com.kimjinhwan.android.getdatafromserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemLoader.CallBack {

    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ItemLoader itemLoader = new ItemLoader();
        itemLoader.getData("http://192.168.10.248:8080/bbs/json/list/", this);

        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void setData(List<Item> items) {
        adapter.setList(items);
        adapter.notifyDataSetChanged();
    }
}
