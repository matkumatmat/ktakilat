package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -5417183359794346637L;
    public final InnerQueuedObserverSupport c;
    public final int d;
    public SimpleQueue e;
    public volatile boolean f;
    public int g;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int i) {
        this.c = innerQueuedObserverSupport;
        this.d = i;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.g;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public boolean isDone() {
        return this.f;
    }

    public void onComplete() {
        this.c.d(this);
    }

    public void onError(Throwable th) {
        this.c.c(this, th);
    }

    public void onNext(T t) {
        int i = this.g;
        InnerQueuedObserverSupport innerQueuedObserverSupport = this.c;
        if (i == 0) {
            innerQueuedObserverSupport.e(this, t);
        } else {
            innerQueuedObserverSupport.b();
        }
    }

    public void onSubscribe(Disposable disposable) {
        SimpleQueue simpleQueue;
        if (DisposableHelper.setOnce(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.g = requestFusion;
                    this.e = queueDisposable;
                    this.f = true;
                    this.c.d(this);
                    return;
                } else if (requestFusion == 2) {
                    this.g = requestFusion;
                    this.e = queueDisposable;
                    return;
                }
            }
            int i = -this.d;
            if (i < 0) {
                simpleQueue = new SpscLinkedArrayQueue(-i);
            } else {
                simpleQueue = new SpscArrayQueue(i);
            }
            this.e = simpleQueue;
        }
    }

    public SimpleQueue<T> queue() {
        return this.e;
    }

    public void setDone() {
        this.f = true;
    }
}
