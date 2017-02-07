package com.example.monkey.mobiletest;

import android.app.Application;

import com.example.monkey.mobiletest.util.UtilLog;

/**
 * Created by Monkey on 2/6/17.
 */

public class HouApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);

    }
}
