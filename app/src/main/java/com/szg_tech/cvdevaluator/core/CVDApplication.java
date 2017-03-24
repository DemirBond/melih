package com.szg_tech.cvdevaluator.core;

import android.app.Application;

import io.realm.Realm;

public class CVDApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
