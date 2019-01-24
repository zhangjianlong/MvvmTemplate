package com.baselibrary.v2.bindingadapter.common.itemviews;


import com.baselibrary.v2.bindingadapter.common.BaseItemViewSelector;
import com.baselibrary.v2.bindingadapter.common.ItemView;
import com.baselibrary.v2.bindingadapter.common.itemviews.ItemViewModel;



public class ItemViewModelSelector<T extends ItemViewModel> extends BaseItemViewSelector<T> {
    @Override
    public void select(ItemView itemView, int position, T item) {
        item.itemView(itemView);
    }
}
