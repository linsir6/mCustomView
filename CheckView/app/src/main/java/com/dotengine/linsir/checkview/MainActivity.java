package com.dotengine.linsir.checkview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CheckView checkView;
    private Button checked;
    private Button unChecked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checked = (Button) findViewById(R.id.checked);
        unChecked = (Button) findViewById(R.id.un_checked);
        checkView = (CheckView) findViewById(R.id.check_view);
        checkView.setBackgroundColor(Color.BLUE);
        checkView.check();
        checked.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                checkView.check();
            }
        });

        unChecked.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                checkView.unCheck();
            }
        });

    }
}
