package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class SafeObserver<T> implements Observer<T>, Disposable {
    public final Observer c;
    public Disposable d;
    public boolean e;

    public SafeObserver(Observer observer) {
        this.c = observer;
    }

    public final void dispose() {
        this.d.dispose();
    }

    public final boolean isDisposed() {
        return this.d.isDisposed();
    }

    public final void onComplete() {
        if (!this.e) {
            this.e = true;
            Disposable disposable = this.d;
            Observer observer = this.c;
            if (disposable == null) {
                NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
                try {
                    observer.onSubscribe(EmptyDisposable.INSTANCE);
                    try {
                        observer.onError(nullPointerException);
                    } catch (Throwable th) {
                        Exceptions.a(th);
                        RxJavaPlugins.b(new CompositeException(nullPointerException, th));
                    }
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    RxJavaPlugins.b(new CompositeException(nullPointerException, th2));
                }
            } else {
                try {
                    observer.onComplete();
                } catch (Throwable th3) {
                    Exceptions.a(th3);
                    RxJavaPlugins.b(th3);
                }
            }
        }
    }

    public final void onError(Throwable th) {
        if (this.e) {
            RxJavaPlugins.b(th);
            return;
        }
        this.e = true;
        Disposable disposable = this.d;
        Observer observer = this.c;
        if (disposable == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                observer.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    observer.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    RxJavaPlugins.b(new CompositeException(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                Exceptions.a(th3);
                RxJavaPlugins.b(new CompositeException(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                observer.onError(th);
            } catch (Throwable th4) {
                Exceptions.a(th4);
                RxJavaPlugins.b(new CompositeException(th, th4));
            }
        }
    }

    public final void onNext(Object obj) {
        if (!this.e) {
            Disposable disposable = this.d;
            Observer observer = this.c;
            if (disposable == null) {
                this.e = true;
                NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
                try {
                    observer.onSubscribe(EmptyDisposable.INSTANCE);
                    try {
                        observer.onError(nullPointerException);
                    } catch (Throwable th) {
                        Exceptions.a(th);
                        RxJavaPlugins.b(new CompositeException(nullPointerException, th));
                    }
                } catch (Throwable th2) {
                    Exceptions.a(th2);
                    RxJavaPlugins.b(new CompositeException(nullPointerException, th2));
                }
            } else if (obj == null) {
                NullPointerException nullPointerException2 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.d.dispose();
                    onError(nullPointerException2);
                } catch (Throwable th3) {
                    Exceptions.a(th3);
                    onError(new CompositeException(nullPointerException2, th3));
                }
            } else {
                try {
                    observer.onNext(obj);
                } catch (Throwable th4) {
                    Exceptions.a(th4);
                    onError(new CompositeException(th, th4));
                }
            }
        }
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.d, disposable)) {
            this.d = disposable;
            try {
                this.c.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.a(th);
                RxJavaPlugins.b(new CompositeException(th, th));
            }
        }
    }
}
