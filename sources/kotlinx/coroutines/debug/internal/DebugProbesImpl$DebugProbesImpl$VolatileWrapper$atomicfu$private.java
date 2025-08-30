package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private {
    private volatile /* synthetic */ int installations$volatile;
    private volatile /* synthetic */ long sequenceNumber$volatile;

    static {
        Class<DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private> cls = DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.class;
        AtomicIntegerFieldUpdater.newUpdater(cls, "installations$volatile");
        AtomicLongFieldUpdater.newUpdater(cls, "sequenceNumber$volatile");
    }
}
