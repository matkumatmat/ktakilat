package io.reactivex.subjects;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubject extends Completable implements CompletableObserver {

    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        public final CompletableObserver c;

        public CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.c = completableObserver;
            lazySet(completableSubject);
        }

        public final void dispose() {
            if (((CompletableSubject) getAndSet((Object) null)) != null) {
                throw null;
            }
        }

        public final boolean isDisposed() {
            if (get() == null) {
                return true;
            }
            return false;
        }
    }

    public final void c(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(new CompletableDisposable(completableObserver, this));
        throw null;
    }

    public final void onComplete() {
        throw null;
    }

    public final void onError(Throwable th) {
        ObjectHelper.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        throw null;
    }

    public final void onSubscribe(Disposable disposable) {
        throw null;
    }
}
