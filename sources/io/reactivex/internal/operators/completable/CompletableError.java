package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.CancellationException;

public final class CompletableError extends Completable {
    public final CancellationException c;

    public CompletableError(CancellationException cancellationException) {
        this.c = cancellationException;
    }

    public final void c(CompletableObserver completableObserver) {
        EmptyDisposable.error((Throwable) this.c, completableObserver);
    }
}
