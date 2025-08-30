package defpackage;

import org.apache.commons.lang3.function.FailableFunction;

/* renamed from: v7  reason: default package */
public final /* synthetic */ class v7 implements FailableFunction {
    public final /* synthetic */ int c;
    public final /* synthetic */ FailableFunction d;
    public final /* synthetic */ FailableFunction e;

    public /* synthetic */ v7(FailableFunction failableFunction, FailableFunction failableFunction2, int i) {
        this.c = i;
        this.d = failableFunction;
        this.e = failableFunction2;
    }

    public final /* synthetic */ FailableFunction andThen(FailableFunction failableFunction) {
        int i = this.c;
        return w7.a(this, failableFunction);
    }

    public final Object apply(Object obj) {
        switch (this.c) {
            case 0:
                return this.d.apply(this.e.apply(obj));
            default:
                return this.e.apply(this.d.apply(obj));
        }
    }

    public final /* synthetic */ FailableFunction compose(FailableFunction failableFunction) {
        int i = this.c;
        return w7.b(this, failableFunction);
    }
}
