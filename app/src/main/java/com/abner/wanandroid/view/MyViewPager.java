package com.abner.wanandroid.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.orhanobut.logger.Logger;

/**
 * 解决ViewPager和DrawerLayout的事件冲突
 *
 * @author zhangduntai
 * @date 2019/1/14
 */
public class MyViewPager extends ViewPager {

    boolean isDraw = false;
    private float mInitialMotionX;
    private float mInitialMotionY;


    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDraw(boolean draw) {
        isDraw = draw;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = true;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        if (getCurrentItem() == 0) {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    Logger.i("Action_down:%s", x);
                    intercepted = true;
                    mInitialMotionX = x;
                    mInitialMotionY = y;
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                    Logger.i("Action_move:%s", x);
                    Logger.i("Action_move mInitialMotionX:%s", mInitialMotionX);
                    if (isDraw) {
                        intercepted = false;
                    } else if (x < mInitialMotionX) {
                        intercepted = true;
                    } else {
                        intercepted = false;
                    }
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    intercepted = true;
                    break;
                }

            }

        }
        Logger.i("interceptd:%s", intercepted);
        if (!intercepted) return intercepted;
        return super.onInterceptTouchEvent(ev);
    }
}
