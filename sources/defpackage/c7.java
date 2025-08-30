package defpackage;

import org.apache.commons.lang3.function.FailableDoubleConsumer;
import org.apache.commons.lang3.function.FailableRunnable;

/* renamed from: c7  reason: default package */
public final /* synthetic */ class c7 implements FailableRunnable {
    public final /* synthetic */ FailableDoubleConsumer c;
    public final /* synthetic */ double d;

    public /* synthetic */ c7(FailableDoubleConsumer failableDoubleConsumer, double d2) {
        this.c = failableDoubleConsumer;
        this.d = d2;
    }

    public final void run() {
        this.c.accept(this.d);
    }
}
