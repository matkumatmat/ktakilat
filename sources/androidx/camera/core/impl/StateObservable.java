package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class StateObservable<T> implements Observable<T> {
    private static final int INITIAL_VERSION = 0;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private final CopyOnWriteArraySet<ObserverWrapper<T>> mNotifySet = new CopyOnWriteArraySet<>();
    private final AtomicReference<Object> mState;
    @GuardedBy("mLock")
    private boolean mUpdating = false;
    @GuardedBy("mLock")
    private int mVersion = 0;
    @GuardedBy("mLock")
    private final Map<Observable.Observer<? super T>, ObserverWrapper<T>> mWrapperMap = new HashMap();

    @AutoValue
    public static abstract class ErrorWrapper {
        @NonNull
        public static ErrorWrapper wrap(@NonNull Throwable th) {
            return new AutoValue_StateObservable_ErrorWrapper(th);
        }

        @NonNull
        public abstract Throwable getError();
    }

    public static final class ObserverWrapper<T> implements Runnable {
        private static final Object NOT_SET = new Object();
        private static final int NO_VERSION = -1;
        private final AtomicBoolean mActive = new AtomicBoolean(true);
        private final Executor mExecutor;
        private Object mLastState = NOT_SET;
        @GuardedBy("this")
        private int mLatestSignalledVersion = -1;
        private final Observable.Observer<? super T> mObserver;
        private final AtomicReference<Object> mStateRef;
        @GuardedBy("this")
        private boolean mWrapperUpdating = false;

        public ObserverWrapper(@NonNull AtomicReference<Object> atomicReference, @NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
            this.mStateRef = atomicReference;
            this.mExecutor = executor;
            this.mObserver = observer;
        }

        public void close() {
            this.mActive.set(false);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
            if (java.util.Objects.equals(r4.mLastState, r0) != false) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            r4.mLastState = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            if ((r0 instanceof androidx.camera.core.impl.StateObservable.ErrorWrapper) == false) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
            r4.mObserver.onError(((androidx.camera.core.impl.StateObservable.ErrorWrapper) r0).getError());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
            r4.mObserver.onNewData(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
            if (r2 == r4.mLatestSignalledVersion) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
            if (r4.mActive.get() != false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
            r0 = r4.mStateRef.get();
            r2 = r4.mLatestSignalledVersion;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0050, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
            r4.mWrapperUpdating = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0055, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0057, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                monitor-enter(r4)
                java.util.concurrent.atomic.AtomicBoolean r0 = r4.mActive     // Catch:{ all -> 0x000e }
                boolean r0 = r0.get()     // Catch:{ all -> 0x000e }
                r1 = 0
                if (r0 != 0) goto L_0x0010
                r4.mWrapperUpdating = r1     // Catch:{ all -> 0x000e }
                monitor-exit(r4)     // Catch:{ all -> 0x000e }
                return
            L_0x000e:
                r0 = move-exception
                goto L_0x0058
            L_0x0010:
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r4.mStateRef     // Catch:{ all -> 0x000e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x000e }
                int r2 = r4.mLatestSignalledVersion     // Catch:{ all -> 0x000e }
                monitor-exit(r4)     // Catch:{ all -> 0x000e }
            L_0x0019:
                java.lang.Object r3 = r4.mLastState
                boolean r3 = java.util.Objects.equals(r3, r0)
                if (r3 != 0) goto L_0x0038
                r4.mLastState = r0
                boolean r3 = r0 instanceof androidx.camera.core.impl.StateObservable.ErrorWrapper
                if (r3 == 0) goto L_0x0033
                androidx.camera.core.impl.Observable$Observer<? super T> r3 = r4.mObserver
                androidx.camera.core.impl.StateObservable$ErrorWrapper r0 = (androidx.camera.core.impl.StateObservable.ErrorWrapper) r0
                java.lang.Throwable r0 = r0.getError()
                r3.onError(r0)
                goto L_0x0038
            L_0x0033:
                androidx.camera.core.impl.Observable$Observer<? super T> r3 = r4.mObserver
                r3.onNewData(r0)
            L_0x0038:
                monitor-enter(r4)
                int r0 = r4.mLatestSignalledVersion     // Catch:{ all -> 0x0050 }
                if (r2 == r0) goto L_0x0052
                java.util.concurrent.atomic.AtomicBoolean r0 = r4.mActive     // Catch:{ all -> 0x0050 }
                boolean r0 = r0.get()     // Catch:{ all -> 0x0050 }
                if (r0 != 0) goto L_0x0046
                goto L_0x0052
            L_0x0046:
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r4.mStateRef     // Catch:{ all -> 0x0050 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0050 }
                int r2 = r4.mLatestSignalledVersion     // Catch:{ all -> 0x0050 }
                monitor-exit(r4)     // Catch:{ all -> 0x0050 }
                goto L_0x0019
            L_0x0050:
                r0 = move-exception
                goto L_0x0056
            L_0x0052:
                r4.mWrapperUpdating = r1     // Catch:{ all -> 0x0050 }
                monitor-exit(r4)     // Catch:{ all -> 0x0050 }
                return
            L_0x0056:
                monitor-exit(r4)     // Catch:{ all -> 0x0050 }
                throw r0
            L_0x0058:
                monitor-exit(r4)     // Catch:{ all -> 0x000e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.StateObservable.ObserverWrapper.run():void");
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void update(int r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                java.util.concurrent.atomic.AtomicBoolean r0 = r1.mActive     // Catch:{ all -> 0x000b }
                boolean r0 = r0.get()     // Catch:{ all -> 0x000b }
                if (r0 != 0) goto L_0x000d
                monitor-exit(r1)     // Catch:{ all -> 0x000b }
                return
            L_0x000b:
                r2 = move-exception
                goto L_0x002e
            L_0x000d:
                int r0 = r1.mLatestSignalledVersion     // Catch:{ all -> 0x000b }
                if (r2 > r0) goto L_0x0013
                monitor-exit(r1)     // Catch:{ all -> 0x000b }
                return
            L_0x0013:
                r1.mLatestSignalledVersion = r2     // Catch:{ all -> 0x000b }
                boolean r2 = r1.mWrapperUpdating     // Catch:{ all -> 0x000b }
                if (r2 == 0) goto L_0x001b
                monitor-exit(r1)     // Catch:{ all -> 0x000b }
                return
            L_0x001b:
                r2 = 1
                r1.mWrapperUpdating = r2     // Catch:{ all -> 0x000b }
                monitor-exit(r1)     // Catch:{ all -> 0x000b }
                java.util.concurrent.Executor r2 = r1.mExecutor     // Catch:{ all -> 0x0025 }
                r2.execute(r1)     // Catch:{ all -> 0x0025 }
                goto L_0x002a
            L_0x0025:
                monitor-enter(r1)
                r2 = 0
                r1.mWrapperUpdating = r2     // Catch:{ all -> 0x002b }
                monitor-exit(r1)     // Catch:{ all -> 0x002b }
            L_0x002a:
                return
            L_0x002b:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x002b }
                throw r2
            L_0x002e:
                monitor-exit(r1)     // Catch:{ all -> 0x000b }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.StateObservable.ObserverWrapper.update(int):void");
        }
    }

    public StateObservable(@Nullable Object obj, boolean z) {
        if (z) {
            Preconditions.checkArgument(obj instanceof Throwable, "Initial errors must be Throwable");
            this.mState = new AtomicReference<>(ErrorWrapper.wrap((Throwable) obj));
            return;
        }
        this.mState = new AtomicReference<>(obj);
    }

    @GuardedBy("mLock")
    private void removeObserverLocked(@NonNull Observable.Observer<? super T> observer) {
        ObserverWrapper remove = this.mWrapperMap.remove(observer);
        if (remove != null) {
            remove.close();
            this.mNotifySet.remove(remove);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r1.hasNext() == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        r1.next().update(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r1 = r3.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        if (r3.mVersion != r4) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        r3.mUpdating = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        r4 = r3.mNotifySet.iterator();
        r0 = r3.mVersion;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004e, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004f, code lost:
        r1 = r4;
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0053, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateStateInternal(@androidx.annotation.Nullable java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r3.mState     // Catch:{ all -> 0x0011 }
            java.lang.Object r1 = r1.getAndSet(r4)     // Catch:{ all -> 0x0011 }
            boolean r4 = java.util.Objects.equals(r1, r4)     // Catch:{ all -> 0x0011 }
            if (r4 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r4 = move-exception
            goto L_0x0054
        L_0x0013:
            int r4 = r3.mVersion     // Catch:{ all -> 0x0011 }
            r1 = 1
            int r4 = r4 + r1
            r3.mVersion = r4     // Catch:{ all -> 0x0011 }
            boolean r2 = r3.mUpdating     // Catch:{ all -> 0x0011 }
            if (r2 == 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x001f:
            r3.mUpdating = r1     // Catch:{ all -> 0x0011 }
            java.util.concurrent.CopyOnWriteArraySet<androidx.camera.core.impl.StateObservable$ObserverWrapper<T>> r1 = r3.mNotifySet     // Catch:{ all -> 0x0011 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
        L_0x0028:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0038
            java.lang.Object r0 = r1.next()
            androidx.camera.core.impl.StateObservable$ObserverWrapper r0 = (androidx.camera.core.impl.StateObservable.ObserverWrapper) r0
            r0.update(r4)
            goto L_0x0028
        L_0x0038:
            java.lang.Object r1 = r3.mLock
            monitor-enter(r1)
            int r0 = r3.mVersion     // Catch:{ all -> 0x0044 }
            if (r0 != r4) goto L_0x0046
            r4 = 0
            r3.mUpdating = r4     // Catch:{ all -> 0x0044 }
            monitor-exit(r1)     // Catch:{ all -> 0x0044 }
            return
        L_0x0044:
            r4 = move-exception
            goto L_0x0052
        L_0x0046:
            java.util.concurrent.CopyOnWriteArraySet<androidx.camera.core.impl.StateObservable$ObserverWrapper<T>> r4 = r3.mNotifySet     // Catch:{ all -> 0x0044 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0044 }
            int r0 = r3.mVersion     // Catch:{ all -> 0x0044 }
            monitor-exit(r1)     // Catch:{ all -> 0x0044 }
            r1 = r4
            r4 = r0
            goto L_0x0028
        L_0x0052:
            monitor-exit(r1)     // Catch:{ all -> 0x0044 }
            throw r4
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.StateObservable.updateStateInternal(java.lang.Object):void");
    }

    public void addObserver(@NonNull Executor executor, @NonNull Observable.Observer<? super T> observer) {
        ObserverWrapper observerWrapper;
        synchronized (this.mLock) {
            removeObserverLocked(observer);
            observerWrapper = new ObserverWrapper(this.mState, executor, observer);
            this.mWrapperMap.put(observer, observerWrapper);
            this.mNotifySet.add(observerWrapper);
        }
        observerWrapper.update(0);
    }

    @NonNull
    public ListenableFuture<T> fetchData() {
        Object obj = this.mState.get();
        if (obj instanceof ErrorWrapper) {
            return Futures.immediateFailedFuture(((ErrorWrapper) obj).getError());
        }
        return Futures.immediateFuture(obj);
    }

    public void removeObserver(@NonNull Observable.Observer<? super T> observer) {
        synchronized (this.mLock) {
            removeObserverLocked(observer);
        }
    }

    public void removeObservers() {
        synchronized (this.mLock) {
            try {
                Iterator it = new HashSet(this.mWrapperMap.keySet()).iterator();
                while (it.hasNext()) {
                    removeObserverLocked((Observable.Observer) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void updateState(@Nullable T t) {
        updateStateInternal(t);
    }

    public void updateStateAsError(@NonNull Throwable th) {
        updateStateInternal(ErrorWrapper.wrap(th));
    }
}
