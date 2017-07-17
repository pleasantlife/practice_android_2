package com.veryworks.android.musicplayer;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veryworks.android.musicplayer.domain.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by XPS on 2017-06-16.
 */

public class DetailAdapter extends PagerAdapter {

    List<Music.Item> datas = null;

    public DetailAdapter(Set<Music.Item> datas) {
       this.datas = new ArrayList<>(datas);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    // RecyclerView의 OnbindView와 같은 역할을 수행함.
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_detail_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView textView = (TextView) view.findViewById(R.id.textView);

        Glide.with(container.getContext()).load(datas.get(position).albumArt).into(imageView);
        textView.setText(datas.get(position).title);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
