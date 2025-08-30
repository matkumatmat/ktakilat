package kotlinx.coroutines;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class BuildersKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: kotlinx.coroutines.LazyDeferredCoroutine} */
    /* JADX WARNING: type inference failed for: r2v3, types: [kotlin.coroutines.Continuation, kotlinx.coroutines.Deferred, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlinx.coroutines.Deferred a(kotlinx.coroutines.CoroutineScope r1, kotlinx.coroutines.MainCoroutineDispatcher r2, kotlin.jvm.functions.Function2 r3, int r4) {
        /*
            r0 = 1
            r4 = r4 & r0
            if (r4 == 0) goto L_0x0006
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
        L_0x0006:
            kotlinx.coroutines.CoroutineStart r4 = kotlinx.coroutines.CoroutineStart.DEFAULT
            kotlin.coroutines.CoroutineContext r1 = kotlinx.coroutines.CoroutineContextKt.b(r1, r2)
            boolean r2 = r4.isLazy()
            if (r2 == 0) goto L_0x0018
            kotlinx.coroutines.LazyDeferredCoroutine r2 = new kotlinx.coroutines.LazyDeferredCoroutine
            r2.<init>(r1, r3)
            goto L_0x001d
        L_0x0018:
            kotlinx.coroutines.DeferredCoroutine r2 = new kotlinx.coroutines.DeferredCoroutine
            r2.<init>(r1, r0)
        L_0x001d:
            r4.invoke(r3, r2, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.BuildersKt.a(kotlinx.coroutines.CoroutineScope, kotlinx.coroutines.MainCoroutineDispatcher, kotlin.jvm.functions.Function2, int):kotlinx.coroutines.Deferred");
    }

    public static Job b(CoroutineScope coroutineScope, MainCoroutineDispatcher mainCoroutineDispatcher, CoroutineStart coroutineStart, Function2 function2, int i) {
        AbstractCoroutine abstractCoroutine;
        CoroutineContext coroutineContext = mainCoroutineDispatcher;
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineContext b = CoroutineContextKt.b(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            abstractCoroutine = new LazyStandaloneCoroutine(b, function2);
        } else {
            abstractCoroutine = new AbstractCoroutine(b, true);
        }
        coroutineStart.invoke(function2, abstractCoroutine, abstractCoroutine);
        return abstractCoroutine;
    }

    public static Object c(Function2 function2) {
        EventLoop eventLoop;
        CoroutineContext coroutineContext;
        long j;
        CompletedExceptionally completedExceptionally;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) emptyCoroutineContext.get(ContinuationInterceptor.b);
        GlobalScope globalScope = GlobalScope.c;
        if (continuationInterceptor == null) {
            eventLoop = ThreadLocalEventLoop.a();
            coroutineContext = CoroutineContextKt.b(globalScope, emptyCoroutineContext.plus(eventLoop));
        } else {
            if (continuationInterceptor instanceof EventLoop) {
                EventLoop eventLoop2 = (EventLoop) continuationInterceptor;
            }
            eventLoop = (EventLoop) ThreadLocalEventLoop.f771a.get();
            coroutineContext = CoroutineContextKt.b(globalScope, emptyCoroutineContext);
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(coroutineContext, currentThread, eventLoop);
        CoroutineStart.DEFAULT.invoke(function2, blockingCoroutine, blockingCoroutine);
        EventLoop eventLoop3 = blockingCoroutine.g;
        if (eventLoop3 != null) {
            int i = EventLoop.f;
            eventLoop3.w(false);
        }
        while (!Thread.interrupted()) {
            try {
                if (eventLoop3 != null) {
                    j = eventLoop3.A();
                } else {
                    j = LocationRequestCompat.PASSIVE_INTERVAL;
                }
                if (!blockingCoroutine.y()) {
                    LockSupport.parkNanos(blockingCoroutine, j);
                } else {
                    if (eventLoop3 != null) {
                        int i2 = EventLoop.f;
                        eventLoop3.t(false);
                    }
                    Object a2 = JobSupportKt.a(JobSupport.c.get(blockingCoroutine));
                    if (a2 instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) a2;
                    } else {
                        completedExceptionally = null;
                    }
                    if (completedExceptionally == null) {
                        return a2;
                    }
                    throw completedExceptionally.f764a;
                }
            } catch (Throwable th) {
                if (eventLoop3 != null) {
                    int i3 = EventLoop.f;
                    eventLoop3.t(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        blockingCoroutine.J(interruptedException);
        throw interruptedException;
    }

    public static final Object d(Function2 function2, CoroutineContext coroutineContext, Continuation continuation) {
        CoroutineContext coroutineContext2;
        Object obj;
        CoroutineContext context = continuation.getContext();
        if (!((Boolean) coroutineContext.fold(Boolean.FALSE, new e3(3))).booleanValue()) {
            coroutineContext2 = context.plus(coroutineContext);
        } else {
            coroutineContext2 = CoroutineContextKt.a(context, coroutineContext, false);
        }
        JobKt.a(coroutineContext2);
        if (coroutineContext2 != context) {
            ContinuationInterceptor.Key key = ContinuationInterceptor.b;
            if (!Intrinsics.a(coroutineContext2.get(key), context.get(key))) {
                ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation, coroutineContext2);
                CancellableKt.b(function2, scopeCoroutine, scopeCoroutine);
                while (true) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = DispatchedCoroutine.g;
                    int i = atomicIntegerFieldUpdater.get(scopeCoroutine);
                    if (i == 0) {
                        if (atomicIntegerFieldUpdater.compareAndSet(scopeCoroutine, 0, 1)) {
                            obj = CoroutineSingletons.COROUTINE_SUSPENDED;
                            break;
                        }
                    } else if (i == 2) {
                        obj = JobSupportKt.a(JobSupport.c.get(scopeCoroutine));
                        if (obj instanceof CompletedExceptionally) {
                            throw ((CompletedExceptionally) obj).f764a;
                        }
                    } else {
                        throw new IllegalStateException("Already suspended");
                    }
                }
            } else {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(continuation, coroutineContext2);
                CoroutineContext coroutineContext3 = undispatchedCoroutine.e;
                Object c = ThreadContextKt.c(coroutineContext3, (Object) null);
                try {
                    obj = UndispatchedKt.a(undispatchedCoroutine, undispatchedCoroutine, function2);
                } finally {
                    ThreadContextKt.a(coroutineContext3, c);
                }
            }
        } else {
            ScopeCoroutine scopeCoroutine2 = new ScopeCoroutine(continuation, coroutineContext2);
            obj = UndispatchedKt.a(scopeCoroutine2, scopeCoroutine2, function2);
        }
        if (obj == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
        }
        return obj;
    }
}
