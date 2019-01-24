package com.baselibrary.v2.base;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.baselibrary.v2.utils.messenger.Messenger;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


/**
 * @author: zjl
 * @Time: 2017/6/1 15:18
 * @Desc:
 */

public class BViewModel<T> extends BaseObservable {

    protected RxAppCompatActivity activity;

    public BViewModel() {
        activity = null;
    }

    public BViewModel(RxAppCompatActivity activity) {
        this.activity = activity;
    }

    public RxAppCompatActivity getActivity() {
        return activity;
    }

    protected T binding;

    public void setBinding(T binding) {
        this.binding = binding;
    }

    protected void onStart() {

    }

    protected void onCreate() {

    }

    protected void onResume() {

    }

    protected void onPause() {

    }

    protected void onStop() {

    }

    protected void onNewIntent(Intent intent) {
    }

    protected void onDestroy() {
        Messenger.getDefault().unregister(this);
    }


    protected void setUserVisibleHint(boolean isVisibleToUser) {

    }


    @Bindable
    protected BViewModel getViewModel() {
        return this;
    }
}
