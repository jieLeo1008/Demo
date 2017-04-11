package com.leisure.annotationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
/**
 *  @硕哥告诉你
 *  2017/4/6上午9:27
 *  本demo首先从MyContentView这个类开始看,然后再看另外两个自定义的注解
 *  再看我的ViewTool
 *  最后再来看MainActivity
 *  ViewTool的这个类涉及到了我所讲过的反射,我知道你们肯定忘了,所以再自己看一看我那天讲的东西
 *  我使用自定义注解的方式实现了ButterKnife的效果  不要问我什么是ButterKnife,我讲过!!!!!
 */
@MyContentView(R.layout.activity_main)

public class MainActivity extends AppCompatActivity {
    @MyFindViewById(R.id.tv)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewTool.inject(this);
    }

    @MyClick(R.id.tv)
    public void click(View view){
        switch (view.getId()) {
            case R.id.tv:
                Toast.makeText(MainActivity.this, "aaaa", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewTool.unInject();
    }
}
