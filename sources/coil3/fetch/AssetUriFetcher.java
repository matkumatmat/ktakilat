package coil3.fetch;

import android.graphics.Bitmap;
import coil3.RealImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.AssetMetadata;
import coil3.decode.DataSource;
import coil3.decode.SourceImageSource;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.util.MimeTypeMap;
import coil3.util.Utils_androidKt;
import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/AssetUriFetcher;", "Lcoil3/fetch/Fetcher;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AssetUriFetcher implements Fetcher {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f86a;
    public final Options b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/AssetUriFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        public final Fetcher a(Object obj, Options options, RealImageLoader realImageLoader) {
            Uri uri = (Uri) obj;
            Bitmap.Config[] configArr = Utils_androidKt.f162a;
            if (!Intrinsics.a(uri.c, "file") || !Intrinsics.a(CollectionsKt.firstOrNull(UriKt.c(uri)), "android_asset")) {
                return null;
            }
            return new AssetUriFetcher(uri, options);
        }
    }

    public AssetUriFetcher(Uri uri, Options options) {
        this.f86a = uri;
        this.b = options;
    }

    public final Object a(Continuation continuation) {
        String p = CollectionsKt.p(CollectionsKt.j(UriKt.c(this.f86a)), RemoteSettings.FORWARD_SLASH_STRING, (String) null, (String) null, (Function1) null, 62);
        Options options = this.b;
        return new SourceFetchResult(new SourceImageSource(Okio.buffer(Okio.source(options.f145a.getAssets().open(p))), options.f, new AssetMetadata(p)), MimeTypeMap.b(p), DataSource.DISK);
    }
}
