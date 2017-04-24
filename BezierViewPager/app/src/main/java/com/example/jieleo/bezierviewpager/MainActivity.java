package com.example.jieleo.bezierviewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import qdx.bezierviewpager_compile.BezierRoundView;
import qdx.bezierviewpager_compile.vPage.BezierViewPager;
import qdx.bezierviewpager_compile.vPage.CardPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private List<String>  urlList;

    String oneUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492838873523&di=8af3d5dc8feb15d86c2402f60f26f27e&imgtype=0&src=http%3A%2F%2Fdown.laifudao.com%2Ftupian%2F20117418112.jpg";
    String twoUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492838873523&di=f7757e7234036e4022093123c0bf0087&imgtype=0&src=http%3A%2F%2Fww1.sinaimg.cn%2Flarge%2Fbca0b9cfjw1dzbw1juu4dj.jpg";
    String threeUrl="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492838914107&di=3cfa8c9a63dbd34ac2104df7becb5a97&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D979234693%2C2355123647%26fm%3D214%26gp%3D0.jpg";

    BezierViewPager mBezierViewPager;
    BezierRoundView mBezierRoundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlList=new ArrayList<>();
        urlList.add(oneUrl);
        urlList.add(twoUrl);
        urlList.add(threeUrl);
        CardPagerAdapter cardAdapter = new CardPagerAdapter(getApplicationContext());
        cardAdapter.addImgUrlList(urlList);  //放置图片url的list，v1.0.3版本imgList集合类型为List<Obj>，只要Glide支持的都可以加载

        BezierViewPager viewPager = (BezierViewPager) findViewById(R.id.view_page);
        viewPager.setAdapter(cardAdapter);

        BezierRoundView bezRound = (BezierRoundView) findViewById(R.id.bezRound);
        bezRound.attach2ViewPage(viewPager);


        cardAdapter.setOnCardItemClickListener(new CardPagerAdapter.OnCardItemClickListener() {
            @Override
            public void onClick(int i) {
                startActivity(new Intent(MainActivity.this,ViewPagerActivity.class));
//                Toast.makeText(MainActivity.this, "i:" + i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
