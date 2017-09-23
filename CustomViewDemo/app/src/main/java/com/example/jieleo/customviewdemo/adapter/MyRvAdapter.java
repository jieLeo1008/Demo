package com.example.jieleo.customviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.bean.item_decoration.NotifBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongJie on 2017/8/9.
 */

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder> {
    private Context mContext;


    private List<NotifBean> mNotifBeen;

    private List<String> mTitle;

    private List<String> title = new ArrayList<>();

//    public MyRvAdapter(Context context, List<NotifBean> notifBeen) {
//        mContext = context;
//        mNotifBeen = notifBeen;
//    }


    public MyRvAdapter(Context context, List<String> title) {
        mContext = context;
        this.title = title;
    }

    private MyClickListener mMyClickListener;

    public MyRvAdapter setMyClickListener(MyClickListener myClickListener) {
        mMyClickListener = myClickListener;
        return this;
    }

    @Override
    public MyRvAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_my_rv, parent, false);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        final MyHolder myHolder = holder;


//        ObjectAnimator.ofFloat(myHolder.mTextView,"translationX",-1080f,0f).setDuration(1000).start();

        myHolder.mTextView.setText(title.get(position));
        myHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                ObjectAnimator.ofFloat(myHolder.mTextView,"translationX",0f,1080f).setDuration(1000).start();
//                TranslateAnimation animation = new TranslateAnimation(0f, 10f, 0f, 200f);
//                animation.setDuration(1000);
//
//                holder.mTextView.startAnimation(animation);
                mMyClickListener.onMyClick(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return title != null ? title.size() : 0;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_001);
        }
    }

    public interface MyClickListener {
        void onMyClick(int position);
    }


    public void remove(int position) {
//        mNotifBeen.remove(position);
        try {
            title.remove(position);
//            notifyItemRemoved(position);
            notifyDataSetChanged();
        } catch (Exception e) {
            Log.d("MyRvAdapter", "e:" + e);
        }
//        notifyItemChanged(position);
//        notifyDataSetChanged();
    }

//    public void add(NotifBean notifBean,int position){
//        mNotifBeen.add(notifBean);
//        notifyItemChanged(position);
//        notifyItemInserted(position);
//    }


    public void add(String data, int position) {
        title.add(data);
//        notifyItemInserted(position);
        notifyItemChanged(position);
    }


}
