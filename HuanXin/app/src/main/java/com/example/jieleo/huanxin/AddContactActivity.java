package com.example.jieleo.huanxin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditText;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        mEditText = (EditText) findViewById(R.id.contact_name);
        mButton = (Button) findViewById(R.id.add_contact);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_contact:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (!TextUtils.isEmpty(mEditText.getText().toString())){
                            try {
                                EMClient.getInstance().contactManager().addContact(mEditText.getText().toString(),"哈哈");
                            } catch (HyphenateException e) {
                                e.printStackTrace();
                            }
                        }else {
                            Toast.makeText(MyApp.getContext(), "好友名不能为空", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).start();

                break;
        }
    }
}
