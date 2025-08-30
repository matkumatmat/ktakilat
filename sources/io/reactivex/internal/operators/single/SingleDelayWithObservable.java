package io.reactivex.internal.operators.single;

import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithObservable<T, U> extends Single<T> {

    public static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements Observer<U>, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;
        public final SingleObserver c;
        public boolean d;

        public OtherSubscriber(SingleObserver singleObserver) {
            this.c = singleObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
                return;
            }
            this.d = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            ((Disposable) get()).dispose();
            onComplete();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.set(this, disposable)) {
                this.c.onSubscribe(this);
            }
        }
    }

    public final void c(SingleObserver singleObserver) {
        new OtherSubscriber(singleObserver);
        throw null;
    }
}
