package com.example.jieleo.bezierviewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by OldFour on 2017/4/23.
 */

public class MyAdapter extends FragmentPagerAdapter{
    private Context context;

    private List<String>  urlList;

    private String[] title={"第一页","第二页","第三页","第四页","第五页"};


    public MyAdapter setUrlList(List<String> urlList) {
        this.urlList = urlList;
        notifyDataSetChanged();
        return this;
    }

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return FirstFragment.newInstance(urlList.get(position));
    }

    @Override
    public int getCount() {
        return urlList==null?0:urlList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
