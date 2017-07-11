package com.jieleo.tileoverlydemo.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jieleo.tileoverlydemo.R;
import com.jieleo.tileoverlydemo.activity.MapActivity;
import com.jieleo.tileoverlydemo.utils.permission.MPermission;
import com.jieleo.tileoverlydemo.utils.permission.PermissionFailed;
import com.jieleo.tileoverlydemo.utils.permission.PermissionSuccess;

/**
 * Created by YongJie on 2017/6/26.
 */

public class TestFragment extends Fragment {

    private TextView mTextView;
    private Bundle mArgs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        mTextView = (TextView)view.findViewById(R.id.tv_01);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mArgs = getArguments();
        mTextView.setText(mArgs.get("position") + "");
        Toast.makeText(getContext(), "args.getInt():" + mArgs.getInt("position"), Toast.LENGTH_SHORT).show();
        MPermission.needPermission(this,200,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION});

    }



    @PermissionSuccess(requestCode = 200)
    public void requestPermissionSuccess(){
        Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getActivity(), MapActivity.class));
    }

    @PermissionFailed(requestCode = 200)
    public void requestPermissionFailed(){
        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
    }

    public static TestFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("position", position);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
//            mTextView.setText("啊哈哈");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TestFragment", "onPause");
    }



    @Override
    public void onResume() {
        super.onResume();
        Log.d("TestFragment", "onResume");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TestFragment", "onDestroy");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MPermission.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }
}
