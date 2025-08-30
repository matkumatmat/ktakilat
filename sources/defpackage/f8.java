package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableLongConsumer;

/* renamed from: f8  reason: default package */
public abstract /* synthetic */ class f8 {
    public static FailableLongConsumer a(FailableLongConsumer failableLongConsumer, FailableLongConsumer failableLongConsumer2) {
        Objects.requireNonNull(failableLongConsumer2);
        return new t2(16, failableLongConsumer, failableLongConsumer2);
    }

    public static /* synthetic */ void b(FailableLongConsumer failableLongConsumer, FailableLongConsumer failableLongConsumer2, long j) {
        failableLongConsumer.accept(j);
        failableLongConsumer2.accept(j);
    }

    public static FailableLongConsumer d() {
        return FailableLongConsumer.NOP;
    }

    public static /* synthetic */ void c(long j) {
    }
}
