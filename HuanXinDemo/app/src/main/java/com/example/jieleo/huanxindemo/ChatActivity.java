package com.example.jieleo.huanxindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessageBody;

import java.util.List;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private List<EMMessage> mEMMessages;
    private EMMessageListener mEmMessageListener;
    private EditText mEditText;
    private Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mEditText = (EditText) findViewById(R.id.my_edt);
        sendBtn = (Button) findViewById(R.id.send_btn);
        sendBtn.setOnClickListener(this);
        mEmMessageListener = new EMMessageListener() {
            @Override
            public void onMessageReceived(List<EMMessage> messages) {
                Log.d("ChatActivity", "收到消息");

            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> messages) {
                Log.d("ChatActivity", "收到透传消息");
            }

            @Override
            public void onMessageRead(List<EMMessage> messages) {
                Log.d("ChatActivity", "收到已读回执");
            }

            @Override
            public void onMessageDelivered(List<EMMessage> messages) {
                Log.d("ChatActivity", "收到已送达回执");
            }

            @Override
            public void onMessageChanged(EMMessage message, Object change) {
                Log.d("ChatActivity", "消息状态变动");
            }
        };

        EMClient.getInstance().chatManager().addMessageListener(mEmMessageListener);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EMClient.getInstance().chatManager().removeMessageListener(mEmMessageListener);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_btn:
                String content=mEditText.getText().toString();
                EMMessage message=EMMessage.createTxtSendMessage(content,"qwe");
                EMClient.getInstance().chatManager().sendMessage(message);
                break;
        }
    }
}
