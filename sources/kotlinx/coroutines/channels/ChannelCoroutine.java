package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005HA¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0001¢\u0006\u0004\b\b\u0010\u0007R\u000b\u0010\n\u001a\u00020\t8\u0016X\u0005R\u000b\u0010\u000b\u001a\u00020\t8\u0016X\u0005R\u000b\u0010\f\u001a\u00020\t8\u0016X\u0005R\u0011\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0016X\u0005R\u0017\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\r8\u0016X\u0005R\u0013\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\r8\u0016X\u0005R\u001d\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00118\u0016X\u0005¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching", "()Lkotlinx/coroutines/channels/ChannelResult;", "tryReceive", "", "isClosedForReceive", "isClosedForSend", "isEmpty", "Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "onReceiveCatching", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "onSend", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannelCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,39:1\n732#2,3:40\n732#2,3:43\n732#2,3:46\n*S KotlinDebug\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n*L\n17#1:40,3\n23#1:43,3\n30#1:46,3\n*E\n"})
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    public final BufferedChannel f;

    public ChannelCoroutine(CoroutineContext coroutineContext, BufferedChannel bufferedChannel) {
        super(coroutineContext, true);
        this.f = bufferedChannel;
    }

    public Object A(Object obj, Continuation continuation) {
        return this.f.A(obj, continuation);
    }

    public final boolean C() {
        return this.f.C();
    }

    public final void K(CancellationException cancellationException) {
        CancellationException m0 = JobSupport.m0(this, cancellationException);
        this.f.p(m0);
        J(m0);
    }

    public final SelectClause1 a() {
        return this.f.a();
    }

    public final SelectClause1 b() {
        return this.f.b();
    }

    public final void c(CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new JobCancellationException(M(), (Throwable) null, this);
            }
            K(cancellationException);
        }
    }

    public final Object h() {
        return this.f.h();
    }

    public final ChannelIterator iterator() {
        BufferedChannel bufferedChannel = this.f;
        bufferedChannel.getClass();
        return new BufferedChannel.BufferedChannelIterator();
    }

    public final Object n(Continuation continuation) {
        return this.f.n(continuation);
    }

    public boolean o(Throwable th) {
        return this.f.o(th);
    }

    public final Object t(ContinuationImpl continuationImpl) {
        BufferedChannel bufferedChannel = this.f;
        bufferedChannel.getClass();
        Object L = BufferedChannel.L(bufferedChannel, continuationImpl);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return L;
    }

    public final void w(Function1 function1) {
        this.f.w(function1);
    }

    public Object z(Object obj) {
        return this.f.z(obj);
    }
}
