package com.baselibrary.v2.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.baselibrary.v2.base.BFViewModel;
import com.baselibrary.v2.utils.inject.InjectUtil;
import com.baselibrary.v2.weight.AppException;
import com.trello.rxlifecycle2.components.support.RxFragment;

import javax.inject.Inject;



/**
 * @author: zjl
 * @Time: 2017/6/1 15:18
 * @Desc:
 */

public abstract class BFragment<V extends BFViewModel, T extends ViewDataBinding> extends RxFragment {

    protected LayoutInflater inflater;

    protected FragmentActivity activity;

    @Inject
    protected V viewModel;

    protected T binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBeforeView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        try {
            binding = DataBindingUtil.inflate(inflater, InjectUtil.injectFrgRootView(this), container, false);
        } catch (Exception e) {
            AppException.binding(e).printStackTrace();
        }
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.v("viewModel:","viewModel is null: "+(viewModel==null));
        viewModel.setFragment(this);
        viewModel.setBinding(binding);
        bindViewModel();
        InjectUtil.injectAfterView(this);
        viewModel.afterViews();
    }

    protected abstract void bindViewModel();


    protected void initBeforeView() {
        InjectUtil.injectBeforeView(this);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (FragmentActivity) activity;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        viewModel.onHiddenChanged(hidden);
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        viewModel.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        // TODO Auto-generated method stub
        if (viewModel!=null){
            viewModel.setUserVisibleHint(isVisibleToUser);
        }

        super.setUserVisibleHint(isVisibleToUser);
    }
}
