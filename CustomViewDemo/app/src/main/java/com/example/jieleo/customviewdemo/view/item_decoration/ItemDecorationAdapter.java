package com.example.jieleo.customviewdemo.view.item_decoration;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
 * Created by OldFour on 2017/5/22.
 */

public class ItemDecorationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private List<ItemDecorationBean.DataBean.ComingBean>  mComingBeanList;

    public ItemDecorationAdapter(Context context) {
        mContext = context;
    }

    public ItemDecorationAdapter setComingBeanList(List<ItemDecorationBean.DataBean.ComingBean> comingBeanList) {
        mComingBeanList = comingBeanList;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder=null;
        if (myHolder==null){
            View view= LayoutInflater.from(mContext).inflate(R.layout.item_details,parent,false);
            myHolder=new MyHolder(view);
        }
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder= (MyHolder) holder;
        myHolder.setData(position);

    }

    @Override
    public int getItemCount() {
        return mComingBeanList!=null?mComingBeanList.size():0;
    }


    class MyHolder extends RecyclerView.ViewHolder{
        private TextView mv_name;
        private TextView mv_dec;
        private TextView mv_date;
        private ImageView imageView;


        public MyHolder(View itemView) {
            super(itemView);
            mv_name = (TextView) itemView.findViewById(R.id.mv_name);
            mv_date = (TextView) itemView.findViewById(R.id.mv_date);
            mv_dec = (TextView) itemView.findViewById(R.id.mv_dec);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }


        public void setData(int position){
            ItemDecorationBean.DataBean.ComingBean comingBean=mComingBeanList.get(position);

            String name = comingBean.getNm();
            mv_name.setText(name);

            String date = comingBean.getShowInfo();
            mv_date.setText(date);

            String dec = comingBean.getScm();
            mv_dec.setText(dec);

            String imageUrl = comingBean.getImg();
            String newImageUrl = imageUrl.replaceAll("w.h", "50.80");
            Glide.with(mContext).load(newImageUrl).into(imageView);
        }
    }
}
