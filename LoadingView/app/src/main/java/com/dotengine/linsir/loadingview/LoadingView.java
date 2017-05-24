package com.dotengine.linsir.loadingview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 *  Created by linSir 
 *  date at 2017/5/23.
 *  describe: 自定义的进度条的view
 */

public class LoadingView extends View {


    private Bitmap mLeafBitmap;

    private int mLeafWidth;
    private int mLeafHeight;

    private Resources mResources;


    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initBitmap();

    }



    public void initBitmap(){
        mResources = getResources();
        mLeafBitmap = ((BitmapDrawable)mResources.getDrawable(R.drawable.leaf)).getBitmap();

        mLeafWidth = mLeafBitmap.getWidth();
        mLeafHeight = mLeafBitmap.getHeight();

    }







}
