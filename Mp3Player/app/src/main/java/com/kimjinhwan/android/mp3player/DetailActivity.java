package com.kimjinhwan.android.mp3player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    TextView textView;
    List<MusicContent.ConItem> conItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        Log.e("intent", "인텐트"+intent);

    }

    public class holder {

        public void getItem()

    }

}
