package coil3.fetch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil3.ExtrasKt;
import coil3.Image_androidKt;
import coil3.RealImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.DataSource;
import coil3.decode.ResourceMetadata;
import coil3.decode.SourceImageSource;
import coil3.fetch.Fetcher;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.util.DrawableUtils;
import coil3.util.MimeTypeMap;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Okio;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/ResourceUriFetcher;", "Lcoil3/fetch/Fetcher;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nResourceUriFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResourceUriFetcher.kt\ncoil3/fetch/ResourceUriFetcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 bitmaps.kt\ncoil3/util/BitmapsKt\n+ 4 BitmapDrawable.kt\nandroidx/core/graphics/drawable/BitmapDrawableKt\n*L\n1#1,99:1\n1#2:100\n51#3:101\n28#4:102\n*S KotlinDebug\n*F\n+ 1 ResourceUriFetcher.kt\ncoil3/fetch/ResourceUriFetcher\n*L\n61#1:101\n61#1:102\n*E\n"})
public final class ResourceUriFetcher implements Fetcher {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f95a;
    public final Options b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/ResourceUriFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        public final Fetcher a(Object obj, Options options, RealImageLoader realImageLoader) {
            Uri uri = (Uri) obj;
            if (!Intrinsics.a(uri.c, "android.resource")) {
                return null;
            }
            return new ResourceUriFetcher(uri, options);
        }
    }

    public ResourceUriFetcher(Uri uri, Options options) {
        this.f95a = uri;
        this.b = options;
    }

    public final Object a(Continuation continuation) {
        Integer intOrNull;
        Resources resources;
        BitmapDrawable bitmapDrawable;
        boolean z;
        Drawable createFromXmlInner;
        Uri uri = this.f95a;
        String str = uri.d;
        if (str != null) {
            if (StringsKt.t(str)) {
                str = null;
            }
            if (str != null) {
                String str2 = (String) CollectionsKt.r(UriKt.c(uri));
                if (str2 == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) {
                    throw new IllegalStateException("Invalid android.resource URI: " + uri);
                }
                int intValue = intOrNull.intValue();
                Options options = this.b;
                Context context = options.f145a;
                if (str.equals(context.getPackageName())) {
                    resources = context.getResources();
                } else {
                    resources = context.getPackageManager().getResourcesForApplication(str);
                }
                TypedValue typedValue = new TypedValue();
                boolean z2 = true;
                resources.getValue(intValue, typedValue, true);
                String b2 = MimeTypeMap.b(typedValue.string.toString());
                if (Intrinsics.a(b2, "text/xml")) {
                    if (str.equals(context.getPackageName())) {
                        bitmapDrawable = AppCompatResources.getDrawable(context, intValue);
                        if (bitmapDrawable == null) {
                            throw new IllegalStateException(ba.k(intValue, "Invalid resource ID: ").toString());
                        }
                    } else {
                        XmlResourceParser xml = resources.getXml(intValue);
                        int next = xml.next();
                        while (next != 2 && next != 1) {
                            next = xml.next();
                        }
                        if (next == 2) {
                            if (Build.VERSION.SDK_INT < 24) {
                                String name = xml.getName();
                                if (Intrinsics.a(name, "vector")) {
                                    createFromXmlInner = VectorDrawableCompat.createFromXmlInner(resources, xml, Xml.asAttributeSet(xml), context.getTheme());
                                } else if (Intrinsics.a(name, "animated-vector")) {
                                    createFromXmlInner = AnimatedVectorDrawableCompat.createFromXmlInner(context, resources, xml, Xml.asAttributeSet(xml), context.getTheme());
                                }
                                bitmapDrawable = createFromXmlInner;
                            }
                            bitmapDrawable = ResourcesCompat.getDrawable(resources, intValue, context.getTheme());
                            if (bitmapDrawable == null) {
                                throw new IllegalStateException(ba.k(intValue, "Invalid resource ID: ").toString());
                            }
                        } else {
                            throw new XmlPullParserException("No start tag found.");
                        }
                    }
                    Bitmap.Config[] configArr = Utils_androidKt.f162a;
                    if ((bitmapDrawable instanceof VectorDrawable) || (bitmapDrawable instanceof VectorDrawableCompat)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        Bitmap.Config config = (Bitmap.Config) ExtrasKt.b(options, ImageRequests_androidKt.c);
                        if (options.d != Precision.INEXACT) {
                            z2 = false;
                        }
                        bitmapDrawable = new BitmapDrawable(context.getResources(), DrawableUtils.a(bitmapDrawable, config, options.b, options.c, z2));
                    }
                    return new ImageFetchResult(Image_androidKt.b(bitmapDrawable), z, DataSource.DISK);
                }
                return new SourceFetchResult(new SourceImageSource(Okio.buffer(Okio.source(resources.openRawResource(intValue, new TypedValue()))), options.f, new ResourceMetadata(str, intValue)), b2, DataSource.DISK);
            }
        }
        throw new IllegalStateException("Invalid android.resource URI: " + uri);
    }
}
