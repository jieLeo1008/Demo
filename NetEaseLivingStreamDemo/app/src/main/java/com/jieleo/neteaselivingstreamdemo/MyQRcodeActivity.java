package com.jieleo.neteaselivingstreamdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;

import com.google.zxing.Result;

import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.core.ViewFinderView;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MyQRcodeActivity extends Activity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mZXingScannerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup content= (ViewGroup) getLayoutInflater().inflate(R.layout.activity_my_qrcode,null);
        setContentView(content);

        mZXingScannerView=new ZXingScannerView(this){

            @Override
            protected IViewFinder createViewFinderView(Context context) {
                return new CustomViewFinderView(context);
            }

        };

        content.addView(mZXingScannerView);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mZXingScannerView.setResultHandler(this);
        mZXingScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mZXingScannerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {
        String url=result.toString();
        Log.d("MyQRcodeActivity", url);

        Intent intent = new Intent();
        //把返回数据存入Intent
        if (TextUtils.isEmpty(url)) {
            intent.putExtra("result", "");
        } else {
            intent.putExtra("result", url);
        }

        //设置返回数据
        setResult(RESULT_OK, intent);
        //关闭Activity
        finish();

        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mZXingScannerView.resumeCameraPreview(MyQRcodeActivity.this);
            }
        }, 2000);
    }

    private static class CustomViewFinderView extends ViewFinderView {
        public static final String TRADE_MARK_TEXT = "请将二维码置于取景框中";
        public static final int TRADE_MARK_TEXT_SIZE_SP = 20;
        public final Paint PAINT = new Paint();

        public CustomViewFinderView(Context context) {
            super(context);
            init();
        }

        public CustomViewFinderView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        private void init() {
            PAINT.setColor(Color.WHITE);
            PAINT.setAntiAlias(true);
            float textPixelSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                    TRADE_MARK_TEXT_SIZE_SP, getResources().getDisplayMetrics());
            PAINT.setTextSize(textPixelSize);
        }

        @Override
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            drawTradeMark(canvas);
        }

        private void drawTradeMark(Canvas canvas) {
            Rect framingRect = getFramingRect();
            float tradeMarkTop;
            float tradeMarkLeft;
            if (framingRect != null) {
                tradeMarkTop = framingRect.bottom + PAINT.getTextSize() + 10;
                tradeMarkLeft = framingRect.left;
            } else {
                tradeMarkTop = 10;
                tradeMarkLeft = canvas.getHeight() - PAINT.getTextSize() - 10;
            }
            canvas.drawText(TRADE_MARK_TEXT, tradeMarkLeft, tradeMarkTop, PAINT);
//            canvas.drawText(TRADE_MARK_TEXT,10,10,10,10,PAINT);
        }
    }
}
