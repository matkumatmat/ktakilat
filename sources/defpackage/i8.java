package defpackage;

import org.apache.commons.lang3.function.FailableLongPredicate;

/* renamed from: i8  reason: default package */
public final /* synthetic */ class i8 implements FailableLongPredicate {
    public final /* synthetic */ int c;
    public final /* synthetic */ FailableLongPredicate d;
    public final /* synthetic */ FailableLongPredicate e;

    public /* synthetic */ i8(FailableLongPredicate failableLongPredicate, FailableLongPredicate failableLongPredicate2, int i) {
        this.c = i;
        this.d = failableLongPredicate;
        this.e = failableLongPredicate2;
    }

    public final /* synthetic */ FailableLongPredicate and(FailableLongPredicate failableLongPredicate) {
        int i = this.c;
        return j8.a(this, failableLongPredicate);
    }

    public final /* synthetic */ FailableLongPredicate negate() {
        switch (this.c) {
            case 0:
                return j8.b(this);
            default:
                return j8.b(this);
        }
    }

    public final /* synthetic */ FailableLongPredicate or(FailableLongPredicate failableLongPredicate) {
        int i = this.c;
        return j8.c(this, failableLongPredicate);
    }

    public final boolean test(long j) {
        switch (this.c) {
            case 0:
                return j8.d(this.d, this.e, j);
            default:
                return j8.f(this.d, this.e, j);
        }
    }
}
