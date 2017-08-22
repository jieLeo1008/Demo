package com.example.jieleo.customviewdemo.utils.window;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.adapter.MyListAdapter;
import com.example.jieleo.customviewdemo.adapter.MyRvAdapter;
import com.example.jieleo.customviewdemo.bean.item_decoration.NotifBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongJie on 2017/8/9.
 */

public class WindowUtils {

    private static final String LOG_TAG = "WindowUtils";
    private static View mView = null;
    private static WindowManager mWindowManager = null;
    private static Context mContext = null;

    public static Boolean isShown = false;
    private static MyRvAdapter myRvAdapter;
    private static RecyclerView recyclerView;

    public static List<NotifBean> mNotifBeen = new ArrayList<>();

    private static List<String> title = new ArrayList<>();

    private static ListView listView;
    private static MyListAdapter myListAdapter;

    /**
     * 显示弹出框
     *
     * @param context
     * @param
     */
    public static void showPopupWindow(final Context context) {
        if (isShown) {
//            LogUtil.i(LOG_TAG, "return cause already shown");
            return;
        }

        isShown = true;
//        LogUtil.i(LOG_TAG, "showPopupWindow");

        
        // 获取应用的Context
        mContext = context.getApplicationContext();
        // 获取WindowManager
        mWindowManager = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);

        mView = setUpView(context);

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();

        // 类型
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;

        // WindowManager.LayoutParams.TYPE_SYSTEM_ALERT

        // 设置flag

        int flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        // | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        // 如果设置了WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE，弹出的View收不到Back键的事件
        params.flags = flags;
        // 不设置这个弹出框的透明遮罩显示为黑色
        params.format = PixelFormat.TRANSLUCENT;
        // FLAG_NOT_TOUCH_MODAL不阻塞事件传递到后面的窗口
        // 设置 FLAG_NOT_FOCUSABLE 悬浮窗口较小时，后面的应用图标由不可长按变为可长按
        // 不设置这个flag的话，home页的划屏会有问题

        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;

        params.gravity = Gravity.CENTER;

        mWindowManager.addView(mView, params);

//        LogUtil.i(LOG_TAG, "add view");

//        recyclerView.setItemAnimator(new SlideItemAnimator());


    }

    /**
     * 隐藏弹出框
     */
    public static void hidePopupWindow() {
//        LogUtil.i(LOG_TAG, "hide " + isShown + ", " + mView);
        if (isShown && null != mView) {
//            LogUtil.i(LOG_TAG, "hidePopupWindow");
            mWindowManager.removeView(mView);
            isShown = false;
        }

    }

    private static View setUpView(final Context context) {

//        LogUtil.i(LOG_TAG, "setUp view");

        View view = LayoutInflater.from(context).inflate(R.layout.popupwindow,
                null);
        Button positiveBtn = (Button) view.findViewById(R.id.positiveBtn);
        positiveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


//                LogUtil.i(LOG_TAG, "ok on click");
                // 打开安装包
                // 隐藏弹窗
//                WindowUtils.hidePopupWindow();

//                mNotifBeen.add(new NotifBean().setText("哈哈" + Math.random()));

//                myRvAdapter.notifyItemInserted(mNotifBeen.size());
//                myRvAdapter.notifyDataSetChanged();

//                myRvAdapter.add(new NotifBean().setText("哈哈"+Math.random()),0);

                myRvAdapter.add("你好" + Math.random(), 0);


//                recyclerView.scrollToPosition(0);

//                title.add("小猪");
//                myListAdapter.notifyDataSetChanged();

            }
        });

        Button negativeBtn = (Button) view.findViewById(R.id.negativeBtn);
        negativeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                LogUtil.i(LOG_TAG, "cancel on click");
                WindowUtils.hidePopupWindow();

            }
        });

        // 点击窗口外部区域可消除
        // 这点的实现主要将悬浮窗设置为全屏大小，外层有个透明背景，中间一部分视为内容区域
        // 所以点击内容区域外部视为点击悬浮窗外部
        final View popupWindowView = view.findViewById(R.id.popup_window);// 非透明的内容区域

        view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

//                LogUtil.i(LOG_TAG, "onTouch");
                int x = (int) event.getX();
                int y = (int) event.getY();
                Rect rect = new Rect();
                popupWindowView.getGlobalVisibleRect(rect);
                if (!rect.contains(x, y)) {
//                    WindowUtils.hidePopupWindow();

                }

//                LogUtil.i(LOG_TAG, "onTouch : " + x + ", " + y + ", rect: "
//                        + rect);
                return false;
            }
        });

        // 点击back键可消除
        view.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_BACK:
                        WindowUtils.hidePopupWindow();
                        return true;
                    default:
                        return false;
                }
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_01);
        myRvAdapter = new MyRvAdapter(context, new ArrayList<String>());

        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true));
        recyclerView.setAdapter(myRvAdapter);


        myRvAdapter.setMyClickListener(new MyRvAdapter.MyClickListener() {
            @Override
            public void onMyClick(int position) {

//                mNotifBeen.remove(position);

                myRvAdapter.remove(position);
//                myRvAdapter.notifyItemRemoved(position);
//                myRvAdapter.notifyDataSetChanged();
            }
        });


//        listView= (ListView) view.findViewById(R.id.list_view);
//
//        title.add("哈哈");
//        title.add("你好");
//        title.add("再见");
//
//        myListAdapter = new MyListAdapter(title,context);
//
//        listView.setAdapter(myListAdapter);
//
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                title.remove(position);
//                myListAdapter.notifyDataSetChanged();
//            }
//        });

        return view;


    }


}