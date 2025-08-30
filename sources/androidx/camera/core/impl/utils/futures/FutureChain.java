package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureChain<V> implements ListenableFuture<V> {
    @Nullable
    CallbackToFutureAdapter.Completer<V> mCompleter;
    @NonNull
    private final ListenableFuture<V> mDelegate;

    public FutureChain(@NonNull ListenableFuture<V> listenableFuture) {
        this.mDelegate = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    @NonNull
    public static <V> FutureChain<V> from(@NonNull ListenableFuture<V> listenableFuture) {
        if (listenableFuture instanceof FutureChain) {
            return (FutureChain) listenableFuture;
        }
        return new FutureChain<>(listenableFuture);
    }

    public final void addCallback(@NonNull FutureCallback<? super V> futureCallback, @NonNull Executor executor) {
        Futures.addCallback(this, futureCallback, executor);
    }

    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.mDelegate.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        return this.mDelegate.cancel(z);
    }

    @Nullable
    public V get() throws InterruptedException, ExecutionException {
        return this.mDelegate.get();
    }

    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    public boolean set(@Nullable V v) {
        CallbackToFutureAdapter.Completer<V> completer = this.mCompleter;
        if (completer != null) {
            return completer.set(v);
        }
        return false;
    }

    public boolean setException(@NonNull Throwable th) {
        CallbackToFutureAdapter.Completer<V> completer = this.mCompleter;
        if (completer != null) {
            return completer.setException(th);
        }
        return false;
    }

    @NonNull
    public final <T> FutureChain<T> transform(@NonNull Function<? super V, T> function, @NonNull Executor executor) {
        return (FutureChain) Futures.transform(this, function, executor);
    }

    @NonNull
    public final <T> FutureChain<T> transformAsync(@NonNull AsyncFunction<? super V, T> asyncFunction, @NonNull Executor executor) {
        return (FutureChain) Futures.transformAsync(this, asyncFunction, executor);
    }

    @Nullable
    public V get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mDelegate.get(j, timeUnit);
    }

    public FutureChain() {
        this.mDelegate = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<V>() {
            public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<V> completer) {
                boolean z;
                if (FutureChain.this.mCompleter == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z, "The result can only set once!");
                FutureChain.this.mCompleter = completer;
                return "FutureChain[" + FutureChain.this + "]";
            }
        });
    }
}
