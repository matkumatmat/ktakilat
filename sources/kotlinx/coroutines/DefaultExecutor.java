package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Thread;", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "()V", "", "debugStatus", "I", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultExecutor.kt\nkotlinx/coroutines/DefaultExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,195:1\n1#2:196\n*E\n"})
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final DefaultExecutor k;
    public static final long l;

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlinx.coroutines.DefaultExecutor, kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop] */
    static {
        Long l2;
        ? eventLoopImplBase = new EventLoopImplBase();
        k = eventLoopImplBase;
        eventLoopImplBase.w(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        l = timeUnit.toNanos(l2.longValue());
    }

    public final Thread F() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setContextClassLoader(k.getClass().getClassLoader());
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    public final void G(long j, EventLoopImplBase.DelayedTask delayedTask) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final void H(Runnable runnable) {
        if (debugStatus != 4) {
            super.H(runnable);
            return;
        }
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void M() {
        boolean z;
        int i = debugStatus;
        if (i == 2 || i == 3) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            debugStatus = 3;
            EventLoopImplBase.g.set(this, (Object) null);
            EventLoopImplBase.i.set(this, (Object) null);
            notifyAll();
        }
    }

    public final DisposableHandle m(long j, Runnable runnable, CoroutineContext coroutineContext) {
        long a2 = EventLoop_commonKt.a(j);
        if (a2 >= 4611686018427387903L) {
            return NonDisposableHandle.c;
        }
        long nanoTime = System.nanoTime();
        EventLoopImplBase.DelayedRunnableTask delayedRunnableTask = new EventLoopImplBase.DelayedRunnableTask(runnable, a2 + nanoTime);
        L(nanoTime, delayedRunnableTask);
        return delayedRunnableTask;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        _thread = null;
        M();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        if (K() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        F();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
        r9 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        java.lang.Thread.interrupted();
        r11 = A();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        if (r11 != androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        r15 = java.lang.System.nanoTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r9 != androidx.core.location.LocationRequestCompat.PASSIVE_INTERVAL) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        r9 = l + r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        r15 = r9 - r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
        if (r15 > 0) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
        _thread = null;
        M();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005f, code lost:
        if (K() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0061, code lost:
        F();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0067, code lost:
        if (r11 <= r15) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0069, code lost:
        r11 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006b, code lost:
        r9 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006e, code lost:
        if (r11 <= 0) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r0 = debugStatus;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0072, code lost:
        if (r0 == 2) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0074, code lost:
        if (r0 != 3) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0077, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0079, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007a, code lost:
        if (r0 == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007c, code lost:
        _thread = null;
        M();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0085, code lost:
        if (K() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0087, code lost:
        F();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        java.util.concurrent.locks.LockSupport.parkNanos(r1, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            java.lang.ThreadLocal r0 = kotlinx.coroutines.ThreadLocalEventLoop.f771a
            r0.set(r1)
            r2 = 0
            monitor-enter(r17)     // Catch:{ all -> 0x004e }
            int r0 = debugStatus     // Catch:{ all -> 0x008f }
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r0 == r5) goto L_0x0016
            if (r0 != r4) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r0 = 0
            goto L_0x0017
        L_0x0016:
            r0 = 1
        L_0x0017:
            if (r0 == 0) goto L_0x0029
            monitor-exit(r17)     // Catch:{ all -> 0x004e }
            _thread = r2
            r17.M()
            boolean r0 = r17.K()
            if (r0 != 0) goto L_0x0028
            r17.F()
        L_0x0028:
            return
        L_0x0029:
            debugStatus = r6     // Catch:{ all -> 0x008f }
            r17.notifyAll()     // Catch:{ all -> 0x008f }
            monitor-exit(r17)     // Catch:{ all -> 0x004e }
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r9 = r7
        L_0x0035:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x004e }
            long r11 = r17.A()     // Catch:{ all -> 0x004e }
            r13 = 0
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x006b
            long r15 = java.lang.System.nanoTime()     // Catch:{ all -> 0x004e }
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0050
            long r9 = l     // Catch:{ all -> 0x004e }
            long r9 = r9 + r15
            goto L_0x0050
        L_0x004e:
            r0 = move-exception
            goto L_0x0092
        L_0x0050:
            long r15 = r9 - r15
            int r0 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x0065
            _thread = r2
            r17.M()
            boolean r0 = r17.K()
            if (r0 != 0) goto L_0x0064
            r17.F()
        L_0x0064:
            return
        L_0x0065:
            int r0 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x006c
            r11 = r15
            goto L_0x006c
        L_0x006b:
            r9 = r7
        L_0x006c:
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x0035
            int r0 = debugStatus     // Catch:{ all -> 0x004e }
            if (r0 == r5) goto L_0x0079
            if (r0 != r4) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r0 = 0
            goto L_0x007a
        L_0x0079:
            r0 = 1
        L_0x007a:
            if (r0 == 0) goto L_0x008b
            _thread = r2
            r17.M()
            boolean r0 = r17.K()
            if (r0 != 0) goto L_0x008a
            r17.F()
        L_0x008a:
            return
        L_0x008b:
            java.util.concurrent.locks.LockSupport.parkNanos(r1, r11)     // Catch:{ all -> 0x004e }
            goto L_0x0035
        L_0x008f:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x008f }
            throw r0     // Catch:{ all -> 0x004e }
        L_0x0092:
            _thread = r2
            r17.M()
            boolean r2 = r17.K()
            if (r2 != 0) goto L_0x00a0
            r17.F()
        L_0x00a0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DefaultExecutor.run():void");
    }

    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public final String toString() {
        return "DefaultExecutor";
    }
}
