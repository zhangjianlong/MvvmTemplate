package com.baselibrary.v2.base;

import com.baselibrary.v2.base.BViewModel;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * @author: zjl
 * @Time:  2017/6/1 15:18
 * @Desc:
 */

public abstract class BDViewModel<T> extends BViewModel<T> {

    protected BDialog dialog;

    protected v2.base.OnDialogLisetener onDialogLisetener;


    public BDViewModel(RxAppCompatActivity activity) {
        super(activity);
    }

    public void setDialog(BDialog dialog) {
        this.dialog = dialog;
    }

    public void setOnDialogLisetener(v2.base.OnDialogLisetener onDialogLisetener) {
        this.onDialogLisetener = onDialogLisetener;
    }
}
