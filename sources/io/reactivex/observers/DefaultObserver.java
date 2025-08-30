package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.EndConsumerHelper;

public abstract class DefaultObserver<T> implements Observer<T> {
    public Disposable c;

    public final void onSubscribe(Disposable disposable) {
        Disposable disposable2 = this.c;
        Class<?> cls = getClass();
        ObjectHelper.b(disposable, "next is null");
        if (disposable2 != null) {
            disposable.dispose();
            if (disposable2 != DisposableHelper.DISPOSED) {
                EndConsumerHelper.a(cls);
                return;
            }
            return;
        }
        this.c = disposable;
    }
}
