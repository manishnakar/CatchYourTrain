package com.example.sushantoberoi.catchyourtrain;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FindTrains extends AppCompatActivity {
    TextView txt,txt2,txt3;
    String data;
    ArrayAdapter<String>adapter;
    List<String>array_name;
    ListView lv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Check Live status");
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_find_trains);
        data = getIntent().getStringExtra("name");
        txt=(TextView)findViewById(R.id.txt);
        txt2=(TextView)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
        lv3=(ListView)findViewById(R.id.lv3);
        try {
            URL url=new URL(data);
            HttpURLConnection ucon=(HttpURLConnection)url.openConnection();
            InputStreamReader in =new InputStreamReader(ucon.getInputStream());
            BufferedReader br=new BufferedReader(in);
            String s;
            array_name=new ArrayList<String>();
            String json="";
            while((s=br.readLine())!=null){
                json+=s;
            }
            Gson gson=new Gson();
            LiveStatus livestatus=gson.fromJson(json,LiveStatus.class);
            String trainnum=livestatus.getTrain_number();
            LiveStatus.CurrentStationBean currstation=livestatus.getCurrent_station();
            if(currstation!=null) {
                String position = livestatus.getPosition();
                int dist = currstation.getDistance();
                txt.setText("Train Number " + trainnum);
                System.out.println(trainnum);
                txt2.setText("Current Station " + position);
                txt3.setText("Distance is " + dist);
            }

            List<LiveStatus.RouteBean> obj=livestatus.getRoute();
            for(int i=0;i<obj.size();i++){
                if(obj.get(i).isHas_arrived()==false)
                {
                    array_name.add("("+obj.get(i).getStation_().getCode()+")"+"-"+obj.get(i).getStation_().getName()+"\n"+"Sch. Arr. "+obj.get(i).getScharr()+"\n"+"Act. Arr. "+obj.get(i).getActarr());
                }
            }
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_name);
            lv3.setAdapter(adapter);
        } catch (MalformedURLException e) {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }

    }
}
