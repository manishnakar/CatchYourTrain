package com.example.sushantoberoi.catchyourtrain;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SaveContacts extends AppCompatActivity implements  AdapterView.OnItemClickListener {
    ListView lv;
    Button btn;
    String query,name,con;
    EditText t1,t2;
    String []array_name;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_contacts);
        btn=(Button)findViewById(R.id.btn);
        t1=(EditText)findViewById(R.id.txt1);
        t2=(EditText)findViewById(R.id.txt2);
        lv= (ListView)findViewById(R.id.listView2);
            SQLiteDatabase data = openOrCreateDatabase("hint", MODE_PRIVATE, null); //nobody other can access
            //it is stored in our phone only
            data.execSQL("create table if not exists contacts(name varchar, contact varchar);");
            query = "select * from contacts";
            Cursor c = data.rawQuery(query, null);
            int cnt = c.getCount();
        if(cnt>0) {
            c.moveToFirst();
            array_name = new String[cnt];
            int k = 0;
            Log.d("Hello","count : "+cnt);
            while (!c.isAfterLast()) {
                String s1 = c.getString(c.getColumnIndex("name"));
                String s2 = c.getString(c.getColumnIndex("contact"));
                Toast.makeText(this, s1 + " " + s2, Toast.LENGTH_LONG).show();
                array_name[k++] = s1 + " " + s2;
                c.moveToNext();
            }

            Toast.makeText(this, "sss1", Toast.LENGTH_LONG).show();
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array_name);
            lv.setAdapter(adapter);
        }
        Log.d("Hello","This is for the first");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=t1.getText().toString();
                con=t2.getText().toString();
                SQLiteDatabase data=openOrCreateDatabase("hint",MODE_PRIVATE,null); //nobody other can access
                //it is stored in our phone only
                data.execSQL("create table if not exists contacts(name varchar, contact varchar);");
                data.execSQL("insert into contacts values ('" + name + "','" + con + "');");
                //adapter.add(""+name+" "+con);
                }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
