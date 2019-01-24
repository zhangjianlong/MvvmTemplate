package com.baseapp.v2.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.baselibrary.v2.base.BAViewModel;


/**
 * @author: zjl
 * @Time: 2017/11/17 10:52
 * @Desc:
 */

public abstract class BackActivity<V extends BAViewModel, T extends ViewDataBinding> extends BaseActivity<V, T> {

    @Override
    protected void initAfterView() {
        setSupportActionBar(setToolBar());
        setToolBar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        super.initAfterView();
    }

    protected abstract Toolbar setToolBar();
}
