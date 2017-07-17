package com.veryworks.android.musicplayer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArraySet;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.veryworks.android.musicplayer.domain.Music;

import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    ViewHolder viewHolder = null;

    private DetailFragment() {
        // Required empty public constructor

    }


    public Set<Music.Item> getDatas(){
        Music music = Music.getInstance();
        music.loader(getContext());
        return music.getItems();
    }

    public DetailFragment newInstance() {

    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }





    public class ViewHolder implements View.OnClickListener {

        ViewPager viewPager;
        ImageButton btnNext, btnPlay, btnPrev;
        SeekBar seekBar;
        TextView current, duration;

        public void ViewHolder(View view) {
            viewPager = (ViewPager) view.findViewById(R.id.viewPager);
            btnNext = (ImageButton) view.findViewById(R.id.btnNext);
            btnPlay = (ImageButton) view.findViewById(R.id.btnPlay);
            btnPrev = (ImageButton) view.findViewById(R.id.btnPrev);
            seekBar = (SeekBar) view.findViewById(R.id.seekBar);
            current = (TextView) view.findViewById(R.id.current);
            duration = (TextView) view.findViewById(R.id.duration);
            setOnClickListener();
        }

        private void setOnClickListener(){
            btnNext.setOnClickListener(this);
            btnPlay.setOnClickListener(this);
            btnPrev.setOnClickListener(this);
        }

        public void setViewPager(int position) {
            DetailAdapter adapter = new DetailAdapter(getDatas());
        }

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btnNext:
                    break;
                case R.id.btnPlay:
                    break;
                case R.id.btnPrev:
                    break;

            }
        }
    }
}
