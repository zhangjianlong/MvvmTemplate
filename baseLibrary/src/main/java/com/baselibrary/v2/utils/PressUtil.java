package com.baselibrary.v2.utils;

import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.baselibrary.v2.utils.messenger.Messenger;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subscribers.DisposableSubscriber;


/**
 * @author: zjl
 * @Time: 2017/6/1 15:18
 * @Desc:
 */

public class PressUtil {
    private static final long MAX_LONGPRESS_TIME = 1000 * 2;
    private static final long MIN_LONGPRESS_TIME = 1000;
    private static MotionEvent downEvent = null;
    private static MotionEvent moveEvent = null;
    private static Flowable<Long> timer;

    private static DisposableSubscriber<Long> subscriber;


    public static void isLongPressed(MotionEvent event) {
        float offsetX = 0f;
        float offsetY = 0f;
        long intervalTime = 0L;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downEvent = event;
                if (timer == null && subscriber == null) {
                    timer = Flowable.timer(MAX_LONGPRESS_TIME, TimeUnit.MILLISECONDS);
                    subscriber = new DisposableSubscriber<Long>() {
                        @Override
                        public void onNext(Long aLong) {
                            Log.v("Flowable", "before 3");
                        }

                        @Override
                        public void onError(Throwable throwable) {

                        }

                        @Override
                        public void onComplete() {
                            Log.v("isLongPressed","longPress1");
                            Messenger.getDefault().sendNoMsg(MessageKey.LONG_PRESS);
                            recoverDefault();

                        }
                    };
                    timer.subscribe(subscriber);
                }


                break;
            case MotionEvent.ACTION_MOVE:
                moveEvent = event;
                offsetX = Math.abs(moveEvent.getX() - downEvent.getX());
                offsetY = Math.abs(moveEvent.getY() - downEvent.getY());
                intervalTime = Math.abs(moveEvent.getEventTime() - downEvent.getDownTime());
                if (offsetX>=10&&offsetY>=10){
                    recoverDefault();
                }
//
//                if (offsetX <= 10 && offsetY <= 10 && Math.abs(intervalTime) <= MAX_LONGPRESS_TIME && Math.abs(MIN_LONGPRESS_TIME) >= MIN_LONGPRESS_TIME) {
//                    Log.v("isLongPressed","longPress2");
//                    Messenger.getDefault().sendNoMsg(MessageKey.LONG_PRESS);
//                    recoverDefault();
//
//                }
                break;
            case MotionEvent.ACTION_UP:
            default:
                Log.v("isLongPressed","cancel");
                recoverDefault();
                break;
        }


    }


    private static void recoverDefault() {
        if (timer != null) {
            subscriber.dispose();
        }
        downEvent = null;
        timer = null;
        downEvent = null;
        subscriber = null;
    }

}
