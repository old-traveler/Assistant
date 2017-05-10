package com.assistant.base;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by hyc on 2017/5/10 17:04
 */

public class AssistantApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
