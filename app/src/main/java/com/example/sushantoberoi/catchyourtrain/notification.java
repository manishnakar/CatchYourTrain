package com.example.sushantoberoi.catchyourtrain;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class notification extends AppCompatActivity {
    Button alarmbtn;
    String currtrainnum,currdate;
    EditText destStation,date,trainnum,time;
    NotificationCompat.Builder builder;
    NotificationManager mNotificationManager;
    String beforeTime;
    private int uniqueID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        getSupportActionBar().setTitle("Get Notifications");
        time=(EditText)findViewById(R.id.time);
        builder =
                new NotificationCompat.Builder(this);
        builder.setAutoCancel(true);
        uniqueID=34527;
        alarmbtn=(Button)findViewById(R.id.alarmbtn);
        date=(EditText)findViewById(R.id.date);
        destStation= (EditText) findViewById(R.id.destStation);
        trainnum=(EditText)findViewById(R.id.trainNum);
        alarmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        currtrainnum=trainnum.getText().toString();
                        currdate=date.getText().toString();
                        while(true){
                            try {
                                addNotification();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                Thread.sleep(1000000); // to be updated 2 min
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

               /* new Thread(new Runnable() {
                    @Override
                    public void run() {
                    String dest = destStation.getText().toString();
                            String dateofjourney = date.getText().toString();
                            String num = trainnum.getText().toString();
                        beforeTime=time.getText().toString();
                        while(true) {
                            String data = "http://api.railwayapi.com/live/train/" + num + "/doj/" + dateofjourney + "/apikey/"+MainActivity.KEY+"/";
                            try {
                               URL url = new URL(data);
                                HttpURLConnection ucon = (HttpURLConnection) url.openConnection();
                                InputStreamReader in = new InputStreamReader(ucon.getInputStream());
                                BufferedReader br = new BufferedReader(in);
                                String s;
                                String json = "";
                                while ((s = br.readLine()) != null) {
                                    json += s;
                                }
                                Gson gson = new Gson();
                                LiveStatus livestatus = gson.fromJson(json, LiveStatus.class);
                                LiveStatus.CurrentStationBean.StationBean obj=new LiveStatus.CurrentStationBean.StationBean();
                                String currst=obj.getCode();
                                if(dest==currst){
                                    MediaPlayer mp = MediaPlayer.create(notification.this, R.raw.emergency_alert);
                                    mp.start();
                                    break;
                                }
                                Thread.sleep(10000);
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();*/
            }
        });
    }
    public  void addNotification() throws IOException {
        String data = "http://api.railwayapi.com/live/train/" + currtrainnum + "/doj/" + currdate + "/apikey/" + MainActivity.KEY + "/";
        URL url = new URL(data);
        HttpURLConnection ucon = (HttpURLConnection) url.openConnection();
        InputStreamReader in = new InputStreamReader(ucon.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String s;
        String json = "";
        while ((s = br.readLine()) != null) {
            json += s;
        }
        Gson gson = new Gson();
        String dest=destStation.getText().toString();
        LiveStatus livestatus = gson.fromJson(json, LiveStatus.class);
        String position = livestatus.getPosition();
        builder.setSmallIcon(R.drawable.notification);
        builder.setTicker("Your Live Status:");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("Live running status");
        //builder.setContentText(""+position);
         /* Increase notification number every time a new notification arrives */

   /* Add Big View Specific Configuration */
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        if (position != null) {
            int size = position.length();
            String ans2 = "", ans1 = "";
            ans2 += currtrainnum + " ";
            int flag = 0;
            for (int j = 0; j < size; j++) {
                if (j > size / 2 && position.charAt(j) == ' ')
                    flag = 1;
                if (flag == 1)
                    ans1 += position.charAt(j);
                else
                    ans2 += position.charAt(j);
            }
            List<LiveStatus.RouteBean> route= livestatus.getRoute();
            int count=route.size();
            System.out.println(count);
            String dist="";
            for(int i=0;i<count;i++){
                if(route.get(i).getStation_().getCode().equalsIgnoreCase(dest)){
                    dist=route.get(i).getActarr();
                    break;
                }
            }
            System.out.println(dist);
            String[] events = new String[4];
            events[0] = new String(ans2);
            events[1] = new String(ans1);
            events[2]=new String("Actual Arrival For Your Station time is: "+dist);
            //events[3]=new String("Status is: "+new LiveStatus.CurrentStationBean().getStatus());
            // Sets a title for the Inbox style big view
            inboxStyle.setBigContentTitle("Running Status");

            // Moves events into the big view
            for (int i = 0; i < events.length; i++) {
                inboxStyle.addLine(events[i]);
            }

            builder.setStyle(inboxStyle);
            Intent resultIntent = new Intent(this, MainActivity.class);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(MainActivity.class);

   /* Adds the Intent that starts the Activity to the top of the stack */
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

            builder.setContentIntent(resultPendingIntent);
            mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

   /* notificationID allows you to update the notification later on. */
            mNotificationManager.notify(uniqueID, builder.build());
        }
    }
}

