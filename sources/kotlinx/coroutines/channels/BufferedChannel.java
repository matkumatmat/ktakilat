package kotlinx.coroutines.channels;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import com.google.common.primitives.Longs;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3116:1\n270#1,6:3119\n277#1,68:3126\n394#1,18:3217\n241#1:3235\n266#1,10:3236\n277#1,48:3247\n415#1:3295\n331#1,14:3296\n419#1,3:3311\n241#1:3324\n266#1,10:3325\n277#1,68:3336\n241#1:3414\n266#1,10:3415\n277#1,68:3426\n241#1:3498\n266#1,10:3499\n277#1,68:3510\n241#1:3579\n266#1,10:3580\n277#1,68:3591\n906#1,52:3661\n984#1,8:3717\n878#1:3725\n902#1,33:3726\n994#1:3759\n936#1,14:3760\n955#1,3:3775\n999#1,6:3778\n906#1,52:3792\n984#1,8:3848\n878#1:3856\n902#1,33:3857\n994#1:3890\n936#1,14:3891\n955#1,3:3906\n999#1,6:3909\n878#1:3924\n902#1,48:3925\n955#1,3:3974\n878#1:3977\n902#1,48:3978\n955#1,3:4027\n241#1:4039\n266#1,10:4040\n277#1,68:4051\n878#1:4120\n902#1,48:4121\n955#1,3:4170\n1#2:3117\n3099#3:3118\n3099#3:3125\n3099#3:3246\n3099#3:3335\n3099#3:3425\n3099#3:3497\n3099#3:3509\n3099#3:3590\n3099#3:3660\n3099#3:3923\n3099#3:4030\n3099#3:4031\n3113#3:4032\n3113#3:4033\n3112#3:4034\n3112#3:4035\n3112#3:4036\n3113#3:4037\n3112#3:4038\n3099#3:4050\n3100#3:4173\n3099#3:4174\n3099#3:4175\n3099#3:4176\n3100#3:4177\n3099#3:4178\n3100#3:4201\n3099#3:4202\n3099#3:4203\n3100#3:4204\n3099#3:4254\n3100#3:4255\n3100#3:4256\n3100#3:4274\n3100#3:4275\n351#4,9:3194\n360#4,2:3211\n369#4,4:3213\n373#4,8:3314\n351#4,9:3405\n360#4,2:3495\n369#4,4:3713\n373#4,8:3784\n369#4,4:3844\n373#4,8:3915\n206#5:3203\n207#5:3206\n206#5:3207\n207#5:3210\n57#6,2:3204\n57#6,2:3208\n57#6,2:3322\n266#7:3310\n266#7:3404\n266#7:3494\n266#7:3578\n266#7:3659\n266#7:4119\n902#8:3774\n902#8:3905\n902#8:3973\n902#8:4026\n902#8:4169\n33#9,11:4179\n33#9,11:4190\n68#10,3:4205\n42#10,8:4208\n68#10,3:4216\n42#10,8:4219\n42#10,8:4227\n68#10,3:4235\n42#10,8:4238\n42#10,8:4246\n774#11:4257\n865#11,2:4258\n2318#11,14:4260\n774#11:4276\n865#11,2:4277\n2318#11,14:4279\n774#11:4293\n865#11,2:4294\n2318#11,14:4296\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n110#1:3119,6\n110#1:3126,68\n151#1:3217,18\n151#1:3235\n151#1:3236,10\n151#1:3247,48\n151#1:3295\n151#1:3296,14\n151#1:3311,3\n191#1:3324\n191#1:3325,10\n191#1:3336,68\n222#1:3414\n222#1:3415,10\n222#1:3426,68\n353#1:3498\n353#1:3499,10\n353#1:3510,68\n411#1:3579\n411#1:3580,10\n411#1:3591,68\n687#1:3661,52\n716#1:3717,8\n716#1:3725\n716#1:3726,33\n716#1:3759\n716#1:3760,14\n716#1:3775,3\n716#1:3778,6\n752#1:3792,52\n768#1:3848,8\n768#1:3856\n768#1:3857,33\n768#1:3890\n768#1:3891,14\n768#1:3906,3\n768#1:3909,6\n801#1:3924\n801#1:3925,48\n801#1:3974,3\n991#1:3977\n991#1:3978,48\n991#1:4027,3\n1484#1:4039\n1484#1:4040,10\n1484#1:4051,68\n1532#1:4120\n1532#1:4121,48\n1532#1:4170,3\n67#1:3118\n110#1:3125\n151#1:3246\n191#1:3335\n222#1:3425\n275#1:3497\n353#1:3509\n411#1:3590\n626#1:3660\n791#1:3923\n1027#1:4030\n1076#1:4031\n1394#1:4032\n1396#1:4033\n1426#1:4034\n1436#1:4035\n1445#1:4036\n1446#1:4037\n1453#1:4038\n1484#1:4050\n1898#1:4173\n1900#1:4174\n1902#1:4175\n1915#1:4176\n1926#1:4177\n1927#1:4178\n2229#1:4201\n2242#1:4202\n2252#1:4203\n2255#1:4204\n2572#1:4254\n2574#1:4255\n2599#1:4256\n2661#1:4274\n2662#1:4275\n131#1:3194,9\n131#1:3211,2\n150#1:3213,4\n150#1:3314,8\n218#1:3405,9\n218#1:3495,2\n715#1:3713,4\n715#1:3784,8\n766#1:3844,4\n766#1:3915,8\n135#1:3203\n135#1:3206\n138#1:3207\n138#1:3210\n135#1:3204,2\n138#1:3208,2\n180#1:3322,2\n151#1:3310\n191#1:3404\n222#1:3494\n353#1:3578\n411#1:3659\n1484#1:4119\n716#1:3774\n768#1:3905\n801#1:3973\n991#1:4026\n1532#1:4169\n2131#1:4179,11\n2186#1:4190,11\n2394#1:4205,3\n2394#1:4208,8\n2449#1:4216,3\n2449#1:4219,8\n2468#1:4227,8\n2498#1:4235,3\n2498#1:4238,8\n2559#1:4246,8\n2608#1:4257\n2608#1:4258,2\n2609#1:4260,14\n2673#1:4276\n2673#1:4277,2\n2674#1:4279,14\n2714#1:4293\n2714#1:4294,2\n2715#1:4296,14\n*E\n"})
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002\u0010\u0011R\u000b\u0010\u0004\u001a\u00020\u00038\u0002X\u0004R\u000b\u0010\u0005\u001a\u00020\u00038\u0002X\u0004R\u000b\u0010\u0006\u001a\u00020\u00038\u0002X\u0004R\u000b\u0010\u0007\u001a\u00020\u00038\u0002X\u0004R\u0017\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b8\u0002X\u0004R\u0017\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b8\u0002X\u0004R\u0017\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b8\u0002X\u0004R\u0013\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\b8\u0002X\u0004R\u0013\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\b8\u0002X\u0004¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/atomicfu/AtomicLong;", "sendersAndCloseStatus", "receivers", "bufferEnd", "completedExpandBuffersAndPauseFlag", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/channels/ChannelSegment;", "sendSegment", "receiveSegment", "bufferEndSegment", "", "_closeCause", "closeHandler", "SendBroadcast", "BufferedChannelIterator", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BufferedChannel<E> implements Channel<E> {
    public static final /* synthetic */ AtomicLongFieldUpdater f;
    public static final /* synthetic */ AtomicLongFieldUpdater g;
    public static final /* synthetic */ AtomicLongFieldUpdater i;
    public static final /* synthetic */ AtomicLongFieldUpdater j;
    public static final /* synthetic */ AtomicReferenceFieldUpdater k;
    public static final /* synthetic */ AtomicReferenceFieldUpdater l;
    public static final /* synthetic */ AtomicReferenceFieldUpdater m;
    public static final /* synthetic */ AtomicReferenceFieldUpdater n;
    public static final /* synthetic */ AtomicReferenceFieldUpdater o;
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    public final int c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final Function1 d;
    public final l1 e;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    @SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3116:1\n906#2,52:3117\n984#2,8:3173\n878#2:3181\n902#2,33:3182\n994#2:3215\n936#2,14:3216\n955#2,3:3231\n999#2,6:3234\n369#3,4:3169\n373#3,8:3240\n902#4:3230\n57#5,2:3248\n57#5,2:3251\n1#6:3250\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1619#1:3117,52\n1657#1:3173,8\n1657#1:3181\n1657#1:3182,33\n1657#1:3215\n1657#1:3216,14\n1657#1:3231,3\n1657#1:3234,6\n1655#1:3169,4\n1655#1:3240,8\n1657#1:3230\n1693#1:3248,2\n1741#1:3251,2\n*E\n"})
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        public Object c = BufferedChannelKt.p;
        public CancellableContinuationImpl d;

        public BufferedChannelIterator() {
        }

        public static final void c(BufferedChannelIterator bufferedChannelIterator) {
            CancellableContinuationImpl cancellableContinuationImpl = bufferedChannelIterator.d;
            Intrinsics.c(cancellableContinuationImpl);
            bufferedChannelIterator.d = null;
            bufferedChannelIterator.c = BufferedChannelKt.l;
            Throwable x = BufferedChannel.this.x();
            if (x == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(Boolean.FALSE));
                return;
            }
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(ResultKt.a(x)));
        }

        public final Object a(Continuation continuation) {
            Boolean bool;
            Object obj = this.c;
            boolean z = true;
            if (obj == BufferedChannelKt.p || obj == BufferedChannelKt.l) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BufferedChannel.l;
                BufferedChannel bufferedChannel = BufferedChannel.this;
                ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel);
                while (true) {
                    if (bufferedChannel.G()) {
                        this.c = BufferedChannelKt.l;
                        Throwable x = bufferedChannel.x();
                        if (x == null) {
                            z = false;
                        } else {
                            int i = StackTraceRecoveryKt.f804a;
                            throw x;
                        }
                    } else {
                        long andIncrement = BufferedChannel.g.getAndIncrement(bufferedChannel);
                        long j = (long) BufferedChannelKt.b;
                        long j2 = andIncrement / j;
                        int i2 = (int) (andIncrement % j);
                        if (channelSegment.e != j2) {
                            ChannelSegment v = bufferedChannel.v(j2, channelSegment);
                            if (v == null) {
                                continue;
                            } else {
                                channelSegment = v;
                            }
                        }
                        Object S = bufferedChannel.S(channelSegment, i2, andIncrement, (Object) null);
                        Symbol symbol = BufferedChannelKt.m;
                        if (S != symbol) {
                            Symbol symbol2 = BufferedChannelKt.o;
                            if (S == symbol2) {
                                if (andIncrement < bufferedChannel.D()) {
                                    channelSegment.a();
                                }
                            } else if (S == BufferedChannelKt.n) {
                                BufferedChannel bufferedChannel2 = BufferedChannel.this;
                                CancellableContinuationImpl b = CancellableContinuationKt.b(IntrinsicsKt.b(continuation));
                                try {
                                    this.d = b;
                                    int i3 = i2;
                                    Object S2 = bufferedChannel2.S(channelSegment, i2, andIncrement, this);
                                    if (S2 == symbol) {
                                        b(channelSegment, i3);
                                    } else {
                                        m1 m1Var = null;
                                        Function1 function1 = bufferedChannel2.d;
                                        if (S2 == symbol2) {
                                            if (andIncrement < bufferedChannel2.D()) {
                                                channelSegment.a();
                                            }
                                            ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.l.get(bufferedChannel2);
                                            while (true) {
                                                if (bufferedChannel2.G()) {
                                                    c(this);
                                                    break;
                                                }
                                                long andIncrement2 = BufferedChannel.g.getAndIncrement(bufferedChannel2);
                                                long j3 = (long) BufferedChannelKt.b;
                                                long j4 = andIncrement2 / j3;
                                                int i4 = (int) (andIncrement2 % j3);
                                                if (channelSegment2.e != j4) {
                                                    ChannelSegment v2 = bufferedChannel2.v(j4, channelSegment2);
                                                    if (v2 != null) {
                                                        channelSegment2 = v2;
                                                    }
                                                }
                                                Object S3 = bufferedChannel2.S(channelSegment2, i4, andIncrement2, this);
                                                if (S3 == BufferedChannelKt.m) {
                                                    b(channelSegment2, i4);
                                                    break;
                                                } else if (S3 == BufferedChannelKt.o) {
                                                    if (andIncrement2 < bufferedChannel2.D()) {
                                                        channelSegment2.a();
                                                    }
                                                } else if (S3 != BufferedChannelKt.n) {
                                                    channelSegment2.a();
                                                    this.c = S3;
                                                    this.d = null;
                                                    bool = Boolean.TRUE;
                                                    if (function1 != null) {
                                                        m1Var = new m1(function1, S3);
                                                    }
                                                } else {
                                                    throw new IllegalStateException("unexpected");
                                                }
                                            }
                                        } else {
                                            channelSegment.a();
                                            this.c = S2;
                                            this.d = null;
                                            bool = Boolean.TRUE;
                                            if (function1 != null) {
                                                m1Var = new m1(function1, S2);
                                            }
                                        }
                                        b.l(bool, m1Var);
                                    }
                                    Object p = b.p();
                                    if (p == CoroutineSingletons.COROUTINE_SUSPENDED) {
                                        Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
                                    }
                                    return p;
                                } catch (Throwable th) {
                                    b.y();
                                    throw th;
                                }
                            } else {
                                channelSegment.a();
                                this.c = S;
                            }
                        } else {
                            throw new IllegalStateException("unreachable");
                        }
                    }
                }
            }
            return Boolean.valueOf(z);
        }

        public final void b(Segment segment, int i) {
            CancellableContinuationImpl cancellableContinuationImpl = this.d;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.b(segment, i);
            }
        }

        public final Object next() {
            Object obj = this.c;
            Symbol symbol = BufferedChannelKt.p;
            if (obj != symbol) {
                this.c = symbol;
                if (obj != BufferedChannelKt.l) {
                    return obj;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = BufferedChannel.f;
                Throwable y = BufferedChannel.this.y();
                int i = StackTraceRecoveryKt.f804a;
                throw y;
            }
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SendBroadcast implements Waiter {
        public final /* synthetic */ CancellableContinuationImpl c;
        public final CancellableContinuationImpl d;

        public SendBroadcast(CancellableContinuationImpl cancellableContinuationImpl) {
            this.c = cancellableContinuationImpl;
            this.d = cancellableContinuationImpl;
        }

        public final void b(Segment segment, int i) {
            this.c.b(segment, i);
        }
    }

    static {
        Class<BufferedChannel> cls = BufferedChannel.class;
        f = AtomicLongFieldUpdater.newUpdater(cls, "sendersAndCloseStatus$volatile");
        g = AtomicLongFieldUpdater.newUpdater(cls, "receivers$volatile");
        i = AtomicLongFieldUpdater.newUpdater(cls, "bufferEnd$volatile");
        j = AtomicLongFieldUpdater.newUpdater(cls, "completedExpandBuffersAndPauseFlag$volatile");
        Class<Object> cls2 = Object.class;
        k = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "sendSegment$volatile");
        l = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "receiveSegment$volatile");
        m = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "bufferEndSegment$volatile");
        n = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_closeCause$volatile");
        o = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "closeHandler$volatile");
    }

    public BufferedChannel(int i2, Function1 function1) {
        long j2;
        l1 l1Var;
        this.c = i2;
        this.d = function1;
        if (i2 >= 0) {
            ChannelSegment channelSegment = BufferedChannelKt.f773a;
            if (i2 == 0) {
                j2 = 0;
            } else if (i2 != Integer.MAX_VALUE) {
                j2 = (long) i2;
            } else {
                j2 = LocationRequestCompat.PASSIVE_INTERVAL;
            }
            this.bufferEnd$volatile = j2;
            this.completedExpandBuffersAndPauseFlag$volatile = i.get(this);
            ChannelSegment channelSegment2 = new ChannelSegment(0, (ChannelSegment) null, this, 3);
            this.sendSegment$volatile = channelSegment2;
            this.receiveSegment$volatile = channelSegment2;
            if (I()) {
                channelSegment2 = BufferedChannelKt.f773a;
                Intrinsics.d(channelSegment2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = channelSegment2;
            if (function1 != null) {
                l1Var = new l1(this, 0);
            } else {
                l1Var = null;
            }
            this.e = l1Var;
            this._closeCause$volatile = BufferedChannelKt.s;
            return;
        }
        throw new IllegalArgumentException(ba.l(i2, "Invalid channel capacity: ", ", should be >=0").toString());
    }

    public static void E(BufferedChannel bufferedChannel) {
        bufferedChannel.getClass();
        AtomicLongFieldUpdater atomicLongFieldUpdater = j;
        if ((atomicLongFieldUpdater.addAndGet(bufferedChannel, 1) & Longs.MAX_POWER_OF_TWO) != 0) {
            do {
            } while ((atomicLongFieldUpdater.get(bufferedChannel) & Longs.MAX_POWER_OF_TWO) != 0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object L(kotlinx.coroutines.channels.BufferedChannel r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.e = r1
        L_0x0012:
            r6 = r0
            goto L_0x001a
        L_0x0014:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r14 = r6.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.e
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            kotlin.ResultKt.b(r14)
            kotlinx.coroutines.channels.ChannelResult r14 = (kotlinx.coroutines.channels.ChannelResult) r14
            java.lang.Object r13 = r14.f775a
            goto L_0x0099
        L_0x002e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0036:
            kotlin.ResultKt.b(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = l
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r14 = (kotlinx.coroutines.channels.ChannelSegment) r14
        L_0x0041:
            boolean r1 = r13.G()
            if (r1 == 0) goto L_0x0051
            java.lang.Throwable r13 = r13.x()
            kotlinx.coroutines.channels.ChannelResult$Closed r14 = new kotlinx.coroutines.channels.ChannelResult$Closed
            r14.<init>(r13)
            goto L_0x009f
        L_0x0051:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = g
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.e
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L_0x006d
            kotlinx.coroutines.channels.ChannelSegment r1 = r13.v(r9, r14)
            if (r1 != 0) goto L_0x006c
            goto L_0x0041
        L_0x006c:
            r14 = r1
        L_0x006d:
            r12 = 0
            r7 = r13
            r8 = r14
            r9 = r3
            r10 = r4
            java.lang.Object r1 = r7.S(r8, r9, r10, r12)
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.m
            if (r1 == r7) goto L_0x00a0
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.o
            if (r1 != r7) goto L_0x008a
            long r7 = r13.D()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0041
            r14.a()
            goto L_0x0041
        L_0x008a:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.n
            if (r1 != r7) goto L_0x009b
            r6.e = r2
            r1 = r13
            r2 = r14
            java.lang.Object r13 = r1.M(r2, r3, r4, r6)
            if (r13 != r0) goto L_0x0099
            return r0
        L_0x0099:
            r14 = r13
            goto L_0x009f
        L_0x009b:
            r14.a()
            r14 = r1
        L_0x009f:
            return r14
        L_0x00a0:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.L(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final ChannelSegment d(BufferedChannel bufferedChannel, long j2, ChannelSegment channelSegment) {
        Object a2;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j3;
        long j4;
        bufferedChannel.getClass();
        ChannelSegment channelSegment2 = BufferedChannelKt.f773a;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.c;
        loop0:
        while (true) {
            a2 = ConcurrentLinkedListKt.a(channelSegment, j2, bufferedChannelKt$createSegmentFunction$1);
            if (SegmentOrClosed.b(a2)) {
                break;
            }
            Segment a3 = SegmentOrClosed.a(a2);
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k;
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(bufferedChannel);
                if (segment.e >= a3.e) {
                    break loop0;
                } else if (a3.j()) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, segment, a3)) {
                        if (atomicReferenceFieldUpdater.get(bufferedChannel) != segment) {
                            if (a3.f()) {
                                a3.e();
                            }
                        }
                    }
                    if (segment.f()) {
                        segment.e();
                    }
                }
            }
        }
        boolean b = SegmentOrClosed.b(a2);
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = g;
        if (b) {
            bufferedChannel.C();
            if (channelSegment.e * ((long) BufferedChannelKt.b) >= atomicLongFieldUpdater2.get(bufferedChannel)) {
                return null;
            }
            channelSegment.a();
            return null;
        }
        ChannelSegment channelSegment3 = (ChannelSegment) SegmentOrClosed.a(a2);
        long j5 = channelSegment3.e;
        if (j5 <= j2) {
            return channelSegment3;
        }
        long j6 = ((long) BufferedChannelKt.b) * j5;
        do {
            atomicLongFieldUpdater = f;
            j3 = atomicLongFieldUpdater.get(bufferedChannel);
            j4 = 1152921504606846975L & j3;
            if (j4 >= j6) {
                break;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j3, j4 + (((long) ((int) (j3 >> 60))) << 60)));
        if (j5 * ((long) BufferedChannelKt.b) >= atomicLongFieldUpdater2.get(bufferedChannel)) {
            return null;
        }
        channelSegment3.a();
        return null;
    }

    public static final void e(BufferedChannel bufferedChannel, Object obj, CancellableContinuationImpl cancellableContinuationImpl) {
        Function1 function1 = bufferedChannel.d;
        if (function1 != null) {
            OnUndeliveredElementKt.a(function1, obj, cancellableContinuationImpl.g);
        }
        Throwable B = bufferedChannel.B();
        Result.Companion companion = Result.Companion;
        cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(ResultKt.a(B)));
    }

    public static final void f(BufferedChannel bufferedChannel, Waiter waiter, ChannelSegment channelSegment, int i2) {
        bufferedChannel.getClass();
        waiter.b(channelSegment, i2 + BufferedChannelKt.b);
    }

    public static final void g(BufferedChannel bufferedChannel, SelectInstance selectInstance) {
        Waiter waiter;
        bufferedChannel.getClass();
        ChannelSegment channelSegment = (ChannelSegment) l.get(bufferedChannel);
        while (!bufferedChannel.G()) {
            long andIncrement = g.getAndIncrement(bufferedChannel);
            long j2 = (long) BufferedChannelKt.b;
            long j3 = andIncrement / j2;
            int i2 = (int) (andIncrement % j2);
            if (channelSegment.e != j3) {
                ChannelSegment v = bufferedChannel.v(j3, channelSegment);
                if (v == null) {
                    continue;
                } else {
                    channelSegment = v;
                }
            }
            Object S = bufferedChannel.S(channelSegment, i2, andIncrement, selectInstance);
            if (S == BufferedChannelKt.m) {
                if (selectInstance instanceof Waiter) {
                    waiter = (Waiter) selectInstance;
                } else {
                    waiter = null;
                }
                if (waiter != null) {
                    waiter.b(channelSegment, i2);
                    return;
                }
                return;
            } else if (S == BufferedChannelKt.o) {
                if (andIncrement < bufferedChannel.D()) {
                    channelSegment.a();
                }
            } else if (S != BufferedChannelKt.n) {
                channelSegment.a();
                selectInstance.e(S);
                return;
            } else {
                throw new IllegalStateException("unexpected");
            }
        }
        selectInstance.e(BufferedChannelKt.l);
    }

    public static final int i(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int i2, Object obj, long j2, Object obj2, boolean z) {
        bufferedChannel.getClass();
        channelSegment.n(i2, obj);
        if (z) {
            return bufferedChannel.T(channelSegment, i2, obj, j2, obj2, z);
        }
        Object l2 = channelSegment.l(i2);
        if (l2 == null) {
            if (bufferedChannel.l(j2)) {
                if (channelSegment.k(i2, (Object) null, BufferedChannelKt.d)) {
                    return 1;
                }
            } else if (obj2 == null) {
                return 3;
            } else {
                if (channelSegment.k(i2, (Object) null, obj2)) {
                    return 2;
                }
            }
        } else if (l2 instanceof Waiter) {
            channelSegment.n(i2, (Object) null);
            if (bufferedChannel.Q(l2, obj)) {
                channelSegment.o(i2, BufferedChannelKt.i);
                return 0;
            }
            Symbol symbol = BufferedChannelKt.k;
            if (channelSegment.i.getAndSet((i2 * 2) + 1, symbol) != symbol) {
                channelSegment.m(i2, true);
            }
            return 5;
        }
        return bufferedChannel.T(channelSegment, i2, obj, j2, obj2, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: kotlinx.coroutines.CancellableContinuationImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: kotlinx.coroutines.CancellableContinuationImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: kotlinx.coroutines.channels.BufferedChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: kotlinx.coroutines.CancellableContinuationImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: kotlinx.coroutines.CancellableContinuationImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: kotlinx.coroutines.channels.BufferedChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: kotlinx.coroutines.CancellableContinuationImpl} */
    /* JADX WARNING: type inference failed for: r1v43 */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e4, code lost:
        r7 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        e(r9, r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e9, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ec, code lost:
        r0 = th;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object A(java.lang.Object r24, kotlin.coroutines.Continuation r25) {
        /*
            r23 = this;
            r9 = r23
            r0 = r24
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = k
            java.lang.Object r1 = r10.get(r9)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
        L_0x000c:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r11 = f
            long r2 = r11.getAndIncrement(r9)
            r12 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r14 = r2 & r12
            r8 = 0
            boolean r16 = r9.F(r2, r8)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r2 = (long) r2
            long r4 = r14 / r2
            long r2 = r14 % r2
            int r7 = (int) r2
            long r2 = r1.e
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0040
            kotlinx.coroutines.channels.ChannelSegment r2 = d(r9, r4, r1)
            if (r2 != 0) goto L_0x003e
            if (r16 == 0) goto L_0x000c
            java.lang.Object r0 = r23.K(r24, r25)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r0 != r1) goto L_0x01e5
            goto L_0x01e7
        L_0x003e:
            r5 = r2
            goto L_0x0041
        L_0x0040:
            r5 = r1
        L_0x0041:
            r17 = 0
            r1 = r23
            r2 = r5
            r3 = r7
            r4 = r24
            r18 = r5
            r5 = r14
            r19 = r7
            r7 = r17
            r8 = r16
            int r1 = i(r1, r2, r3, r4, r5, r7, r8)
            if (r1 == 0) goto L_0x01e0
            r8 = 1
            if (r1 == r8) goto L_0x01e5
            r7 = 2
            if (r1 == r7) goto L_0x01ce
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = g
            r6 = 5
            r4 = 4
            r3 = 3
            if (r1 == r3) goto L_0x0085
            if (r1 == r4) goto L_0x0070
            if (r1 == r6) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            r18.a()
        L_0x006d:
            r1 = r18
            goto L_0x000c
        L_0x0070:
            long r1 = r5.get(r9)
            int r3 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x007b
            r18.a()
        L_0x007b:
            java.lang.Object r0 = r23.K(r24, r25)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r0 != r1) goto L_0x01e5
            goto L_0x01e7
        L_0x0085:
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r25)
            kotlinx.coroutines.CancellableContinuationImpl r2 = kotlinx.coroutines.CancellableContinuationKt.b(r1)
            r16 = 0
            r1 = r23
            r17 = r2
            r2 = r18
            r3 = r19
            r12 = 4
            r4 = r24
            r13 = r5
            r5 = r14
            r12 = 2
            r7 = r17
            r12 = 1
            r8 = r16
            int r1 = i(r1, r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0174 }
            if (r1 == 0) goto L_0x01a3
            if (r1 == r12) goto L_0x0198
            r2 = 2
            if (r1 == r2) goto L_0x018e
            r2 = 4
            if (r1 == r2) goto L_0x0180
            java.lang.String r14 = "unexpected"
            r15 = 5
            if (r1 != r15) goto L_0x0178
            r18.a()     // Catch:{ all -> 0x0174 }
            java.lang.Object r1 = r10.get(r9)     // Catch:{ all -> 0x0174 }
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1     // Catch:{ all -> 0x0174 }
        L_0x00be:
            long r2 = r11.getAndIncrement(r9)     // Catch:{ all -> 0x0174 }
            r18 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r21 = r2 & r18
            r10 = 0
            boolean r16 = r9.F(r2, r10)     // Catch:{ all -> 0x0174 }
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.b     // Catch:{ all -> 0x0174 }
            long r2 = (long) r2     // Catch:{ all -> 0x0174 }
            long r4 = r21 / r2
            long r2 = r21 % r2
            int r8 = (int) r2     // Catch:{ all -> 0x0174 }
            long r2 = r1.e     // Catch:{ all -> 0x0174 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00f8
            kotlinx.coroutines.channels.ChannelSegment r2 = d(r9, r4, r1)     // Catch:{ all -> 0x00f4 }
            if (r2 != 0) goto L_0x00f0
            if (r16 == 0) goto L_0x00be
            r7 = r17
            e(r9, r0, r7)     // Catch:{ all -> 0x00ec }
            r1 = r7
            goto L_0x01b3
        L_0x00ec:
            r0 = move-exception
        L_0x00ed:
            r1 = r7
            goto L_0x01ca
        L_0x00f0:
            r7 = r17
            r5 = r2
            goto L_0x00fb
        L_0x00f4:
            r0 = move-exception
            r7 = r17
            goto L_0x00ed
        L_0x00f8:
            r7 = r17
            r5 = r1
        L_0x00fb:
            r1 = r23
            r2 = r5
            r3 = r8
            r4 = r24
            r17 = r5
            r5 = r21
            r20 = r7
            r10 = r8
            r8 = r16
            int r1 = i(r1, r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0126 }
            if (r1 == 0) goto L_0x0164
            if (r1 == r12) goto L_0x0156
            r2 = 2
            if (r1 == r2) goto L_0x0148
            r3 = 3
            if (r1 == r3) goto L_0x013d
            r4 = 4
            if (r1 == r4) goto L_0x012b
            if (r1 == r15) goto L_0x011e
            goto L_0x0121
        L_0x011e:
            r17.a()     // Catch:{ all -> 0x0126 }
        L_0x0121:
            r1 = r17
            r17 = r20
            goto L_0x00be
        L_0x0126:
            r0 = move-exception
            r1 = r20
            goto L_0x01ca
        L_0x012b:
            long r1 = r13.get(r9)     // Catch:{ all -> 0x0126 }
            int r3 = (r21 > r1 ? 1 : (r21 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0136
            r17.a()     // Catch:{ all -> 0x0126 }
        L_0x0136:
            r1 = r20
        L_0x0138:
            e(r9, r0, r1)     // Catch:{ all -> 0x0145 }
            goto L_0x01b3
        L_0x013d:
            r1 = r20
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0145 }
            r0.<init>(r14)     // Catch:{ all -> 0x0145 }
            throw r0     // Catch:{ all -> 0x0145 }
        L_0x0145:
            r0 = move-exception
            goto L_0x01ca
        L_0x0148:
            r1 = r20
            if (r16 == 0) goto L_0x0150
            r17.i()     // Catch:{ all -> 0x0145 }
            goto L_0x0138
        L_0x0150:
            r2 = r17
            f(r9, r1, r2, r10)     // Catch:{ all -> 0x0145 }
            goto L_0x01b3
        L_0x0156:
            r1 = r20
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0145 }
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0145 }
            java.lang.Object r0 = kotlin.Result.m16constructorimpl(r0)     // Catch:{ all -> 0x0145 }
        L_0x0160:
            r1.resumeWith(r0)     // Catch:{ all -> 0x0145 }
            goto L_0x01b3
        L_0x0164:
            r2 = r17
            r1 = r20
            r2.a()     // Catch:{ all -> 0x0145 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0145 }
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0145 }
            java.lang.Object r0 = kotlin.Result.m16constructorimpl(r0)     // Catch:{ all -> 0x0145 }
            goto L_0x0160
        L_0x0174:
            r0 = move-exception
            r1 = r17
            goto L_0x01ca
        L_0x0178:
            r1 = r17
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0145 }
            r0.<init>(r14)     // Catch:{ all -> 0x0145 }
            throw r0     // Catch:{ all -> 0x0145 }
        L_0x0180:
            r1 = r17
            long r2 = r13.get(r9)     // Catch:{ all -> 0x0145 }
            int r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0138
            r18.a()     // Catch:{ all -> 0x0145 }
            goto L_0x0138
        L_0x018e:
            r1 = r17
            r2 = r18
            r0 = r19
            f(r9, r1, r2, r0)     // Catch:{ all -> 0x0145 }
            goto L_0x01b3
        L_0x0198:
            r1 = r17
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0145 }
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0145 }
            java.lang.Object r0 = kotlin.Result.m16constructorimpl(r0)     // Catch:{ all -> 0x0145 }
            goto L_0x0160
        L_0x01a3:
            r1 = r17
            r2 = r18
            r2.a()     // Catch:{ all -> 0x0145 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0145 }
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0145 }
            java.lang.Object r0 = kotlin.Result.m16constructorimpl(r0)     // Catch:{ all -> 0x0145 }
            goto L_0x0160
        L_0x01b3:
            java.lang.Object r0 = r1.p()
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r0 != r1) goto L_0x01c2
            java.lang.String r2 = "frame"
            r3 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
        L_0x01c2:
            if (r0 != r1) goto L_0x01c5
            goto L_0x01c7
        L_0x01c5:
            kotlin.Unit r0 = kotlin.Unit.f696a
        L_0x01c7:
            if (r0 != r1) goto L_0x01e5
            goto L_0x01e7
        L_0x01ca:
            r1.y()
            throw r0
        L_0x01ce:
            r3 = r25
            r2 = r18
            if (r16 == 0) goto L_0x01e5
            r2.i()
            java.lang.Object r0 = r23.K(r24, r25)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r0 != r1) goto L_0x01e5
            goto L_0x01e7
        L_0x01e0:
            r2 = r18
            r2.a()
        L_0x01e5:
            kotlin.Unit r0 = kotlin.Unit.f696a
        L_0x01e7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.A(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Throwable B() {
        Throwable x = x();
        if (x == null) {
            return new ClosedSendChannelException("Channel was closed");
        }
        return x;
    }

    public boolean C() {
        return F(f.get(this), false);
    }

    public final long D() {
        return f.get(this) & 1152921504606846975L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c7, code lost:
        r0 = (kotlinx.coroutines.channels.ChannelSegment) ((kotlinx.coroutines.internal.ConcurrentLinkedListNode) kotlinx.coroutines.internal.ConcurrentLinkedListNode.d.get(r0));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean F(long r19, boolean r21) {
        /*
            r18 = this;
            r6 = r18
            r0 = 60
            long r0 = r19 >> r0
            int r1 = (int) r0
            r7 = 0
            if (r1 == 0) goto L_0x019a
            r8 = 1
            if (r1 == r8) goto L_0x019a
            java.util.concurrent.atomic.AtomicLongFieldUpdater r9 = g
            r0 = 2
            r2 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r1 == r0) goto L_0x010b
            r0 = 3
            if (r1 != r0) goto L_0x00fb
            long r0 = r19 & r2
            kotlinx.coroutines.channels.ChannelSegment r0 = r6.r(r0)
            r2 = 0
            r1 = r2
            r3 = r1
        L_0x0023:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.b
            int r4 = r4 - r8
        L_0x0026:
            r5 = -1
            if (r5 >= r4) goto L_0x00c7
            int r10 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r10 = (long) r10
            long r12 = r0.e
            long r12 = r12 * r10
            long r10 = (long) r4
            long r12 = r12 + r10
        L_0x0032:
            java.lang.Object r10 = r0.l(r4)
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.i
            if (r10 == r11) goto L_0x00d3
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.d
            java.util.concurrent.atomic.AtomicReferenceArray r14 = r0.i
            kotlin.jvm.functions.Function1 r15 = r6.d
            if (r10 != r11) goto L_0x0065
            long r16 = r9.get(r6)
            int r11 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r11 < 0) goto L_0x00d3
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.l
            boolean r10 = r0.k(r4, r10, r11)
            if (r10 == 0) goto L_0x0032
            if (r15 == 0) goto L_0x005e
            int r5 = r4 * 2
            java.lang.Object r5 = r14.get(r5)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r15, r5, r1)
        L_0x005e:
            r0.n(r4, r2)
            r0.i()
            goto L_0x00c3
        L_0x0065:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.e
            if (r10 == r11) goto L_0x00b8
            if (r10 != 0) goto L_0x006c
            goto L_0x00b8
        L_0x006c:
            boolean r11 = r10 instanceof kotlinx.coroutines.Waiter
            if (r11 != 0) goto L_0x0081
            boolean r11 = r10 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r11 == 0) goto L_0x0075
            goto L_0x0081
        L_0x0075:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.g
            if (r10 == r11) goto L_0x00d3
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.f
            if (r10 != r14) goto L_0x007e
            goto L_0x00d3
        L_0x007e:
            if (r10 == r11) goto L_0x0032
            goto L_0x00c3
        L_0x0081:
            long r16 = r9.get(r6)
            int r11 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r11 < 0) goto L_0x00d3
            boolean r11 = r10 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r11 == 0) goto L_0x0093
            r11 = r10
            kotlinx.coroutines.channels.WaiterEB r11 = (kotlinx.coroutines.channels.WaiterEB) r11
            kotlinx.coroutines.Waiter r11 = r11.f778a
            goto L_0x0096
        L_0x0093:
            r11 = r10
            kotlinx.coroutines.Waiter r11 = (kotlinx.coroutines.Waiter) r11
        L_0x0096:
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.channels.BufferedChannelKt.l
            boolean r5 = r0.k(r4, r10, r5)
            if (r5 == 0) goto L_0x00b5
            if (r15 == 0) goto L_0x00aa
            int r5 = r4 * 2
            java.lang.Object r5 = r14.get(r5)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r15, r5, r1)
        L_0x00aa:
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.a(r3, r11)
            r0.n(r4, r2)
            r0.i()
            goto L_0x00c3
        L_0x00b5:
            r5 = -1
            goto L_0x0032
        L_0x00b8:
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.channels.BufferedChannelKt.l
            boolean r5 = r0.k(r4, r10, r5)
            if (r5 == 0) goto L_0x00b5
            r0.i()
        L_0x00c3:
            int r4 = r4 + -1
            goto L_0x0026
        L_0x00c7:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.internal.ConcurrentLinkedListNode.d
            java.lang.Object r0 = r4.get(r0)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r0
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            if (r0 != 0) goto L_0x0023
        L_0x00d3:
            if (r3 == 0) goto L_0x00f5
            boolean r0 = r3 instanceof java.util.ArrayList
            if (r0 != 0) goto L_0x00df
            kotlinx.coroutines.Waiter r3 = (kotlinx.coroutines.Waiter) r3
            r6.O(r3, r7)
            goto L_0x00f5
        L_0x00df:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r0 = r3.size()
            int r0 = r0 - r8
            r2 = -1
        L_0x00e7:
            if (r2 >= r0) goto L_0x00f5
            java.lang.Object r4 = r3.get(r0)
            kotlinx.coroutines.Waiter r4 = (kotlinx.coroutines.Waiter) r4
            r6.O(r4, r7)
            int r0 = r0 + -1
            goto L_0x00e7
        L_0x00f5:
            if (r1 != 0) goto L_0x00fa
        L_0x00f7:
            r7 = 1
            goto L_0x019a
        L_0x00fa:
            throw r1
        L_0x00fb:
            java.lang.String r0 = "unexpected close status: "
            java.lang.String r0 = defpackage.ba.k(r1, r0)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x010b:
            long r0 = r19 & r2
            r6.r(r0)
            if (r21 == 0) goto L_0x00f7
        L_0x0112:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = l
            java.lang.Object r1 = r0.get(r6)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
            long r2 = r9.get(r6)
            long r4 = r18.D()
            int r10 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r10 > 0) goto L_0x0127
            goto L_0x0144
        L_0x0127:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r4 = (long) r4
            long r10 = r2 / r4
            long r12 = r1.e
            int r14 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r14 == 0) goto L_0x0145
            kotlinx.coroutines.channels.ChannelSegment r1 = r6.v(r10, r1)
            if (r1 != 0) goto L_0x0145
            java.lang.Object r0 = r0.get(r6)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            long r0 = r0.e
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x0112
        L_0x0144:
            goto L_0x00f7
        L_0x0145:
            r1.a()
            long r4 = r2 % r4
            int r0 = (int) r4
        L_0x014b:
            java.lang.Object r4 = r1.l(r0)
            if (r4 == 0) goto L_0x0182
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.channels.BufferedChannelKt.e
            if (r4 != r5) goto L_0x0156
            goto L_0x0182
        L_0x0156:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.channels.BufferedChannelKt.d
            if (r4 != r0) goto L_0x015b
            goto L_0x019a
        L_0x015b:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.channels.BufferedChannelKt.j
            if (r4 != r0) goto L_0x0160
            goto L_0x018d
        L_0x0160:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.channels.BufferedChannelKt.l
            if (r4 != r0) goto L_0x0165
            goto L_0x018d
        L_0x0165:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.channels.BufferedChannelKt.i
            if (r4 != r0) goto L_0x016a
            goto L_0x018d
        L_0x016a:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.channels.BufferedChannelKt.h
            if (r4 != r0) goto L_0x016f
            goto L_0x018d
        L_0x016f:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.channels.BufferedChannelKt.g
            if (r4 != r0) goto L_0x0174
            goto L_0x019a
        L_0x0174:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.channels.BufferedChannelKt.f
            if (r4 != r0) goto L_0x0179
            goto L_0x018d
        L_0x0179:
            long r0 = r9.get(r6)
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x018d
            goto L_0x019a
        L_0x0182:
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.channels.BufferedChannelKt.h
            boolean r4 = r1.k(r0, r4, r5)
            if (r4 == 0) goto L_0x014b
            r18.u()
        L_0x018d:
            r0 = 1
            long r4 = r2 + r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = g
            r1 = r18
            r0.compareAndSet(r1, r2, r4)
            goto L_0x0112
        L_0x019a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.F(long, boolean):boolean");
    }

    public final boolean G() {
        return F(f.get(this), true);
    }

    public boolean H() {
        return false;
    }

    public final boolean I() {
        long j2 = i.get(this);
        if (j2 == 0 || j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
            return true;
        }
        return false;
    }

    public final void J(long j2, ChannelSegment channelSegment) {
        ChannelSegment channelSegment2;
        ChannelSegment channelSegment3;
        while (channelSegment.e < j2 && (channelSegment3 = (ChannelSegment) channelSegment.b()) != null) {
            channelSegment = channelSegment3;
        }
        while (true) {
            if (!channelSegment.c() || (channelSegment2 = (ChannelSegment) channelSegment.b()) == null) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.e < channelSegment.e) {
                        if (!channelSegment.j()) {
                            continue;
                            break;
                        }
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, channelSegment)) {
                            if (atomicReferenceFieldUpdater.get(this) != segment) {
                                if (channelSegment.f()) {
                                    channelSegment.e();
                                }
                            }
                        }
                        if (segment.f()) {
                            segment.e();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            channelSegment = channelSegment2;
        }
    }

    public final Object K(Object obj, Continuation continuation) {
        UndeliveredElementException b;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation));
        cancellableContinuationImpl.q();
        Function1 function1 = this.d;
        if (function1 == null || (b = OnUndeliveredElementKt.b(function1, obj, (UndeliveredElementException) null)) == null) {
            Throwable B = B();
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(ResultKt.a(B)));
        } else {
            ExceptionsKt.a(b, B());
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(ResultKt.a(b)));
        }
        Object p = cancellableContinuationImpl.p();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (p == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
        }
        if (p == coroutineSingletons) {
            return p;
        }
        return Unit.f696a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object M(kotlinx.coroutines.channels.ChannelSegment r17, int r18, long r19, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            r16 = this;
            r7 = r16
            r0 = r21
            boolean r1 = r0 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r1 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r1
            int r2 = r1.e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0018
            int r2 = r2 - r3
            r1.e = r2
        L_0x0016:
            r0 = r1
            goto L_0x001e
        L_0x0018:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r1 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            r1.<init>(r7, r0)
            goto L_0x0016
        L_0x001e:
            java.lang.Object r1 = r0.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.b(r1)
            goto L_0x0127
        L_0x002e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0036:
            kotlin.ResultKt.b(r1)
            r0.e = r3
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
            kotlinx.coroutines.CancellableContinuationImpl r9 = kotlinx.coroutines.CancellableContinuationKt.b(r1)
            kotlinx.coroutines.channels.ReceiveCatching r10 = new kotlinx.coroutines.channels.ReceiveCatching     // Catch:{ all -> 0x0076 }
            r10.<init>(r9)     // Catch:{ all -> 0x0076 }
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r6 = r10
            java.lang.Object r1 = r1.S(r2, r3, r4, r6)     // Catch:{ all -> 0x0076 }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.m     // Catch:{ all -> 0x0076 }
            if (r1 != r2) goto L_0x0062
            r2 = r17
            r3 = r18
            r10.b(r2, r3)     // Catch:{ all -> 0x0076 }
            goto L_0x0117
        L_0x0062:
            r2 = r17
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.o     // Catch:{ all -> 0x0076 }
            kotlin.jvm.functions.Function1 r12 = r7.d
            if (r1 != r3) goto L_0x0104
            long r3 = r16.D()     // Catch:{ all -> 0x0076 }
            int r1 = (r19 > r3 ? 1 : (r19 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0079
            r17.a()     // Catch:{ all -> 0x0076 }
            goto L_0x0079
        L_0x0076:
            r0 = move-exception
            goto L_0x012c
        L_0x0079:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = l     // Catch:{ all -> 0x0076 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ all -> 0x0076 }
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1     // Catch:{ all -> 0x0076 }
        L_0x0081:
            boolean r2 = r16.G()     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x00a0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0076 }
            java.lang.Throwable r1 = r16.x()     // Catch:{ all -> 0x0076 }
            kotlinx.coroutines.channels.ChannelResult$Closed r2 = new kotlinx.coroutines.channels.ChannelResult$Closed     // Catch:{ all -> 0x0076 }
            r2.<init>(r1)     // Catch:{ all -> 0x0076 }
            kotlinx.coroutines.channels.ChannelResult r1 = new kotlinx.coroutines.channels.ChannelResult     // Catch:{ all -> 0x0076 }
            r1.<init>(r2)     // Catch:{ all -> 0x0076 }
            java.lang.Object r1 = kotlin.Result.m16constructorimpl(r1)     // Catch:{ all -> 0x0076 }
            r9.resumeWith(r1)     // Catch:{ all -> 0x0076 }
            goto L_0x0117
        L_0x00a0:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = g     // Catch:{ all -> 0x0076 }
            long r13 = r2.getAndIncrement(r7)     // Catch:{ all -> 0x0076 }
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.b     // Catch:{ all -> 0x0076 }
            long r2 = (long) r2     // Catch:{ all -> 0x0076 }
            long r4 = r13 / r2
            long r2 = r13 % r2
            int r15 = (int) r2     // Catch:{ all -> 0x0076 }
            long r2 = r1.e     // Catch:{ all -> 0x0076 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00bd
            kotlinx.coroutines.channels.ChannelSegment r2 = r7.v(r4, r1)     // Catch:{ all -> 0x0076 }
            if (r2 != 0) goto L_0x00bb
            goto L_0x0081
        L_0x00bb:
            r6 = r2
            goto L_0x00be
        L_0x00bd:
            r6 = r1
        L_0x00be:
            r1 = r16
            r2 = r6
            r3 = r15
            r4 = r13
            r11 = r6
            r6 = r10
            java.lang.Object r1 = r1.S(r2, r3, r4, r6)     // Catch:{ all -> 0x0076 }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.m     // Catch:{ all -> 0x0076 }
            if (r1 != r2) goto L_0x00d1
            r10.b(r11, r15)     // Catch:{ all -> 0x0076 }
            goto L_0x0117
        L_0x00d1:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.o     // Catch:{ all -> 0x0076 }
            if (r1 != r2) goto L_0x00e2
            long r1 = r16.D()     // Catch:{ all -> 0x0076 }
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x00e0
            r11.a()     // Catch:{ all -> 0x0076 }
        L_0x00e0:
            r1 = r11
            goto L_0x0081
        L_0x00e2:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.n     // Catch:{ all -> 0x0076 }
            if (r1 == r2) goto L_0x00fc
            r11.a()     // Catch:{ all -> 0x0076 }
            kotlinx.coroutines.channels.ChannelResult r2 = new kotlinx.coroutines.channels.ChannelResult     // Catch:{ all -> 0x0076 }
            r2.<init>(r1)     // Catch:{ all -> 0x0076 }
            if (r12 == 0) goto L_0x00f5
            kotlin.reflect.KFunction r11 = r16.k()     // Catch:{ all -> 0x0076 }
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11     // Catch:{ all -> 0x0076 }
        L_0x00f8:
            r9.l(r2, r11)     // Catch:{ all -> 0x0076 }
            goto L_0x0117
        L_0x00fc:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0076 }
            java.lang.String r1 = "unexpected"
            r0.<init>(r1)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x0104:
            r17.a()     // Catch:{ all -> 0x0076 }
            kotlinx.coroutines.channels.ChannelResult r2 = new kotlinx.coroutines.channels.ChannelResult     // Catch:{ all -> 0x0076 }
            r2.<init>(r1)     // Catch:{ all -> 0x0076 }
            if (r12 == 0) goto L_0x0113
            kotlin.reflect.KFunction r11 = r16.k()     // Catch:{ all -> 0x0076 }
            goto L_0x0114
        L_0x0113:
            r11 = 0
        L_0x0114:
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11     // Catch:{ all -> 0x0076 }
            goto L_0x00f8
        L_0x0117:
            java.lang.Object r1 = r9.p()
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 != r2) goto L_0x0124
            java.lang.String r2 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
        L_0x0124:
            if (r1 != r8) goto L_0x0127
            return r8
        L_0x0127:
            kotlinx.coroutines.channels.ChannelResult r1 = (kotlinx.coroutines.channels.ChannelResult) r1
            java.lang.Object r0 = r1.f775a
            return r0
        L_0x012c:
            r9.y()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.M(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0041, code lost:
        r9.e(kotlinx.coroutines.channels.BufferedChannelKt.l);
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void N(kotlinx.coroutines.selects.SelectInstance r18, java.lang.Object r19) {
        /*
            r17 = this;
            r8 = r17
            r9 = r18
            r10 = r19
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = k
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x000e:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r11 = r1 & r3
            r3 = 0
            boolean r13 = r8.F(r1, r3)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r1 = (long) r1
            long r3 = r11 / r1
            long r1 = r11 % r1
            int r14 = (int) r1
            long r1 = r0.e
            kotlin.jvm.functions.Function1 r15 = r8.d
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x004a
            kotlinx.coroutines.channels.ChannelSegment r1 = d(r8, r3, r0)
            if (r1 != 0) goto L_0x0048
            if (r13 == 0) goto L_0x000e
            if (r15 == 0) goto L_0x0041
            kotlin.coroutines.CoroutineContext r0 = r18.getContext()
            kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r15, r10, r0)
        L_0x0041:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.channels.BufferedChannelKt.l
            r9.e(r0)
            goto L_0x00be
        L_0x0048:
            r7 = r1
            goto L_0x004b
        L_0x004a:
            r7 = r0
        L_0x004b:
            r0 = r17
            r1 = r7
            r2 = r14
            r3 = r19
            r4 = r11
            r6 = r18
            r16 = r7
            r7 = r13
            int r0 = i(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00b8
            r1 = 1
            if (r0 == r1) goto L_0x00b2
            r1 = 2
            if (r0 == r1) goto L_0x0092
            r1 = 3
            if (r0 == r1) goto L_0x008a
            r1 = 4
            if (r0 == r1) goto L_0x0073
            r1 = 5
            if (r0 == r1) goto L_0x006d
            goto L_0x0070
        L_0x006d:
            r16.a()
        L_0x0070:
            r0 = r16
            goto L_0x000e
        L_0x0073:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = g
            long r0 = r0.get(r8)
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0080
            r16.a()
        L_0x0080:
            if (r15 == 0) goto L_0x0041
            kotlin.coroutines.CoroutineContext r0 = r18.getContext()
            kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r15, r10, r0)
            goto L_0x0041
        L_0x008a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            r0.<init>(r1)
            throw r0
        L_0x0092:
            if (r13 == 0) goto L_0x00a1
            r16.i()
            if (r15 == 0) goto L_0x0041
            kotlin.coroutines.CoroutineContext r0 = r18.getContext()
            kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r15, r10, r0)
            goto L_0x0041
        L_0x00a1:
            boolean r0 = r9 instanceof kotlinx.coroutines.Waiter
            if (r0 == 0) goto L_0x00a9
            r0 = r9
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0
            goto L_0x00aa
        L_0x00a9:
            r0 = 0
        L_0x00aa:
            if (r0 == 0) goto L_0x00be
            r1 = r16
            f(r8, r0, r1, r14)
            goto L_0x00be
        L_0x00b2:
            kotlin.Unit r0 = kotlin.Unit.f696a
            r9.e(r0)
            goto L_0x00be
        L_0x00b8:
            r1 = r16
            r1.a()
            goto L_0x00b2
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.N(kotlinx.coroutines.selects.SelectInstance, java.lang.Object):void");
    }

    public final void O(Waiter waiter, boolean z) {
        Throwable th;
        if (waiter instanceof SendBroadcast) {
            CancellableContinuationImpl cancellableContinuationImpl = ((SendBroadcast) waiter).d;
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(Boolean.FALSE));
        } else if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.Companion;
            if (z) {
                th = y();
            } else {
                th = B();
            }
            continuation.resumeWith(Result.m16constructorimpl(ResultKt.a(th)));
        } else if (waiter instanceof ReceiveCatching) {
            CancellableContinuationImpl cancellableContinuationImpl2 = ((ReceiveCatching) waiter).c;
            Result.Companion companion3 = Result.Companion;
            cancellableContinuationImpl2.resumeWith(Result.m16constructorimpl(new ChannelResult(new ChannelResult.Closed(x()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) waiter;
            CancellableContinuationImpl cancellableContinuationImpl3 = bufferedChannelIterator.d;
            Intrinsics.c(cancellableContinuationImpl3);
            bufferedChannelIterator.d = null;
            bufferedChannelIterator.c = BufferedChannelKt.l;
            Throwable x = BufferedChannel.this.x();
            if (x == null) {
                Result.Companion companion4 = Result.Companion;
                cancellableContinuationImpl3.resumeWith(Result.m16constructorimpl(Boolean.FALSE));
                return;
            }
            Result.Companion companion5 = Result.Companion;
            cancellableContinuationImpl3.resumeWith(Result.m16constructorimpl(ResultKt.a(x)));
        } else if (waiter instanceof SelectInstance) {
            ((SelectInstance) waiter).c(this, BufferedChannelKt.l);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
        r9.resumeWith(kotlin.Result.m16constructorimpl(java.lang.Boolean.TRUE));
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00af A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object P(kotlin.coroutines.Continuation r18) {
        /*
            r17 = this;
            r8 = r17
            kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r18)
            r10 = 1
            r9.<init>(r10, r0)
            r9.q()
            kotlin.jvm.functions.Function1 r0 = r8.d
            if (r0 != 0) goto L_0x00c7
            kotlinx.coroutines.channels.BufferedChannel$SendBroadcast r11 = new kotlinx.coroutines.channels.BufferedChannel$SendBroadcast
            r11.<init>(r9)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = k
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x0020:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r12 = r1 & r3
            r3 = 0
            boolean r14 = r8.F(r1, r3)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r1 = (long) r1
            long r3 = r12 / r1
            long r1 = r12 % r1
            int r15 = (int) r1
            long r1 = r0.e
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0057
            kotlinx.coroutines.channels.ChannelSegment r1 = d(r8, r3, r0)
            if (r1 != 0) goto L_0x0055
            if (r14 == 0) goto L_0x0020
            kotlin.Result$Companion r0 = kotlin.Result.Companion
        L_0x004a:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            java.lang.Object r0 = kotlin.Result.m16constructorimpl(r0)
            r9.resumeWith(r0)
            goto L_0x00b7
        L_0x0055:
            r7 = r1
            goto L_0x0058
        L_0x0057:
            r7 = r0
        L_0x0058:
            r3 = 0
            r0 = r17
            r1 = r7
            r2 = r15
            r4 = r12
            r6 = r11
            r16 = r7
            r7 = r14
            int r0 = i(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00af
            if (r0 == r10) goto L_0x00a3
            r1 = 2
            if (r0 == r1) goto L_0x0095
            r1 = 3
            if (r0 == r1) goto L_0x008d
            r1 = 4
            if (r0 == r1) goto L_0x007d
            r1 = 5
            if (r0 == r1) goto L_0x0077
            goto L_0x007a
        L_0x0077:
            r16.a()
        L_0x007a:
            r0 = r16
            goto L_0x0020
        L_0x007d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = g
            long r0 = r0.get(r8)
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x008a
            r16.a()
        L_0x008a:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            goto L_0x004a
        L_0x008d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            r0.<init>(r1)
            throw r0
        L_0x0095:
            if (r14 == 0) goto L_0x009d
            r16.i()
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            goto L_0x004a
        L_0x009d:
            r0 = r16
            f(r8, r11, r0, r15)
            goto L_0x00b7
        L_0x00a3:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
        L_0x00a5:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Object r0 = kotlin.Result.m16constructorimpl(r0)
            r9.resumeWith(r0)
            goto L_0x00b7
        L_0x00af:
            r0 = r16
            r0.a()
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            goto L_0x00a5
        L_0x00b7:
            java.lang.Object r0 = r9.p()
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r0 != r1) goto L_0x00c6
            java.lang.String r1 = "frame"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
        L_0x00c6:
            return r0
        L_0x00c7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.P(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: m1} */
    /* JADX WARNING: type inference failed for: r2v3, types: [kotlin.reflect.KFunction] */
    /* JADX WARNING: type inference failed for: r2v8, types: [kotlin.reflect.KFunction] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean Q(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof kotlinx.coroutines.selects.SelectInstance
            if (r0 == 0) goto L_0x000b
            kotlinx.coroutines.selects.SelectInstance r4 = (kotlinx.coroutines.selects.SelectInstance) r4
            boolean r4 = r4.c(r3, r5)
            goto L_0x006a
        L_0x000b:
            boolean r0 = r4 instanceof kotlinx.coroutines.channels.ReceiveCatching
            kotlin.jvm.functions.Function1 r1 = r3.d
            r2 = 0
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>"
            kotlin.jvm.internal.Intrinsics.d(r4, r0)
            kotlinx.coroutines.channels.ReceiveCatching r4 = (kotlinx.coroutines.channels.ReceiveCatching) r4
            kotlinx.coroutines.CancellableContinuationImpl r4 = r4.c
            kotlinx.coroutines.channels.ChannelResult r0 = new kotlinx.coroutines.channels.ChannelResult
            r0.<init>(r5)
            if (r1 == 0) goto L_0x0026
            kotlin.reflect.KFunction r2 = r3.k()
        L_0x0026:
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            boolean r4 = kotlinx.coroutines.channels.BufferedChannelKt.a(r4, r0, r2)
            goto L_0x006a
        L_0x002d:
            boolean r0 = r4 instanceof kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator
            if (r0 == 0) goto L_0x0053
            java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>"
            kotlin.jvm.internal.Intrinsics.d(r4, r0)
            kotlinx.coroutines.channels.BufferedChannel$BufferedChannelIterator r4 = (kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator) r4
            kotlinx.coroutines.CancellableContinuationImpl r0 = r4.d
            kotlin.jvm.internal.Intrinsics.c(r0)
            r4.d = r2
            r4.c = r5
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            kotlinx.coroutines.channels.BufferedChannel r4 = kotlinx.coroutines.channels.BufferedChannel.this
            kotlin.jvm.functions.Function1 r4 = r4.d
            if (r4 == 0) goto L_0x004e
            m1 r2 = new m1
            r2.<init>(r4, r5)
        L_0x004e:
            boolean r4 = kotlinx.coroutines.channels.BufferedChannelKt.a(r0, r1, r2)
            goto L_0x006a
        L_0x0053:
            boolean r0 = r4 instanceof kotlinx.coroutines.CancellableContinuation
            if (r0 == 0) goto L_0x006b
            java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>"
            kotlin.jvm.internal.Intrinsics.d(r4, r0)
            kotlinx.coroutines.CancellableContinuation r4 = (kotlinx.coroutines.CancellableContinuation) r4
            if (r1 == 0) goto L_0x0064
            kotlin.reflect.KFunction r2 = r3.j()
        L_0x0064:
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            boolean r4 = kotlinx.coroutines.channels.BufferedChannelKt.a(r4, r5, r2)
        L_0x006a:
            return r4
        L_0x006b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected receiver type: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.Q(java.lang.Object, java.lang.Object):boolean");
    }

    public final boolean R(Object obj, ChannelSegment channelSegment, int i2) {
        TrySelectDetailedResult trySelectDetailedResult;
        if (obj instanceof CancellableContinuation) {
            Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.a((CancellableContinuation) obj, Unit.f696a, (Function3) null);
        } else if (obj instanceof SelectInstance) {
            Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            int l2 = ((SelectImplementation) obj).l(this, Unit.f696a);
            Function3 function3 = SelectKt.f820a;
            if (l2 == 0) {
                trySelectDetailedResult = TrySelectDetailedResult.SUCCESSFUL;
            } else if (l2 == 1) {
                trySelectDetailedResult = TrySelectDetailedResult.REREGISTER;
            } else if (l2 == 2) {
                trySelectDetailedResult = TrySelectDetailedResult.CANCELLED;
            } else if (l2 == 3) {
                trySelectDetailedResult = TrySelectDetailedResult.ALREADY_SELECTED;
            } else {
                throw new IllegalStateException(("Unexpected internal result: " + l2).toString());
            }
            if (trySelectDetailedResult == TrySelectDetailedResult.REREGISTER) {
                channelSegment.n(i2, (Object) null);
            }
            if (trySelectDetailedResult == TrySelectDetailedResult.SUCCESSFUL) {
                return true;
            }
            return false;
        } else if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.a(((SendBroadcast) obj).d, Boolean.TRUE, (Function3) null);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
    }

    public final Object S(ChannelSegment channelSegment, int i2, long j2, Object obj) {
        Object l2 = channelSegment.l(i2);
        AtomicReferenceArray atomicReferenceArray = channelSegment.i;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f;
        if (l2 == null) {
            if (j2 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.n;
                }
                if (channelSegment.k(i2, l2, obj)) {
                    u();
                    return BufferedChannelKt.m;
                }
            }
        } else if (l2 == BufferedChannelKt.d && channelSegment.k(i2, l2, BufferedChannelKt.i)) {
            u();
            Object obj2 = atomicReferenceArray.get(i2 * 2);
            channelSegment.n(i2, (Object) null);
            return obj2;
        }
        while (true) {
            Object l3 = channelSegment.l(i2);
            if (l3 == null || l3 == BufferedChannelKt.e) {
                if (j2 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (channelSegment.k(i2, l3, BufferedChannelKt.h)) {
                        u();
                        return BufferedChannelKt.o;
                    }
                } else if (obj == null) {
                    return BufferedChannelKt.n;
                } else {
                    if (channelSegment.k(i2, l3, obj)) {
                        u();
                        return BufferedChannelKt.m;
                    }
                }
            } else if (l3 != BufferedChannelKt.d) {
                Symbol symbol = BufferedChannelKt.j;
                if (l3 == symbol) {
                    return BufferedChannelKt.o;
                }
                if (l3 == BufferedChannelKt.h) {
                    return BufferedChannelKt.o;
                }
                if (l3 == BufferedChannelKt.l) {
                    u();
                    return BufferedChannelKt.o;
                } else if (l3 != BufferedChannelKt.g && channelSegment.k(i2, l3, BufferedChannelKt.f)) {
                    boolean z = l3 instanceof WaiterEB;
                    if (z) {
                        l3 = ((WaiterEB) l3).f778a;
                    }
                    if (R(l3, channelSegment, i2)) {
                        channelSegment.o(i2, BufferedChannelKt.i);
                        u();
                        Object obj3 = atomicReferenceArray.get(i2 * 2);
                        channelSegment.n(i2, (Object) null);
                        return obj3;
                    }
                    channelSegment.o(i2, symbol);
                    channelSegment.i();
                    if (z) {
                        u();
                    }
                    return BufferedChannelKt.o;
                }
            } else if (channelSegment.k(i2, l3, BufferedChannelKt.i)) {
                u();
                Object obj4 = atomicReferenceArray.get(i2 * 2);
                channelSegment.n(i2, (Object) null);
                return obj4;
            }
        }
    }

    public final int T(ChannelSegment channelSegment, int i2, Object obj, long j2, Object obj2, boolean z) {
        while (true) {
            Object l2 = channelSegment.l(i2);
            if (l2 == null) {
                if (!l(j2) || z) {
                    if (z) {
                        if (channelSegment.k(i2, (Object) null, BufferedChannelKt.j)) {
                            channelSegment.i();
                            return 4;
                        }
                    } else if (obj2 == null) {
                        return 3;
                    } else {
                        if (channelSegment.k(i2, (Object) null, obj2)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.k(i2, (Object) null, BufferedChannelKt.d)) {
                    return 1;
                }
            } else if (l2 != BufferedChannelKt.e) {
                Symbol symbol = BufferedChannelKt.k;
                if (l2 == symbol) {
                    channelSegment.n(i2, (Object) null);
                    return 5;
                } else if (l2 == BufferedChannelKt.h) {
                    channelSegment.n(i2, (Object) null);
                    return 5;
                } else if (l2 == BufferedChannelKt.l) {
                    channelSegment.n(i2, (Object) null);
                    C();
                    return 4;
                } else {
                    channelSegment.n(i2, (Object) null);
                    if (l2 instanceof WaiterEB) {
                        l2 = ((WaiterEB) l2).f778a;
                    }
                    if (Q(l2, obj)) {
                        channelSegment.o(i2, BufferedChannelKt.i);
                        return 0;
                    } else if (channelSegment.i.getAndSet((i2 * 2) + 1, symbol) == symbol) {
                        return 5;
                    } else {
                        channelSegment.m(i2, true);
                        return 5;
                    }
                }
            } else if (channelSegment.k(i2, l2, BufferedChannelKt.d)) {
                return 1;
            }
        }
    }

    public final void U(long j2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j3;
        boolean z;
        long j4;
        if (!I()) {
            do {
                atomicLongFieldUpdater = i;
            } while (atomicLongFieldUpdater.get(this) <= j2);
            int i2 = BufferedChannelKt.c;
            int i3 = 0;
            while (true) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = j;
                if (i3 < i2) {
                    long j5 = atomicLongFieldUpdater.get(this);
                    if (j5 != (atomicLongFieldUpdater2.get(this) & 4611686018427387903L) || j5 != atomicLongFieldUpdater.get(this)) {
                        i3++;
                    } else {
                        return;
                    }
                } else {
                    do {
                        j3 = atomicLongFieldUpdater2.get(this);
                    } while (!atomicLongFieldUpdater2.compareAndSet(this, j3, Longs.MAX_POWER_OF_TWO + (j3 & 4611686018427387903L)));
                    while (true) {
                        long j6 = atomicLongFieldUpdater.get(this);
                        long j7 = atomicLongFieldUpdater2.get(this);
                        long j8 = j7 & 4611686018427387903L;
                        if ((j7 & Longs.MAX_POWER_OF_TWO) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (j6 == j8 && j6 == atomicLongFieldUpdater.get(this)) {
                            break;
                        } else if (!z) {
                            atomicLongFieldUpdater2.compareAndSet(this, j7, j8 + Longs.MAX_POWER_OF_TWO);
                        }
                    }
                    do {
                        j4 = atomicLongFieldUpdater2.get(this);
                    } while (!atomicLongFieldUpdater2.compareAndSet(this, j4, j4 & 4611686018427387903L));
                    return;
                }
            }
        }
    }

    public final SelectClause1 a() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.c;
        Intrinsics.d(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        TypeIntrinsics.c(3, bufferedChannel$onReceive$1);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.c;
        Intrinsics.d(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        TypeIntrinsics.c(3, bufferedChannel$onReceive$2);
        return new SelectClause1Impl(this, bufferedChannel$onReceive$1, bufferedChannel$onReceive$2, this.e);
    }

    public final SelectClause1 b() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.c;
        Intrinsics.d(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        TypeIntrinsics.c(3, bufferedChannel$onReceiveCatching$1);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.c;
        Intrinsics.d(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        TypeIntrinsics.c(3, bufferedChannel$onReceiveCatching$2);
        return new SelectClause1Impl(this, bufferedChannel$onReceiveCatching$1, bufferedChannel$onReceiveCatching$2, this.e);
    }

    public final void c(CancellationException cancellationException) {
        p(cancellationException);
    }

    public final Object h() {
        Waiter waiter;
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        long j2 = atomicLongFieldUpdater.get(this);
        long j3 = f.get(this);
        if (F(j3, true)) {
            return new ChannelResult.Closed(x());
        }
        Object obj = ChannelResult.b;
        if (j2 >= (j3 & 1152921504606846975L)) {
            return obj;
        }
        Symbol symbol = BufferedChannelKt.k;
        ChannelSegment channelSegment = (ChannelSegment) l.get(this);
        while (!G()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j4 = (long) BufferedChannelKt.b;
            long j5 = andIncrement / j4;
            int i2 = (int) (andIncrement % j4);
            if (channelSegment.e != j5) {
                ChannelSegment v = v(j5, channelSegment);
                if (v == null) {
                    continue;
                } else {
                    channelSegment = v;
                }
            }
            Object S = S(channelSegment, i2, andIncrement, symbol);
            if (S == BufferedChannelKt.m) {
                if (symbol instanceof Waiter) {
                    waiter = (Waiter) symbol;
                } else {
                    waiter = null;
                }
                if (waiter != null) {
                    waiter.b(channelSegment, i2);
                }
                U(andIncrement);
                channelSegment.i();
            } else if (S == BufferedChannelKt.o) {
                if (andIncrement < D()) {
                    channelSegment.a();
                }
            } else if (S != BufferedChannelKt.n) {
                channelSegment.a();
                obj = S;
            } else {
                throw new IllegalStateException("unexpected");
            }
            return obj;
        }
        return new ChannelResult.Closed(x());
    }

    public final ChannelIterator iterator() {
        return new BufferedChannelIterator();
    }

    public final KFunction j() {
        return new FunctionReferenceImpl(3, this, BufferedChannel.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
    }

    public final KFunction k() {
        return new FunctionReferenceImpl(3, this, BufferedChannel.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
    }

    public final boolean l(long j2) {
        if (j2 < i.get(this) || j2 < g.get(this) + ((long) this.c)) {
            return true;
        }
        return false;
    }

    public final Object n(Continuation continuation) {
        ChannelSegment channelSegment;
        CancellableContinuationImpl cancellableContinuationImpl;
        Function3 function3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        ChannelSegment channelSegment2 = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
        while (!G()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = g;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j2 = (long) BufferedChannelKt.b;
            long j3 = andIncrement / j2;
            int i2 = (int) (andIncrement % j2);
            if (channelSegment2.e != j3) {
                ChannelSegment v = v(j3, channelSegment2);
                if (v == null) {
                    continue;
                } else {
                    channelSegment = v;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object S = S(channelSegment, i2, andIncrement, (Object) null);
            Symbol symbol = BufferedChannelKt.m;
            if (S != symbol) {
                Symbol symbol2 = BufferedChannelKt.o;
                if (S == symbol2) {
                    if (andIncrement < D()) {
                        channelSegment.a();
                    }
                    channelSegment2 = channelSegment;
                } else {
                    if (S == BufferedChannelKt.n) {
                        CancellableContinuationImpl b = CancellableContinuationKt.b(IntrinsicsKt.b(continuation));
                        CancellableContinuationImpl cancellableContinuationImpl2 = b;
                        try {
                            Object S2 = S(channelSegment, i2, andIncrement, b);
                            if (S2 == symbol) {
                                cancellableContinuationImpl = cancellableContinuationImpl2;
                                try {
                                    cancellableContinuationImpl.b(channelSegment, i2);
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } else {
                                cancellableContinuationImpl = cancellableContinuationImpl2;
                                KFunction kFunction = null;
                                Function1 function1 = this.d;
                                if (S2 == symbol2) {
                                    if (andIncrement < D()) {
                                        channelSegment.a();
                                    }
                                    ChannelSegment channelSegment3 = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
                                    while (true) {
                                        if (G()) {
                                            Result.Companion companion = Result.Companion;
                                            cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(ResultKt.a(y())));
                                            break;
                                        }
                                        long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                        long j4 = (long) BufferedChannelKt.b;
                                        long j5 = andIncrement2 / j4;
                                        int i3 = (int) (andIncrement2 % j4);
                                        if (channelSegment3.e != j5) {
                                            ChannelSegment v2 = v(j5, channelSegment3);
                                            if (v2 != null) {
                                                channelSegment3 = v2;
                                            }
                                        }
                                        Function1 function12 = function1;
                                        S2 = S(channelSegment3, i3, andIncrement2, cancellableContinuationImpl);
                                        if (S2 == BufferedChannelKt.m) {
                                            cancellableContinuationImpl.b(channelSegment3, i3);
                                            break;
                                        } else if (S2 == BufferedChannelKt.o) {
                                            if (andIncrement2 < D()) {
                                                channelSegment3.a();
                                            }
                                            function1 = function12;
                                        } else if (S2 != BufferedChannelKt.n) {
                                            channelSegment3.a();
                                            if (function12 != null) {
                                                kFunction = j();
                                            }
                                            function3 = (Function3) kFunction;
                                        } else {
                                            throw new IllegalStateException("unexpected");
                                        }
                                    }
                                } else {
                                    Function1 function13 = function1;
                                    channelSegment.a();
                                    if (function13 != null) {
                                        kFunction = j();
                                    }
                                    function3 = (Function3) kFunction;
                                }
                                cancellableContinuationImpl.l(S2, function3);
                            }
                            S = cancellableContinuationImpl.p();
                            if (S == CoroutineSingletons.COROUTINE_SUSPENDED) {
                                Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cancellableContinuationImpl = cancellableContinuationImpl2;
                            cancellableContinuationImpl.y();
                            throw th;
                        }
                    } else {
                        channelSegment.a();
                    }
                    return S;
                }
            } else {
                throw new IllegalStateException("unexpected");
            }
        }
        Throwable y = y();
        int i4 = StackTraceRecoveryKt.f804a;
        throw y;
    }

    public boolean o(Throwable th) {
        return q(false, th);
    }

    public void p(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        q(true, cancellationException);
    }

    public final boolean q(boolean z, Throwable th) {
        boolean z2;
        Object obj;
        Symbol symbol;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f;
        if (z) {
            do {
                j6 = atomicLongFieldUpdater.get(this);
                if (((int) (j6 >> 60)) != 0) {
                    break;
                }
                ChannelSegment channelSegment = BufferedChannelKt.f773a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j6, (((long) 1) << 60) + (j6 & 1152921504606846975L)));
        }
        Symbol symbol2 = BufferedChannelKt.s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, symbol2, th)) {
                if (atomicReferenceFieldUpdater.get(this) != symbol2) {
                    z2 = false;
                    break;
                }
            } else {
                z2 = true;
                break;
            }
        }
        if (z) {
            do {
                j5 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(this, j5, (((long) 3) << 60) + (j5 & 1152921504606846975L)));
        } else {
            do {
                j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 >> 60);
                if (i2 == 0) {
                    j3 = j2 & 1152921504606846975L;
                    j4 = (long) 2;
                } else if (i2 != 1) {
                    break;
                } else {
                    j3 = j2 & 1152921504606846975L;
                    j4 = (long) 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j2, (j4 << 60) + j3));
        }
        C();
        if (z2) {
            loop4:
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = o;
                obj = atomicReferenceFieldUpdater2.get(this);
                if (obj == null) {
                    symbol = BufferedChannelKt.q;
                } else {
                    symbol = BufferedChannelKt.r;
                }
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, obj, symbol)) {
                        break loop4;
                    } else if (atomicReferenceFieldUpdater2.get(this) != obj) {
                    }
                }
            }
            if (obj != null) {
                TypeIntrinsics.c(1, obj);
                ((Function1) obj).invoke(x());
            }
        }
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        r10 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0090, code lost:
        r1 = (kotlinx.coroutines.channels.ChannelSegment) ((kotlinx.coroutines.internal.ConcurrentLinkedListNode) kotlinx.coroutines.internal.ConcurrentLinkedListNode.d.get(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.channels.ChannelSegment r(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = m
            java.lang.Object r0 = r0.get(r13)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = k
            java.lang.Object r1 = r1.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
            long r2 = r1.e
            r4 = r0
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r4 = r4.e
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x001a
            r0 = r1
        L_0x001a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = l
            java.lang.Object r1 = r1.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
            long r2 = r1.e
            r4 = r0
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r4 = r4.e
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x002e
            r0 = r1
        L_0x002e:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r0
        L_0x0030:
            r0.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.ConcurrentLinkedListNode.c
            java.lang.Object r1 = r1.get(r0)
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.internal.ConcurrentLinkedListKt.f793a
            r3 = 0
            if (r1 != r2) goto L_0x003f
            goto L_0x004b
        L_0x003f:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r1 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r1
            if (r1 != 0) goto L_0x0133
        L_0x0043:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.ConcurrentLinkedListNode.c
            boolean r4 = r1.compareAndSet(r0, r3, r2)
            if (r4 == 0) goto L_0x012b
        L_0x004b:
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            boolean r1 = r13.H()
            r2 = -1
            r4 = 1
            if (r1 == 0) goto L_0x00a4
            r1 = r0
        L_0x0056:
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.b
            int r5 = r5 - r4
        L_0x0059:
            r6 = -1
            if (r2 >= r5) goto L_0x0090
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r8 = (long) r8
            long r10 = r1.e
            long r10 = r10 * r8
            long r8 = (long) r5
            long r10 = r10 + r8
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = g
            long r8 = r8.get(r13)
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x0072
        L_0x0070:
            r10 = r6
            goto L_0x009d
        L_0x0072:
            java.lang.Object r8 = r1.l(r5)
            if (r8 == 0) goto L_0x0082
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.e
            if (r8 != r9) goto L_0x007d
            goto L_0x0082
        L_0x007d:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.d
            if (r8 != r9) goto L_0x008d
            goto L_0x009d
        L_0x0082:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.l
            boolean r8 = r1.k(r5, r8, r9)
            if (r8 == 0) goto L_0x0072
            r1.i()
        L_0x008d:
            int r5 = r5 + -1
            goto L_0x0059
        L_0x0090:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.ConcurrentLinkedListNode.d
            java.lang.Object r1 = r5.get(r1)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r1 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r1
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
            if (r1 != 0) goto L_0x0056
            goto L_0x0070
        L_0x009d:
            int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00a4
            r13.s(r10)
        L_0x00a4:
            r1 = r0
        L_0x00a5:
            if (r1 == 0) goto L_0x0109
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.b
            int r5 = r5 - r4
        L_0x00aa:
            if (r2 >= r5) goto L_0x00fe
            int r6 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r6 = (long) r6
            long r8 = r1.e
            long r8 = r8 * r6
            long r6 = (long) r5
            long r8 = r8 + r6
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 < 0) goto L_0x0109
        L_0x00b9:
            java.lang.Object r6 = r1.l(r5)
            if (r6 == 0) goto L_0x00f0
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.e
            if (r6 != r7) goto L_0x00c4
            goto L_0x00f0
        L_0x00c4:
            boolean r7 = r6 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r7 == 0) goto L_0x00dc
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.l
            boolean r7 = r1.k(r5, r6, r7)
            if (r7 == 0) goto L_0x00b9
            kotlinx.coroutines.channels.WaiterEB r6 = (kotlinx.coroutines.channels.WaiterEB) r6
            kotlinx.coroutines.Waiter r6 = r6.f778a
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.a(r3, r6)
            r1.m(r5, r4)
            goto L_0x00fb
        L_0x00dc:
            boolean r7 = r6 instanceof kotlinx.coroutines.Waiter
            if (r7 == 0) goto L_0x00fb
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.l
            boolean r7 = r1.k(r5, r6, r7)
            if (r7 == 0) goto L_0x00b9
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.a(r3, r6)
            r1.m(r5, r4)
            goto L_0x00fb
        L_0x00f0:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.l
            boolean r6 = r1.k(r5, r6, r7)
            if (r6 == 0) goto L_0x00b9
            r1.i()
        L_0x00fb:
            int r5 = r5 + -1
            goto L_0x00aa
        L_0x00fe:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.ConcurrentLinkedListNode.d
            java.lang.Object r1 = r5.get(r1)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r1 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r1
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
            goto L_0x00a5
        L_0x0109:
            if (r3 == 0) goto L_0x012a
            boolean r14 = r3 instanceof java.util.ArrayList
            if (r14 != 0) goto L_0x0115
            kotlinx.coroutines.Waiter r3 = (kotlinx.coroutines.Waiter) r3
            r13.O(r3, r4)
            goto L_0x012a
        L_0x0115:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r14 = r3.size()
            int r14 = r14 - r4
        L_0x011c:
            if (r2 >= r14) goto L_0x012a
            java.lang.Object r15 = r3.get(r14)
            kotlinx.coroutines.Waiter r15 = (kotlinx.coroutines.Waiter) r15
            r13.O(r15, r4)
            int r14 = r14 + -1
            goto L_0x011c
        L_0x012a:
            return r0
        L_0x012b:
            java.lang.Object r1 = r1.get(r0)
            if (r1 == 0) goto L_0x0043
            goto L_0x0030
        L_0x0133:
            r0 = r1
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.r(long):kotlinx.coroutines.channels.ChannelSegment");
    }

    public final void s(long j2) {
        UndeliveredElementException b;
        ChannelSegment channelSegment = (ChannelSegment) l.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = g;
            long j3 = atomicLongFieldUpdater.get(this);
            if (j2 >= Math.max(((long) this.c) + j3, i.get(this))) {
                if (atomicLongFieldUpdater.compareAndSet(this, j3, j3 + 1)) {
                    long j4 = (long) BufferedChannelKt.b;
                    long j5 = j3 / j4;
                    int i2 = (int) (j3 % j4);
                    if (channelSegment.e != j5) {
                        ChannelSegment v = v(j5, channelSegment);
                        if (v == null) {
                            continue;
                        } else {
                            channelSegment = v;
                        }
                    }
                    Object S = S(channelSegment, i2, j3, (Object) null);
                    if (S != BufferedChannelKt.o) {
                        channelSegment.a();
                        Function1 function1 = this.d;
                        if (!(function1 == null || (b = OnUndeliveredElementKt.b(function1, S, (UndeliveredElementException) null)) == null)) {
                            throw b;
                        }
                    } else if (j3 < D()) {
                        channelSegment.a();
                    }
                }
            } else {
                return;
            }
        }
    }

    public final Object t(ContinuationImpl continuationImpl) {
        return L(this, continuationImpl);
    }

    /* JADX WARNING: type inference failed for: r2v10, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ba, code lost:
        r3 = r3.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c1, code lost:
        if (r3 != null) goto L_0x01e2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r16 = this;
            r0 = r16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r3 = (int) r2
            r2 = 2
            r4 = 3
            if (r3 == r2) goto L_0x001e
            if (r3 == r4) goto L_0x0018
            goto L_0x0023
        L_0x0018:
            java.lang.String r3 = "cancelled,"
            r1.append(r3)
            goto L_0x0023
        L_0x001e:
            java.lang.String r3 = "closed,"
            r1.append(r3)
        L_0x0023:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "capacity="
            r3.<init>(r5)
            int r5 = r0.c
            r3.append(r5)
            r5 = 44
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r1.append(r3)
            java.lang.String r3 = "data=["
            r1.append(r3)
            kotlinx.coroutines.channels.ChannelSegment[] r3 = new kotlinx.coroutines.channels.ChannelSegment[r4]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = l
            java.lang.Object r4 = r4.get(r0)
            r6 = 0
            r3[r6] = r4
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = k
            java.lang.Object r4 = r4.get(r0)
            r7 = 1
            r3[r7] = r4
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = m
            java.lang.Object r4 = r4.get(r0)
            r3[r2] = r4
            java.util.List r2 = kotlin.collections.CollectionsKt.t(r3)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x006b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r2.next()
            r8 = r4
            kotlinx.coroutines.channels.ChannelSegment r8 = (kotlinx.coroutines.channels.ChannelSegment) r8
            kotlinx.coroutines.channels.ChannelSegment r9 = kotlinx.coroutines.channels.BufferedChannelKt.f773a
            if (r8 == r9) goto L_0x006b
            r3.add(r4)
            goto L_0x006b
        L_0x0080:
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01e6
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x0095
            goto L_0x00af
        L_0x0095:
            r4 = r3
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r8 = r4.e
        L_0x009a:
            java.lang.Object r4 = r2.next()
            r10 = r4
            kotlinx.coroutines.channels.ChannelSegment r10 = (kotlinx.coroutines.channels.ChannelSegment) r10
            long r10 = r10.e
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00a9
            r3 = r4
            r8 = r10
        L_0x00a9:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x009a
        L_0x00af:
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = g
            long r10 = r2.get(r0)
            long r12 = r16.D()
        L_0x00bb:
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.b
            r4 = 0
        L_0x00be:
            if (r4 >= r2) goto L_0x01ba
            long r8 = r3.e
            int r14 = kotlinx.coroutines.channels.BufferedChannelKt.b
            long r14 = (long) r14
            long r8 = r8 * r14
            long r14 = (long) r4
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x00d1
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x01c3
        L_0x00d1:
            java.lang.Object r15 = r3.l(r4)
            java.util.concurrent.atomic.AtomicReferenceArray r6 = r3.i
            int r7 = r4 * 2
            java.lang.Object r6 = r6.get(r7)
            boolean r7 = r15 instanceof kotlinx.coroutines.CancellableContinuation
            if (r7 == 0) goto L_0x00f7
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00eb
            if (r14 < 0) goto L_0x00eb
            java.lang.String r7 = "receive"
            goto L_0x0183
        L_0x00eb:
            if (r14 >= 0) goto L_0x00f3
            if (r7 < 0) goto L_0x00f3
            java.lang.String r7 = "send"
            goto L_0x0183
        L_0x00f3:
            java.lang.String r7 = "cont"
            goto L_0x0183
        L_0x00f7:
            boolean r7 = r15 instanceof kotlinx.coroutines.selects.SelectInstance
            if (r7 == 0) goto L_0x0111
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0105
            if (r14 < 0) goto L_0x0105
            java.lang.String r7 = "onReceive"
            goto L_0x0183
        L_0x0105:
            if (r14 >= 0) goto L_0x010d
            if (r7 < 0) goto L_0x010d
            java.lang.String r7 = "onSend"
            goto L_0x0183
        L_0x010d:
            java.lang.String r7 = "select"
            goto L_0x0183
        L_0x0111:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.ReceiveCatching
            if (r7 == 0) goto L_0x0119
            java.lang.String r7 = "receiveCatching"
            goto L_0x0183
        L_0x0119:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast
            if (r7 == 0) goto L_0x0120
            java.lang.String r7 = "sendBroadcast"
            goto L_0x0183
        L_0x0120:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r7 == 0) goto L_0x0138
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "EB("
            r7.<init>(r8)
            r7.append(r15)
            r8 = 41
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L_0x0183
        L_0x0138:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.f
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r15, r7)
            if (r7 != 0) goto L_0x0181
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.g
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r15, r7)
            if (r7 == 0) goto L_0x0149
            goto L_0x0181
        L_0x0149:
            if (r15 == 0) goto L_0x01b4
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.e
            boolean r7 = r15.equals(r7)
            if (r7 != 0) goto L_0x01b4
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.i
            boolean r7 = r15.equals(r7)
            if (r7 != 0) goto L_0x01b4
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.h
            boolean r7 = r15.equals(r7)
            if (r7 != 0) goto L_0x01b4
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.k
            boolean r7 = r15.equals(r7)
            if (r7 != 0) goto L_0x01b4
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.j
            boolean r7 = r15.equals(r7)
            if (r7 != 0) goto L_0x01b4
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.l
            boolean r7 = r15.equals(r7)
            if (r7 == 0) goto L_0x017c
            goto L_0x01b4
        L_0x017c:
            java.lang.String r7 = r15.toString()
            goto L_0x0183
        L_0x0181:
            java.lang.String r7 = "resuming_sender"
        L_0x0183:
            if (r6 == 0) goto L_0x01a2
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "("
            r8.<init>(r9)
            r8.append(r7)
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = "),"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r1.append(r6)
            goto L_0x01b4
        L_0x01a2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
        L_0x01b4:
            int r4 = r4 + 1
            r6 = 0
            r7 = 1
            goto L_0x00be
        L_0x01ba:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r2 = r3.b()
            r3 = r2
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            if (r3 != 0) goto L_0x01e2
        L_0x01c3:
            char r2 = kotlin.text.StringsKt.u(r1)
            if (r2 != r5) goto L_0x01d8
            int r2 = r1.length()
            r4 = 1
            int r2 = r2 - r4
            java.lang.StringBuilder r2 = r1.deleteCharAt(r2)
            java.lang.String r3 = "deleteCharAt(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x01d8:
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x01e2:
            r6 = 0
            r7 = 1
            goto L_0x00bb
        L_0x01e6:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    public final void u() {
        Object a2;
        if (!I()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
            ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
            loop0:
            while (true) {
                long andIncrement = i.getAndIncrement(this);
                long j2 = andIncrement / ((long) BufferedChannelKt.b);
                if (D() <= andIncrement) {
                    if (channelSegment.e < j2 && channelSegment.b() != null) {
                        J(j2, channelSegment);
                    }
                    E(this);
                    return;
                }
                if (channelSegment.e != j2) {
                    BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.c;
                    while (true) {
                        a2 = ConcurrentLinkedListKt.a(channelSegment, j2, bufferedChannelKt$createSegmentFunction$1);
                        if (SegmentOrClosed.b(a2)) {
                            break;
                        }
                        Segment a3 = SegmentOrClosed.a(a2);
                        while (true) {
                            Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                            if (segment.e >= a3.e) {
                                break;
                            } else if (a3.j()) {
                                while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, a3)) {
                                    if (atomicReferenceFieldUpdater.get(this) != segment) {
                                        if (a3.f()) {
                                            a3.e();
                                        }
                                    }
                                }
                                if (segment.f()) {
                                    segment.e();
                                }
                            }
                        }
                    }
                    ChannelSegment channelSegment2 = null;
                    if (SegmentOrClosed.b(a2)) {
                        C();
                        J(j2, channelSegment);
                        E(this);
                    } else {
                        ChannelSegment channelSegment3 = (ChannelSegment) SegmentOrClosed.a(a2);
                        long j3 = channelSegment3.e;
                        if (j3 > j2) {
                            long j4 = j3 * ((long) BufferedChannelKt.b);
                            if (i.compareAndSet(this, andIncrement + 1, j4)) {
                                AtomicLongFieldUpdater atomicLongFieldUpdater = j;
                                if ((atomicLongFieldUpdater.addAndGet(this, j4 - andIncrement) & Longs.MAX_POWER_OF_TWO) != 0) {
                                    do {
                                    } while ((atomicLongFieldUpdater.get(this) & Longs.MAX_POWER_OF_TWO) != 0);
                                }
                            } else {
                                E(this);
                            }
                        } else {
                            channelSegment2 = channelSegment3;
                        }
                    }
                    if (channelSegment2 == null) {
                        continue;
                    } else {
                        channelSegment = channelSegment2;
                    }
                }
                int i2 = (int) (andIncrement % ((long) BufferedChannelKt.b));
                Object l2 = channelSegment.l(i2);
                boolean z = l2 instanceof Waiter;
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = g;
                if (!z || andIncrement < atomicLongFieldUpdater2.get(this) || !channelSegment.k(i2, l2, BufferedChannelKt.g)) {
                    while (true) {
                        Object l3 = channelSegment.l(i2);
                        if (!(l3 instanceof Waiter)) {
                            if (l3 != BufferedChannelKt.j) {
                                if (l3 != null) {
                                    if (l3 == BufferedChannelKt.d || l3 == BufferedChannelKt.h || l3 == BufferedChannelKt.i || l3 == BufferedChannelKt.k || l3 == BufferedChannelKt.l) {
                                        break loop0;
                                    } else if (l3 != BufferedChannelKt.f) {
                                        throw new IllegalStateException(("Unexpected cell state: " + l3).toString());
                                    }
                                } else if (channelSegment.k(i2, l3, BufferedChannelKt.e)) {
                                    break loop0;
                                }
                            } else {
                                break;
                            }
                        } else if (andIncrement < atomicLongFieldUpdater2.get(this)) {
                            if (channelSegment.k(i2, l3, new WaiterEB((Waiter) l3))) {
                                break loop0;
                            }
                        } else if (channelSegment.k(i2, l3, BufferedChannelKt.g)) {
                            if (R(l3, channelSegment, i2)) {
                                channelSegment.o(i2, BufferedChannelKt.d);
                                break;
                            } else {
                                channelSegment.o(i2, BufferedChannelKt.j);
                                channelSegment.i();
                            }
                        }
                    }
                } else if (R(l2, channelSegment, i2)) {
                    channelSegment.o(i2, BufferedChannelKt.d);
                    break;
                } else {
                    channelSegment.o(i2, BufferedChannelKt.j);
                    channelSegment.i();
                }
                E(this);
            }
            E(this);
        }
    }

    public final ChannelSegment v(long j2, ChannelSegment channelSegment) {
        Object a2;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j3;
        ChannelSegment channelSegment2 = BufferedChannelKt.f773a;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.c;
        loop0:
        while (true) {
            a2 = ConcurrentLinkedListKt.a(channelSegment, j2, bufferedChannelKt$createSegmentFunction$1);
            if (SegmentOrClosed.b(a2)) {
                break;
            }
            Segment a3 = SegmentOrClosed.a(a2);
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.e >= a3.e) {
                    break loop0;
                } else if (a3.j()) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, a3)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (a3.f()) {
                                a3.e();
                            }
                        }
                    }
                    if (segment.f()) {
                        segment.e();
                    }
                }
            }
        }
        if (SegmentOrClosed.b(a2)) {
            C();
            if (channelSegment.e * ((long) BufferedChannelKt.b) >= D()) {
                return null;
            }
            channelSegment.a();
            return null;
        }
        ChannelSegment channelSegment3 = (ChannelSegment) SegmentOrClosed.a(a2);
        boolean I = I();
        long j4 = channelSegment3.e;
        if (!I && j2 <= i.get(this) / ((long) BufferedChannelKt.b)) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = m;
                Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                if (segment2.e >= j4 || !channelSegment3.j()) {
                    break;
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, segment2, channelSegment3)) {
                    if (atomicReferenceFieldUpdater2.get(this) != segment2) {
                        if (channelSegment3.f()) {
                            channelSegment3.e();
                        }
                    }
                }
                if (segment2.f()) {
                    segment2.e();
                }
            }
        }
        if (j4 <= j2) {
            return channelSegment3;
        }
        long j5 = ((long) BufferedChannelKt.b) * j4;
        do {
            atomicLongFieldUpdater = g;
            j3 = atomicLongFieldUpdater.get(this);
            if (j3 >= j5 || atomicLongFieldUpdater.compareAndSet(this, j3, j5)) {
            }
            atomicLongFieldUpdater = g;
            j3 = atomicLongFieldUpdater.get(this);
            break;
        } while (atomicLongFieldUpdater.compareAndSet(this, j3, j5));
        if (j4 * ((long) BufferedChannelKt.b) >= D()) {
            return null;
        }
        channelSegment3.a();
        return null;
    }

    public final void w(Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = o;
            if (atomicReferenceFieldUpdater.compareAndSet(this, (Object) null, function1)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = BufferedChannelKt.q;
            if (obj == symbol) {
                Symbol symbol2 = BufferedChannelKt.r;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, symbol, symbol2)) {
                        function1.invoke(x());
                        return;
                    } else if (atomicReferenceFieldUpdater.get(this) != symbol) {
                    }
                }
            } else if (obj == BufferedChannelKt.r) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            } else {
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        }
    }

    public final Throwable x() {
        return (Throwable) n.get(this);
    }

    public final Throwable y() {
        Throwable x = x();
        if (x == null) {
            return new ClosedReceiveChannelException("Channel was closed");
        }
        return x;
    }

    public Object z(Object obj) {
        boolean z;
        ChannelSegment channelSegment;
        Waiter waiter;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f;
        long j2 = atomicLongFieldUpdater.get(this);
        boolean z2 = false;
        if (F(j2, false)) {
            z = false;
        } else {
            z = !l(j2 & 1152921504606846975L);
        }
        ChannelResult.Failed failed = ChannelResult.b;
        if (z) {
            return failed;
        }
        Symbol symbol = BufferedChannelKt.j;
        ChannelSegment channelSegment2 = (ChannelSegment) k.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j3 = andIncrement & 1152921504606846975L;
            boolean F = F(andIncrement, z2);
            long j4 = (long) BufferedChannelKt.b;
            long j5 = j3 / j4;
            int i2 = (int) (j3 % j4);
            if (channelSegment2.e != j5) {
                ChannelSegment d2 = d(this, j5, channelSegment2);
                if (d2 != null) {
                    channelSegment = d2;
                } else if (F) {
                    return new ChannelResult.Closed(B());
                }
            } else {
                channelSegment = channelSegment2;
            }
            ChannelSegment channelSegment3 = channelSegment;
            int i3 = i2;
            int i4 = i(this, channelSegment, i2, obj, j3, symbol, F);
            if (i4 != 0) {
                if (i4 == 1) {
                    break;
                } else if (i4 != 2) {
                    if (i4 == 3) {
                        throw new IllegalStateException("unexpected");
                    } else if (i4 != 4) {
                        if (i4 == 5) {
                            channelSegment3.a();
                        }
                        channelSegment2 = channelSegment3;
                        z2 = false;
                    } else {
                        if (j3 < g.get(this)) {
                            channelSegment3.a();
                        }
                        return new ChannelResult.Closed(B());
                    }
                } else if (F) {
                    channelSegment3.i();
                    return new ChannelResult.Closed(B());
                } else {
                    if (symbol instanceof Waiter) {
                        waiter = (Waiter) symbol;
                    } else {
                        waiter = null;
                    }
                    ChannelSegment channelSegment4 = channelSegment3;
                    if (waiter != null) {
                        f(this, waiter, channelSegment4, i3);
                    }
                    channelSegment4.i();
                    return failed;
                }
            } else {
                channelSegment3.a();
                break;
            }
        }
        return Unit.f696a;
    }
}
