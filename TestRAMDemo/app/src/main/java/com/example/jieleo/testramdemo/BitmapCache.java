package com.example.jieleo.testramdemo;

import android.graphics.Bitmap;
import android.util.ArrayMap;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Created by OldFour on 2017/4/15.
 */

public class BitmapCache {

    private static BitmapCache cache;

    private ArrayMap<String,MySoftRef> hashRefs;
//垃圾Reference的队列（所引用的对象已经被回收，则将该引用存入队列中）
    private ReferenceQueue<Bitmap>   q;


    private BitmapCache() {
        hashRefs=new ArrayMap<String,MySoftRef>();
        q=new ReferenceQueue<Bitmap>();
    }

    public static BitmapCache  getInstance(){
        if (cache==null){
            synchronized (BitmapCache.class){
                if (cache==null){
                    cache=new BitmapCache();
                }
            }
        }
        return cache;
    }

    /**
     * 集成SoftReference 使得每一个实例都具有可识别的标识
     */
    private class MySoftRef extends SoftReference<Bitmap> {
        private String _key="";
        public MySoftRef(Bitmap referent, ReferenceQueue<? super Bitmap> q ,String key) {
            super(referent, q);
            _key=key;
        }
    }

    /**
     * 以软引用的方式对一个Bitmap对象的实例进行引用并保存该引用
     * @param bmp   引用的bitmap
     * @param key   文件名
     */
    public void addCacheBitmap(Bitmap bmp,String key){
        cleanCache();//清除垃圾引用
        MySoftRef ref =new MySoftRef(bmp,q,key);
        hashRefs.put(key,ref);
    }

    /**
     * 依据所指定的drawable下的图片资源ID号（可以根据自己的需要从网络或本地path下获取），重新获取相应的Bitmap对象实例
     * @param resId  资源的Id
     * @return
     */
    public Bitmap getBitmap(String resId){
        Bitmap bitmap=null;
        try {
        if (hashRefs.containsKey(resId)){
            MySoftRef ref=(MySoftRef)hashRefs.get(resId);
            bitmap=(Bitmap)ref.get();
        }
        return bitmap;

        }catch (NullPointerException ex){
            return null;
        }
    }

    private void cleanCache() {
        MySoftRef ref=null;
        while ((ref= (MySoftRef) q.poll())!=null){
                hashRefs.remove(ref._key);
        }

    }

    /**
     * 清除Cache内的全部内容
     */
    public void clearCache(){
        cleanCache();
        hashRefs.clear();
        System.gc();
        System.runFinalization();
    }



}
