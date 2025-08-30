package coil3.fetch;

import android.graphics.Bitmap;
import coil3.RealImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.disk.DiskCache;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.util.MimeTypeMap;
import coil3.util.UtilsKt;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Path;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/FileUriFetcher;", "Lcoil3/fetch/Fetcher;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileUriFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileUriFetcher.kt\ncoil3/fetch/FileUriFetcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n1#2:40\n*E\n"})
public final class FileUriFetcher implements Fetcher {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f92a;
    public final Options b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/FileUriFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        public final Fetcher a(Object obj, Options options, RealImageLoader realImageLoader) {
            Uri uri = (Uri) obj;
            Function1 function1 = UtilsKt.f161a;
            String str = uri.c;
            if ((str == null || str.equals("file")) && uri.e != null) {
                Bitmap.Config[] configArr = Utils_androidKt.f162a;
                if (!Intrinsics.a(uri.c, "file") || !Intrinsics.a(CollectionsKt.firstOrNull(UriKt.c(uri)), "android_asset")) {
                    return new FileUriFetcher(uri, options);
                }
            }
            return null;
        }
    }

    public FileUriFetcher(Uri uri, Options options) {
        this.f92a = uri;
        this.b = options;
    }

    public final Object a(Continuation continuation) {
        Path.Companion companion = Path.Companion;
        String b2 = UriKt.b(this.f92a);
        if (b2 != null) {
            Path path = Path.Companion.get$default(companion, b2, false, 1, (Object) null);
            return new SourceFetchResult(ImageSourceKt.a(path, this.b.f, (String) null, (DiskCache.Snapshot) null, 28), MimeTypeMap.a(StringsKt.L(path.name(), ClassUtils.PACKAGE_SEPARATOR_CHAR, "")), DataSource.DISK);
        }
        throw new IllegalStateException("filePath == null");
    }
}
