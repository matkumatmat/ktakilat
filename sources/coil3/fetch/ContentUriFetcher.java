package coil3.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import coil3.RealImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.ContentMetadata;
import coil3.decode.DataSource;
import coil3.decode.SourceImageSource;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.size.Dimension;
import coil3.size.Size;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Okio;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/ContentUriFetcher;", "Lcoil3/fetch/Fetcher;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContentUriFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentUriFetcher.kt\ncoil3/fetch/ContentUriFetcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1#2:104\n*E\n"})
public final class ContentUriFetcher implements Fetcher {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f90a;
    public final Options b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/ContentUriFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        public final Fetcher a(Object obj, Options options, RealImageLoader realImageLoader) {
            Uri uri = (Uri) obj;
            if (!Intrinsics.a(uri.c, FirebaseAnalytics.Param.CONTENT)) {
                return null;
            }
            return new ContentUriFetcher(uri, options);
        }
    }

    public ContentUriFetcher(Uri uri, Options options) {
        this.f90a = uri;
        this.b = options;
    }

    public final Object a(Continuation continuation) {
        AssetFileDescriptor assetFileDescriptor;
        List c;
        int size;
        Dimension.Pixels pixels;
        Dimension.Pixels pixels2;
        Uri uri = this.f90a;
        android.net.Uri parse = android.net.Uri.parse(uri.f65a);
        Options options = this.b;
        ContentResolver contentResolver = options.f145a.getContentResolver();
        String str = uri.d;
        if (Intrinsics.a(str, "com.android.contacts") && Intrinsics.a(CollectionsKt.r(UriKt.c(uri)), "display_photo")) {
            assetFileDescriptor = contentResolver.openAssetFileDescriptor(parse, "r");
            if (assetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + parse + "'.").toString());
            }
        } else if (Build.VERSION.SDK_INT < 29 || !Intrinsics.a(str, "media") || (size = (c = UriKt.c(uri)).size()) < 3 || !Intrinsics.a(c.get(size - 3), "audio") || !Intrinsics.a(c.get(size - 2), "albums")) {
            assetFileDescriptor = contentResolver.openAssetFileDescriptor(parse, "r");
            if (assetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to open '" + parse + "'.").toString());
            }
        } else {
            Size size2 = options.b;
            Dimension dimension = size2.f150a;
            Bundle bundle = null;
            if (dimension instanceof Dimension.Pixels) {
                pixels = (Dimension.Pixels) dimension;
            } else {
                pixels = null;
            }
            if (pixels != null) {
                Dimension dimension2 = size2.b;
                if (dimension2 instanceof Dimension.Pixels) {
                    pixels2 = (Dimension.Pixels) dimension2;
                } else {
                    pixels2 = null;
                }
                if (pixels2 != null) {
                    bundle = new Bundle(1);
                    bundle.putParcelable("android.content.extra.SIZE", new Point(pixels.f148a, pixels2.f148a));
                }
            }
            assetFileDescriptor = contentResolver.openTypedAssetFile(parse, "image/*", bundle, (CancellationSignal) null);
            if (assetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + parse + "'.").toString());
            }
        }
        return new SourceFetchResult(new SourceImageSource(Okio.buffer(Okio.source((InputStream) assetFileDescriptor.createInputStream())), options.f, new ContentMetadata(assetFileDescriptor)), contentResolver.getType(parse), DataSource.DISK);
    }
}
