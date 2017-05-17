package com.example.jieleo.huanxin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText registerUserName, registerPassword, userName, password;
    private Button registerBtn, loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registerUserName = (EditText) findViewById(R.id.register_user_name);
        registerPassword = (EditText) findViewById(R.id.register_password);
        userName = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);
        registerBtn = (Button) findViewById(R.id.register_btn);
        loginBtn = (Button) findViewById(R.id.login);

        registerBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_btn://注册
                String registerUserName = this.registerUserName.getText().toString();
                String registerPassword = this.registerPassword.getText().toString();
                registerUser(registerUserName, registerPassword);
                break;
            case R.id.login://登录
                String userName = this.userName.getText().toString();
                String password = this.password.getText().toString();
                login(userName, password);
                break;
        }
    }

    private void login(final String userName, String password) {
        EMClient.getInstance().login(userName, password, new EMCallBack() {
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                //登录聊天服务器成功

                SPUtils.put(LoginActivity.this, "IS_LOGIN", true);
                SPUtils.put(LoginActivity.this, "USER_NAME", userName);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                Log.d("LoginActivity", "SPUtils.get(LoginActivity.this,,false):" + SPUtils.get(LoginActivity.this, "IS_LOGIN", false));
                finish();
            }

            @Override
            public void onError(int i, String s) {
                Log.d("LoginActivity", s);
            }

            @Override
            public void onProgress(int i, String s) {
                Log.d("LoginActivity", "onProgress");
            }
        });
    }

    /**
     * 注册用户
     *
     * @param userName 用户名
     * @param password 密码
     */
    private void registerUser(String userName, String password) {
        try {
            EMClient.getInstance().createAccount(userName, password);
        } catch (HyphenateException e) {
            e.printStackTrace();
            Log.d("LoginActivity", "e.getErrorCode():" + e.getErrorCode());
        }

    }
}
