package com.ktakilat.loan.weiget.gesture;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.pendanaan.kta.R;
import java.util.ArrayList;
import java.util.Iterator;

public class PatternLockerView extends View {
    public boolean c;
    public final boolean d;
    public final boolean e;
    public final int f;
    public final DefaultLockerLinkedLineView g;
    public final DefaultLockerNormalCellView i;
    public final DefaultLockerHitCellView j;
    public boolean k;
    public float l;
    public float m;
    public int n;
    public boolean o;
    public OnPatternChangeListener p;
    public final ArrayList q;
    public final TimeRunnable r;
    public ArrayList s;

    public class TimeRunnable implements Runnable {
        public TimeRunnable() {
        }

        public final void run() {
            PatternLockerView patternLockerView = PatternLockerView.this;
            patternLockerView.o = true;
            patternLockerView.a();
            patternLockerView.k = false;
            patternLockerView.invalidate();
        }
    }

    public PatternLockerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a() {
        ArrayList arrayList = this.q;
        if (arrayList.size() > 0) {
            arrayList.clear();
            this.n = 0;
            Iterator it = this.s.iterator();
            while (it.hasNext()) {
                ((CellBean) it.next()).g = false;
            }
        }
    }

    public final void b(MotionEvent motionEvent) {
        Iterator it = this.s.iterator();
        while (it.hasNext()) {
            CellBean cellBean = (CellBean) it.next();
            if (!cellBean.g) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f2 = cellBean.d - x;
                float f3 = cellBean.e - y;
                if (Math.sqrt((double) ((f3 * f3) + (f2 * f2))) <= ((double) cellBean.f)) {
                    boolean z = this.d;
                    ArrayList arrayList = this.q;
                    int i2 = cellBean.f606a;
                    if (!z && arrayList.size() > 0) {
                        CellBean cellBean2 = (CellBean) this.s.get(((Integer) arrayList.get(arrayList.size() - 1)).intValue());
                        int i3 = (cellBean2.f606a + i2) / 2;
                        if (!arrayList.contains(Integer.valueOf(i3)) && Math.abs(cellBean2.b - cellBean.b) % 2 == 0 && Math.abs(cellBean2.c - cellBean.c) % 2 == 0) {
                            ((CellBean) this.s.get(i3)).g = true;
                            arrayList.add(Integer.valueOf(i3));
                        }
                    }
                    cellBean.g = true;
                    arrayList.add(Integer.valueOf(i2));
                    if (this.e) {
                        performHapticFeedback(1, 1);
                    }
                }
            }
        }
    }

    public final void onDetachedFromWindow() {
        setOnPatternChangedListener((OnPatternChangeListener) null);
        removeCallbacks(this.r);
        super.onDetachedFromWindow();
    }

    public final void onDraw(Canvas canvas) {
        int i2;
        DefaultLockerHitCellView defaultLockerHitCellView;
        int i3;
        super.onDraw(canvas);
        if (this.s == null) {
            this.s = CellFactory.a((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        }
        Iterator it = this.s.iterator();
        while (it.hasNext()) {
            CellBean cellBean = (CellBean) it.next();
            boolean z = cellBean.g;
            float f2 = cellBean.e;
            float f3 = cellBean.f;
            float f4 = cellBean.d;
            if (!z || (defaultLockerHitCellView = this.j) == null) {
                DefaultLockerNormalCellView defaultLockerNormalCellView = this.i;
                defaultLockerNormalCellView.getClass();
                int save = canvas.save();
                Paint paint = defaultLockerNormalCellView.b;
                DefaultStyleDecorator defaultStyleDecorator = defaultLockerNormalCellView.c;
                paint.setColor(defaultStyleDecorator.f613a);
                float f5 = defaultStyleDecorator.f;
                paint.setStrokeWidth(f5 / 2.0f);
                float f6 = f3 / 4.0f;
                canvas.drawCircle(f4, f2, f6, paint);
                Paint paint2 = defaultLockerNormalCellView.f612a;
                paint2.setColor(defaultStyleDecorator.b);
                canvas.drawCircle(f4, f2, f6 - (f5 / 4.0f), paint2);
                canvas.restoreToCount(save);
            } else {
                boolean z2 = this.k;
                int save2 = canvas.save();
                Paint paint3 = defaultLockerHitCellView.b;
                DefaultStyleDecorator defaultStyleDecorator2 = defaultLockerHitCellView.c;
                paint3.setColor(defaultStyleDecorator2.d);
                canvas.drawCircle(f4, f2, f3 / 2.0f, paint3);
                Paint paint4 = defaultLockerHitCellView.f610a;
                if (z2) {
                    i3 = defaultStyleDecorator2.e;
                } else {
                    i3 = defaultStyleDecorator2.c;
                }
                paint4.setColor(i3);
                canvas.drawCircle(f4, f2, f3 / 4.0f, paint4);
                canvas.restoreToCount(save2);
            }
        }
        ArrayList arrayList = this.q;
        if (arrayList.size() > 0) {
            DefaultLockerLinkedLineView defaultLockerLinkedLineView = this.g;
            ArrayList arrayList2 = this.s;
            float f7 = this.l;
            float f8 = this.m;
            boolean z3 = this.k;
            defaultLockerLinkedLineView.getClass();
            if (!arrayList.isEmpty() && !arrayList2.isEmpty()) {
                int save3 = canvas.save();
                Path path = new Path();
                boolean z4 = true;
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    Integer num = (Integer) arrayList.get(i4);
                    if (num.intValue() >= 0 && num.intValue() < arrayList2.size()) {
                        CellBean cellBean2 = (CellBean) arrayList2.get(num.intValue());
                        if (z4) {
                            path.reset();
                            path.moveTo(cellBean2.d, cellBean2.e);
                            z4 = false;
                        } else {
                            path.lineTo(cellBean2.d, cellBean2.e);
                        }
                    }
                }
                if (!(f7 == 0.0f && f8 == 0.0f) && arrayList.size() < 9) {
                    path.lineTo(f7, f8);
                }
                Paint paint5 = defaultLockerLinkedLineView.f611a;
                DefaultStyleDecorator defaultStyleDecorator3 = defaultLockerLinkedLineView.b;
                if (z3) {
                    i2 = defaultStyleDecorator3.e;
                } else {
                    i2 = defaultStyleDecorator3.c;
                }
                paint5.setColor(i2);
                paint5.setStrokeWidth(defaultStyleDecorator3.f);
                canvas.drawPath(path, paint5);
                canvas.restoreToCount(save3);
            }
        }
    }

    public final void onMeasure(int i2, int i3) {
        int min = Math.min(i2, i3);
        super.onMeasure(min, min);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.o
            if (r0 != 0) goto L_0x0009
            boolean r6 = super.onTouchEvent(r6)
            return r6
        L_0x0009:
            int r0 = r6.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x0058
            java.util.ArrayList r2 = r5.q
            r3 = 0
            if (r0 == r1) goto L_0x0034
            r4 = 2
            if (r0 == r4) goto L_0x0019
            goto L_0x0066
        L_0x0019:
            r5.b(r6)
            float r0 = r6.getX()
            r5.l = r0
            float r0 = r6.getY()
            r5.m = r0
            int r0 = r2.size()
            int r2 = r5.n
            if (r2 == r0) goto L_0x0032
            r5.n = r0
        L_0x0032:
            r3 = 1
            goto L_0x0066
        L_0x0034:
            r5.b(r6)
            r0 = 0
            r5.l = r0
            r5.m = r0
            com.ktakilat.loan.weiget.gesture.OnPatternChangeListener r0 = r5.p
            if (r0 == 0) goto L_0x0043
            r0.a(r2)
        L_0x0043:
            boolean r0 = r5.c
            if (r0 == 0) goto L_0x0032
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x0032
            r5.o = r3
            com.ktakilat.loan.weiget.gesture.PatternLockerView$TimeRunnable r0 = r5.r
            int r2 = r5.f
            long r2 = (long) r2
            r5.postDelayed(r0, r2)
            goto L_0x0032
        L_0x0058:
            r5.a()
            r5.b(r6)
            com.ktakilat.loan.weiget.gesture.OnPatternChangeListener r0 = r5.p
            if (r0 == 0) goto L_0x0032
            r0.onStart()
            goto L_0x0032
        L_0x0066:
            r5.invalidate()
            if (r3 == 0) goto L_0x006c
            return r1
        L_0x006c:
            boolean r6 = super.onTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.weiget.gesture.PatternLockerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setEnableAutoClean(boolean z) {
        this.c = z;
    }

    public void setOnPatternChangedListener(OnPatternChangeListener onPatternChangeListener) {
        this.p = onPatternChangeListener;
    }

    public PatternLockerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: type inference failed for: r12v2, types: [com.ktakilat.loan.weiget.gesture.DefaultLockerNormalCellView, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r12v3, types: [com.ktakilat.loan.weiget.gesture.DefaultLockerHitCellView, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r12v4, types: [java.lang.Object, com.ktakilat.loan.weiget.gesture.DefaultLockerLinkedLineView] */
    public PatternLockerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = 0;
        this.g = null;
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0;
        this.o = true;
        this.p = null;
        ArrayList arrayList = new ArrayList();
        this.q = arrayList;
        arrayList.clear();
        this.r = new TimeRunnable();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PatternLockerView, i2, 0);
        int color = obtainStyledAttributes.getColor(0, DefaultConfig.f607a);
        int i3 = DefaultConfig.b;
        int color2 = obtainStyledAttributes.getColor(7, i3);
        int color3 = obtainStyledAttributes.getColor(8, i3);
        int color4 = obtainStyledAttributes.getColor(4, DefaultConfig.c);
        int color5 = obtainStyledAttributes.getColor(5, DefaultConfig.d);
        float dimension = obtainStyledAttributes.getDimension(9, TypedValue.applyDimension(1, (float) 1, context.getResources().getDisplayMetrics()));
        this.f = obtainStyledAttributes.getInteger(6, 1000);
        this.c = obtainStyledAttributes.getBoolean(1, true);
        this.e = obtainStyledAttributes.getBoolean(2, false);
        this.d = obtainStyledAttributes.getBoolean(3, false);
        obtainStyledAttributes.recycle();
        DefaultStyleDecorator defaultStyleDecorator = new DefaultStyleDecorator(color, color5, color2, color3, color4, dimension);
        ? obj = new Object();
        Paint a2 = DefaultConfig.a();
        obj.f612a = a2;
        Paint.Style style = Paint.Style.FILL;
        a2.setStyle(style);
        Paint a3 = DefaultConfig.a();
        obj.b = a3;
        Paint.Style style2 = Paint.Style.STROKE;
        a3.setStyle(style2);
        obj.c = defaultStyleDecorator;
        this.i = obj;
        ? obj2 = new Object();
        Paint a4 = DefaultConfig.a();
        obj2.f610a = a4;
        a4.setStyle(style);
        Paint a5 = DefaultConfig.a();
        obj2.b = a5;
        a5.setStyle(style);
        obj2.c = defaultStyleDecorator;
        this.j = obj2;
        ? obj3 = new Object();
        Paint a6 = DefaultConfig.a();
        obj3.f611a = a6;
        a6.setStyle(style2);
        obj3.b = defaultStyleDecorator;
        this.g = obj3;
    }
}
