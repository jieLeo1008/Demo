package com.benny.viewdemo.ui.java.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.benny.viewdemo.R;
import com.benny.viewdemo.ui.java.fragment.NextFragment;
import com.benny.viewdemo.ui.java.fragment.ResuseFragment;
import com.benny.viewdemo.widget.MyDiaLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.vp01)
    ViewPager mVp01;

    List<String> url = new ArrayList<>();
    @BindView(R.id.btn_01)
    Button mBtn01;

    private boolean canJump;
    private int currenPos;
    private boolean canLeft;


    private MyDiaLog mMyDiaLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        for (int i = 0; i < 5; i++) {
            url.add("aaaaa");
        }
        mVp01.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        mVp01.setOffscreenPageLimit(2);


        mVp01.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == url.size() - 1) {
                    if (positionOffset > 0.35) {
                        canJump = true;
                    } else if (positionOffset > 0 && positionOffset <= 0.35) {
                        canJump = false;
                    }
                    canLeft = false;
                } else {
                    canLeft = true;
                }
            }

            @Override
            public void onPageSelected(int position) {
                currenPos = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (currenPos == url.size() - 1 && !canLeft) {
                    if (state == ViewPager.SCROLL_STATE_SETTLING) {
                        if (canJump) {
                            Toast.makeText(ViewPagerActivity.this, "跳转了", Toast.LENGTH_SHORT).show();
                            new Handler().post(new Runnable() {
                                @Override
                                public void run() {
                                    mVp01.setCurrentItem(2);
                                }
                            });
                        }
                    }
                }
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @OnClick(R.id.btn_01)
    public void onViewClicked() {

       mMyDiaLog= new MyDiaLog(this,R.style.MyDialog).setTitle("提示").setLeft("确定").setRight("取消").setOnClick(new MyDiaLog.OnClick() {
            @Override
            public void onClickLeft() {
                Toast.makeText(ViewPagerActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickRight() {
                mMyDiaLog.dismiss();
            }
        });
       mMyDiaLog.show();
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return url.size() + 1;
        }

        @Override
        public Fragment getItem(int position) {
            if (position < url.size()) {
                return ResuseFragment.newInstance(position, (ArrayList<String>) url);
            } else {
                return new NextFragment();
            }
        }


    }
}
