package com.lc.duoweidu.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Log;


import com.lc.duoweidu.project.face.FaceDB;
import com.zcx.helper.app.AppApplication;
import com.zcx.helper.app.AppInit;
import com.zcx.helper.glide.GlideLoader;
import com.zcx.helper.http.Http;

/**
 * Created by Administrator on 2017/2/3.
 */
@AppInit(name = "duoweidu", log = true, scale = 1.1f)
public class BaseApplication extends AppApplication {

    public static Context context;

    public static BasePerference basePerference;

    public static Context getContext() {
        return context;
    }

    public  FaceDB mFaceDB;

    Uri mImage;

    @Override
    public void onCreate() {

        super.onCreate();

        context = getApplicationContext();

        basePerference=new BasePerference(this,"Test");

        mFaceDB=new FaceDB(this.getExternalCacheDir().getPath());

        mImage=null;


    }


    public void setCaptureImage(Uri uri) {
        mImage = uri;
    }

    public Uri getCaptureImage() {
        return mImage;
    }

    /**
     * @param path
     * @return
     */
    public static Bitmap decodeImage(String path) {
        Bitmap res;
        try {
            ExifInterface exif = new ExifInterface(path);
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            BitmapFactory.Options op = new BitmapFactory.Options();
            op.inSampleSize = 1;
            op.inJustDecodeBounds = false;
            //op.inMutable = true;
            res = BitmapFactory.decodeFile(path, op);
            //rotate and scale.
            Matrix matrix = new Matrix();

            if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
                matrix.postRotate(90);
            } else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {
                matrix.postRotate(180);
            } else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {
                matrix.postRotate(270);
            }

            Bitmap temp = Bitmap.createBitmap(res, 0, 0, res.getWidth(), res.getHeight(), matrix, true);
            Log.d("com.arcsoft", "check target Image:" + temp.getWidth() + "X" + temp.getHeight());

            if (!temp.equals(res)) {
                res.recycle();
            }
            return temp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
