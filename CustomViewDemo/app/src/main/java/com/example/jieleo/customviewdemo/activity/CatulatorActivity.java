package com.example.jieleo.customviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatulatorActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "CatulatorActivity";

    private EditText mEditText1,mEditText2,mEditText3,mEditText4,mEditText5;
                int[]  num=new int[35];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catulator);

        mEditText1 = (EditText) findViewById(R.id.edt_01);
        mEditText2 = (EditText) findViewById(R.id.edt_02);
        mEditText3 = (EditText) findViewById(R.id.edt_03);
        mEditText4 = (EditText) findViewById(R.id.edt_04);
        mEditText5 = (EditText) findViewById(R.id.edt_05);

        findViewById(R.id.btn_01).setOnClickListener(this);
        findViewById(R.id.btn_02).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_01:
                boolean next=true;
                int a=Integer.valueOf(mEditText1.getText().toString());
                int b=Integer.valueOf(mEditText2.getText().toString());
                int c=Integer.valueOf(mEditText3.getText().toString());
                int d=Integer.valueOf(mEditText4.getText().toString());
                int e=Integer.valueOf(mEditText5.getText().toString());
                List<Integer>  list=new ArrayList<>();
                list.add(a);
                list.add(b);
                list.add(c);
                list.add(d);
                list.add(e);
                Collections.sort(list);
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (i==j){
                            break;
                        }
                        if (list.get(i)==list.get(j)){
                            next=false;
                        }

                    }
                        if (list.get(i)>35){
                            Toast.makeText(this, "输入的数据不合法", Toast.LENGTH_SHORT).show();
                            next=false;
                        }
                }
                if (next){
                    for (int i = 0; i < list.size(); i++) {
                        int x=list.get(i);
                        num[x-1]+=1;
                    }


                mEditText1.setText("");
                mEditText2.setText("");
                mEditText3.setText("");
                mEditText4.setText("");
                mEditText5.setText("");

                }



                break;


            case R.id.btn_02:
                int count=0;
                for (int i = 0; i < num.length; i++) {
                    count+=num[i];

                }

                for (int i = 0; i < num.length; i++) {
                    double y =(num[i]+0.00)/count*100;
                    Log.e(TAG, "onClick: "+ "  "+(i+1)+"  "+y+"   ");
                }


                break;
        }
    }
}
