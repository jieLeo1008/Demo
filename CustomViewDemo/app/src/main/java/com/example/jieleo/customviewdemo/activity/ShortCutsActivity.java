package com.example.jieleo.customviewdemo.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jieleo.customviewdemo.R;

import java.util.Arrays;

public class ShortCutsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_cuts);

        makeShortCuts();

    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    private void makeShortCuts(){
        ShortcutManager shortcutManager =getSystemService(ShortcutManager.class);

        ShortcutInfo shortcutInfo =new ShortcutInfo.Builder(this,"id1")
                .setShortLabel("Web Site")
                .setLongLabel("Open the Web")
                .setIcon(Icon.createWithResource(this,R.drawable.ic_launcher_round))
                .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com")))
                .build();


        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcutInfo));
    }
}
