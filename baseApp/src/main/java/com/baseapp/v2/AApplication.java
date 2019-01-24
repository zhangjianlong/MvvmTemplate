package com.baseapp.v2;


import android.content.Context;

import com.baseapp.v2.di.components.AppComponent;
import com.baseapp.v2.di.components.DaggerAppComponent;
import com.baseapp.v2.di.modules.AppModule;
import com.baselibrary.v2.base.BaseApplication;

/**
 * Created by ZouKaiyi
 * Date on 2017/2/8.
 * Description
 */

public class AApplication extends BaseApplication {
    public static AApplication application;

    public static Context getContext() {
        return context;
    }

    public static Context context;
    private AppComponent appComponent;




    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }


    public static AApplication getApplication() {
        return application;
    }



}
