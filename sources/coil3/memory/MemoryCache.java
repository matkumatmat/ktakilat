package coil3.memory;

import coil3.Image;
import coil3.util.Collections_jvmCommonKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcoil3/memory/MemoryCache;", "", "Key", "Value", "Builder", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryCache {

    @SourceDebugExtension({"SMAP\nMemoryCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemoryCache.kt\ncoil3/memory/MemoryCache$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,189:1\n1#2:190\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/memory/MemoryCache$Builder;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public oc f111a;
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/memory/MemoryCache$Key;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Key {

        /* renamed from: a  reason: collision with root package name */
        public final String f112a;
        public final Map b;

        public Key(String str, Map map) {
            this.f112a = str;
            this.b = Collections_jvmCommonKt.b(map);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Key) {
                Key key = (Key) obj;
                if (!Intrinsics.a(this.f112a, key.f112a) || !Intrinsics.a(this.b, key.b)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f112a.hashCode() * 31);
        }

        public final String toString() {
            return "Key(key=" + this.f112a + ", extras=" + this.b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/memory/MemoryCache$Value;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Value {

        /* renamed from: a  reason: collision with root package name */
        public final Image f113a;
        public final Map b;

        public Value(Image image, Map map) {
            this.f113a = image;
            this.b = Collections_jvmCommonKt.b(map);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Value) {
                Value value = (Value) obj;
                if (!Intrinsics.a(this.f113a, value.f113a) || !Intrinsics.a(this.b, value.b)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f113a.hashCode() * 31);
        }

        public final String toString() {
            return "Value(image=" + this.f113a + ", extras=" + this.b + ')';
        }
    }

    Value a(Key key);

    void b(long j);

    void c(Key key, Value value);

    void clear();

    long getSize();
}
