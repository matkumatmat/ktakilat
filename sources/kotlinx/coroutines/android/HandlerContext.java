package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "kotlinx-coroutines-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,212:1\n13#2:213\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n*L\n140#1:213\n*E\n"})
public final class HandlerContext extends HandlerDispatcher implements Delay {
    public final Handler c;
    public final String d;
    public final boolean e;
    public final HandlerContext f;

    public HandlerContext(Handler handler, String str, boolean z) {
        HandlerContext handlerContext;
        this.c = handler;
        this.d = str;
        this.e = z;
        if (z) {
            handlerContext = this;
        } else {
            handlerContext = new HandlerContext(handler, str, true);
        }
        this.f = handlerContext;
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (!this.c.post(runnable)) {
            u(coroutineContext, runnable);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof HandlerContext) {
            HandlerContext handlerContext = (HandlerContext) obj;
            if (handlerContext.c == this.c && handlerContext.e == this.e) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void h(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 = new HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(cancellableContinuationImpl, this);
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.c.postDelayed(handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1, j)) {
            cancellableContinuationImpl.s(new da(this, handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1));
        } else {
            u(cancellableContinuationImpl.g, handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1);
        }
    }

    public final int hashCode() {
        int i;
        int identityHashCode = System.identityHashCode(this.c);
        if (this.e) {
            i = 1231;
        } else {
            i = 1237;
        }
        return identityHashCode ^ i;
    }

    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        if (!this.e || !Intrinsics.a(Looper.myLooper(), this.c.getLooper())) {
            return true;
        }
        return false;
    }

    public final DisposableHandle m(long j, Runnable runnable, CoroutineContext coroutineContext) {
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.c.postDelayed(runnable, j)) {
            return new ca(0, this, runnable);
        }
        u(coroutineContext, runnable);
        return NonDisposableHandle.c;
    }

    public final MainCoroutineDispatcher t() {
        return this.f;
    }

    public final String toString() {
        String str;
        MainCoroutineDispatcher mainCoroutineDispatcher;
        DefaultScheduler defaultScheduler = Dispatchers.f767a;
        MainCoroutineDispatcher mainCoroutineDispatcher2 = MainDispatcherLoader.f801a;
        if (this == mainCoroutineDispatcher2) {
            str = "Dispatchers.Main";
        } else {
            try {
                mainCoroutineDispatcher = mainCoroutineDispatcher2.t();
            } catch (UnsupportedOperationException unused) {
                mainCoroutineDispatcher = null;
            }
            if (this == mainCoroutineDispatcher) {
                str = "Dispatchers.Main.immediate";
            } else {
                str = null;
            }
        }
        if (str != null) {
            return str;
        }
        String str2 = this.d;
        if (str2 == null) {
            str2 = this.c.toString();
        }
        if (this.e) {
            return e.l(str2, ".immediate");
        }
        return str2;
    }

    public final void u(CoroutineContext coroutineContext, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        Job job = (Job) coroutineContext.get(Job.Key.c);
        if (job != null) {
            job.c(cancellationException);
        }
        DefaultScheduler defaultScheduler = Dispatchers.f767a;
        DefaultIoScheduler.c.dispatch(coroutineContext, runnable);
    }

    public HandlerContext(Handler handler) {
        this(handler, (String) null, false);
    }
}
