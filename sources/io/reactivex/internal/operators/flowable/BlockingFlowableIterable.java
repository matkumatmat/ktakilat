package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

public final class BlockingFlowableIterable<T> implements Iterable<T> {

    public static final class BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Iterator<T>, Runnable, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        public final SpscArrayQueue c = new SpscArrayQueue(0);
        public final long d = ((long) 0);
        public final long e = ((long) 0);
        public final ReentrantLock f;
        public final Condition g;
        public long i;
        public volatile boolean j;
        public Throwable k;

        public BlockingFlowableIterator() {
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f = reentrantLock;
            this.g = reentrantLock.newCondition();
        }

        public final void a() {
            ReentrantLock reentrantLock = this.f;
            reentrantLock.lock();
            try {
                this.g.signalAll();
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public final boolean hasNext() {
            while (true) {
                boolean z = this.j;
                boolean isEmpty = this.c.isEmpty();
                if (z) {
                    Throwable th = this.k;
                    if (th != null) {
                        throw ExceptionHelper.c(th);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                this.f.lock();
                while (!this.j && this.c.isEmpty()) {
                    try {
                        this.g.await();
                    } catch (InterruptedException e2) {
                        run();
                        throw ExceptionHelper.c(e2);
                    } catch (Throwable th2) {
                        this.f.unlock();
                        throw th2;
                    }
                }
                this.f.unlock();
            }
        }

        public final boolean isDisposed() {
            return SubscriptionHelper.isCancelled((Subscription) get());
        }

        public final Object next() {
            if (hasNext()) {
                Object poll = this.c.poll();
                long j2 = this.i + 1;
                if (j2 == this.e) {
                    this.i = 0;
                    ((Subscription) get()).request(j2);
                } else {
                    this.i = j2;
                }
                return poll;
            }
            throw new NoSuchElementException();
        }

        public final void onComplete() {
            this.j = true;
            a();
        }

        public final void onError(Throwable th) {
            this.k = th;
            this.j = true;
            a();
        }

        public final void onNext(Object obj) {
            if (!this.c.offer(obj)) {
                SubscriptionHelper.cancel(this);
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            }
            a();
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, this.d);
        }

        public final void remove() {
            throw new UnsupportedOperationException("remove");
        }

        public final void run() {
            SubscriptionHelper.cancel(this);
            a();
        }
    }

    public final Iterator iterator() {
        new BlockingFlowableIterator();
        throw null;
    }
}
