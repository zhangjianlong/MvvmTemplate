package com.baselibrary.v2.base;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;


import com.baselibrary.v2.utils.inject.InjectUtil;
import com.baselibrary.v2.weight.AppException;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


import javax.inject.Inject;



/**
 * @author: zjl
 * @Time: 2017/6/1 15:17
 * @Desc:
 */

public abstract class BActivity<V extends BAViewModel, T extends ViewDataBinding> extends RxAppCompatActivity {

    protected LayoutInflater inflater;

    protected T binding;

    @Inject
    protected V viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater = LayoutInflater.from(this);
        initBeforeView();
        initRootView();
        viewModel.setBinding(binding);
        bindViewModel();
        initAfterView();
        viewModel.setFragmentManager(this.getSupportFragmentManager());
        viewModel.onCreate();
        viewModel.afterViews();
    }

    protected abstract void bindViewModel();

    protected void initBeforeView() {
        InjectUtil.injectBeforeView(this);
    }

    protected void initRootView() {
        try {
            binding = InjectUtil.injectBindRootView(this);
        } catch (Exception e) {
            AppException.binding(e).printStackTrace();
        }
    }

    protected void initAfterView() {
        InjectUtil.injectAfterView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();

        viewModel.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        viewModel.onDestroy();
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);//当应用已经启动了的时候  会调用onNewIntent方法
        viewModel.onNewIntent(intent);
    }
}
