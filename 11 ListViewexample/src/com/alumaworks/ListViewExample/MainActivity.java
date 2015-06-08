package com.alumaworks.ListViewExample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static ListView listView;
    private static String[] NAMES = new String[] {"John","Mark","US"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListViewthod();
    }
    public void ListViewthod(){
        listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_view,NAMES);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=(String)listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,"Position :"+position+"Value: "+value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
