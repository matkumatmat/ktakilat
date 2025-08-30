package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {
    public final Function d;

    public static final class DebounceObserver<T, U> implements Observer<T>, Disposable {
        public final SerializedObserver c;
        public final Function d;
        public Disposable e;
        public final AtomicReference f = new AtomicReference();
        public volatile long g;
        public boolean i;

        public static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {
            public final DebounceObserver d;
            public final long e;
            public final Object f;
            public boolean g;
            public final AtomicBoolean i = new AtomicBoolean();

            public DebounceInnerObserver(DebounceObserver debounceObserver, long j, Object obj) {
                this.d = debounceObserver;
                this.e = j;
                this.f = obj;
            }

            public final void a() {
                if (this.i.compareAndSet(false, true)) {
                    DebounceObserver debounceObserver = this.d;
                    long j = this.e;
                    Object obj = this.f;
                    if (j == debounceObserver.g) {
                        debounceObserver.c.onNext(obj);
                    }
                }
            }

            public final void onComplete() {
                if (!this.g) {
                    this.g = true;
                    a();
                }
            }

            public final void onError(Throwable th) {
                if (this.g) {
                    RxJavaPlugins.b(th);
                    return;
                }
                this.g = true;
                this.d.onError(th);
            }

            public final void onNext(Object obj) {
                if (!this.g) {
                    this.g = true;
                    dispose();
                    a();
                }
            }
        }

        public DebounceObserver(SerializedObserver serializedObserver, Function function) {
            this.c = serializedObserver;
            this.d = function;
        }

        public final void dispose() {
            this.e.dispose();
            DisposableHelper.dispose(this.f);
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final void onComplete() {
            if (!this.i) {
                this.i = true;
                AtomicReference atomicReference = this.f;
                Disposable disposable = (Disposable) atomicReference.get();
                if (disposable != DisposableHelper.DISPOSED) {
                    ((DebounceInnerObserver) disposable).a();
                    DisposableHelper.dispose(atomicReference);
                    this.c.onComplete();
                }
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.f);
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.i) {
                long j = this.g + 1;
                this.g = j;
                Disposable disposable = (Disposable) this.f.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    Object apply = this.d.apply(obj);
                    ObjectHelper.b(apply, "The ObservableSource supplied is null");
                    ObservableSource observableSource = (ObservableSource) apply;
                    DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j, obj);
                    AtomicReference atomicReference = this.f;
                    while (!atomicReference.compareAndSet(disposable, debounceInnerObserver)) {
                        if (atomicReference.get() != disposable) {
                            return;
                        }
                    }
                    observableSource.subscribe(debounceInnerObserver);
                } catch (Throwable th) {
                    Exceptions.a(th);
                    dispose();
                    this.c.onError(th);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableDebounce(Observable observable, Function function) {
        super(observable);
        this.d = function;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new DebounceObserver(new SerializedObserver(observer), this.d));
    }
}
