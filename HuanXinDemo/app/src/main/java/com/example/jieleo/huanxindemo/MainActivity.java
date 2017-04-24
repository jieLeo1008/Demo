package com.example.jieleo.huanxindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button createAccountBtn,logInBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAccountBtn = (Button) findViewById(R.id.createAccount);
        logInBtn = (Button) findViewById(R.id.log_in);

        createAccountBtn.setOnClickListener(this);
        logInBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.createAccount:
                startActivity(new Intent(this,CreateAccountActivity.class));
                break;
            case R.id.log_in:
                startActivity(new Intent(this,LoginActivity.class));
                break;
        }
    }
}
