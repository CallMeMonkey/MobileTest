package com.example.monkey.mobiletest;

/**
 * Created by Monkey on 1/25/17.
 */

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monkey.mobiletest.Adapter.ListViewAdapter;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView ListView;
    private ArrayList<String> listResult;
    //ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listResult = new ArrayList<String>();
        createFakeResult();

        initialView();
    }

    public void createFakeResult(){
        listResult.add("aaaaaaaaaaaaaaaa");
        listResult.add("bbbbbbbb");
        listResult.add("cccccc");
        listResult.add("ddddddddd");
        listResult.add("eeeeeeeeeeeee");
        listResult.add("ffffffffffff");
        listResult.add("g");
        listResult.add("h");
        listResult.add("i");
        listResult.add("j");
        listResult.add("k");
        listResult.add("l");
        listResult.add("m");
        listResult.add("n");
        listResult.add("o");


    }

    private void initialView(){

        View view = getLayoutInflater().inflate(R.layout.list_view_header, null);
        ListView = (ListView) findViewById(R.id.List_view);
        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        ListView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("No more content.");
        tv.setTextSize(26);
        tv.setGravity(Gravity.CENTER);
        ListView.addFooterView(tv);

        ListView.setAdapter(listViewAdapter);
        ListView.setOnItemClickListener(this);
        ListView.invalidateViews();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "ListView was clicked at position:"+ position, Toast.LENGTH_LONG).show();
        Log.d("Name", String.valueOf(position));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("message", "ListView");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
