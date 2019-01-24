package com.baselibrary.v2.bindingadapter.common.factories;

import android.support.v4.view.ViewPager;


import com.baselibrary.v2.bindingadapter.common.BindingLoopViewPagerAdapter;
import com.baselibrary.v2.bindingadapter.common.BindingViewPagerAdapter;
import com.baselibrary.v2.bindingadapter.common.ItemViewArg;



public interface BindingViewPagerAdapterFactory {
    <T> BindingViewPagerAdapter<T> create(ViewPager viewPager, ItemViewArg<T> arg);

    BindingViewPagerAdapterFactory DEFAULT = new BindingViewPagerAdapterFactory() {
        @Override
        public <T> BindingViewPagerAdapter<T> create(ViewPager viewPager, ItemViewArg<T> arg) {
            return new BindingViewPagerAdapter<>(arg);
        }
    };

    BindingViewPagerAdapterFactory BANNER = new BindingViewPagerAdapterFactory() {
        @Override
        public <T> BindingViewPagerAdapter<T> create(ViewPager viewPager, ItemViewArg<T> arg) {
            return new BindingLoopViewPagerAdapter<>(arg);
        }
    };
}
