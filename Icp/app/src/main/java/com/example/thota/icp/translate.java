package com.example.thota.icp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class translate extends AppCompatActivity implements OnItemSelectedListener {
    String selected;//language selected from list
    String value;
    String x;
    TextView result1;//text view to display translated language
    HashMap<String, String> language = new HashMap<String, String>();//used to store language names and related codes
    String destinationLang;//selected language code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);


        language.put("English","en");language.put("Arabic","ar");language.put("Dutch","nl");language.put("Greek","el");language.put("Italian","it");
        language.put("Spanish","es");language.put("Chinese","zh");language.put("Marathi","mr");language.put("Punjabi","pa");language.put("Tamil","ta");
        language.put("Telugu","te");language.put("French","fr");language.put("Hindi","hi");language.put("Swedish","sv");language.put("Japanese","ja");
        List<String> options= new ArrayList<String>(language.keySet());
        Spinner spinner=(Spinner) findViewById(R.id.spinner);//assign spinner view to the spinner class object
        ArrayAdapter<String> languageadapter= new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,options);//array adapter is used to convert string values to view objects
        languageadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(languageadapter);//fit adapter to spinner
        spinner.setOnItemSelectedListener(this);//calls onItemSelected method
        result1=(TextView)findViewById(R.id.result);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selected=parent.getItemAtPosition(position).toString();
        destinationLang=language.get(selected).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void logout(View v){
        Intent redirect=new Intent(translate.this,MainActivity.class);
        startActivity(redirect);
    }
    public void translate(View v) {
        EditText Word = (EditText) findViewById(R.id.word);
        value = Word.getText().toString();
        String url = "https://translate.yandex.net/api/v1.5/tr.json/translate?" +
                "key=trnsl.1.1.20151023T145251Z.bf1ca7097253ff7e." +
                "c0b0a88bea31ba51f72504cc0cc42cf891ed90d2&text=" + value + "&" +
                "lang=en-" + destinationLang + "&[format=plain]&[options=1]&[callback=set]";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String answer = response.body().string();
                try {
                    JSONObject reader = new JSONObject(answer);//parse json objects
                    JSONArray text = reader.getJSONArray("text");//parse json array

                        x=text.get(0).toString();
                        Log.d("okHttp", reader.toString());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("xvalue",x);
                            result1.setText(x);//set the result value to the textview
                        }
                    });

                } catch (JSONException e1) {
                    e1.printStackTrace();
                }

            }
        });

    }
}
