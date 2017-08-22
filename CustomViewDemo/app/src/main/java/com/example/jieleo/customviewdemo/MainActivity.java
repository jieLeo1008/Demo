package com.example.jieleo.customviewdemo;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.activity.AddressSelectorActivity;
import com.example.jieleo.customviewdemo.activity.BlueToothActivity;
import com.example.jieleo.customviewdemo.activity.BottomSheetActivity;
import com.example.jieleo.customviewdemo.activity.CaiPiaoActivity;
import com.example.jieleo.customviewdemo.activity.CatulatorActivity;
import com.example.jieleo.customviewdemo.activity.DLTActivity;
import com.example.jieleo.customviewdemo.activity.DownloadActivity;
import com.example.jieleo.customviewdemo.activity.IdCardActivity;
import com.example.jieleo.customviewdemo.activity.ImmersiveActivity;
import com.example.jieleo.customviewdemo.activity.ItemDecorationActivity;
import com.example.jieleo.customviewdemo.activity.MyItemActivity;
import com.example.jieleo.customviewdemo.activity.MyNotificationActivity;
import com.example.jieleo.customviewdemo.activity.ObjectAnimatorActivity;
import com.example.jieleo.customviewdemo.activity.ScratchImageViewActivity;
import com.example.jieleo.customviewdemo.activity.ServerActivity;
import com.example.jieleo.customviewdemo.activity.SetDetailsActivity;
import com.example.jieleo.customviewdemo.activity.ShortCutsActivity;
import com.example.jieleo.customviewdemo.activity.StarAnimActivity;
import com.example.jieleo.customviewdemo.activity.SwipeDelActivity;
import com.example.jieleo.customviewdemo.activity.TextInputLayoutActivity;
import com.example.jieleo.customviewdemo.activity.ToBrowseActivity;
import com.example.jieleo.customviewdemo.activity.UltraViewPagerActivity;
import com.example.jieleo.customviewdemo.activity.ZhiHuMatisseActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.password_view:
                break;
            case R.id.item_decoration:
                startActivity(new Intent(this,ItemDecorationActivity.class));
                break;
            case R.id.object_animator:
                startActivity(new Intent(this,ObjectAnimatorActivity.class));
                break;
            case R.id.bga_aty:
//                startActivity(new Intent(this,BGABadgeViewActivity.class));
                break;
            case R.id.text_input_layout:
                startActivity(new Intent(this,TextInputLayoutActivity.class));
                break;
            case R.id.caipiao:
                startActivity(new Intent(this,CaiPiaoActivity.class));
                break;
            case R.id.catulator:
                startActivity(new Intent(this,CatulatorActivity.class));
                break;
            case R.id.awesome_qr_code:
//                startActivity(new Intent(this,QRCodeActivity.class));
                break;
            case R.id.dlt:
                startActivity(new Intent(this,DLTActivity.class));
                break;
            case R.id.bitmap_size:
                startActivity(new Intent(this,MyItemActivity.class));
                break;
            case R.id.immersive:
                startActivity(new Intent(this,ImmersiveActivity.class));
                break;
            case R.id.to_browse:
                startActivity(new Intent(this,ToBrowseActivity.class));
                break;
            case R.id.select_address:
                startActivity(new Intent(this,AddressSelectorActivity.class));
                break;
            case  R.id.app_details:
                startActivity(new Intent(this,SetDetailsActivity.class));
                break;
            case R.id.short_cuts:
                startActivity(new Intent(this,ShortCutsActivity.class));
                break;
            case R.id.to_server:
                startActivity(new Intent(this,ServerActivity.class));
                break;
            case R.id.blue_tooth:
                startActivity(new Intent(this,BlueToothActivity.class));
                break;
            case R.id.id_card:
                startActivity(new Intent(this,IdCardActivity.class));
                break;
            case R.id.download_service:
                startActivity(new Intent(this,DownloadActivity.class));
                break;
            case R.id.android_n_camera:
                startActivity(new Intent(this,MyNotificationActivity.class));
                break;
            case R.id.ultra_view_pager:
                startActivity(new Intent(this,UltraViewPagerActivity.class));
                break;
            case R.id.matisse:
                startActivity(new Intent(this,ZhiHuMatisseActivity.class));
                break;
            case R.id.bottom_sheet:
                startActivity(new Intent(this,BottomSheetActivity.class));
                break;
            case R.id.swipe_delete:
                startActivity(new Intent(this,SwipeDelActivity.class));
                break;
            case R.id.scratch_view:
                startActivity(new Intent(this, ScratchImageViewActivity.class));
                break;
            case R.id.start_anim:
                startActivity(new Intent(this, StarAnimActivity.class));
                break;


        }



    }

}
