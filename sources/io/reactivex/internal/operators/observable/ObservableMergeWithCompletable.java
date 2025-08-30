package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    public final CompletableSource d;

    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;
        public final Observer c;
        public final AtomicReference d = new AtomicReference();
        public final OtherObserver e = new OtherObserver(this);
        public final AtomicThrowable f = new AtomicThrowable();
        public volatile boolean g;
        public volatile boolean i;

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver c;

            public OtherObserver(MergeWithObserver mergeWithObserver) {
                this.c = mergeWithObserver;
            }

            public final void onComplete() {
                MergeWithObserver mergeWithObserver = this.c;
                mergeWithObserver.i = true;
                if (mergeWithObserver.g) {
                    HalfSerializer.a(mergeWithObserver.c, mergeWithObserver, mergeWithObserver.f);
                }
            }

            public final void onError(Throwable th) {
                MergeWithObserver mergeWithObserver = this.c;
                DisposableHelper.dispose(mergeWithObserver.d);
                HalfSerializer.c(mergeWithObserver.c, th, mergeWithObserver, mergeWithObserver.f);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public MergeWithObserver(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            DisposableHelper.dispose(this.d);
            DisposableHelper.dispose(this.e);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.d.get());
        }

        public final void onComplete() {
            this.g = true;
            if (this.i) {
                HalfSerializer.a(this.c, this, this.f);
            }
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.d);
            HalfSerializer.c(this.c, th, this, this.f);
        }

        public final void onNext(Object obj) {
            HalfSerializer.e(this.c, obj, this, this.f);
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.d, disposable);
        }
    }

    public ObservableMergeWithCompletable(Observable observable, CompletableSource completableSource) {
        super(observable);
        this.d = completableSource;
    }

    public final void subscribeActual(Observer observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.c.subscribe(mergeWithObserver);
        this.d.b(mergeWithObserver.e);
    }
}
