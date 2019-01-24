package v2.bindingadapter.common;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * @author: zjl
 * @Time: 2017/8/8 13:34
 * @Desc:
 */

public class NoScrollRecyleLinearMannager extends LinearLayoutManager {
    private boolean isScrollEnabled = false;

    public NoScrollRecyleLinearMannager(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }
}
