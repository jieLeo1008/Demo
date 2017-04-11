package com.example.jieleo.gallerydemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by OldFour on 2017/4/6.
 */

public class PageAdapter extends PagerAdapter {
    private List<ImageView>  mImageViews;

    public PageAdapter(List<ImageView> imageViews) {
        mImageViews = imageViews;
    }

    @Override
    public int getCount() {
        return mImageViews!=null?mImageViews.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=mImageViews.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
