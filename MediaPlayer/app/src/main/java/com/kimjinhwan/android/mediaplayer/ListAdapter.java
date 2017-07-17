package com.kimjinhwan.android.mediaplayer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimjinhwan.android.mediaplayer.ListFragment.OnListFragmentInteractionListener;
import com.kimjinhwan.android.mediaplayer.domain.MusicLoader;
import com.kimjinhwan.android.mediaplayer.dummy.DummyContent.DummyItem;

import java.util.List;
import java.util.Set;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final Set<MusicLoader.MusicItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MusicLoader.MusicItem musicItems[];

    public ListAdapter(Set<MusicLoader.MusicItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;

        //set에서 데이터를 꺼내서 사용을 하는 index를 필요로 하는 경우 array에 담는다.
        musicItems = new MusicLoader.MusicItem[mValues.size()];
        mValues.toArray(musicItems/*공간이 확정된 array 변수*/);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = musicItems.[position];
        holder.mIdView.setText(holder.mItem.id);
        holder.mContentView.setText(mValues.get(position).content);

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
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;      //id값
        public final TextView mContentView; //타이틀값
        // public DummyItem mItem;      <- 처음에 있었는데 왜 넣어놨을까? : 아이템에 해당하는 셀에 데이터를 다 몰아넣고 씀.
        public MusicLoader mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
