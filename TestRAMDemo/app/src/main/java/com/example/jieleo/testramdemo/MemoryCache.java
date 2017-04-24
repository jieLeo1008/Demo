package com.example.jieleo.testramdemo;

import android.graphics.Bitmap;
import android.util.Log;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by OldFour on 2017/4/15.
 */

public class MemoryCache {
    private static final String TAG = "MemoryCache";

    private Map<String ,Bitmap>  cache = Collections.synchronizedMap(new LinkedHashMap<String, Bitmap>(8,0.75f,true));

    private long size=0;
    private long limit=1000000;


    public MemoryCache(){
        setLimit(Runtime.getRuntime().maxMemory()/4);
    }

    private void setLimit(long l) {
        limit=l;
        Log.d(TAG, "limit/1024/1024:" + (limit / 1024 / 1024));
    }

    public Bitmap getBitmap(String id){
        try{
        if (!cache.containsKey(id)){
            return null;
        }else {
            return cache.get(id);
        }
        }catch (NullPointerException np){
            return null;
        }
    }


    public void put(String id,Bitmap bitmap){
        try{
            if (cache.containsKey(id)){
                size-=getSizeInByte(cache.get(id));
                cache.put(id,bitmap);
                size+=getSizeInByte(bitmap);
                checkSize();
            }
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }

    private void checkSize() {
        Log.d(TAG, "cache size=" + size + "length" + cache.size());
        if (size>limit){
            Iterator<Map.Entry<String, Bitmap>> iterator=cache.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String ,Bitmap> entry=iterator.next();
                size -=getSizeInByte(entry.getValue());
                iterator.remove();
                if (size<=limit){
                    break;
                }
            }
            Log.d(TAG, "cache.size():" + cache.size());
        }


    }

    private long getSizeInByte(Bitmap bitmap) {
        if (bitmap==null){
        return 0;
        }else {
            return bitmap.getRowBytes()*bitmap.getHeight();
        }
    }
}
