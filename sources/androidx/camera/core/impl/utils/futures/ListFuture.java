package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

class ListFuture<V> implements ListenableFuture<List<V>> {
    private final boolean mAllMustSucceed;
    @Nullable
    List<? extends ListenableFuture<? extends V>> mFutures;
    @NonNull
    private final AtomicInteger mRemaining;
    @NonNull
    private final ListenableFuture<List<V>> mResult = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<List<V>>() {
        public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<List<V>> completer) {
            boolean z;
            if (ListFuture.this.mResultNotifier == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "The result can only set once!");
            ListFuture.this.mResultNotifier = completer;
            return "ListFuture[" + this + "]";
        }
    });
    CallbackToFutureAdapter.Completer<List<V>> mResultNotifier;
    @Nullable
    List<V> mValues;

    public ListFuture(@NonNull List<? extends ListenableFuture<? extends V>> list, boolean z, @NonNull Executor executor) {
        this.mFutures = (List) Preconditions.checkNotNull(list);
        this.mValues = new ArrayList(list.size());
        this.mAllMustSucceed = z;
        this.mRemaining = new AtomicInteger(list.size());
        init(executor);
    }

    private void callAllGets() throws InterruptedException {
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        if (list != null && !isDone()) {
            for (ListenableFuture listenableFuture : list) {
                while (true) {
                    if (!listenableFuture.isDone()) {
                        try {
                            listenableFuture.get();
                        } catch (Error e) {
                            throw e;
                        } catch (InterruptedException e2) {
                            throw e2;
                        } catch (Throwable unused) {
                            if (this.mAllMustSucceed) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private void init(@NonNull Executor executor) {
        addListener(new Runnable() {
            public void run() {
                ListFuture listFuture = ListFuture.this;
                listFuture.mValues = null;
                listFuture.mFutures = null;
            }
        }, CameraXExecutors.directExecutor());
        if (this.mFutures.isEmpty()) {
            this.mResultNotifier.set(new ArrayList(this.mValues));
            return;
        }
        for (int i = 0; i < this.mFutures.size(); i++) {
            this.mValues.add((Object) null);
        }
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        for (final int i2 = 0; i2 < list.size(); i2++) {
            final ListenableFuture listenableFuture = (ListenableFuture) list.get(i2);
            listenableFuture.addListener(new Runnable() {
                public void run() {
                    ListFuture.this.setOneValue(i2, listenableFuture);
                }
            }, executor);
        }
    }

    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.mResult.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        if (list != null) {
            for (ListenableFuture cancel : list) {
                cancel.cancel(z);
            }
        }
        return this.mResult.cancel(z);
    }

    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    public boolean isDone() {
        return this.mResult.isDone();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x00be */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOneValue(int r7, @androidx.annotation.NonNull java.util.concurrent.Future<? extends V> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Less than 0 remaining futures"
            java.util.List<V> r1 = r6.mValues
            boolean r2 = r6.isDone()
            if (r2 != 0) goto L_0x0108
            if (r1 != 0) goto L_0x000e
            goto L_0x0108
        L_0x000e:
            r2 = 1
            r3 = 0
            boolean r4 = r8.isDone()     // Catch:{ CancellationException -> 0x00be, ExecutionException -> 0x004f, RuntimeException -> 0x004d, Error -> 0x004b }
            java.lang.String r5 = "Tried to set value from future which is not done"
            androidx.core.util.Preconditions.checkState(r4, r5)     // Catch:{ CancellationException -> 0x00be, ExecutionException -> 0x004f, RuntimeException -> 0x004d, Error -> 0x004b }
            java.lang.Object r8 = androidx.camera.core.impl.utils.futures.Futures.getUninterruptibly(r8)     // Catch:{ CancellationException -> 0x00be, ExecutionException -> 0x004f, RuntimeException -> 0x004d, Error -> 0x004b }
            r1.set(r7, r8)     // Catch:{ CancellationException -> 0x00be, ExecutionException -> 0x004f, RuntimeException -> 0x004d, Error -> 0x004b }
            java.util.concurrent.atomic.AtomicInteger r7 = r6.mRemaining
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r7 != 0) goto L_0x00e1
            java.util.List<V> r7 = r6.mValues
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
        L_0x003a:
            r8.set(r0)
            goto L_0x00e1
        L_0x003f:
            boolean r7 = r6.isDone()
            androidx.core.util.Preconditions.checkState(r7)
            goto L_0x00e1
        L_0x0048:
            r7 = move-exception
            goto L_0x00e2
        L_0x004b:
            r7 = move-exception
            goto L_0x0051
        L_0x004d:
            r7 = move-exception
            goto L_0x0071
        L_0x004f:
            r7 = move-exception
            goto L_0x0095
        L_0x0051:
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier     // Catch:{ all -> 0x0048 }
            r8.setException(r7)     // Catch:{ all -> 0x0048 }
            java.util.concurrent.atomic.AtomicInteger r7 = r6.mRemaining
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r2 = 0
        L_0x0060:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r7 != 0) goto L_0x00e1
            java.util.List<V> r7 = r6.mValues
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x0071:
            boolean r8 = r6.mAllMustSucceed     // Catch:{ all -> 0x0048 }
            if (r8 == 0) goto L_0x007a
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier     // Catch:{ all -> 0x0048 }
            r8.setException(r7)     // Catch:{ all -> 0x0048 }
        L_0x007a:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.mRemaining
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r2 = 0
        L_0x0084:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r7 != 0) goto L_0x00e1
            java.util.List<V> r7 = r6.mValues
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x0095:
            boolean r8 = r6.mAllMustSucceed     // Catch:{ all -> 0x0048 }
            if (r8 == 0) goto L_0x00a2
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier     // Catch:{ all -> 0x0048 }
            java.lang.Throwable r7 = r7.getCause()     // Catch:{ all -> 0x0048 }
            r8.setException(r7)     // Catch:{ all -> 0x0048 }
        L_0x00a2:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.mRemaining
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x00ab
            goto L_0x00ac
        L_0x00ab:
            r2 = 0
        L_0x00ac:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r7 != 0) goto L_0x00e1
            java.util.List<V> r7 = r6.mValues
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x00be:
            boolean r7 = r6.mAllMustSucceed     // Catch:{ all -> 0x0048 }
            if (r7 == 0) goto L_0x00c5
            r6.cancel(r3)     // Catch:{ all -> 0x0048 }
        L_0x00c5:
            java.util.concurrent.atomic.AtomicInteger r7 = r6.mRemaining
            int r7 = r7.decrementAndGet()
            if (r7 < 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00ce:
            r2 = 0
        L_0x00cf:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r7 != 0) goto L_0x00e1
            java.util.List<V> r7 = r6.mValues
            if (r7 == 0) goto L_0x003f
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r8 = r6.mResultNotifier
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r7)
            goto L_0x003a
        L_0x00e1:
            return
        L_0x00e2:
            java.util.concurrent.atomic.AtomicInteger r8 = r6.mRemaining
            int r8 = r8.decrementAndGet()
            if (r8 < 0) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r2 = 0
        L_0x00ec:
            androidx.core.util.Preconditions.checkState(r2, r0)
            if (r8 != 0) goto L_0x0107
            java.util.List<V> r8 = r6.mValues
            if (r8 == 0) goto L_0x0100
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.util.List<V>> r0 = r6.mResultNotifier
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r8)
            r0.set(r1)
            goto L_0x0107
        L_0x0100:
            boolean r8 = r6.isDone()
            androidx.core.util.Preconditions.checkState(r8)
        L_0x0107:
            throw r7
        L_0x0108:
            boolean r7 = r6.mAllMustSucceed
            java.lang.String r8 = "Future was done before all dependencies completed"
            androidx.core.util.Preconditions.checkState(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.futures.ListFuture.setOneValue(int, java.util.concurrent.Future):void");
    }

    @Nullable
    public List<V> get() throws InterruptedException, ExecutionException {
        callAllGets();
        return this.mResult.get();
    }

    public List<V> get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mResult.get(j, timeUnit);
    }
}
