package com.example.jieleo.customviewdemo.activity;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.utils.IdCard.IdCardUtil;
import com.example.jieleo.customviewdemo.utils.IdCard.RegexUtil;

import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class IdCardActivity extends AppCompatActivity {

    @InjectView(R.id.edt_01)
    EditText mEdt01;
    @InjectView(R.id.btn_01)
    Button mBtn01;


    String[] IDCARD = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",  "X", };


    final List<String>  idCardList = Arrays.asList(IDCARD);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_card);

        ButterKnife.inject(this);


        InputFilter inputFilter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = 0; i < source.toString().length(); i++) {
                    if (!idCardList.contains(String.valueOf(source.charAt(i)))){
                        return "";
                    }
                    if (mEdt01.getText().toString().length()<17){
                        if ("x".equals(String.valueOf(source.charAt(i)))||"X".equals(String.valueOf(source.charAt(i)))){
                            return "";
                        }
                    }
                }
                return null;
            }
        };

        mEdt01.setFilters(new InputFilter[]{new InputFilter.LengthFilter(18),inputFilter});

    }

    @OnClick(R.id.btn_01)
    public void onViewClicked() {

            String result=mEdt01.getText().toString();

            if (RegexUtil.isIDCard(result)&&RegexUtil.isRealIDCard(result)){
                Toast.makeText(this, "身份证验证成功", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "身份证号码验证不通过", Toast.LENGTH_SHORT).show();
            }
    }
}
