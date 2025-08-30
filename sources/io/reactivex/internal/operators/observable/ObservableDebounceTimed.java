package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;
    public final TimeUnit e;
    public final Scheduler f;

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        public final Object c;
        public final long d;
        public final DebounceTimedObserver e;
        public final AtomicBoolean f = new AtomicBoolean();

        public DebounceEmitter(Object obj, long j, DebounceTimedObserver debounceTimedObserver) {
            this.c = obj;
            this.d = j;
            this.e = debounceTimedObserver;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            if (get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        public final void run() {
            if (this.f.compareAndSet(false, true)) {
                DebounceTimedObserver debounceTimedObserver = this.e;
                long j = this.d;
                Object obj = this.c;
                if (j == debounceTimedObserver.j) {
                    debounceTimedObserver.c.onNext(obj);
                    DisposableHelper.dispose(this);
                }
            }
        }
    }

    public static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {
        public final SerializedObserver c;
        public final long d;
        public final TimeUnit e;
        public final Scheduler.Worker f;
        public Disposable g;
        public Disposable i;
        public volatile long j;
        public boolean k;

        public DebounceTimedObserver(SerializedObserver serializedObserver, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.c = serializedObserver;
            this.d = j2;
            this.e = timeUnit;
            this.f = worker;
        }

        public final void dispose() {
            this.g.dispose();
            this.f.dispose();
        }

        public final boolean isDisposed() {
            return this.f.isDisposed();
        }

        public final void onComplete() {
            if (!this.k) {
                this.k = true;
                Disposable disposable = this.i;
                if (disposable != null) {
                    DisposableHelper.dispose((DebounceEmitter) disposable);
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.run();
                }
                this.c.onComplete();
                this.f.dispose();
            }
        }

        public final void onError(Throwable th) {
            if (this.k) {
                RxJavaPlugins.b(th);
                return;
            }
            Disposable disposable = this.i;
            if (disposable != null) {
                DisposableHelper.dispose((DebounceEmitter) disposable);
            }
            this.k = true;
            this.c.onError(th);
            this.f.dispose();
        }

        public final void onNext(Object obj) {
            if (!this.k) {
                long j2 = this.j + 1;
                this.j = j2;
                Disposable disposable = this.i;
                if (disposable != null) {
                    DisposableHelper.dispose((DebounceEmitter) disposable);
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(obj, j2, this);
                this.i = debounceEmitter;
                DisposableHelper.replace(debounceEmitter, this.f.c(debounceEmitter, this.d, this.e));
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(Observable observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(observable);
        this.d = j;
        this.e = timeUnit;
        this.f = scheduler;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.d, this.e, this.f.a()));
    }
}
