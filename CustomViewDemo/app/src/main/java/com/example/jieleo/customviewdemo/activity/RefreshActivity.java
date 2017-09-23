package com.example.jieleo.customviewdemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class RefreshActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout mRefreshLayout;

    private RecyclerView mRecyclerView;

    private List<String>  mList;

    private MyRvAdapter mMyRvAdapter;

    private Handler mHandler =new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if (message.what==100){
                mRefreshLayout.setRefreshing(false);
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);

        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_01);

        mList=new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            mList.add(Math.random()+"");

        }
        mMyRvAdapter=new MyRvAdapter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mRecyclerView.setAdapter(mMyRvAdapter);

        mMyRvAdapter.setList(mList);




        mRefreshLayout.setOnRefreshListener(this);


    }

    @Override
    public void onRefresh() {
//            new Thread(() -> runOnUiThread(() -> {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            })).run();

        mRefreshLayout.setRefreshing(true);

        mHandler.sendEmptyMessageDelayed(100,3000);


    }


    public class  MyRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        Context mContext;

        List<String> mList;

        public MyRvAdapter(Context context) {
            mContext = context;
        }

        public MyRvAdapter setList(List<String> list) {
            mList = list;
            notifyDataSetChanged();
            return this;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view =LayoutInflater.from(mContext).inflate(R.layout.my_rv_layout,parent,false);
            MyHolder myHolder =new MyHolder(view);
            return myHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyHolder myHolder = (MyHolder) holder;
            try {

            myHolder.mTextView.setText(mList.get(position));

            }catch (Exception e){
                Log.d("MyRvAdapter", e.toString());
            }
        }

        @Override
        public int getItemCount() {
            return mList!=null?mList.size():0;
        }



        public class  MyHolder extends RecyclerView.ViewHolder{

           private TextView mTextView;

            public MyHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.tv_01);
            }
        }
    }
}
