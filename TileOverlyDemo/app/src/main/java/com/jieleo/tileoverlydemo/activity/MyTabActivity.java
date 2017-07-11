package com.jieleo.tileoverlydemo.activity;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jieleo.tileoverlydemo.R;
import com.jieleo.tileoverlydemo.utils.DeviceUtil;
import com.jieleo.tileoverlydemo.view.swiperecycleview.DefaultItemTouchHelper;
import com.jieleo.tileoverlydemo.view.swiperecycleview.HorizontalRecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyTabActivity extends AppCompatActivity {

    private HorizontalRecyclerView mRecyclerView;
    private View lastView;
    private int lastPoi;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tab);
        mRecyclerView = (HorizontalRecyclerView) findViewById(R.id.hor_rv_01);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setPadding(DeviceUtil.getScreenWidth(this)/2-202, 0, DeviceUtil.getScreenWidth(this)/2, 0);
        mRecyclerView.setClipToPadding(false);
        mRecyclerView.getAdapter().bindDatas(getBindData());
        mLinearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemTouchHelperListener(new DefaultItemTouchHelper.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {

            }

            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                // 更换数据源中的数据Item的位置
                Collections.swap(mRecyclerView.getAdapter().getDatas(), srcPosition, targetPosition);

                // 更新UI中的Item的位置，主要是给用户看到交互效果
                mRecyclerView.getAdapter().notifyItemMoved(srcPosition, targetPosition);
                return true;
            }
        },true,false);



        mRecyclerView.setOnItemSelectedListener(new HorizontalRecyclerView.OnItemSelectedLitener() {
            @Override
            public void onItemSelected(View view, int position) {
                mRecyclerView.smoothToCenter(view);

                //设置选中的View的Type
                TextView textView = (TextView) view;
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                if (lastView!=null){
                    if (lastPoi!=position){
                    TextView textView1 = (TextView) lastView;
                    textView1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    }
                }
                lastView=view;
                lastPoi=position;
            }
        });


        Log.d("MyTabActivity", "mLinearLayoutManager.findFirstCompletelyVisibleItemPosition():" + mLinearLayoutManager.findFirstCompletelyVisibleItemPosition());



    }



    private List<String>  getBindData(){
        List<String>  data =new ArrayList<>();
        data.add("游乐设施");
        data.add("娱乐表演");
        data.add("餐饮");
        data.add("商店");
        data.add("洗手间");
        data.add("迪士尼处处拍");
        return data;
    }
}
