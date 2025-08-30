package kotlin.collections;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/collections/AbstractMutableMap;", "K", "V", "", "Ljava/util/AbstractMap;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.1")
public abstract class AbstractMutableMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, KMutableMap {
    public abstract Set a();

    public /* bridge */ Set b() {
        return super.keySet();
    }

    public /* bridge */ int c() {
        return super.size();
    }

    public final /* bridge */ Set entrySet() {
        return a();
    }

    public final /* bridge */ Set keySet() {
        return b();
    }

    public final /* bridge */ int size() {
        return c();
    }
}
