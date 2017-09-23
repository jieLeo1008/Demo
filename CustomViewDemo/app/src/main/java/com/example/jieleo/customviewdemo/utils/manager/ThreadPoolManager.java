package com.example.jieleo.customviewdemo.utils.manager;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by YongJie on 2017/9/4.
 */

public class ThreadPoolManager {

    private static ThreadPoolManager instance;

    public static ThreadPoolManager getInstance() {
        if (instance == null) {
            synchronized (ThreadPoolManager.class) {
                if (instance == null) {
                    instance = new ThreadPoolManager();
                }
            }
        }
        return instance;
    }


    //核心线程的数量
    private int corePoolSize;
    //最大线程池数量，表示当缓冲队列满的时候能继续容纳的等待任务的数量
    private int maximumPoolSize;
    //存活时间
    private long keepAliveTime = 1;
    //时间单位
    private TimeUnit unit = TimeUnit.MINUTES;

    private ThreadPoolExecutor executor;

    private ThreadPoolManager() {

        //给corePoolSize赋值：当前设备可用处理器核心数*2 + 1,能够让cpu的效率得到最大程度执行（有研究论证的）
        corePoolSize = Runtime.getRuntime().availableProcessors() * 2 + 1;

        maximumPoolSize = corePoolSize;

        executor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

    }


    /**
     * 执行任务
     *
     * @param runnable
     */
    public void execute(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        executor.execute(runnable);

    }

    /**
     * 移除任务
     * @param runnable
     */
    public void remove(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        executor.remove(runnable);
    }



}
