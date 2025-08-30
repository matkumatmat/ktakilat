package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import kotlinx.coroutines.internal.NamedDispatcher;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,547:1\n1#2:548\n*E\n"})
public abstract class EventLoop extends CoroutineDispatcher {
    public static final /* synthetic */ int f = 0;
    public long c;
    public boolean d;
    public ArrayDeque e;

    public long A() {
        if (!C()) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return 0;
    }

    public final boolean C() {
        Object obj;
        ArrayDeque arrayDeque = this.e;
        if (arrayDeque == null) {
            return false;
        }
        if (arrayDeque.isEmpty()) {
            obj = null;
        } else {
            obj = arrayDeque.removeFirst();
        }
        DispatchedTask dispatchedTask = (DispatchedTask) obj;
        if (dispatchedTask == null) {
            return false;
        }
        dispatchedTask.run();
        return true;
    }

    public final CoroutineDispatcher limitedParallelism(int i, String str) {
        LimitedDispatcherKt.a(i);
        if (str != null) {
            return new NamedDispatcher(this, str);
        }
        return this;
    }

    public void shutdown() {
    }

    public final void t(boolean z) {
        long j;
        long j2 = this.c;
        if (z) {
            j = 4294967296L;
        } else {
            j = 1;
        }
        long j3 = j2 - j;
        this.c = j3;
        if (j3 <= 0 && this.d) {
            shutdown();
        }
    }

    public final void u(DispatchedTask dispatchedTask) {
        ArrayDeque arrayDeque = this.e;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque();
            this.e = arrayDeque;
        }
        arrayDeque.addLast(dispatchedTask);
    }

    public final void w(boolean z) {
        long j;
        long j2 = this.c;
        if (z) {
            j = 4294967296L;
        } else {
            j = 1;
        }
        this.c = j + j2;
        if (!z) {
            this.d = true;
        }
    }

    public final boolean z() {
        if (this.c >= 4294967296L) {
            return true;
        }
        return false;
    }
}
