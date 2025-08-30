package com.ktakilat.loan.weiget.gesture;

import android.graphics.Color;
import android.graphics.Paint;

public class DefaultConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final int f607a = Color.parseColor("#2196F3");
    public static final int b = Color.parseColor("#3F51B5");
    public static final int c = Color.parseColor("#F44336");
    public static final int d = Color.parseColor("#FFFFFF");

    public static Paint a() {
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        return paint;
    }
}
