package com.example.jieleo.huanxin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jieleo.huanxin.R;

import java.util.List;

/**
 * Created by OldFour on 2017/5/10.
 */

public class SetRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<String> words;

    OnClickItem mOnClickItem;


    public SetRecyclerViewAdapter setOnClickItem(OnClickItem onClickItem) {
        mOnClickItem = onClickItem;
        return this;
    }

    public SetRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public SetRecyclerViewAdapter setWords(List<String> words) {
        this.words = words;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder;
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_set_fragment,parent,false);
        myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder myHolder= (MyHolder) holder;
        myHolder.mButton.setText(words.get(position));
        myHolder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickItem.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return words !=null? words.size():0;
    }

    class MyHolder extends RecyclerView.ViewHolder{

        Button mButton;
        public MyHolder(View itemView) {
            super(itemView);
            mButton = (Button) itemView.findViewById(R.id.set_tv);
        }
    }

    public interface OnClickItem {
        void  onClick(int position);
    }
}
