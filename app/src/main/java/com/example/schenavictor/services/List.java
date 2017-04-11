package com.example.schenavictor.services;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.schenavictor.services.Entity.Adapter_List_View;

/**
 * Created by 2015102617 on 03/04/2017.
 */
public class List extends AppCompatActivity {
    private Adapter_List_View AdapterListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        AdapterListView = new Adapter_List_View(this);
        ListView listView =(ListView)findViewById(R.id.listView);
        listView.setAdapter(AdapterListView);
    }
}
