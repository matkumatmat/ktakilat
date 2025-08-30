package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/memory/RealStrongMemoryCache;", "Lcoil3/memory/StrongMemoryCache;", "InternalValue", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStrongMemoryCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StrongMemoryCache.kt\ncoil3/memory/RealStrongMemoryCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,121:1\n1#2:122\n*E\n"})
public final class RealStrongMemoryCache implements StrongMemoryCache {

    /* renamed from: a  reason: collision with root package name */
    public final RealWeakMemoryCache f117a;
    public final RealStrongMemoryCache$cache$1 b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/memory/RealStrongMemoryCache$InternalValue;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InternalValue {

        /* renamed from: a  reason: collision with root package name */
        public final Image f118a;
        public final Map b;
        public final long c;

        public InternalValue(Image image, Map map, long j) {
            this.f118a = image;
            this.b = map;
            this.c = j;
        }
    }

    public RealStrongMemoryCache(long j, RealWeakMemoryCache realWeakMemoryCache) {
        this.f117a = realWeakMemoryCache;
        this.b = new RealStrongMemoryCache$cache$1(j, this);
    }

    public final MemoryCache.Value a(MemoryCache.Key key) {
        InternalValue internalValue = (InternalValue) this.b.b.get(key);
        if (internalValue != null) {
            return new MemoryCache.Value(internalValue.f118a, internalValue.b);
        }
        return null;
    }

    public final void b(long j) {
        this.b.e(j);
    }

    public final boolean c(MemoryCache.Key key) {
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = this.b;
        Object remove = realStrongMemoryCache$cache$1.b.remove(key);
        if (remove != null) {
            realStrongMemoryCache$cache$1.c = realStrongMemoryCache$cache$1.b() - realStrongMemoryCache$cache$1.c(key, remove);
            realStrongMemoryCache$cache$1.a(key, remove, (Object) null);
        }
        if (remove != null) {
            return true;
        }
        return false;
    }

    public final void clear() {
        this.b.e(-1);
    }

    public final void d(MemoryCache.Key key, Image image, Map map, long j) {
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = this.b;
        long j2 = realStrongMemoryCache$cache$1.f158a;
        LinkedHashMap linkedHashMap = realStrongMemoryCache$cache$1.b;
        if (j <= j2) {
            InternalValue internalValue = new InternalValue(image, map, j);
            Object put = linkedHashMap.put(key, internalValue);
            realStrongMemoryCache$cache$1.c = realStrongMemoryCache$cache$1.c(key, internalValue) + realStrongMemoryCache$cache$1.b();
            if (put != null) {
                realStrongMemoryCache$cache$1.c = realStrongMemoryCache$cache$1.b() - realStrongMemoryCache$cache$1.c(key, put);
                realStrongMemoryCache$cache$1.a(key, put, internalValue);
            }
            realStrongMemoryCache$cache$1.e(realStrongMemoryCache$cache$1.f158a);
            return;
        }
        Object remove = linkedHashMap.remove(key);
        if (remove != null) {
            realStrongMemoryCache$cache$1.c = realStrongMemoryCache$cache$1.b() - realStrongMemoryCache$cache$1.c(key, remove);
            realStrongMemoryCache$cache$1.a(key, remove, (Object) null);
        }
        this.f117a.b(key, image, map, j);
    }

    public final long getSize() {
        return this.b.b();
    }
}
