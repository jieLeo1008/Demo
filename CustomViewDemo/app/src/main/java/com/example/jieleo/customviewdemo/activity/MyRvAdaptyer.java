package com.example.jieleo.customviewdemo.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.bean.item_decoration.ItemDecorationBean;

import java.util.List;

/**
 * Created by OldFour on 2017/6/16.
 */

public class MyRvAdaptyer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    private ItemDecorationBean mItemDecorationBean;

    public MyRvAdaptyer setItemDecorationBean(ItemDecorationBean itemDecorationBean) {
        mItemDecorationBean = itemDecorationBean;
        notifyDataSetChanged();
        return this;
    }

    public MyRvAdaptyer(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder =null;
        if (myHolder==null){
            View view = LayoutInflater.from(context).inflate(R.layout.item_rv,parent,false);
            myHolder=new MyHolder(view);
        }
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder= (MyHolder) holder;
        List<ItemDecorationBean.DataBean.ComingBean> comingBeen=mItemDecorationBean.getData().getComing();
        if (position>0){
            if (comingBeen.get(position-1).getComingTitle().equals(comingBeen.get(position).getComingTitle())){
                myHolder.mTextView.setVisibility(View.GONE);
            }else {
                myHolder.mTextView.setText(comingBeen.get(position).getComingTitle());
            }
        }else {
            myHolder.mTextView.setVisibility(View.VISIBLE);
            myHolder.mTextView.setText(comingBeen.get(position).getComingTitle());
        }
        Glide.with(context).load(toString(comingBeen.get(position).getImg())).into(myHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mItemDecorationBean!=null?mItemDecorationBean.getData().getComing().size():0;
    }


    private String toString (String str){
        return str.replaceAll("w.h", "50.80");
    }


    class MyHolder extends RecyclerView.ViewHolder{

        private TextView mTextView;
        private ImageView mImageView;


        public MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_01);
            mImageView= (ImageView) itemView.findViewById(R.id.iv_01);
        }
    }

}
