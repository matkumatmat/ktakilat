package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;
    public Disposable e;

    public DeferredScalarObserver(Observer<? super R> observer) {
        super(observer);
    }

    public void dispose() {
        super.dispose();
        this.e.dispose();
    }

    public void onComplete() {
        Object obj = this.d;
        if (obj != null) {
            this.d = null;
            complete(obj);
            return;
        }
        complete();
    }

    public void onError(Throwable th) {
        this.d = null;
        error(th);
    }

    public abstract /* synthetic */ void onNext(@NonNull Object obj);

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.e, disposable)) {
            this.e = disposable;
            this.c.onSubscribe(this);
        }
    }
}
