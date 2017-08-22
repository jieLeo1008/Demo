package com.jieleo.databindingdemo;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by YongJie on 2017/8/14.
 */

public class User  {
    public String imageUri;

    public User(String imageUri) {
        this.imageUri = imageUri;
    }

    @BindingAdapter({"imageUri"})
    public static void imageLoader(ImageView imageView , String imageUri){
        Glide.with(imageView.getContext()).load(imageUri).into(imageView);
    }
}
