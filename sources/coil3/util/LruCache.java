package coil3.util;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcoil3/util/LruCache;", "", "K", "V", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\ncoil3/util/LruCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1#2:98\n*E\n"})
public class LruCache<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final long f158a;
    public final LinkedHashMap b = new LinkedHashMap(0, 0.75f, true);
    public long c;

    public LruCache(long j) {
        this.f158a = j;
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    public void a(Object obj, Object obj2, Object obj3) {
    }

    public final long b() {
        if (this.c == -1) {
            long j = 0;
            for (Map.Entry entry : this.b.entrySet()) {
                j += c(entry.getKey(), entry.getValue());
            }
            this.c = j;
        }
        return this.c;
    }

    public final long c(Object obj, Object obj2) {
        try {
            long d = d(obj, obj2);
            if (d >= 0) {
                return d;
            }
            throw new IllegalStateException(("sizeOf(" + obj + ", " + obj2 + ") returned a negative value: " + d).toString());
        } catch (Exception e) {
            this.c = -1;
            throw e;
        }
    }

    public long d(Object obj, Object obj2) {
        return 1;
    }

    public final void e(long j) {
        while (b() > j) {
            LinkedHashMap linkedHashMap = this.b;
            if (!linkedHashMap.isEmpty()) {
                Map.Entry entry = (Map.Entry) CollectionsKt.l(linkedHashMap.entrySet());
                Object key = entry.getKey();
                Object value = entry.getValue();
                linkedHashMap.remove(key);
                this.c = b() - c(key, value);
                a(key, value, (Object) null);
            } else if (b() != 0) {
                throw new IllegalStateException("sizeOf() is returning inconsistent values");
            } else {
                return;
            }
        }
    }
}
