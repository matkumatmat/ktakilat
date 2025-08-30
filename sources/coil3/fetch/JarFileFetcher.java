package coil3.fetch;

import coil3.RealImageLoader;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.disk.DiskCache;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.util.MimeTypeMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Okio;
import okio.Path;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/JarFileFetcher;", "Lcoil3/fetch/Fetcher;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJarFileFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JarFileFetcher.kt\ncoil3/fetch/JarFileFetcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public final class JarFileFetcher implements Fetcher {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f94a;
    public final Options b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/JarFileFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        public final Fetcher a(Object obj, Options options, RealImageLoader realImageLoader) {
            Uri uri = (Uri) obj;
            if (!Intrinsics.a(uri.c, "jar:file")) {
                return null;
            }
            return new JarFileFetcher(uri, options);
        }
    }

    public JarFileFetcher(Uri uri, Options options) {
        this.f94a = uri;
        this.b = options;
    }

    public final Object a(Continuation continuation) {
        Uri uri = this.f94a;
        String str = uri.e;
        if (str == null) {
            str = "";
        }
        int r = StringsKt.r(str, '!', 0, false, 6);
        if (r != -1) {
            Path.Companion companion = Path.Companion;
            String substring = str.substring(0, r);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Path path = Path.Companion.get$default(companion, substring, false, 1, (Object) null);
            String substring2 = str.substring(r + 1, str.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            Path path2 = Path.Companion.get$default(companion, substring2, false, 1, (Object) null);
            return new SourceFetchResult(ImageSourceKt.a(path2, Okio.openZip(this.b.f, path), (String) null, (DiskCache.Snapshot) null, 28), MimeTypeMap.a(StringsKt.L(path2.name(), ClassUtils.PACKAGE_SEPARATOR_CHAR, "")), DataSource.DISK);
        }
        throw new IllegalStateException(("Invalid jar:file URI: " + uri).toString());
    }
}
