package kotlin.random;

import java.util.Random;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FallbackThreadLocalRandom$implStorage$1 extends ThreadLocal<Random> {
    public final Object initialValue() {
        return new Random();
    }
}
