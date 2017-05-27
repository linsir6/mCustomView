package com.dotengine.linsir.cameraview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {


    private CameraView mCameraView;
    private static final int CAMERA_VIEW_WIDTH = 240;
    private static final int CAMERA_VIEW_HEIGHT = 320;

    private byte[] temp;

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCameraView = (CameraView) findViewById(R.id.camera_view);
        mCameraView.setPreviewResolution(CAMERA_VIEW_WIDTH,CAMERA_VIEW_HEIGHT);
        imageView = (ImageView) findViewById(R.id.snap_img);

        mCameraView.setPreviewCallback(new CameraView.PreviewCallback() {
            @Override public void onGetYuvFrame(byte[] data) {
                temp = data;
                Log.e("lin","===lin===>  onGetYuvFrame");
            }
        });

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                mCameraView.startCamera();
            }
        });

        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                mCameraView.stopCamera();
            }
        });

        findViewById(R.id.snap).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                final YuvImage image = new YuvImage(temp, ImageFormat.NV21, 240, 320, null);
                ByteArrayOutputStream os = new ByteArrayOutputStream(temp.length);
                if(!image.compressToJpeg(new Rect(0, 0, 240, 320), 100, os)){
                    return;
                }
                byte[] tmp = os.toByteArray();
                Bitmap bmp = BitmapFactory.decodeByteArray(tmp, 0,tmp.length);

                Matrix matrix = new Matrix();
                matrix.setRotate(270f);

                Bitmap newBM = Bitmap.createBitmap(bmp, 0, 0, 240, 320, matrix, false);

                imageView.setImageBitmap(newBM);


            }
        });

    }






}
