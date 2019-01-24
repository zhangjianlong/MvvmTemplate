package com.baselibrary.v2.base;

import android.app.ActivityManager;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.ComponentName;
import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.baselibrary.v2.base.BViewModel;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


import v2.command.ReplyCommand;



/**
 * @author: zjl
 * @Time: 2017/6/1 15:17
 * @Desc:
 */

public abstract class BAViewModel<T> extends BViewModel<T> {
    public static String Tag = BAViewModel.class.getSimpleName();
    public ObservableField<String> rightText = new ObservableField<>();
    public ObservableField<String> toolTitle = new ObservableField<>();
    public ObservableField<Drawable> rightDrawable = new ObservableField<>();

    protected FragmentManager fragmentManager;


    public abstract void afterViews();

    public BAViewModel(RxAppCompatActivity activity) {
        super(activity);
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
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

    @Override
    protected void onCreate() {
        super.onCreate();

    }

    @Override
    public void onStart() {

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


    public final ReplyCommand back = new ReplyCommand(() -> {
        activity.finish();
    });

    public final ReplyCommand rightTvClick = new ReplyCommand(() -> {
    });

}
