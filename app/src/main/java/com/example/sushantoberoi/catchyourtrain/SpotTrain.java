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
        t1.setAdapter(new PlacesAutoCompleteAdapter(getActivity(),R.layout.autocomplete_list_item));
        t2.setAdapter(new PlacesAutoCompleteAdapter(getActivity(),R.layout.autocomplete_list_item));
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
                int len=s1.length();
                String ans1="",ans2="";
                for(int i=0;i<len;i++){
                    if(s1.charAt(i)=='-'){
                        break;
                    }
                    ans1+=s1.charAt(i);
                }
                len=s2.length();
                for(int i=0;i<len;i++){
                    if(s2.charAt(i)=='-')
                        break;
                    ans2+=s2.charAt(i);
                }
                s1=ans1;
                s2=ans2;
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
