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
    String s1,s2,s4,u;
    static String s3;
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
                if(s3==null || s4==null || s3.isEmpty()|| s4.isEmpty()){
                    Toast.makeText(getContext(), "Kindly fill all fields", Toast.LENGTH_LONG).show();
                } else {
                    u = "http://api.railwayapi.com/live/train/" + s3 + "/doj/" + s4 + "/apikey/" + MainActivity.KEY + "/";
                    Intent i = new Intent(getActivity(), FindTrains.class);
                    //   Log.d("tag","hello");
                    i.putExtra("name", u);
                    // Log.d("tag","hello");
                    startActivity(i);
                    // Log.d("tag","hello");
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = t1.getText().toString();
                s2 = t2.getText().toString();
                if (s1 == null || s2 == null || s1.isEmpty()|| s2.isEmpty()) {
                    Toast.makeText(getContext(), "Kindly fill all fields", Toast.LENGTH_LONG).show();
                } else {
                    int len = s1.length();
                    String ans1 = "", ans2 = "";
                    for (int i = 0; i < len; i++) {
                        if (s1.charAt(i) == '-') {
                            break;
                        }
                        ans1 += s1.charAt(i);
                    }
                    len = s2.length();
                    for (int i = 0; i < len; i++) {
                        if (s2.charAt(i) == '-')
                            break;
                        ans2 += s2.charAt(i);
                    }
                    s1 = ans1;
                    s2 = ans2;
                    s3 = t4.getText().toString();
                    if (s3.isEmpty() || s3==null) {
                        Toast.makeText(getActivity(), "Please enter the date", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String dd = s3.substring(6, 8);
                    String mm = s3.substring(4, 6);
                    u = "http://api.railwayapi.com/between/source/" + s1 + "/dest/" + s2 + "/date/" + dd + "-" + mm + "/apikey/" + MainActivity.KEY + "/";
                    Intent i = new Intent(getActivity(), TrainsBwStation.class);
                    Log.d("mm", mm);
                    Log.d("dd", dd);
                    i.putExtra("name", u);
                    Log.d("mm", mm);
                    Log.d("dd", dd);
                    startActivity(i);
                }
            }
        });
       return v;
    }
/*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("from",t1.getText().toString());
        outState.putCharSequence("to",t2.getText().toString());
        outState.putCharSequence("trino",t3.getText().toString());
        outState.putCharSequence("date",t4.getText().toString());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null)
        {
            t1.setText(""+savedInstanceState.getCharSequence("from"));
            t2.setText(""+savedInstanceState.getCharSequence("to"));
            t3.setText(""+savedInstanceState.getCharSequence("trino"));
            t4.setText(""+savedInstanceState.getCharSequence("date"));
        }
    }*/
    /*
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        t1.setText(""+savedInstanceState.getCharSequence("from"));
        t2.setText(""+savedInstanceState.getCharSequence("to"));
        t3.setText(""+savedInstanceState.getCharSequence("trino"));
        t4.setText(""+savedInstanceState.getCharSequence("date"));
    }
    */
}
