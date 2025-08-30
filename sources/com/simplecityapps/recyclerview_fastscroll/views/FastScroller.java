package com.simplecityapps.recyclerview_fastscroll.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.Keep;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.simplecityapps.recyclerview_fastscroll.R;
import com.simplecityapps.recyclerview_fastscroll.interfaces.OnFastScrollStateChangeListener;
import com.simplecityapps.recyclerview_fastscroll.utils.Utils;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FastScroller {

    /* renamed from: a  reason: collision with root package name */
    public final FastScrollRecyclerView f634a;
    public final FastScrollPopup b;
    public final int c;
    public final int d;
    public final Paint e;
    public final Paint f;
    public final int g;
    public final Rect h = new Rect();
    public final Rect i = new Rect();
    public final Rect j = new Rect();
    public final int k;
    public int l;
    public final Point m = new Point(-1, -1);
    public final Point n = new Point(0, 0);
    public boolean o;
    public ObjectAnimator p;
    public boolean q;
    public int r = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    public boolean s = true;
    public final Runnable t;
    public int u;
    public int v = 2030043136;
    public boolean w;
    public final int x;
    public int y;
    public final RectF z = new RectF();

    public @interface PopupPosition {
        public static final int ADJACENT = 0;
        public static final int CENTER = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PopupTextVerticalAlignmentMode {
        public static final int FONT_METRICS = 1;
        public static final int TEXT_BOUNDS = 0;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [com.simplecityapps.recyclerview_fastscroll.views.FastScrollPopup, java.lang.Object] */
    public FastScroller(Context context, FastScrollRecyclerView fastScrollRecyclerView, AttributeSet attributeSet) {
        int i2;
        FastScrollRecyclerView fastScrollRecyclerView2 = fastScrollRecyclerView;
        Resources resources = context.getResources();
        this.f634a = fastScrollRecyclerView2;
        ? obj = new Object();
        obj.e = new Path();
        obj.f = new RectF();
        obj.h = ViewCompat.MEASURED_STATE_MASK;
        obj.i = new Rect();
        obj.j = new Rect();
        obj.k = new Rect();
        obj.n = new Rect();
        obj.o = 1.0f;
        obj.b = resources;
        obj.f631a = fastScrollRecyclerView2;
        obj.g = new Paint(1);
        Paint paint = new Paint(1);
        obj.m = paint;
        paint.setAlpha(0);
        obj.m.setTextSize((float) ((int) TypedValue.applyDimension(2, 32.0f, resources.getDisplayMetrics())));
        obj.f631a.invalidate(obj.k);
        int i3 = (int) (resources.getDisplayMetrics().density * 62.0f);
        obj.c = i3;
        obj.d = i3 / 2;
        obj.f631a.invalidate(obj.k);
        this.b = obj;
        this.c = (int) (52.0f * resources.getDisplayMetrics().density);
        this.d = (int) (8.0f * resources.getDisplayMetrics().density);
        this.g = (int) (6.0f * resources.getDisplayMetrics().density);
        this.k = (int) (-24.0f * resources.getDisplayMetrics().density);
        Paint paint2 = new Paint(1);
        this.e = paint2;
        Paint paint3 = new Paint(1);
        this.f = paint3;
        this.x = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FastScrollRecyclerView, 0, 0);
        try {
            this.s = obtainStyledAttributes.getBoolean(R.styleable.FastScrollRecyclerView_fastScrollAutoHide, true);
            this.r = obtainStyledAttributes.getInteger(R.styleable.FastScrollRecyclerView_fastScrollAutoHideDelay, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
            this.w = obtainStyledAttributes.getBoolean(R.styleable.FastScrollRecyclerView_fastScrollEnableThumbInactiveColor, true);
            this.u = obtainStyledAttributes.getColor(R.styleable.FastScrollRecyclerView_fastScrollThumbColor, 2030043136);
            this.v = obtainStyledAttributes.getColor(R.styleable.FastScrollRecyclerView_fastScrollThumbInactiveColor, 2030043136);
            int color = obtainStyledAttributes.getColor(R.styleable.FastScrollRecyclerView_fastScrollTrackColor, 671088640);
            int color2 = obtainStyledAttributes.getColor(R.styleable.FastScrollRecyclerView_fastScrollPopupBgColor, ViewCompat.MEASURED_STATE_MASK);
            int color3 = obtainStyledAttributes.getColor(R.styleable.FastScrollRecyclerView_fastScrollPopupTextColor, -1);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FastScrollRecyclerView_fastScrollPopupTextSize, (int) TypedValue.applyDimension(2, 32.0f, resources.getDisplayMetrics()));
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FastScrollRecyclerView_fastScrollPopupBackgroundSize, (int) (62.0f * resources.getDisplayMetrics().density));
            int integer = obtainStyledAttributes.getInteger(R.styleable.FastScrollRecyclerView_fastScrollPopupTextVerticalAlignmentMode, 0);
            int integer2 = obtainStyledAttributes.getInteger(R.styleable.FastScrollRecyclerView_fastScrollPopupPosition, 0);
            paint3.setColor(color);
            if (this.w) {
                i2 = this.v;
            } else {
                i2 = this.u;
            }
            paint2.setColor(i2);
            obj.h = color2;
            obj.g.setColor(color2);
            obj.f631a.invalidate(obj.k);
            obj.m.setColor(color3);
            obj.f631a.invalidate(obj.k);
            obj.m.setTextSize((float) dimensionPixelSize);
            obj.f631a.invalidate(obj.k);
            obj.c = dimensionPixelSize2;
            obj.d = dimensionPixelSize2 / 2;
            obj.f631a.invalidate(obj.k);
            obj.r = integer;
            obj.s = integer2;
            obtainStyledAttributes.recycle();
            this.t = new Runnable() {
                public final void run() {
                    int i;
                    FastScroller fastScroller = FastScroller.this;
                    if (!fastScroller.o) {
                        ObjectAnimator objectAnimator = fastScroller.p;
                        if (objectAnimator != null) {
                            objectAnimator.cancel();
                        }
                        if (Utils.a(fastScroller.f634a.getResources())) {
                            i = -1;
                        } else {
                            i = 1;
                        }
                        ObjectAnimator ofInt = ObjectAnimator.ofInt(fastScroller, "offsetX", new int[]{Math.max(fastScroller.g, fastScroller.d) * i});
                        fastScroller.p = ofInt;
                        ofInt.setInterpolator(new FastOutLinearInInterpolator());
                        fastScroller.p.setDuration(200);
                        fastScroller.p.start();
                    }
                }
            };
            fastScrollRecyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    FastScroller fastScroller = FastScroller.this;
                    if (!fastScroller.f634a.isInEditMode()) {
                        if (!fastScroller.q) {
                            ObjectAnimator objectAnimator = fastScroller.p;
                            if (objectAnimator != null) {
                                objectAnimator.cancel();
                            }
                            ObjectAnimator ofInt = ObjectAnimator.ofInt(fastScroller, "offsetX", new int[]{0});
                            fastScroller.p = ofInt;
                            ofInt.setInterpolator(new LinearOutSlowInInterpolator());
                            fastScroller.p.setDuration(150);
                            fastScroller.p.addListener(new AnimatorListenerAdapter() {
                                public final void onAnimationCancel(Animator animator) {
                                    super.onAnimationCancel(animator);
                                    FastScroller.this.q = false;
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    super.onAnimationEnd(animator);
                                    FastScroller.this.q = false;
                                }
                            });
                            fastScroller.q = true;
                            fastScroller.p.start();
                        }
                        if (fastScroller.s) {
                            fastScroller.b();
                            return;
                        }
                        FastScrollRecyclerView fastScrollRecyclerView = fastScroller.f634a;
                        if (fastScrollRecyclerView != null) {
                            fastScrollRecyclerView.removeCallbacks(fastScroller.t);
                        }
                    }
                }
            });
            if (this.s) {
                b();
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void a(MotionEvent motionEvent, int i2, int i3, int i4, OnFastScrollStateChangeListener onFastScrollStateChangeListener) {
        int i5;
        int i6;
        int i7;
        float f2;
        int i8 = i2;
        int i9 = i3;
        int i10 = this.k;
        Rect rect = this.h;
        int i11 = this.g;
        int i12 = this.c;
        int action = motionEvent.getAction();
        int y2 = (int) motionEvent.getY();
        Point point = this.m;
        if (action != 0) {
            Paint paint = this.e;
            FastScrollPopup fastScrollPopup = this.b;
            if (action != 1) {
                if (action == 2) {
                    boolean z2 = this.o;
                    int i13 = this.x;
                    FastScrollRecyclerView fastScrollRecyclerView = this.f634a;
                    if (!z2) {
                        int i14 = point.x;
                        int i15 = point.y;
                        rect.set(i14, i15, i11 + i14, i15 + i12);
                        rect.inset(i10, i10);
                        if (rect.contains(i8, i9) && Math.abs(y2 - i9) > i13) {
                            fastScrollRecyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                            this.o = true;
                            this.l = (i4 - i9) + this.l;
                            fastScrollPopup.a(true);
                            if (onFastScrollStateChangeListener != null) {
                                onFastScrollStateChangeListener.b();
                            }
                            if (this.w) {
                                paint.setColor(this.u);
                            }
                        }
                    }
                    if (this.o) {
                        int i16 = this.y;
                        if (i16 == 0 || Math.abs(i16 - y2) >= i13) {
                            this.y = y2;
                            boolean g2 = fastScrollRecyclerView.g();
                            int height = fastScrollRecyclerView.getHeight() - i12;
                            float max = ((float) Math.max(0, Math.min(height, y2 - this.l))) / ((float) height);
                            if (g2) {
                                max = 1.0f - max;
                            }
                            int itemCount = fastScrollRecyclerView.getAdapter().getItemCount();
                            String str = "";
                            if (itemCount != 0) {
                                if (fastScrollRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                                    i5 = ((GridLayoutManager) fastScrollRecyclerView.getLayoutManager()).getSpanCount();
                                    itemCount = (int) Math.ceil(((double) itemCount) / ((double) i5));
                                } else {
                                    i5 = 1;
                                }
                                fastScrollRecyclerView.stopScroll();
                                FastScrollRecyclerView.ScrollPositionState scrollPositionState = fastScrollRecyclerView.e;
                                fastScrollRecyclerView.e(scrollPositionState);
                                if (fastScrollRecyclerView.getAdapter() instanceof FastScrollRecyclerView.MeasurableAdapter) {
                                    f2 = fastScrollRecyclerView.c(max);
                                    int d2 = (int) (((float) fastScrollRecyclerView.d(fastScrollRecyclerView.a())) * max);
                                    if (fastScrollRecyclerView.getAdapter() instanceof FastScrollRecyclerView.MeasurableAdapter) {
                                        FastScrollRecyclerView.MeasurableAdapter measurableAdapter = (FastScrollRecyclerView.MeasurableAdapter) fastScrollRecyclerView.getAdapter();
                                        i6 = 0;
                                        while (i6 < fastScrollRecyclerView.getAdapter().getItemCount()) {
                                            int b2 = fastScrollRecyclerView.b(i6);
                                            fastScrollRecyclerView.findViewHolderForAdapterPosition(i6);
                                            fastScrollRecyclerView.getAdapter().getItemViewType(i6);
                                            int a2 = measurableAdapter.a() + b2;
                                            if (i6 == fastScrollRecyclerView.getAdapter().getItemCount() - 1) {
                                                if (d2 >= b2 && d2 <= a2) {
                                                    i7 = fastScrollRecyclerView.b(i6) - d2;
                                                }
                                            } else if (d2 >= b2 && d2 < a2) {
                                                i7 = fastScrollRecyclerView.b(i6) - d2;
                                            }
                                            i6++;
                                        }
                                        int b3 = fastScrollRecyclerView.b(0);
                                        int b4 = fastScrollRecyclerView.b(fastScrollRecyclerView.getAdapter().getItemCount() - 1);
                                        fastScrollRecyclerView.findViewHolderForAdapterPosition(fastScrollRecyclerView.getAdapter().getItemCount() - 1);
                                        fastScrollRecyclerView.getAdapter().getItemViewType(fastScrollRecyclerView.getAdapter().getItemCount() - 1);
                                        throw new IllegalStateException(String.format("Invalid passed height: %d, [low: %d, height: %d]", new Object[]{Integer.valueOf(d2), Integer.valueOf(b3), Integer.valueOf(measurableAdapter.a() + b4)}));
                                    }
                                    throw new IllegalStateException("findMeasureAdapterFirstVisiblePosition() should only be called where the RecyclerView.Adapter is an instance of MeasurableAdapter");
                                }
                                float c2 = fastScrollRecyclerView.c(max);
                                int d3 = (int) (((float) fastScrollRecyclerView.d(itemCount * scrollPositionState.c)) * max);
                                int i17 = scrollPositionState.c;
                                int i18 = (i5 * d3) / i17;
                                i7 = -(d3 % i17);
                                f2 = c2;
                                i6 = i18;
                                ((LinearLayoutManager) fastScrollRecyclerView.getLayoutManager()).scrollToPositionWithOffset(i6, i7);
                                if (fastScrollRecyclerView.getAdapter() instanceof FastScrollRecyclerView.SectionedAdapter) {
                                    if (max == 1.0f) {
                                        f2 = (float) (fastScrollRecyclerView.getAdapter().getItemCount() - 1);
                                    }
                                    str = ((FastScrollRecyclerView.SectionedAdapter) fastScrollRecyclerView.getAdapter()).a((int) f2);
                                }
                            }
                            if (!str.equals(fastScrollPopup.l)) {
                                fastScrollPopup.l = str;
                                Paint paint2 = fastScrollPopup.m;
                                int length = str.length();
                                Rect rect2 = fastScrollPopup.n;
                                paint2.getTextBounds(str, 0, length, rect2);
                                rect2.right = (int) (paint2.measureText(str) + ((float) rect2.left));
                            }
                            fastScrollPopup.a(!str.isEmpty());
                            int i19 = point.y;
                            Rect rect3 = fastScrollPopup.i;
                            Rect rect4 = fastScrollPopup.k;
                            rect3.set(rect4);
                            if (fastScrollPopup.o <= 0.0f || TextUtils.isEmpty(fastScrollPopup.l)) {
                                rect4.setEmpty();
                            } else {
                                int scrollBarWidth = fastScrollRecyclerView.getScrollBarWidth();
                                int i20 = fastScrollPopup.c;
                                Rect rect5 = fastScrollPopup.n;
                                int round = Math.round(((float) (i20 - rect5.height())) / 10.0f);
                                int i21 = fastScrollPopup.c;
                                int max2 = Math.max(i21, (round * 10) + rect5.width());
                                if (fastScrollPopup.s == 1) {
                                    int width = (fastScrollRecyclerView.getWidth() - max2) / 2;
                                    rect4.left = width;
                                    rect4.right = width + max2;
                                    rect4.top = (fastScrollRecyclerView.getHeight() - i21) / 2;
                                } else {
                                    if (Utils.a(fastScrollPopup.b)) {
                                        int scrollBarWidth2 = fastScrollRecyclerView.getScrollBarWidth() * 2;
                                        rect4.left = scrollBarWidth2;
                                        rect4.right = scrollBarWidth2 + max2;
                                    } else {
                                        int width2 = fastScrollRecyclerView.getWidth() - (fastScrollRecyclerView.getScrollBarWidth() * 2);
                                        rect4.right = width2;
                                        rect4.left = width2 - max2;
                                    }
                                    rect4.top = (fastScrollRecyclerView.getScrollBarThumbHeight() / 2) + (((fastScrollRecyclerView.getPaddingTop() - fastScrollRecyclerView.getPaddingBottom()) + i19) - i21);
                                    rect4.top = Math.max(fastScrollRecyclerView.getPaddingTop() + scrollBarWidth, Math.min(rect4.top, ((fastScrollRecyclerView.getHeight() + fastScrollRecyclerView.getPaddingTop()) - scrollBarWidth) - i21));
                                }
                                rect4.bottom = rect4.top + i21;
                            }
                            rect3.union(rect4);
                            fastScrollRecyclerView.invalidate(rect3);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (action != 3) {
                    return;
                }
            }
            this.l = 0;
            this.y = 0;
            if (this.o) {
                this.o = false;
                fastScrollPopup.a(false);
                if (onFastScrollStateChangeListener != null) {
                    onFastScrollStateChangeListener.a();
                }
            }
            if (this.w) {
                paint.setColor(this.v);
                return;
            }
            return;
        }
        int i22 = point.x;
        int i23 = point.y;
        rect.set(i22, i23, i11 + i22, i12 + i23);
        rect.inset(i10, i10);
        if (rect.contains(i8, i9)) {
            this.l = i9 - point.y;
        }
    }

    public final void b() {
        FastScrollRecyclerView fastScrollRecyclerView = this.f634a;
        if (fastScrollRecyclerView != null) {
            Runnable runnable = this.t;
            if (fastScrollRecyclerView != null) {
                fastScrollRecyclerView.removeCallbacks(runnable);
            }
            fastScrollRecyclerView.postDelayed(runnable, (long) this.r);
        }
    }

    public final void c(int i2, int i3) {
        Point point = this.m;
        int i4 = point.x;
        if (i4 != i2 || point.y != i3) {
            Point point2 = this.n;
            int i5 = point2.x;
            int i6 = i4 + i5;
            int i7 = point2.y;
            int i8 = i4 + i5;
            int i9 = this.g;
            FastScrollRecyclerView fastScrollRecyclerView = this.f634a;
            int height = fastScrollRecyclerView.getHeight() + point2.y;
            Rect rect = this.i;
            rect.set(i6, i7, i8 + i9, height);
            point.set(i2, i3);
            int i10 = point.x;
            int i11 = point2.x;
            int height2 = fastScrollRecyclerView.getHeight() + point2.y;
            Rect rect2 = this.j;
            rect2.set(i10 + i11, point2.y, i10 + i11 + i9, height2);
            rect.union(rect2);
            fastScrollRecyclerView.invalidate(rect);
        }
    }

    @Keep
    public int getOffsetX() {
        return this.n.x;
    }

    @Keep
    public void setOffsetX(int i2) {
        Point point = this.n;
        int i3 = point.y;
        int i4 = point.x;
        if (i4 != i2) {
            Point point2 = this.m;
            int i5 = point2.x + i4;
            int i6 = this.g;
            FastScrollRecyclerView fastScrollRecyclerView = this.f634a;
            int height = fastScrollRecyclerView.getHeight() + point.y;
            Rect rect = this.i;
            rect.set(i5, i3, i5 + i6, height);
            point.set(i2, i3);
            int i7 = point2.x + point.x;
            int height2 = fastScrollRecyclerView.getHeight() + point.y;
            Rect rect2 = this.j;
            rect2.set(i7, point.y, i6 + i7, height2);
            rect.union(rect2);
            fastScrollRecyclerView.invalidate(rect);
        }
    }
}
