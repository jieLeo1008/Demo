package com.example.jieleo.customviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.bean.item_decoration.ItemDecorationBean;
import com.example.jieleo.customviewdemo.tool.CallBack;
import com.example.jieleo.customviewdemo.tool.NetTool;

public class MyItemActivity extends AppCompatActivity {
    public String url="http://api.meituan.com/mmdb/movie/v2/list/rt/order/coming.json?ci=1&limit=12&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704714271&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=1a0b4a9b-44ec-42fc-b110-ead68bcc2824&__skcy=sXcDKbGi20CGXQPPZvhCU3%2FkzdE%3D";
    private TextView mTextView;
    private RecyclerView mRecyclerView;
    MyRvAdaptyer mMyRvAdaptyer ;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_item);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_01);
        mTextView = (TextView) findViewById(R.id.tv_001);
        mMyRvAdaptyer=new MyRvAdaptyer(this);
        mLinearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mMyRvAdaptyer);
        NetTool.getInstance().getDataFromUrl(url, ItemDecorationBean.class, new CallBack<ItemDecorationBean>() {
            @Override
            public void onSuccess(ItemDecorationBean response) {
                mMyRvAdaptyer.setItemDecorationBean(response);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
        Log.d("MyItemActivity", "linearLayoutManager.findFirstVisibleItemPosition():" + mLinearLayoutManager.findFirstVisibleItemPosition());
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

        });

    }
}
