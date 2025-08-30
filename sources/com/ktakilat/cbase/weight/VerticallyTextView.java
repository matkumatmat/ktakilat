package com.ktakilat.cbase.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.ktakilat.cbase.R;

public class VerticallyTextView extends View {
    public TextPaint c;
    public String d;
    public final Rect e = new Rect();
    public final int f;

    public VerticallyTextView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        TextPaint textPaint = new TextPaint();
        this.c = textPaint;
        textPaint.setAntiAlias(true);
        this.c.setTextSize(15.0f);
        this.c.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.c.setTextAlign(Paint.Align.CENTER);
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        Path path = new Path();
        int i = this.f;
        Rect rect = this.e;
        if (i == 0) {
            float width = (float) ((getWidth() >> 1) - (rect.height() >> 1));
            path.moveTo(width, (float) 0);
            path.lineTo(width, (float) height);
        } else {
            float width2 = (float) ((getWidth() >> 1) + (rect.height() >> 1));
            path.moveTo(width2, (float) height);
            path.lineTo(width2, (float) 0);
        }
        canvas.drawTextOnPath(this.d, path, 0.0f, 0.0f, this.c);
    }

    public final void onMeasure(int i, int i2) {
        TextPaint textPaint = this.c;
        String str = this.d;
        int length = str.length();
        Rect rect = this.e;
        textPaint.getTextBounds(str, 0, length, rect);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int height = rect.height();
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(height, size);
            } else {
                size = height;
            }
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            int width = rect.width();
            if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(width, size2);
            } else {
                size2 = width;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setText(String str) {
        this.d = str;
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        this.c.setColor(i);
        invalidate();
    }

    public void setTextSize(int i) {
        this.c.setTextSize((float) i);
        requestLayout();
        invalidate();
    }

    public VerticallyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerticallyTextView);
        String string = obtainStyledAttributes.getString(R.styleable.VerticallyTextView_vertical_text);
        if (string != null) {
            this.d = string.toString();
        }
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.VerticallyTextView_vertical_textSize, 15);
        if (dimensionPixelOffset > 0) {
            this.c.setTextSize((float) dimensionPixelOffset);
        }
        this.c.setColor(obtainStyledAttributes.getColor(R.styleable.VerticallyTextView_vertical_textColor, ViewCompat.MEASURED_STATE_MASK));
        this.f = obtainStyledAttributes.getInt(R.styleable.VerticallyTextView_direction, 0);
        obtainStyledAttributes.recycle();
        requestLayout();
        invalidate();
    }
}
