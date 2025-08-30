package com.chaos.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;

public class PinView extends AppCompatEditText {
    public static final InputFilter[] G = new InputFilter[0];
    public static final int[] H = {16842913};
    public int A;
    public int B;
    public int C;
    public Drawable D;
    public boolean E;
    public String F;
    public final int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int i;
    public final Paint j;
    public final TextPaint k;
    public ColorStateList l;
    public int m;
    public int n;
    public final Rect o;
    public final RectF p;
    public final RectF q;
    public final Path r;
    public final PointF s;
    public final ValueAnimator t;
    public boolean u;
    public boolean v;
    public Blink w;
    public boolean x;
    public boolean y;
    public float z;

    /* renamed from: com.chaos.view.PinView$2  reason: invalid class name */
    class AnonymousClass2 extends DefaultActionModeCallback {
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            menu.removeItem(16908355);
            return true;
        }
    }

    public class Blink implements Runnable {
        public boolean c;

        public Blink() {
        }

        public final void run() {
            boolean z;
            if (!this.c) {
                PinView pinView = PinView.this;
                pinView.removeCallbacks(this);
                InputFilter[] inputFilterArr = PinView.G;
                if (!pinView.x || !pinView.isFocused()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    pinView.d(!pinView.y);
                    pinView.postDelayed(this, 500);
                }
            }
        }
    }

    public static class DefaultActionModeCallback implements ActionMode.Callback {
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        public final void onDestroyActionMode(ActionMode actionMode) {
        }

        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    }

    public PinView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setMaxLength(int i2) {
        if (i2 >= 0) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
            return;
        }
        setFilters(G);
    }

    public final void a() {
        int i2 = this.c;
        if (i2 == 1) {
            if (((float) this.g) > ((float) this.n) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than lineWidth when viewType is line");
            }
        } else if (i2 == 0) {
            if (((float) this.g) > ((float) this.e) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than itemWidth");
            }
        }
    }

    public final void b(Canvas canvas, TextPaint textPaint, CharSequence charSequence, int i2) {
        String charSequence2 = charSequence.toString();
        int i3 = i2 + 1;
        Rect rect = this.o;
        textPaint.getTextBounds(charSequence2, i2, i3, rect);
        PointF pointF = this.s;
        float f2 = pointF.x;
        float f3 = pointF.y;
        canvas.drawText(charSequence, i2, i3, (f2 - (Math.abs((float) rect.width()) / 2.0f)) - ((float) rect.left), ((Math.abs((float) rect.height()) / 2.0f) + f3) - ((float) rect.bottom), textPaint);
    }

    public final TextPaint c(int i2) {
        if (!this.u || i2 != getText().length() - 1) {
            return getPaint();
        }
        TextPaint textPaint = this.k;
        textPaint.setColor(getPaint().getColor());
        return textPaint;
    }

    public final void d(boolean z2) {
        if (this.y != z2) {
            this.y = z2;
            invalidate();
        }
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.l;
        if (colorStateList == null || colorStateList.isStateful()) {
            g();
        }
    }

    public final void e() {
        if (!this.x || !isFocused()) {
            Blink blink = this.w;
            if (blink != null) {
                removeCallbacks(blink);
                return;
            }
            return;
        }
        if (this.w == null) {
            this.w = new Blink();
        }
        removeCallbacks(this.w);
        this.y = false;
        postDelayed(this.w, 500);
    }

    public final void f() {
        RectF rectF = this.p;
        this.s.set((Math.abs(rectF.width()) / 2.0f) + rectF.left, (Math.abs(rectF.height()) / 2.0f) + rectF.top);
    }

    public final void g() {
        int i2;
        ColorStateList colorStateList = this.l;
        if (colorStateList != null) {
            i2 = colorStateList.getColorForState(getDrawableState(), 0);
        } else {
            i2 = getCurrentTextColor();
        }
        if (i2 != this.m) {
            this.m = i2;
            invalidate();
        }
    }

    @ColorInt
    public int getCurrentLineColor() {
        return this.m;
    }

    public int getCursorColor() {
        return this.B;
    }

    public int getCursorWidth() {
        return this.A;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.chaos.view.DefaultMovementMethod] */
    public MovementMethod getDefaultMovementMethod() {
        if (DefaultMovementMethod.f187a == null) {
            DefaultMovementMethod.f187a = new Object();
        }
        return DefaultMovementMethod.f187a;
    }

    public int getItemCount() {
        return this.d;
    }

    public int getItemHeight() {
        return this.f;
    }

    public int getItemRadius() {
        return this.g;
    }

    @Px
    public int getItemSpacing() {
        return this.i;
    }

    public int getItemWidth() {
        return this.e;
    }

    public ColorStateList getLineColors() {
        return this.l;
    }

    public int getLineWidth() {
        return this.n;
    }

    public final void h() {
        float f2;
        float f3 = (float) (((int) ((2.0f * getResources().getDisplayMetrics().density) + 0.5f)) * 2);
        if (((float) this.f) - getTextSize() > f3) {
            f2 = getTextSize() + f3;
        } else {
            f2 = getTextSize();
        }
        this.z = f2;
    }

    public final void i(int i2) {
        float f2 = ((float) this.n) / 2.0f;
        int paddingStart = ViewCompat.getPaddingStart(this) + getScrollX();
        int i3 = this.i;
        int i4 = this.e;
        float f3 = ((float) (((i3 + i4) * i2) + paddingStart)) + f2;
        if (i3 == 0 && i2 > 0) {
            f3 -= (float) (this.n * i2);
        }
        float f4 = (((float) i4) + f3) - ((float) this.n);
        float paddingTop = ((float) (getPaddingTop() + getScrollY())) + f2;
        this.p.set(f3, paddingTop, f4, (((float) this.f) + paddingTop) - ((float) this.n));
    }

    public final boolean isCursorVisible() {
        return this.x;
    }

    public final boolean isSuggestionsEnabled() {
        return false;
    }

    public final void j(int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.i != 0) {
            z3 = true;
        } else {
            if (i2 != 0 || i2 == this.d - 1) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (i2 != this.d - 1 || i2 == 0) {
                z3 = z4;
                z2 = false;
                RectF rectF = this.p;
                int i3 = this.g;
                k(rectF, (float) i3, (float) i3, z3, z2);
            }
            z3 = z4;
        }
        z2 = true;
        RectF rectF2 = this.p;
        int i32 = this.g;
        k(rectF2, (float) i32, (float) i32, z3, z2);
    }

    public final void k(RectF rectF, float f2, float f3, boolean z2, boolean z3) {
        Path path = this.r;
        path.reset();
        float f4 = rectF.left;
        float f5 = rectF.top;
        float f6 = (rectF.right - f4) - (f2 * 2.0f);
        float f7 = (rectF.bottom - f5) - (2.0f * f3);
        path.moveTo(f4, f5 + f3);
        if (z2) {
            float f8 = -f3;
            path.rQuadTo(0.0f, f8, f2, f8);
        } else {
            path.rLineTo(0.0f, -f3);
            path.rLineTo(f2, 0.0f);
        }
        path.rLineTo(f6, 0.0f);
        if (z3) {
            path.rQuadTo(f2, 0.0f, f2, f3);
        } else {
            path.rLineTo(f2, 0.0f);
            path.rLineTo(0.0f, f3);
        }
        path.rLineTo(0.0f, f7);
        if (z3) {
            path.rQuadTo(0.0f, f3, -f2, f3);
        } else {
            path.rLineTo(0.0f, f3);
            path.rLineTo(-f2, 0.0f);
        }
        path.rLineTo(-f6, 0.0f);
        if (z2) {
            float f9 = -f2;
            path.rQuadTo(f9, 0.0f, f9, -f3);
        } else {
            path.rLineTo(-f2, 0.0f);
            path.rLineTo(0.0f, -f3);
        }
        path.rLineTo(0.0f, -f7);
        path.close();
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Blink blink = this.w;
        if (blink != null) {
            blink.c = false;
            e();
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Blink blink = this.w;
        if (blink != null) {
            if (!blink.c) {
                PinView.this.removeCallbacks(blink);
                blink.c = true;
            }
            d(false);
        }
    }

    public final void onDraw(Canvas canvas) {
        int[] iArr;
        int i2;
        Path path;
        int i3;
        boolean z2;
        int i4;
        int i5;
        boolean z3;
        boolean z4;
        boolean z5;
        Canvas canvas2 = canvas;
        canvas.save();
        Paint paint = this.j;
        paint.setColor(this.m);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) this.n);
        getPaint().setColor(getCurrentTextColor());
        int length = getText().length();
        int i6 = 0;
        while (true) {
            int i7 = this.d;
            iArr = H;
            i2 = this.c;
            path = this.r;
            if (i6 >= i7) {
                break;
            }
            if (!isFocused() || length != i6) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                ColorStateList colorStateList = this.l;
                if (colorStateList != null) {
                    i4 = colorStateList.getColorForState(iArr, this.m);
                } else {
                    i4 = this.m;
                }
            } else {
                i4 = this.m;
            }
            paint.setColor(i4);
            i(i6);
            f();
            canvas.save();
            if (i2 == 0) {
                j(i6);
                canvas2.clipPath(path);
            }
            Drawable drawable = this.D;
            RectF rectF = this.p;
            if (drawable != null) {
                float f2 = ((float) this.n) / 2.0f;
                this.D.setBounds(Math.round(rectF.left - f2), Math.round(rectF.top - f2), Math.round(rectF.right + f2), Math.round(rectF.bottom + f2));
                Drawable drawable2 = this.D;
                if (!z2) {
                    iArr = getDrawableState();
                }
                drawable2.setState(iArr);
                this.D.draw(canvas2);
            }
            canvas.restore();
            PointF pointF = this.s;
            if (!z2 || !this.y) {
                i5 = length;
            } else {
                float f3 = pointF.x;
                float f4 = pointF.y - (this.z / 2.0f);
                int color = paint.getColor();
                float strokeWidth = paint.getStrokeWidth();
                paint.setColor(this.B);
                paint.setStrokeWidth((float) this.A);
                float f5 = strokeWidth;
                float f6 = f4 + this.z;
                i5 = length;
                canvas.drawLine(f3, f4, f3, f6, paint);
                paint.setColor(color);
                paint.setStrokeWidth(f5);
            }
            if (i2 == 0) {
                if (!this.E || i6 >= getText().length()) {
                    canvas2.drawPath(path, paint);
                }
            } else if (i2 == 1 && (!this.E || i6 >= getText().length())) {
                if (this.i == 0) {
                    int i8 = this.d;
                    if (i8 > 1) {
                        if (i6 == 0) {
                            z4 = true;
                        } else if (i6 == i8 - 1) {
                            z5 = false;
                        } else {
                            z4 = false;
                        }
                        z3 = false;
                        paint.setStyle(Paint.Style.FILL);
                        paint.setStrokeWidth(((float) this.n) / 10.0f);
                        float f7 = ((float) this.n) / 2.0f;
                        RectF rectF2 = this.q;
                        float f8 = rectF.bottom;
                        rectF2.set(rectF.left - f7, f8 - f7, rectF.right + f7, f8 + f7);
                        float f9 = (float) this.g;
                        k(rectF2, f9, f9, z4, z3);
                        canvas2.drawPath(path, paint);
                    }
                    z5 = true;
                } else {
                    z5 = true;
                }
                z3 = true;
                paint.setStyle(Paint.Style.FILL);
                paint.setStrokeWidth(((float) this.n) / 10.0f);
                float f72 = ((float) this.n) / 2.0f;
                RectF rectF22 = this.q;
                float f82 = rectF.bottom;
                rectF22.set(rectF.left - f72, f82 - f72, rectF.right + f72, f82 + f72);
                float f92 = (float) this.g;
                k(rectF22, f92, f92, z4, z3);
                canvas2.drawPath(path, paint);
            }
            if (this.F.length() > i6) {
                if (getTransformationMethod() != null || !this.v) {
                    b(canvas2, c(i6), this.F, i6);
                } else {
                    TextPaint c2 = c(i6);
                    canvas2.drawCircle(pointF.x, pointF.y, c2.getTextSize() / 2.0f, c2);
                }
            } else if (!TextUtils.isEmpty(getHint()) && getHint().length() == this.d) {
                TextPaint c3 = c(i6);
                c3.setColor(getCurrentHintTextColor());
                b(canvas2, c3, getHint(), i6);
            }
            i6++;
            length = i5;
        }
        if (isFocused() && getText().length() != this.d && i2 == 0) {
            int length2 = getText().length();
            i(length2);
            f();
            j(length2);
            ColorStateList colorStateList2 = this.l;
            if (colorStateList2 != null) {
                i3 = colorStateList2.getColorForState(iArr, this.m);
            } else {
                i3 = this.m;
            }
            paint.setColor(i3);
            if (!this.E || length2 >= getText().length()) {
                canvas2.drawPath(path, paint);
            }
        }
        canvas.restore();
    }

    public final void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (z2) {
            setSelection(getText().length());
            e();
        }
    }

    public final void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = this.f;
        if (mode != 1073741824) {
            int i5 = this.d;
            size = ViewCompat.getPaddingStart(this) + ViewCompat.getPaddingEnd(this) + (i5 * this.e) + ((i5 - 1) * this.i);
            if (this.i == 0) {
                size -= (this.d - 1) * this.n;
            }
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingTop() + i4 + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    public final void onScreenStateChanged(int i2) {
        Blink blink;
        super.onScreenStateChanged(i2);
        if (i2 == 0) {
            Blink blink2 = this.w;
            if (blink2 != null) {
                if (!blink2.c) {
                    PinView.this.removeCallbacks(blink2);
                    blink2.c = true;
                }
                d(false);
            }
        } else if (i2 == 1 && (blink = this.w) != null) {
            blink.c = false;
            e();
        }
    }

    public final void onSelectionChanged(int i2, int i3) {
        super.onSelectionChanged(i2, i3);
        if (i3 != getText().length()) {
            setSelection(getText().length());
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        ValueAnimator valueAnimator;
        if (i2 != charSequence.length()) {
            setSelection(getText().length());
        }
        e();
        if (this.u && i4 - i3 > 0 && (valueAnimator = this.t) != null) {
            valueAnimator.end();
            this.t.start();
        }
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod == null) {
            this.F = getText().toString();
        } else {
            this.F = transformationMethod.getTransformation(getText(), this).toString();
        }
    }

    public void setAnimationEnable(boolean z2) {
        this.u = z2;
    }

    public void setCursorColor(@ColorInt int i2) {
        this.B = i2;
        if (this.x) {
            d(true);
        }
    }

    public void setCursorVisible(boolean z2) {
        if (this.x != z2) {
            this.x = z2;
            d(z2);
            e();
        }
    }

    public void setCursorWidth(@Px int i2) {
        this.A = i2;
        if (this.x) {
            d(true);
        }
    }

    public void setHideLineWhenFilled(boolean z2) {
        this.E = z2;
    }

    public void setInputType(int i2) {
        boolean z2;
        super.setInputType(i2);
        int inputType = getInputType() & 4095;
        if (inputType == 129 || inputType == 225 || inputType == 18) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.v = z2;
    }

    public void setItemBackground(Drawable drawable) {
        this.C = 0;
        this.D = drawable;
        invalidate();
    }

    public void setItemBackgroundColor(@ColorInt int i2) {
        Drawable drawable = this.D;
        if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable.mutate()).setColor(i2);
            this.C = 0;
            return;
        }
        setItemBackground(new ColorDrawable(i2));
    }

    public void setItemBackgroundResources(@DrawableRes int i2) {
        if (i2 == 0 || this.C == i2) {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), i2, getContext().getTheme());
            this.D = drawable;
            setItemBackground(drawable);
            this.C = i2;
        }
    }

    public void setItemCount(int i2) {
        this.d = i2;
        setMaxLength(i2);
        requestLayout();
    }

    public void setItemHeight(@Px int i2) {
        this.f = i2;
        h();
        requestLayout();
    }

    public void setItemRadius(@Px int i2) {
        this.g = i2;
        a();
        requestLayout();
    }

    public void setItemSpacing(@Px int i2) {
        this.i = i2;
        requestLayout();
    }

    public void setItemWidth(@Px int i2) {
        this.e = i2;
        a();
        requestLayout();
    }

    public void setLineColor(@ColorInt int i2) {
        this.l = ColorStateList.valueOf(i2);
        g();
    }

    public void setLineWidth(@Px int i2) {
        this.n = i2;
        a();
        requestLayout();
    }

    public void setPasswordHidden(boolean z2) {
        this.v = z2;
        requestLayout();
    }

    public void setTextSize(float f2) {
        super.setTextSize(f2);
        h();
    }

    public void setTypeface(Typeface typeface, int i2) {
        super.setTypeface(typeface, i2);
    }

    public PinView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pinViewStyle);
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        TextPaint textPaint = this.k;
        if (textPaint != null) {
            textPaint.set(getPaint());
        }
    }

    /* JADX WARNING: type inference failed for: r7v13, types: [java.lang.Object, android.view.ActionMode$Callback] */
    /* JADX WARNING: type inference failed for: r7v17, types: [java.lang.Object, android.view.ActionMode$Callback] */
    public PinView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TextPaint textPaint = new TextPaint();
        this.k = textPaint;
        this.m = ViewCompat.MEASURED_STATE_MASK;
        this.o = new Rect();
        this.p = new RectF();
        this.q = new RectF();
        this.r = new Path();
        this.s = new PointF();
        boolean z2 = false;
        this.u = false;
        Resources resources = getResources();
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setStyle(Paint.Style.STROKE);
        textPaint.set(getPaint());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PinView, i2, 0);
        this.c = obtainStyledAttributes.getInt(R.styleable.PinView_viewType, 0);
        this.d = obtainStyledAttributes.getInt(R.styleable.PinView_itemCount, 4);
        int i3 = R.styleable.PinView_itemHeight;
        int i4 = R.dimen.pv_pin_view_item_size;
        this.f = (int) obtainStyledAttributes.getDimension(i3, (float) resources.getDimensionPixelSize(i4));
        this.e = (int) obtainStyledAttributes.getDimension(R.styleable.PinView_itemWidth, (float) resources.getDimensionPixelSize(i4));
        this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinView_itemSpacing, resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_spacing));
        this.g = (int) obtainStyledAttributes.getDimension(R.styleable.PinView_itemRadius, 0.0f);
        this.n = (int) obtainStyledAttributes.getDimension(R.styleable.PinView_lineWidth, (float) resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_line_width));
        this.l = obtainStyledAttributes.getColorStateList(R.styleable.PinView_lineColor);
        this.x = obtainStyledAttributes.getBoolean(R.styleable.PinView_android_cursorVisible, true);
        this.B = obtainStyledAttributes.getColor(R.styleable.PinView_cursorColor, getCurrentTextColor());
        this.A = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PinView_cursorWidth, resources.getDimensionPixelSize(R.dimen.pv_pin_view_cursor_width));
        this.D = obtainStyledAttributes.getDrawable(R.styleable.PinView_android_itemBackground);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.PinView_hideLineWhenFilled, false);
        obtainStyledAttributes.recycle();
        ColorStateList colorStateList = this.l;
        if (colorStateList != null) {
            this.m = colorStateList.getDefaultColor();
        }
        h();
        a();
        setMaxLength(this.d);
        paint.setStrokeWidth((float) this.n);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
        this.t = ofFloat;
        ofFloat.setDuration(150);
        this.t.setInterpolator(new DecelerateInterpolator());
        this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                PinView pinView = PinView.this;
                pinView.k.setTextSize(pinView.getTextSize() * floatValue);
                pinView.k.setAlpha((int) (255.0f * floatValue));
                pinView.postInvalidate();
            }
        });
        setTransformationMethod((TransformationMethod) null);
        setCustomSelectionActionModeCallback(new Object());
        if (Build.VERSION.SDK_INT >= 26) {
            setCustomInsertionActionModeCallback(new Object());
        }
        int inputType = getInputType() & 4095;
        this.v = (inputType == 129 || inputType == 225 || inputType == 18) ? true : z2;
    }

    public void setLineColor(ColorStateList colorStateList) {
        colorStateList.getClass();
        this.l = colorStateList;
        g();
    }

    public void setTextSize(int i2, float f2) {
        super.setTextSize(i2, f2);
        h();
    }
}
