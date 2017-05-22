package com.dotengine.linsir.pieview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PieView mPieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPieView = (PieView) findViewById(R.id.mPieView);

        ArrayList<PieData> list = new ArrayList<PieData>();
        PieData data = new PieData("test",1);
        PieData data2 = new PieData("test",1);
        PieData data3 = new PieData("test",1);
        PieData data4 = new PieData("test",1);

        list.add(data);
        list.add(data2);
        list.add(data3);
        list.add(data4);

        mPieView.setData(list);



    }
}
