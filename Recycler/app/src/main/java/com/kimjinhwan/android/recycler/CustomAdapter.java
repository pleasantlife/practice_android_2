package com.kimjinhwan.android.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XPS on 2017-06-27.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {

    List<Item> items;

    public CustomAdapter(){
        items = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_list, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Item item = items.get(position);
        holder.txtAuthor.setText(item.author);
        holder.txtId.setText(item.id);
        holder.txtTitle.setText(item.title);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView txtAuthor, txtTitle, txtId;

        public Holder(View itemView) {
            super(itemView);
            txtAuthor = (TextView) itemView.findViewById(R.id.txtAuthor);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtId = (TextView) itemView.findViewById(R.id.txtId);
        }
    }
}
