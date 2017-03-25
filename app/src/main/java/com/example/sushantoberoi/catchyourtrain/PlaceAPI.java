package com.example.sushantoberoi.catchyourtrain;

/**
 * Created by sushant oberoi on 24-03-2017.
 */

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class PlaceAPI {

    private static final String TAG = PlaceAPI.class.getSimpleName();
    String s1="http://api.railwayapi.com/suggest_station/name/";
    String s2="/apikey/"+MainActivity.KEY+"/";

    public ArrayList<String> autocomplete (String input) {
        ArrayList<String> resultList = null;
        String s3 = s1 + input + s2;
        try {
            URL url = new URL(s3);
            HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
            hcon.connect();
            if (hcon == null)
                System.out.println("Null");
            System.out.println("Hello");
            InputStreamReader in = new InputStreamReader(hcon.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String json = "", s;
            System.out.println(json);
            while ((s = br.readLine()) != null) {
                json += s;
            }
            Gson gson = new Gson();
            com.example.sushantoberoi.catchyourtrain.JsonObject obj = gson.fromJson(json,com.example.sushantoberoi.catchyourtrain.JsonObject.class);
            List<com.example.sushantoberoi.catchyourtrain.JsonObject.StationBean> ans = obj.getStation();
            resultList=new ArrayList<String>(obj.getTotal());
            for (int i = 0; i < obj.getTotal(); i++) {
                resultList.add(ans.get(i).getCode() + "-" + ans.get(i).getFullname());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

}