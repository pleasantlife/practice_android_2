package com.kimjinhwan.android.mediaplayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.kimjinhwan.android.mediaplayer.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ListFragment.OnListFragmentInteractionListener {

    FrameLayout frameLayout;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        setFragment(ListFragment.newInstance(1));

        }

        private void setView(){

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

        }


        private void setFragment(Fragment fragment){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.frameLayout, fragment);
            transaction.commit();
        }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}

