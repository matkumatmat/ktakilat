package coil3.transition;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil3.decode.DecodeUtils;
import coil3.size.Scale;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/transition/CrossfadeDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCrossfadeDrawable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrossfadeDrawable.kt\ncoil3/transition/CrossfadeDrawable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Canvas.kt\nandroidx/core/graphics/CanvasKt\n+ 4 collections.kt\ncoil3/util/CollectionsKt\n*L\n1#1,284:1\n1#2:285\n30#3,7:286\n30#3,7:293\n30#3,7:300\n30#3,7:307\n43#4,4:314\n43#4,4:318\n*S KotlinDebug\n*F\n+ 1 CrossfadeDrawable.kt\ncoil3/transition/CrossfadeDrawable\n*L\n72#1:286,7\n80#1:293,7\n94#1:300,7\n101#1:307,7\n216#1:314,4\n274#1:318,4\n*E\n"})
public final class CrossfadeDrawable extends Drawable implements Drawable.Callback, Animatable2Compat {
    public final Scale c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final ArrayList g = new ArrayList();
    public final int i;
    public final int j;
    public long k;
    public int l;
    public int m;
    public Drawable n;
    public final Drawable o;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcoil3/transition/CrossfadeDrawable$Companion;", "", "", "STATE_START", "I", "STATE_RUNNING", "STATE_DONE", "DEFAULT_DURATION", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    public CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale, int i2, boolean z, boolean z2) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Drawable drawable3;
        this.c = scale;
        this.d = i2;
        this.e = z;
        this.f = z2;
        Drawable drawable4 = null;
        if (drawable != null) {
            num = Integer.valueOf(drawable.getIntrinsicWidth());
        } else {
            num = null;
        }
        if (drawable2 != null) {
            num2 = Integer.valueOf(drawable2.getIntrinsicWidth());
        } else {
            num2 = null;
        }
        this.i = a(num, num2);
        if (drawable != null) {
            num3 = Integer.valueOf(drawable.getIntrinsicHeight());
        } else {
            num3 = null;
        }
        if (drawable2 != null) {
            num4 = Integer.valueOf(drawable2.getIntrinsicHeight());
        } else {
            num4 = null;
        }
        this.j = a(num3, num4);
        this.l = 255;
        if (drawable != null) {
            drawable3 = drawable.mutate();
        } else {
            drawable3 = null;
        }
        this.n = drawable3;
        drawable4 = drawable2 != null ? drawable2.mutate() : drawable4;
        this.o = drawable4;
        if (i2 > 0) {
            Drawable drawable5 = this.n;
            if (drawable5 != null) {
                drawable5.setCallback(this);
            }
            if (drawable4 != null) {
                drawable4.setCallback(this);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("durationMillis must be > 0.");
    }

    public final int a(Integer num, Integer num2) {
        int i2;
        int i3 = -1;
        if (!this.f && ((num != null && num.intValue() == -1) || (num2 != null && num2.intValue() == -1))) {
            return -1;
        }
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = -1;
        }
        if (num2 != null) {
            i3 = num2.intValue();
        }
        return Math.max(i2, i3);
    }

    public final void b() {
        this.m = 2;
        this.n = null;
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Animatable2Compat.AnimationCallback) arrayList.get(i2)).onAnimationEnd(this);
        }
    }

    public final void c(Drawable drawable, Rect rect) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
            return;
        }
        int width = rect.width();
        int height = rect.height();
        double b = DecodeUtils.b(intrinsicWidth, intrinsicHeight, width, height, this.c);
        double d2 = (double) 2;
        int a2 = MathKt.a((((double) width) - (((double) intrinsicWidth) * b)) / d2);
        int a3 = MathKt.a((((double) height) - (b * ((double) intrinsicHeight))) / d2);
        drawable.setBounds(rect.left + a2, rect.top + a3, rect.right - a2, rect.bottom - a3);
    }

    public final void clearAnimationCallbacks() {
        this.g.clear();
    }

    public final void draw(Canvas canvas) {
        boolean z;
        Drawable drawable;
        int i2 = this.m;
        if (i2 == 0) {
            Drawable drawable2 = this.n;
            if (drawable2 != null) {
                drawable2.setAlpha(this.l);
                int save = canvas.save();
                try {
                    drawable2.draw(canvas);
                } finally {
                    canvas.restoreToCount(save);
                }
            }
        } else {
            Drawable drawable3 = this.o;
            if (i2 != 2) {
                double uptimeMillis = ((double) (SystemClock.uptimeMillis() - this.k)) / ((double) this.d);
                double d2 = 0.0d;
                if (uptimeMillis >= 0.0d) {
                    if (uptimeMillis > 1.0d) {
                        d2 = 1.0d;
                    } else {
                        d2 = uptimeMillis;
                    }
                }
                int i3 = this.l;
                int i4 = (int) (d2 * ((double) i3));
                if (this.e) {
                    i3 -= i4;
                }
                if (uptimeMillis >= 1.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && (drawable = this.n) != null) {
                    drawable.setAlpha(i3);
                    int save2 = canvas.save();
                    try {
                        drawable.draw(canvas);
                    } finally {
                        canvas.restoreToCount(save2);
                    }
                }
                if (drawable3 != null) {
                    drawable3.setAlpha(i4);
                    int save3 = canvas.save();
                    try {
                        drawable3.draw(canvas);
                    } finally {
                        canvas.restoreToCount(save3);
                    }
                }
                if (z) {
                    b();
                } else {
                    invalidateSelf();
                }
            } else if (drawable3 != null) {
                drawable3.setAlpha(this.l);
                int save4 = canvas.save();
                try {
                    drawable3.draw(canvas);
                } finally {
                    canvas.restoreToCount(save4);
                }
            }
        }
    }

    public final int getAlpha() {
        return this.l;
    }

    public final ColorFilter getColorFilter() {
        ColorFilter colorFilter;
        int i2 = this.m;
        if (i2 != 0) {
            Drawable drawable = this.o;
            if (i2 != 1) {
                if (i2 == 2 && drawable != null) {
                    return drawable.getColorFilter();
                }
                return null;
            } else if (drawable != null && (colorFilter = drawable.getColorFilter()) != null) {
                return colorFilter;
            } else {
                Drawable drawable2 = this.n;
                if (drawable2 != null) {
                    return drawable2.getColorFilter();
                }
                return null;
            }
        } else {
            Drawable drawable3 = this.n;
            if (drawable3 != null) {
                return drawable3.getColorFilter();
            }
            return null;
        }
    }

    public final int getIntrinsicHeight() {
        return this.j;
    }

    public final int getIntrinsicWidth() {
        return this.i;
    }

    public final int getOpacity() {
        Drawable drawable = this.n;
        int i2 = this.m;
        if (i2 != 0) {
            Drawable drawable2 = this.o;
            if (i2 == 2) {
                if (drawable2 != null) {
                    return drawable2.getOpacity();
                }
                return -2;
            } else if (drawable != null && drawable2 != null) {
                return Drawable.resolveOpacity(drawable.getOpacity(), drawable2.getOpacity());
            } else {
                if (drawable != null) {
                    return drawable.getOpacity();
                }
                if (drawable2 != null) {
                    return drawable2.getOpacity();
                }
                return -2;
            }
        } else if (drawable != null) {
            return drawable.getOpacity();
        } else {
            return -2;
        }
    }

    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public final boolean isRunning() {
        if (this.m == 1) {
            return true;
        }
        return false;
    }

    public final boolean isStateful() {
        boolean z;
        boolean z2;
        Drawable drawable = this.n;
        if (drawable != null) {
            z = drawable.isStateful();
        } else {
            z = false;
        }
        if (!z) {
            Drawable drawable2 = this.o;
            if (drawable2 != null) {
                z2 = drawable2.isStateful();
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.n;
        if (drawable != null) {
            c(drawable, rect);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null) {
            c(drawable2, rect);
        }
    }

    public final boolean onLevelChange(int i2) {
        boolean z;
        boolean z2;
        Drawable drawable = this.n;
        if (drawable != null) {
            z = drawable.setLevel(i2);
        } else {
            z = false;
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null) {
            z2 = drawable2.setLevel(i2);
        } else {
            z2 = false;
        }
        if (z || z2) {
            return true;
        }
        return false;
    }

    public final boolean onStateChange(int[] iArr) {
        boolean z;
        boolean z2;
        Drawable drawable = this.n;
        if (drawable != null) {
            z = drawable.setState(iArr);
        } else {
            z = false;
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null) {
            z2 = drawable2.setState(iArr);
        } else {
            z2 = false;
        }
        if (z || z2) {
            return true;
        }
        return false;
    }

    public final void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.g.add(animationCallback);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public final void setAlpha(int i2) {
        if (i2 < 0 || i2 >= 256) {
            throw new IllegalArgumentException(ba.k(i2, "Invalid alpha: ").toString());
        }
        this.l = i2;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i2) {
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setTint(i2);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null) {
            drawable2.setTint(i2);
        }
    }

    public final void setTintBlendMode(BlendMode blendMode) {
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null) {
            drawable2.setTintBlendMode(blendMode);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null) {
            drawable2.setTintMode(mode);
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start() {
        /*
            r4 = this;
            android.graphics.drawable.Drawable r0 = r4.n
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            r2 = 0
            if (r1 == 0) goto L_0x000a
            android.graphics.drawable.Animatable r0 = (android.graphics.drawable.Animatable) r0
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            if (r0 == 0) goto L_0x0010
            r0.start()
        L_0x0010:
            android.graphics.drawable.Drawable r0 = r4.o
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            if (r1 == 0) goto L_0x0019
            r2 = r0
            android.graphics.drawable.Animatable r2 = (android.graphics.drawable.Animatable) r2
        L_0x0019:
            if (r2 == 0) goto L_0x001e
            r2.start()
        L_0x001e:
            int r0 = r4.m
            if (r0 == 0) goto L_0x0023
            return
        L_0x0023:
            r0 = 1
            r4.m = r0
            long r0 = android.os.SystemClock.uptimeMillis()
            r4.k = r0
            java.util.ArrayList r0 = r4.g
            int r1 = r0.size()
            r2 = 0
        L_0x0033:
            if (r2 >= r1) goto L_0x0041
            java.lang.Object r3 = r0.get(r2)
            androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback r3 = (androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback) r3
            r3.onAnimationStart(r4)
            int r2 = r2 + 1
            goto L_0x0033
        L_0x0041:
            r4.invalidateSelf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.transition.CrossfadeDrawable.start():void");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void stop() {
        /*
            r3 = this;
            android.graphics.drawable.Drawable r0 = r3.n
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            r2 = 0
            if (r1 == 0) goto L_0x000a
            android.graphics.drawable.Animatable r0 = (android.graphics.drawable.Animatable) r0
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            if (r0 == 0) goto L_0x0010
            r0.stop()
        L_0x0010:
            android.graphics.drawable.Drawable r0 = r3.o
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            if (r1 == 0) goto L_0x0019
            r2 = r0
            android.graphics.drawable.Animatable r2 = (android.graphics.drawable.Animatable) r2
        L_0x0019:
            if (r2 == 0) goto L_0x001e
            r2.stop()
        L_0x001e:
            int r0 = r3.m
            r1 = 2
            if (r0 == r1) goto L_0x0026
            r3.b()
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.transition.CrossfadeDrawable.stop():void");
    }

    public final boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return this.g.remove(animationCallback);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
