package com.lc.rongyunimdemo.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lc.rongyunimdemo.R;
import com.lc.rongyunimdemo.ui.adapter.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MainModel>  mList =new ArrayList<>();

    private MainRvAdapter mAdapter;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=findViewById(R.id.main_rv);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mAdapter=new MainRvAdapter();

        mRecyclerView.setAdapter(mAdapter);

        mList.add(new MainModel("超G名片",CardActivity.class));

        mAdapter.notifyDataSetChanged();
    }






    public class MainRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{



        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MainHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_main,parent,false));
        }




        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            MainHolder mainHolder= (MainHolder) holder;
            mainHolder.mButton.setText(mList.get(position).getName());
            mainHolder.mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,mList.get(position).getClazz()));
                }
            });
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        public class MainHolder extends RecyclerView.ViewHolder{
            Button mButton;
            public MainHolder(View itemView) {
                super(itemView);
                mButton=itemView.findViewById(R.id.item_main_btn);
            }
        }

    }



    public class MainModel<T> {
        private String name;


        private Class<T>  clazz;

        public MainModel(String name, Class<T> clazz) {
            this.name = name;
            this.clazz = clazz;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Class<T> getClazz() {
            return clazz;
        }

        public void setClazz(Class<T> clazz) {
            this.clazz = clazz;
        }
    }
}
