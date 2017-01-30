package com.example.monkey.mobiletest;

/**
 * Created by Monkey on 1/25/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.monkey.mobiletest.Adapter.ListViewAdapter;

public class ListViewActivity extends AppCompatActivity {

    private ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initialView();
    }

    private void initialView(){
        ListView = (ListView) findViewById(R.id.List_view);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this);
        ListView.setAdapter(listViewAdapter);
    }
}
