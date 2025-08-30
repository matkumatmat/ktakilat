package coil3.fetch;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil3.Image_androidKt;
import coil3.RealImageLoader;
import coil3.decode.DataSource;
import coil3.fetch.Fetcher;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.util.DrawableUtils;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/DrawableFetcher;", "Lcoil3/fetch/Fetcher;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDrawableFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DrawableFetcher.kt\ncoil3/fetch/DrawableFetcher\n+ 2 bitmaps.kt\ncoil3/util/BitmapsKt\n+ 3 BitmapDrawable.kt\nandroidx/core/graphics/drawable/BitmapDrawableKt\n*L\n1#1,45:1\n51#2:46\n28#3:47\n*S KotlinDebug\n*F\n+ 1 DrawableFetcher.kt\ncoil3/fetch/DrawableFetcher\n*L\n29#1:46\n29#1:47\n*E\n"})
public final class DrawableFetcher implements Fetcher {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f91a;
    public final Options b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/DrawableFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Landroid/graphics/drawable/Drawable;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Drawable> {
        public final Fetcher a(Object obj, Options options, RealImageLoader realImageLoader) {
            return new DrawableFetcher((Drawable) obj, options);
        }
    }

    public DrawableFetcher(Drawable drawable, Options options) {
        this.f91a = drawable;
        this.b = options;
    }

    public final Object a(Continuation continuation) {
        boolean z;
        Bitmap.Config[] configArr = Utils_androidKt.f162a;
        Drawable drawable = this.f91a;
        boolean z2 = true;
        if ((drawable instanceof VectorDrawable) || (drawable instanceof VectorDrawableCompat)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Options options = this.b;
            Bitmap.Config a2 = ImageRequests_androidKt.a(options);
            if (options.d != Precision.INEXACT) {
                z2 = false;
            }
            drawable = new BitmapDrawable(options.f145a.getResources(), DrawableUtils.a(drawable, a2, options.b, options.c, z2));
        }
        return new ImageFetchResult(Image_androidKt.b(drawable), z, DataSource.MEMORY);
    }
}
