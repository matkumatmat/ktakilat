package coil3;

import coil3.util.Collections_jvmCommonKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/Extras;", "", "Key", "Builder", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Extras {
    public static final Extras b = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    public final Map f53a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/Extras$Companion;", "", "Lcoil3/Extras;", "EMPTY", "Lcoil3/Extras;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/Extras$Key;", "T", "", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Key<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f55a;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/Extras$Key$Companion;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
        }

        public Key(Object obj) {
            this.f55a = obj;
        }
    }

    public Extras(Map map) {
        this.f53a = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Extras) && Intrinsics.a(this.f53a, ((Extras) obj).f53a);
    }

    public final int hashCode() {
        return this.f53a.hashCode();
    }

    public final String toString() {
        return "Extras(data=" + this.f53a + ')';
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/Extras$Builder;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedHashMap f54a;

        public Builder() {
            this.f54a = new LinkedHashMap();
        }

        public final Extras a() {
            return new Extras(Collections_jvmCommonKt.b(this.f54a));
        }

        public final void b(Key key, Object obj) {
            LinkedHashMap linkedHashMap = this.f54a;
            if (obj != null) {
                linkedHashMap.put(key, obj);
            } else {
                linkedHashMap.remove(key);
            }
        }

        public Builder(LinkedHashMap linkedHashMap) {
            this.f54a = MapsKt.i(linkedHashMap);
        }

        public Builder(Extras extras) {
            this.f54a = MapsKt.i(extras.f53a);
        }
    }
}
