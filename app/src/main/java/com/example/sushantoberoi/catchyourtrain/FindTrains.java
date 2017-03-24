package com.example.sushantoberoi.catchyourtrain;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FindTrains extends AppCompatActivity {
    TextView txt,txt2,txt3;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_find_trains);
        data = getIntent().getStringExtra("name");
        txt=(TextView)findViewById(R.id.txt);
        txt2=(TextView)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
        try {
            URL url=new URL(data);
            HttpURLConnection ucon=(HttpURLConnection)url.openConnection();
            InputStreamReader in =new InputStreamReader(ucon.getInputStream());
            BufferedReader br=new BufferedReader(in);
            String s;
            String json="";
            while((s=br.readLine())!=null){
                json+=s;
            }
            Gson gson=new Gson();
            LiveStatus livestatus=gson.fromJson(json,LiveStatus.class);
            String trainnum=livestatus.getTrain_number();
            LiveStatus.CurrentStationBean currstation=livestatus.getCurrent_station();
            String position=livestatus.getPosition();
            int dist=currstation.getDistance();
            txt.setText("Train Number "+trainnum);
            System.out.println(trainnum);
            txt2.setText("Current Station "+position);
            txt3.setText("Distance is "+dist);
        } catch (MalformedURLException e) {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }

    }
}
