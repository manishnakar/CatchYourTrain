package com.example.sushantoberoi.catchyourtrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by sushant oberoi on 21-03-2017.
 */
public class Security extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener{
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.security, container, false);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(),R.array.items,android.R.layout.simple_list_item_1);
        lv= (ListView) v.findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==0)
        {
            Intent intent=new Intent(getActivity(),SaveContacts.class);
            startActivity(intent);
        }
        else if(i==1){
            String location="agra";
            String msg="help me: my location is: "+location;
            String num="999999999";
            SmsManager s=SmsManager.getDefault();
            s.sendTextMessage(num,null,msg,null,null);
        }
    }
}
