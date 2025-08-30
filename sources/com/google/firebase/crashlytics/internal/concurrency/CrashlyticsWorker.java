package com.google.firebase.crashlytics.internal.concurrency;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CrashlyticsWorker implements Executor {
    private final ExecutorService executor;
    private Task<?> tail = Tasks.forResult(null);
    private final Object tailLock = new Object();

    public CrashlyticsWorker(ExecutorService executorService) {
        this.executor = executorService;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$await$6() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Task lambda$submitTask$2(Callable callable, Task task) throws Exception {
        return (Task) callable.call();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Task lambda$submitTask$3(Callable callable, Task task) throws Exception {
        return (Task) callable.call();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Task lambda$submitTaskOnSuccess$4(Callable callable, Task task) throws Exception {
        return (Task) callable.call();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Task lambda$submitTaskOnSuccess$5(SuccessContinuation successContinuation, Task task) throws Exception {
        if (task.isSuccessful()) {
            return successContinuation.then(task.getResult());
        }
        if (task.getException() != null) {
            return Tasks.forException(task.getException());
        }
        return Tasks.forCanceled();
    }

    @VisibleForTesting
    public void await() throws ExecutionException, InterruptedException, TimeoutException {
        Tasks.await(submit((Runnable) new v(3)), 30, TimeUnit.SECONDS);
        Thread.sleep(1);
    }

    public void execute(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    @CanIgnoreReturnValue
    public <T> Task<T> submit(Callable<T> callable) {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.tailLock) {
            continueWithTask = this.tail.continueWithTask(this.executor, new v4(callable, 0));
            this.tail = continueWithTask;
        }
        return continueWithTask;
    }

    @CanIgnoreReturnValue
    public <T> Task<T> submitTask(Callable<Task<T>> callable) {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.tailLock) {
            continueWithTask = this.tail.continueWithTask(this.executor, new v4(callable, 1));
            this.tail = continueWithTask;
        }
        return continueWithTask;
    }

    @CanIgnoreReturnValue
    public <T, R> Task<R> submitTaskOnSuccess(Callable<Task<T>> callable, SuccessContinuation<T, R> successContinuation) {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.tailLock) {
            continueWithTask = this.tail.continueWithTask(this.executor, new v4(callable, 3)).continueWithTask(this.executor, new k0(successContinuation, 15));
            this.tail = continueWithTask;
        }
        return continueWithTask;
    }

    @CanIgnoreReturnValue
    public Task<Void> submit(Runnable runnable) {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.tailLock) {
            continueWithTask = this.tail.continueWithTask(this.executor, new u4(runnable));
            this.tail = continueWithTask;
        }
        return continueWithTask;
    }

    @CanIgnoreReturnValue
    public <T, R> Task<R> submitTask(Callable<Task<T>> callable, Continuation<T, Task<R>> continuation) {
        Task<TContinuationResult> continueWithTask;
        synchronized (this.tailLock) {
            continueWithTask = this.tail.continueWithTask(this.executor, new v4(callable, 2)).continueWithTask(this.executor, continuation);
            this.tail = continueWithTask;
        }
        return continueWithTask;
    }
}
