package com.ktakilat.cbase.weight.circleprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.ktakilat.cbase.R;
import com.ktakilat.cbase.ui.LogActivity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class CircleProgressBar extends ProgressBar {
    public final RectF c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public float i;
    public float j;
    public float k;
    public int l;
    public int m;
    public float n;
    public float o;
    public float p;
    public int q;
    public int r;
    public int s;
    public int t;
    public String u;
    public int v;
    public int w;
    public Paint.Cap x;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShaderMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    public CircleProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a(Canvas canvas) {
        int i2 = this.v;
        RectF rectF = this.c;
        Paint paint = this.e;
        Paint paint2 = this.d;
        if (i2 == 1) {
            Canvas canvas2 = canvas;
            RectF rectF2 = rectF;
            canvas2.drawArc(rectF2, -90.0f, 360.0f, false, paint);
            canvas2.drawArc(rectF2, -90.0f, (((float) getProgress()) * 360.0f) / ((float) getMax()), true, paint2);
        } else if (i2 != 2) {
            float f2 = (float) (6.283185307179586d / ((double) this.m));
            float f3 = this.i;
            float f4 = f3 - this.n;
            int progress = (int) ((((float) getProgress()) / ((float) getMax())) * ((float) this.m));
            for (int i3 = 0; i3 < this.m; i3++) {
                double d2 = (double) (((float) i3) * f2);
                float sin = (((float) Math.sin(d2)) * f4) + this.j;
                float cos = this.j - (((float) Math.cos(d2)) * f4);
                float sin2 = (((float) Math.sin(d2)) * f3) + this.j;
                float cos2 = this.j - (((float) Math.cos(d2)) * f3);
                if (i3 < progress) {
                    canvas.drawLine(sin, cos, sin2, cos2, paint2);
                } else {
                    canvas.drawLine(sin, cos, sin2, cos2, paint);
                }
            }
        } else {
            Canvas canvas3 = canvas;
            RectF rectF3 = rectF;
            canvas3.drawArc(rectF3, -90.0f, 360.0f, false, paint);
            canvas3.drawArc(rectF3, -90.0f, (((float) getProgress()) * 360.0f) / ((float) getMax()), false, paint2);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r14v1, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: type inference failed for: r7v4, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r22 = this;
            r0 = r22
            r1 = 2
            int r2 = r0.q
            int r3 = r0.r
            r4 = 0
            android.graphics.Paint r5 = r0.d
            if (r2 == r3) goto L_0x009e
            int r2 = r0.w
            if (r2 == 0) goto L_0x007b
            r3 = 1
            if (r2 == r3) goto L_0x0068
            if (r2 == r1) goto L_0x0017
            goto L_0x009a
        L_0x0017:
            float r2 = r0.o
            double r2 = (double) r2
            r6 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r2 = r2 / r6
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = r2 * r6
            float r4 = r0.i
            double r6 = (double) r4
            double r2 = r2 / r6
            float r2 = (float) r2
            android.graphics.Paint$Cap r3 = r0.x
            android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.BUTT
            if (r3 != r4) goto L_0x0036
            int r3 = r0.v
            if (r3 != r1) goto L_0x0036
            r2 = 0
            goto L_0x003b
        L_0x0036:
            double r2 = (double) r2
            double r2 = java.lang.Math.toDegrees(r2)
        L_0x003b:
            r6 = -4587338432941916160(0xc056800000000000, double:-90.0)
            double r6 = r6 - r2
            float r2 = (float) r6
            android.graphics.SweepGradient r4 = new android.graphics.SweepGradient
            float r3 = r0.j
            float r6 = r0.k
            int r7 = r0.q
            int r8 = r0.r
            int[] r7 = new int[]{r7, r8}
            float[] r1 = new float[r1]
            r1 = {0, 1065353216} // fill-array
            r4.<init>(r3, r6, r7, r1)
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>()
            float r3 = r0.j
            float r6 = r0.k
            r1.postRotate(r2, r3, r6)
            r4.setLocalMatrix(r1)
            goto L_0x009a
        L_0x0068:
            android.graphics.RadialGradient r4 = new android.graphics.RadialGradient
            float r8 = r0.j
            float r9 = r0.k
            float r10 = r0.i
            int r11 = r0.q
            int r12 = r0.r
            android.graphics.Shader$TileMode r13 = android.graphics.Shader.TileMode.CLAMP
            r7 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13)
            goto L_0x009a
        L_0x007b:
            android.graphics.LinearGradient r4 = new android.graphics.LinearGradient
            android.graphics.RectF r1 = r0.c
            float r2 = r1.left
            float r3 = r1.top
            float r1 = r1.bottom
            int r6 = r0.q
            int r7 = r0.r
            android.graphics.Shader$TileMode r21 = android.graphics.Shader.TileMode.CLAMP
            r14 = r4
            r15 = r2
            r16 = r3
            r17 = r2
            r18 = r1
            r19 = r6
            r20 = r7
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
        L_0x009a:
            r5.setShader(r4)
            goto L_0x00a6
        L_0x009e:
            r5.setShader(r4)
            int r1 = r0.q
            r5.setColor(r1)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.weight.circleprogress.CircleProgressBar.b():void");
    }

    public int getBackgroundColor() {
        return this.l;
    }

    public Paint.Cap getCap() {
        return this.x;
    }

    public int getLineCount() {
        return this.m;
    }

    public float getLineWidth() {
        return this.n;
    }

    public int getProgressBackgroundColor() {
        return this.t;
    }

    public int getProgressEndColor() {
        return this.r;
    }

    public int getProgressStartColor() {
        return this.q;
    }

    public float getProgressStrokeWidth() {
        return this.o;
    }

    public int getProgressTextColor() {
        return this.s;
    }

    public String getProgressTextFormatPattern() {
        return this.u;
    }

    public float getProgressTextSize() {
        return this.p;
    }

    public int getShader() {
        return this.w;
    }

    public int getStyle() {
        return this.v;
    }

    public final synchronized void onDraw(Canvas canvas) {
        if (this.l != 0) {
            float f2 = this.j;
            canvas.drawCircle(f2, f2, this.i, this.f);
        }
        a(canvas);
    }

    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float f2 = (float) (i2 / 2);
        this.j = f2;
        float f3 = (float) (i3 / 2);
        this.k = f3;
        float min = Math.min(f2, f3);
        this.i = min;
        RectF rectF = this.c;
        float f4 = this.k;
        rectF.top = f4 - min;
        rectF.bottom = f4 + min;
        float f5 = this.j;
        rectF.left = f5 - min;
        rectF.right = f5 + min;
        b();
        float f6 = this.o;
        rectF.inset(f6 / 2.0f, f6 / 2.0f);
    }

    public void setBackgroundColor(int i2) {
        this.l = i2;
        this.f.setColor(i2);
        invalidate();
    }

    public void setCap(Paint.Cap cap) {
        this.x = cap;
        this.d.setStrokeCap(cap);
        this.e.setStrokeCap(cap);
        invalidate();
    }

    public void setLineCount(int i2) {
        this.m = i2;
        invalidate();
    }

    public void setLineWidth(float f2) {
        this.n = f2;
        invalidate();
    }

    public void setProgressBackgroundColor(int i2) {
        this.t = i2;
        this.e.setColor(i2);
        invalidate();
    }

    public void setProgressEndColor(int i2) {
        this.r = i2;
        b();
        invalidate();
    }

    public void setProgressStartColor(int i2) {
        this.q = i2;
        b();
        invalidate();
    }

    public void setProgressStrokeWidth(float f2) {
        this.o = f2;
        this.c.inset(f2 / 2.0f, f2 / 2.0f);
        invalidate();
    }

    public void setProgressTextColor(int i2) {
        this.s = i2;
        invalidate();
    }

    public void setProgressTextFormatPattern(String str) {
        this.u = str;
        invalidate();
    }

    public void setProgressTextSize(float f2) {
        this.p = f2;
        invalidate();
    }

    public void setShader(int i2) {
        this.w = i2;
        b();
        invalidate();
    }

    public void setStyle(int i2) {
        Paint.Style style;
        Paint.Style style2;
        this.v = i2;
        Paint paint = this.d;
        if (i2 == 1) {
            style = Paint.Style.FILL;
        } else {
            style = Paint.Style.STROKE;
        }
        paint.setStyle(style);
        Paint paint2 = this.e;
        if (this.v == 1) {
            style2 = Paint.Style.FILL;
        } else {
            style2 = Paint.Style.STROKE;
        }
        paint2.setStyle(style2);
        invalidate();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new RectF();
        new Rect();
        this.d = new Paint(1);
        this.e = new Paint(1);
        this.f = new Paint(1);
        this.g = new Paint(1);
        Class<ProgressBar> cls = ProgressBar.class;
        try {
            Field declaredField = cls.getDeclaredField("mOnlyIndeterminate");
            declaredField.setAccessible(true);
            Boolean bool = Boolean.FALSE;
            declaredField.set(this, bool);
            Field declaredField2 = cls.getDeclaredField("mIndeterminate");
            declaredField2.setAccessible(true);
            declaredField2.set(this, bool);
            Field declaredField3 = cls.getDeclaredField("mCurrentDrawable");
            declaredField3.setAccessible(true);
            declaredField3.set(this, (Object) null);
        } catch (Exception e2) {
            e2.toString();
            ArrayList arrayList = LogActivity.k;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressBar);
        this.l = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_background_color, 0);
        obtainStyledAttributes.getBoolean(R.styleable.CircleProgressBar_draw_progress_text, true);
        this.m = obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_line_count, 45);
        int i2 = R.styleable.CircleProgressBar_progress_text_format_pattern;
        this.u = obtainStyledAttributes.hasValue(i2) ? obtainStyledAttributes.getString(i2) : "%d%%";
        this.v = obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_style, 0);
        this.w = obtainStyledAttributes.getInt(R.styleable.CircleProgressBar_progress_shader, 0);
        int i3 = R.styleable.CircleProgressBar_progress_stroke_cap;
        this.x = obtainStyledAttributes.hasValue(i3) ? Paint.Cap.values()[obtainStyledAttributes.getInt(i3, 0)] : Paint.Cap.BUTT;
        this.n = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_line_width, (int) ((4.0f * getContext().getResources().getDisplayMetrics().density) + 0.5f));
        this.p = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_progress_text_size, (int) ((11.0f * getContext().getResources().getDisplayMetrics().density) + 0.5f));
        this.o = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressBar_progress_stroke_width, (int) ((1.0f * getContext().getResources().getDisplayMetrics().density) + 0.5f));
        this.q = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_start_color, Color.parseColor("#fff2a670"));
        this.r = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_end_color, Color.parseColor("#fff2a670"));
        this.s = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_text_color, Color.parseColor("#fff2a670"));
        this.t = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progress_background_color, Color.parseColor("#ffe3e3e5"));
        obtainStyledAttributes.recycle();
        Paint.Align align = Paint.Align.CENTER;
        Paint paint = this.g;
        paint.setTextAlign(align);
        paint.setTextSize(this.p);
        Paint.Style style = this.v == 1 ? Paint.Style.FILL : Paint.Style.STROKE;
        Paint paint2 = this.d;
        paint2.setStyle(style);
        paint2.setStrokeWidth(this.o);
        paint2.setColor(this.q);
        paint2.setStrokeCap(this.x);
        Paint.Style style2 = this.v == 1 ? Paint.Style.FILL : Paint.Style.STROKE;
        Paint paint3 = this.e;
        paint3.setStyle(style2);
        paint3.setStrokeWidth(this.o);
        paint3.setColor(this.t);
        paint3.setStrokeCap(this.x);
        Paint.Style style3 = Paint.Style.FILL;
        Paint paint4 = this.f;
        paint4.setStyle(style3);
        paint4.setColor(this.l);
    }
}
