package com.blankj.achievescroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/*********************************************
 * author: Blankj on 2016/7/26 18:32
 * blog:   http://blankj.com
 * e-mail: blankj@qq.com
 *********************************************/
public class DragView4 extends View {

    private int lastX;
    private int lastY;

    public DragView4(Context context) {
        super(context);
    }

    public DragView4(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragView4(Context context, AttributeSet attrs, int defStyleAttr) {
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
                int offsetY = y - lastY;
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
        }
        return true;
    }

}
