package defpackage;

import org.apache.commons.lang3.function.FailableDoublePredicate;

/* renamed from: p7  reason: default package */
public final /* synthetic */ class p7 implements FailableDoublePredicate {
    public final /* synthetic */ int c;
    public final /* synthetic */ FailableDoublePredicate d;
    public final /* synthetic */ FailableDoublePredicate e;

    public /* synthetic */ p7(FailableDoublePredicate failableDoublePredicate, FailableDoublePredicate failableDoublePredicate2, int i) {
        this.c = i;
        this.d = failableDoublePredicate;
        this.e = failableDoublePredicate2;
    }

    public final /* synthetic */ FailableDoublePredicate and(FailableDoublePredicate failableDoublePredicate) {
        int i = this.c;
        return q7.a(this, failableDoublePredicate);
    }

    public final /* synthetic */ FailableDoublePredicate negate() {
        switch (this.c) {
            case 0:
                return q7.b(this);
            default:
                return q7.b(this);
        }
    }

    public final /* synthetic */ FailableDoublePredicate or(FailableDoublePredicate failableDoublePredicate) {
        int i = this.c;
        return q7.c(this, failableDoublePredicate);
    }

    public final boolean test(double d2) {
        switch (this.c) {
            case 0:
                return q7.f(this.d, this.e, d2);
            default:
                return q7.d(this.d, this.e, d2);
        }
    }
}
