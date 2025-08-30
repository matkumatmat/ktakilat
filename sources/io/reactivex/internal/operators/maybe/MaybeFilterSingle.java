package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeFilterSingle<T> extends Maybe<T> {

    public static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {
        public Disposable c;

        public final void dispose() {
            Disposable disposable = this.c;
            this.c = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public final boolean isDisposed() {
            return this.c.isDisposed();
        }

        public final void onError(Throwable th) {
            throw null;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                throw null;
            }
        }

        public final void onSuccess(Object obj) {
            throw null;
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        throw null;
    }
}
