package com.abner.wanandroid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.orhanobut.logger.Logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

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
        if (getCurrentItem() == 0) { //在第一页拦截
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    intercepted = true;
                    mInitialMotionX = x;
                    mInitialMotionY = y;
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                    if (isDraw) { //打开状态必拦截
                        intercepted = false;
                    } else if (x < mInitialMotionX) {  //非打开状态向左划  不拦截
                        intercepted = true;
                    } else { // 其余状态拦截
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
        if (!intercepted) return intercepted;
        return super.onInterceptTouchEvent(ev);
    }
}
