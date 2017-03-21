package com.example.jie.baidumapdemo;

import android.graphics.Bitmap;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MapView mMapView;
    private Button normalBtn, satelliteBtn,trafficMapBtn,heatMapBtn,makerBtn,openLocaBtn,closeLocaBtn,moveToPosition;
    private BaiduMap mBaiduMap;
    private LatLng mLatLng;


    private BitmapDescriptor mCurrentMarker;
    private LocationClient mLocationClient;

    public BDLocationListener mLocationListener;
    private MyLocationData mLocationData;
    private MapStatusUpdate mMapStatusUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mMapView = (MapView) findViewById(R.id.map_view);
        normalBtn = (Button) findViewById(R.id.map_normal);
        satelliteBtn = (Button) findViewById(R.id.map_satellite);
        trafficMapBtn = (Button) findViewById(R.id.traffic_map);
        heatMapBtn = (Button) findViewById(R.id.heart_map);
        makerBtn = (Button) findViewById(R.id.maker);
        openLocaBtn = (Button) findViewById(R.id.open_location);
        closeLocaBtn = (Button) findViewById(R.id.close_location);
        moveToPosition = (Button) findViewById(R.id.move_to_position);



        mLocationClient =new LocationClient(MyApp.getmContext());
        mLocationListener=new MyLocationListener();
        initLocation();
        mLocationClient.registerLocationListener(mLocationListener);
        mBaiduMap=mMapView.getMap();

        normalBtn.setOnClickListener(this);
        satelliteBtn.setOnClickListener(this);
        trafficMapBtn.setOnClickListener(this);
        heatMapBtn.setOnClickListener(this);
        makerBtn.setOnClickListener(this);
        openLocaBtn.setOnClickListener(this);
        closeLocaBtn.setOnClickListener(this);
        moveToPosition.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.map_normal:
            mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.map_satellite:
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.traffic_map:
                mBaiduMap.setTrafficEnabled(true);
                break;
            case R.id.heart_map:
                mBaiduMap.setBaiduHeatMapEnabled(true);
                break;
            case R.id.maker:
                mLatLng=new LatLng(39.963175, 116.400244);
                BitmapDescriptor bitmap= BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round);
                OverlayOptions options =new MarkerOptions().position(mLatLng).icon(bitmap);
                mBaiduMap.addOverlay(options);
                break;
            case R.id.open_location:
                mLocationClient.start();
                break;
            case R.id.close_location:
                mLocationClient.stop();
                break;
            case R.id.move_to_position:
                mMapStatusUpdate= MapStatusUpdateFactory.newLatLng(mLatLng);
                mBaiduMap.animateMapStatus(mMapStatusUpdate);
                BitmapDescriptor bitmap1= BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round);
                OverlayOptions options2 =new MarkerOptions().position(mLatLng).icon(bitmap1);
                mBaiduMap.addOverlay(options2);
                break;
        }
    }


    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系

//        int span=1000;
//        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);
    }


    public class MyLocationListener implements BDLocationListener{

        @Override
        public void onReceiveLocation(BDLocation location) {
            StringBuffer sb = new StringBuffer(256);

            sb.append("time : ");
            sb.append(location.getTime());    //获取定位时间

            sb.append("\nerror code : ");
            sb.append(location.getLocType());    //获取类型类型

            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());    //获取纬度信息

            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());    //获取经度信息

            sb.append("\nradius : ");
            sb.append(location.getRadius());    //获取定位精准度

            if (location.getLocType() == BDLocation.TypeGpsLocation){

                // GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());    // 单位：公里每小时

                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());    //获取卫星数

                sb.append("\nheight : ");
                sb.append(location.getAltitude());    //获取海拔高度信息，单位米

                sb.append("\ndirection : ");
                sb.append(location.getDirection());    //获取方向信息，单位度

                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){

                // 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());    //获取地址信息

                sb.append("\noperationers : ");
                sb.append(location.getOperators());    //获取运营商信息

                sb.append("\ndescribe : ");
                sb.append("网络定位成功");

            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {

                // 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");

            } else if (location.getLocType() == BDLocation.TypeServerError) {

                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");

            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {

                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");

            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {

                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");

            }

            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());    //位置语义化信息

            List<Poi> list = location.getPoiList();    // POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }

            }
            Log.e("BaiduLocationApiDem", sb.toString());


            mLocationData = new MyLocationData.Builder().accuracy(location.getRadius()).direction(100).latitude(location.getLatitude()).longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(mLocationData);
            mCurrentMarker = BitmapDescriptorFactory
                    .fromResource(R.mipmap.ic_launcher_round);
            MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, mCurrentMarker);
            mBaiduMap.setMyLocationConfigeration(config);
            mLatLng =new LatLng(location.getLatitude(),location.getLongitude());
            Log.e("MyLocationListener", "经度" + location.getRadius() + "纬度" + location.getLatitude());
            mMapStatusUpdate= MapStatusUpdateFactory.newLatLng(mLatLng);
            mBaiduMap.animateMapStatus(mMapStatusUpdate);
            BitmapDescriptor bitmap1= BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_round);
            OverlayOptions options2 =new MarkerOptions().position(mLatLng).icon(bitmap1);
            mBaiduMap.addOverlay(options2);
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }



}
