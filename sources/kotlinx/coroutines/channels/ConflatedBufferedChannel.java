package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConflatedBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,90:1\n562#2,2:91\n529#2,2:93\n529#2,2:95\n562#2,2:97\n*S KotlinDebug\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n*L\n33#1:91,2\n45#1:93,2\n77#1:95,2\n80#1:97,2\n*E\n"})
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {
    public final BufferOverflow p;

    public ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1 function1) {
        super(i, function1);
        this.p = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.a(BufferedChannel.class).f() + " instead").toString());
        } else if (i < 1) {
            throw new IllegalArgumentException(ba.l(i, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
        }
    }

    public final Object A(Object obj, Continuation continuation) {
        UndeliveredElementException b;
        Object V = V(obj, true);
        if (!(V instanceof ChannelResult.Closed)) {
            return Unit.f696a;
        }
        ChannelResult.a(V);
        Function1 function1 = this.d;
        if (function1 == null || (b = OnUndeliveredElementKt.b(function1, obj, (UndeliveredElementException) null)) == null) {
            throw B();
        }
        ExceptionsKt.a(b, B());
        throw b;
    }

    public final boolean H() {
        if (this.p == BufferOverflow.DROP_OLDEST) {
            return true;
        }
        return false;
    }

    public final void N(SelectInstance selectInstance, Object obj) {
        Object V = V(obj, false);
        if (!(V instanceof ChannelResult.Failed)) {
            Unit unit = (Unit) V;
            selectInstance.e(Unit.f696a);
        } else if (V instanceof ChannelResult.Closed) {
            ChannelResult.a(V);
            selectInstance.e(BufferedChannelKt.l);
        } else {
            throw new IllegalStateException("unreachable");
        }
    }

    public final Object P(Continuation continuation) {
        Object V = V((Object) null, true);
        if (V instanceof ChannelResult.Failed) {
            return Boolean.FALSE;
        }
        Unit unit = (Unit) V;
        return Boolean.TRUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object V(java.lang.Object r19, boolean r20) {
        /*
            r18 = this;
            r8 = r18
            kotlinx.coroutines.channels.BufferOverflow r0 = kotlinx.coroutines.channels.BufferOverflow.DROP_LATEST
            kotlinx.coroutines.channels.BufferOverflow r1 = r8.p
            r9 = 0
            if (r1 != r0) goto L_0x002b
            java.lang.Object r0 = super.z(r19)
            boolean r1 = r0 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
            if (r1 == 0) goto L_0x00e8
            boolean r1 = r0 instanceof kotlinx.coroutines.channels.ChannelResult.Closed
            if (r1 == 0) goto L_0x0017
            goto L_0x00e8
        L_0x0017:
            if (r20 == 0) goto L_0x0027
            kotlin.jvm.functions.Function1 r0 = r8.d
            if (r0 == 0) goto L_0x0027
            r10 = r19
            kotlinx.coroutines.internal.UndeliveredElementException r0 = kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r0, r10, r9)
            if (r0 != 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            throw r0
        L_0x0027:
            kotlin.Unit r0 = kotlin.Unit.f696a
            goto L_0x00e8
        L_0x002b:
            r10 = r19
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.channels.BufferedChannel.k
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x0037:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.channels.BufferedChannel.f
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r12 = r1 & r3
            r3 = 0
            boolean r14 = r8.F(r1, r3)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r6 = (long) r1
            long r1 = r12 / r6
            long r3 = r12 % r6
            int r15 = (int) r3
            long r3 = r0.e
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 == 0) goto L_0x006d
            kotlinx.coroutines.channels.ChannelSegment r1 = kotlinx.coroutines.channels.BufferedChannel.d(r8, r1, r0)
            if (r1 != 0) goto L_0x006b
            if (r14 == 0) goto L_0x0037
            java.lang.Throwable r0 = r18.B()
            kotlinx.coroutines.channels.ChannelResult$Closed r1 = new kotlinx.coroutines.channels.ChannelResult$Closed
            r1.<init>(r0)
        L_0x0068:
            r0 = r1
            goto L_0x00e8
        L_0x006b:
            r4 = r1
            goto L_0x006e
        L_0x006d:
            r4 = r0
        L_0x006e:
            r0 = r18
            r1 = r4
            r2 = r15
            r3 = r19
            r20 = r4
            r4 = r12
            r16 = r6
            r6 = r11
            r7 = r14
            int r0 = kotlinx.coroutines.channels.BufferedChannel.i(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00e2
            r1 = 1
            if (r0 == r1) goto L_0x00df
            r1 = 2
            if (r0 == r1) goto L_0x00b6
            r1 = 3
            if (r0 == r1) goto L_0x00ae
            r1 = 4
            if (r0 == r1) goto L_0x0097
            r1 = 5
            if (r0 == r1) goto L_0x0091
            goto L_0x0094
        L_0x0091:
            r20.a()
        L_0x0094:
            r0 = r20
            goto L_0x0037
        L_0x0097:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.channels.BufferedChannel.g
            long r0 = r0.get(r8)
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x00a4
            r20.a()
        L_0x00a4:
            java.lang.Throwable r0 = r18.B()
            kotlinx.coroutines.channels.ChannelResult$Closed r1 = new kotlinx.coroutines.channels.ChannelResult$Closed
            r1.<init>(r0)
            goto L_0x0068
        L_0x00ae:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            r0.<init>(r1)
            throw r0
        L_0x00b6:
            if (r14 == 0) goto L_0x00c5
            r20.i()
            java.lang.Throwable r0 = r18.B()
            kotlinx.coroutines.channels.ChannelResult$Closed r1 = new kotlinx.coroutines.channels.ChannelResult$Closed
            r1.<init>(r0)
            goto L_0x0068
        L_0x00c5:
            boolean r0 = r11 instanceof kotlinx.coroutines.Waiter
            if (r0 == 0) goto L_0x00cc
            r9 = r11
            kotlinx.coroutines.Waiter r9 = (kotlinx.coroutines.Waiter) r9
        L_0x00cc:
            r0 = r20
            if (r9 == 0) goto L_0x00d3
            kotlinx.coroutines.channels.BufferedChannel.f(r8, r9, r0, r15)
        L_0x00d3:
            long r0 = r0.e
            long r0 = r0 * r16
            long r2 = (long) r15
            long r0 = r0 + r2
            r8.s(r0)
            kotlin.Unit r0 = kotlin.Unit.f696a
            goto L_0x00e8
        L_0x00df:
            kotlin.Unit r0 = kotlin.Unit.f696a
            goto L_0x00e8
        L_0x00e2:
            r0 = r20
            r0.a()
            goto L_0x00df
        L_0x00e8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ConflatedBufferedChannel.V(java.lang.Object, boolean):java.lang.Object");
    }

    public final Object z(Object obj) {
        return V(obj, false);
    }
}
