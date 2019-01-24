package com.baselibrary.v2.bindingadapter.common.factories;


import android.support.v7.widget.RecyclerView;

import com.baselibrary.v2.bindingadapter.common.BindingRecyclerViewAdapter;
import com.baselibrary.v2.bindingadapter.common.ItemViewArg;


public interface BindingRecyclerViewAdapterFactory {
    <T> BindingRecyclerViewAdapter<T> create(RecyclerView recyclerView, ItemViewArg<T> arg);

    BindingRecyclerViewAdapterFactory DEFAULT = new BindingRecyclerViewAdapterFactory() {
        @Override
        public <T> BindingRecyclerViewAdapter<T> create(RecyclerView recyclerView, ItemViewArg<T> arg) {
            return new BindingRecyclerViewAdapter<>(arg);
        }
    };
}
