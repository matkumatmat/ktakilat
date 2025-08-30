package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    public final Observer c;
    public Disposable d;
    public QueueDisposable e;
    public boolean f;
    public int g;

    public BasicFuseableObserver(Observer observer) {
        this.c = observer;
    }

    public final void a(Throwable th) {
        Exceptions.a(th);
        this.d.dispose();
        onError(th);
    }

    public void clear() {
        this.e.clear();
    }

    public final void dispose() {
        this.d.dispose();
    }

    public final boolean isDisposed() {
        return this.d.isDisposed();
    }

    public final boolean isEmpty() {
        return this.e.isEmpty();
    }

    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f) {
            this.f = true;
            this.c.onComplete();
        }
    }

    public void onError(Throwable th) {
        if (this.f) {
            RxJavaPlugins.b(th);
            return;
        }
        this.f = true;
        this.c.onError(th);
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.d, disposable)) {
            this.d = disposable;
            if (disposable instanceof QueueDisposable) {
                this.e = (QueueDisposable) disposable;
            }
            this.c.onSubscribe(this);
        }
    }

    public int requestFusion(int i) {
        QueueDisposable queueDisposable = this.e;
        if (queueDisposable == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueDisposable.requestFusion(i);
        if (requestFusion == 0) {
            return requestFusion;
        }
        this.g = requestFusion;
        return requestFusion;
    }
}
