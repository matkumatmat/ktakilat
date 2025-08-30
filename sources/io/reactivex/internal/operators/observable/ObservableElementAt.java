package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    public final long d;
    public final Object e;
    public final boolean f;

    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        public final Observer c;
        public final long d;
        public final Object e;
        public final boolean f;
        public Disposable g;
        public long i;
        public boolean j;

        public ElementAtObserver(Observer observer, long j2, Object obj, boolean z) {
            this.c = observer;
            this.d = j2;
            this.e = obj;
            this.f = z;
        }

        public final void dispose() {
            this.g.dispose();
        }

        public final boolean isDisposed() {
            return this.g.isDisposed();
        }

        public final void onComplete() {
            if (!this.j) {
                this.j = true;
                Observer observer = this.c;
                Object obj = this.e;
                if (obj != null || !this.f) {
                    if (obj != null) {
                        observer.onNext(obj);
                    }
                    observer.onComplete();
                    return;
                }
                observer.onError(new NoSuchElementException());
            }
        }

        public final void onError(Throwable th) {
            if (this.j) {
                RxJavaPlugins.b(th);
                return;
            }
            this.j = true;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.j) {
                long j2 = this.i;
                if (j2 == this.d) {
                    this.j = true;
                    this.g.dispose();
                    Observer observer = this.c;
                    observer.onNext(obj);
                    observer.onComplete();
                    return;
                }
                this.i = j2 + 1;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(Observable observable, long j, Object obj, boolean z) {
        super(observable);
        this.d = j;
        this.e = obj;
        this.f = z;
    }

    public final void subscribeActual(Observer observer) {
        Observer observer2 = observer;
        this.c.subscribe(new ElementAtObserver(observer2, this.d, this.e, this.f));
    }
}
