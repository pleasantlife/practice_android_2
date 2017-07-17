package com.kimjinhwan.android.daummapapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapView;

public class MainActivity extends AppCompatActivity {
    private final String API_KEY = "dc086b2e1acfae934ec768c574fe6709";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = new MapView(this);
        mapView.setDaumMapApiKey(API_KEY);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_View);
        mapViewContainer.addView(mapView);
    }
}
