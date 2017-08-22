package com.jieleo.databindingdemo;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by YongJie on 2017/8/14.
 */

public class Beauty {

    public String beautyUrl;

    public String beautyNum;

    public Beauty(String beautyUrl, String beautyNum) {
        this.beautyUrl = beautyUrl;
        this.beautyNum = beautyNum;
    }

    @BindingAdapter({"imageUrl"})
    public static void imageLoader(ImageView imageView ,String imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }


}
