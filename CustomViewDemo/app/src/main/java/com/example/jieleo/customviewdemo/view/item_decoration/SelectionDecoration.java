package com.example.jieleo.customviewdemo.view.item_decoration;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.bean.item_decoration.NameBean;

import java.util.List;

/**
 * Created by OldFour on 2017/5/22.
 */

public class SelectionDecoration extends RecyclerView.ItemDecoration{
    private static final String TAG = "SelectionDecoration";

    private List<NameBean>  mNameBeen;

    private DecorationCallback mDecorationCallback;

    private TextPaint mTextPaint;

    private Paint mPaint;

    private int topGap;

    private int  alignBottom;

    private Paint.FontMetrics  mFontMetrics;

    public SelectionDecoration(List<NameBean> nameBeen, Context context,DecorationCallback decorationCallback) {
        Resources res =context.getResources();
        this.mNameBeen=nameBeen;
        this.mDecorationCallback=decorationCallback;
        //设置悬浮栏的画笔
        mPaint=new Paint();
        mPaint.setColor(res.getColor(R.color.colorWhite));

        //设置悬浮栏中文本的画笔
        mTextPaint=new TextPaint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(30.2f);
        mTextPaint.setColor(Color.DKGRAY);
        mTextPaint.setTextAlign(Paint.Align.LEFT);
        mFontMetrics=new Paint.FontMetrics();

        //决定悬浮栏的高度
        topGap=res.getDimensionPixelSize(R.dimen.btn_width);
        //决定文本的显示位置
        alignBottom=res.getDimensionPixelSize(R.dimen.sectioned_alignBottom);

    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos=parent.getChildAdapterPosition(view);
        String groupId=mDecorationCallback.getGroupId(pos);
        if (groupId.equals("-1")){
            return;
        }
        if (pos==0|| isFirstInGroup(pos)){
            outRect.top=topGap;
            if (mNameBeen.get(pos).getName()==""){
                outRect.top=0;
            }
        }else {
            outRect.top=0;
        }
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();
        int childCount=parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view=parent.getChildAt(i);
            int position=parent.getChildAdapterPosition(view);
            String groupId=mDecorationCallback.getGroupId(position);
            if (groupId.equals("-1")){
                return;
            }
            String textLine = mDecorationCallback.getGroupFirstLine(position).toUpperCase();
            if (textLine=="") {
                float top = view.getTop();
                float bottom = view.getTop();
                c.drawRect(left, top, right, bottom, mPaint);
                return;
            }else {
                if (position == 0 || isFirstInGroup(position)) {
                    float top = view.getTop() - topGap;
                    float bottom = view.getTop();
                    //绘制悬浮栏
                    c.drawRect(left, top - topGap, right, bottom, mPaint);
                    //绘制文本
                    c.drawText(textLine, left, bottom, mTextPaint);
                }
            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int itemCount = state.getItemCount();
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        float lineHeight = mTextPaint.getTextSize() + mFontMetrics.descent;
        String preGroupId = "";
        String groupId = "-1";
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);

            preGroupId = groupId;
            groupId = mDecorationCallback.getGroupId(position);
            if (groupId.equals("-1") || groupId.equals(preGroupId)) continue;

            String textLine = mDecorationCallback.getGroupFirstLine(position).toUpperCase();
            if (TextUtils.isEmpty(textLine)) continue;

            int viewBottom = view.getBottom();
            float textY = Math.max(topGap, view.getTop());
            //下一个和当前不一样移动当前
            if (position + 1 < itemCount) {
                String nextGroupId = mDecorationCallback.getGroupId(position + 1);
                //组内最后一个view进入了header
                if (nextGroupId != groupId && viewBottom < textY) {
                    textY = viewBottom;
                }
            }
            //textY - topGap决定了悬浮栏绘制的高度和位置
            c.drawRect(left, textY - topGap, right, textY, mPaint);
            //left+2*alignBottom 决定了文本往左偏移的多少（加-->向左移）
            //textY-alignBottom  决定了文本往右偏移的多少  (减-->向上移)
            c.drawText(textLine, left + 2 * alignBottom, textY - alignBottom, mTextPaint);
        }
    }


    private boolean isFirstInGroup(int pos) {
        if (pos==0){
            return true;
        }else {
            String prevGroup =mDecorationCallback.getGroupId(pos-1);
            String groupId=mDecorationCallback.getGroupId(pos);

            if (prevGroup.equals(groupId)){
                return false;
            }else {
                return true;
            }
        }

    }

    //定义一个借口方便外界的调用
    public interface DecorationCallback {
        String getGroupId(int position);

        String getGroupFirstLine(int position);
    }
}
