package com.jieleo.haichangnoticedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by YongJie on 2017/8/11.
 */

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;

    private List<String> title;

    private List<Bean> mBeen ;


    private OnMyClickListener mClickListener;

    public TestAdapter setClickListener(OnMyClickListener clickListener) {
        mClickListener = clickListener;
        return this;
    }


    public TestAdapter(Context context, List<Bean> been) {
        mContext = context;
        mBeen = been;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_my, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyHolder myHolder = (MyHolder) holder;
        myHolder.mTextView.setText(mBeen.get(position).getTitle());
        myHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MyRvAdapter", "position:" + position);
                mClickListener.onMyClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBeen.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_01);
        }
    }


    public void addData(int pos, String content) {
        title.add(pos, content);
        notifyItemInserted(pos);
    }


    public void addBean(int  pos,Bean bean){
        mBeen.add(pos,bean);
        notifyItemInserted(pos);
    }





//    public void deleData(int pos) {
//        title.remove(pos);
//        notifyItemRemoved(pos);
//        notifyDataSetChanged();
//    }


    public void deleData(int pos){
        mBeen.remove(pos);
        notifyDataSetChanged();
    }




    public interface OnMyClickListener {
        void onMyClick(int pos);

    }
}

