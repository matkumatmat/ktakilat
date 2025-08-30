package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleResumeNext<T> extends Single<T> {

    public static final class ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5314538511045349925L;
        public final SingleObserver c;

        public ResumeMainSingleObserver(SingleObserver singleObserver) {
            this.c = singleObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onError(Throwable th) {
            try {
                throw null;
            } catch (Throwable th2) {
                Exceptions.a(th2);
                this.c.onError(new CompositeException(th, th2));
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.c.onSubscribe(this);
            }
        }

        public final void onSuccess(Object obj) {
            this.c.onSuccess(obj);
        }
    }

    public final void c(SingleObserver singleObserver) {
        new ResumeMainSingleObserver(singleObserver);
        throw null;
    }
}
