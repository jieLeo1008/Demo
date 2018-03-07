package com.benny.viewdemo.ui.java;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.benny.viewdemo.R;
import com.benny.viewdemo.adapter.ZakerRvAdapter;
import com.benny.viewdemo.model.ZakerModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Benny on 2018/3/6.
 */

public class ZakerGridActivity extends BaseActivity {


    RecyclerView mZakerRv;

    private StaggeredGridLayoutManager mGridLayoutManager;

    private List<ZakerModel> mZakerModelList = new ArrayList<>();

    private ZakerRvAdapter mZakerRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaker);
    }

    @Override
    public void findView() {
        mZakerRv=findViewById(R.id.zaker_rv);
    }

    @Override
    public void initView() {
        mGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                mZakerModelList.add(new ZakerModel("Single", "https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E6%9F%AF%E5%9F%BA&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&cs=2709111055,2872441224&os=1822990606,2094308964&pn=1&rn=1&di=79114718980&ln=1991&fr=&fmq=1520344571692_R&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&pi=0&gsm=0&objurl=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201603%2F03%2F20160303091940_LKwNa.jpeg&rpstart=0&rpnum=0&adpicid=0"));
            } else {
                mZakerModelList.add(new ZakerModel("Double", "https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E6%9F%AF%E5%9F%BA&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&cs=1305653691,834932102&os=3463271,329880340&pn=11&rn=1&di=113163948810&ln=1991&fr=&fmq=1520344571692_R&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&pi=0&gsm=0&objurl=http%3A%2F%2Fq.zizhu316.com%2FupLoad%2Fproduct%2Fmonth_1704%2F201704221003276057.jpg&rpstart=0&rpnum=0&adpicid=0"));
            }
        }
        mZakerRv.setLayoutManager(mGridLayoutManager);

        mZakerRvAdapter =new ZakerRvAdapter(this,mZakerModelList);

        mZakerRv.setAdapter(mZakerRvAdapter);

        mTouchHelper.attachToRecyclerView(mZakerRv);
    }

    @Override
    public void setOnClick() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initData() {

    }


    ItemTouchHelper mTouchHelper =new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            //首先回调的方法 返回int表示是否监听该方向
            int dragFlags = ItemTouchHelper.UP|ItemTouchHelper.DOWN|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
            int swipeFlags = 0;//侧滑删除
            return makeMovementFlags(dragFlags,swipeFlags);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            //滑动事件
            Collections.swap(mZakerModelList,viewHolder.getAdapterPosition(),target.getAdapterPosition());
            mZakerRvAdapter.notifyItemMoved(viewHolder.getAdapterPosition(),target.getAdapterPosition());
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            mZakerModelList.remove(viewHolder.getAdapterPosition());
            mZakerRvAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
        }

        @Override
        public boolean isLongPressDragEnabled() {
            return true;
        }
    });
}
