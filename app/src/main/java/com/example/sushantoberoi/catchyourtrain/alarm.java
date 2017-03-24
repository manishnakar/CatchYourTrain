package com.example.sushantoberoi.catchyourtrain;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class alarm extends AppCompatActivity {
    Button alarmbtn;
    EditText destStation,date,trainnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Toast.makeText(this,"this is toast",Toast.LENGTH_LONG).show();
        alarmbtn=(Button)findViewById(R.id.alarmbtn);
        date=(EditText)findViewById(R.id.date);
        destStation= (EditText) findViewById(R.id.destStation);
        trainnum=(EditText)findViewById(R.id.trainNum);
        Log.d("hey1","hello1");
        Log.e("hey1","hello1");
        alarmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true) {
                            System.out.println("hello1");
                            Log.d("hey1","hello1");
                            Log.e("hey1","hello1");
                            String dest = destStation.getText().toString();
                            String dateofjourney = date.getText().toString();
                            String num = trainnum.getText().toString();
                            String data = "http://api.railwayapi.com/live/train/" + num + "/doj/" + dateofjourney + "/apikey/mbtervh9/";
                            try {
                                System.out.println("hello");
                                URL url = new URL(data);
                                HttpURLConnection ucon = (HttpURLConnection) url.openConnection();
                                InputStreamReader in = new InputStreamReader(ucon.getInputStream());
                                BufferedReader br = new BufferedReader(in);
                                String s;
                                String json = "";
                                while ((s = br.readLine()) != null) {
                                    json += s;
                                }
                                Log.e("hey1","hello1");
                                Gson gson = new Gson();
                                LiveStatus livestatus = gson.fromJson(json, LiveStatus.class);
                                LiveStatus.CurrentStationBean obj=new LiveStatus.CurrentStationBean();
                                String currst=obj.getStation_().getName();
                                if(currst.equals(dest)){
                                    MediaPlayer mp = MediaPlayer.create(alarm.this, R.raw.emergency_alert);
                                    mp.start();
                                    break;
                                }
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
    }
}
