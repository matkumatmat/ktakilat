package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
public final class ObservableSwitchMapCompletable<T> extends Completable {
    public final Observable c;
    public final Function d;
    public final boolean e;

    public static final class SwitchMapCompletableObserver<T> implements Observer<T>, Disposable {
        public static final SwitchMapInnerObserver k = new SwitchMapInnerObserver((SwitchMapCompletableObserver) null);
        public final CompletableObserver c;
        public final Function d;
        public final boolean e;
        public final AtomicThrowable f = new AtomicThrowable();
        public final AtomicReference g = new AtomicReference();
        public volatile boolean i;
        public Disposable j;

        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            public final SwitchMapCompletableObserver c;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver switchMapCompletableObserver) {
                this.c = switchMapCompletableObserver;
            }

            public final void onComplete() {
                SwitchMapCompletableObserver switchMapCompletableObserver = this.c;
                AtomicReference atomicReference = switchMapCompletableObserver.g;
                while (!atomicReference.compareAndSet(this, (Object) null)) {
                    if (atomicReference.get() != this) {
                        return;
                    }
                }
                if (switchMapCompletableObserver.i) {
                    Throwable terminate = switchMapCompletableObserver.f.terminate();
                    if (terminate == null) {
                        switchMapCompletableObserver.c.onComplete();
                    } else {
                        switchMapCompletableObserver.c.onError(terminate);
                    }
                }
            }

            public final void onError(Throwable th) {
                SwitchMapCompletableObserver switchMapCompletableObserver = this.c;
                AtomicReference atomicReference = switchMapCompletableObserver.g;
                while (true) {
                    if (!atomicReference.compareAndSet(this, (Object) null)) {
                        if (atomicReference.get() != this) {
                            break;
                        }
                    } else if (switchMapCompletableObserver.f.addThrowable(th)) {
                        if (!switchMapCompletableObserver.e) {
                            switchMapCompletableObserver.dispose();
                            Throwable terminate = switchMapCompletableObserver.f.terminate();
                            if (terminate != ExceptionHelper.f682a) {
                                switchMapCompletableObserver.c.onError(terminate);
                                return;
                            }
                            return;
                        } else if (switchMapCompletableObserver.i) {
                            switchMapCompletableObserver.c.onError(switchMapCompletableObserver.f.terminate());
                            return;
                        } else {
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

        public SwitchMapCompletableObserver(CompletableObserver completableObserver, Function function, boolean z) {
            this.c = completableObserver;
            this.d = function;
            this.e = z;
        }

        public final void dispose() {
            this.j.dispose();
            AtomicReference atomicReference = this.g;
            SwitchMapInnerObserver switchMapInnerObserver = k;
            SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) atomicReference.getAndSet(switchMapInnerObserver);
            if (switchMapInnerObserver2 != null && switchMapInnerObserver2 != switchMapInnerObserver) {
                DisposableHelper.dispose(switchMapInnerObserver2);
            }
        }

        public final boolean isDisposed() {
            if (this.g.get() == k) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            this.i = true;
            if (this.g.get() == null) {
                Throwable terminate = this.f.terminate();
                if (terminate == null) {
                    this.c.onComplete();
                } else {
                    this.c.onError(terminate);
                }
            }
        }

        public final void onError(Throwable th) {
            AtomicThrowable atomicThrowable = this.f;
            if (!atomicThrowable.addThrowable(th)) {
                RxJavaPlugins.b(th);
            } else if (this.e) {
                onComplete();
            } else {
                AtomicReference atomicReference = this.g;
                SwitchMapInnerObserver switchMapInnerObserver = k;
                SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) atomicReference.getAndSet(switchMapInnerObserver);
                if (!(switchMapInnerObserver2 == null || switchMapInnerObserver2 == switchMapInnerObserver)) {
                    DisposableHelper.dispose(switchMapInnerObserver2);
                }
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != ExceptionHelper.f682a) {
                    this.c.onError(terminate);
                }
            }
        }

        public final void onNext(Object obj) {
            try {
                Object apply = this.d.apply(obj);
                ObjectHelper.b(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                SwitchMapInnerObserver switchMapInnerObserver = new SwitchMapInnerObserver(this);
                while (true) {
                    AtomicReference atomicReference = this.g;
                    SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) atomicReference.get();
                    if (switchMapInnerObserver2 != k) {
                        while (true) {
                            if (atomicReference.compareAndSet(switchMapInnerObserver2, switchMapInnerObserver)) {
                                if (switchMapInnerObserver2 != null) {
                                    DisposableHelper.dispose(switchMapInnerObserver2);
                                }
                                completableSource.b(switchMapInnerObserver);
                                return;
                            } else if (atomicReference.get() != switchMapInnerObserver2) {
                            }
                        }
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                Exceptions.a(th);
                this.j.dispose();
                onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.j, disposable)) {
                this.j = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapCompletable(Observable observable, Function function, boolean z) {
        this.c = observable;
        this.d = function;
        this.e = z;
    }

    public final void c(CompletableObserver completableObserver) {
        Observable observable = this.c;
        Function function = this.d;
        if (!ScalarXMapZHelper.a(observable, function, completableObserver)) {
            observable.subscribe(new SwitchMapCompletableObserver(completableObserver, function, this.e));
        }
    }
}
