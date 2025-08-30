package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCallbackObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -6076952298809384986L;
    public final Consumer c;
    public final Consumer d;
    public final Action e;

    public MaybeCallbackObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        this.c = consumer;
        this.d = consumer2;
        this.e = action;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        if (this.d != Functions.e) {
            return true;
        }
        return false;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.e.run();
        } catch (Throwable th) {
            Exceptions.a(th);
            RxJavaPlugins.b(th);
        }
    }

    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.d.accept(th);
        } catch (Throwable th2) {
            Exceptions.a(th2);
            RxJavaPlugins.b(new CompositeException(th, th2));
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.c.accept(t);
        } catch (Throwable th) {
            Exceptions.a(th);
            RxJavaPlugins.b(th);
        }
    }
}
