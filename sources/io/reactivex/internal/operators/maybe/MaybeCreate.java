package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCreate<T> extends Maybe<T> {

    public static final class Emitter<T> extends AtomicReference<Disposable> implements MaybeEmitter<T>, Disposable {
        private static final long serialVersionUID = -2467358622224974244L;
        public final MaybeObserver c;

        public Emitter(MaybeObserver maybeObserver) {
            this.c = maybeObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final String toString() {
            String simpleName = Emitter.class.getSimpleName();
            String atomicReference = super.toString();
            return simpleName + "{" + atomicReference + "}";
        }
    }

    public final void c(MaybeObserver maybeObserver) {
        Disposable disposable;
        Emitter emitter = new Emitter(maybeObserver);
        maybeObserver.onSubscribe(emitter);
        try {
            throw null;
        } catch (Throwable th) {
            if (disposable != null) {
                disposable.dispose();
            }
            throw th;
        }
    }
}
