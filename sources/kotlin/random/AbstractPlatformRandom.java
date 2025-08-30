package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlatformRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformRandom.kt\nkotlin/random/AbstractPlatformRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
public abstract class AbstractPlatformRandom extends Random {
    public abstract Random a();

    public final int nextBits(int i) {
        return ((-i) >> 31) & (a().nextInt() >>> (32 - i));
    }

    public final boolean nextBoolean() {
        return a().nextBoolean();
    }

    public final byte[] nextBytes(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        a().nextBytes(bArr);
        return bArr;
    }

    public final double nextDouble() {
        return a().nextDouble();
    }

    public final float nextFloat() {
        return a().nextFloat();
    }

    public final int nextInt() {
        return a().nextInt();
    }

    public final long nextLong() {
        return a().nextLong();
    }

    public final int nextInt(int i) {
        return a().nextInt(i);
    }
}
