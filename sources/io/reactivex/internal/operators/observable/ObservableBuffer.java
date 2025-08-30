package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    public final int d;
    public final int e;
    public final Callable f;

    public static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        public final Observer c;
        public final int d;
        public final Callable e;
        public Collection f;
        public int g;
        public Disposable i;

        public BufferExactObserver(Observer observer, int i2, Callable callable) {
            this.c = observer;
            this.d = i2;
            this.e = callable;
        }

        public final boolean a() {
            try {
                Object call = this.e.call();
                ObjectHelper.b(call, "Empty buffer supplied");
                this.f = (Collection) call;
                return true;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.f = null;
                Disposable disposable = this.i;
                Observer observer = this.c;
                if (disposable == null) {
                    EmptyDisposable.error(th, (Observer<?>) observer);
                    return false;
                }
                disposable.dispose();
                observer.onError(th);
                return false;
            }
        }

        public final void dispose() {
            this.i.dispose();
        }

        public final boolean isDisposed() {
            return this.i.isDisposed();
        }

        public final void onComplete() {
            Collection collection = this.f;
            if (collection != null) {
                this.f = null;
                boolean isEmpty = collection.isEmpty();
                Observer observer = this.c;
                if (!isEmpty) {
                    observer.onNext(collection);
                }
                observer.onComplete();
            }
        }

        public final void onError(Throwable th) {
            this.f = null;
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            Collection collection = this.f;
            if (collection != null) {
                collection.add(obj);
                int i2 = this.g + 1;
                this.g = i2;
                if (i2 >= this.d) {
                    this.c.onNext(collection);
                    this.g = 0;
                    a();
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

    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;
        public final Observer c;
        public final int d;
        public final int e;
        public final Callable f;
        public Disposable g;
        public final ArrayDeque i = new ArrayDeque();
        public long j;

        public BufferSkipObserver(Observer observer, int i2, int i3, Callable callable) {
            this.c = observer;
            this.d = i2;
            this.e = i3;
            this.f = callable;
        }

        public final void dispose() {
            this.g.dispose();
        }

        public final boolean isDisposed() {
            return this.g.isDisposed();
        }

        public final void onComplete() {
            while (true) {
                ArrayDeque arrayDeque = this.i;
                boolean isEmpty = arrayDeque.isEmpty();
                Observer observer = this.c;
                if (!isEmpty) {
                    observer.onNext(arrayDeque.poll());
                } else {
                    observer.onComplete();
                    return;
                }
            }
        }

        public final void onError(Throwable th) {
            this.i.clear();
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            long j2 = this.j;
            this.j = 1 + j2;
            long j3 = j2 % ((long) this.e);
            ArrayDeque arrayDeque = this.i;
            Observer observer = this.c;
            if (j3 == 0) {
                try {
                    Object call = this.f.call();
                    ObjectHelper.b(call, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    arrayDeque.offer((Collection) call);
                } catch (Throwable th) {
                    arrayDeque.clear();
                    this.g.dispose();
                    observer.onError(th);
                    return;
                }
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) it.next();
                collection.add(obj);
                if (this.d <= collection.size()) {
                    it.remove();
                    observer.onNext(collection);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(Observable observable, int i, int i2, Callable callable) {
        super(observable);
        this.d = i;
        this.e = i2;
        this.f = callable;
    }

    public final void subscribeActual(Observer observer) {
        ObservableSource observableSource = this.c;
        Callable callable = this.f;
        int i = this.e;
        int i2 = this.d;
        if (i == i2) {
            BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i2, callable);
            if (bufferExactObserver.a()) {
                observableSource.subscribe(bufferExactObserver);
                return;
            }
            return;
        }
        observableSource.subscribe(new BufferSkipObserver(observer, i2, i, callable));
    }
}
