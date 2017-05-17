package com.example.jieleo.huanxin.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jieleo.huanxin.R;

import java.util.List;

/**
 * Created by OldFour on 2017/5/10.
 */

public class ContactListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private List<String>  contacts;

    OnItemClick mOnItemClick;

    public ContactListAdapter setOnItemClick(OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
        return this;
    }

    public ContactListAdapter(Context context) {
        mContext = context;
    }

    public ContactListAdapter setContacts(List<String> contacts) {
        this.contacts = contacts;
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
        myHolder.mButton.setText(contacts.get(position));
        myHolder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts!=null?contacts.size():0;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        Button mButton;
        public MyHolder(View itemView) {
            super(itemView);
            mButton = (Button) itemView.findViewById(R.id.set_tv);
        }
    }

    public interface OnItemClick{
        void onClick(int position);
    }
}
