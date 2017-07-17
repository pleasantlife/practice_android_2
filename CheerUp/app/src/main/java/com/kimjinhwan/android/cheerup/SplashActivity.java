package com.kimjinhwan.android.cheerup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = (ImageView) findViewById(R.id.imageView);

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goToMain();
    }



    public void goToMain() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
