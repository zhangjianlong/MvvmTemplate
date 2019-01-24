package com.baseapp.v2.feature.activity.main;


import javax.inject.Inject;

import com.baseapp.R;
import com.baseapp.databinding.ActMainBinding;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import com.baselibrary.v2.base.BAViewModel;
import com.baselibrary.v2.di.PerActivity;

@PerActivity
public class MainViewModel extends BAViewModel<ActMainBinding> {


    @Inject
    public MainViewModel(RxAppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void afterViews() {

    }
}