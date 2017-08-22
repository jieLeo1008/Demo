package com.example.jieleo.customviewdemo.adapter;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jieleo.customviewdemo.R;

/**
 * Created by YongJie on 2017/8/1.
 */

public class UltraPagerAdapter extends PagerAdapter {
    private boolean isMultiSrc;

    public UltraPagerAdapter(boolean isMultiSrc) {
        this.isMultiSrc = isMultiSrc;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.item_ultra_view_pager,null);

        TextView textView = (TextView) linearLayout.findViewById(R.id.tv_01);

        textView.setText(position+"");

        switch (position) {
            case 0:
                linearLayout.setBackgroundColor(Color.parseColor("#2196F3"));
                break;
            case 1:
                linearLayout.setBackgroundColor(Color.parseColor("#673AB7"));
                break;
            case 3:
                linearLayout.setBackgroundColor(Color.parseColor("#009632"));
                break;
            case 4:
                linearLayout.setBackgroundColor(Color.parseColor("#F44336"));
                break;
        }

//        linearLayout.setId(R.id.);

        container.addView(linearLayout);



        return linearLayout;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        LinearLayout view = (LinearLayout) object;
        container.removeView(view);
    }
}
