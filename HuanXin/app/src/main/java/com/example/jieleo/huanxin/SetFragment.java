package com.example.jieleo.huanxin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jieleo.huanxin.adapter.SetRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OldFour on 2017/5/9.
 */

public class SetFragment extends Fragment implements SetRecyclerViewAdapter.OnClickItem {

    private RecyclerView mRecyclerView;

    List<String>  words=new ArrayList<>();

    private SetRecyclerViewAdapter mRecyclerViewAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_set,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.set_rv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle=getArguments();
        words=bundle.getStringArrayList("word");
        mRecyclerViewAdapter=new SetRecyclerViewAdapter(MyApp.getContext());
        mRecyclerViewAdapter.setWords(words);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MyApp.getContext(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);


        mRecyclerViewAdapter.setOnClickItem(this);
    }



    @Override
    public void onClick(int position) {
        switch (position) {
            case 0://添加好友
                startActivity(new Intent(getActivity(),AddContactActivity.class));
                break;
            case 1://退出登录
                startActivity(new Intent(getActivity(),TestActivity.class));
                break;
        }
    }
}
