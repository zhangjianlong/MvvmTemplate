package com.baselibrary.v2.base;

import android.app.Application;
import android.view.LayoutInflater;


import com.baselibrary.v2.utils.Static;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * Created by zoukaiyi on 2017/2/7.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        closeAndroidPDialog();
        init();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void init() {
        Static.CONTEXT = this;
        Static.INFLATER = LayoutInflater.from(this);

    }


    private void closeAndroidPDialog() {



            try {
                Class aClass = Class.forName("android.content.pm.PackageParser$Package");
                Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
                declaredConstructor.setAccessible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Class cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread");
                declaredMethod.setAccessible(true);
                Object activityThread = declaredMethod.invoke(null);
                Field mHiddenApiWarningShown = cls.getDeclaredField("mHiddenApiWarningShown");
                mHiddenApiWarningShown.setAccessible(true);
                mHiddenApiWarningShown.setBoolean(activityThread, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
