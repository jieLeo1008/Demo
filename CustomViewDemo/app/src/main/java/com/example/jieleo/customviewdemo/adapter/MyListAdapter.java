package com.example.jieleo.customviewdemo.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jieleo.customviewdemo.R;

import java.util.List;

/**
 * Created by YongJie on 2017/8/10.
 */

public class MyListAdapter extends BaseAdapter {

    private List<String> mList;

    private Context mContext;
    private final Animation mAnimation;


    public MyListAdapter(List<String> list, Context context) {
        mList = list;
        mContext = context;
        mAnimation = AnimationUtils.loadAnimation(context, R.anim.bottom_in_anim);
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyHolder myHolder;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            myHolder = new MyHolder(convertView);
            convertView.setTag(myHolder);
        } else {
            myHolder = (MyHolder) convertView.getTag();
        }


//        info.startAnimation(mAnimation);
//        ObjectAnimator.ofFloat(info,"translationX",-1080f,0).setDuration(1000).start();
//

        myHolder.info.setText(mList.get(position));

        return convertView;
    }


    public class MyHolder {

        TextView info;

        View mView;

        public MyHolder(View view) {

            mView = view;

            info = (TextView) view.findViewById(R.id.tv_01);

        }
    }



}
