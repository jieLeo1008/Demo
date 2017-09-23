package com.example.jieleo.customviewdemo.utils.manager;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongJie on 2017/9/5.
 */

public class MyActivityManager {

    private static List<Activity> activities = new ArrayList<>();


    public static void addActivity(Activity activity) {
        activities.add(activity);
    }


    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }


    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
