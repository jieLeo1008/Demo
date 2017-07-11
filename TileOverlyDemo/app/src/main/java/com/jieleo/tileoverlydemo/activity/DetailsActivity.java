package com.jieleo.tileoverlydemo.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;
import com.jieleo.tileoverlydemo.R;
import com.jieleo.tileoverlydemo.base.MyApp;
import com.jieleo.tileoverlydemo.fragment.DetailsFragment;
import com.jieleo.tileoverlydemo.fragment.MapFragment;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabLayout;
    private SearchView mSearchView;
    private MapFragment mMapFragment;
    private DetailsFragment mDetailsFragment;
    private FloatingActionButton faBtn;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private TextView tv_01,tv_02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(MyApp.getContext());
        setContentView(R.layout.activity_details);


        initView();
        initData();
        bindEvent();

    }

    private void initData() {
        mFragmentManager = getSupportFragmentManager();
        mMapFragment = new MapFragment();
        mDetailsFragment = new DetailsFragment();
        initTab();
        mFragmentManager.beginTransaction().add(R.id.content, mMapFragment)
                .add(R.id.content, mDetailsFragment)
                .commit();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        hidleAll(fragmentTransaction);
        fragmentTransaction.show(mMapFragment);
        fragmentTransaction.commit();


    }

    private void initTab() {
        addTab();
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    private void hidleAll(FragmentTransaction fragmentTransaction) {
        fragmentTransaction.hide(mMapFragment)
                .hide(mDetailsFragment);
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mSearchView = (SearchView) findViewById(R.id.search_view);
        faBtn = (FloatingActionButton) findViewById(R.id.fa_btn_01);
        tv_01 = (TextView) findViewById(R.id.tv_01);
        tv_02 = (TextView) findViewById(R.id.tv_02);
    }


    private void bindEvent() {
        /**
         * TabLayout的选择事件
         */
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mTabLayout.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {

            }
        });

        faBtn.setOnClickListener(this);
    }


    /**
     * 增加Tab标签
     */
    private void addTab() {
        mTabLayout.addTab(mTabLayout.newTab().setText("游乐设施"));
        mTabLayout.addTab(mTabLayout.newTab().setText("娱乐表演"));
        mTabLayout.addTab(mTabLayout.newTab().setText("餐厅"),true);
        mTabLayout.addTab(mTabLayout.newTab().setText("商店"));
        mTabLayout.addTab(mTabLayout.newTab().setText("洗手间"));
        mTabLayout.addTab(mTabLayout.newTab().setText("处处拍"));
        mTabLayout.addTab(mTabLayout.newTab().setText("节庆"));



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fa_btn_01:
                onFaBtnClick();
                break;
        }
    }


    private void onFaBtnClick() {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        hidleAll(mFragmentTransaction);
        if (mMapFragment.isHidden()) {
            mFragmentTransaction.show(mMapFragment);
        } else {
            mFragmentTransaction.show(mDetailsFragment);
        }
        mFragmentTransaction.commit();
    }


    private void SetTv02(){
        Display display =this.getWindowManager().getDefaultDisplay();
        int x =display.getWidth();

    }

}
