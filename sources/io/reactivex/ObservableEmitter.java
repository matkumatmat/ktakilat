package io.reactivex;

import io.reactivex.disposables.Disposable;

public interface ObservableEmitter<T> extends Emitter<T> {
    void a(Disposable disposable);
}
