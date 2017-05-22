package com.dotengine.linsir.pieview;

import android.support.annotation.NonNull;

/**
 *  Created by linSir 
 *  date at 2017/5/22.
 *  describe: 每一个数据的Model
 */

public class PieData {

    private String name;    //颜色
    private float value;    //数值
    private float percentage;   //百分比

    private int color = 0;      //颜色
    private float angle = 0;    //角度

    public PieData(@NonNull String name, @NonNull float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

}
