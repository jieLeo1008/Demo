package com.example.jieleo.baseviewholderdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by OldFour on 2017/4/25.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Bean mBean;
    private Context mContext;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public RecyclerViewAdapter setBean(Bean bean) {
        mBean = bean;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseViewHolder.createViewHolder(mContext,parent,R.layout.item);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setText(R.id.tv,mBean.getData().getColumns().get(position).getAuthor());
        holder.setImage(R.id.iv,mBean.getData().getColumns().get(position).getBanner_webp_url());
    }

    @Override
    public int getItemCount() {
        return mBean==null?0:mBean.getData().getColumns().size();
    }
}
