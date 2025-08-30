package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUsing<T, D> extends Observable<T> {
    public final Callable c;
    public final Function d;
    public final Consumer e;
    public final boolean f;

    public static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5904473792286235046L;
        public final Observer c;
        public final Object d;
        public final Consumer e;
        public final boolean f;
        public Disposable g;

        public UsingObserver(Observer observer, Object obj, Consumer consumer, boolean z) {
            this.c = observer;
            this.d = obj;
            this.e = consumer;
            this.f = z;
        }

        public final void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.e.accept(this.d);
                } catch (Throwable th) {
                    Exceptions.a(th);
                    RxJavaPlugins.b(th);
                }
            }
        }

        public final void dispose() {
            a();
            this.g.dispose();
        }

        public final boolean isDisposed() {
            return get();
        }

        public final void onComplete() {
            boolean z = this.f;
            Observer observer = this.c;
            if (z) {
                if (compareAndSet(false, true)) {
                    try {
                        this.e.accept(this.d);
                    } catch (Throwable th) {
                        Exceptions.a(th);
                        observer.onError(th);
                        return;
                    }
                }
                this.g.dispose();
                observer.onComplete();
                return;
            }
            observer.onComplete();
            this.g.dispose();
            a();
        }

        public final void onError(Throwable th) {
            boolean z = this.f;
            Observer observer = this.c;
            if (z) {
                if (compareAndSet(false, true)) {
                    try {
                        this.e.accept(this.d);
                    } catch (Throwable th2) {
                        Exceptions.a(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.g.dispose();
                observer.onError(th);
                return;
            }
            observer.onError(th);
            this.g.dispose();
            a();
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable callable, Function function, Consumer consumer, boolean z) {
        this.c = callable;
        this.d = function;
        this.e = consumer;
        this.f = z;
    }

    public final void subscribeActual(Observer observer) {
        Consumer consumer = this.e;
        try {
            Object call = this.c.call();
            try {
                Object apply = this.d.apply(call);
                ObjectHelper.b(apply, "The sourceSupplier returned a null ObservableSource");
                ((ObservableSource) apply).subscribe(new UsingObserver(observer, call, consumer, this.f));
            } catch (Throwable th) {
                Exceptions.a(th);
                EmptyDisposable.error((Throwable) new CompositeException(th, th), (Observer<?>) observer);
            }
        } catch (Throwable th2) {
            Exceptions.a(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
