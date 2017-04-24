package com.example.jieleo.bezierviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager  mViewPager;
    private TabLayout mTabLayout;
    private MyAdapter mAdapter;

    private List<String>  urlList;

    String oneUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492838873523&di=8af3d5dc8feb15d86c2402f60f26f27e&imgtype=0&src=http%3A%2F%2Fdown.laifudao.com%2Ftupian%2F20117418112.jpg";
    String twoUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492838873523&di=f7757e7234036e4022093123c0bf0087&imgtype=0&src=http%3A%2F%2Fww1.sinaimg.cn%2Flarge%2Fbca0b9cfjw1dzbw1juu4dj.jpg";
    String threeUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492838914107&di=3cfa8c9a63dbd34ac2104df7becb5a97&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D979234693%2C2355123647%26fm%3D214%26gp%3D0.jpg";
    String fourUrl="http://img3.imgtn.bdimg.com/it/u=2284109350,2364555117&fm=23&gp=0.jpg";
    String fiveUrl="http://s1.sinaimg.cn/middle/506cc9abt7a716c03f0a0&690";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewPager = (ViewPager) findViewById(R.id.my_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager.setClipToPadding(false);

        urlList=new ArrayList<>();
        urlList.add(oneUrl);
        urlList.add(twoUrl);
        urlList.add(threeUrl);
        urlList.add(fourUrl);
        urlList.add(fiveUrl);

        mAdapter=new MyAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mAdapter.setUrlList(urlList);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int currentposition;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentposition=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state!=ViewPager.SCROLL_STATE_IDLE){
                    return;
                }else if (currentposition==0){
                    mViewPager.setCurrentItem(urlList.size()-2,true);
                }else if (currentposition==urlList.size()-1){
                    mViewPager.setCurrentItem(1,true);
                }
            }
        });
    }
}
