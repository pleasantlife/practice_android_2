package com.kimjinhwan.android.mp3player;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimjinhwan.android.mp3player.ItemFragment.OnListFragmentInteractionListener;
import com.kimjinhwan.android.mp3player.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final List<MusicContent.ConItem> conItemList;
    private final OnListFragmentInteractionListener mListener;

    public ItemAdapter(List<MusicContent.ConItem> conItem, OnListFragmentInteractionListener listener) {
        conItemList = conItem;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MusicContent.ConItem conItem = conItemList.get(position);
        holder.position = position;
        holder.mIdView.setText(conItemList.get(position).id);
        holder.mContentView.setText(conItemList.get(position).title);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return conItemList.size();
    }

    public void moveDetail(int position){

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public int position;
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public MusicContent.ConItem mItem;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    moveDetail(position);
                }
            });
        }
    }
}
