package com.ktakilat.loan.normal_ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.idl.face.platform.utils.BitmapUtils;

public class HoleView extends View {
    public Paint c;
    public Paint d;

    public HoleView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(-1728053248);
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        setLayerType(1, (Paint) null);
        Paint paint2 = new Paint();
        this.d = paint2;
        paint2.setAntiAlias(true);
        this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.c);
        int width = getWidth();
        int height = getHeight();
        int i = (width * 248) / BitmapUtils.ROTATE360;
        int i2 = (i * 376) / 251;
        int i3 = (width - i) / 2;
        int i4 = (height - i2) / 2;
        canvas.drawRoundRect(new RectF((float) i3, (float) i4, (float) (i + i3), (float) (i2 + i4)), 24.0f, 24.0f, this.d);
    }

    public HoleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public HoleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
