package coil3.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil3.decode.DecodeUtils;
import coil3.size.Scale;
import coil3.util.BitmapsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/gif/MovieDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", "Companion", "coil-gif_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMovieDrawable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieDrawable.kt\ncoil3/gif/MovieDrawable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Canvas.kt\nandroidx/core/graphics/CanvasKt\n+ 4 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,289:1\n1#2:290\n30#3,7:291\n30#3,7:298\n30#3,7:305\n95#4:312\n*S KotlinDebug\n*F\n+ 1 MovieDrawable.kt\ncoil3/gif/MovieDrawable\n*L\n75#1:291,7\n127#1:298,7\n134#1:305,7\n226#1:312\n*E\n"})
public final class MovieDrawable extends Drawable implements Animatable2Compat {
    public final Movie c;
    public final Bitmap.Config d;
    public final Scale e;
    public final Paint f = new Paint(3);
    public final ArrayList g = new ArrayList();
    public final Rect i = new Rect();
    public final Rect j = new Rect();
    public Canvas k;
    public Bitmap l;
    public float m = 1.0f;
    public float n = 1.0f;
    public float o;
    public float p;
    public boolean q;
    public long r;
    public long s;
    public int t = -1;
    public AnimatedTransformation u;
    public Picture v;
    public PixelOpacity w = PixelOpacity.UNCHANGED;
    public boolean x;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/gif/MovieDrawable$Companion;", "", "", "REPEAT_INFINITE", "I", "coil-gif_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    public MovieDrawable(Movie movie, Bitmap.Config config, Scale scale) {
        this.c = movie;
        this.d = config;
        this.e = scale;
        if (BitmapsKt.a(config)) {
            throw new IllegalArgumentException("Bitmap config must not be hardware.");
        }
    }

    /* JADX INFO: finally extract failed */
    public final void a(Canvas canvas) {
        Canvas canvas2 = this.k;
        Bitmap bitmap = this.l;
        if (canvas2 != null && bitmap != null) {
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            int save = canvas2.save();
            try {
                float f2 = this.m;
                canvas2.scale(f2, f2);
                Movie movie = this.c;
                Paint paint = this.f;
                movie.draw(canvas2, 0.0f, 0.0f, paint);
                Picture picture = this.v;
                if (picture != null) {
                    picture.draw(canvas2);
                }
                canvas2.restoreToCount(save);
                int save2 = canvas.save();
                try {
                    canvas.translate(this.o, this.p);
                    float f3 = this.n;
                    canvas.scale(f3, f3);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                } finally {
                    canvas.restoreToCount(save2);
                }
            } catch (Throwable th) {
                canvas2.restoreToCount(save);
                throw th;
            }
        }
    }

    public final void b(Rect rect) {
        Rect rect2 = this.i;
        if (!Intrinsics.a(rect2, rect)) {
            rect2.set(rect);
            int width = rect.width();
            int height = rect.height();
            Movie movie = this.c;
            int width2 = movie.width();
            int height2 = movie.height();
            if (width2 > 0 && height2 > 0) {
                Scale scale = this.e;
                double b = DecodeUtils.b(width2, height2, width, height, scale);
                if (!this.x && b > 1.0d) {
                    b = 1.0d;
                }
                float f2 = (float) b;
                this.m = f2;
                int i2 = (int) (((float) width2) * f2);
                int i3 = (int) (f2 * ((float) height2));
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, this.d);
                Bitmap bitmap = this.l;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                this.l = createBitmap;
                this.k = new Canvas(createBitmap);
                if (this.x) {
                    this.n = 1.0f;
                    this.o = 0.0f;
                    this.p = 0.0f;
                    return;
                }
                float b2 = (float) DecodeUtils.b(i2, i3, width, height, scale);
                this.n = b2;
                float f3 = ((float) width) - (((float) i2) * b2);
                float f4 = (float) 2;
                this.o = (f3 / f4) + ((float) rect.left);
                this.p = ((((float) height) - (b2 * ((float) i3))) / f4) + ((float) rect.top);
            }
        }
    }

    public final void clearAnimationCallbacks() {
        this.g.clear();
    }

    public final void draw(Canvas canvas) {
        boolean z;
        Movie movie = this.c;
        int duration = movie.duration();
        if (duration == 0) {
            duration = 0;
            z = false;
        } else {
            if (this.q) {
                this.s = SystemClock.uptimeMillis();
            }
            int i2 = (int) (this.s - this.r);
            int i3 = i2 / duration;
            int i4 = this.t;
            if (i4 == -1 || i3 <= i4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                duration = i2 - (i3 * duration);
            }
        }
        movie.setTime(duration);
        if (this.x) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            Rect rect = this.j;
            rect.set(0, 0, width, height);
            b(rect);
            int save = canvas.save();
            try {
                float f2 = ((float) 1) / this.m;
                canvas.scale(f2, f2);
                a(canvas);
            } finally {
                canvas.restoreToCount(save);
            }
        } else {
            b(getBounds());
            a(canvas);
        }
        if (!this.q || !z) {
            stop();
        } else {
            invalidateSelf();
        }
    }

    public final int getIntrinsicHeight() {
        return this.c.height();
    }

    public final int getIntrinsicWidth() {
        return this.c.width();
    }

    public final int getOpacity() {
        PixelOpacity pixelOpacity;
        if (this.f.getAlpha() != 255 || ((pixelOpacity = this.w) != PixelOpacity.OPAQUE && (pixelOpacity != PixelOpacity.UNCHANGED || !this.c.isOpaque()))) {
            return -3;
        }
        return -1;
    }

    public final boolean isRunning() {
        return this.q;
    }

    public final void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.g.add(animationCallback);
    }

    public final void setAlpha(int i2) {
        if (i2 < 0 || i2 >= 256) {
            throw new IllegalArgumentException(ba.k(i2, "Invalid alpha: ").toString());
        }
        this.f.setAlpha(i2);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f.setColorFilter(colorFilter);
    }

    public final void start() {
        if (!this.q) {
            this.q = true;
            this.r = SystemClock.uptimeMillis();
            ArrayList arrayList = this.g;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((Animatable2Compat.AnimationCallback) arrayList.get(i2)).onAnimationStart(this);
            }
            invalidateSelf();
        }
    }

    public final void stop() {
        if (this.q) {
            this.q = false;
            ArrayList arrayList = this.g;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((Animatable2Compat.AnimationCallback) arrayList.get(i2)).onAnimationEnd(this);
            }
        }
    }

    public final boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return this.g.remove(animationCallback);
    }
}
