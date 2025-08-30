package com.simplecityapps.recyclerview_fastscroll.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.simplecityapps.recyclerview_fastscroll.R;
import com.simplecityapps.recyclerview_fastscroll.interfaces.OnFastScrollStateChangeListener;
import com.simplecityapps.recyclerview_fastscroll.utils.Utils;
import com.simplecityapps.recyclerview_fastscroll.views.FastScroller;

public class FastScrollRecyclerView extends RecyclerView implements RecyclerView.OnItemTouchListener {
    public final FastScroller c;
    public boolean d;
    public final ScrollPositionState e;
    public int f;
    public int g;
    public int i;
    public final SparseIntArray j;
    public final ScrollOffsetInvalidator k;
    public OnFastScrollStateChangeListener l;

    public interface MeasurableAdapter<VH extends RecyclerView.ViewHolder> {
        int a();
    }

    public class ScrollOffsetInvalidator extends RecyclerView.AdapterDataObserver {
        public ScrollOffsetInvalidator() {
        }

        public final void a() {
            FastScrollRecyclerView.this.j.clear();
        }

        public final void onChanged() {
            a();
        }

        public final void onItemRangeChanged(int i, int i2) {
            a();
        }

        public final void onItemRangeInserted(int i, int i2) {
            a();
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            a();
        }

        public final void onItemRangeRemoved(int i, int i2) {
            a();
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            a();
        }
    }

    public static class ScrollPositionState {

        /* renamed from: a  reason: collision with root package name */
        public int f633a;
        public int b;
        public int c;
    }

    public interface SectionedAdapter {
        String a(int i);
    }

    public FastScrollRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final int a() {
        if (getAdapter() instanceof MeasurableAdapter) {
            return b(getAdapter().getItemCount());
        }
        throw new IllegalStateException("calculateAdapterHeight() should only be called where the RecyclerView.Adapter is an instance of MeasurableAdapter");
    }

    public final int b(int i2) {
        if (getAdapter() instanceof MeasurableAdapter) {
            SparseIntArray sparseIntArray = this.j;
            if (sparseIntArray.indexOfKey(i2) >= 0) {
                return sparseIntArray.get(i2);
            }
            MeasurableAdapter measurableAdapter = (MeasurableAdapter) getAdapter();
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sparseIntArray.put(i4, i3);
                getAdapter().getItemViewType(i4);
                findViewHolderForAdapterPosition(i4);
                i3 += measurableAdapter.a();
            }
            sparseIntArray.put(i2, i3);
            return i3;
        }
        throw new IllegalStateException("calculateScrollDistanceToPosition() should only be called where the RecyclerView.Adapter is an instance of MeasurableAdapter");
    }

    public final float c(float f2) {
        if (!(getAdapter() instanceof MeasurableAdapter)) {
            return ((float) getAdapter().getItemCount()) * f2;
        }
        MeasurableAdapter measurableAdapter = (MeasurableAdapter) getAdapter();
        int a2 = (int) (((float) a()) * f2);
        for (int i2 = 0; i2 < getAdapter().getItemCount(); i2++) {
            int b = b(i2);
            findViewHolderForAdapterPosition(i2);
            getAdapter().getItemViewType(i2);
            int a3 = measurableAdapter.a() + b;
            if (i2 == getAdapter().getItemCount() - 1) {
                if (a2 >= b && a2 <= a3) {
                    return (float) i2;
                }
            } else if (a2 >= b && a2 < a3) {
                return (float) i2;
            }
        }
        Log.w("FastScrollRecyclerView", "Failed to find a view at the provided scroll fraction (" + f2 + ")");
        return f2 * ((float) getAdapter().getItemCount());
    }

    public final int d(int i2) {
        return (getPaddingBottom() + (getPaddingTop() + i2)) - getHeight();
    }

    public final void draw(Canvas canvas) {
        float[] fArr;
        float f2;
        float[] fArr2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        if (this.d) {
            RecyclerView.Adapter adapter = getAdapter();
            FastScroller fastScroller = this.c;
            if (adapter != null) {
                int itemCount = getAdapter().getItemCount();
                if (getLayoutManager() instanceof GridLayoutManager) {
                    itemCount = (int) Math.ceil(((double) itemCount) / ((double) ((GridLayoutManager) getLayoutManager()).getSpanCount()));
                }
                if (itemCount == 0) {
                    fastScroller.c(-1, -1);
                } else {
                    ScrollPositionState scrollPositionState = this.e;
                    e(scrollPositionState);
                    if (scrollPositionState.f633a < 0) {
                        fastScroller.c(-1, -1);
                    } else {
                        if (getAdapter() instanceof MeasurableAdapter) {
                            i3 = d(a());
                            i2 = b(scrollPositionState.f633a);
                        } else {
                            i3 = d(itemCount * scrollPositionState.c);
                            i2 = scrollPositionState.f633a * scrollPositionState.c;
                        }
                        int availableScrollBarHeight = getAvailableScrollBarHeight();
                        if (i3 <= 0) {
                            fastScroller.c(-1, -1);
                        } else {
                            int min = Math.min(i3, getPaddingTop() + i2);
                            if (g()) {
                                i4 = (min + scrollPositionState.b) - availableScrollBarHeight;
                            } else {
                                i4 = min - scrollPositionState.b;
                            }
                            int i7 = (int) ((((float) i4) / ((float) i3)) * ((float) availableScrollBarHeight));
                            if (g()) {
                                i5 = getPaddingBottom() + (availableScrollBarHeight - i7);
                            } else {
                                i5 = i7 + getPaddingTop();
                            }
                            if (Utils.a(getResources())) {
                                i6 = 0;
                            } else {
                                i6 = getWidth() - Math.max(fastScroller.g, fastScroller.d);
                            }
                            fastScroller.c(i6, i5);
                        }
                    }
                }
            }
            Point point = fastScroller.m;
            int i8 = point.x;
            if (i8 >= 0 && point.y >= 0) {
                RectF rectF = fastScroller.z;
                Point point2 = fastScroller.n;
                int i9 = i8 + point2.x;
                int i10 = fastScroller.d;
                int i11 = fastScroller.g;
                int i12 = i10 - i11;
                int i13 = point2.y;
                FastScrollRecyclerView fastScrollRecyclerView = fastScroller.f634a;
                rectF.set((float) (i12 + i9), (float) (fastScrollRecyclerView.getPaddingTop() + i13), (float) (point.x + point2.x + i11 + i12), (float) ((fastScrollRecyclerView.getHeight() + point2.y) - fastScrollRecyclerView.getPaddingBottom()));
                float f3 = (float) i11;
                canvas2.drawRoundRect(rectF, f3, f3, fastScroller.f);
                int i14 = point.x + point2.x;
                int i15 = i12 / 2;
                int i16 = point.y + point2.y;
                rectF.set((float) (i15 + i14), (float) i16, (float) (i14 + i10 + i15), (float) (i16 + fastScroller.c));
                float f4 = (float) i10;
                canvas2.drawRoundRect(rectF, f4, f4, fastScroller.e);
                FastScrollPopup fastScrollPopup = fastScroller.b;
                if (fastScrollPopup.o > 0.0f && !TextUtils.isEmpty(fastScrollPopup.l)) {
                    int save = canvas.save();
                    Rect rect = fastScrollPopup.k;
                    canvas2.translate((float) rect.left, (float) rect.top);
                    Rect rect2 = fastScrollPopup.j;
                    rect2.set(rect);
                    rect2.offsetTo(0, 0);
                    Path path = fastScrollPopup.e;
                    path.reset();
                    RectF rectF2 = fastScrollPopup.f;
                    rectF2.set(rect2);
                    if (fastScrollPopup.s == 1) {
                        float f5 = (float) fastScrollPopup.d;
                        fArr = new float[]{f5, f5, f5, f5, f5, f5, f5, f5};
                    } else {
                        if (Utils.a(fastScrollPopup.b)) {
                            float f6 = (float) fastScrollPopup.d;
                            fArr2 = new float[]{f6, f6, f6, f6, f6, f6, 0.0f, 0.0f};
                        } else {
                            float f7 = (float) fastScrollPopup.d;
                            fArr2 = new float[]{f7, f7, f7, f7, 0.0f, 0.0f, f7, f7};
                        }
                        fArr = fArr2;
                    }
                    int i17 = fastScrollPopup.r;
                    Paint paint = fastScrollPopup.m;
                    Rect rect3 = fastScrollPopup.n;
                    if (i17 == 1) {
                        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                        f2 = ((((float) rect.height()) - fontMetrics.ascent) - fontMetrics.descent) / 2.0f;
                    } else {
                        f2 = ((float) (rect3.height() + rect.height())) / 2.0f;
                    }
                    path.addRoundRect(rectF2, fArr, Path.Direction.CW);
                    Paint paint2 = fastScrollPopup.g;
                    paint2.setAlpha((int) (((float) Color.alpha(fastScrollPopup.h)) * fastScrollPopup.o));
                    paint.setAlpha((int) (fastScrollPopup.o * 255.0f));
                    canvas2.drawPath(path, paint2);
                    canvas2.drawText(fastScrollPopup.l, ((float) (rect.width() - rect3.width())) / 2.0f, f2, paint);
                    canvas2.restoreToCount(save);
                }
            }
        }
    }

    public final void e(ScrollPositionState scrollPositionState) {
        scrollPositionState.f633a = -1;
        scrollPositionState.b = -1;
        scrollPositionState.c = -1;
        if (getAdapter().getItemCount() != 0 && getChildCount() != 0) {
            View childAt = getChildAt(0);
            scrollPositionState.f633a = getChildAdapterPosition(childAt);
            if (getLayoutManager() instanceof GridLayoutManager) {
                scrollPositionState.f633a /= ((GridLayoutManager) getLayoutManager()).getSpanCount();
            }
            if (getAdapter() instanceof MeasurableAdapter) {
                scrollPositionState.b = getLayoutManager().getDecoratedTop(childAt);
                findViewHolderForAdapterPosition(scrollPositionState.f633a);
                getAdapter().getItemViewType(scrollPositionState.f633a);
                scrollPositionState.c = ((MeasurableAdapter) getAdapter()).a();
                return;
            }
            scrollPositionState.b = getLayoutManager().getDecoratedTop(childAt);
            scrollPositionState.c = getLayoutManager().getBottomDecorationHeight(childAt) + getLayoutManager().getTopDecorationHeight(childAt) + childAt.getHeight();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r1 != 3) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(android.view.MotionEvent r19) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r19.getAction()
            float r2 = r19.getX()
            int r5 = (int) r2
            float r2 = r19.getY()
            int r10 = (int) r2
            if (r1 == 0) goto L_0x0040
            r2 = 1
            if (r1 == r2) goto L_0x002c
            r2 = 2
            if (r1 == r2) goto L_0x001c
            r2 = 3
            if (r1 == r2) goto L_0x002c
            goto L_0x0051
        L_0x001c:
            r0.i = r10
            int r8 = r0.f
            int r9 = r0.g
            com.simplecityapps.recyclerview_fastscroll.interfaces.OnFastScrollStateChangeListener r11 = r0.l
            com.simplecityapps.recyclerview_fastscroll.views.FastScroller r6 = r0.c
            r7 = r19
            r6.a(r7, r8, r9, r10, r11)
            goto L_0x0051
        L_0x002c:
            int r14 = r0.f
            int r15 = r0.g
            int r1 = r0.i
            com.simplecityapps.recyclerview_fastscroll.interfaces.OnFastScrollStateChangeListener r2 = r0.l
            com.simplecityapps.recyclerview_fastscroll.views.FastScroller r12 = r0.c
            r13 = r19
            r16 = r1
            r17 = r2
            r12.a(r13, r14, r15, r16, r17)
            goto L_0x0051
        L_0x0040:
            r0.f = r5
            r0.i = r10
            r0.g = r10
            com.simplecityapps.recyclerview_fastscroll.views.FastScroller r3 = r0.c
            com.simplecityapps.recyclerview_fastscroll.interfaces.OnFastScrollStateChangeListener r8 = r0.l
            r4 = r19
            r6 = r10
            r7 = r10
            r3.a(r4, r5, r6, r7, r8)
        L_0x0051:
            com.simplecityapps.recyclerview_fastscroll.views.FastScroller r1 = r0.c
            boolean r1 = r1.o
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView.f(android.view.MotionEvent):boolean");
    }

    public final boolean g() {
        if (getLayoutManager() instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) getLayoutManager()).getReverseLayout();
        }
        return false;
    }

    public int getAvailableScrollBarHeight() {
        return ((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.c.c;
    }

    public int getScrollBarThumbHeight() {
        return this.c.c;
    }

    public int getScrollBarWidth() {
        FastScroller fastScroller = this.c;
        return Math.max(fastScroller.g, fastScroller.d);
    }

    public final void onFinishInflate() {
        super.onFinishInflate();
        addOnItemTouchListener(this);
    }

    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        return f(motionEvent);
    }

    public final void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        f(motionEvent);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        ScrollOffsetInvalidator scrollOffsetInvalidator = this.k;
        if (adapter2 != null) {
            getAdapter().unregisterAdapterDataObserver(scrollOffsetInvalidator);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(scrollOffsetInvalidator);
        }
        super.setAdapter(adapter);
    }

    public void setAutoHideDelay(int i2) {
        FastScroller fastScroller = this.c;
        fastScroller.r = i2;
        if (fastScroller.s) {
            fastScroller.b();
        }
    }

    public void setAutoHideEnabled(boolean z) {
        FastScroller fastScroller = this.c;
        fastScroller.s = z;
        if (z) {
            fastScroller.b();
            return;
        }
        FastScrollRecyclerView fastScrollRecyclerView = fastScroller.f634a;
        if (fastScrollRecyclerView != null) {
            fastScrollRecyclerView.removeCallbacks(fastScroller.t);
        }
    }

    public void setFastScrollEnabled(boolean z) {
        this.d = z;
    }

    public void setOnFastScrollStateChangeListener(OnFastScrollStateChangeListener onFastScrollStateChangeListener) {
        this.l = onFastScrollStateChangeListener;
    }

    public void setPopUpTypeface(Typeface typeface) {
        FastScrollPopup fastScrollPopup = this.c.b;
        fastScrollPopup.m.setTypeface(typeface);
        fastScrollPopup.f631a.invalidate(fastScrollPopup.k);
    }

    public void setPopupBgColor(@ColorInt int i2) {
        FastScrollPopup fastScrollPopup = this.c.b;
        fastScrollPopup.h = i2;
        fastScrollPopup.g.setColor(i2);
        fastScrollPopup.f631a.invalidate(fastScrollPopup.k);
    }

    public void setPopupPosition(@FastScroller.PopupPosition int i2) {
        this.c.b.s = i2;
    }

    public void setPopupTextColor(@ColorInt int i2) {
        FastScrollPopup fastScrollPopup = this.c.b;
        fastScrollPopup.m.setColor(i2);
        fastScrollPopup.f631a.invalidate(fastScrollPopup.k);
    }

    public void setPopupTextSize(int i2) {
        FastScrollPopup fastScrollPopup = this.c.b;
        fastScrollPopup.m.setTextSize((float) i2);
        fastScrollPopup.f631a.invalidate(fastScrollPopup.k);
    }

    @Deprecated
    public void setStateChangeListener(OnFastScrollStateChangeListener onFastScrollStateChangeListener) {
        setOnFastScrollStateChangeListener(onFastScrollStateChangeListener);
    }

    public void setThumbColor(@ColorInt int i2) {
        FastScroller fastScroller = this.c;
        fastScroller.u = i2;
        fastScroller.e.setColor(i2);
        fastScroller.f634a.invalidate(fastScroller.i);
    }

    @Deprecated
    public void setThumbEnabled(boolean z) {
        setFastScrollEnabled(z);
    }

    public void setThumbInactiveColor(@ColorInt int i2) {
        FastScroller fastScroller = this.c;
        fastScroller.v = i2;
        fastScroller.w = true;
        fastScroller.e.setColor(i2);
    }

    public void setTrackColor(@ColorInt int i2) {
        FastScroller fastScroller = this.c;
        fastScroller.f.setColor(i2);
        fastScroller.f634a.invalidate(fastScroller.i);
    }

    public FastScrollRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r0v0, types: [com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView$ScrollPositionState, java.lang.Object] */
    public FastScrollRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = true;
        this.e = new Object();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FastScrollRecyclerView, 0, 0);
        try {
            this.d = obtainStyledAttributes.getBoolean(R.styleable.FastScrollRecyclerView_fastScrollThumbEnabled, true);
            obtainStyledAttributes.recycle();
            this.c = new FastScroller(context, this, attributeSet);
            this.k = new ScrollOffsetInvalidator();
            this.j = new SparseIntArray();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Deprecated
    public void setThumbInactiveColor(boolean z) {
        FastScroller fastScroller = this.c;
        fastScroller.w = z;
        fastScroller.e.setColor(z ? fastScroller.v : fastScroller.u);
    }
}
