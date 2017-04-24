package com.example.jieleo.huanxindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userNameEdt, passwordEdt;
    private Button createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        userNameEdt = (EditText) findViewById(R.id.user_name_create_edt);
        passwordEdt = (EditText) findViewById(R.id.password_create_edt);
        createAccountBtn = (Button) findViewById(R.id.createAccount_btn);


        createAccountBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (!userNameEdt.getText().toString().isEmpty() && !passwordEdt.getText().toString().isEmpty()) {
            final String userName = userNameEdt.getText().toString();
            final String password = passwordEdt.getText().toString();
            Log.d("CreateAccountActivity", "userName:" + userName + "password:" + password);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        EMClient.getInstance().createAccount(userName,password);
                        Log.d("CreateAccountActivity", "注册");
                    } catch (HyphenateException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
