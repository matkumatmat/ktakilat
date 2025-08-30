package defpackage;

import org.apache.commons.lang3.function.FailableDoubleUnaryOperator;

/* renamed from: t7  reason: default package */
public final /* synthetic */ class t7 implements FailableDoubleUnaryOperator {
    public final /* synthetic */ int c;
    public final /* synthetic */ FailableDoubleUnaryOperator d;
    public final /* synthetic */ FailableDoubleUnaryOperator e;

    public /* synthetic */ t7(FailableDoubleUnaryOperator failableDoubleUnaryOperator, FailableDoubleUnaryOperator failableDoubleUnaryOperator2, int i) {
        this.c = i;
        this.d = failableDoubleUnaryOperator;
        this.e = failableDoubleUnaryOperator2;
    }

    public final /* synthetic */ FailableDoubleUnaryOperator andThen(FailableDoubleUnaryOperator failableDoubleUnaryOperator) {
        int i = this.c;
        return u7.a(this, failableDoubleUnaryOperator);
    }

    public final double applyAsDouble(double d2) {
        switch (this.c) {
            case 0:
                return this.d.applyAsDouble(this.e.applyAsDouble(d2));
            default:
                return this.e.applyAsDouble(this.d.applyAsDouble(d2));
        }
    }

    public final /* synthetic */ FailableDoubleUnaryOperator compose(FailableDoubleUnaryOperator failableDoubleUnaryOperator) {
        int i = this.c;
        return u7.b(this, failableDoubleUnaryOperator);
    }
}
