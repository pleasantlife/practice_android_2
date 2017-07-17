package com.kimjinhwan.android.getdatafromserver;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XPS on 2017-06-26.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    List<Item> items;

    public MyAdapter() {
        items = new ArrayList<>();
    }


    public void setList(List<Item> items){
        this.items = items;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_list, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Item item = items.get(position);    // TODO
        holder.txtNumber.setText(item.id+"");
        holder.txtTitle.setText(item.title);
        holder.txtAuthor.setText(item.author);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView txtNumber;
        TextView txtTitle;
        TextView txtAuthor;

        public Holder(View itemView) {
            super(itemView);

            txtNumber = (TextView) itemView.findViewById(R.id.txtNumber);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtAuthor = (TextView) itemView.findViewById(R.id.txtAuthor);
        }
    }
}
