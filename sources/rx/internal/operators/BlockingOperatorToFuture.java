package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public final class BlockingOperatorToFuture {
    private BlockingOperatorToFuture() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Future<T> toFuture(Observable<? extends T> observable) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final Subscription subscribe = observable.single().subscribe(new Subscriber<T>() {
            public void onCompleted() {
                countDownLatch.countDown();
            }

            /* JADX WARNING: Removed duplicated region for block: B:1:0x0002 A[LOOP:0: B:1:0x0002->B:4:0x000e, LOOP_START] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onError(java.lang.Throwable r3) {
                /*
                    r2 = this;
                    java.util.concurrent.atomic.AtomicReference r0 = r2
                L_0x0002:
                    r1 = 0
                    boolean r1 = r0.compareAndSet(r1, r3)
                    if (r1 == 0) goto L_0x000a
                    goto L_0x0010
                L_0x000a:
                    java.lang.Object r1 = r0.get()
                    if (r1 == 0) goto L_0x0002
                L_0x0010:
                    java.util.concurrent.CountDownLatch r3 = r0
                    r3.countDown()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.BlockingOperatorToFuture.AnonymousClass1.onError(java.lang.Throwable):void");
            }

            public void onNext(T t) {
                atomicReference.set(t);
            }
        });
        return new Future<T>() {
            private volatile boolean cancelled;

            private T getValue() throws ExecutionException {
                Throwable th = (Throwable) atomicReference2.get();
                if (th != null) {
                    throw new ExecutionException("Observable onError", th);
                } else if (!this.cancelled) {
                    return atomicReference.get();
                } else {
                    throw new CancellationException("Subscription unsubscribed");
                }
            }

            public boolean cancel(boolean z) {
                if (countDownLatch.getCount() <= 0) {
                    return false;
                }
                this.cancelled = true;
                subscribe.unsubscribe();
                countDownLatch.countDown();
                return true;
            }

            public T get() throws InterruptedException, ExecutionException {
                countDownLatch.await();
                return getValue();
            }

            public boolean isCancelled() {
                return this.cancelled;
            }

            public boolean isDone() {
                if (countDownLatch.getCount() == 0) {
                    return true;
                }
                return false;
            }

            public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                if (countDownLatch.await(j, timeUnit)) {
                    return getValue();
                }
                throw new TimeoutException("Timed out after " + timeUnit.toMillis(j) + "ms waiting for underlying Observable.");
            }
        };
    }
}
