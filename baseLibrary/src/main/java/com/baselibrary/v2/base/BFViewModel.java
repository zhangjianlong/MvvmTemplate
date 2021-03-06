package com.baselibrary.v2.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * @author: zjl
 * @Time: 2017/6/1 15:18
 * @Desc:
 */

public abstract class BFViewModel<T> extends BViewModel<T> {
    public static String Tag = BFViewModel.class.getSimpleName();
    protected RxFragment fragment;

    public FragmentManager fragmentManager;

    public Bundle bundle;

    public abstract void afterViews();

    public BFViewModel(RxAppCompatActivity activity) {
        super(activity);
    }

    public void setFragment(RxFragment fragment) {
        this.fragment = fragment;
        bundle = fragment.getArguments();
        fragmentManager = fragment.getChildFragmentManager();
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment        The fragment to be added.
     */
    public void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    public void replaceFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onStart() {

    }

    public void onHiddenChanged(boolean hidden) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }


}
