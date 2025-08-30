package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class ConnectConsumer implements Consumer<Disposable> {
    public Disposable c;

    public final void accept(Object obj) {
        this.c = (Disposable) obj;
    }
}
