package com.example.ranvir.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by RANVIR on 30-12-2015.
 */
public class CamResult extends Activity{
    ImageView iv;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cameraresult);
        iv=(ImageView)findViewById(R.id.ivResult);
        Intent in2 = getIntent();
        bmp = (Bitmap) in2.getParcelableExtra("BitmapImage");
        iv.setImageBitmap(bmp);
    }
}
