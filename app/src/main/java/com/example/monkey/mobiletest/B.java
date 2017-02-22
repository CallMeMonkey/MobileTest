package com.example.monkey.mobiletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class B extends BaseActivity {

    private ImageButton btc1;
    private ImageButton btc2;
    private ImageButton btc3;
    private ImageButton btc4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        initialView();
        initialListener();
    }

    private void initialView() {
        btc1 = (ImageButton) findViewById(R.id.btc1);
        btc2 = (ImageButton) findViewById(R.id.btc2);
        btc3 = (ImageButton) findViewById(R.id.btc3);
        btc4 = (ImageButton) findViewById(R.id.btc4);

    }

    private void initialListener(){

        btc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(A.class);
            }
        });

        btc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(B.class);
            }
        });

        btc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(C.class);
            }
        });

        btc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(D.class);
            }
        });

    }
}
