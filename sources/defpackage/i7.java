package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableBiConsumer;

/* renamed from: i7  reason: default package */
public abstract /* synthetic */ class i7 {
    public static FailableBiConsumer a(FailableBiConsumer failableBiConsumer, FailableBiConsumer failableBiConsumer2) {
        Objects.requireNonNull(failableBiConsumer2);
        return new t2(11, failableBiConsumer, failableBiConsumer2);
    }

    public static /* synthetic */ void b(FailableBiConsumer failableBiConsumer, FailableBiConsumer failableBiConsumer2, Object obj, Object obj2) {
        failableBiConsumer.accept(obj, obj2);
        failableBiConsumer2.accept(obj, obj2);
    }

    public static FailableBiConsumer d() {
        return FailableBiConsumer.NOP;
    }

    public static /* synthetic */ void c(Object obj, Object obj2) {
    }
}
