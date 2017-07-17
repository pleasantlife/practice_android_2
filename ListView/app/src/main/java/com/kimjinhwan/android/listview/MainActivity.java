package com.kimjinhwan.android.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    static final String DATAS[] = {"List1", "List2", "List3"};

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.item_list, DATAS);
        listView.setAdapter(arrayAdapter);

    }
}
