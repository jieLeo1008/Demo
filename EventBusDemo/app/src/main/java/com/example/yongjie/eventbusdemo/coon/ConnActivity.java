package com.example.yongjie.eventbusdemo.coon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.yongjie.eventbusdemo.R;
import com.example.yongjie.eventbusdemo.adapter.ConnRvAdapter;

public class ConnActivity extends AppCompatActivity implements ConnView{

    private ConnPresenter mConnPresenter;
    private RecyclerView mRecyclerView;
    private ConnRvAdapter mAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conn);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_01);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_01);
        mConnPresenter=new ConnPresenter(this);
        mProgressBar.setVisibility(View.INVISIBLE);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mAdapter=new ConnRvAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mConnPresenter.getConnData("http://api.liwushuo.com/v2/shop/items?limit=20&offset=0");

    }

    @Override
    public void getConnDataSuccess(ConnBean connBean) {
        mAdapter.setConnBean(connBean);
    }

    @Override
    public void getConnDataFail(Throwable throwable) {
        Toast.makeText(this, "请求数据失败  请检查网络状况", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void progressShow() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void progressDismiss() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }
}
