package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Benny on 2017/11/15.
 */

public class Main01 {


    private static long b;
    private static long a;

    public static void main(String[] args){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(time);



        String lastTime="2017-11-15 22:39:28";
        try {

            System.out.println(simpleDateFormat.parse("2017-11-15 23:33:45").getTime());

            Date date =simpleDateFormat.parse(lastTime);
            long currintTime=date.getTime();
            System.out.println(currintTime);
            System.out.println(simpleDateFormat.format(currintTime));
            a = simpleDateFormat.parse("2017-11-15 23:33:45").getTime();
            b = currintTime;


        } catch (ParseException e) {
            e.printStackTrace();
        }

        long result=a-b;

        int second= (int) (result/1000);

        System.out.println("second"+second);

        int seconds=second%60;

        System.out.println("seconds"+seconds);

        int minutes=second/60;

        int minute=second%60;

//        System.out.println("minutes"+minutes);
        System.out.println("minute"+minute);

        int hour=minutes/60;

        System.out.println("hour"+hour);

        System.out.println("H:"+hour+"min:"+minutes+"Sec:"+seconds);


    }
}
