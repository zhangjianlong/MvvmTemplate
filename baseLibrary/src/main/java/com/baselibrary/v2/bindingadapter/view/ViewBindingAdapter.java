package v2.bindingadapter.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import v2.command.ReplyCommand;


/**
 * Created by kelin on 16-3-24.
 */
public final class ViewBindingAdapter {

    @BindingAdapter({"clickCommand"})
    public static void clickCommand(View view, final ReplyCommand clickCommand) {
        if (!view.isEnabled()) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickCommand != null) {
                    clickCommand.execute();
                }
            }
        });
    }

    @BindingAdapter({"longClickCommand"})
    public static void longClickCommand(View view, final ReplyCommand longClickCommand) {
        if (!view.isEnabled()) {
            return;
        }
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longClickCommand != null) {
                    longClickCommand.execute();
                }
//                AnimatorSet animatorSetsuofang = new AnimatorSet();//组合动画
//                ObjectAnimator scaleX = ObjectAnimator.ofFloat(v, "scaleX", 1, 0.8f);
//                ObjectAnimator scaleY = ObjectAnimator.ofFloat(v, "scaleY", 1, 0.8f);
//                scaleX.setDuration(300);
//                scaleY.setDuration(300);
//                scaleX.setInterpolator(new DecelerateInterpolator());
//                scaleY.setInterpolator(new DecelerateInterpolator());
//
//                ObjectAnimator ra = ObjectAnimator.ofFloat(v,"rotation", -2f,2f);
//                ra.setDuration(100);
//                ra.setRepeatCount(-1);
//                ra.setRepeatMode(ValueAnimator.REVERSE);
//                ra.setInterpolator(new LinearInterpolator());
//
//                animatorSetsuofang.play(scaleX).with(scaleY);//两个动画同时开始
//                animatorSetsuofang.play(ra).after(scaleX);
//
//
//                animatorSetsuofang.start();

                return true;
            }
        });
    }


    @BindingAdapter({"requestFocus"})
    public static void requestFocusCommand(View view, final Boolean needRequestFocus) {
        if (needRequestFocus) {
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } else {
            view.clearFocus();
        }
    }

    @BindingAdapter({"onFocusChangeCommand"})
    public static void onFocusChangeCommand(View view, final ReplyCommand<Boolean> onFocusChangeCommand) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (onFocusChangeCommand != null) {
                    onFocusChangeCommand.execute(hasFocus);
                }
            }
        });
    }

//    @BindingAdapter({"onTouchCommand"})
//    public static void onTouchCommand(View view, final ResponseCommand<MotionEvent, Boolean> onTouchCommand) {
//        view.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (onTouchCommand != null) {
//                    return onTouchCommand.execute(event);
//                }
//                return false;
//            }
//        });
//    }


    public static class TextChangeDataWrapper {
        public CharSequence s;
        public int start;
        public int before;
        public int count;

        public TextChangeDataWrapper(CharSequence s, int start, int before, int count) {
            this.s = s;
            this.start = start;
            this.before = before;
            this.count = count;
        }
    }


}



