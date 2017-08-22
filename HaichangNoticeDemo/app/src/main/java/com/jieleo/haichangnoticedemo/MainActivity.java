package com.jieleo.haichangnoticedemo;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Handler mHandler = null;

    private RecyclerView mRecyclerView;

    private TestAdapter mMyRvAdapter;

    private List<String> title=new ArrayList<>();

    private List<Bean> mBeen =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       findViewById(R.id.insert).setOnClickListener(this);
       findViewById(R.id.delete).setOnClickListener(this);


        mRecyclerView = (RecyclerView) findViewById(R.id.myRv);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));

        mMyRvAdapter=new TestAdapter(this,mBeen);

        mRecyclerView.setAdapter(mMyRvAdapter);
        mRecyclerView.setItemAnimator(new SlideItemAnimator());
        mMyRvAdapter.setClickListener(new TestAdapter.OnMyClickListener() {
            @Override
            public void onMyClick(int pos) {
                mMyRvAdapter.deleData(pos);
            }
        });


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.insert:
//                mMyRvAdapter.addData(0,Math.random()+"");
                for (int i = 0; i < 5; i++) {
                Bean bean =new Bean(Math.random()+"",Math.random()+"");


                mMyRvAdapter.addBean(0,bean);

                }
                break;
            case R.id.delete:
                mMyRvAdapter.deleData(0);
                break;
        }

    }


//    static class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder>{

//        private Context mContext;
//
//        private List<String> title;
//
//
//        private OnMyClickListener mClickListener;
//
//        public MyRvAdapter setClickListener(OnMyClickListener clickListener) {
//            mClickListener = clickListener;
//            return this;
//        }
//
//        public MyRvAdapter(Context context, List<String> title) {
//            mContext = context;
//            this.title = title;
//        }
//
//        @Override
//        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(mContext).inflate(R.layout.item_my,parent,false);
//            MyHolder myHolder =new MyHolder(view);
//            return myHolder;
//        }
//
//        @Override
//        public void onBindViewHolder(MyHolder holder, final int position) {
//            MyHolder myHolder =holder;
//            myHolder.mTextView.setText(title.get(position));
//            myHolder.mTextView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Log.d("MyRvAdapter", "position:" + position);
//                    mClickListener.onMyClick(position);
//                }
//            });
//        }
//
//        @Override
//        public int getItemCount() {
//            return title!=null?title.size():0;
//        }
//
//        class MyHolder extends RecyclerView.ViewHolder{
//
//            private TextView mTextView ;
//            public MyHolder(View itemView) {
//                super(itemView);
//                mTextView = (TextView) itemView.findViewById(R.id.tv_01);
//            }
//        }
//
//
//        public void  addData(int pos, String content){
//            title.add(pos,content);
//            notifyItemInserted(pos);
//        }
//
//        public void deleData(int pos){
//            title.remove(pos);
//            notifyItemRemoved(pos);
//        }
//
//         interface  OnMyClickListener{
//            void onMyClick(int pos);
//
//        }
//    }
}
