package com.example.jieleo.gallerydemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;

/**
 * Created by OldFour on 2017/4/6.
 */

public class ImageUtils {

    public static Bitmap getReverseBitmapById(int resId, Context context){
        Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(),resId);
        Matrix matrix=new Matrix();
        matrix.setScale(-1,1);
        Bitmap inverseBitmap=Bitmap.createBitmap(bitmap,0,bitmap.getHeight()/2,bitmap.getWidth(),bitmap.getHeight()/3,matrix,false);
        Bitmap groupBitMap=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight()+bitmap.getHeight()/3+60,bitmap.getConfig());
        Canvas gCanvas=new Canvas(groupBitMap);
        gCanvas.drawBitmap(bitmap,0,0,null);
        gCanvas.drawBitmap(inverseBitmap,0,bitmap.getHeight()+50,null);

        Paint paint=new Paint();
        Shader.TileMode tileMode= Shader.TileMode.CLAMP;
        LinearGradient  shader=new LinearGradient(0,bitmap.getHeight()+50,0,groupBitMap.getHeight()
            , Color.BLACK,Color.TRANSPARENT,tileMode);
        paint.setShader(shader);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        gCanvas.drawRect(0,bitmap.getHeight()+50,bitmap.getWidth(),groupBitMap.getHeight(),paint);
        return groupBitMap;
    }
}
