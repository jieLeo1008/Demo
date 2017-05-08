package com.example.jieleo.baseviewholderdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by OldFour on 2017/4/25.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private View mView;

    private SparseArray<View>   mViewSparseArray;

    private Context mContext;

    public BaseViewHolder(View itemView,Context context) {
        super(itemView);
        mView=itemView;
        mContext=context;
        mViewSparseArray=new SparseArray<>();
    }

    public static BaseViewHolder createViewHolder(Context context, ViewGroup viewGroup,int layoutId){
        View view= LayoutInflater.from(context).inflate(layoutId,viewGroup,false);
        BaseViewHolder baseViewHolder=new BaseViewHolder(view,context);
        return baseViewHolder;
    }

    public <T extends View> T getView(int resId){
        View view=mViewSparseArray.get(resId);
        if (view==null){
            view=itemView.findViewById(resId);
            mViewSparseArray.put(resId,view);
        }
        return (T) view;
    }

    public BaseViewHolder setText(int resId,String content){
        TextView textView=getView(resId);
        if (content!=null){
            textView.setText(content);
        }
        return this;
    }

    public BaseViewHolder setImage(int resId,String url){
        ImageView imageView=getView(resId);
        if (url!=null){
            Glide.with(mContext).load(url).into(imageView);
        }
        return this;
    }


}
