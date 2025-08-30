package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

public final class ObservableZipIterable<T, U, V> extends Observable<V> {
    public final Observable c;
    public final Iterable d;
    public final BiFunction e;

    public static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {
        public final Observer c;
        public final Iterator d;
        public final BiFunction e;
        public Disposable f;
        public boolean g;

        public ZipIterableObserver(Observer observer, Iterator it, BiFunction biFunction) {
            this.c = observer;
            this.d = it;
            this.e = biFunction;
        }

        public final void dispose() {
            this.f.dispose();
        }

        public final boolean isDisposed() {
            return this.f.isDisposed();
        }

        public final void onComplete() {
            if (!this.g) {
                this.g = true;
                this.c.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.b(th);
                return;
            }
            this.g = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            Observer observer = this.c;
            Iterator it = this.d;
            if (!this.g) {
                try {
                    Object next = it.next();
                    ObjectHelper.b(next, "The iterator returned a null value");
                    try {
                        Object apply = this.e.apply(obj, next);
                        ObjectHelper.b(apply, "The zipper function returned a null value");
                        observer.onNext(apply);
                        try {
                            if (!it.hasNext()) {
                                this.g = true;
                                this.f.dispose();
                                observer.onComplete();
                            }
                        } catch (Throwable th) {
                            Exceptions.a(th);
                            this.g = true;
                            this.f.dispose();
                            observer.onError(th);
                        }
                    } catch (Throwable th2) {
                        Exceptions.a(th2);
                        this.g = true;
                        this.f.dispose();
                        observer.onError(th2);
                    }
                } catch (Throwable th3) {
                    Exceptions.a(th3);
                    this.g = true;
                    this.f.dispose();
                    observer.onError(th3);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableZipIterable(Observable observable, Iterable iterable, BiFunction biFunction) {
        this.c = observable;
        this.d = iterable;
        this.e = biFunction;
    }

    public final void subscribeActual(Observer observer) {
        try {
            Iterator it = this.d.iterator();
            ObjectHelper.b(it, "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete((Observer<?>) observer);
                    return;
                }
                this.c.subscribe(new ZipIterableObserver(observer, it, this.e));
            } catch (Throwable th) {
                Exceptions.a(th);
                EmptyDisposable.error(th, (Observer<?>) observer);
            }
        } catch (Throwable th2) {
            Exceptions.a(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
