package defpackage;

import org.apache.commons.lang3.function.FailableIntPredicate;

/* renamed from: z7  reason: default package */
public final /* synthetic */ class z7 implements FailableIntPredicate {
    public final /* synthetic */ int c;
    public final /* synthetic */ FailableIntPredicate d;
    public final /* synthetic */ FailableIntPredicate e;

    public /* synthetic */ z7(FailableIntPredicate failableIntPredicate, FailableIntPredicate failableIntPredicate2, int i) {
        this.c = i;
        this.d = failableIntPredicate;
        this.e = failableIntPredicate2;
    }

    public final /* synthetic */ FailableIntPredicate and(FailableIntPredicate failableIntPredicate) {
        int i = this.c;
        return a8.a(this, failableIntPredicate);
    }

    public final /* synthetic */ FailableIntPredicate negate() {
        switch (this.c) {
            case 0:
                return a8.b(this);
            default:
                return a8.b(this);
        }
    }

    public final /* synthetic */ FailableIntPredicate or(FailableIntPredicate failableIntPredicate) {
        int i = this.c;
        return a8.c(this, failableIntPredicate);
    }

    public final boolean test(int i) {
        switch (this.c) {
            case 0:
                return a8.d(this.d, this.e, i);
            default:
                return a8.f(this.d, this.e, i);
        }
    }
}
