package com.example.jieleo.huanxindemo;

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

    private EditText userNameEdt,passwordEdt,nameEdt;
    private Button loginBtn,addContactBtn,logoutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameEdt = (EditText) findViewById(R.id.user_name_edt);
        passwordEdt = (EditText) findViewById(R.id.password_edt);
        nameEdt = (EditText) findViewById(R.id.addName);
        addContactBtn = (Button) findViewById(R.id.addContactBtn);
        logoutBtn = (Button) findViewById(R.id.logout);

        loginBtn = (Button) findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(this);
        addContactBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
        if (!userNameEdt.getText().toString().isEmpty()&&!passwordEdt.getText().toString().isEmpty()){
            String userName=userNameEdt.getText().toString();
            String password=passwordEdt.getText().toString();

            EMClient.getInstance().login(userName, password, new EMCallBack() {
                @Override
                public void onSuccess() {
                    EMClient.getInstance().groupManager().loadAllGroups();
                    EMClient.getInstance().chatManager().loadAllConversations();
                    Log.d("main", "登录聊天服务器成功！");
                    startActivity(new Intent(LoginActivity.this,ContactsList.class));
                }

                @Override
                public void onError(int code, String error) {

                }

                @Override
                public void onProgress(int progress, String status) {
                    Log.d("main", "登录聊天服务器失败！");
                }
            });
        }
             break;
            case R.id.addContactBtn:
                try {
                    EMClient.getInstance().contactManager().addContact(nameEdt.getText().toString(),"  ");
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.logout:
                EMClient.getInstance().logout(true, new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(LoginActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(int code, String error) {

                    }

                    @Override
                    public void onProgress(int progress, String status) {

                    }
                });
                break;
        }
    }
}
