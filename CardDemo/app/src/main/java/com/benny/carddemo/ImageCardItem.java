package com.benny.carddemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by wensefu on 17-3-4.
 */
public class ImageCardItem extends BaseCardItem {

    private static final String TAG = "ImageCardItem";


    public ImageCardItem(Context context) {
        super(context);
    }

    public  static class ViewHolder{
        ImageView left;
        ImageView right;
        ImageView up;
        ImageView down;
    }

    @Override
    public View getView(View convertView, ViewGroup parent) {
        convertView = View.inflate(mContext,R.layout.item_card,null);

        return convertView;
    }
}
