package com.kimjinhwan.android.mp3player;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by XPS on 2017-06-22.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.Holder> {


    @Override
    public DetailAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(DetailAdapter.Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class Holder extends RecyclerView.ViewHolder {


        public Holder(View itemView) {
            super(itemView);
        }
    }
}
