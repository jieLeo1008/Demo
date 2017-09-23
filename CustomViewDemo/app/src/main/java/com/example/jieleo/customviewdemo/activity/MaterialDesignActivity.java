package com.example.jieleo.customviewdemo.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;

public class MaterialDesignActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);


        mToolbar.setTitle("Title");

        mToolbar.setSubtitle("Subtitle");

        mToolbar.setLogo(R.mipmap.icon_address_arrow_selected);

        setSupportActionBar(mToolbar);

        mToolbar.setNavigationIcon(R.mipmap.icon_address_arrow_selected);


        mToolbar.setPopupTheme(R.style.ToolBarPopMenu);
        /**
         * ToolBar Menu的点击事件
         */
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_search:
                        Toast.makeText(MaterialDesignActivity.this, "Search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_notification:
                        Toast.makeText(MaterialDesignActivity.this, "notificaion", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:
                        Toast.makeText(MaterialDesignActivity.this, "setting", Toast.LENGTH_SHORT).show();
                        break;

                }


                return true;
            }
        });



        findViewById(R.id.snack_bar).setOnClickListener(this);

        findViewById(R.id.fla_btn).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.snack_bar:

                Snackbar.make(view,"真的要点我",Snackbar.LENGTH_LONG).setAction("真的？", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MaterialDesignActivity.this, "点就点吧", Toast.LENGTH_SHORT).show();
                    }
                }).show();

                break;
            case R.id.fla_btn:

                Toast.makeText(this, "回到顶部", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
