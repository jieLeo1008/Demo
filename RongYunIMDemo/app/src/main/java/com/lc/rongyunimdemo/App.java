package com.lc.rongyunimdemo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

import cn.rongcloud.contactcard.ContactCardExtensionModule;
import cn.rongcloud.contactcard.IContactCardClickListener;
import cn.rongcloud.contactcard.IContactCardInfoProvider;
import cn.rongcloud.contactcard.message.ContactMessage;
import io.rong.imageloader.core.DisplayImageOptions;
import io.rong.imageloader.core.display.FadeInBitmapDisplayer;
import io.rong.imkit.RongExtensionManager;
import io.rong.imkit.RongIM;
import io.rong.imkit.tools.CharacterParser;
import io.rong.imkit.widget.provider.RealTimeLocationMessageProvider;
import io.rong.imlib.ipc.RongExceptionHandler;
import io.rong.imlib.model.UserInfo;
import io.rong.push.RongPushClient;
import io.rong.push.common.RongException;

/**
 * Created by Benny on 2018/2/1.
 */

public class App extends Application {

    public static Context context;

    private static DisplayImageOptions options;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        RongIM.init(this);


//
//        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))) {
//
//            RongPushClient.registerHWPush(this);
//            RongPushClient.registerMiPush(this, "2882303761517473625", "5451747338625");
//            try {
//                RongPushClient.registerFCM(this);
//            } catch (RongException e) {
//                e.printStackTrace();
//            }
//
//            /**
//             * 注意：
//             *
//             * IMKit SDK调用第一步 初始化
//             *
//             * context上下文
//             *
//             * 只有两个进程需要初始化，主进程和 push 进程
//             */
//            RongIM.setServerInfo("nav.cn.ronghub.com", "up.qbox.me");
//            RongIM.init(this);
//            NLog.setDebug(true);//Seal Module Log 开关
//            SealAppContext.init(this);
//            SharedPreferencesContext.init(this);
//            Thread.setDefaultUncaughtExceptionHandler(new RongExceptionHandler(this));
//
//            try {
//                RongIM.registerMessageTemplate(new ContactNotificationMessageProvider());
//                RongIM.registerMessageTemplate(new RealTimeLocationMessageProvider());
//                RongIM.registerMessageType(TestMessage.class);
//                RongIM.registerMessageTemplate(new TestMessageProvider());
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            openSealDBIfHasCachedToken();
//
//            options = new DisplayImageOptions.Builder()
//                    .showImageForEmptyUri(cn.rongcloud.im.R.drawable.de_default_portrait)
//                    .showImageOnFail(cn.rongcloud.im.R.drawable.de_default_portrait)
//                    .showImageOnLoading(cn.rongcloud.im.R.drawable.de_default_portrait)
//                    .displayer(new FadeInBitmapDisplayer(300))
//                    .cacheInMemory(true)
//                    .cacheOnDisk(true)
//                    .build();
//
//         RongExtensionManager.getInstance().registerExtensionModule(new ContactCardExtensionModule(new IContactCardInfoProvider() {
//                @Override
//                public void getContactAllInfoProvider(final IContactCardInfoCallback contactInfoCallback) {
//                    SealUserInfoManager.getInstance().getFriends(new SealUserInfoManager.ResultCallback<List<Friend>>() {
//                        @Override
//                        public void onSuccess(List<Friend> friendList) {
//                            contactInfoCallback.getContactCardInfoCallback(friendList);
//                        }
//
//                        @Override
//                        public void onError(String errString) {
//                            contactInfoCallback.getContactCardInfoCallback(null);
//                        }
//                    });
//                }
//
//                @Override
//                public void getContactAppointedInfoProvider(String userId, String name, String portrait, final IContactCardInfoCallback contactInfoCallback) {
//                    SealUserInfoManager.getInstance().getFriendByID(userId, new SealUserInfoManager.ResultCallback<Friend>() {
//                        @Override
//                        public void onSuccess(Friend friend) {
//                            List<UserInfo> list = new ArrayList<>();
//                            list.add(friend);
//                            contactInfoCallback.getContactCardInfoCallback(list);
//                        }
//
//                        @Override
//                        public void onError(String errString) {
//                            contactInfoCallback.getContactCardInfoCallback(null);
//                        }
//                    });
//                }
//
//            }, new IContactCardClickListener() {
//                @Override
//                public void onContactCardClick(View view, ContactMessage content) {
//                    Intent intent = new Intent(view.getContext(), UserDetailActivity.class);
//                    Friend friend = SealUserInfoManager.getInstance().getFriendByID(content.getId());
//                    if (friend == null) {
//                        UserInfo userInfo = new UserInfo(content.getId(), content.getName(),
//                                Uri.parse(TextUtils.isEmpty(content.getImgUrl()) ? RongGenerate.generateDefaultAvatar(content.getName(), content.getId()) : content.getImgUrl()));
//                        friend = CharacterParser.getInstance().generateFriendFromUserInfo(userInfo);
//                    }
//                    intent.putExtra("friend", friend);
//                    view.getContext().startActivity(intent);
//                }
//            }));
//            RongExtensionManager.getInstance().registerExtensionModule(new RecognizeExtensionModule());
//        }
    }


    public static Context getAppContext() {
        return context;
    }

    


    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
