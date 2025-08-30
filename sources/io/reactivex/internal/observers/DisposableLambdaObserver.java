package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {
    public final Observer c;
    public final Consumer d;
    public final Action e;
    public Disposable f;

    public DisposableLambdaObserver(Observer observer, Consumer consumer, Action action) {
        this.c = observer;
        this.d = consumer;
        this.e = action;
    }

    public final void dispose() {
        try {
            this.e.run();
        } catch (Throwable th) {
            Exceptions.a(th);
            RxJavaPlugins.b(th);
        }
        this.f.dispose();
    }

    public final boolean isDisposed() {
        return this.f.isDisposed();
    }

    public final void onComplete() {
        if (this.f != DisposableHelper.DISPOSED) {
            this.c.onComplete();
        }
    }

    public final void onError(Throwable th) {
        if (this.f != DisposableHelper.DISPOSED) {
            this.c.onError(th);
        } else {
            RxJavaPlugins.b(th);
        }
    }

    public final void onNext(Object obj) {
        this.c.onNext(obj);
    }

    public final void onSubscribe(Disposable disposable) {
        Observer observer = this.c;
        try {
            this.d.accept(disposable);
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                observer.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.a(th);
            disposable.dispose();
            this.f = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }
}
