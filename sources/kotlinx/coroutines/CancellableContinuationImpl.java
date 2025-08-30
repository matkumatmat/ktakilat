package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

@SourceDebugExtension({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,701:1\n227#1,10:705\n227#1,10:716\n1#2:702\n20#3:703\n20#3:704\n18#3:715\n17#3:726\n18#3,3:727\n17#3:730\n18#3,3:731\n18#3:738\n17#3,4:739\n57#4,2:734\n57#4,2:736\n57#4,2:743\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n239#1:705,10\n244#1:716,10\n69#1:703\n155#1:704\n242#1:715\n271#1:726\n272#1:727,3\n281#1:730\n282#1:731,3\n387#1:738\n390#1:739,4\n323#1:734,2\n333#1:736,2\n614#1:743,2\n*E\n"})
@PublishedApi
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006R\u000b\u0010\b\u001a\u00020\u00078\u0002X\u0004R\u0013\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0002X\u0004R\u0013\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\t8\u0002X\u0004¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "Lkotlinx/atomicfu/AtomicInt;", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicRef;", "", "_state", "Lkotlinx/coroutines/DisposableHandle;", "_parentHandle", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {
    public static final /* synthetic */ AtomicIntegerFieldUpdater i;
    public static final /* synthetic */ AtomicReferenceFieldUpdater j;
    public static final /* synthetic */ AtomicReferenceFieldUpdater k;
    private volatile /* synthetic */ int _decisionAndIndex$volatile = 536870911;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile = Active.c;
    public final Continuation f;
    public final CoroutineContext g;

    static {
        Class<CancellableContinuationImpl> cls = CancellableContinuationImpl.class;
        i = AtomicIntegerFieldUpdater.newUpdater(cls, "_decisionAndIndex$volatile");
        Class<Object> cls2 = Object.class;
        j = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state$volatile");
        k = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle$volatile");
    }

    public CancellableContinuationImpl(int i2, Continuation continuation) {
        super(i2);
        this.f = continuation;
        this.g = continuation.getContext();
    }

    public static Object B(NotCompleted notCompleted, Object obj, int i2, Function3 function3) {
        CancelHandler cancelHandler;
        if ((obj instanceof CompletedExceptionally) || !DispatchedTaskKt.a(i2)) {
            return obj;
        }
        if (function3 == null && !(notCompleted instanceof CancelHandler)) {
            return obj;
        }
        if (notCompleted instanceof CancelHandler) {
            cancelHandler = (CancelHandler) notCompleted;
        } else {
            cancelHandler = null;
        }
        return new CompletedContinuation(obj, cancelHandler, function3, (CancellationException) null, 16);
    }

    public static void w(NotCompleted notCompleted, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + notCompleted + ", already has " + obj).toString());
    }

    public final void A(CoroutineDispatcher coroutineDispatcher, Object obj) {
        DispatchedContinuation dispatchedContinuation;
        CoroutineDispatcher coroutineDispatcher2;
        int i2;
        Continuation continuation = this.f;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.f;
        } else {
            coroutineDispatcher2 = null;
        }
        if (coroutineDispatcher2 == coroutineDispatcher) {
            i2 = 4;
        } else {
            i2 = this.e;
        }
        z(obj, i2, (Function3) null);
    }

    public final Symbol C(Object obj, Function3 function3) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z = obj2 instanceof NotCompleted;
            Symbol symbol = CancellableContinuationImplKt.f762a;
            if (z) {
                Object B = B((NotCompleted) obj2, obj, this.e, function3);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, B)) {
                        if (!v()) {
                            m();
                        }
                        return symbol;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    }
                }
            } else {
                boolean z2 = obj2 instanceof CompletedContinuation;
                return null;
            }
        }
    }

    public final void F(Object obj) {
        n(this.e);
    }

    public final void a(CancellationException cancellationException) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof NotCompleted) {
                throw new IllegalStateException("Not completed");
            } else if (!(obj instanceof CompletedExceptionally)) {
                if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.e == null) {
                        CompletedContinuation a2 = CompletedContinuation.a(completedContinuation, (CancelHandler) null, cancellationException, 15);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, a2)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                            }
                        }
                        CancelHandler cancelHandler = completedContinuation.b;
                        if (cancelHandler != null) {
                            h(cancelHandler, cancellationException);
                        }
                        Function3 function3 = completedContinuation.c;
                        if (function3 != null) {
                            j(function3, cancellationException, completedContinuation.f763a);
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("Must be called at most once");
                }
                CompletedContinuation completedContinuation2 = new CompletedContinuation(obj, (CancelHandler) null, (Function3) null, cancellationException, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, completedContinuation2)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            } else {
                return;
            }
        }
    }

    public final void b(Segment segment, int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = i;
            i3 = atomicIntegerFieldUpdater.get(this);
            if ((i3 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, ((i3 >> 29) << 29) + i2));
        t(segment);
    }

    public final Continuation c() {
        return this.f;
    }

    public final Throwable d(Object obj) {
        Throwable d = super.d(obj);
        if (d != null) {
            return d;
        }
        return null;
    }

    public final Object e(Object obj) {
        if (obj instanceof CompletedContinuation) {
            return ((CompletedContinuation) obj).f763a;
        }
        return obj;
    }

    public final Object g() {
        return j.get(this);
    }

    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public final CoroutineContext getContext() {
        return this.g;
    }

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void h(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.d(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(this.g, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final Symbol i(Object obj, Function3 function3) {
        return C(obj, function3);
    }

    public final void j(Function3 function3, Throwable th, Object obj) {
        CoroutineContext coroutineContext = this.g;
        try {
            function3.invoke(th, obj, coroutineContext);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(coroutineContext, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void k(Segment segment, Throwable th) {
        CoroutineContext coroutineContext = this.g;
        int i2 = i.get(this) & 536870911;
        if (i2 != 536870911) {
            try {
                segment.h(i2, coroutineContext);
            } catch (Throwable th2) {
                CoroutineExceptionHandlerKt.a(coroutineContext, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
            }
        } else {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
    }

    public final void l(Object obj, Function3 function3) {
        z(obj, this.e, function3);
    }

    public final void m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k;
        DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater.get(this);
        if (disposableHandle != null) {
            disposableHandle.dispose();
            atomicReferenceFieldUpdater.set(this, NonDisposableHandle.c);
        }
    }

    public final void n(int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        boolean z;
        do {
            atomicIntegerFieldUpdater = i;
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 == 1) {
                    if (i2 == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Continuation continuation = this.f;
                    if (z || !(continuation instanceof DispatchedContinuation) || DispatchedTaskKt.a(i2) != DispatchedTaskKt.a(this.e)) {
                        DispatchedTaskKt.b(this, continuation, z);
                        return;
                    }
                    DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
                    CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.f;
                    CoroutineContext context = dispatchedContinuation.g.getContext();
                    if (coroutineDispatcher.isDispatchNeeded(context)) {
                        coroutineDispatcher.dispatch(context, this);
                        return;
                    }
                    EventLoop a2 = ThreadLocalEventLoop.a();
                    if (a2.z()) {
                        a2.u(this);
                        return;
                    }
                    a2.w(true);
                    try {
                        DispatchedTaskKt.b(this, continuation, true);
                        do {
                        } while (a2.C());
                    } catch (Throwable th) {
                        a2.t(true);
                        throw th;
                    }
                    a2.t(true);
                    return;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, 1073741824 + (536870911 & i3)));
    }

    public Throwable o(JobSupport jobSupport) {
        return jobSupport.g();
    }

    public final Object p() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        boolean v = v();
        do {
            atomicIntegerFieldUpdater = i;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 == 2) {
                    if (v) {
                        y();
                    }
                    Object obj = j.get(this);
                    if (!(obj instanceof CompletedExceptionally)) {
                        if (DispatchedTaskKt.a(this.e)) {
                            Job job = (Job) this.g.get(Job.Key.c);
                            if (job != null && !job.isActive()) {
                                CancellationException g2 = job.g();
                                a(g2);
                                throw g2;
                            }
                        }
                        return e(obj);
                    }
                    throw ((CompletedExceptionally) obj).f764a;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 536870912 + (536870911 & i2)));
        if (((DisposableHandle) k.get(this)) == null) {
            r();
        }
        if (v) {
            y();
        }
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    public final void q() {
        DisposableHandle r = r();
        if (r != null && !(j.get(this) instanceof NotCompleted)) {
            r.dispose();
            k.set(this, NonDisposableHandle.c);
        }
    }

    public final DisposableHandle r() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Job job = (Job) this.g.get(Job.Key.c);
        if (job == null) {
            return null;
        }
        DisposableHandle c = JobKt.c(job, true, new ChildContinuation(this));
        do {
            atomicReferenceFieldUpdater = k;
            if (atomicReferenceFieldUpdater.compareAndSet(this, (Object) null, c) || atomicReferenceFieldUpdater.get(this) != null) {
                return c;
            }
            atomicReferenceFieldUpdater = k;
            break;
        } while (atomicReferenceFieldUpdater.get(this) != null);
        return c;
    }

    public final void resumeWith(Object obj) {
        Throwable r0 = Result.m19exceptionOrNullimpl(obj);
        if (r0 != null) {
            obj = new CompletedExceptionally(false, r0);
        }
        z(obj, this.e, (Function3) null);
    }

    public final void s(Function1 function1) {
        t(new CancelHandler.UserSupplied(function1));
    }

    public final void t(NotCompleted notCompleted) {
        Object obj;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof Active) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, notCompleted)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            Throwable th = null;
            if ((obj instanceof CancelHandler) || (obj instanceof Segment)) {
                w(notCompleted, obj);
            } else if (obj instanceof CompletedExceptionally) {
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                completedExceptionally.getClass();
                if (!CompletedExceptionally.b.compareAndSet(completedExceptionally, 0, 1)) {
                    w(notCompleted, obj);
                    throw null;
                } else if (obj instanceof CancelledContinuation) {
                    if (!(obj instanceof CompletedExceptionally)) {
                        completedExceptionally = null;
                    }
                    if (completedExceptionally != null) {
                        th = completedExceptionally.f764a;
                    }
                    if (notCompleted instanceof CancelHandler) {
                        h((CancelHandler) notCompleted, th);
                        return;
                    }
                    Intrinsics.d(notCompleted, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                    k((Segment) notCompleted, th);
                    return;
                } else {
                    return;
                }
            } else if (obj instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                if (completedContinuation.b != null) {
                    w(notCompleted, obj);
                    throw null;
                } else if (!(notCompleted instanceof Segment)) {
                    Intrinsics.d(notCompleted, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    CancelHandler cancelHandler = (CancelHandler) notCompleted;
                    Throwable th2 = completedContinuation.e;
                    if (th2 != null) {
                        h(cancelHandler, th2);
                        return;
                    }
                    CompletedContinuation a2 = CompletedContinuation.a(completedContinuation, cancelHandler, (CancellationException) null, 29);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, a2)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                        }
                    }
                    return;
                } else {
                    return;
                }
            } else if (!(notCompleted instanceof Segment)) {
                Intrinsics.d(notCompleted, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                CompletedContinuation completedContinuation2 = new CompletedContinuation(obj, (CancelHandler) notCompleted, (Function3) null, (CancellationException) null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, completedContinuation2)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            } else {
                return;
            }
        }
        w(notCompleted, obj);
        throw null;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(x());
        sb.append('(');
        sb.append(DebugStringsKt.b(this.f));
        sb.append("){");
        Object obj = j.get(this);
        if (obj instanceof NotCompleted) {
            str = "Active";
        } else if (obj instanceof CancelledContinuation) {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        } else {
            str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        }
        sb.append(str);
        sb.append("}@");
        sb.append(DebugStringsKt.a(this));
        return sb.toString();
    }

    public final boolean u(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z = false;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            if ((obj instanceof CancelHandler) || (obj instanceof Segment)) {
                z = true;
            }
            CancelledContinuation cancelledContinuation = new CancelledContinuation(this, th, z);
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, cancelledContinuation)) {
                    NotCompleted notCompleted = (NotCompleted) obj;
                    if (notCompleted instanceof CancelHandler) {
                        h((CancelHandler) obj, th);
                    } else if (notCompleted instanceof Segment) {
                        k((Segment) obj, th);
                    }
                    if (!v()) {
                        m();
                    }
                    n(this.e);
                    return true;
                } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                }
            }
        }
    }

    public final boolean v() {
        if (this.e == 2) {
            Continuation continuation = this.f;
            Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (DispatchedContinuation.k.get((DispatchedContinuation) continuation) != null) {
                return true;
            }
        }
        return false;
    }

    public String x() {
        return "CancellableContinuation";
    }

    public final void y() {
        DispatchedContinuation dispatchedContinuation;
        Continuation continuation = this.f;
        Throwable th = null;
        if (continuation instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) continuation;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation != null) {
            loop0:
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation.k;
                Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                Symbol symbol = DispatchedContinuationKt.b;
                if (obj == symbol) {
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, symbol, this)) {
                            break loop0;
                        } else if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != symbol) {
                        }
                    }
                } else if (obj instanceof Throwable) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, (Object) null)) {
                        if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = obj;
                } else {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                }
            }
            if (th != null) {
                m();
                u(th);
            }
        }
    }

    public final void z(Object obj, int i2, Function3 function3) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
                Object B = B((NotCompleted) obj2, obj, i2, function3);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, B)) {
                        if (!v()) {
                            m();
                        }
                        n(i2);
                        return;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    }
                }
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    cancelledContinuation.getClass();
                    if (CancelledContinuation.c.compareAndSet(cancelledContinuation, 0, 1)) {
                        if (function3 != null) {
                            j(function3, cancelledContinuation.f764a, obj);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
        }
    }
}
