package com.ktakilat.loan.weiget.gesture;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import com.pendanaan.kta.R;
import java.util.ArrayList;
import java.util.Iterator;

public class PatternIndicatorView extends View {
    public final DefaultIndicatorNormalCellView c;
    public final DefaultIndicatorHitCellView d;
    public boolean e;
    public ArrayList f;
    public ArrayList g;

    public PatternIndicatorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        if (this.g == null) {
            this.g = CellFactory.a((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        }
        Iterator it = this.g.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ((CellBean) it.next()).g = false;
        }
        for (i = 0; i < this.f.size(); i++) {
            Integer num = (Integer) this.f.get(i);
            if (num.intValue() >= 0 && num.intValue() < this.g.size()) {
                ((CellBean) this.g.get(num.intValue())).g = true;
            }
        }
        Iterator it2 = this.g.iterator();
        while (it2.hasNext()) {
            CellBean cellBean = (CellBean) it2.next();
            if (cellBean.g) {
                DefaultIndicatorHitCellView defaultIndicatorHitCellView = this.d;
                boolean z = this.e;
                defaultIndicatorHitCellView.getClass();
                int save = canvas.save();
                Paint paint = defaultIndicatorHitCellView.f608a;
                DefaultStyleDecorator defaultStyleDecorator = defaultIndicatorHitCellView.b;
                if (z) {
                    i2 = defaultStyleDecorator.e;
                } else {
                    i2 = defaultStyleDecorator.c;
                }
                paint.setColor(i2);
                canvas.drawCircle(cellBean.d, cellBean.e, cellBean.f, paint);
                canvas.restoreToCount(save);
            } else {
                DefaultIndicatorNormalCellView defaultIndicatorNormalCellView = this.c;
                defaultIndicatorNormalCellView.getClass();
                int save2 = canvas.save();
                Paint paint2 = defaultIndicatorNormalCellView.f609a;
                DefaultStyleDecorator defaultStyleDecorator2 = defaultIndicatorNormalCellView.b;
                paint2.setColor(defaultStyleDecorator2.f613a);
                float f2 = cellBean.d;
                float f3 = cellBean.e;
                float f4 = cellBean.f;
                canvas.drawCircle(f2, f3, f4, paint2);
                paint2.setColor(defaultStyleDecorator2.b);
                canvas.drawCircle(cellBean.d, f3, f4 - defaultStyleDecorator2.f, paint2);
                canvas.restoreToCount(save2);
            }
        }
    }

    public final void onMeasure(int i, int i2) {
        int min = Math.min(i, i2);
        super.onMeasure(min, min);
    }

    public PatternIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: type inference failed for: r10v2, types: [com.ktakilat.loan.weiget.gesture.DefaultIndicatorNormalCellView, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r10v3, types: [com.ktakilat.loan.weiget.gesture.DefaultIndicatorHitCellView, java.lang.Object] */
    public PatternIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        this.f = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PatternIndicatorView, i, 0);
        int color = obtainStyledAttributes.getColor(0, DefaultConfig.f607a);
        int color2 = obtainStyledAttributes.getColor(2, DefaultConfig.d);
        int color3 = obtainStyledAttributes.getColor(3, DefaultConfig.b);
        int color4 = obtainStyledAttributes.getColor(1, DefaultConfig.c);
        float dimension = obtainStyledAttributes.getDimension(4, TypedValue.applyDimension(1, (float) 1, context.getResources().getDisplayMetrics()));
        obtainStyledAttributes.recycle();
        DefaultStyleDecorator defaultStyleDecorator = new DefaultStyleDecorator(color, color2, color3, color3, color4, dimension);
        ? obj = new Object();
        Paint a2 = DefaultConfig.a();
        obj.f609a = a2;
        Paint.Style style = Paint.Style.FILL;
        a2.setStyle(style);
        obj.b = defaultStyleDecorator;
        this.c = obj;
        ? obj2 = new Object();
        Paint a3 = DefaultConfig.a();
        obj2.f608a = a3;
        a3.setStyle(style);
        obj2.b = defaultStyleDecorator;
        this.d = obj2;
        DefaultConfig.a().setStyle(Paint.Style.STROKE);
    }
}
