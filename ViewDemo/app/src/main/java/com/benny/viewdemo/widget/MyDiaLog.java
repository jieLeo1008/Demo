package com.benny.viewdemo.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.benny.viewdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Benny on 2018/3/13.
 */

public class MyDiaLog extends Dialog {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.confirm_tv)
    TextView mConfirmTv;
    @BindView(R.id.cancel_tv)
    TextView mCancelTv;

    private String title;

    private String left;

    private String right;

    private OnClick mOnClick;

    public MyDiaLog setTitle(String title) {
        this.title = title;
        return this;
    }

    public MyDiaLog setLeft(String left) {
        this.left = left;
        return this;
    }

    public MyDiaLog setRight(String right) {
        this.right = right;
        return this;
    }

    public MyDiaLog setOnClick(OnClick onClick) {
        mOnClick = onClick;
        return this;
    }


    public MyDiaLog(@NonNull Context context, int themeResId) {
        super(context, R.style.MyDialog);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_dialog);
        ButterKnife.bind(this);
        setCanceledOnTouchOutside(false);
        mTitle.setText(title);
        mConfirmTv.setText(left);
        mCancelTv.setText(right);

    }

    @butterknife.OnClick({R.id.confirm_tv, R.id.cancel_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.confirm_tv:
                mOnClick.onClickLeft();
                break;
            case R.id.cancel_tv:
                mOnClick.onClickRight();
                break;
        }
    }




    public interface OnClick {
        void onClickLeft();

        void onClickRight();
    }

}
