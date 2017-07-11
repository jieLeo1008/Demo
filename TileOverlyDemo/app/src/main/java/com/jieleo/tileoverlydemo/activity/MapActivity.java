package com.jieleo.tileoverlydemo.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.jieleo.tileoverlydemo.R;
import com.jieleo.tileoverlydemo.base.MyApp;

public class MapActivity extends AppCompatActivity {


    private TextureMapView mMapView;
    private BaiduMap mBaiduMap;
    private TabLayout mTabLayout;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(MyApp.getContext());
        setContentView(R.layout.activity_map);

        initView();

        initPop();

        mBaiduMap=mMapView.getMap();

        //加载map的回调
        mBaiduMap.setOnMapLoadedCallback(new BaiduMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                //默认显示地区
                LatLng northEast = new LatLng(39.095164, 122.025586);
                LatLng southWest = new LatLng(39.073656, 121.985643);
                mBaiduMap.setMapStatusLimits(new LatLngBounds.Builder().include(northEast).include(southWest).build());
                //设置默认显示的位置
                LatLng centerPoi =new LatLng(39.08701,122.00892);
                MapStatus mapStatus =new MapStatus.Builder()
                        .target(centerPoi)
                        .zoom(19).build();
                MapStatusUpdate mapStatusUpdate= MapStatusUpdateFactory.newMapStatus(mapStatus);
                mBaiduMap.setMapStatus(mapStatusUpdate);
            }
        });


        //tabLayout选择监听
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


        //点击地图的回调
        mBaiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                double x=latLng.longitude;
                double y =latLng.latitude;
                if (x>122.013||x<122.002||y>39.0911||y<39.08444){
                    Toast.makeText(MapActivity.this, "超出范围", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MapActivity.this, "范围合理", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                Log.d("MapActivity", mapPoi.getName());

                return false;
            }
        });

        //设置地图是否显示
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);




    }

    private void initPop() {
        LayoutInflater inflater =LayoutInflater.from(this);
        View view =inflater.inflate(R.layout.item_popup,null);
        final PopupWindow popupWindow =new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, 500,false);
        //设置点击外部关闭
        popupWindow.setOutsideTouchable(true);
        //设置 可以被点击
        popupWindow.setFocusable(true);

        Button button =view.findViewById(R.id.btn_01);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()){
                    popupWindow.dismiss();
                }else {
                    popupWindow.showAtLocation(mTabLayout, Gravity.TOP,0,0);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MapActivity.this, "点击了Button", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MapActivity.this,AnotherMapActivity.class));
            }
        });





    }

    private void initView() {
        mMapView=(TextureMapView)findViewById(R.id.map_view);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mButton = (Button) findViewById(R.id.btn_01);

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.addTab(mTabLayout.newTab().setText("第二页"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第三页"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第三页"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第一页"),0,true);
        mTabLayout.addTab(mTabLayout.newTab().setText("第三页"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第三页"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第三页"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第三页"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第三页"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第三页"));
        mTabLayout.addTab(mTabLayout.newTab().setText("第三页"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
}
