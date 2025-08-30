package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SemaphoreKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f823a = SystemPropsKt.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12);
    public static final Symbol b = new Symbol("PERMIT");
    public static final Symbol c = new Symbol("TAKEN");
    public static final Symbol d = new Symbol("BROKEN");
    public static final Symbol e = new Symbol("CANCELLED");
    public static final int f = SystemPropsKt.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12);

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlinx.coroutines.sync.Semaphore, kotlinx.coroutines.sync.SemaphoreAndMutexImpl] */
    public static Semaphore a(int i) {
        return new SemaphoreAndMutexImpl(i, 0);
    }
}
