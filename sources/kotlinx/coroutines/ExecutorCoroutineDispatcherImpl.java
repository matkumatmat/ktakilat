package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {
    public final Executor c;

    public ExecutorCoroutineDispatcherImpl(Executor executor) {
        this.c = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    public final void close() {
        ExecutorService executorService;
        Executor executor = this.c;
        if (executor instanceof ExecutorService) {
            executorService = (ExecutorService) executor;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            this.c.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            Job job = (Job) coroutineContext.get(Job.Key.c);
            if (job != null) {
                job.c(cancellationException);
            }
            DefaultScheduler defaultScheduler = Dispatchers.f767a;
            DefaultIoScheduler.c.dispatch(coroutineContext, runnable);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ExecutorCoroutineDispatcherImpl) || ((ExecutorCoroutineDispatcherImpl) obj).c != this.c) {
            return false;
        }
        return true;
    }

    public final void h(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        ScheduledExecutorService scheduledExecutorService;
        Executor executor = this.c;
        ScheduledFuture<?> scheduledFuture = null;
        if (executor instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) executor;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            try {
                scheduledFuture = scheduledExecutorService.schedule(new ResumeUndispatchedRunnable(this, cancellableContinuationImpl), j, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                Job job = (Job) cancellableContinuationImpl.g.get(Job.Key.c);
                if (job != null) {
                    job.c(cancellationException);
                }
            }
        }
        if (scheduledFuture != null) {
            cancellableContinuationImpl.t(new CancelFutureOnCancel(scheduledFuture));
        } else {
            DefaultExecutor.k.h(j, cancellableContinuationImpl);
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.c);
    }

    public final DisposableHandle m(long j, Runnable runnable, CoroutineContext coroutineContext) {
        ScheduledExecutorService scheduledExecutorService;
        Executor executor = this.c;
        ScheduledFuture<?> scheduledFuture = null;
        if (executor instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) executor;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            try {
                scheduledFuture = scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e);
                Job job = (Job) coroutineContext.get(Job.Key.c);
                if (job != null) {
                    job.c(cancellationException);
                }
            }
        }
        if (scheduledFuture != null) {
            return new DisposableFutureHandle(scheduledFuture);
        }
        return DefaultExecutor.k.m(j, runnable, coroutineContext);
    }

    public final Executor t() {
        return this.c;
    }

    public final String toString() {
        return this.c.toString();
    }
}
