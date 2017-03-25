package com.example.sushantoberoi.catchyourtrain;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Alarm extends AppCompatActivity {

    AutoCompleteTextView a1,a2;
    Button b1;
    EditText t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm2);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        getSupportActionBar().setTitle("Set Alarm");
        a1=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView5);
        a2=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView6);
        b1=(Button)findViewById(R.id.button);
        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAlert();
            }
        });
    }

    public void startAlert() {
        final String s1 = a1.getText().toString();
        final String s2 = a2.getText().toString();
        final String s3 = t1.getText().toString();
        final String s4 = t2.getText().toString();
        final String data = "http://api.railwayapi.com/live/train/" + s1 + "/doj/" + s3 + "/apikey/" + MainActivity.KEY + "/";
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {

                    URL url = null;
                    try {
                        url = new URL(data);
                        HttpURLConnection ucon = null;
                        ucon = (HttpURLConnection) url.openConnection();
                        InputStreamReader in = null;
                        in = new InputStreamReader(ucon.getInputStream());
                        BufferedReader br = new BufferedReader(in);
                        String s;
                        String json = "";
                        while ((s = br.readLine()) != null) {
                            json += s;
                        }

                        Gson gson = new Gson();
                        LiveStatus livestatus = gson.fromJson(json, LiveStatus.class);
                        //int numberOfStops=livestatus.getRoute().size();
                        String trainnum = livestatus.getTrain_number();
                        LiveStatus.CurrentStationBean currstation = livestatus.getCurrent_station();
                        int dist = 0;
                        if (currstation != null) {
                            dist = currstation.getDistance();
                        }
                        Log.d("curr_dist", dist + "");
                        List<LiveStatus.RouteBean> route = livestatus.getRoute();
                        int dest_dist = 0;
                        Log.d("LOLO","LOLO");
                        Log.d("LOLO",s2);
                        Log.d("LOLO",route.size()+"");
                        int flag=0;
                        for (int i = 0; i < route.size(); i++) {
                            Log.d("LOLO",route.get(i).getStation_().getCode());
                            if (route.get(i).getStation_().getCode().equalsIgnoreCase(s2)) {
                                dest_dist = route.get(i).getDistance();  // check
                                flag=1;
                                /*

                                */
                                Log.d("LO","LO");
                                Log.d("i is",i+"");
                                break;
                            }
                        }
                        if(flag==0){
                            break;
                        }
                        Log.d("dest_dist", dest_dist + "");
                        int diff=Integer.parseInt(s4);
                        if (dest_dist-dist-diff<=0){
                            alert(1);
                            break;
                        }
                        if(dest_dist-dist-diff>50)
                            Thread.sleep(300000);
                    /*
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                    Date date1 = null;
                    date1 = format.parse(time1);

                    Date date2 = null;
                    date2 = format.parse(time2);

                    Date date3= null;
                    date3 = format.parse(s4);

                    long difference = date2.getTime() - date1.getTime() + date3.getTime();
                    Log.d("tag1",difference+"");
                    alert(difference);*/
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }/* catch (ParseException e) {
                    e.printStackTrace();
                }*/ catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

            /*
            long t=System.currentTimeMillis();
            Log.d("arr time",""+new LiveStatus.CurrentStationBean().getActarr());
            Toast.makeText(getApplicationContext(),""+new LiveStatus.CurrentStationBean().getActarr(),Toast.LENGTH_LONG).show();*/
    }
    public void alert(long i) {
            Intent intent = new Intent(this, Mote.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    this.getApplicationContext(), 234324243, intent, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                    + (i * 1000), pendingIntent);
        Intent j=new Intent(this,StopAlarm.class);
        startActivity(j);
    }
}
