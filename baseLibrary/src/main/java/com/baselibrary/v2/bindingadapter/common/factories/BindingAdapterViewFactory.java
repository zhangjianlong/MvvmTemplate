package com.baselibrary.v2.bindingadapter.common.factories;

import android.widget.AdapterView;

import com.baselibrary.v2.bindingadapter.common.BindingListViewAdapter;
import com.baselibrary.v2.bindingadapter.common.ItemViewArg;


public interface BindingAdapterViewFactory {
    <T> BindingListViewAdapter<T> create(AdapterView adapterView, ItemViewArg<T> arg);

    BindingAdapterViewFactory DEFAULT = new BindingAdapterViewFactory() {
        @Override
        public <T> BindingListViewAdapter<T> create(AdapterView adapterView, ItemViewArg<T> arg) {
            return new BindingListViewAdapter<>(arg);
        }
    };
}
