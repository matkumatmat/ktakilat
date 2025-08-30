package androidx.camera.video.internal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class SharedByteBuffer implements Closeable {
    private static final String TAG = "SharedByteBuffer";
    private final Object mCloseLock = new Object();
    @GuardedBy("mCloseLock")
    private boolean mClosed = false;
    private final Pair<Executor, Runnable> mFinalCloseAction;
    private final int mShareId;
    private final ByteBuffer mSharedByteBuffer;
    @GuardedBy("mCloseLock")
    private final AtomicInteger mSharedRefCount;

    private SharedByteBuffer(@NonNull ByteBuffer byteBuffer, @NonNull AtomicInteger atomicInteger, @NonNull Pair<Executor, Runnable> pair, int i) {
        int i2;
        this.mSharedByteBuffer = byteBuffer;
        this.mSharedRefCount = atomicInteger;
        this.mFinalCloseAction = pair;
        this.mShareId = i;
        if (Logger.isDebugEnabled(TAG) && (i2 = atomicInteger.get()) < 1) {
            Locale locale = Locale.US;
            String sharedByteBuffer = toString();
            throw new AssertionError("Cannot create new instance of SharedByteBuffer with invalid ref count " + i2 + ". Ref count must be >= 1. [" + sharedByteBuffer + "]");
        }
    }

    @GuardedBy("mCloseLock")
    private void checkNotClosed(@NonNull String str) {
        if (this.mClosed) {
            throw new IllegalStateException(ba.o("Cannot call ", str, " on a closed SharedByteBuffer."));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (androidx.camera.core.Logger.isDebugEnabled(TAG) == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r2 < 0) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r3 = java.util.Locale.US;
        r3 = toString();
        androidx.camera.core.Logger.d(TAG, "Ref count decremented: " + r2 + " [" + r3 + "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        throw new java.lang.AssertionError("Invalid ref count. close() should never produce a ref count below 0");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        if (r2 != 0) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (androidx.camera.core.Logger.isDebugEnabled(TAG) == false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005a, code lost:
        r2 = java.util.Locale.US;
        r2 = toString();
        androidx.camera.core.Logger.d(TAG, "Final reference released. Running final close action. [" + r2 + "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        ((java.util.concurrent.Executor) androidx.core.util.Preconditions.checkNotNull((java.util.concurrent.Executor) r6.mFinalCloseAction.first)).execute((java.lang.Runnable) androidx.core.util.Preconditions.checkNotNull((java.lang.Runnable) r6.mFinalCloseAction.second));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0094, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r3 = java.util.Locale.US;
        r3 = toString();
        androidx.camera.core.Logger.e(TAG, "Unable to execute final close action. [" + r3 + "]", r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean closeInternal() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mCloseLock
            monitor-enter(r0)
            boolean r1 = r6.mClosed     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            r0 = 0
            return r0
        L_0x000a:
            r1 = move-exception
            goto L_0x00b4
        L_0x000d:
            r1 = 1
            r6.mClosed = r1     // Catch:{ all -> 0x000a }
            java.util.concurrent.atomic.AtomicInteger r2 = r6.mSharedRefCount     // Catch:{ all -> 0x000a }
            int r2 = r2.decrementAndGet()     // Catch:{ all -> 0x000a }
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            java.lang.String r0 = "SharedByteBuffer"
            boolean r0 = androidx.camera.core.Logger.isDebugEnabled(r0)
            if (r0 == 0) goto L_0x0050
            if (r2 < 0) goto L_0x0048
            java.lang.String r0 = "SharedByteBuffer"
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r3 = r6.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Ref count decremented: "
            r4.<init>(r5)
            r4.append(r2)
            java.lang.String r5 = " ["
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = "]"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            androidx.camera.core.Logger.d(r0, r3)
            goto L_0x0050
        L_0x0048:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "Invalid ref count. close() should never produce a ref count below 0"
            r0.<init>(r1)
            throw r0
        L_0x0050:
            if (r2 != 0) goto L_0x00b3
            java.lang.String r0 = "SharedByteBuffer"
            boolean r0 = androidx.camera.core.Logger.isDebugEnabled(r0)
            if (r0 == 0) goto L_0x0078
            java.lang.String r0 = "SharedByteBuffer"
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r2 = r6.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Final reference released. Running final close action. ["
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = "]"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            androidx.camera.core.Logger.d(r0, r2)
        L_0x0078:
            androidx.core.util.Pair<java.util.concurrent.Executor, java.lang.Runnable> r0 = r6.mFinalCloseAction     // Catch:{ RejectedExecutionException -> 0x0094 }
            F r0 = r0.first     // Catch:{ RejectedExecutionException -> 0x0094 }
            java.util.concurrent.Executor r0 = (java.util.concurrent.Executor) r0     // Catch:{ RejectedExecutionException -> 0x0094 }
            java.lang.Object r0 = androidx.core.util.Preconditions.checkNotNull(r0)     // Catch:{ RejectedExecutionException -> 0x0094 }
            java.util.concurrent.Executor r0 = (java.util.concurrent.Executor) r0     // Catch:{ RejectedExecutionException -> 0x0094 }
            androidx.core.util.Pair<java.util.concurrent.Executor, java.lang.Runnable> r2 = r6.mFinalCloseAction     // Catch:{ RejectedExecutionException -> 0x0094 }
            S r2 = r2.second     // Catch:{ RejectedExecutionException -> 0x0094 }
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ RejectedExecutionException -> 0x0094 }
            java.lang.Object r2 = androidx.core.util.Preconditions.checkNotNull(r2)     // Catch:{ RejectedExecutionException -> 0x0094 }
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ RejectedExecutionException -> 0x0094 }
            r0.execute(r2)     // Catch:{ RejectedExecutionException -> 0x0094 }
            goto L_0x00b3
        L_0x0094:
            r0 = move-exception
            java.lang.String r2 = "SharedByteBuffer"
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r3 = r6.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Unable to execute final close action. ["
            r4.<init>(r5)
            r4.append(r3)
            java.lang.String r3 = "]"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            androidx.camera.core.Logger.e(r2, r3, r0)
        L_0x00b3:
            return r1
        L_0x00b4:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.SharedByteBuffer.closeInternal():boolean");
    }

    @NonNull
    public static SharedByteBuffer newSharedInstance(@NonNull ByteBuffer byteBuffer, @NonNull Executor executor, @NonNull Runnable runnable) {
        return new SharedByteBuffer(((ByteBuffer) Preconditions.checkNotNull(byteBuffer)).asReadOnlyBuffer(), new AtomicInteger(1), new Pair((Executor) Preconditions.checkNotNull(executor), (Runnable) Preconditions.checkNotNull(runnable)), System.identityHashCode(byteBuffer));
    }

    public void close() {
        closeInternal();
    }

    public void finalize() throws Throwable {
        try {
            if (closeInternal()) {
                Locale locale = Locale.US;
                String sharedByteBuffer = toString();
                Logger.w(TAG, "SharedByteBuffer closed by finalizer, but should have been closed manually with SharedByteBuffer.close() [" + sharedByteBuffer + "]");
            }
        } finally {
            super.finalize();
        }
    }

    @NonNull
    public ByteBuffer get() {
        ByteBuffer byteBuffer;
        synchronized (this.mCloseLock) {
            checkNotClosed("get()");
            byteBuffer = this.mSharedByteBuffer;
        }
        return byteBuffer;
    }

    @NonNull
    public SharedByteBuffer share() {
        int incrementAndGet;
        AtomicInteger atomicInteger;
        synchronized (this.mCloseLock) {
            checkNotClosed("share()");
            incrementAndGet = this.mSharedRefCount.incrementAndGet();
            atomicInteger = this.mSharedRefCount;
        }
        if (Logger.isDebugEnabled(TAG)) {
            if (incrementAndGet > 1) {
                Locale locale = Locale.US;
                String sharedByteBuffer = toString();
                Logger.d(TAG, "Ref count incremented: " + incrementAndGet + " [" + sharedByteBuffer + "]");
            } else {
                throw new AssertionError("Invalid ref count. share() should always produce a ref count of 2 or more.");
            }
        }
        return new SharedByteBuffer(this.mSharedByteBuffer.asReadOnlyBuffer(), atomicInteger, this.mFinalCloseAction, this.mShareId);
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "SharedByteBuffer[buf: %s, shareId: 0x%x, instanceId:0x%x]", new Object[]{this.mSharedByteBuffer, Integer.valueOf(this.mShareId), Integer.valueOf(System.identityHashCode(this))});
    }
}
