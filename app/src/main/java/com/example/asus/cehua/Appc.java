package com.example.asus.cehua;

import android.app.Application;

import org.xutils.x;

/**
 * Created by asus on 2017/8/29.
 */

public class Appc  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
