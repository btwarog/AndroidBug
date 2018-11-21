package pl.btwarog.apptest;

import android.app.Application;
import android.content.Context;

public class TestApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

}
