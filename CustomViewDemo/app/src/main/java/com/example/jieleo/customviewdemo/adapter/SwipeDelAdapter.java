package com.example.jieleo.customviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;

/**
 * Created by YongJie on 2017/8/15.
 */

public class SwipeDelAdapter extends  RecyclerView.Adapter<SwipeDelAdapter.SwipeDelVH>{

    private Context mContext;


    public SwipeDelAdapter(Context context) {
        mContext = context;
    }

    @Override
    public SwipeDelVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SwipeDelVH(LayoutInflater.from(mContext).inflate(R.layout.item_swipe_del,parent,false));
    }

    @Override
    public void onBindViewHolder(SwipeDelVH holder, int position) {
//        ((SwipeMenuLayout) holder.itemView).setIos(false).setLeftSwipe(position % 2 == 0 ? true : false);//这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑
//        ((SwipeMenuLayout) holder.itemView).setIos(false).setLeftSwipe(position % 2 == 0 ? true : false);//这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑

        holder.content.setText(position%2==0?"我是单的":"我是双的");

        holder.toTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "置顶", Toast.LENGTH_SHORT).show();
            }
        });


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "删除", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class SwipeDelVH extends RecyclerView.ViewHolder{


        TextView content;
        Button toTop;
        Button delete;

        public SwipeDelVH(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.tv_001);
            toTop = (Button) itemView.findViewById(R.id.btn_01);
            delete= (Button) itemView.findViewById(R.id.btn_02);
        }
    }
}
