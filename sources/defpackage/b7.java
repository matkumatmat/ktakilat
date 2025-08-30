package defpackage;

import java.util.function.BiPredicate;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBiPredicate;

/* renamed from: b7  reason: default package */
public final /* synthetic */ class b7 implements BiPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f372a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b7(Object obj, int i) {
        this.f372a = i;
        this.b = obj;
    }

    public final boolean test(Object obj, Object obj2) {
        switch (this.f372a) {
            case 0:
                return Failable.test((FailableBiPredicate) this.b, obj, obj2);
            default:
                return Functions.test((Functions.FailableBiPredicate) this.b, obj, obj2);
        }
    }
}
