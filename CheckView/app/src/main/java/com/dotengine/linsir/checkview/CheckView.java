package com.dotengine.linsir.checkview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 *  Created by linSir 
 *  date at 2017/5/23.
 *  describe: 一个自动画✔️好的view
 */

public class CheckView extends View {


    private static final int ANIM_NULL = 0; //状态——无动画
    private static final int ANIM_CHECK = 1;    //状态——开启
    private static final int ANIM_UNCHECK = 2;  //状态——动画结束


    private int mWidth, mHeight;    //view's width , view's height
    private static Handler mHandler;

    private Paint mPaint;
    private Bitmap okBitmap;

    private int animCurrentPage = -1;
    private int animMaxPage = 13;
    private int animDuration = 500;
    private int animState = ANIM_NULL;

    private boolean isCheck = false;


    public CheckView(Context context) {
        super(context, null);
    }

    public CheckView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {

        mPaint = new Paint();
        mPaint.setColor(0xffFF5317);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        okBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.checkmark);

        mHandler = new Handler() {

            @Override public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (animCurrentPage < animMaxPage && animCurrentPage >= 0) {

                    invalidate();
                    if (animState == ANIM_NULL) {
                        return;
                    }
                    if (animState == ANIM_CHECK) {
                        animCurrentPage++;
                    } else if (animState == ANIM_UNCHECK) {
                        animCurrentPage--;
                    }

                    this.sendEmptyMessageDelayed(0, animDuration / animMaxPage);


                } else {
                    if (isCheck) {
                        animCurrentPage = animMaxPage - 1;
                    } else {
                        animCurrentPage = -1;
                    }

                    invalidate();
                    animState = ANIM_NULL;
                }
            }
        };


    }


    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;

    }


    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawCircle(0, 0, 240, mPaint);

        int sideLength = okBitmap.getHeight();
        Rect src = new Rect(sideLength * animCurrentPage, 0, sideLength * (animCurrentPage + 1), sideLength);
        Rect dst = new Rect(-200, -200, 200, 200);


        canvas.drawBitmap(okBitmap, src, dst, null);
    }


    public void check() {
        if (animState != ANIM_NULL || isCheck) {
            return;
        }
        animState = ANIM_CHECK;
        animCurrentPage = 0;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isCheck = true;
    }

    public void unCheck() {
        if (animState != ANIM_NULL || (!isCheck)) {
            return;
        }
        animState = ANIM_UNCHECK;
        animCurrentPage = animMaxPage - 1;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isCheck = false;
    }

    public void setAnimDuration(int animDuration) {
        if (animDuration <= 0) {
            return;
        }
        this.animDuration = animDuration;
    }


    public void setBackgroundColor(int color) {
        mPaint.setColor(color);
    }

}









































