package coil3.network.internal;

import coil3.network.CacheStrategy;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkResponse;
import coil3.network.NetworkResponseBody;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/network/internal/DefaultCacheStrategy;", "Lcoil3/network/CacheStrategy;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultCacheStrategy implements CacheStrategy {
    public final CacheStrategy.ReadResult a(NetworkResponse networkResponse) {
        return new CacheStrategy.ReadResult(networkResponse);
    }

    public final CacheStrategy.WriteResult b(NetworkResponse networkResponse, NetworkResponse networkResponse2) {
        if (networkResponse2.f131a != 304 || networkResponse == null) {
            return new CacheStrategy.WriteResult(networkResponse2);
        }
        NetworkHeaders networkHeaders = networkResponse.d;
        networkHeaders.getClass();
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder(networkHeaders);
        for (Map.Entry entry : networkResponse2.d.f128a.entrySet()) {
            String lowerCase = ((String) entry.getKey()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            builder.f129a.put(lowerCase, CollectionsKt.E((List) entry.getValue()));
        }
        return new CacheStrategy.WriteResult(new NetworkResponse(networkResponse2.f131a, networkResponse2.b, networkResponse2.c, builder.b(), (NetworkResponseBody) null, networkResponse2.f));
    }
}
