package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {
    public final Observable c;
    public final Function d;
    public final boolean e;

    public static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final SwitchMapSingleObserver l = new SwitchMapSingleObserver((SwitchMapSingleMainObserver) null);
        private static final long serialVersionUID = -5402190102429853762L;
        public final Observer c;
        public final Function d;
        public final boolean e;
        public final AtomicThrowable f = new AtomicThrowable();
        public final AtomicReference g = new AtomicReference();
        public Disposable i;
        public volatile boolean j;
        public volatile boolean k;

        public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public final SwitchMapSingleMainObserver c;
            public volatile Object d;

            public SwitchMapSingleObserver(SwitchMapSingleMainObserver switchMapSingleMainObserver) {
                this.c = switchMapSingleMainObserver;
            }

            public final void onError(Throwable th) {
                SwitchMapSingleMainObserver switchMapSingleMainObserver = this.c;
                AtomicReference atomicReference = switchMapSingleMainObserver.g;
                while (true) {
                    if (!atomicReference.compareAndSet(this, (Object) null)) {
                        if (atomicReference.get() != this) {
                            break;
                        }
                    } else if (switchMapSingleMainObserver.f.addThrowable(th)) {
                        if (!switchMapSingleMainObserver.e) {
                            switchMapSingleMainObserver.i.dispose();
                            switchMapSingleMainObserver.a();
                        }
                        switchMapSingleMainObserver.b();
                        return;
                    }
                }
                RxJavaPlugins.b(th);
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public final void onSuccess(Object obj) {
                this.d = obj;
                this.c.b();
            }
        }

        public SwitchMapSingleMainObserver(Observer observer, Function function, boolean z) {
            this.c = observer;
            this.d = function;
            this.e = z;
        }

        public final void a() {
            AtomicReference atomicReference = this.g;
            SwitchMapSingleObserver switchMapSingleObserver = l;
            SwitchMapSingleObserver switchMapSingleObserver2 = (SwitchMapSingleObserver) atomicReference.getAndSet(switchMapSingleObserver);
            if (switchMapSingleObserver2 != null && switchMapSingleObserver2 != switchMapSingleObserver) {
                DisposableHelper.dispose(switchMapSingleObserver2);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x004c A[LOOP:1: B:26:0x004c->B:29:0x0058, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b() {
            /*
                r8 = this;
                int r0 = r8.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.Observer r0 = r8.c
                io.reactivex.internal.util.AtomicThrowable r1 = r8.f
                java.util.concurrent.atomic.AtomicReference r2 = r8.g
                r3 = 1
                r4 = 1
            L_0x000f:
                boolean r5 = r8.k
                if (r5 == 0) goto L_0x0014
                return
            L_0x0014:
                java.lang.Object r5 = r1.get()
                if (r5 == 0) goto L_0x0026
                boolean r5 = r8.e
                if (r5 != 0) goto L_0x0026
                java.lang.Throwable r1 = r1.terminate()
                r0.onError(r1)
                return
            L_0x0026:
                boolean r5 = r8.j
                java.lang.Object r6 = r2.get()
                io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle$SwitchMapSingleMainObserver$SwitchMapSingleObserver r6 = (io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.SwitchMapSingleObserver) r6
                if (r6 != 0) goto L_0x0032
                r7 = 1
                goto L_0x0033
            L_0x0032:
                r7 = 0
            L_0x0033:
                if (r5 == 0) goto L_0x0045
                if (r7 == 0) goto L_0x0045
                java.lang.Throwable r1 = r1.terminate()
                if (r1 == 0) goto L_0x0041
                r0.onError(r1)
                goto L_0x0044
            L_0x0041:
                r0.onComplete()
            L_0x0044:
                return
            L_0x0045:
                if (r7 != 0) goto L_0x0060
                java.lang.Object r5 = r6.d
                if (r5 != 0) goto L_0x004c
                goto L_0x0060
            L_0x004c:
                r5 = 0
                boolean r5 = r2.compareAndSet(r6, r5)
                if (r5 == 0) goto L_0x0054
                goto L_0x005a
            L_0x0054:
                java.lang.Object r5 = r2.get()
                if (r5 == r6) goto L_0x004c
            L_0x005a:
                java.lang.Object r5 = r6.d
                r0.onNext(r5)
                goto L_0x000f
            L_0x0060:
                int r4 = -r4
                int r4 = r8.addAndGet(r4)
                if (r4 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle.SwitchMapSingleMainObserver.b():void");
        }

        public final void dispose() {
            this.k = true;
            this.i.dispose();
            a();
        }

        public final boolean isDisposed() {
            return this.k;
        }

        public final void onComplete() {
            this.j = true;
            b();
        }

        public final void onError(Throwable th) {
            if (this.f.addThrowable(th)) {
                if (!this.e) {
                    a();
                }
                this.j = true;
                b();
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            SwitchMapSingleObserver switchMapSingleObserver = l;
            AtomicReference atomicReference = this.g;
            SwitchMapSingleObserver switchMapSingleObserver2 = (SwitchMapSingleObserver) atomicReference.get();
            if (switchMapSingleObserver2 != null) {
                DisposableHelper.dispose(switchMapSingleObserver2);
            }
            try {
                Object apply = this.d.apply(obj);
                ObjectHelper.b(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                while (true) {
                    SwitchMapSingleObserver switchMapSingleObserver4 = (SwitchMapSingleObserver) atomicReference.get();
                    if (switchMapSingleObserver4 != switchMapSingleObserver) {
                        while (true) {
                            if (atomicReference.compareAndSet(switchMapSingleObserver4, switchMapSingleObserver3)) {
                                singleSource.b(switchMapSingleObserver3);
                                return;
                            } else if (atomicReference.get() != switchMapSingleObserver4) {
                            }
                        }
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                Exceptions.a(th);
                this.i.dispose();
                atomicReference.getAndSet(switchMapSingleObserver);
                onError(th);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.c.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapSingle(Observable observable, Function function, boolean z) {
        this.c = observable;
        this.d = function;
        this.e = z;
    }

    public final void subscribeActual(Observer observer) {
        Observable observable = this.c;
        Function function = this.d;
        if (!ScalarXMapZHelper.c(observable, function, observer)) {
            observable.subscribe(new SwitchMapSingleMainObserver(observer, function, this.e));
        }
    }
}
