package com.example.jieleo.customviewdemo.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jieleo.customviewdemo.R;

import java.util.List;

/**
 * Created by OldFour on 2017/6/2.
 */

public class PopRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;

    private List<String> mList;

    public PopRvAdapter(Context context) {
        mContext = context;
    }

    public PopRvAdapter setList(List<String> list) {
        mList = list;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder=null;
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_pop,parent,false);
        myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder= (MyHolder) holder;
        myHolder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList!=null?mList.size():0;
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView mTextView;
        public MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_001);
        }
    }
}
