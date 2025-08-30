package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import coil3.memory.RealWeakMemoryCache;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/memory/RealMemoryCache;", "Lcoil3/memory/MemoryCache;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRealMemoryCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealMemoryCache.kt\ncoil3/memory/RealMemoryCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,64:1\n1#2:65\n*E\n"})
public final class RealMemoryCache implements MemoryCache {

    /* renamed from: a  reason: collision with root package name */
    public final StrongMemoryCache f116a;
    public final RealWeakMemoryCache b;
    public final Object c = new Object();

    public RealMemoryCache(StrongMemoryCache strongMemoryCache, RealWeakMemoryCache realWeakMemoryCache) {
        this.f116a = strongMemoryCache;
        this.b = realWeakMemoryCache;
    }

    public final MemoryCache.Value a(MemoryCache.Key key) {
        MemoryCache.Value a2;
        MemoryCache.Value value;
        synchronized (this.c) {
            try {
                a2 = this.f116a.a(key);
                if (a2 == null) {
                    RealWeakMemoryCache realWeakMemoryCache = this.b;
                    ArrayList arrayList = (ArrayList) realWeakMemoryCache.f119a.get(key);
                    MemoryCache.Value value2 = null;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                break;
                            }
                            RealWeakMemoryCache.InternalValue internalValue = (RealWeakMemoryCache.InternalValue) arrayList.get(i);
                            Image image = (Image) internalValue.f120a.get();
                            if (image != null) {
                                value = new MemoryCache.Value(image, internalValue.b);
                            } else {
                                value = null;
                            }
                            if (value != null) {
                                value2 = value;
                                break;
                            }
                            i++;
                        }
                        realWeakMemoryCache.a();
                    }
                    a2 = value2;
                }
                if (a2 != null && !a2.f113a.a()) {
                    d(key);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public final void b(long j) {
        synchronized (this.c) {
            this.f116a.b(j);
            Unit unit = Unit.f696a;
        }
    }

    public final void c(MemoryCache.Key key, MemoryCache.Value value) {
        synchronized (this.c) {
            long size = value.f113a.getSize();
            if (size >= 0) {
                this.f116a.d(key, value.f113a, value.b, size);
                Unit unit = Unit.f696a;
            } else {
                throw new IllegalStateException(("Image size must be non-negative: " + size).toString());
            }
        }
    }

    public final void clear() {
        synchronized (this.c) {
            this.f116a.clear();
            RealWeakMemoryCache realWeakMemoryCache = this.b;
            realWeakMemoryCache.b = 0;
            realWeakMemoryCache.f119a.clear();
            Unit unit = Unit.f696a;
        }
    }

    public final void d(MemoryCache.Key key) {
        synchronized (this.c) {
            boolean c2 = this.f116a.c(key);
            if (this.b.f119a.remove(key) != null) {
            }
        }
    }

    public final long getSize() {
        long size;
        synchronized (this.c) {
            size = this.f116a.getSize();
        }
        return size;
    }
}
