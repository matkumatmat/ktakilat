package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.LinkedList;

public final class ListCompositeDisposable implements Disposable, DisposableContainer {
    public LinkedList c;
    public volatile boolean d;

    public final boolean a(Disposable disposable) {
        if (!c(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    public final boolean b(Disposable disposable) {
        if (!this.d) {
            synchronized (this) {
                try {
                    if (!this.d) {
                        LinkedList linkedList = this.c;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.c = linkedList;
                        }
                        linkedList.add(disposable);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        disposable.dispose();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x001e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(io.reactivex.disposables.Disposable r3) {
        /*
            r2 = this;
            boolean r0 = r2.d
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            boolean r0 = r2.d     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            return r1
        L_0x000d:
            r3 = move-exception
            goto L_0x001f
        L_0x000f:
            java.util.LinkedList r0 = r2.c     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x001d
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x000d }
            if (r3 != 0) goto L_0x001a
            goto L_0x001d
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            r3 = 1
            return r3
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            return r1
        L_0x001f:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.disposables.ListCompositeDisposable.c(io.reactivex.disposables.Disposable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        if (r1 != null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        if (r1.hasNext() == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        ((io.reactivex.disposables.Disposable) r1.next()).dispose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
        io.reactivex.exceptions.Exceptions.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        if (r2 == null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
        r2 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        r2.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0043, code lost:
        if (r2.size() != 1) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        throw io.reactivex.internal.util.ExceptionHelper.c((java.lang.Throwable) r2.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        throw new io.reactivex.exceptions.CompositeException((java.lang.Iterable<? extends java.lang.Throwable>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispose() {
        /*
            r4 = this;
            boolean r0 = r4.d
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r4)
            boolean r0 = r4.d     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r4)     // Catch:{ all -> 0x000c }
            return
        L_0x000c:
            r0 = move-exception
            goto L_0x0058
        L_0x000e:
            r0 = 1
            r4.d = r0     // Catch:{ all -> 0x000c }
            java.util.LinkedList r1 = r4.c     // Catch:{ all -> 0x000c }
            r2 = 0
            r4.c = r2     // Catch:{ all -> 0x000c }
            monitor-exit(r4)     // Catch:{ all -> 0x000c }
            if (r1 != 0) goto L_0x001a
            goto L_0x0057
        L_0x001a:
            java.util.Iterator r1 = r1.iterator()
        L_0x001e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x003d
            java.lang.Object r3 = r1.next()
            io.reactivex.disposables.Disposable r3 = (io.reactivex.disposables.Disposable) r3
            r3.dispose()     // Catch:{ all -> 0x002e }
            goto L_0x001e
        L_0x002e:
            r3 = move-exception
            io.reactivex.exceptions.Exceptions.a(r3)
            if (r2 != 0) goto L_0x0039
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0039:
            r2.add(r3)
            goto L_0x001e
        L_0x003d:
            if (r2 == 0) goto L_0x0057
            int r1 = r2.size()
            if (r1 != r0) goto L_0x0051
            r0 = 0
            java.lang.Object r0 = r2.get(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.RuntimeException r0 = io.reactivex.internal.util.ExceptionHelper.c(r0)
            throw r0
        L_0x0051:
            io.reactivex.exceptions.CompositeException r0 = new io.reactivex.exceptions.CompositeException
            r0.<init>((java.lang.Iterable<? extends java.lang.Throwable>) r2)
            throw r0
        L_0x0057:
            return
        L_0x0058:
            monitor-exit(r4)     // Catch:{ all -> 0x000c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.disposables.ListCompositeDisposable.dispose():void");
    }

    public final boolean isDisposed() {
        return this.d;
    }
}
