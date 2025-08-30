package defpackage;

import org.apache.commons.lang3.function.FailableBiPredicate;

/* renamed from: k7  reason: default package */
public final /* synthetic */ class k7 implements FailableBiPredicate {
    public final /* synthetic */ int c;
    public final /* synthetic */ FailableBiPredicate d;
    public final /* synthetic */ FailableBiPredicate e;

    public /* synthetic */ k7(FailableBiPredicate failableBiPredicate, FailableBiPredicate failableBiPredicate2, int i) {
        this.c = i;
        this.d = failableBiPredicate;
        this.e = failableBiPredicate2;
    }

    public final /* synthetic */ FailableBiPredicate and(FailableBiPredicate failableBiPredicate) {
        int i = this.c;
        return l7.a(this, failableBiPredicate);
    }

    public final /* synthetic */ FailableBiPredicate negate() {
        switch (this.c) {
            case 0:
                return l7.b(this);
            default:
                return l7.b(this);
        }
    }

    public final /* synthetic */ FailableBiPredicate or(FailableBiPredicate failableBiPredicate) {
        int i = this.c;
        return l7.c(this, failableBiPredicate);
    }

    public final boolean test(Object obj, Object obj2) {
        switch (this.c) {
            case 0:
                return l7.d(this.d, this.e, obj, obj2);
            default:
                return l7.f(this.d, this.e, obj, obj2);
        }
    }
}
