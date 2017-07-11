package com.jieleo.tileoverlydemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.map.MapView;
import com.jieleo.tileoverlydemo.R;

/**
 * Created by YongJie on 2017/6/27.
 */

public class MapFragment extends Fragment {

    private MapView mMapView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_map,container,false);
        mMapView=view.findViewById(R.id.map_view);
        return view;
    }
}
