package com.example.group.teamproject2.activitys;

import android.app.Application;
import android.content.Context;

import com.example.group.teamproject2.utils.GreenDaoManager;

/**
 * Created by Administrator on 2016/12/30.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        GreenDaoManager.getInstance(mContext);
    }

    public static Context getContext(){
        return mContext;
    }
}
