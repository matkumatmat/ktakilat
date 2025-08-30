package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject<T> extends Subject<T> {
    public static final PublishDisposable[] e = new PublishDisposable[0];
    public static final PublishDisposable[] f = new PublishDisposable[0];
    public final AtomicReference c = new AtomicReference(f);
    public Throwable d;

    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        public final Observer c;
        public final PublishSubject d;

        public PublishDisposable(Observer observer, PublishSubject publishSubject) {
            this.c = observer;
            this.d = publishSubject;
        }

        public final void dispose() {
            if (compareAndSet(false, true)) {
                this.d.d(this);
            }
        }

        public final boolean isDisposed() {
            return get();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: io.reactivex.subjects.PublishSubject$PublishDisposable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: io.reactivex.subjects.PublishSubject$PublishDisposable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(io.reactivex.subjects.PublishSubject.PublishDisposable r8) {
        /*
            r7 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference r0 = r7.c
            java.lang.Object r1 = r0.get()
            io.reactivex.subjects.PublishSubject$PublishDisposable[] r1 = (io.reactivex.subjects.PublishSubject.PublishDisposable[]) r1
            io.reactivex.subjects.PublishSubject$PublishDisposable[] r2 = e
            if (r1 == r2) goto L_0x0042
            io.reactivex.subjects.PublishSubject$PublishDisposable[] r2 = f
            if (r1 != r2) goto L_0x0011
            goto L_0x0042
        L_0x0011:
            int r3 = r1.length
            r4 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r3) goto L_0x001e
            r6 = r1[r5]
            if (r6 != r8) goto L_0x001b
            goto L_0x001f
        L_0x001b:
            int r5 = r5 + 1
            goto L_0x0014
        L_0x001e:
            r5 = -1
        L_0x001f:
            if (r5 >= 0) goto L_0x0022
            return
        L_0x0022:
            r6 = 1
            if (r3 != r6) goto L_0x0026
            goto L_0x0034
        L_0x0026:
            int r2 = r3 + -1
            io.reactivex.subjects.PublishSubject$PublishDisposable[] r2 = new io.reactivex.subjects.PublishSubject.PublishDisposable[r2]
            java.lang.System.arraycopy(r1, r4, r2, r4, r5)
            int r4 = r5 + 1
            int r3 = r3 - r5
            int r3 = r3 - r6
            java.lang.System.arraycopy(r1, r4, r2, r5, r3)
        L_0x0034:
            boolean r3 = r0.compareAndSet(r1, r2)
            if (r3 == 0) goto L_0x003b
            return
        L_0x003b:
            java.lang.Object r3 = r0.get()
            if (r3 == r1) goto L_0x0034
            goto L_0x0000
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.PublishSubject.d(io.reactivex.subjects.PublishSubject$PublishDisposable):void");
    }

    public final void onComplete() {
        AtomicReference atomicReference = this.c;
        Object obj = atomicReference.get();
        Object obj2 = e;
        if (obj != obj2) {
            for (PublishDisposable publishDisposable : (PublishDisposable[]) atomicReference.getAndSet(obj2)) {
                if (!publishDisposable.get()) {
                    publishDisposable.c.onComplete();
                }
            }
        }
    }

    public final void onError(Throwable th) {
        ObjectHelper.b(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AtomicReference atomicReference = this.c;
        Object obj = atomicReference.get();
        Object obj2 = e;
        if (obj == obj2) {
            RxJavaPlugins.b(th);
            return;
        }
        this.d = th;
        for (PublishDisposable publishDisposable : (PublishDisposable[]) atomicReference.getAndSet(obj2)) {
            if (publishDisposable.get()) {
                RxJavaPlugins.b(th);
            } else {
                publishDisposable.c.onError(th);
            }
        }
    }

    public final void onNext(Object obj) {
        ObjectHelper.b(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable publishDisposable : (PublishDisposable[]) this.c.get()) {
            if (!publishDisposable.get()) {
                publishDisposable.c.onNext(obj);
            }
        }
    }

    public final void onSubscribe(Disposable disposable) {
        if (this.c.get() == e) {
            disposable.dispose();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: io.reactivex.subjects.PublishSubject$PublishDisposable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void subscribeActual(io.reactivex.Observer r7) {
        /*
            r6 = this;
            io.reactivex.subjects.PublishSubject$PublishDisposable r0 = new io.reactivex.subjects.PublishSubject$PublishDisposable
            r0.<init>(r7, r6)
            r7.onSubscribe(r0)
        L_0x0008:
            java.util.concurrent.atomic.AtomicReference r1 = r6.c
            java.lang.Object r2 = r1.get()
            io.reactivex.subjects.PublishSubject$PublishDisposable[] r2 = (io.reactivex.subjects.PublishSubject.PublishDisposable[]) r2
            io.reactivex.subjects.PublishSubject$PublishDisposable[] r3 = e
            if (r2 != r3) goto L_0x0020
            java.lang.Throwable r0 = r6.d
            if (r0 == 0) goto L_0x001c
            r7.onError(r0)
            goto L_0x003a
        L_0x001c:
            r7.onComplete()
            goto L_0x003a
        L_0x0020:
            int r3 = r2.length
            int r4 = r3 + 1
            io.reactivex.subjects.PublishSubject$PublishDisposable[] r4 = new io.reactivex.subjects.PublishSubject.PublishDisposable[r4]
            r5 = 0
            java.lang.System.arraycopy(r2, r5, r4, r5, r3)
            r4[r3] = r0
        L_0x002b:
            boolean r3 = r1.compareAndSet(r2, r4)
            if (r3 == 0) goto L_0x003b
            boolean r7 = r0.get()
            if (r7 == 0) goto L_0x003a
            r6.d(r0)
        L_0x003a:
            return
        L_0x003b:
            java.lang.Object r3 = r1.get()
            if (r3 == r2) goto L_0x002b
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.PublishSubject.subscribeActual(io.reactivex.Observer):void");
    }
}
