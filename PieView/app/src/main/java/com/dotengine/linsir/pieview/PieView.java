package com.dotengine.linsir.pieview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 *  Created by linSir 
 *  date at 2017/5/22.
 *  describe:      
 */

public class PieView extends View {

    private int[] mColors = {Color.RED, Color.BLACK, Color.BLUE, Color.GREEN, Color.YELLOW};

    private float mStartAngle = 0;  //初始化绘制的角度

    private ArrayList<PieData> mData;   //数据

    private int mWidth, mHeight;    //宽，高

    private Paint mPaint = new Paint();


    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔的模式为填充
        mPaint.setAntiAlias(true);  //设置抗锯齿
    }


    @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData)
            return;
        float currentStartAngle = mStartAngle;
        canvas.translate(mWidth / 2, mHeight / 2);
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);
        RectF rect = new RectF(-r, -r, r, r);

        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rect, currentStartAngle, pie.getAngle(), true, mPaint);
            currentStartAngle += pie.getAngle();
        }

    }

    /**
     * 设置起始角度
     */
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();   //刷新
    }


    public void setData(ArrayList<PieData> mData) {
        this.mData = mData;
        initData(mData);
        invalidate();
    }

    private void initData(ArrayList<PieData> mData) {
        if (null == mData || mData.size() == 0)
            return;

        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);
            sumValue += pie.getValue();
            int j = i % mColors.length;
            pie.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pie = mData.get(i);

            float percentage = pie.getValue()/sumValue;  //占的百分比
            float angle = percentage*360;

            pie.setPercentage(percentage);
            pie.setAngle(angle);
            sumAngle += angle;

        }

    }

}

































