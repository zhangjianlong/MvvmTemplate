package com.baselibrary.v2.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.baselibrary.v2.base.BWindowViewModel;
import com.baselibrary.v2.utils.inject.InjectUtil;
import com.baselibrary.v2.weight.popupWindow.BasePopupWindow;
import com.baselibrary.v2.weight.popupWindow.WindowBuilder;


/**
 * @author: zjl
 * @Time: 2017/7/19 18:46
 * @Desc:
 */
public abstract class BWindow<V extends BWindowViewModel, T extends ViewDataBinding> extends BasePopupWindow {


    public BWindow(WindowBuilder builder) {
        super(builder);
    }


    protected LayoutInflater inflater;

    protected V viewModel;

    protected T binding;

    public BWindow(WindowBuilder builder, V viewModel) {
        super(builder);
        this.viewModel = viewModel;
        binding = DataBindingUtil.
                inflate(LayoutInflater.from(context), InjectUtil.injectFrgRootView(this), null, false)
        ;
        contentView = binding.getRoot();
        this.setContentView(contentView);
        viewModel.setBinding(binding);
        bindViewModel();
        InjectUtil.injectAfterView(this);
        viewModel.setWindow(this);



    }

    protected abstract void bindViewModel();

    public static WindowBuilder newWindow(Context context) {
        return new WindowBuilder(context);
    }
}
