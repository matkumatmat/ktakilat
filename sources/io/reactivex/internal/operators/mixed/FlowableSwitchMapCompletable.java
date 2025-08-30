package io.reactivex.internal.operators.mixed;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

@Experimental
public final class FlowableSwitchMapCompletable<T> extends Completable {

    public static final class SwitchMapCompletableObserver<T> implements FlowableSubscriber<T>, Disposable {
        public static final SwitchMapInnerObserver i = new SwitchMapInnerObserver((SwitchMapCompletableObserver) null);
        public final CompletableObserver c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicReference e = new AtomicReference();
        public volatile boolean f;
        public Subscription g;

        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            public final SwitchMapCompletableObserver c;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver switchMapCompletableObserver) {
                this.c = switchMapCompletableObserver;
            }

            public final void onComplete() {
                SwitchMapCompletableObserver switchMapCompletableObserver = this.c;
                AtomicReference atomicReference = switchMapCompletableObserver.e;
                while (!atomicReference.compareAndSet(this, (Object) null)) {
                    if (atomicReference.get() != this) {
                        return;
                    }
                }
                if (switchMapCompletableObserver.f) {
                    Throwable terminate = switchMapCompletableObserver.d.terminate();
                    if (terminate == null) {
                        switchMapCompletableObserver.c.onComplete();
                    } else {
                        switchMapCompletableObserver.c.onError(terminate);
                    }
                }
            }

            public final void onError(Throwable th) {
                SwitchMapCompletableObserver switchMapCompletableObserver = this.c;
                AtomicReference atomicReference = switchMapCompletableObserver.e;
                while (true) {
                    if (!atomicReference.compareAndSet(this, (Object) null)) {
                        if (atomicReference.get() != this) {
                            break;
                        }
                    } else {
                        AtomicThrowable atomicThrowable = switchMapCompletableObserver.d;
                        if (atomicThrowable.addThrowable(th)) {
                            switchMapCompletableObserver.dispose();
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate != ExceptionHelper.f682a) {
                                switchMapCompletableObserver.c.onError(terminate);
                                return;
                            }
                            return;
                        }
                    }
                }
                RxJavaPlugins.b(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public SwitchMapCompletableObserver(CompletableObserver completableObserver) {
            this.c = completableObserver;
        }

        public final void dispose() {
            this.g.cancel();
            AtomicReference atomicReference = this.e;
            SwitchMapInnerObserver switchMapInnerObserver = i;
            SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) atomicReference.getAndSet(switchMapInnerObserver);
            if (switchMapInnerObserver2 != null && switchMapInnerObserver2 != switchMapInnerObserver) {
                DisposableHelper.dispose(switchMapInnerObserver2);
            }
        }

        public final boolean isDisposed() {
            if (this.e.get() == i) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            this.f = true;
            if (this.e.get() == null) {
                Throwable terminate = this.d.terminate();
                if (terminate == null) {
                    this.c.onComplete();
                } else {
                    this.c.onError(terminate);
                }
            }
        }

        public final void onError(Throwable th) {
            AtomicThrowable atomicThrowable = this.d;
            if (atomicThrowable.addThrowable(th)) {
                AtomicReference atomicReference = this.e;
                SwitchMapInnerObserver switchMapInnerObserver = i;
                SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) atomicReference.getAndSet(switchMapInnerObserver);
                if (!(switchMapInnerObserver2 == null || switchMapInnerObserver2 == switchMapInnerObserver)) {
                    DisposableHelper.dispose(switchMapInnerObserver2);
                }
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != ExceptionHelper.f682a) {
                    this.c.onError(terminate);
                    return;
                }
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            try {
                throw null;
            } catch (Throwable th) {
                Exceptions.a(th);
                this.g.cancel();
                onError(th);
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.c.onSubscribe(this);
                subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
    }

    public final void c(CompletableObserver completableObserver) {
        new SwitchMapCompletableObserver(completableObserver);
        throw null;
    }
}
