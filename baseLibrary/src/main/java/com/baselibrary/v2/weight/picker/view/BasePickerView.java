package com.baselibrary.v2.weight.picker.view;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;


import com.baselibrary.R;
import com.baselibrary.v2.weight.picker.listener.OnDismissListener;


/**
 * Created by Sai on 15/11/22.
 * 精仿iOSPickerViewController控件
 */
public class BasePickerView {
    private final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM
    );

    protected Context context;
    protected ViewGroup contentContainer;
    private ViewGroup decorView;//activity的根View
    private ViewGroup rootView;//附加View 的 根View

    private OnDismissListener onDismissListener;
    private boolean isDismissing;

    private Animation outAnim;
    private Animation inAnim;
    private int gravity = Gravity.BOTTOM;

    private v2.weight.picker.view.DialogBuilder builder;

    public BasePickerView(v2.weight.picker.view.DialogBuilder builder) {
        this.context = builder.getContext();
        this.builder = builder;
        initViews();
        init();
        initEvents();
    }

    protected void initViews() {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        decorView = (ViewGroup) ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        rootView = (ViewGroup) layoutInflater.inflate(R.layout.weight_basepickerview, decorView, false);
        rootView.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        ));

        if (!builder.isBackgroud()) {
            rootView.findViewById(R.id.outmost_container).setBackgroundColor(context.getResources().getColor(R.color.transparent));
        }
        contentContainer = (ViewGroup) rootView.findViewById(R.id.content_container);
        contentContainer.setLayoutParams(builder.getContentParams());
    }

    protected void init() {
        inAnim = getInAnimation();
        outAnim = getOutAnimation();
    }

    protected void initEvents() {
        setCancelable(builder.isCancelable());
    }


    public static v2.weight.picker.view.DialogBuilder newDialog(Context context) {
        return new v2.weight.picker.view.DialogBuilder(context);
    }

    /**
     * show的时候调用
     *
     * @param view 这个View
     */
    private void onAttached(View view) {
        Log.v("BasePickerView","addView");
        decorView.addView(view);
        view.setAnimation(AnimationUtils.loadAnimation(context, R.anim.picker_alpha_in));
        contentContainer.startAnimation(inAnim);
        contentContainer.requestFocus();
        contentContainer.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getAction()) {
                    case KeyEvent.ACTION_UP:
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            if (builder.isCancelable()) {
                                Log.v("BasePickerView","onAttached addView");
                                dismiss();
                            }
                            return true;
                        }
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    /**
     * 添加这个View到Activity的根视图
     */
    public void show() {
        isDismissing = false;
        if (isShowing()) {
            return;
        }
        /**隐藏软键盘**/
        View view = ((Activity) context).getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        onAttached(rootView);
    }

    /**
     * 检测该View是不是已经添加到根视图
     *
     * @return 如果视图已经存在该View返回true
     */
    public boolean isShowing() {
        View view = decorView.findViewById(R.id.outmost_container);
        return view != null;
    }

    public void dismiss() {
        if (isDismissing) {
            return;
        }

        //消失动画
        outAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
//                decorView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.v("BasePickerView","remove");
//                        //从activity根视图移除
//                        Animation animation1 = AnimationUtils
//                                .loadAnimation(context, R.anim.picker_alpha_out);
//                        animation1.setAnimationListener(new Animation.AnimationListener() {
//                            @Override
//                            public void onAnimationStart(Animation animation) {
//
//                            }
//
//                            @Override
//                            public void onAnimationEnd(Animation animation) {
////
//                            }
//
//                            @Override
//                            public void onAnimationRepeat(Animation animation) {
//
//                            }
//                        });
//                        rootView.startAnimation(animation1);
//                        isDismissing = false;
//                        if (onDismissListener != null) {
//                            onDismissListener.onDismiss(BasePickerView.this);
//                        }
//                    }
//                });
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                decorView.removeView(rootView);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        contentContainer.startAnimation(outAnim);
        isDismissing = true;
    }

    public Animation getInAnimation() {
        return builder.getInAnimation();
    }

    public Animation getOutAnimation() {
        return builder.getOutAnimation();
    }

    public BasePickerView setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
        return this;
    }

    public BasePickerView setCancelable(boolean isCancelable) {
        View view = rootView.findViewById(R.id.outmost_container);

        if (isCancelable) {
            view.setOnTouchListener(onCancelableTouchListener);
        } else {
            view.setOnTouchListener(null);
        }
        return this;
    }

    /**
     * Called when the user touch on black overlay in order to dismiss the dialog
     */
    private final View.OnTouchListener onCancelableTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                dismiss();
            }
            return false;
        }
    };
    public View findViewById(int id) {
        return contentContainer.findViewById(id);
    }
}
