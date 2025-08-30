package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/memory/EmptyStrongMemoryCache;", "Lcoil3/memory/StrongMemoryCache;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EmptyStrongMemoryCache implements StrongMemoryCache {

    /* renamed from: a  reason: collision with root package name */
    public final RealWeakMemoryCache f110a;

    public EmptyStrongMemoryCache(RealWeakMemoryCache realWeakMemoryCache) {
        this.f110a = realWeakMemoryCache;
    }

    public final MemoryCache.Value a(MemoryCache.Key key) {
        return null;
    }

    public final void b(long j) {
    }

    public final boolean c(MemoryCache.Key key) {
        return false;
    }

    public final void clear() {
    }

    public final void d(MemoryCache.Key key, Image image, Map map, long j) {
        this.f110a.b(key, image, map, j);
    }

    public final long getSize() {
        return 0;
    }
}
