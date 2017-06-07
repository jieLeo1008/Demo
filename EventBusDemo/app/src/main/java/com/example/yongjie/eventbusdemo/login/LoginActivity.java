package com.example.yongjie.eventbusdemo.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.yongjie.eventbusdemo.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private LoginPresenter mLoginPresenter;
    private EditText mEditText1, mEditText2;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEditText1 = (EditText) findViewById(R.id.edt_01);
        mEditText2 = (EditText) findViewById(R.id.edt_02);
        mProgressBar = (ProgressBar) findViewById(R.id.pb_01);
        mLoginPresenter = new LoginPresenter(this);
        mProgressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed() {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPb() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hintPb() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onClick(View v) {
        mLoginPresenter.makeLogin(mEditText1.getText().toString(), mEditText2.getText().toString());
    }
}
