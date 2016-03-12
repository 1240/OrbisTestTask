package com.l24o.orbistesttask;

import android.app.Application;

import com.l24o.orbistesttask.realm.RealmHelper;

import io.realm.Realm;

/**
 * Created by chuff on 12.03.2016.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RealmHelper.clear(Realm.getInstance(getApplicationContext()));
    }
}
