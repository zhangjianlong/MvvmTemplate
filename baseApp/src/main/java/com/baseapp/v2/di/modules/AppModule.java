package com.baseapp.v2.di.modules;


import com.baseapp.v2.AApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eric on 16/3/22.
 */
@Module
public class AppModule {
    private AApplication application;

    public AppModule(AApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    AApplication provideApplicationContext() {
        return application;
    }


}
