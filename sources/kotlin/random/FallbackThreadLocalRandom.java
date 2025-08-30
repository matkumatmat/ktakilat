package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/random/FallbackThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    public final FallbackThreadLocalRandom$implStorage$1 d = new ThreadLocal();

    public final Random a() {
        Object obj = this.d.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (Random) obj;
    }
}
