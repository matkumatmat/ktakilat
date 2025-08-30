package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/collections/AbstractMutableSet;", "E", "", "Ljava/util/AbstractSet;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.1")
public abstract class AbstractMutableSet<E> extends AbstractSet<E> implements Set<E>, KMutableSet {
    public abstract int getSize();

    public final /* bridge */ int size() {
        return getSize();
    }
}
