package coil3.memory;

import coil3.memory.MemoryCache;
import coil3.memory.RealStrongMemoryCache;
import coil3.util.LruCache;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"coil3/memory/RealStrongMemoryCache$cache$1", "Lcoil3/util/LruCache;", "Lcoil3/memory/MemoryCache$Key;", "Lcoil3/memory/RealStrongMemoryCache$InternalValue;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealStrongMemoryCache$cache$1 extends LruCache<MemoryCache.Key, RealStrongMemoryCache.InternalValue> {
    public final /* synthetic */ RealStrongMemoryCache d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealStrongMemoryCache$cache$1(long j, RealStrongMemoryCache realStrongMemoryCache) {
        super(j);
        this.d = realStrongMemoryCache;
    }

    public final void a(Object obj, Object obj2, Object obj3) {
        RealStrongMemoryCache.InternalValue internalValue = (RealStrongMemoryCache.InternalValue) obj2;
        this.d.f117a.b((MemoryCache.Key) obj, internalValue.f118a, internalValue.b, internalValue.c);
    }

    public final long d(Object obj, Object obj2) {
        MemoryCache.Key key = (MemoryCache.Key) obj;
        return ((RealStrongMemoryCache.InternalValue) obj2).c;
    }
}
