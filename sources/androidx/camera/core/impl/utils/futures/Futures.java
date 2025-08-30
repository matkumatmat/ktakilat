package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class Futures {
    private static final Function<?, ?> IDENTITY_FUNCTION = new Function<Object, Object>() {
        public Object apply(Object obj) {
            return obj;
        }
    };

    public static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> mCallback;
        final Future<V> mFuture;

        public CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.mFuture = future;
            this.mCallback = futureCallback;
        }

        public void run() {
            try {
                this.mCallback.onSuccess(Futures.getDone(this.mFuture));
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    this.mCallback.onFailure(e);
                } else {
                    this.mCallback.onFailure(cause);
                }
            } catch (Error | RuntimeException e2) {
                this.mCallback.onFailure(e2);
            }
        }

        @NonNull
        public String toString() {
            return CallbackListener.class.getSimpleName() + "," + this.mCallback;
        }
    }

    private Futures() {
    }

    public static <V> void addCallback(@NonNull ListenableFuture<V> listenableFuture, @NonNull FutureCallback<? super V> futureCallback, @NonNull Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    @NonNull
    public static <V> ListenableFuture<List<V>> allAsList(@NonNull Collection<? extends ListenableFuture<? extends V>> collection) {
        return new ListFuture(new ArrayList(collection), true, CameraXExecutors.directExecutor());
    }

    @Nullable
    public static <V> V getDone(@NonNull Future<V> future) throws ExecutionException {
        boolean isDone = future.isDone();
        Preconditions.checkState(isDone, "Future was expected to be done, " + future);
        return getUninterruptibly(future);
    }

    @Nullable
    public static <V> V getUninterruptibly(@NonNull Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    @NonNull
    public static <V> ListenableFuture<V> immediateFailedFuture(@NonNull Throwable th) {
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    @NonNull
    public static <V> ScheduledFuture<V> immediateFailedScheduledFuture(@NonNull Throwable th) {
        return new ImmediateFuture.ImmediateFailedScheduledFuture(th);
    }

    @NonNull
    public static <V> ListenableFuture<V> immediateFuture(@Nullable V v) {
        if (v == null) {
            return ImmediateFuture.nullFuture();
        }
        return new ImmediateFuture.ImmediateSuccessfulFuture(v);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$makeTimeoutFuture$3(ListenableFuture listenableFuture, ScheduledExecutorService scheduledExecutorService, long j, CallbackToFutureAdapter.Completer completer) throws Exception {
        propagate(listenableFuture, completer);
        if (!listenableFuture.isDone()) {
            listenableFuture.addListener(new p9(scheduledExecutorService.schedule(new q9(completer, listenableFuture, j), j, TimeUnit.MILLISECONDS), 1), CameraXExecutors.directExecutor());
        }
        return "TimeoutFuture[" + listenableFuture + "]";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$makeTimeoutFuture$4(CallbackToFutureAdapter.Completer completer, Object obj, boolean z, ListenableFuture listenableFuture) {
        completer.set(obj);
        if (z) {
            listenableFuture.cancel(true);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$makeTimeoutFuture$6(ListenableFuture listenableFuture, ScheduledExecutorService scheduledExecutorService, Object obj, boolean z, long j, CallbackToFutureAdapter.Completer completer) throws Exception {
        propagate(listenableFuture, completer);
        if (!listenableFuture.isDone()) {
            listenableFuture.addListener(new p9(scheduledExecutorService.schedule(new o9(completer, obj, z, listenableFuture), j, TimeUnit.MILLISECONDS), 0), CameraXExecutors.directExecutor());
        }
        return "TimeoutFuture[" + listenableFuture + "]";
    }

    @NonNull
    public static <V> ListenableFuture<V> makeTimeoutFuture(long j, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull ListenableFuture<V> listenableFuture) {
        return CallbackToFutureAdapter.getFuture(new e4((Object) listenableFuture, (Object) scheduledExecutorService, j));
    }

    @NonNull
    public static <V> ListenableFuture<V> nonCancellationPropagating(@NonNull ListenableFuture<V> listenableFuture) {
        Preconditions.checkNotNull(listenableFuture);
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        return CallbackToFutureAdapter.getFuture(new m9(listenableFuture, 1));
    }

    public static <V> void propagate(@NonNull ListenableFuture<V> listenableFuture, @NonNull CallbackToFutureAdapter.Completer<V> completer) {
        propagateTransform(listenableFuture, IDENTITY_FUNCTION, completer, CameraXExecutors.directExecutor());
    }

    public static <I, O> void propagateTransform(@NonNull ListenableFuture<I> listenableFuture, @NonNull Function<? super I, ? extends O> function, @NonNull CallbackToFutureAdapter.Completer<O> completer, @NonNull Executor executor) {
        propagateTransform(true, listenableFuture, function, completer, executor);
    }

    @NonNull
    public static <V> ListenableFuture<List<V>> successfulAsList(@NonNull Collection<? extends ListenableFuture<? extends V>> collection) {
        return new ListFuture(new ArrayList(collection), false, CameraXExecutors.directExecutor());
    }

    @NonNull
    public static <I, O> ListenableFuture<O> transform(@NonNull ListenableFuture<I> listenableFuture, @NonNull final Function<? super I, ? extends O> function, @NonNull Executor executor) {
        Preconditions.checkNotNull(function);
        return transformAsync(listenableFuture, new AsyncFunction<I, O>() {
            @NonNull
            public ListenableFuture<O> apply(I i) {
                return Futures.immediateFuture(Function.this.apply(i));
            }
        }, executor);
    }

    @NonNull
    public static <I, O> ListenableFuture<O> transformAsync(@NonNull ListenableFuture<I> listenableFuture, @NonNull AsyncFunction<? super I, ? extends O> asyncFunction, @NonNull Executor executor) {
        ChainingListenableFuture chainingListenableFuture = new ChainingListenableFuture(asyncFunction, listenableFuture);
        listenableFuture.addListener(chainingListenableFuture, executor);
        return chainingListenableFuture;
    }

    @NonNull
    public static <V> ListenableFuture<Void> transformAsyncOnCompletion(@NonNull ListenableFuture<V> listenableFuture) {
        return CallbackToFutureAdapter.getFuture(new m9(listenableFuture, 0));
    }

    @NonNull
    public static <V> ListenableFuture<V> makeTimeoutFuture(long j, @NonNull ScheduledExecutorService scheduledExecutorService, @Nullable V v, boolean z, @NonNull ListenableFuture<V> listenableFuture) {
        return CallbackToFutureAdapter.getFuture(new n9(j, scheduledExecutorService, v, z, listenableFuture));
    }

    /* access modifiers changed from: private */
    public static <I, O> void propagateTransform(boolean z, @NonNull final ListenableFuture<I> listenableFuture, @NonNull final Function<? super I, ? extends O> function, @NonNull final CallbackToFutureAdapter.Completer<O> completer, @NonNull Executor executor) {
        Preconditions.checkNotNull(listenableFuture);
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(completer);
        Preconditions.checkNotNull(executor);
        addCallback(listenableFuture, new FutureCallback<I>() {
            public void onFailure(@NonNull Throwable th) {
                CallbackToFutureAdapter.Completer.this.setException(th);
            }

            public void onSuccess(@Nullable I i) {
                try {
                    CallbackToFutureAdapter.Completer.this.set(function.apply(i));
                } catch (Throwable th) {
                    CallbackToFutureAdapter.Completer.this.setException(th);
                }
            }
        }, executor);
        if (z) {
            completer.addCancellationListener(new Runnable() {
                public void run() {
                    ListenableFuture.this.cancel(true);
                }
            }, CameraXExecutors.directExecutor());
        }
    }
}
