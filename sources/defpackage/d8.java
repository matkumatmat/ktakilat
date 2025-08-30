package defpackage;

import org.apache.commons.lang3.function.FailableIntUnaryOperator;

/* renamed from: d8  reason: default package */
public final /* synthetic */ class d8 implements FailableIntUnaryOperator {
    public final /* synthetic */ int c;
    public final /* synthetic */ FailableIntUnaryOperator d;
    public final /* synthetic */ FailableIntUnaryOperator e;

    public /* synthetic */ d8(FailableIntUnaryOperator failableIntUnaryOperator, FailableIntUnaryOperator failableIntUnaryOperator2, int i) {
        this.c = i;
        this.d = failableIntUnaryOperator;
        this.e = failableIntUnaryOperator2;
    }

    public final /* synthetic */ FailableIntUnaryOperator andThen(FailableIntUnaryOperator failableIntUnaryOperator) {
        int i = this.c;
        return e8.a(this, failableIntUnaryOperator);
    }

    public final int applyAsInt(int i) {
        switch (this.c) {
            case 0:
                return this.d.applyAsInt(this.e.applyAsInt(i));
            default:
                return this.e.applyAsInt(this.d.applyAsInt(i));
        }
    }

    public final /* synthetic */ FailableIntUnaryOperator compose(FailableIntUnaryOperator failableIntUnaryOperator) {
        int i = this.c;
        return e8.b(this, failableIntUnaryOperator);
    }
}
