package com.example.jieleo.customviewdemo.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class DLTActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @InjectView(R.id.tv_01)
    TextView mTv01;
    @InjectView(R.id.edt_01)
    EditText mEdt01;
    @InjectView(R.id.edt_02)
    EditText mEdt02;
    @InjectView(R.id.edt_03)
    EditText mEdt03;
    @InjectView(R.id.btn_01)
    Button mBtn01;
    @InjectView(R.id.tv_02)
    TextView mTv02;
    @InjectView(R.id.tv_03)
    TextView mTv03;
    @InjectView(R.id.tv_04)
    TextView mTv04;

    private String[] partOne = new String[5];
    private String[] partTwo = new String[2];
    private boolean finish = true;
    private List<String>  mList ;
    private ListPopupWindow mListPopupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dlt);
        ButterKnife.inject(this);

        mEdt01.setInputType(InputType.TYPE_CLASS_NUMBER);
        mEdt02.setInputType(InputType.TYPE_CLASS_NUMBER);
        mEdt03.setInputType(InputType.TYPE_CLASS_NUMBER);

        mList=new ArrayList<>();
        mList.add("第一个");
        mList.add("第二个");
        mList.add("第三个");
        mList.add("第四个");
        mList.add("第五个");
        mList.add("第六个");


    }


    @OnClick({R.id.tv_01, R.id.btn_01})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_01:
                showPop(mList);
                mListPopupWindow.setDropDownGravity(Gravity.END);
                mListPopupWindow.setAnchorView(view);
                mListPopupWindow.show();

                break;
            case R.id.btn_01:
                int first = Integer.valueOf(mEdt01.getText().toString());
                int second = Integer.valueOf(mEdt02.getText().toString());
                int third = Integer.valueOf(mEdt03.getText().toString());
                if ((first + second + third) == 5 && first >= 0 && first <= 5 && second >= 0 && second <= 5 && third >= 0 && third <= 5) {

                } else {
                    Toast.makeText(this, "输入有误    请重新输入", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }


    /**
     * 判断传入的集合是否符合要求
     *
     * @param list   传入的集合
     * @param first  第一区间要求的个数
     * @param second 第二区间要求的个数
     * @param third  第三区间要求的个数
     * @return
     */
    private boolean parseList(List<Integer> list, int first, int second, int third) {
        int a = 0, b = 0, c = 0;
        //遍历集合判断所在区间个数
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            if (x > 0 && x < 11) {
                a++;
            }
            if (x > 10 && x < 26) {
                b++;
            }
            if (x > 25 && x < 36) {
                c++;
            }
        }
        if (a == first && b == second && c == third) {
            return true;
        } else {
            return false;
        }

    }


    /**
     *   产生对应长度的集合
     * @param i 集合的长度
     * @return  对应长度的集合
     */
    private List<Integer> createList(int i) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            double x = Math.random() * 35 + 1;
            list.add((int) x);
        }
        return list;
    }

    /**
     *  处理集合 使之符合要求
     * @param i 需要多大的集合
     * @return  需要的集合
     */
    private List<Integer> parseList(int i) {
        boolean finish = true;
        int count = 0;
        List<Integer> list;
        do {
            list = createList(i);
            OUT:
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    if (j == k) {
                        break;
                    } else {
                        if (list.get(j) == list.get(k)) {
                            count++;
                            break OUT;//如果有不同位置相同元素  跳出最大循环
                        }
                    }
                }
            }

            if (count == 0) {
                finish = false;
            } else {
                count = 0;
            }

        } while (finish);

        Collections.sort(list);
        for (int j = 0; j < list.size(); j++) {
            Log.d("DLTActivity", "list.get(i):" + list.get(j));
        }

        return list;
    }

    private void  showPop(List<String> list){
        mListPopupWindow =new ListPopupWindow(this);
        ArrayAdapter adapter =new ArrayAdapter(this,R.layout.item_spiner,mList);
        mListPopupWindow.setAdapter(adapter);
        mListPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mListPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mListPopupWindow.setModal(true);
        mListPopupWindow.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mTv01.setText(mList.get(position));
        mListPopupWindow.dismiss();
    }
}
