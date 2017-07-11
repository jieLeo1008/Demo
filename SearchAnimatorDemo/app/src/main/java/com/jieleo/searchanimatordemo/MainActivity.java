package com.jieleo.searchanimatordemo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SearchView mSearchView;

    private Button mButton;
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchView = (SearchView) findViewById(R.id.search_01);


        final AnimationSet animationSet =new AnimationSet(true);
        AlphaAnimation alphaAnimation =new AlphaAnimation(0,1);
        TranslateAnimation translateAnimation =new TranslateAnimation(0.1f,100f,0,0);
        translateAnimation.setDuration(1000);
        alphaAnimation.setDuration(1000);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        mSearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "打开", Toast.LENGTH_SHORT).show();
                mSearchView.setVisibility(View.INVISIBLE);
                mSearchView.startAnimation(animationSet);
            }
        });
        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Toast.makeText(MainActivity.this, "关闭", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        findViewById(R.id.btn_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
