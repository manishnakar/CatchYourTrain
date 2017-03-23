package com.example.sushantoberoi.catchyourtrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sushant oberoi on 21-03-2017.
 */
public class SpotTrain extends android.support.v4.app.Fragment {
    AutoCompleteTextView t1,t2,t3,t4;
    Button btn,btn2;
    String s1,s2,s3,s4,u;
    String[] array_name;
    ArrayAdapter<String> adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.spot,container,false);
        btn=(Button)v.findViewById(R.id.findTrains);
        btn2=(Button)v.findViewById(R.id.trainsbwStation);
        t1=(AutoCompleteTextView)v.findViewById(R.id.autoCompleteTextView);
        t2=(AutoCompleteTextView)v.findViewById(R.id.autoCompleteTextView2);
        t3=(AutoCompleteTextView)v.findViewById(R.id.autoCompleteTextView3);
        t4=(AutoCompleteTextView)v.findViewById(R.id.autoCompleteTextView4);

        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_name);
        //t1.setAdapter(adapter);
        //t2.setAdapter(adapter);
        //t3.setAdapter(adapter);
        //t4.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s3=t3.getText().toString();
                s4=t4.getText().toString();
                u="http://api.railwayapi.com/live/train/"+s3+"/doj/"+s4+"/apikey/mbtervh9/";
                Intent i=new Intent(getActivity(),FindTrains.class);
             //   Log.d("tag","hello");
                i.putExtra("name",u);
               // Log.d("tag","hello");
                startActivity(i);
               // Log.d("tag","hello");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=t1.getText().toString();
                s2=t2.getText().toString();
                s3=t4.getText().toString();
                Log.d("s1",s1);
                Log.d("s2",s2);
                Log.d("s3",s3);
                String dd=s3.substring(6,8);
                String mm=s3.substring(4,6);
                Log.d("mm",mm);
                Log.d("dd",dd);
                Toast.makeText(getContext(),dd+mm,Toast.LENGTH_LONG).show();
                u="http://api.railwayapi.com/between/source/"+s1+"/dest/"+s2+"/date/"+dd+"-"+mm+"/apikey/mbtervh9/";
                Intent i=new Intent(getActivity(),TrainsBwStation.class);
                Log.d("mm",mm);Log.d("dd",dd);
                i.putExtra("name",u);
                Log.d("mm",mm);Log.d("dd",dd);
                startActivity(i);
            }
        });
       return v;
    }
}
