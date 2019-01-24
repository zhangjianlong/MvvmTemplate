package com.baseapp.v2.base;

import android.databinding.ViewDataBinding;

import com.baselibrary.BR;
import com.baselibrary.v2.base.BWindow;
import com.baselibrary.v2.base.BWindowViewModel;
import com.baselibrary.v2.weight.popupWindow.WindowBuilder;


/**
 * @author: zjl
 * @Time: 2017/7/19 18:52
 * @Desc:
 */
public class BaseWindow<V extends BWindowViewModel, T extends ViewDataBinding> extends BWindow<V, T> {

    public BaseWindow(WindowBuilder builder, V viewModel) {
        super(builder, viewModel);
    }

    @Override
    protected void bindViewModel() {
        binding.setVariable(BR.viewModel, viewModel);
    }

}
