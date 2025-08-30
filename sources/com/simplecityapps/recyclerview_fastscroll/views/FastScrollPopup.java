package com.simplecityapps.recyclerview_fastscroll.views;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Keep;

public class FastScrollPopup {

    /* renamed from: a  reason: collision with root package name */
    public FastScrollRecyclerView f631a;
    public Resources b;
    public int c;
    public int d;
    public Path e;
    public RectF f;
    public Paint g;
    public int h;
    public Rect i;
    public Rect j;
    public Rect k;
    public String l;
    public Paint m;
    public Rect n;
    public float o;
    public ObjectAnimator p;
    public boolean q;
    public int r;
    public int s;

    public final void a(boolean z) {
        float f2;
        long j2;
        if (this.q != z) {
            this.q = z;
            ObjectAnimator objectAnimator = this.p;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (z) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{f2});
            this.p = ofFloat;
            if (z) {
                j2 = 200;
            } else {
                j2 = 150;
            }
            ofFloat.setDuration(j2);
            this.p.start();
        }
    }

    @Keep
    public float getAlpha() {
        return this.o;
    }

    @Keep
    public void setAlpha(float f2) {
        this.o = f2;
        this.f631a.invalidate(this.k);
    }
}
