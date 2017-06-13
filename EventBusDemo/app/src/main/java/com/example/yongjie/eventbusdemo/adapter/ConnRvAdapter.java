package com.example.yongjie.eventbusdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yongjie.eventbusdemo.R;
import com.example.yongjie.eventbusdemo.coon.ConnBean;

/**
 * Created by OldFour on 2017/6/7.
 */

public class ConnRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ConnBean mConnBean;
    private Context context;

    public ConnRvAdapter(Context context) {
        this.context = context;
    }

    public ConnRvAdapter setConnBean(ConnBean connBean) {
        mConnBean = connBean;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyHolder myHolder = null;
        if (myHolder == null) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_conn, parent, false);
            myHolder = new MyHolder(view);
        }
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        Glide.with(context).load(mConnBean.getData().getItems().get(position).getCover_image_url()).into(myHolder.mImageView);
        myHolder.mTextView.setText(mConnBean.getData().getItems().get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mConnBean!=null?mConnBean.getData().getItems().size():0;
    }


    class MyHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextView;

        public MyHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_01);
            mTextView = (TextView) itemView.findViewById(R.id.tv_01);
        }
    }
}
