package com.example.jieleo.customviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.bean.ProvinceBean;
import com.example.jieleo.customviewdemo.tool.CallBack;
import com.example.jieleo.customviewdemo.tool.NetTool;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.util.ArrayList;
import java.util.List;

public class WheelAddressSelectActivity extends AppCompatActivity {

    private String ProvinceUrl = "http://app24.app.longcai.net/index.php/interfaces/area/province_list";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whell_address_select);

        WheelView wheelView= (WheelView) findViewById(R.id.my_wheel);

        wheelView.setWheelAdapter(new ArrayWheelAdapter(this));

        wheelView.setSkin(WheelView.Skin.Holo);


        NetTool.getInstance().getDataFromUrl(ProvinceUrl, ProvinceBean.class, new CallBack<ProvinceBean>() {
            @Override
            public void onSuccess(ProvinceBean response) {
                List<String> list =new ArrayList<String>();

                for (ProvinceBean.DataBean dataBean : response.getData()) {
                        list.add(dataBean.getArea_name());
                }
                wheelView.setWheelData(list);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });



        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
            @Override
            public void onItemSelected(int position, Object o) {
                Log.d("WheelAddressSelectActiv", "position:" + position + "Name" + o.toString());
            }
        });

        wheelView.setWheelClickable(true);

        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onItemClick(int position, Object o) {
                Log.d("WheelAddressSelectActiv", "position:" + position + "Name" + o.toString());

            }
        });
    }
}
