package com.example.thota.icp5;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void OnCamera(View v){
        Intent toCamera= new Intent(MainActivity.this,CameraActivity.class);
        startActivity(toCamera);
    }
    public void Location(View v){
        Intent toLocation=new Intent(MainActivity.this,mapdetails.class);
        startActivity(toLocation);
    }
}
