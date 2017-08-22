package com.example.jieleo.customviewdemo.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ShortcutManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jieleo.customviewdemo.R;

public class SetDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_details);
    }

    public void onClick(View view) {
//        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//        Uri uri = Uri.fromParts("package", this.getPackageName(), null);
//        intent.setData(uri);
//        startActivity(intent);

        removeShortCuts();

    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    private void removeShortCuts() {
        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
        shortcutManager.removeAllDynamicShortcuts();
    }


}
