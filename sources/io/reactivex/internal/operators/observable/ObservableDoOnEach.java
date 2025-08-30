package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {
    public final Consumer d;
    public final Consumer e;
    public final Action f;
    public final Action g;

    public static final class DoOnEachObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public final Consumer d;
        public final Consumer e;
        public final Action f;
        public final Action g;
        public Disposable i;
        public boolean j;

        public DoOnEachObserver(Observer observer, Consumer consumer, Consumer consumer2, Action action, Action action2) {
            this.c = observer;
            this.d = consumer;
            this.e = consumer2;
            this.f = action;
            this.g = action2;
        }

        public final void dispose() {
            this.i.dispose();
        }

        public final boolean isDisposed() {
            return this.i.isDisposed();
        }

        public final void onComplete() {
            if (!this.j) {
                try {
                    this.f.run();
                    this.j = true;
                    this.c.onComplete();
                    try {
                        this.g.run();
                    } catch (Throwable th) {
                        Exceptions.a(th);
                        RxJavaPlugins.b(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    onError(th2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.j) {
                RxJavaPlugins.b(th);
                return;
            }
            this.j = true;
            try {
                this.e.accept(th);
            } catch (Throwable th2) {
                Exceptions.a(th2);
                th = new CompositeException(th, th2);
            }
            this.c.onError(th);
            try {
                this.g.run();
            } catch (Throwable th3) {
                Exceptions.a(th3);
                RxJavaPlugins.b(th3);
            }
        }

        public final void onNext(Object obj) {
            if (!this.j) {
                try {
                    this.d.accept(obj);
                    this.c.onNext(obj);
                } catch (Throwable th) {
                    Exceptions.a(th);
                    this.i.dispose();
                    onError(th);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableDoOnEach(Observable observable, Consumer consumer, Consumer consumer2, Action action, Action action2) {
        super(observable);
        this.d = consumer;
        this.e = consumer2;
        this.f = action;
        this.g = action2;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new DoOnEachObserver(observer, this.d, this.e, this.f, this.g));
    }
}
