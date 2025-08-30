package defpackage;

import java.util.Objects;
import org.apache.commons.lang3.function.FailableConsumer;

/* renamed from: m7  reason: default package */
public abstract /* synthetic */ class m7 {
    public static FailableConsumer a(FailableConsumer failableConsumer, FailableConsumer failableConsumer2) {
        Objects.requireNonNull(failableConsumer2);
        return new t2(13, failableConsumer, failableConsumer2);
    }

    public static /* synthetic */ void b(FailableConsumer failableConsumer, FailableConsumer failableConsumer2, Object obj) {
        failableConsumer.accept(obj);
        failableConsumer2.accept(obj);
    }

    public static FailableConsumer d() {
        return FailableConsumer.NOP;
    }

    public static /* synthetic */ void c(Object obj) {
    }
}
