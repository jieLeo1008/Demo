package com.jieleo.mysimpledemo.java.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jieleo.mysimpledemo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Benny on 2017/11/16.
 */

public class CountDownView extends LinearLayout {

    private Context context;

    private TextView hour, minute, second;


    private String startTime;

    private String serverTime;

    private Long currentTime;

    private int hours, minutes, seconds;

    private SimpleDateFormat mSimpleDateFormat;


    private CountDown mCountDown;


    private volatile boolean isCountinue = true;

    private Thread countDownThread;

    public void setCountDown(CountDown countDown) {
        mCountDown = countDown;
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        if (!isInEditMode()) {

            mSimpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

            View view = LayoutInflater.from(context).inflate(R.layout.item_count_down, this, true);

            hour = view.findViewById(R.id.hour_tv);

            minute = view.findViewById(R.id.minutes_tv);

            second = view.findViewById(R.id.second_tv);

            initThread();

        }
    }

    /**
     * 设置Thread
     */
    private void initThread() {
        if (countDownThread == null) {
            countDownThread = new Thread(new Runnable() {
                @Override
                public void run() {

                    while (isCountinue) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        if (seconds == 0) {
                            if (minutes > 0 && hours > 0) {
                                seconds = 60;
                                minutes = 60;
                                minutes--;
                                hours--;
                            } else if (minutes > 0 && hours == 0) {
                                seconds = 60;
                                minutes--;
                            } else if (minutes == 0 && hours > 0) {
                                minutes = 60;
                                hours--;
                            } else if (minutes == 0 && hours == 0) {
                                mCountDown.complete();
                                isCountinue = false;
                                break;
                            }
                        }

                        seconds--;

                        parseString();

                        Log.d("CountDownView", "hour: " + hours + "  minutes:" + minutes + "   second" + seconds);
                    }

                }
            });
        }

    }

    /**
     * 设置开场时间
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     *设置当前时间
     * @param serverTime
     */
    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * 将字符串时间转化为long型
     * @param time
     * @return
     */
    private long parseTime(String time) {
        Date date = null;
        try {
            date = mSimpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * 将long型时间差转化为时分秒
     * @param sumTime
     */
    private void parseTime(long sumTime) {
        seconds = (int) ((sumTime / 1000) % 60);
        minutes = (int) (((sumTime / 1000) / 60) % 60);
        hours = (int) (((sumTime / 1000) / 60) / 60);
    }

    /**
     * 开始倒计时
     */
    public void startCountDown(String startTime,String serverTime) {

        parseTime(parseTime(startTime) - parseTime(serverTime));

        parseString();

        isCountinue = true;

        countDownThread.start();
    }

    /**
     * 判断Thread是否可用
     * @return
     */
    public boolean isThreadAlive() {
        return countDownThread.isAlive();
    }

    /**
     * 设置时间
     */
    private void parseString() {


        if (seconds < 10 && seconds >= 0) {
            second.setText("0" + seconds);
        } else {
            second.setText(seconds + "");
        }

        if (minutes < 10 && minutes >= 0) {
            minute.setText("0" + minutes);
        } else {
            minute.setText(minutes + "");

        }

        if (hours >= 0 && hours < 10) {
            hour.setText("0" + hours);
        } else {
            hour.setText(hours);
        }

    }

    /**
     * 设置暂停
     */
    public void setPause() {
        isCountinue = false;
    }

    public interface CountDown {
        /**
         * 倒计时完成
         */
        void complete();
    }

}
