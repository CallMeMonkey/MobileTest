package com.example.monkey.mobiletest;

/**
 * Created by Monkey on 1/25/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.monkey.mobiletest.Adapter.ListViewAdapter;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

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
        ListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "ListView was clicked at position:"+ position, Toast.LENGTH_LONG).show();
    }
}
