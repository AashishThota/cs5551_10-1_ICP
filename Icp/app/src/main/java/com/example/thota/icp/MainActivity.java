package com.example.thota.icp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
public void Credentials(View v){
        EditText user = (EditText) findViewById(R.id.Username);
        EditText pass = (EditText) findViewById(R.id.Pass);
        String username= user.getText().toString();//get the value of text field
        String Password= pass.getText().toString();//get the value of password
        if(username.equals("aashish") && Password.equals("aashish"))
        {
            Intent intent=new Intent(MainActivity.this,translate.class);
            startActivity(intent);//sends control to translate activity
        }
        else{
            user.setText("");
            pass.setText("");
        }
    }
}
