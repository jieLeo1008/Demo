package com.example.jieleo.baidumap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

public class SecondMapActivity extends AppCompatActivity {

    private MapView mMapView;
    private BaiduMap mBaiduMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_map);
        Intent intent=getIntent();
        Log.d("SecondMapActivity", "intent.getDoubleExtra(,0):" + intent.getDoubleExtra("Lng", 0));
        Log.d("SecondMapActivity", "intent.getDoubleExtra(,0):" + intent.getDoubleExtra("Lat", 0));
        LatLng latLng=new LatLng(intent.getDoubleExtra("Lat",0),intent.getDoubleExtra("Lng",0));
        mMapView = (MapView) findViewById(R.id.map_view);
        mBaiduMap=mMapView.getMap();
        mBaiduMap.setOnMapLoadedCallback(new BaiduMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                LatLng northEast = new LatLng(39.095164, 122.014586);
                LatLng southWest = new LatLng(39.073656, 121.988643);

//        mBaiduMap.setMaxAndMinZoomLevel(17f,14f);//设置最大最小缩放值
                mBaiduMap.setMapStatusLimits(new LatLngBounds.Builder().include(northEast).include(southWest).build());

                LatLng centerPoint = new LatLng(39.086705, 122.009147);
                MapStatus mapStatus = new MapStatus.Builder()
                        .target(centerPoint)
                        .zoom(17)
                        .build();
                MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
                mBaiduMap.setMapStatus(mapStatusUpdate);
            }
        });

        OverlayOptions options=new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        mBaiduMap.addOverlay(options);

        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                startActivity(new Intent( SecondMapActivity.this,TextureMapActivity.class));
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
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
}
