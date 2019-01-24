package com.baseapp.v2.base;
import android.databinding.ViewDataBinding;


import com.baselibrary.BR;
import com.baselibrary.v2.base.BDViewModel;
import com.baselibrary.v2.base.BDialog;

import v2.weight.picker.view.DialogBuilder;


/**
 * @author: zjl
 * @Time: 2017/6/1 15:12
 * @Desc:
 */

public class BaseDialog<V extends BDViewModel, T extends ViewDataBinding> extends BDialog<V, T> {

    public BaseDialog(DialogBuilder builder, V viewModel) {
        super(builder, viewModel);
    }

    @Override
    protected void bindViewModel() {
        binding.setVariable(BR.viewModel, viewModel);
    }
}
