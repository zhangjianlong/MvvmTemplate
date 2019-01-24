package v2.weight.picker.utils;

import android.view.Gravity;

import com.baselibrary.R;


/**
 * Created by Sai on 15/8/9.
 */
public class PickerViewAnimateUtil {
    private static final int INVALID = -1;

    /**
     * Get default animation resource when not defined by the user
     *
     * @param gravity       the gravity of the dialog
     * @param isInAnimation determine if is in or out animation. true when is is
     * @return the id of the animation resource
     */
    public static int getAnimationResource(int gravity, boolean isInAnimation) {
        switch (gravity) {
            case Gravity.BOTTOM:
                return isInAnimation ? R.anim.picker_trans_in : R.anim.picker_trans_out;
            case Gravity.CENTER:
                return isInAnimation ? R.anim.picker_scan_in : R.anim.picker_scan_out;
            case Gravity.RIGHT:
                return isInAnimation ? R.anim.slide_right_in : R.anim.slide_right_out;
        }
        return INVALID;
    }
}