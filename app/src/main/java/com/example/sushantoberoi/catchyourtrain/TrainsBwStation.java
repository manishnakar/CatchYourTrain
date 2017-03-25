package com.example.sushantoberoi.catchyourtrain;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TrainsBwStation extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String data;
    ListView lv;
    TextView txt;
    String[] array_name;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Train Between Stations");
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_trains_bw_station);
        lv= (ListView) findViewById(R.id.listview);
        txt= (TextView) findViewById(R.id.txt);
        data = getIntent().getStringExtra("name");

        try {
            URL url = new URL(data);
            HttpURLConnection ucon=(HttpURLConnection)url.openConnection();
            InputStreamReader in =new InputStreamReader(ucon.getInputStream());
            BufferedReader br=new BufferedReader(in);
            String s;
            String json="";
            while((s=br.readLine())!=null){
                json+=s;
           }
            Gson gson=new Gson();
            TrainBwStationJson trainsBwStationJson=gson.fromJson(json,TrainBwStationJson.class);
            int numOftrains=trainsBwStationJson.getTotal();
//            Log.d("num",numOftrains+"");
            List<TrainBwStationJson.TrainBean> trains=trainsBwStationJson.getTrain();
            int size=trains.size(),k=0;
            array_name=new String[size];
            Log.d("size",size+"");
            for(int i=0;i<size;i++){
                String s1=trains.get(i).getNumber();
                String s2=trains.get(i).getName();
                array_name[k++]=s2+" "+s1;
            }
            Log.d("LOLO","lolo");

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_name);
                lv.setAdapter(adapter);
            lv.setOnItemClickListener(this);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String s=array_name[i];
        String[] arr=s.split(" ");
        int size=arr.length;
        String num=arr[size-1];
        Log.d("trainnum ",num);
        Intent j=new Intent(TrainsBwStation.this,FindTrains.class);
        String u="http://api.railwayapi.com/live/train/" + num + "/doj/" + SpotTrain.s3 + "/apikey/" + MainActivity.KEY + "/";
        //Log.d("url:",u);
        j.putExtra("name", u);
        startActivity(j);
    }
}
