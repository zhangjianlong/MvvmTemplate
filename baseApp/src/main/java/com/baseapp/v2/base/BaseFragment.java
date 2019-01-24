package com.baseapp.v2.base;

import android.databinding.ViewDataBinding;

import com.baseapp.v2.AApplication;
import com.baseapp.v2.di.components.AppComponent;
import com.baseapp.v2.di.modules.ActivityModule;
import com.baselibrary.BR;
import com.baselibrary.v2.base.BFViewModel;
import com.baselibrary.v2.base.BFragment;
import com.baselibrary.v2.di.HasComponent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;



/**
 * @author: zjl
 * @Time: 2017/6/1 15:12
 * @Desc:
 */

public class BaseFragment<V extends BFViewModel, T extends ViewDataBinding> extends BFragment<V, T> {

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

    @Override
    protected void bindViewModel() {
        binding.setVariable(BR.viewModel, viewModel);
    }


    /**
     * 为独立fragment注入
     *
     * @return
     */
    protected AppComponent getApplicationComponent() {
        return ((AApplication) getActivity().getApplication()).getAppComponent();
    }

    /**
     * 为独立fragment注入
     *
     * @return
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule((RxAppCompatActivity) getActivity());
    }
}
