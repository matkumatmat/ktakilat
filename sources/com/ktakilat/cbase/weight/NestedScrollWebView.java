package com.ktakilat.cbase.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.ktakilat.cbase.utils.LogUtil;

public class NestedScrollWebView extends WebView implements NestedScrollingChild {
    public int c;
    public final int[] d = new int[2];
    public final int[] e = new int[2];
    public int f;
    public final NestedScrollingChildHelper g = new NestedScrollingChildHelper(this);

    public NestedScrollWebView(Context context) {
        super(context);
        setNestedScrollingEnabled(true);
    }

    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.g.dispatchNestedFling(f2, f3, z);
    }

    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return this.g.dispatchNestedPreFling(f2, f3);
    }

    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.g.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.g.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public final boolean hasNestedScrollingParent() {
        return this.g.hasNestedScrollingParent();
    }

    public final boolean isNestedScrollingEnabled() {
        return this.g.isNestedScrollingEnabled();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f = 0;
        }
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, (float) this.f);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.c - y;
                    NestedScrollingChildHelper nestedScrollingChildHelper = this.g;
                    int[] iArr = this.e;
                    int[] iArr2 = this.d;
                    if (nestedScrollingChildHelper.dispatchNestedPreScroll(0, i, iArr, iArr2)) {
                        i -= iArr[1];
                        obtain.offsetLocation(0.0f, (float) iArr2[1]);
                        this.f += iArr2[1];
                    }
                    this.c = y - iArr2[1];
                    int scrollY = getScrollY();
                    int max = Math.max(0, scrollY + i) - scrollY;
                    if (this.g.dispatchNestedScroll(0, max, 0, i - max, this.d)) {
                        int i2 = this.c;
                        int i3 = iArr2[1];
                        this.c = i2 - i3;
                        obtain.offsetLocation(0.0f, (float) i3);
                        this.f += iArr2[1];
                    }
                    boolean onTouchEvent = super.onTouchEvent(obtain);
                    obtain.recycle();
                    return onTouchEvent;
                } else if (!(actionMasked == 3 || actionMasked == 5 || actionMasked == 6)) {
                    return false;
                }
            }
            stopNestedScroll();
            return super.onTouchEvent(motionEvent);
        }
        this.c = y;
        startNestedScroll(2);
        return super.onTouchEvent(motionEvent);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.g.setNestedScrollingEnabled(z);
    }

    public void setOverScrollMode(int i) {
        try {
            super.setOverScrollMode(i);
        } catch (Throwable th) {
            LogUtil.a(th);
        }
    }

    public final boolean startNestedScroll(int i) {
        return this.g.startNestedScroll(i);
    }

    public final void stopNestedScroll() {
        this.g.stopNestedScroll();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setNestedScrollingEnabled(true);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setNestedScrollingEnabled(true);
    }
}
