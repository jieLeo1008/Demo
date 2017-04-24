package com.example.jieleo.huanxindemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by OldFour on 2017/4/18.
 */

public class ContactsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String>  userNames;
    private Context mContext;

    public ContactsListAdapter(Context context) {
        mContext = context;
    }

    public ContactsListAdapter setUserNames(List<String> userNames) {
        this.userNames = userNames;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder=null;
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_user_name,parent,false);
        myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder= (MyHolder) holder;
        myHolder.mTextView.setText(userNames.get(position));
    }

    @Override
    public int getItemCount() {
        return userNames==null?0:userNames.size();
    }

    public static  class MyHolder extends RecyclerView.ViewHolder{

        private TextView mTextView;
        public MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.user_name_tv);
        }
    }
}
