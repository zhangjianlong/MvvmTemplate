package com.baseapp.v2.feature.activity.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.baseapp.R;
import com.baseapp.v2.base.BaseActivity;
import com.baseapp.databinding.ActMainBinding;
import com.baseapp.v2.di.components.DaggerMainComponent;
import com.baseapp.v2.di.components.MainComponent;
import com.baseapp.v2.di.modules.MainModule;

import v2.utils.inject.AfterViews;
import v2.utils.inject.BeforeViews;
import v2.utils.inject.RootView;


@RootView(R.layout.act_main)
public final class MainActivity extends BaseActivity<MainViewModel, ActMainBinding> {

    MainComponent component;

    public final static void instance(Context context) {
        instance(context, null);
    }

    public final static void instance(Context context, Bundle bundle) {
        Intent intent = new Intent(context, MainActivity.class);
        if (bundle != null) {
            intent.putExtra("data", bundle);
        }
        context.startActivity(intent);
    }

    @BeforeViews
    void beforViews() {
        component = DaggerMainComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .mainModule(new MainModule())
                .build();
        component.inject(this);
    }

    @AfterViews
    void afterViews() {
    }
}
