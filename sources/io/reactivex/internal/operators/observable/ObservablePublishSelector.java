package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final Function d;

    public static final class SourceObserver<T, R> implements Observer<T> {
        public final PublishSubject c;
        public final AtomicReference d;

        public SourceObserver(PublishSubject publishSubject, AtomicReference atomicReference) {
            this.c = publishSubject;
            this.d = atomicReference;
        }

        public final void onComplete() {
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.d, disposable);
        }
    }

    public static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        private static final long serialVersionUID = 854110278590336484L;
        public final Observer c;
        public Disposable d;

        public TargetObserver(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            this.d.dispose();
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return this.d.isDisposed();
        }

        public final void onComplete() {
            DisposableHelper.dispose(this);
            this.c.onComplete();
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.c.onError(th);
        }

        public final void onNext(Object obj) {
            this.c.onNext(obj);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservablePublishSelector(Observable observable, Function function) {
        super(observable);
        this.d = function;
    }

    public final void subscribeActual(Observer observer) {
        PublishSubject publishSubject = new PublishSubject();
        try {
            Object apply = this.d.apply(publishSubject);
            ObjectHelper.b(apply, "The selector returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.c.subscribe(new SourceObserver(publishSubject, targetObserver));
        } catch (Throwable th) {
            Exceptions.a(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }
}
