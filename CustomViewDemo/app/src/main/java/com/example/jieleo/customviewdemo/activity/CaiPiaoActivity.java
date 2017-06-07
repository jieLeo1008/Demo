package com.example.jieleo.customviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jieleo.customviewdemo.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CaiPiaoActivity extends AppCompatActivity implements View.OnClickListener {


    private boolean finish = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_piao);
        findViewById(R.id.btn_01).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_01:
                String resultOne = getPartOne();
                Log.d("CaiPiaoActivity", resultOne);
                finish = true;
                break;
            case R.id.btn_02:
                Log.d("CaiPiaoActivity", getResult());
                break;
        }
    }

    private String getPartOne() {
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        List<Integer> list = new ArrayList<>();
        do {
            double x = Math.random() * 35 + 1;
            Log.d("CaiPiaoActivity", "x:" + x);
            if (a == 0) {
                a = (int) x;
                Log.d("CaiPiaoActivity", "a:" + a);
                list.add(a);
            }
            if (b == 0 && a != (int) x) {
                b = (int) x;
                Log.d("CaiPiaoActivity", "b:" + b);
                list.add(b);
            }
            if (c == 0 && a != (int) x && b != (int) x) {
                c = (int) x;
                Log.d("CaiPiaoActivity", "c:" + c);
                list.add(c);
            }
            if (d == 0 && a != (int) x && b != (int) x && c != (int) x) {
                d = (int) x;
                Log.d("CaiPiaoActivity", "d:" + d);
                list.add(d);
            }
            if (e == 0 && a != (int) x && b != (int) x && c != (int) x && d != (int) x) {
                e = (int) x;
                Log.d("CaiPiaoActivity", "e:" + e);
                list.add(e);
            }
            if (a > 0 && b > 0 && c > 0 && d > 0 && e > 0) {

                finish = false;

            }

        } while (finish);


        Collections.sort(list);

        Log.d("CaiPiaoActivity", "list:" + list);
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i) + "   ";
        }

        return result;
    }


    private String parseList(ArrayList<Integer> list, int value) {
        boolean finish = true;
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);
        int d = list.get(3);
        int e = list.get(4);
        do {
            if (value == 5) {
                if (a > 0 && a < 16 && b > 0 && b < 16) {
                    if (c > 15 && c < 20) {
                        if (d > 19 && d < 36 && e > 19 && e < 36) {
                            finish = false;
                        }
                    }
                }
            }
        } while (finish);
        return null;
    }


    private List<Integer> getArray() {
        finish=true;
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        List<Integer> list = new ArrayList<>();
        do {
            double x = Math.random() * 35 + 1;
            Log.d("CaiPiaoActivity", "x:" + x);
            if (a == 0) {
                a = (int) x;
                Log.d("CaiPiaoActivity", "a:" + a);
                list.add(a);
            }
            if (b == 0 && a != (int) x) {
                b = (int) x;
                Log.d("CaiPiaoActivity", "b:" + b);
                list.add(b);
            }
            if (c == 0 && a != (int) x && b != (int) x) {
                c = (int) x;
                Log.d("CaiPiaoActivity", "c:" + c);
                list.add(c);
            }
            if (d == 0 && a != (int) x && b != (int) x && c != (int) x) {
                d = (int) x;
                Log.d("CaiPiaoActivity", "d:" + d);
                list.add(d);
            }
            if (e == 0 && a != (int) x && b != (int) x && c != (int) x && d != (int) x) {
                e = (int) x;
                Log.d("CaiPiaoActivity", "e:" + e);
                list.add(e);
            }
            if (a > 0 && b > 0 && c > 0 && d > 0 && e > 0) {

                finish = false;

            }

        } while (finish);


        Collections.sort(list);
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i) + "   ";
        }
        Log.d("CaiPiaoActivity", result);
        Log.d("CaiPiaoActivity", "list.size():" + list.size());
        return list;
    }


    private boolean parseList(List<Integer> list, int value) {
        Log.d("CaiPiaoActivity", "list.size():" + list.size());
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        if (a[0] > 0 && a[0] < 16 && a[1] > 0 && a[1] < 16) {
            if (a[2] > 15 && a[2] < 21) {
                if (a[3] > 20 && a[3] < 36 && a[4] > 20 && a[4] < 36) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }


    private String getResult(){
        boolean over=true;
        List<Integer> list=new ArrayList<>();
        do {
            if (getArray()!=null){
             list=getArray();
            if (!parseList(list,5)){
                break;
            }
            }
        }while (over);

        Log.d("CaiPiaoActivity", "list:" + list);
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i) + "   ";
        }

        return result;
    }



}
