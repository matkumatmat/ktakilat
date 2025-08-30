package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    public final Function d;
    public final boolean e;

    public static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        public final Observer c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final Function e;
        public final boolean f;
        public final CompositeDisposable g = new Object();
        public Disposable i;
        public volatile boolean j;

        public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            public InnerObserver() {
            }

            public final void dispose() {
                DisposableHelper.dispose(this);
            }

            public final boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public final void onComplete() {
                FlatMapCompletableMainObserver flatMapCompletableMainObserver = FlatMapCompletableMainObserver.this;
                flatMapCompletableMainObserver.g.c(this);
                flatMapCompletableMainObserver.onComplete();
            }

            public final void onError(Throwable th) {
                FlatMapCompletableMainObserver flatMapCompletableMainObserver = FlatMapCompletableMainObserver.this;
                flatMapCompletableMainObserver.g.c(this);
                flatMapCompletableMainObserver.onError(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        /* JADX WARNING: type inference failed for: r1v2, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public FlatMapCompletableMainObserver(Observer observer, Function function, boolean z) {
            this.c = observer;
            this.e = function;
            this.f = z;
            lazySet(1);
        }

        public final void clear() {
        }

        public final void dispose() {
            this.j = true;
            this.i.dispose();
            this.g.dispose();
        }

        public final boolean isDisposed() {
            return this.i.isDisposed();
        }

        public final boolean isEmpty() {
            return true;
        }

        public final void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.d.terminate();
                Observer observer = this.c;
                if (terminate != null) {
                    observer.onError(terminate);
                } else {
                    observer.onComplete();
                }
            }
        }

        public final void onError(Throwable th) {
            AtomicThrowable atomicThrowable = this.d;
            if (atomicThrowable.addThrowable(th)) {
                boolean z = this.f;
                Observer observer = this.c;
                if (!z) {
                    dispose();
                    if (getAndSet(0) > 0) {
                        observer.onError(atomicThrowable.terminate());
                    }
                } else if (decrementAndGet() == 0) {
                    observer.onError(atomicThrowable.terminate());
                }
            } else {
                RxJavaPlugins.b(th);
            }
        }

        public final void onNext(Object obj) {
            try {
                Object apply = this.e.apply(obj);
                ObjectHelper.b(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.j && this.g.b(innerObserver)) {
                    completableSource.b(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.a(th);
                this.i.dispose();
                onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.c.onSubscribe(this);
            }
        }

        public final Object poll() {
            return null;
        }

        public final int requestFusion(int i2) {
            return i2 & 2;
        }
    }

    public ObservableFlatMapCompletable(Observable observable, Function function, boolean z) {
        super(observable);
        this.d = function;
        this.e = z;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new FlatMapCompletableMainObserver(observer, this.d, this.e));
    }
}
