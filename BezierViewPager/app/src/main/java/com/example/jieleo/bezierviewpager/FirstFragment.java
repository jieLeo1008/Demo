package com.example.jieleo.bezierviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by OldFour on 2017/4/23.
 */

public class FirstFragment extends Fragment {

    private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        mImageView = (ImageView) view.findViewById(R.id.m_iv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle=getArguments();
        String url=bundle.getString("url");
        Glide.with(getContext()).load(url).into(mImageView);
    }

    public static FirstFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url",url);
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
