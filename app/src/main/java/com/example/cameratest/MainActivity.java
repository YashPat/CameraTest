package com.example.cameratest;

import android.hardware.*;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Camera camera;
    FrameLayout frameLayout;
    ShowCamera showCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);

        //open camera
        camera = Camera.open();
        showCamera = new ShowCamera(this,camera);
        frameLayout.addView(showCamera);

    }
    Camera.PictureCallback mPictureCallback = new Camera.PictureCallback(){

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

        }
    };

    public void captureImage(View v){
        if (camera != null){
            camera.takePicture(null,null,mPictureCallback);
        }
    }
}
