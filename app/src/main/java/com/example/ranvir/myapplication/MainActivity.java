package com.example.ranvir.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b;
    Intent in,in2;
    final static int imagedata=0;
    ImageView imgv;
    Bitmap bmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.bCamera);
        imgv=(ImageView)findViewById(R.id.imgvi);
        b.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        in= new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(in,imagedata);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle extras =data.getExtras();
            bmp=(Bitmap)extras.get("data");
           // imgv.setImageBitmap(bmp);
            in2=new Intent(this,CamResult.class);
            in2.putExtra("BitmapImage", bmp);
            startActivity(in2);
        }
    }
}
