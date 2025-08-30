package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;

public final /* synthetic */ class a implements Function2 {
    public final Object invoke(Object obj, Object obj2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = ConcurrentWeakMap.d;
        return new ConcurrentWeakMap.Entry(obj, obj2);
    }
}
