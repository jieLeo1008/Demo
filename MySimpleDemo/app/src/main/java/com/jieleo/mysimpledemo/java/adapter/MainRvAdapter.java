package com.jieleo.mysimpledemo.java.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jieleo.mysimpledemo.R;

import java.util.List;

/**
 * Created by YongJie on 2017/9/20.
 */

public class MainRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private List<String>  title;

    private MyOnclickListener mListener;

    public MainRvAdapter setListener(MyOnclickListener listener) {
        mListener = listener;
        return this;
    }

    public MainRvAdapter(Context context) {
        mContext = context;
    }

    public MainRvAdapter setTitle(List<String> title) {
        this.title = title;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main_rv,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder myHolder= (com.jieleo.mysimpledemo.java.adapter.MainRvAdapter.MyHolder) holder;

        myHolder.jumBtn.setText(title.get(position));

        myHolder.jumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClickBtn(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return title!=null?title.size():0;
    }


    public  class MyHolder extends RecyclerView.ViewHolder{

        private Button jumBtn;

        public MyHolder(View itemView) {
            super(itemView);

            jumBtn = itemView.findViewById(R.id.main_rv_btn);
        }
    }


    public interface  MyOnclickListener{
        void onClickBtn(int pos);
    }
}
