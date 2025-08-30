package com.ktakilat.loan.mobile_check;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import org.apache.commons.lang3.StringUtils;

public class WhiteSpaceSpan extends ReplacementSpan {
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence2 = charSequence;
        sb.append(charSequence);
        sb.append(StringUtils.SPACE);
        canvas.drawText(sb.toString(), i, i2, f, (float) i4, paint);
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return Math.round(paint.measureText(StringUtils.SPACE) + paint.measureText(charSequence, i, i2));
    }
}
