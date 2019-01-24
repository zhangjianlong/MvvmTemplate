package com.baseapp.v2.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;


import com.baseapp.BR;
import com.baseapp.v2.AApplication;
import com.baseapp.v2.di.components.AppComponent;
import com.baseapp.v2.di.modules.ActivityModule;
import com.baselibrary.v2.base.BAViewModel;
import com.baselibrary.v2.base.BActivity;


/**
 * @author: zjl
 * @Time: 2017/6/1 15:12
 * @Desc:
 */

public class BaseActivity<V extends BAViewModel, T extends ViewDataBinding> extends BActivity<V, T> {



    public static String Tag = BaseActivity.class.getSimpleName();
    @Override
    protected void initBeforeView() {
        super.initBeforeView();
        getApplicationComponent().inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void bindViewModel() {
        binding.setVariable(BR.viewModel, viewModel);
    }

    protected AppComponent getApplicationComponent() {
        return ((AApplication) getApplication()).getAppComponent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        doSpecialiSomethingAsVirtualBar();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Get an Activity module for dependency injection.
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }


    /**
     * 虚拟按键-tangZd
     */
    private void doSpecialiSomethingAsVirtualBar() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }





}
