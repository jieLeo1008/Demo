package com.example.jieleo.customviewdemo.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.jieleo.customviewdemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BlueToothActivity extends AppCompatActivity {


    BluetoothAdapter mBluetoothAdapter;

    BluetoothGatt mBluetoothGatt;

    @InjectView(R.id.tv_01)
    TextView mTv01;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth);
        ButterKnife.inject(this);
        //获取bluetoothAdapter
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);

        if (supportBLE()) {

            mBluetoothAdapter = bluetoothManager.getAdapter();

            if(mBluetoothAdapter!=null){
                mTv01.setText("蓝牙是否开启"+mBluetoothAdapter.isEnabled());

                Intent intent =new Intent(); intent.setAction("Android.intent.action.VIEW");
                Uri uri =Uri.parse("https://item.taobao.com/item.htm?spm=a21bo.50862.201867-rmds-0.1.5dcec6f7aA3DPn&scm=1007.12807.84406.100200300000004&id=553345999996&pvid=7ec3b0f0-634a-4abf-a98d-76a34ef89cfb");
                intent.setData(uri);
                intent.setClassName("com.taobao.taobao","com.taobao.tao.detail.activity.DetailActivity");
                startActivity(intent);
            }
        }








    }


    private boolean supportBLE() {
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            return false;
        } else {
            return true;
        }
    }
}
