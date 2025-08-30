package coil3.network;

import coil3.annotation.InternalCoilApi;
import coil3.network.NetworkHeaders;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/network/CacheNetworkResponse;", "", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCacheNetworkResponse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheNetworkResponse.kt\ncoil3/network/CacheNetworkResponse\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
@InternalCoilApi
public final class CacheNetworkResponse {
    public static NetworkResponse a(BufferedSource bufferedSource) {
        int parseInt = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        long parseLong = Long.parseLong(bufferedSource.readUtf8LineStrict());
        long parseLong2 = Long.parseLong(bufferedSource.readUtf8LineStrict());
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        int parseInt2 = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        int i = 0;
        while (i < parseInt2) {
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            int r = StringsKt.r(readUtf8LineStrict, ':', 0, false, 6);
            if (r != -1) {
                String substring = readUtf8LineStrict.substring(0, r);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String obj = StringsKt.Q(substring).toString();
                String substring2 = readUtf8LineStrict.substring(r + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                builder.a(obj, substring2);
                i++;
            } else {
                throw new IllegalArgumentException("Unexpected header: ".concat(readUtf8LineStrict).toString());
            }
        }
        return new NetworkResponse(parseInt, parseLong, parseLong2, builder.b(), (NetworkResponseBody) null, (Object) null);
    }

    public static void b(NetworkResponse networkResponse, BufferedSink bufferedSink) {
        bufferedSink.writeDecimalLong((long) networkResponse.f131a).writeByte(10);
        bufferedSink.writeDecimalLong(networkResponse.b).writeByte(10);
        bufferedSink.writeDecimalLong(networkResponse.c).writeByte(10);
        Set<Map.Entry> entrySet = networkResponse.d.f128a.entrySet();
        int i = 0;
        for (Map.Entry value : entrySet) {
            i += ((List) value.getValue()).size();
        }
        bufferedSink.writeDecimalLong((long) i).writeByte(10);
        for (Map.Entry entry : entrySet) {
            for (String writeUtf8 : (List) entry.getValue()) {
                bufferedSink.writeUtf8((String) entry.getKey()).writeUtf8(":").writeUtf8(writeUtf8).writeByte(10);
            }
        }
    }
}
