package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableDoubleConsumer;

/* renamed from: n7  reason: default package */
public abstract /* synthetic */ class n7 {
    public static FailableDoubleConsumer a(FailableDoubleConsumer failableDoubleConsumer, FailableDoubleConsumer failableDoubleConsumer2) {
        Objects.requireNonNull(failableDoubleConsumer2);
        return new t2(14, failableDoubleConsumer, failableDoubleConsumer2);
    }

    public static /* synthetic */ void b(FailableDoubleConsumer failableDoubleConsumer, FailableDoubleConsumer failableDoubleConsumer2, double d) {
        failableDoubleConsumer.accept(d);
        failableDoubleConsumer2.accept(d);
    }

    public static FailableDoubleConsumer d() {
        return FailableDoubleConsumer.NOP;
    }

    public static /* synthetic */ void c(double d) {
    }
}
