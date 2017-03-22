package com.jieleo.liteorm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        private List<Bean>   mBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LiteOrm liteOrm=LiteOrm.newCascadeInstance(this,"Person.db");
        Bean bean=new Bean("姜弘",23,"女");
        liteOrm.insert(bean);
        mBeen=new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Bean bean1 =new Bean("姜小红",i,"女");
            mBeen.add(bean1);
        }

        liteOrm.insert(mBeen);
        liteOrm.save(mBeen);


        Bean bean1=new Bean("姜小红",20,"女");
        liteOrm.delete(bean1);

        ArrayList<Bean>   list =liteOrm.query(Bean.class);
        for (Bean bean3:list) {
            Log.d("MainActivity", bean3.getName() + bean3.getAge() + bean3.getSex());
        }
        liteOrm.deleteAll(Bean.class);
        liteOrm.deleteDatabase();
    }
}
