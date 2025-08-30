package coil3.network.okhttp.internal;

import coil3.Uri;
import coil3.fetch.Fetcher;
import coil3.network.NetworkFetcher;
import coil3.util.FetcherServiceLoaderTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcoil3/network/okhttp/internal/OkHttpNetworkFetcherServiceLoaderTarget;", "Lcoil3/util/FetcherServiceLoaderTarget;", "Lcoil3/Uri;", "<init>", "()V", "Lkotlin/reflect/KClass;", "type", "()Lkotlin/reflect/KClass;", "", "priority", "()I", "coil-network-okhttp"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OkHttpNetworkFetcherServiceLoaderTarget implements FetcherServiceLoaderTarget<Uri> {
    public Fetcher.Factory factory() {
        return new NetworkFetcher.Factory(new q0(18));
    }

    public int priority() {
        return 2;
    }

    public KClass type() {
        return Reflection.a(Uri.class);
    }
}
