package com.baselibrary.v2.base;


import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * @author: zjl
 * @Time: 2017/7/19 18:46
 * @Desc:
 */
public class BWindowViewModel<T> extends BViewModel<T> {
    protected BWindow bWindow;

    public BWindowViewModel(RxAppCompatActivity activity) {
        super(activity);
    }

    public void setWindow(BWindow bWindow) {
        this.bWindow = bWindow;
    }

}
