package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0002R\u0013\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0002X\u0004¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/channels/ChannelSegment;", "E", "Lkotlinx/coroutines/internal/Segment;", "Lkotlinx/atomicfu/AtomicArray;", "", "data", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/ChannelSegment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3116:1\n1#2:3117\n*E\n"})
public final class ChannelSegment<E> extends Segment<ChannelSegment<E>> {
    public final BufferedChannel g;
    public final /* synthetic */ AtomicReferenceArray i = new AtomicReferenceArray(BufferedChannelKt.b * 2);

    public ChannelSegment(long j, ChannelSegment channelSegment, BufferedChannel bufferedChannel, int i2) {
        super(j, channelSegment, i2);
        this.g = bufferedChannel;
    }

    public final int g() {
        return BufferedChannelKt.b;
    }

    public final void h(int i2, CoroutineContext coroutineContext) {
        boolean z;
        BufferedChannel bufferedChannel;
        Symbol symbol;
        int i3 = BufferedChannelKt.b;
        if (i2 >= i3) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i2 -= i3;
        }
        Object obj = this.i.get(i2 * 2);
        while (true) {
            Object l = l(i2);
            boolean z2 = l instanceof Waiter;
            bufferedChannel = this.g;
            if (z2 || (l instanceof WaiterEB)) {
                if (z) {
                    symbol = BufferedChannelKt.j;
                } else {
                    symbol = BufferedChannelKt.k;
                }
                if (k(i2, l, symbol)) {
                    n(i2, (Object) null);
                    m(i2, !z);
                    if (z) {
                        Intrinsics.c(bufferedChannel);
                        Function1 function1 = bufferedChannel.d;
                        if (function1 != null) {
                            OnUndeliveredElementKt.a(function1, obj, coroutineContext);
                            return;
                        }
                        return;
                    }
                    return;
                }
            } else if (l == BufferedChannelKt.j || l == BufferedChannelKt.k) {
                n(i2, (Object) null);
            } else if (!(l == BufferedChannelKt.g || l == BufferedChannelKt.f)) {
                if (l != BufferedChannelKt.i && l != BufferedChannelKt.d && l != BufferedChannelKt.l) {
                    throw new IllegalStateException(("unexpected state: " + l).toString());
                }
                return;
            }
        }
        n(i2, (Object) null);
        if (z) {
            Intrinsics.c(bufferedChannel);
            Function1 function12 = bufferedChannel.d;
            if (function12 != null) {
                OnUndeliveredElementKt.a(function12, obj, coroutineContext);
            }
        }
    }

    public final boolean k(int i2, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.i;
        int i3 = (i2 * 2) + 1;
        while (!atomicReferenceArray.compareAndSet(i3, obj, obj2)) {
            if (atomicReferenceArray.get(i3) != obj) {
                return false;
            }
        }
        return true;
    }

    public final Object l(int i2) {
        return this.i.get((i2 * 2) + 1);
    }

    public final void m(int i2, boolean z) {
        if (z) {
            BufferedChannel bufferedChannel = this.g;
            Intrinsics.c(bufferedChannel);
            bufferedChannel.U((this.e * ((long) BufferedChannelKt.b)) + ((long) i2));
        }
        i();
    }

    public final void n(int i2, Object obj) {
        this.i.set(i2 * 2, obj);
    }

    public final void o(int i2, Symbol symbol) {
        this.i.set((i2 * 2) + 1, symbol);
    }
}
