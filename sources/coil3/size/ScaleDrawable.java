package coil3.size;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import coil3.decode.DecodeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/size/ScaleDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Animatable;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nScaleDrawable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaleDrawable.kt\ncoil3/size/ScaleDrawable\n+ 2 Canvas.kt\nandroidx/core/graphics/CanvasKt\n*L\n1#1,121:1\n30#2,7:122\n*S KotlinDebug\n*F\n+ 1 ScaleDrawable.kt\ncoil3/size/ScaleDrawable\n*L\n35#1:122,7\n*E\n"})
public final class ScaleDrawable extends Drawable implements Drawable.Callback, Animatable {
    public final Drawable c;
    public final Scale d;
    public float e;
    public float f;
    public float g = 1.0f;

    public ScaleDrawable(Drawable drawable, Scale scale) {
        this.c = drawable;
        this.d = scale;
        drawable.setCallback(this);
    }

    public final void draw(Canvas canvas) {
        int save = canvas.save();
        try {
            canvas.translate(this.e, this.f);
            float f2 = this.g;
            canvas.scale(f2, f2);
            this.c.draw(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public final int getAlpha() {
        return this.c.getAlpha();
    }

    public final ColorFilter getColorFilter() {
        return this.c.getColorFilter();
    }

    public final int getIntrinsicHeight() {
        return this.c.getIntrinsicHeight();
    }

    public final int getIntrinsicWidth() {
        return this.c.getIntrinsicWidth();
    }

    public final int getOpacity() {
        return this.c.getOpacity();
    }

    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public final boolean isRunning() {
        Drawable drawable = this.c;
        if (!(drawable instanceof Animatable) || !((Animatable) drawable).isRunning()) {
            return false;
        }
        return true;
    }

    public final boolean isStateful() {
        return this.c.isStateful();
    }

    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.c;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 1.0f;
            return;
        }
        int width = rect.width();
        int height = rect.height();
        double b = DecodeUtils.b(intrinsicWidth, intrinsicHeight, width, height, this.d);
        double d2 = (double) 2;
        int a2 = MathKt.a((((double) width) - (((double) intrinsicWidth) * b)) / d2);
        int a3 = MathKt.a((((double) height) - (((double) intrinsicHeight) * b)) / d2);
        drawable.setBounds(a2, a3, intrinsicWidth + a2, intrinsicHeight + a3);
        this.e = (float) rect.left;
        this.f = (float) rect.top;
        this.g = (float) b;
    }

    public final boolean onLevelChange(int i) {
        return this.c.setLevel(i);
    }

    public final boolean onStateChange(int[] iArr) {
        return this.c.setState(iArr);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public final void setAlpha(int i) {
        this.c.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }

    public final void setTint(int i) {
        this.c.setTint(i);
    }

    public final void setTintBlendMode(BlendMode blendMode) {
        this.c.setTintBlendMode(blendMode);
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.c.setTintList(colorStateList);
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        this.c.setTintMode(mode);
    }

    public final void start() {
        Drawable drawable = this.c;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    public final void stop() {
        Drawable drawable = this.c;
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
