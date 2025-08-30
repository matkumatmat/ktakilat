package coil3.network;

import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/network/NetworkHeaders;", "", "Builder", "Companion", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkHeaders {
    public static final NetworkHeaders b = new Builder().b();

    /* renamed from: a  reason: collision with root package name */
    public final Map f128a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/network/NetworkHeaders$Companion;", "", "Lcoil3/network/NetworkHeaders;", "EMPTY", "Lcoil3/network/NetworkHeaders;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    public NetworkHeaders(Map map) {
        this.f128a = map;
    }

    public final String a() {
        String lowerCase = HttpHeaders.CONTENT_TYPE.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List list = (List) this.f128a.get(lowerCase);
        if (list != null) {
            return (String) CollectionsKt.r(list);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NetworkHeaders) && Intrinsics.a(this.f128a, ((NetworkHeaders) obj).f128a);
    }

    public final int hashCode() {
        return this.f128a.hashCode();
    }

    public final String toString() {
        return "NetworkHeaders(data=" + this.f128a + ')';
    }

    @SourceDebugExtension({"SMAP\nNetworkHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkHeaders.kt\ncoil3/network/NetworkHeaders$Builder\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,61:1\n412#2:62\n381#2,7:67\n1246#3,4:63\n*S KotlinDebug\n*F\n+ 1 NetworkHeaders.kt\ncoil3/network/NetworkHeaders$Builder\n*L\n36#1:62\n48#1:67,7\n36#1:63,4\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/network/NetworkHeaders$Builder;", "", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashMap f129a;

        public Builder() {
            this.f129a = new LinkedHashMap();
        }

        public final void a(String str, String str2) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            LinkedHashMap linkedHashMap = this.f129a;
            Object obj = linkedHashMap.get(lowerCase);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(lowerCase, obj);
            }
            ((List) obj).add(str2);
        }

        public final NetworkHeaders b() {
            return new NetworkHeaders(MapsKt.h(this.f129a));
        }

        public final void c(String str) {
            String lowerCase = HttpHeaders.CACHE_CONTROL.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            this.f129a.put(lowerCase, CollectionsKt.u(str));
        }

        public Builder(NetworkHeaders networkHeaders) {
            Map map = networkHeaders.f128a;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), CollectionsKt.E((Collection) entry.getValue()));
            }
            this.f129a = linkedHashMap;
        }
    }
}
