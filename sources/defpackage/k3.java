package defpackage;

import java.util.function.Predicate;
import org.apache.commons.lang3.compare.ComparableUtils;

/* renamed from: k3  reason: default package */
public final /* synthetic */ class k3 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f691a;
    public final /* synthetic */ Comparable b;
    public final /* synthetic */ Comparable c;

    public /* synthetic */ k3(Comparable comparable, Comparable comparable2, int i) {
        this.f691a = i;
        this.b = comparable;
        this.c = comparable2;
    }

    public final boolean test(Object obj) {
        switch (this.f691a) {
            case 0:
                return ComparableUtils.is((Comparable) obj).between(this.b, this.c);
            default:
                return ComparableUtils.is((Comparable) obj).betweenExclusive(this.b, this.c);
        }
    }
}
