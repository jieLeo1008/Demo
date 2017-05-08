package com.example.jieleo.amapdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Gradient;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PoiSearch.OnPoiSearchListener {

    private MapView mMapView;
    //初始化地图控制器对象
    private AMap mAMap;

    //声明定位蓝点样式
    private MyLocationStyle mMyLocationStyle;

    private int TYPE_NAVI=0;//导航地图
    private int TYPE_NIGHT=1;//夜景地图
    private int TYPE_NORMALL=2;//白昼地图
    private int TYPE_SATELLITE=3;//卫星地图

    private Button naviBtn,nightBtn,normallBtn,satellteBtn,showTrafficBtn,showHeatMapBtn,searchBtn;

    private EditText searchEdt;


    private PoiSearch.Query mQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map_view);

        initView();
        bindEvent();

        //在activity执行onCreate时 执行onCreate（saveInstanceState），创建地图
        mMapView.onCreate(savedInstanceState);

        if (mAMap==null){
            mAMap=mMapView.getMap();
        }

        showBluePoint();


    }

    private void bindEvent() {
        naviBtn.setOnClickListener(this);
        nightBtn.setOnClickListener(this);
        normallBtn.setOnClickListener(this);
        satellteBtn.setOnClickListener(this);
        showTrafficBtn.setOnClickListener(this);
        showHeatMapBtn.setOnClickListener(this);
        searchBtn.setOnClickListener(this);
    }

    private void initView() {
        naviBtn = (Button) findViewById(R.id.navi_map);
        nightBtn = (Button) findViewById(R.id.night_map);
        normallBtn = (Button) findViewById(R.id.normall_map);
        satellteBtn = (Button) findViewById(R.id.satellite_map);
        showTrafficBtn = (Button) findViewById(R.id.show_traffic);
        showHeatMapBtn = (Button) findViewById(R.id.heat_map);
        searchBtn = (Button) findViewById(R.id.search_btn);
        searchEdt = (EditText) findViewById(R.id.search_Edt);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mapView.onDestroy 销毁地图
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);

    }


    public void showBluePoint(){
        mMyLocationStyle=new MyLocationStyle();//初始化定位蓝点样式
        mMyLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_SHOW);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
//        mMyLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_SHOW);//只定位一次。
//        mMyLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE) ;//定位一次，且将视角移动到地图中心点。
//        mMyLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_FOLLOW) ;//连续定位、且将视角移动到地图中心点，定位蓝点跟随设备移动。（1秒1次定位）
//        mMyLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_MAP_ROTATE);//连续定位、且将视角移动到地图中心点，地图依照设备方向旋转，定位点会跟随设备移动。（1秒1次定位）
        mMyLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。


//        mMyLocationStyle.myLocationIcon(getMyLocalIcon());
//        mMyLocationStyle.anchor(0.0f,0.0f);



        mAMap.setMyLocationStyle(mMyLocationStyle);//设置定位蓝点的Style
        //aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        mAMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。


    }

    public BitmapDescriptor getMyLocalIcon(){
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round);
        BitmapDescriptor bitmapDescriptor= BitmapDescriptorFactory.fromBitmap(bitmap);
        return bitmapDescriptor;
    }



    public void showHeatMap(){
        //生成热力点坐标列表
        LatLng[] latLngs=new LatLng[500];
        double x=39.904979;
        double y=116.40964;

        for (int i = 0; i < 500; i++) {
            double x_=0;
            double y_=0;

            x_=Math.random()*0.5-0.25;
            y_=Math.random()*0.5-0.25;
            latLngs[i] =new LatLng(x+x_,y+y_);
        }


        //构造热力图
        HeatmapTileProvider.Builder builder=new HeatmapTileProvider.Builder();
        builder.data(Arrays.asList(latLngs));
        HeatmapTileProvider heatmapTileProvider=builder.build();

        TileOverlayOptions tileOverlayOptions=new TileOverlayOptions();
        tileOverlayOptions.tileProvider(heatmapTileProvider);//设置瓦片层的提供者

        mAMap.addTileOverlay(tileOverlayOptions);


    }


    public void searchPoi(String keyword){
        mQuery=new PoiSearch.Query(keyword,"公司企业","大连市");
        mQuery.setPageSize(1);
        mQuery.setPageNum(1);

        PoiSearch poiSearch=new PoiSearch(this,mQuery);
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.searchPOIAsyn();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navi_map:
                mAMap.setMapType(AMap.MAP_TYPE_NAVI);
                break;
            case R.id.night_map:
                mAMap.setMapType(AMap.MAP_TYPE_NIGHT);
                break;
            case R.id.normall_map:
                mAMap.setMapType(AMap.MAP_TYPE_NORMAL);
                break;
            case R.id.satellite_map:
                mAMap.setMapType(AMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.show_traffic:
                mAMap.setTrafficEnabled(true);
                break;
            case R.id.heat_map:
                showHeatMap();
                break;
            case R.id.search_btn:
                searchPoi("友好广场");
                break;
        }
    }

    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {

        Log.d("MainActivity", "poiResult.getPois().get(0).getLatLonPoint().getLatitude():" + poiResult.getPois().get(0).getLatLonPoint().getLatitude());
        Log.d("MainActivity", "poiResult.getPois().get(0).getLatLonPoint().getLongitude():" + poiResult.getPois().get(0).getLatLonPoint().getLongitude());

    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {
        Log.d("MainActivity", "onPoiItemSearched");
    }
}
