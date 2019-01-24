package com.baseapp.v2.di.components;


import com.baseapp.v2.di.components.ActivityComponent;
import com.baseapp.v2.di.components.AppComponent;
import com.baseapp.v2.di.modules.ActivityModule;
import com.baseapp.v2.di.modules.MainModule;
import com.baseapp.v2.feature.activity.main.MainActivity;

import dagger.Component;

import com.baselibrary.v2.di.PerActivity;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, MainModule.class})
public interface MainComponent extends ActivityComponent {
    void inject(MainActivity activity);
}