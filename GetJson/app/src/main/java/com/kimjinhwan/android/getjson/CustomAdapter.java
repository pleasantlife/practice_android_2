package com.kimjinhwan.android.getjson;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XPS on 2017-06-26.
 */

// 리사이클러뷰와 데이터를 연결할 어댑터를 생성합니다.
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {

    List<Item> items;


    public CustomAdapter() {
        items = new ArrayList<>();

    }

    public void setItems(List<Item> items){
        this.items = items;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Item item = items.get(position);
        Log.e("거기 계세요?", String.valueOf(items.get(position)));
        holder.txtNo.setText(item.id+"");
        holder.txtTitle.setText(item.title);
        holder.txtAuthor.setText(item.author);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    //MainActivity 클래스에서 TextView 등을 등록해줄 때와 똑같다고 보면 됨.
    class Holder extends RecyclerView.ViewHolder{

        TextView txtNo, txtTitle, txtAuthor;

        //MainActivity 클래스의 onCreate자리와 같은 일을 해주면 됨.
        public Holder(View itemView) {
            super(itemView);

            txtNo = (TextView) itemView.findViewById(R.id.txtNo);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtAuthor = (TextView) itemView.findViewById(R.id.txtAuthor);
        }
    }
}
