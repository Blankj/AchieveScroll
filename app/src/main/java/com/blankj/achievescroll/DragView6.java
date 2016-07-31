package com.blankj.achievescroll;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/*********************************************
 * author: Blankj on 2016/7/26 18:32
 * blog:   http://blankj.com
 * e-mail: blankj@qq.com
 *********************************************/
public class DragView6 extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public DragView6(Context context) {
        super(context);
    }

    public DragView6(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragView6(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录触摸点坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;// 同时对left和right进行偏移
                offsetLeftAndRight(offsetX);
                // 同时对top和bottom进行偏移
                offsetTopAndBottom(offsetY);
                break;
            case MotionEvent.ACTION_UP:
                // 手指离开时，执行滑动过程
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(this, "translationX", -getLeft());
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(this, "translationY", -getTop());
                AnimatorSet set = new AnimatorSet();
                set.playTogether(animator1, animator2);
                set.start();
                break;
        }
        return true;
    }
}
