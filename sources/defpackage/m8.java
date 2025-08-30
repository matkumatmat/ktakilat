package defpackage;

import org.apache.commons.lang3.function.FailableLongUnaryOperator;

/* renamed from: m8  reason: default package */
public final /* synthetic */ class m8 implements FailableLongUnaryOperator {
    public final /* synthetic */ int c;
    public final /* synthetic */ FailableLongUnaryOperator d;
    public final /* synthetic */ FailableLongUnaryOperator e;

    public /* synthetic */ m8(FailableLongUnaryOperator failableLongUnaryOperator, FailableLongUnaryOperator failableLongUnaryOperator2, int i) {
        this.c = i;
        this.d = failableLongUnaryOperator;
        this.e = failableLongUnaryOperator2;
    }

    public final /* synthetic */ FailableLongUnaryOperator andThen(FailableLongUnaryOperator failableLongUnaryOperator) {
        int i = this.c;
        return n8.a(this, failableLongUnaryOperator);
    }

    public final long applyAsLong(long j) {
        switch (this.c) {
            case 0:
                return this.e.applyAsLong(this.d.applyAsLong(j));
            default:
                return this.d.applyAsLong(this.e.applyAsLong(j));
        }
    }

    public final /* synthetic */ FailableLongUnaryOperator compose(FailableLongUnaryOperator failableLongUnaryOperator) {
        int i = this.c;
        return n8.b(this, failableLongUnaryOperator);
    }
}
