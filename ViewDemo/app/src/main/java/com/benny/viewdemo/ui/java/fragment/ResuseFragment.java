package com.benny.viewdemo.ui.java.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.benny.viewdemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Benny on 2018/3/13.
 */

public class ResuseFragment extends Fragment {


    @BindView(R.id.iv01)
    ImageView mIv01;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resuse, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int pos=getArguments().getInt("pos");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public static ResuseFragment newInstance(int position, ArrayList<String> url) {

        Bundle args = new Bundle();
        args.putInt("pos",position);
        args.putStringArrayList("url",url);
        ResuseFragment fragment = new ResuseFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
