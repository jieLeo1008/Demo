package com.example.jieleo.huanxin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by OldFour on 2017/5/9.
 */

public class MyFragementPageAdapter extends FragmentPagerAdapter {

    String[] title={"会话","联系人","设置"};

    private List<Fragment>  mFragments;
    public MyFragementPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyFragementPageAdapter setFragments(List<Fragment> fragments) {
        mFragments = fragments;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments!=null?mFragments.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
