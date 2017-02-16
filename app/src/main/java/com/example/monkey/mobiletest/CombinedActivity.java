package com.example.monkey.mobiletest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monkey.mobiletest.Adapter.ListViewAdapter;
import com.example.monkey.mobiletest.Adapter.ViewPagerAdapter;
import com.example.monkey.mobiletest.fragment.ContentFragment;
import com.example.monkey.mobiletest.fragment.HistoryFragment;
import com.example.monkey.mobiletest.fragment.LoginFragment;

import java.util.ArrayList;

/**
 * Created by Monkey on 2/15/17.
 */

public class CombinedActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ViewPager viewPagerCombined;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private ListView listViewCombined;
    private ArrayList<String> listResultCombined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined);
        listResultCombined = new ArrayList<String>();
        createFakeResult();
        initial();
    }

    private void createFakeResult() {
        listResultCombined.add("aaaaaaaaaaaaaaaa");
        listResultCombined.add("bbbbbbbb");
        listResultCombined.add("cccccc");
        listResultCombined.add("ddddddddd");
        listResultCombined.add("eeeeeeeeeeeee");
        listResultCombined.add("ffffffffffff");
        listResultCombined.add("g");
        listResultCombined.add("h");
        listResultCombined.add("i");
        listResultCombined.add("j");
        listResultCombined.add("k");
        listResultCombined.add("l");
        listResultCombined.add("m");
        listResultCombined.add("n");
        listResultCombined.add("o");
    }

    private void initial(){
        viewPagerCombined = (ViewPager) findViewById(R.id.combined_view_pager);
        fragmentList.add(new LoginFragment());
        fragmentList.add(new HistoryFragment());
        fragmentList.add(new ContentFragment());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPagerCombined.setAdapter(viewPagerAdapter);

        listViewCombined = (ListView) findViewById(R.id.combined_list_view);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResultCombined);
        TextView tv = new TextView(this);
        tv.setText("No more content.");
        tv.setTextSize(26);
        tv.setGravity(Gravity.CENTER);
        listViewCombined.addFooterView(tv);

        listViewCombined.setAdapter(listViewAdapter);
        listViewCombined.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "ListView was clicked at position:"+ position, Toast.LENGTH_LONG).show();
        //Log.d("Name", String.valueOf(position));
    }
}
