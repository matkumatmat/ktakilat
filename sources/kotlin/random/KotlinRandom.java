package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/random/KotlinRandom;", "Ljava/util/Random;", "c", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class KotlinRandom extends Random {
    @NotNull
    private static final Companion c = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/random/KotlinRandom$Companion;", "", "", "serialVersionUID", "J", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public final int next(int i) {
        throw null;
    }

    public final boolean nextBoolean() {
        throw null;
    }

    public final void nextBytes(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        throw null;
    }

    public final double nextDouble() {
        throw null;
    }

    public final float nextFloat() {
        throw null;
    }

    public final int nextInt() {
        throw null;
    }

    public final long nextLong() {
        throw null;
    }

    public final void setSeed(long j) {
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    public final int nextInt(int i) {
        throw null;
    }
}
