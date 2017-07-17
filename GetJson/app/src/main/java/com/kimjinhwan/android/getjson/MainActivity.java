package com.kimjinhwan.android.getjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemLoader.CallBack {


    //리사이클러뷰와 Gson을 활용하여, Json 데이터를 리스트로 뿌려주겠습니다.
    //리사이클러뷰 선언
    RecyclerView recyclerList;
    CustomAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main에서 recyclerView를 설정합니다.
        setContentView(R.layout.activity_main);

        recyclerList = (RecyclerView) findViewById(R.id.recyclerList);

        ItemLoader itemLoader = new ItemLoader();
        itemLoader.getData("http://192.168.10.248:8080/bbs/json/list/insert.jsp", this);

        adapter = new CustomAdapter();
        recyclerList.setAdapter(adapter);
        recyclerList.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override
    public void setData(List<Item> items) {
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}
