package com.kimjinhwan.android.mp3player;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.kimjinhwan.android.mp3player.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    FrameLayout frameLayout;
    Fragment itemFragment;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemFragment = new ItemFragment();
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, itemFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(MusicContent.ConItem item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra()
        startActivity(intent);
    }
}
