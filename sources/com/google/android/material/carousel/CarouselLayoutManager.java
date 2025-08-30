package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 0;
    private static final String TAG = "CarouselLayoutManager";
    public static final int VERTICAL = 1;
    @NonNull
    private CarouselStrategy carouselStrategy;
    private int currentFillStartPosition;
    @Nullable
    private KeylineState currentKeylineState;
    private final DebugItemDecoration debugItemDecoration;
    private boolean isDebuggingEnabled;
    /* access modifiers changed from: private */
    @Nullable
    public KeylineStateList keylineStateList;
    @Nullable
    private Map<Integer, KeylineState> keylineStatePositionMap;
    @VisibleForTesting
    int maxScroll;
    @VisibleForTesting
    int minScroll;
    private CarouselOrientationHelper orientationHelper;
    @VisibleForTesting
    int scrollOffset;

    public static final class ChildCalculations {
        final float center;
        final View child;
        final float offsetCenter;
        final KeylineRange range;

        public ChildCalculations(View view, float f, float f2, KeylineRange keylineRange) {
            this.child = view;
            this.center = f;
            this.offsetCenter = f2;
            this.range = keylineRange;
        }
    }

    public static class DebugItemDecoration extends RecyclerView.ItemDecoration {
        private List<KeylineState.Keyline> keylines = Collections.unmodifiableList(new ArrayList());
        private final Paint linePaint;

        public DebugItemDecoration() {
            Paint paint = new Paint();
            this.linePaint = paint;
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.onDrawOver(canvas, recyclerView, state);
            this.linePaint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            for (KeylineState.Keyline next : this.keylines) {
                this.linePaint.setColor(ColorUtils.blendARGB(-65281, -16776961, next.mask));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).isHorizontal()) {
                    canvas.drawLine(next.locOffset, (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentTop(), next.locOffset, (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentBottom(), this.linePaint);
                } else {
                    canvas.drawLine((float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentLeft(), next.locOffset, (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentRight(), next.locOffset, this.linePaint);
                }
            }
        }

        public void setKeylines(List<KeylineState.Keyline> list) {
            this.keylines = Collections.unmodifiableList(list);
        }
    }

    public static class KeylineRange {
        final KeylineState.Keyline leftOrTop;
        final KeylineState.Keyline rightOrBottom;

        public KeylineRange(KeylineState.Keyline keyline, KeylineState.Keyline keyline2) {
            boolean z;
            if (keyline.loc <= keyline2.loc) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.leftOrTop = keyline;
            this.rightOrBottom = keyline2;
        }
    }

    public CarouselLayoutManager() {
        this(new MultiBrowseCarouselStrategy());
    }

    private void addAndLayoutView(View view, int i, ChildCalculations childCalculations) {
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        addView(view, i);
        float f = childCalculations.offsetCenter;
        this.orientationHelper.layoutDecoratedWithMargins(view, (int) (f - itemSize), (int) (f + itemSize));
        updateChildMaskForLocation(view, childCalculations.center, childCalculations.range);
    }

    private int addEnd(int i, int i2) {
        if (isLayoutRtl()) {
            return i - i2;
        }
        return i + i2;
    }

    private int addStart(int i, int i2) {
        if (isLayoutRtl()) {
            return i + i2;
        }
        return i - i2;
    }

    private void addViewsEnd(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        int calculateChildStartForFill = calculateChildStartForFill(i);
        while (i < state.getItemCount()) {
            ChildCalculations makeChildCalculations = makeChildCalculations(recycler, (float) calculateChildStartForFill, i);
            if (!isLocOffsetOutOfFillBoundsEnd(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                calculateChildStartForFill = addEnd(calculateChildStartForFill, (int) this.currentKeylineState.getItemSize());
                if (!isLocOffsetOutOfFillBoundsStart(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                    addAndLayoutView(makeChildCalculations.child, -1, makeChildCalculations);
                }
                i++;
            } else {
                return;
            }
        }
    }

    private void addViewsStart(RecyclerView.Recycler recycler, int i) {
        int calculateChildStartForFill = calculateChildStartForFill(i);
        while (i >= 0) {
            ChildCalculations makeChildCalculations = makeChildCalculations(recycler, (float) calculateChildStartForFill, i);
            if (!isLocOffsetOutOfFillBoundsStart(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                calculateChildStartForFill = addStart(calculateChildStartForFill, (int) this.currentKeylineState.getItemSize());
                if (!isLocOffsetOutOfFillBoundsEnd(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                    addAndLayoutView(makeChildCalculations.child, 0, makeChildCalculations);
                }
                i--;
            } else {
                return;
            }
        }
    }

    private float calculateChildOffsetCenterForLocation(View view, float f, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.leftOrTop;
        float f2 = keyline.locOffset;
        KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
        float lerp = AnimationUtils.lerp(f2, keyline2.locOffset, keyline.loc, keyline2.loc, f);
        if (keylineRange.rightOrBottom != this.currentKeylineState.getFirstKeyline() && keylineRange.leftOrTop != this.currentKeylineState.getLastKeyline()) {
            return lerp;
        }
        float maskMargins = this.orientationHelper.getMaskMargins((RecyclerView.LayoutParams) view.getLayoutParams()) / this.currentKeylineState.getItemSize();
        KeylineState.Keyline keyline3 = keylineRange.rightOrBottom;
        return lerp + (((1.0f - keyline3.mask) + maskMargins) * (f - keyline3.loc));
    }

    private int calculateChildStartForFill(int i) {
        return addEnd((int) ((float) (getParentStart() - this.scrollOffset)), (int) (this.currentKeylineState.getItemSize() * ((float) i)));
    }

    private int calculateEndScroll(RecyclerView.State state, KeylineStateList keylineStateList2) {
        KeylineState keylineState;
        KeylineState.Keyline keyline;
        float f;
        boolean isLayoutRtl = isLayoutRtl();
        if (isLayoutRtl) {
            keylineState = keylineStateList2.getStartState();
        } else {
            keylineState = keylineStateList2.getEndState();
        }
        if (isLayoutRtl) {
            keyline = keylineState.getFirstFocalKeyline();
        } else {
            keyline = keylineState.getLastFocalKeyline();
        }
        float itemCount = (((float) (state.getItemCount() - 1)) * keylineState.getItemSize()) + ((float) getPaddingEnd());
        if (isLayoutRtl) {
            f = -1.0f;
        } else {
            f = 1.0f;
        }
        float f2 = itemCount * f;
        float parentStart = keyline.loc - ((float) getParentStart());
        float parentEnd = ((float) getParentEnd()) - keyline.loc;
        if (Math.abs(parentStart) > Math.abs(f2)) {
            return 0;
        }
        return (int) ((f2 - parentStart) + parentEnd);
    }

    private static int calculateShouldScrollBy(int i, int i2, int i3, int i4) {
        int i5 = i2 + i;
        return i5 < i3 ? i3 - i2 : i5 > i4 ? i4 - i2 : i;
    }

    private int calculateStartScroll(KeylineStateList keylineStateList2) {
        KeylineState keylineState;
        KeylineState.Keyline keyline;
        int i;
        boolean isLayoutRtl = isLayoutRtl();
        if (isLayoutRtl) {
            keylineState = keylineStateList2.getEndState();
        } else {
            keylineState = keylineStateList2.getStartState();
        }
        if (isLayoutRtl) {
            keyline = keylineState.getLastFocalKeyline();
        } else {
            keyline = keylineState.getFirstFocalKeyline();
        }
        int paddingStart = getPaddingStart();
        if (isLayoutRtl) {
            i = 1;
        } else {
            i = -1;
        }
        return (int) ((((float) (paddingStart * i)) + ((float) getParentStart())) - ((float) addStart((int) keyline.loc, (int) (keylineState.getItemSize() / 2.0f))));
    }

    private void fill(RecyclerView.Recycler recycler, RecyclerView.State state) {
        removeAndRecycleOutOfBoundsViews(recycler);
        if (getChildCount() == 0) {
            addViewsStart(recycler, this.currentFillStartPosition - 1);
            addViewsEnd(recycler, state, this.currentFillStartPosition);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            addViewsStart(recycler, position - 1);
            addViewsEnd(recycler, state, position2 + 1);
        }
        validateChildOrderIfDebugging();
    }

    private int getContainerSize() {
        if (isHorizontal()) {
            return getContainerWidth();
        }
        return getContainerHeight();
    }

    private float getDecoratedCenterXWithMargins(View view) {
        Rect rect = new Rect();
        super.getDecoratedBoundsWithMargins(view, rect);
        return (float) rect.centerX();
    }

    private KeylineState getKeylineStateForPosition(int i) {
        KeylineState keylineState;
        Map<Integer, KeylineState> map = this.keylineStatePositionMap;
        if (map == null || (keylineState = map.get(Integer.valueOf(MathUtils.clamp(i, 0, Math.max(0, getItemCount() - 1))))) == null) {
            return this.keylineStateList.getDefaultState();
        }
        return keylineState;
    }

    private float getMaskedItemSizeForLocOffset(float f, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.leftOrTop;
        float f2 = keyline.maskedItemSize;
        KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
        return AnimationUtils.lerp(f2, keyline2.maskedItemSize, keyline.locOffset, keyline2.locOffset, f);
    }

    /* access modifiers changed from: private */
    public int getParentBottom() {
        return this.orientationHelper.getParentBottom();
    }

    private int getParentEnd() {
        return this.orientationHelper.getParentEnd();
    }

    /* access modifiers changed from: private */
    public int getParentLeft() {
        return this.orientationHelper.getParentLeft();
    }

    /* access modifiers changed from: private */
    public int getParentRight() {
        return this.orientationHelper.getParentRight();
    }

    private int getParentStart() {
        return this.orientationHelper.getParentStart();
    }

    /* access modifiers changed from: private */
    public int getParentTop() {
        return this.orientationHelper.getParentTop();
    }

    private int getScrollOffsetForPosition(int i, KeylineState keylineState) {
        if (isLayoutRtl()) {
            return (int) (((((float) getContainerSize()) - keylineState.getLastFocalKeyline().loc) - (((float) i) * keylineState.getItemSize())) - (keylineState.getItemSize() / 2.0f));
        }
        return (int) ((keylineState.getItemSize() / 2.0f) + ((((float) i) * keylineState.getItemSize()) - keylineState.getFirstFocalKeyline().loc));
    }

    private static KeylineRange getSurroundingKeylineRange(List<KeylineState.Keyline> list, float f, boolean z) {
        float f2;
        float f3 = Float.MAX_VALUE;
        float f4 = Float.MAX_VALUE;
        float f5 = Float.MAX_VALUE;
        float f6 = -3.4028235E38f;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < list.size(); i5++) {
            KeylineState.Keyline keyline = list.get(i5);
            if (z) {
                f2 = keyline.locOffset;
            } else {
                f2 = keyline.loc;
            }
            float abs = Math.abs(f2 - f);
            if (f2 <= f && abs <= f3) {
                i = i5;
                f3 = abs;
            }
            if (f2 > f && abs <= f4) {
                i3 = i5;
                f4 = abs;
            }
            if (f2 <= f5) {
                i2 = i5;
                f5 = f2;
            }
            if (f2 > f6) {
                i4 = i5;
                f6 = f2;
            }
        }
        if (i == -1) {
            i = i2;
        }
        if (i3 == -1) {
            i3 = i4;
        }
        return new KeylineRange(list.get(i), list.get(i3));
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0017 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isLocOffsetOutOfFillBoundsEnd(float r3, com.google.android.material.carousel.CarouselLayoutManager.KeylineRange r4) {
        /*
            r2 = this;
            float r4 = r2.getMaskedItemSizeForLocOffset(r3, r4)
            int r3 = (int) r3
            r0 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r0
            int r4 = (int) r4
            int r3 = r2.addStart(r3, r4)
            boolean r4 = r2.isLayoutRtl()
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L_0x0019
            if (r3 >= 0) goto L_0x0020
        L_0x0017:
            r0 = 1
            goto L_0x0020
        L_0x0019:
            int r4 = r2.getContainerSize()
            if (r3 <= r4) goto L_0x0020
            goto L_0x0017
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.isLocOffsetOutOfFillBoundsEnd(float, com.google.android.material.carousel.CarouselLayoutManager$KeylineRange):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001b A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isLocOffsetOutOfFillBoundsStart(float r3, com.google.android.material.carousel.CarouselLayoutManager.KeylineRange r4) {
        /*
            r2 = this;
            float r4 = r2.getMaskedItemSizeForLocOffset(r3, r4)
            int r3 = (int) r3
            r0 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r0
            int r4 = (int) r4
            int r3 = r2.addEnd(r3, r4)
            boolean r4 = r2.isLayoutRtl()
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L_0x001d
            int r4 = r2.getContainerSize()
            if (r3 <= r4) goto L_0x0020
        L_0x001b:
            r0 = 1
            goto L_0x0020
        L_0x001d:
            if (r3 >= 0) goto L_0x0020
            goto L_0x001b
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.isLocOffsetOutOfFillBoundsStart(float, com.google.android.material.carousel.CarouselLayoutManager$KeylineRange):boolean");
    }

    private void logChildrenIfDebugging() {
        if (this.isDebuggingEnabled && Log.isLoggable(TAG, 3)) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                getDecoratedCenterXWithMargins(childAt);
                getPosition(childAt);
            }
        }
    }

    private ChildCalculations makeChildCalculations(RecyclerView.Recycler recycler, float f, int i) {
        View viewForPosition = recycler.getViewForPosition(i);
        measureChildWithMargins(viewForPosition, 0, 0);
        float addEnd = (float) addEnd((int) f, (int) (this.currentKeylineState.getItemSize() / 2.0f));
        KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), addEnd, false);
        return new ChildCalculations(viewForPosition, addEnd, calculateChildOffsetCenterForLocation(viewForPosition, addEnd, surroundingKeylineRange), surroundingKeylineRange);
    }

    private void offsetChild(View view, float f, float f2, Rect rect) {
        float addEnd = (float) addEnd((int) f, (int) f2);
        KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), addEnd, false);
        float calculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(view, addEnd, surroundingKeylineRange);
        super.getDecoratedBoundsWithMargins(view, rect);
        updateChildMaskForLocation(view, addEnd, surroundingKeylineRange);
        this.orientationHelper.offsetChild(view, rect, f2, calculateChildOffsetCenterForLocation);
    }

    private void refreshKeylineState() {
        this.keylineStateList = null;
        requestLayout();
    }

    private void removeAndRecycleOutOfBoundsViews(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float decoratedCenterXWithMargins = getDecoratedCenterXWithMargins(childAt);
            if (!isLocOffsetOutOfFillBoundsStart(decoratedCenterXWithMargins, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), decoratedCenterXWithMargins, true))) {
                break;
            }
            removeAndRecycleView(childAt, recycler);
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float decoratedCenterXWithMargins2 = getDecoratedCenterXWithMargins(childAt2);
            if (isLocOffsetOutOfFillBoundsEnd(decoratedCenterXWithMargins2, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), decoratedCenterXWithMargins2, true))) {
                removeAndRecycleView(childAt2, recycler);
            } else {
                return;
            }
        }
    }

    private int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        int calculateShouldScrollBy = calculateShouldScrollBy(i, this.scrollOffset, this.minScroll, this.maxScroll);
        this.scrollOffset += calculateShouldScrollBy;
        updateCurrentKeylineStateForScrollOffset();
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        int calculateChildStartForFill = calculateChildStartForFill(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            offsetChild(getChildAt(i2), (float) calculateChildStartForFill, itemSize, rect);
            calculateChildStartForFill = addEnd(calculateChildStartForFill, (int) this.currentKeylineState.getItemSize());
        }
        fill(recycler, state);
        return calculateShouldScrollBy;
    }

    private void updateChildMaskForLocation(View view, float f, KeylineRange keylineRange) {
        if (view instanceof Maskable) {
            KeylineState.Keyline keyline = keylineRange.leftOrTop;
            float f2 = keyline.mask;
            KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
            float lerp = AnimationUtils.lerp(f2, keyline2.mask, keyline.loc, keyline2.loc, f);
            float height = (float) view.getHeight();
            float width = (float) view.getWidth();
            float lerp2 = AnimationUtils.lerp(0.0f, width / 2.0f, 0.0f, 1.0f, lerp);
            RectF maskRect = this.orientationHelper.getMaskRect(height, width, AnimationUtils.lerp(0.0f, height / 2.0f, 0.0f, 1.0f, lerp), lerp2);
            float calculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(view, f, keylineRange);
            RectF rectF = new RectF(calculateChildOffsetCenterForLocation - (maskRect.width() / 2.0f), calculateChildOffsetCenterForLocation - (maskRect.height() / 2.0f), (maskRect.width() / 2.0f) + calculateChildOffsetCenterForLocation, (maskRect.height() / 2.0f) + calculateChildOffsetCenterForLocation);
            RectF rectF2 = new RectF((float) getParentLeft(), (float) getParentTop(), (float) getParentRight(), (float) getParentBottom());
            if (this.carouselStrategy.isContained()) {
                this.orientationHelper.containMaskWithinBounds(maskRect, rectF, rectF2);
            }
            this.orientationHelper.moveMaskOnEdgeOutsideBounds(maskRect, rectF, rectF2);
            ((Maskable) view).setMaskRectF(maskRect);
        }
    }

    private void updateCurrentKeylineStateForScrollOffset() {
        KeylineState keylineState;
        int i = this.maxScroll;
        int i2 = this.minScroll;
        if (i <= i2) {
            if (isLayoutRtl()) {
                keylineState = this.keylineStateList.getEndState();
            } else {
                keylineState = this.keylineStateList.getStartState();
            }
            this.currentKeylineState = keylineState;
        } else {
            this.currentKeylineState = this.keylineStateList.getShiftedState((float) this.scrollOffset, (float) i2, (float) i);
        }
        this.debugItemDecoration.setKeylines(this.currentKeylineState.getKeylines());
    }

    private void validateChildOrderIfDebugging() {
        if (this.isDebuggingEnabled && getChildCount() >= 1) {
            int i = 0;
            while (i < getChildCount() - 1) {
                int position = getPosition(getChildAt(i));
                int i2 = i + 1;
                int position2 = getPosition(getChildAt(i2));
                if (position <= position2) {
                    i = i2;
                } else {
                    logChildrenIfDebugging();
                    StringBuilder r = e.r(i, "Detected invalid child order. Child at index [", position, "] had adapter position [", "] and child at index [");
                    r.append(i2);
                    r.append("] had adapter position [");
                    r.append(position2);
                    r.append("].");
                    throw new IllegalStateException(r.toString());
                }
            }
        }
    }

    public int calculateScrollDeltaToMakePositionVisible(int i) {
        return (int) (((float) this.scrollOffset) - ((float) getScrollOffsetForPosition(i, getKeylineStateForPosition(i))));
    }

    public boolean canScrollHorizontally() {
        return isHorizontal();
    }

    public boolean canScrollVertically() {
        return !isHorizontal();
    }

    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        return (int) this.keylineStateList.getDefaultState().getItemSize();
    }

    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return this.scrollOffset;
    }

    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return this.maxScroll - this.minScroll;
    }

    @Nullable
    public PointF computeScrollVectorForPosition(int i) {
        if (this.keylineStateList == null) {
            return null;
        }
        int offsetToScrollToPosition = getOffsetToScrollToPosition(i, getKeylineStateForPosition(i));
        if (isHorizontal()) {
            return new PointF((float) offsetToScrollToPosition, 0.0f);
        }
        return new PointF(0.0f, (float) offsetToScrollToPosition);
    }

    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        return (int) this.keylineStateList.getDefaultState().getItemSize();
    }

    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return this.scrollOffset;
    }

    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return this.maxScroll - this.minScroll;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getContainerHeight() {
        return getHeight();
    }

    public int getContainerWidth() {
        return getWidth();
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float centerX = (float) rect.centerX();
        float width = (((float) rect.width()) - getMaskedItemSizeForLocOffset(centerX, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), centerX, true))) / 2.0f;
        rect.set((int) (((float) rect.left) + width), rect.top, (int) (((float) rect.right) - width), rect.bottom);
    }

    public int getOffsetToScrollToPosition(int i, @NonNull KeylineState keylineState) {
        return getScrollOffsetForPosition(i, keylineState) - this.scrollOffset;
    }

    public int getOffsetToScrollToPositionForSnap(int i, boolean z) {
        int i2;
        int offsetToScrollToPosition = getOffsetToScrollToPosition(i, this.keylineStateList.getShiftedState((float) this.scrollOffset, (float) this.minScroll, (float) this.maxScroll, true));
        if (this.keylineStatePositionMap != null) {
            i2 = getOffsetToScrollToPosition(i, getKeylineStateForPosition(i));
        } else {
            i2 = offsetToScrollToPosition;
        }
        if (!z || Math.abs(i2) >= Math.abs(offsetToScrollToPosition)) {
            return offsetToScrollToPosition;
        }
        return i2;
    }

    public int getOrientation() {
        return this.orientationHelper.orientation;
    }

    public boolean isHorizontal() {
        if (this.orientationHelper.orientation == 0) {
            return true;
        }
        return false;
    }

    public boolean isLayoutRtl() {
        if (!isHorizontal() || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    public void measureChildWithMargins(@NonNull View view, int i, int i2) {
        float f;
        float f2;
        if (view instanceof Maskable) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            Rect rect = new Rect();
            calculateItemDecorationsForChild(view, rect);
            int i3 = rect.left + rect.right + i;
            int i4 = rect.top + rect.bottom + i2;
            KeylineStateList keylineStateList2 = this.keylineStateList;
            if (keylineStateList2 == null || this.orientationHelper.orientation != 0) {
                f = (float) layoutParams.width;
            } else {
                f = keylineStateList2.getDefaultState().getItemSize();
            }
            KeylineStateList keylineStateList3 = this.keylineStateList;
            if (keylineStateList3 == null || this.orientationHelper.orientation != 1) {
                f2 = (float) layoutParams.height;
            } else {
                f2 = keylineStateList3.getDefaultState().getItemSize();
            }
            view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin + i3, (int) f, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin + i4, (int) f2, canScrollVertically()));
            return;
        }
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z;
        int i;
        if (state.getItemCount() <= 0) {
            removeAndRecycleAllViews(recycler);
            this.currentFillStartPosition = 0;
            return;
        }
        boolean isLayoutRtl = isLayoutRtl();
        if (this.keylineStateList == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            View viewForPosition = recycler.getViewForPosition(0);
            measureChildWithMargins(viewForPosition, 0, 0);
            KeylineState onFirstChildMeasuredWithMargins = this.carouselStrategy.onFirstChildMeasuredWithMargins(this, viewForPosition);
            if (isLayoutRtl) {
                onFirstChildMeasuredWithMargins = KeylineState.reverse(onFirstChildMeasuredWithMargins);
            }
            this.keylineStateList = KeylineStateList.from(this, onFirstChildMeasuredWithMargins);
        }
        int calculateStartScroll = calculateStartScroll(this.keylineStateList);
        int calculateEndScroll = calculateEndScroll(state, this.keylineStateList);
        if (isLayoutRtl) {
            i = calculateEndScroll;
        } else {
            i = calculateStartScroll;
        }
        this.minScroll = i;
        if (isLayoutRtl) {
            calculateEndScroll = calculateStartScroll;
        }
        this.maxScroll = calculateEndScroll;
        if (z) {
            this.scrollOffset = calculateStartScroll;
            this.keylineStatePositionMap = this.keylineStateList.getKeylineStateForPositionMap(getItemCount(), this.minScroll, this.maxScroll, isLayoutRtl());
        } else {
            int i2 = this.scrollOffset;
            this.scrollOffset = i2 + calculateShouldScrollBy(0, i2, i, calculateEndScroll);
        }
        this.currentFillStartPosition = MathUtils.clamp(this.currentFillStartPosition, 0, state.getItemCount());
        updateCurrentKeylineStateForScrollOffset();
        detachAndScrapAttachedViews(recycler);
        fill(recycler, state);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.currentFillStartPosition = 0;
        } else {
            this.currentFillStartPosition = getPosition(getChildAt(0));
        }
        validateChildOrderIfDebugging();
    }

    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
        if (this.keylineStateList == null) {
            return false;
        }
        int offsetToScrollToPosition = getOffsetToScrollToPosition(getPosition(view), getKeylineStateForPosition(getPosition(view)));
        if (z2 || offsetToScrollToPosition == 0) {
            return false;
        }
        recyclerView.scrollBy(offsetToScrollToPosition, 0);
        return true;
    }

    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(i, recycler, state);
        }
        return 0;
    }

    public void scrollToPosition(int i) {
        if (this.keylineStateList != null) {
            this.scrollOffset = getScrollOffsetForPosition(i, getKeylineStateForPosition(i));
            this.currentFillStartPosition = MathUtils.clamp(i, 0, Math.max(0, getItemCount() - 1));
            updateCurrentKeylineStateForScrollOffset();
            requestLayout();
        }
    }

    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(i, recycler, state);
        }
        return 0;
    }

    public void setCarouselStrategy(@NonNull CarouselStrategy carouselStrategy2) {
        this.carouselStrategy = carouselStrategy2;
        refreshKeylineState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setDebuggingEnabled(@NonNull RecyclerView recyclerView, boolean z) {
        this.isDebuggingEnabled = z;
        recyclerView.removeItemDecoration(this.debugItemDecoration);
        if (z) {
            recyclerView.addItemDecoration(this.debugItemDecoration);
        }
        recyclerView.invalidateItemDecorations();
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll((String) null);
            CarouselOrientationHelper carouselOrientationHelper = this.orientationHelper;
            if (carouselOrientationHelper == null || i != carouselOrientationHelper.orientation) {
                this.orientationHelper = CarouselOrientationHelper.createOrientationHelper(this, i);
                refreshKeylineState();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(ba.k(i, "invalid orientation:"));
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        AnonymousClass1 r2 = new LinearSmoothScroller(recyclerView.getContext()) {
            public int calculateDxToMakeVisible(View view, int i) {
                if (CarouselLayoutManager.this.keylineStateList == null || !CarouselLayoutManager.this.isHorizontal()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.calculateScrollDeltaToMakePositionVisible(carouselLayoutManager.getPosition(view));
            }

            public int calculateDyToMakeVisible(View view, int i) {
                if (CarouselLayoutManager.this.keylineStateList == null || CarouselLayoutManager.this.isHorizontal()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.calculateScrollDeltaToMakePositionVisible(carouselLayoutManager.getPosition(view));
            }

            @Nullable
            public PointF computeScrollVectorForPosition(int i) {
                return CarouselLayoutManager.this.computeScrollVectorForPosition(i);
            }
        };
        r2.setTargetPosition(i);
        startSmoothScroll(r2);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy carouselStrategy2) {
        this(carouselStrategy2, 0);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy carouselStrategy2, int i) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        setCarouselStrategy(carouselStrategy2);
        setOrientation(i);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        setOrientation(RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2).orientation);
        setCarouselStrategy(new MultiBrowseCarouselStrategy());
    }
}
