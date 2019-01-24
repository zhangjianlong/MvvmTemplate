package com.baselibrary.v2.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;

import com.baselibrary.v2.utils.inject.InjectUtil;
import com.baselibrary.v2.weight.picker.view.BasePickerView;

import v2.weight.picker.view.DialogBuilder;

/**
 * @author: zjl
 * @Time: 2017/6/1 15:17
 * @Desc:
 */

public abstract class BDialog<V extends BDViewModel, T extends ViewDataBinding> extends BasePickerView {

    protected LayoutInflater inflater;

    protected V viewModel;

    protected T binding;

    public BDialog(DialogBuilder builder, V viewModel) {
        super(builder);
        this.viewModel = viewModel;
        binding = DataBindingUtil.
                inflate(LayoutInflater.from(context), InjectUtil.injectFrgRootView(this), contentContainer, true);
        viewModel.setBinding(binding);
        bindViewModel();
        InjectUtil.injectAfterView(this);
        viewModel.setDialog(this);
    }

    public static DialogBuilder newDialog(Context context) {
        return new DialogBuilder(context);
    }

    protected abstract void bindViewModel();

    public void setOnDialogLisetener(v2.base.OnDialogLisetener onDialogLisetener) {
        viewModel.setOnDialogLisetener(onDialogLisetener);
    }



}
