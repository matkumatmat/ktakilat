package com.ktakilat.cbase.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class VerticalSwipeRefreshLayout extends SwipeRefreshLayout {
    public float c;
    public float d;
    public boolean e;
    public final int f;

    public VerticalSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r0 != 3) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = 0
            if (r0 == 0) goto L_0x003d
            r2 = 1
            if (r0 == r2) goto L_0x003a
            r3 = 2
            if (r0 == r3) goto L_0x0011
            r2 = 3
            if (r0 == r2) goto L_0x003a
            goto L_0x004b
        L_0x0011:
            boolean r0 = r5.e
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            float r0 = r6.getY()
            float r3 = r6.getX()
            float r4 = r5.d
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            float r4 = r5.c
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            int r4 = r5.f
            float r4 = (float) r4
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x004b
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x004b
            r5.e = r2
            return r1
        L_0x003a:
            r5.e = r1
            goto L_0x004b
        L_0x003d:
            float r0 = r6.getY()
            r5.c = r0
            float r0 = r6.getX()
            r5.d = r0
            r5.e = r1
        L_0x004b:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.weight.VerticalSwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
