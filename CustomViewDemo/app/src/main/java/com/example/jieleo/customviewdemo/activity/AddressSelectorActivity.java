package com.example.jieleo.customviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.bean.CityBean;
import com.example.jieleo.customviewdemo.bean.ProvinceBean;
import com.example.jieleo.customviewdemo.tool.CallBack;
import com.example.jieleo.customviewdemo.tool.NetTool;
import com.mic.adressselectorlib.AddressSelector;
import com.mic.adressselectorlib.CityInterface;
import com.mic.adressselectorlib.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 地址选择器
 */
public class AddressSelectorActivity extends AppCompatActivity {

    private AddressSelector mAddressSelector;

    private ArrayList<ProvinceBean.DataBean> mProvinceBean = new ArrayList<>();
    private ArrayList<CityBean.DataBean> mCityBean = new ArrayList<>();

    private String ProvinceUrl = "http://app24.app.longcai.net/index.php/interfaces/area/province_list";

    private String cityUrl = "http://app24.app.longcai.net/index.php/interfaces/area/city_list?area_id=";
    private int cityId;
    private String provinceName;
    private String cityName;
    private String placeName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_selector);

        mAddressSelector = (AddressSelector) findViewById(R.id.address_selector);
        //设置Tab数量
        mAddressSelector.setTabAmount(3);

        NetTool.getInstance().getDataFromUrl(ProvinceUrl, ProvinceBean.class, new CallBack<ProvinceBean>() {
            @Override
            public void onSuccess(ProvinceBean response) {
                mProvinceBean = response.getData();
                mAddressSelector.setCities(mProvinceBean);

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });


        //设置数据列表的Item回调
        mAddressSelector.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void itemClick(final AddressSelector addressSelector, CityInterface cityInterface, int i) {
                Log.d("AddressSelectorActivity", "addressSelector.getId():" + addressSelector.getId());
                cityId = cityInterface.getAreaId();
                switch (i) {
//                    case 0:
////                        addressSelector.setCities(mProvinceBean);
//                        cityId = cityInterface.getAreaId();
//                        break;
                    case 0:
                        provinceName=cityInterface.getCityName();
                        NetTool.getInstance().getDataFromUrl(cityUrl + cityId, CityBean.class, new CallBack<CityBean>() {
                            @Override
                            public void onSuccess(CityBean response) {
                                mCityBean=response.getData();
                                addressSelector.setCities(response.getData());
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                Toast.makeText(AddressSelectorActivity.this, "throwable:" + throwable, Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case 1:
                        cityName=cityInterface.getCityName();
                        NetTool.getInstance().getDataFromUrl(cityUrl + cityId, CityBean.class, new CallBack<CityBean>() {
                            @Override
                            public void onSuccess(CityBean response) {
                                addressSelector.setCities(response.getData());
                            }

                            @Override
                            public void onError(Throwable throwable) {
                                Toast.makeText(AddressSelectorActivity.this, "throwable:" + throwable, Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                    case 2:
                        placeName=cityInterface.getCityName();

                        Toast.makeText(AddressSelectorActivity.this, provinceName+cityName+placeName, Toast.LENGTH_SHORT).show();
                        break;

                }
//                Log.d("AddressSelectorActivity", "i:" + i);
//                String url =cityUrl+mProvinceBean.get(i).getArea_id();
//
//                NetTool.getInstance().getDataFromUrl(url, CityBean.class, new CallBack<CityBean>() {
//                    @Override
//                    public void onSuccess(CityBean response) {
//                        mAddressSelector.setCities(response.getData());
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//
//                    }
//                });
            }
        });



        mAddressSelector.setOnTabSelectedListener(new AddressSelector.OnTabSelectedListener() {
            @Override
            public void onTabSelected(AddressSelector addressSelector, AddressSelector.Tab tab) {
                Log.d("AddressSelectorActivity", "tab.getIndex():" + tab.getIndex());
                switch (tab.getIndex()) {
                    case 0:
                        mAddressSelector.setCities(mProvinceBean);
                        tab.setText("请选择");
                        break;
                    case 1:
                        mAddressSelector.setCities(mCityBean);
                        tab.setText("请选择");
                        break;
                }
            }

            @Override
            public void onTabReselected(AddressSelector addressSelector, AddressSelector.Tab tab) {
                Log.d("AddressSelectorActivity", "tab.getIndex():" + tab.getIndex());
            }
        });


    }
}
