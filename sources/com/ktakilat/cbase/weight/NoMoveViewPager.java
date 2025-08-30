package com.ktakilat.cbase.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class NoMoveViewPager extends ViewPager {
    public NoMoveViewPager(Context context) {
        super(context);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public NoMoveViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
