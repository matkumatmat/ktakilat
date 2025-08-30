package defpackage;

import org.apache.commons.lang3.function.FailablePredicate;

/* renamed from: r8  reason: default package */
public final /* synthetic */ class r8 implements FailablePredicate {
    public final /* synthetic */ int c;
    public final /* synthetic */ FailablePredicate d;
    public final /* synthetic */ FailablePredicate e;

    public /* synthetic */ r8(FailablePredicate failablePredicate, FailablePredicate failablePredicate2, int i) {
        this.c = i;
        this.d = failablePredicate;
        this.e = failablePredicate2;
    }

    public final /* synthetic */ FailablePredicate and(FailablePredicate failablePredicate) {
        int i = this.c;
        return s8.a(this, failablePredicate);
    }

    public final /* synthetic */ FailablePredicate negate() {
        switch (this.c) {
            case 0:
                return s8.b(this);
            default:
                return s8.b(this);
        }
    }

    public final /* synthetic */ FailablePredicate or(FailablePredicate failablePredicate) {
        int i = this.c;
        return s8.c(this, failablePredicate);
    }

    public final boolean test(Object obj) {
        switch (this.c) {
            case 0:
                return s8.f(this.d, this.e, obj);
            default:
                return s8.d(this.d, this.e, obj);
        }
    }
}
