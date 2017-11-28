package com.qf58.learncustomview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_view);
        final Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        final Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        final Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        final Animation set = AnimationUtils.loadAnimation(this,R.anim.set_anim);

        findViewById(R.id.alpha).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(alphaAnimation);
            }
        });

        findViewById(R.id.scale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(scaleAnimation);
            }
        });

        findViewById(R.id.translate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(translate);
            }
        });

        findViewById(R.id.rotate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(rotate);
            }
        });

        findViewById(R.id.set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.startAnimation(set);
            }
        });

    }
}
