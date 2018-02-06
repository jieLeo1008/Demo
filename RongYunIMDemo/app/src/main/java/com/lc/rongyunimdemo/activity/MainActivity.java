package com.lc.rongyunimdemo.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lc.rongyunimdemo.R;
import com.lc.rongyunimdemo.adapter.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MainModel>  mList =new ArrayList<>();

    private MainRvAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter=new MainRvAdapter();

        mList.add(new MainModel("超G名片",CardActivity.class));

        mAdapter.notifyDataSetChanged();
    }






    public class MainRvAdapter extends RecyclerView.Adapter<BaseViewHolder>{



        @Override
        public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new BaseViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_main,parent,false),MainActivity.this);
        }




        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position) {
            holder.getView(R.id.item_main_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return mList.size();
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
