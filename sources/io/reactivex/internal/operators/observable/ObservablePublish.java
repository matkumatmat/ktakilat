package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    public final Observable c;
    public final AtomicReference d;
    public final ObservableSource e;

    public static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        public final Observer c;

        public InnerDisposable(Observer observer) {
            this.c = observer;
        }

        public final void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((PublishObserver) andSet).a(this);
            }
        }

        public final boolean isDisposed() {
            if (get() == this) {
                return true;
            }
            return false;
        }
    }

    public static final class PublishObserver<T> implements Observer<T>, Disposable {
        public static final InnerDisposable[] g = new InnerDisposable[0];
        public static final InnerDisposable[] i = new InnerDisposable[0];
        public final AtomicReference c;
        public final AtomicReference d = new AtomicReference(g);
        public final AtomicBoolean e;
        public final AtomicReference f = new AtomicReference();

        public PublishObserver(AtomicReference atomicReference) {
            this.c = atomicReference;
            this.e = new AtomicBoolean();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable r8) {
            /*
                r7 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference r0 = r7.d
                java.lang.Object r1 = r0.get()
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r1 = (io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[]) r1
                int r2 = r1.length
                if (r2 != 0) goto L_0x000c
                return
            L_0x000c:
                r3 = 0
                r4 = 0
            L_0x000e:
                if (r4 >= r2) goto L_0x001c
                r5 = r1[r4]
                boolean r5 = r5.equals(r8)
                if (r5 == 0) goto L_0x0019
                goto L_0x001d
            L_0x0019:
                int r4 = r4 + 1
                goto L_0x000e
            L_0x001c:
                r4 = -1
            L_0x001d:
                if (r4 >= 0) goto L_0x0020
                return
            L_0x0020:
                r5 = 1
                if (r2 != r5) goto L_0x0026
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r2 = g
                goto L_0x0035
            L_0x0026:
                int r6 = r2 + -1
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r6 = new io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[r6]
                java.lang.System.arraycopy(r1, r3, r6, r3, r4)
                int r3 = r4 + 1
                int r2 = r2 - r4
                int r2 = r2 - r5
                java.lang.System.arraycopy(r1, r3, r6, r4, r2)
                r2 = r6
            L_0x0035:
                boolean r3 = r0.compareAndSet(r1, r2)
                if (r3 == 0) goto L_0x003c
                return
            L_0x003c:
                java.lang.Object r3 = r0.get()
                if (r3 == r1) goto L_0x0035
                goto L_0x0000
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver.a(io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable):void");
        }

        public final void dispose() {
            AtomicReference atomicReference;
            AtomicReference atomicReference2 = this.d;
            InnerDisposable[] innerDisposableArr = i;
            if (((InnerDisposable[]) atomicReference2.getAndSet(innerDisposableArr)) != innerDisposableArr) {
                do {
                    atomicReference = this.c;
                    if (atomicReference.compareAndSet(this, (Object) null) || atomicReference.get() != this) {
                        DisposableHelper.dispose(this.f);
                    }
                    atomicReference = this.c;
                    break;
                } while (atomicReference.get() != this);
                DisposableHelper.dispose(this.f);
            }
        }

        public final boolean isDisposed() {
            if (this.d.get() == i) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete() {
            /*
                r4 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference r0 = r4.c
                r1 = 0
                boolean r1 = r0.compareAndSet(r4, r1)
                if (r1 == 0) goto L_0x000a
                goto L_0x0010
            L_0x000a:
                java.lang.Object r0 = r0.get()
                if (r0 == r4) goto L_0x0000
            L_0x0010:
                java.util.concurrent.atomic.AtomicReference r0 = r4.d
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r1 = i
                java.lang.Object r0 = r0.getAndSet(r1)
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r0 = (io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[]) r0
                int r1 = r0.length
                r2 = 0
            L_0x001c:
                if (r2 >= r1) goto L_0x0028
                r3 = r0[r2]
                io.reactivex.Observer r3 = r3.c
                r3.onComplete()
                int r2 = r2 + 1
                goto L_0x001c
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver.onComplete():void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onError(java.lang.Throwable r5) {
            /*
                r4 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference r0 = r4.c
                r1 = 0
                boolean r1 = r0.compareAndSet(r4, r1)
                if (r1 == 0) goto L_0x000a
                goto L_0x0010
            L_0x000a:
                java.lang.Object r0 = r0.get()
                if (r0 == r4) goto L_0x0000
            L_0x0010:
                java.util.concurrent.atomic.AtomicReference r0 = r4.d
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r1 = i
                java.lang.Object r0 = r0.getAndSet(r1)
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r0 = (io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[]) r0
                int r1 = r0.length
                if (r1 == 0) goto L_0x002b
                int r1 = r0.length
                r2 = 0
            L_0x001f:
                if (r2 >= r1) goto L_0x002e
                r3 = r0[r2]
                io.reactivex.Observer r3 = r3.c
                r3.onError(r5)
                int r2 = r2 + 1
                goto L_0x001f
            L_0x002b:
                io.reactivex.plugins.RxJavaPlugins.b(r5)
            L_0x002e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver.onError(java.lang.Throwable):void");
        }

        public final void onNext(Object obj) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.d.get()) {
                innerDisposable.c.onNext(obj);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f, disposable);
        }
    }

    public static final class PublishSource<T> implements ObservableSource<T> {
        public final AtomicReference c;

        public PublishSource(AtomicReference atomicReference) {
            this.c = atomicReference;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.Object} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void subscribe(io.reactivex.Observer r8) {
            /*
                r7 = this;
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable r0 = new io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable
                r0.<init>(r8)
                r8.onSubscribe(r0)
            L_0x0008:
                java.util.concurrent.atomic.AtomicReference r8 = r7.c
                java.lang.Object r1 = r8.get()
                io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver r1 = (io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver) r1
                if (r1 == 0) goto L_0x001b
                boolean r2 = r1.isDisposed()
                if (r2 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r3 = r1
                goto L_0x0027
            L_0x001b:
                io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver r2 = new io.reactivex.internal.operators.observable.ObservablePublish$PublishObserver
                r2.<init>(r8)
            L_0x0020:
                boolean r3 = r8.compareAndSet(r1, r2)
                if (r3 == 0) goto L_0x0058
                r3 = r2
            L_0x0027:
                java.util.concurrent.atomic.AtomicReference r4 = r3.d
                java.lang.Object r8 = r4.get()
                r5 = r8
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r5 = (io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[]) r5
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r8 = io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver.i
                if (r5 != r8) goto L_0x0035
                goto L_0x0008
            L_0x0035:
                int r8 = r5.length
                int r1 = r8 + 1
                io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable[] r6 = new io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[r1]
                r1 = 0
                java.lang.System.arraycopy(r5, r1, r6, r1, r8)
                r6[r8] = r0
            L_0x0040:
                boolean r8 = r4.compareAndSet(r5, r6)
                if (r8 == 0) goto L_0x0051
                r8 = 0
                boolean r8 = r0.compareAndSet(r8, r3)
                if (r8 != 0) goto L_0x0050
                r3.a(r0)
            L_0x0050:
                return
            L_0x0051:
                java.lang.Object r8 = r4.get()
                if (r8 == r5) goto L_0x0040
                goto L_0x0027
            L_0x0058:
                java.lang.Object r3 = r8.get()
                if (r3 == r1) goto L_0x0020
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservablePublish.PublishSource.subscribe(io.reactivex.Observer):void");
        }
    }

    public ObservablePublish(ObservableSource observableSource, Observable observable, AtomicReference atomicReference) {
        this.e = observableSource;
        this.c = observable;
        this.d = atomicReference;
    }

    public static ObservablePublish d(Observable observable) {
        AtomicReference atomicReference = new AtomicReference();
        return new ObservablePublish(new PublishSource(atomicReference), observable, atomicReference);
    }

    public final void c(Consumer consumer) {
        PublishObserver publishObserver;
        loop0:
        while (true) {
            AtomicReference atomicReference = this.d;
            publishObserver = (PublishObserver) atomicReference.get();
            if (publishObserver != null && !publishObserver.isDisposed()) {
                break;
            }
            PublishObserver publishObserver2 = new PublishObserver(atomicReference);
            while (true) {
                if (atomicReference.compareAndSet(publishObserver, publishObserver2)) {
                    publishObserver = publishObserver2;
                    break loop0;
                } else if (atomicReference.get() != publishObserver) {
                }
            }
        }
        AtomicBoolean atomicBoolean = publishObserver.e;
        boolean z = false;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(publishObserver);
            if (z) {
                this.c.subscribe(publishObserver);
            }
        } catch (Throwable th) {
            Exceptions.a(th);
            throw ExceptionHelper.c(th);
        }
    }

    public final void subscribeActual(Observer observer) {
        ((PublishSource) this.e).subscribe(observer);
    }
}
