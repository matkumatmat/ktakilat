package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8612022020200669122L;
    public final Observer c;
    public final AtomicReference d = new AtomicReference();

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.c = observer;
    }

    public void dispose() {
        DisposableHelper.dispose(this.d);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        if (this.d.get() == DisposableHelper.DISPOSED) {
            return true;
        }
        return false;
    }

    public void onComplete() {
        dispose();
        this.c.onComplete();
    }

    public void onError(Throwable th) {
        dispose();
        this.c.onError(th);
    }

    public void onNext(T t) {
        this.c.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this.d, disposable)) {
            this.c.onSubscribe(this);
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
