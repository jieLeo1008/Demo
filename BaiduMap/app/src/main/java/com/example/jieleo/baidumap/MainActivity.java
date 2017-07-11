package com.example.jieleo.baidumap;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.FileTileProvider;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Tile;
import com.baidu.mapapi.map.TileOverlay;
import com.baidu.mapapi.map.TileOverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private TileOverlay mTileOverlay;
    private Tile offlineTile;
    private Marker mMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView = (MapView) findViewById(R.id.map_view);
        mMapView.setMapCustomEnable(true);
        mBaiduMap = mMapView.getMap();


        mBaiduMap.setOnMapLoadedCallback(new BaiduMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                LatLng northEast = new LatLng(39.095164, 122.014586);
                LatLng southWest = new LatLng(39.073656, 121.988643);

//        mBaiduMap.setMaxAndMinZoomLevel(17f,14f);//设置最大最小缩放值
                mBaiduMap.setMapStatusLimits(new LatLngBounds.Builder().include(northEast).include(southWest).build());

                //设置地图默认显示的地方
                LatLng centerPoint = new LatLng(39.086705, 122.009147);
                MapStatus mapStatus = new MapStatus.Builder()
                        .target(centerPoint)
                        .zoom(17)
                        .build();
                MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
                mBaiduMap.setMapStatus(mapStatusUpdate);

            }
        });



        FileTileProvider tileProvider = new FileTileProvider() {
            @Override
            public Tile getTile(int i, int i1, int i2) {
                Log.d("MainActivity", "i:" + i);
                Log.d("MainActivity", "i1:" + i1);
                Log.d("MainActivity", "i2:" + i2);
                String filedir = "LocalTileImage/" + i2 + "/" + i2 + "_" + i + "_" + i1 + ".jpg";
                Bitmap bm = getFromAssets(filedir);
                if (bm == null) {
                    return null;
                }
                // 瓦片图尺寸必须满足256 * 256
                offlineTile = new Tile(bm.getWidth(), bm.getHeight(), toRawData(bm));
                bm.recycle();
                return offlineTile;
            }

            @Override
            public int getMaxDisLevel() {
                return 20;
            }

            @Override
            public int getMinDisLevel() {
                return 15;
            }
        };

        //设置地图显示的区域
        LatLng northEast = new LatLng(39.095164, 122.014586);
        LatLng southWest = new LatLng(39.073656, 121.988643);
//
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.tileProvider(tileProvider).setPositionFromBounds(new LatLngBounds.Builder().include(northEast).include(southWest).build());
        mTileOverlay = mBaiduMap.addTileLayer(tileOverlayOptions);


        List<LatLng> pointList = new ArrayList<>();
        pointList.add(new LatLng(39.086705, 122.009147));
        pointList.add(new LatLng(39.087561, 122.010216));
        pointList.add(new LatLng(39.083978, 122.006781));
        pointList.add(new LatLng(39.088267, 122.009192));
        pointList.add(new LatLng(39.087712, 122.007178));
        for (int i = 0; i < pointList.size(); i++) {
            OverlayOptions options=new MarkerOptions().position(pointList.get(i)).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)).period(i+1);
            mBaiduMap.addOverlay(options);
        }
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getPeriod() < 6) {
                    if (mMarker!=null){
                        mMarker.remove();
                    }
                    LatLng latLng = marker.getPosition();
                    BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.huanyingdao);
                    OverlayOptions options1 = new MarkerOptions().position(latLng).icon(bitmapDescriptor).period(marker.getPeriod() + 5);
                    mMarker= (Marker) mBaiduMap.addOverlay(options1);

                } else if (marker.getPeriod() > 5) {
                    Toast.makeText(MainActivity.this, "跳转"+marker.getPeriod(), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                    intent.putExtra("xx","王钱钱");
                    intent.putExtra("Lat",marker.getPosition().latitude);
                    intent.putExtra("Lng",marker.getPosition().longitude);
                    startActivity(intent);
                }
                return false;
            }
        });


    }


    byte[] toRawData(Bitmap bitmap) {
        ByteBuffer buffer = ByteBuffer.allocate(bitmap.getWidth()
                * bitmap.getHeight() * 4);
        bitmap.copyPixelsToBuffer(buffer);
        byte[] data = buffer.array();
        buffer.clear();
        return data;
    }


    public Bitmap getFromAssets(String fileName) {
        AssetManager am = this.getAssets();
        InputStream is = null;
        Bitmap bm;

        try {
            is = am.open(fileName);
            bm = BitmapFactory.decodeStream(is);
            return bm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
