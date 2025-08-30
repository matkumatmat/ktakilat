package defpackage;

import java.util.function.Predicate;
import org.apache.commons.lang3.compare.ComparableUtils;

/* renamed from: j3  reason: default package */
public final /* synthetic */ class j3 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f690a;
    public final /* synthetic */ Comparable b;

    public /* synthetic */ j3(Comparable comparable, int i) {
        this.f690a = i;
        this.b = comparable;
    }

    public final boolean test(Object obj) {
        switch (this.f690a) {
            case 0:
                return ComparableUtils.is((Comparable) obj).greaterThanOrEqualTo(this.b);
            case 1:
                return ComparableUtils.is((Comparable) obj).greaterThan(this.b);
            case 2:
                return ComparableUtils.is((Comparable) obj).lessThan(this.b);
            default:
                return ComparableUtils.is((Comparable) obj).lessThanOrEqualTo(this.b);
        }
    }
}
