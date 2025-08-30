package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class BlockingObservableIterable<T> implements Iterable<T> {
    public final Observable c;
    public final int d;

    public static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;
        public final SpscLinkedArrayQueue c;
        public final ReentrantLock d;
        public final Condition e;
        public volatile boolean f;
        public Throwable g;

        public BlockingObservableIterator(int i) {
            this.c = new SpscLinkedArrayQueue(i);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.d = reentrantLock;
            this.e = reentrantLock.newCondition();
        }

        public final void a() {
            ReentrantLock reentrantLock = this.d;
            reentrantLock.lock();
            try {
                this.e.signalAll();
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean hasNext() {
            while (true) {
                boolean z = this.f;
                boolean isEmpty = this.c.isEmpty();
                if (z) {
                    Throwable th = this.g;
                    if (th != null) {
                        throw ExceptionHelper.c(th);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                try {
                    this.d.lock();
                    while (!this.f && this.c.isEmpty()) {
                        this.e.await();
                    }
                    this.d.unlock();
                } catch (InterruptedException e2) {
                    DisposableHelper.dispose(this);
                    a();
                    throw ExceptionHelper.c(e2);
                } catch (Throwable th2) {
                    this.d.unlock();
                    throw th2;
                }
            }
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final Object next() {
            if (hasNext()) {
                return this.c.poll();
            }
            throw new NoSuchElementException();
        }

        public final void onComplete() {
            this.f = true;
            a();
        }

        public final void onError(Throwable th) {
            this.g = th;
            this.f = true;
            a();
        }

        public final void onNext(Object obj) {
            this.c.offer(obj);
            a();
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public final void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public BlockingObservableIterable(Observable observable, int i) {
        this.c = observable;
        this.d = i;
    }

    public final Iterator iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.d);
        this.c.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
