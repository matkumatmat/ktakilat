package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

@Experimental
public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {
    public final Action d;

    public static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        public final Observer c;
        public final Action d;
        public Disposable e;
        public QueueDisposable f;
        public boolean g;

        public DoFinallyObserver(Observer observer, Action action) {
            this.c = observer;
            this.d = action;
        }

        public final void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.d.run();
                } catch (Throwable th) {
                    Exceptions.a(th);
                    RxJavaPlugins.b(th);
                }
            }
        }

        public final void clear() {
            this.f.clear();
        }

        public final void dispose() {
            this.e.dispose();
            a();
        }

        public final boolean isDisposed() {
            return this.e.isDisposed();
        }

        public final boolean isEmpty() {
            return this.f.isEmpty();
        }

        public final void onComplete() {
            this.c.onComplete();
            a();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
            a();
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.f = (QueueDisposable) disposable;
                }
                this.c.onSubscribe(this);
            }
        }

        public final Object poll() {
            Object poll = this.f.poll();
            if (poll == null && this.g) {
                a();
            }
            return poll;
        }

        public final int requestFusion(int i) {
            QueueDisposable queueDisposable = this.f;
            boolean z = false;
            if (queueDisposable == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = queueDisposable.requestFusion(i);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z = true;
                }
                this.g = z;
            }
            return requestFusion;
        }
    }

    public ObservableDoFinally(Observable observable, Action action) {
        super(observable);
        this.d = action;
    }

    public final void subscribeActual(Observer observer) {
        this.c.subscribe(new DoFinallyObserver(observer, this.d));
    }
}
