package io.reactivex.disposables;

import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.OpenHashSet;

public final class CompositeDisposable implements Disposable, DisposableContainer {
    public OpenHashSet c;
    public volatile boolean d;

    public final boolean a(Disposable disposable) {
        if (!c(disposable)) {
            return false;
        }
        disposable.dispose();
        return true;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [io.reactivex.internal.util.OpenHashSet, java.lang.Object] */
    public final boolean b(Disposable disposable) {
        ObjectHelper.b(disposable, "d is null");
        if (!this.d) {
            synchronized (this) {
                try {
                    if (!this.d) {
                        OpenHashSet openHashSet = this.c;
                        OpenHashSet openHashSet2 = openHashSet;
                        if (openHashSet == null) {
                            ? obj = new Object();
                            int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(15));
                            obj.f683a = numberOfLeadingZeros - 1;
                            obj.c = (int) (0.75f * ((float) numberOfLeadingZeros));
                            obj.d = new Object[numberOfLeadingZeros];
                            this.c = obj;
                            openHashSet2 = obj;
                        }
                        openHashSet2.a(disposable);
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

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(io.reactivex.disposables.Disposable r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Disposable item is null"
            io.reactivex.internal.functions.ObjectHelper.b(r8, r0)
            boolean r0 = r7.d
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r7)
            boolean r0 = r7.d     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            monitor-exit(r7)     // Catch:{ all -> 0x0012 }
            return r1
        L_0x0012:
            r8 = move-exception
            goto L_0x004d
        L_0x0014:
            io.reactivex.internal.util.OpenHashSet r0 = r7.c     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x004b
            java.lang.Object[] r2 = r0.d     // Catch:{ all -> 0x0012 }
            int r3 = r0.f683a     // Catch:{ all -> 0x0012 }
            int r4 = r8.hashCode()     // Catch:{ all -> 0x0012 }
            r5 = -1640531527(0xffffffff9e3779b9, float:-9.713111E-21)
            int r4 = r4 * r5
            int r5 = r4 >>> 16
            r4 = r4 ^ r5
            r4 = r4 & r3
            r5 = r2[r4]     // Catch:{ all -> 0x0012 }
            if (r5 != 0) goto L_0x002e
            goto L_0x004b
        L_0x002e:
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0012 }
            r6 = 1
            if (r5 == 0) goto L_0x0039
            r0.b(r4, r3, r2)     // Catch:{ all -> 0x0012 }
            goto L_0x0049
        L_0x0039:
            int r4 = r4 + r6
            r4 = r4 & r3
            r5 = r2[r4]     // Catch:{ all -> 0x0012 }
            if (r5 != 0) goto L_0x0040
            goto L_0x004b
        L_0x0040:
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0012 }
            if (r5 == 0) goto L_0x0039
            r0.b(r4, r3, r2)     // Catch:{ all -> 0x0012 }
        L_0x0049:
            monitor-exit(r7)     // Catch:{ all -> 0x0012 }
            return r6
        L_0x004b:
            monitor-exit(r7)     // Catch:{ all -> 0x0012 }
            return r1
        L_0x004d:
            monitor-exit(r7)     // Catch:{ all -> 0x0012 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.CompositeDisposable.c(io.reactivex.disposables.Disposable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0016, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d() {
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
            r0 = move-exception
            goto L_0x0017
        L_0x000f:
            io.reactivex.internal.util.OpenHashSet r0 = r2.c     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x0015
            int r1 = r0.b     // Catch:{ all -> 0x000d }
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            return r1
        L_0x0017:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.CompositeDisposable.d():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        if (r1 != null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        r1 = r1.d;
        r3 = r1.length;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        if (r5 >= r3) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        r6 = r1[r5];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        if ((r6 instanceof io.reactivex.disposables.Disposable) == false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        ((io.reactivex.disposables.Disposable) r6).dispose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        io.reactivex.exceptions.Exceptions.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        if (r2 == null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0033, code lost:
        r2 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        r2.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003e, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0044, code lost:
        if (r2.size() != 1) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
        throw io.reactivex.internal.util.ExceptionHelper.c((java.lang.Throwable) r2.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
        throw new io.reactivex.exceptions.CompositeException((java.lang.Iterable<? extends java.lang.Throwable>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispose() {
        /*
            r8 = this;
            boolean r0 = r8.d
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r8)
            boolean r0 = r8.d     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x000e
            monitor-exit(r8)     // Catch:{ all -> 0x000c }
            return
        L_0x000c:
            r0 = move-exception
            goto L_0x0058
        L_0x000e:
            r0 = 1
            r8.d = r0     // Catch:{ all -> 0x000c }
            io.reactivex.internal.util.OpenHashSet r1 = r8.c     // Catch:{ all -> 0x000c }
            r2 = 0
            r8.c = r2     // Catch:{ all -> 0x000c }
            monitor-exit(r8)     // Catch:{ all -> 0x000c }
            if (r1 != 0) goto L_0x001a
            goto L_0x0057
        L_0x001a:
            java.lang.Object[] r1 = r1.d
            int r3 = r1.length
            r4 = 0
            r5 = 0
        L_0x001f:
            if (r5 >= r3) goto L_0x003e
            r6 = r1[r5]
            boolean r7 = r6 instanceof io.reactivex.disposables.Disposable
            if (r7 == 0) goto L_0x003b
            io.reactivex.disposables.Disposable r6 = (io.reactivex.disposables.Disposable) r6     // Catch:{ all -> 0x002d }
            r6.dispose()     // Catch:{ all -> 0x002d }
            goto L_0x003b
        L_0x002d:
            r6 = move-exception
            io.reactivex.exceptions.Exceptions.a(r6)
            if (r2 != 0) goto L_0x0038
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0038:
            r2.add(r6)
        L_0x003b:
            int r5 = r5 + 1
            goto L_0x001f
        L_0x003e:
            if (r2 == 0) goto L_0x0057
            int r1 = r2.size()
            if (r1 != r0) goto L_0x0051
            java.lang.Object r0 = r2.get(r4)
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
            monitor-exit(r8)     // Catch:{ all -> 0x000c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.disposables.CompositeDisposable.dispose():void");
    }

    public final boolean isDisposed() {
        return this.d;
    }
}
