package bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CancellationTokenSource implements Closeable {
    private boolean cancellationRequested;
    private boolean closed;
    private final ScheduledExecutorService executor = BoltsExecutors.scheduled();
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final List<CancellationTokenRegistration> registrations = new ArrayList();
    /* access modifiers changed from: private */
    public ScheduledFuture<?> scheduledCancellation;

    private void cancelScheduledCancellation() {
        ScheduledFuture<?> scheduledFuture = this.scheduledCancellation;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.scheduledCancellation = null;
        }
    }

    private void notifyListeners(List<CancellationTokenRegistration> list) {
        for (CancellationTokenRegistration runAction : list) {
            runAction.runAction();
        }
    }

    private void throwIfClosed() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    public void cancel() {
        synchronized (this.lock) {
            try {
                throwIfClosed();
                if (!this.cancellationRequested) {
                    cancelScheduledCancellation();
                    this.cancellationRequested = true;
                    ArrayList arrayList = new ArrayList(this.registrations);
                    notifyListeners(arrayList);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public void cancelAfter(long j) {
        cancelAfter(j, TimeUnit.MILLISECONDS);
    }

    public void close() {
        synchronized (this.lock) {
            try {
                if (!this.closed) {
                    cancelScheduledCancellation();
                    for (CancellationTokenRegistration close : this.registrations) {
                        close.close();
                    }
                    this.registrations.clear();
                    this.closed = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public CancellationToken getToken() {
        CancellationToken cancellationToken;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationToken = new CancellationToken(this);
        }
        return cancellationToken;
    }

    public boolean isCancellationRequested() {
        boolean z;
        synchronized (this.lock) {
            throwIfClosed();
            z = this.cancellationRequested;
        }
        return z;
    }

    public CancellationTokenRegistration register(Runnable runnable) {
        CancellationTokenRegistration cancellationTokenRegistration;
        synchronized (this.lock) {
            try {
                throwIfClosed();
                cancellationTokenRegistration = new CancellationTokenRegistration(this, runnable);
                if (this.cancellationRequested) {
                    cancellationTokenRegistration.runAction();
                } else {
                    this.registrations.add(cancellationTokenRegistration);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cancellationTokenRegistration;
    }

    public void throwIfCancellationRequested() throws CancellationException {
        synchronized (this.lock) {
            try {
                throwIfClosed();
                if (this.cancellationRequested) {
                    throw new CancellationException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        Locale locale = Locale.US;
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        String bool = Boolean.toString(isCancellationRequested());
        return name + "@" + hexString + "[cancellationRequested=" + bool + "]";
    }

    public void unregister(CancellationTokenRegistration cancellationTokenRegistration) {
        synchronized (this.lock) {
            throwIfClosed();
            this.registrations.remove(cancellationTokenRegistration);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cancelAfter(long r5, java.util.concurrent.TimeUnit r7) {
        /*
            r4 = this;
            r0 = -1
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0031
            r0 = 0
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x0010
            r4.cancel()
            return
        L_0x0010:
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            boolean r1 = r4.cancellationRequested     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x001b
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return
        L_0x0019:
            r5 = move-exception
            goto L_0x002f
        L_0x001b:
            r4.cancelScheduledCancellation()     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x002d
            java.util.concurrent.ScheduledExecutorService r1 = r4.executor     // Catch:{ all -> 0x0019 }
            bolts.CancellationTokenSource$1 r2 = new bolts.CancellationTokenSource$1     // Catch:{ all -> 0x0019 }
            r2.<init>()     // Catch:{ all -> 0x0019 }
            java.util.concurrent.ScheduledFuture r5 = r1.schedule(r2, r5, r7)     // Catch:{ all -> 0x0019 }
            r4.scheduledCancellation = r5     // Catch:{ all -> 0x0019 }
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r5
        L_0x0031:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Delay must be >= -1"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bolts.CancellationTokenSource.cancelAfter(long, java.util.concurrent.TimeUnit):void");
    }
}
