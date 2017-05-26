package com.example.jieleo.huanxin;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import com.hyphenate.EMContactListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


@SuppressLint("NewApi")
public class MainActivity extends AppCompatActivity {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private MyFragementPageAdapter mAdapter;
    private ChatListFragment mChatListFragment;
    private ContactListFragment mContactListFragment;
    private SetFragment mSetFragment;
    private List<String> contactList = new ArrayList<>();
    List<String> words = new ArrayList<>();

    MainBroadCastReceiver mMainBroadCastReceiver;

    private EventBus mEventBus;

    private String chatingName;
    private boolean sendNotificaton;

    private RemoteViews mRemoteViews;
    private Notification.Builder mBuilder;
    private NotificationManager mNotificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //判断是否需要登录
        if (!(boolean) SPUtils.get(this, "IS_LOGIN", false)) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {

            Log.d("MainActivity", "SPUtils.get(this,):" + SPUtils.get(this, "USER_NAME", "aaa"));
            setContentView(R.layout.activity_main);
            mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
            mViewPager = (ViewPager) findViewById(R.id.viewPager);

            mFragments = new ArrayList<>();

            mChatListFragment = new ChatListFragment();
            mContactListFragment = new ContactListFragment();
            mSetFragment = new SetFragment();

            mFragments.add(mChatListFragment);
            mFragments.add(mContactListFragment);
            mFragments.add(mSetFragment);

            mAdapter = new MyFragementPageAdapter(getSupportFragmentManager());

            mViewPager.setAdapter(mAdapter);


            mAdapter.setFragments(mFragments);
            mTabLayout.setupWithViewPager(mViewPager);

            String[] word = new String[]{"添加好友", "退出登录"};

            for (int i = 0; i < word.length; i++) {
                words.add(word[i]);
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("word", (ArrayList<String>) words);
            mSetFragment.setArguments(bundle);

            setContactList();

            addContactListener();

            mRemoteViews = new RemoteViews(getPackageName(), R.layout.item_notification);
            mBuilder = new Notification.Builder(this);
            mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            EMClient.getInstance().chatManager().addMessageListener(mEMMessageListener);
        }

        mMainBroadCastReceiver = new MainBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("NotifyContact");
        intentFilter.addAction("ChatNow");
        intentFilter.addAction("ChatOver");
        registerReceiver(mMainBroadCastReceiver, intentFilter);

    }

    private void addContactListener() {
        EMClient.getInstance().contactManager().setContactListener(new EMContactListener() {
            @Override
            public void onContactAdded(String s) {
                Log.d("MainActivity", "好友请求被同意");
            }

            @Override
            public void onContactDeleted(String s) {
                Log.d("MainActivity", "好友请求被拒绝");
            }

            @Override
            public void onContactInvited(final String s, final String s1) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Log.d("MainActivity", "收到好友邀请");
                                Intent intent = new Intent("ContactInvited");
                                intent.putExtra("name", s);
                                intent.putExtra("reason", s1);
                                sendBroadcast(intent);
                            }
                        });
                    }
                }).run();

            }

            @Override
            public void onFriendRequestAccepted(String s) {
                Log.d("MainActivity", "被删除时回调此方法");
            }

            @Override
            public void onFriendRequestDeclined(String s) {
                Log.d("MainActivity", "增加联系人时回调此方法");
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMainBroadCastReceiver);
        EMClient.getInstance().chatManager().removeMessageListener(mEMMessageListener);
    }

    /**
     * 获得所有联系人列表
     */
    private void setContactList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    contactList = EMClient.getInstance().contactManager().getAllContactsFromServer();
                    Log.d("MainActivity", "getUserName");
                    Log.d("MainActivity", "contactList.size():" + contactList.size());
                    //判断联系人数量是否为空
                    if (contactList.size() > 0) {
                        Log.d("MainActivity", "contactList.size():" + contactList.size());
                        Intent intent = new Intent("Contact");
                        intent.putStringArrayListExtra("ContactList", (ArrayList<String>) contactList);
                        sendBroadcast(intent);
                    }
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    EMMessageListener mEMMessageListener = new EMMessageListener() {
        @Override
        public void onMessageReceived(final List<EMMessage> list) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.d("MainActivity", "收到消息");
                    sendCustomNotification(list);

                }
            });
        }

        @Override
        public void onCmdMessageReceived(List<EMMessage> list) {

        }

        @Override
        public void onMessageRead(List<EMMessage> list) {

        }

        @Override
        public void onMessageDelivered(List<EMMessage> list) {

        }

        @Override
        public void onMessageChanged(EMMessage emMessage, Object o) {

        }
    };

    private void sendCustomNotification(List<EMMessage> list) {
        for (EMMessage message : list) {


            String name = null, content = null;
            if (message.getFrom().equals(chatingName)) {

            } else {
                name = message.getFrom();
                content = ((EMTextMessageBody) message.getBody()).getMessage();
//                mRemoteViews.setTextViewText(R.id.chat_name_notify, name);
//                mRemoteViews.setTextViewText(R.id.chat_content_notify, content);
                Intent notifyIntent = new Intent(this, ChatActivity.class);
                notifyIntent.putExtra("contactName", name);
//                mBuilder.setSmallIcon(R.mipmap.ic_launcher_round).setContent(mRemoteViews).setAutoCancel(true);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//                mRemoteViews.setOnClickPendingIntent(R.id.chat_content_notify, pendingIntent);
//                mRemoteViews.setOnClickPendingIntent(R.id.chat_name_notify, pendingIntent);
//                mNotificationManager.notify(1, mBuilder.build());


                mBuilder.setContentTitle(name);
                mBuilder.setContentText(content);
                mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
                mBuilder.setContentIntent(pendingIntent);
                Notification notification=mBuilder.getNotification();
                notification.defaults=Notification.DEFAULT_ALL;
                notification.flags=Notification.FLAG_AUTO_CANCEL;
                mNotificationManager.notify(R.mipmap.ic_launcher,notification);

                Log.d("MainActivity", "发送通知");
            }

        }


    }

    public class MainBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case "NotifyContact":
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent1 = new Intent("Contact");
                            contactList.clear();
                            try {
                                contactList = EMClient.getInstance().contactManager().getAllContactsFromServer();
                                intent1.putStringArrayListExtra("ContactList", (ArrayList<String>) contactList);
                                sendBroadcast(intent1);
                            } catch (HyphenateException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();

                    break;

                case "ChatNow":
                    chatingName = intent.getStringExtra("ChatNowName");
                    Log.d("MainBroadCastReceiver", chatingName);
                    break;

                case "ChatOver":
                    sendNotificaton = true;
                    chatingName = "";
                    break;
            }
        }
    }


}
