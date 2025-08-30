package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableIntConsumer;

/* renamed from: x7  reason: default package */
public abstract /* synthetic */ class x7 {
    public static FailableIntConsumer a(FailableIntConsumer failableIntConsumer, FailableIntConsumer failableIntConsumer2) {
        Objects.requireNonNull(failableIntConsumer2);
        return new t2(15, failableIntConsumer, failableIntConsumer2);
    }

    public static /* synthetic */ void b(FailableIntConsumer failableIntConsumer, FailableIntConsumer failableIntConsumer2, int i) {
        failableIntConsumer.accept(i);
        failableIntConsumer2.accept(i);
    }

    public static FailableIntConsumer d() {
        return FailableIntConsumer.NOP;
    }

    public static /* synthetic */ void c(int i) {
    }
}
