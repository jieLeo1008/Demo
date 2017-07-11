package com.jieleo.bikenavidemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.baidu.mapapi.bikenavi.BikeNavigateHelper;
import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.model.BikeRouteDetailInfo;
import com.baidu.mapapi.bikenavi.model.BikeRoutePlanError;
import com.baidu.mapapi.bikenavi.params.BikeNaviLauchParam;
import com.baidu.mapapi.model.LatLng;

/**
 * Created by YongJie on 2017/6/23.
 */

public class GuideActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = BikeNavigateHelper.getInstance().onCreate(this);
        setContentView(view);
        BikeNavigateHelper.getInstance().routePlanWithParams(new BikeNaviLauchParam().stPt(new LatLng(39.086705, 122.009147)).endPt(new LatLng(39.087561, 122.010216)), new IBRoutePlanListener() {
            @Override
            public void onRoutePlanStart() {
                Toast.makeText(GuideActivity.this, "开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRoutePlanSuccess() {
                Toast.makeText(GuideActivity.this, "success", Toast.LENGTH_SHORT).show();
                BikeNavigateHelper.getInstance().startBikeNavi(GuideActivity.this);
            }

            @Override
            public void onRoutePlanFail(BikeRoutePlanError bikeRoutePlanError) {

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
