package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.StringUtils;

public abstract class DeferrableSurface {
    private static final boolean DEBUG = Logger.isDebugEnabled(TAG);
    public static final Size SIZE_UNDEFINED = new Size(0, 0);
    private static final String TAG = "DeferrableSurface";
    private static final AtomicInteger TOTAL_COUNT = new AtomicInteger(0);
    private static final AtomicInteger USED_COUNT = new AtomicInteger(0);
    @GuardedBy("mLock")
    private CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    private final ListenableFuture<Void> mCloseFuture;
    @GuardedBy("mLock")
    private boolean mClosed;
    @Nullable
    Class<?> mContainerClass;
    private final Object mLock;
    @NonNull
    private final Size mPrescribedSize;
    private final int mPrescribedStreamFormat;
    @GuardedBy("mLock")
    private CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private final ListenableFuture<Void> mTerminationFuture;
    @GuardedBy("mLock")
    private int mUseCount;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SurfaceClosedException extends Exception {
        DeferrableSurface mDeferrableSurface;

        public SurfaceClosedException(@NonNull String str, @NonNull DeferrableSurface deferrableSurface) {
            super(str);
            this.mDeferrableSurface = deferrableSurface;
        }

        @NonNull
        public DeferrableSurface getDeferrableSurface() {
            return this.mDeferrableSurface;
        }
    }

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(@NonNull String str) {
            super(str);
        }
    }

    public DeferrableSurface() {
        this(SIZE_UNDEFINED, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mTerminationCompleter = completer;
        }
        return "DeferrableSurface-termination(" + this + ")";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$new$1(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mCloseCompleter = completer;
        }
        return "DeferrableSurface-close(" + this + ")";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(String str) {
        try {
            this.mTerminationFuture.get();
            printGlobalDebugCounts("Surface terminated", TOTAL_COUNT.decrementAndGet(), USED_COUNT.get());
        } catch (Exception e) {
            Logger.e(TAG, "Unexpected surface termination for " + this + "\nStack Trace:\n" + str);
            synchronized (this.mLock) {
                throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", new Object[]{this, Boolean.valueOf(this.mClosed), Integer.valueOf(this.mUseCount)}), e);
            }
        }
    }

    private void printGlobalDebugCounts(@NonNull String str, int i, int i2) {
        if (!DEBUG && Logger.isDebugEnabled(TAG)) {
            Logger.d(TAG, "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        Logger.d(TAG, str + "[total_surfaces=" + i + ", used_surfaces=" + i2 + "](" + this + "}");
    }

    public void close() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            try {
                if (!this.mClosed) {
                    this.mClosed = true;
                    this.mCloseCompleter.set(null);
                    if (this.mUseCount == 0) {
                        completer = this.mTerminationCompleter;
                        this.mTerminationCompleter = null;
                    } else {
                        completer = null;
                    }
                    if (Logger.isDebugEnabled(TAG)) {
                        Logger.d(TAG, "surface closed,  useCount=" + this.mUseCount + " closed=true " + this);
                    }
                } else {
                    completer = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    public void decrementUseCount() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            try {
                int i = this.mUseCount;
                if (i != 0) {
                    int i2 = i - 1;
                    this.mUseCount = i2;
                    if (i2 != 0 || !this.mClosed) {
                        completer = null;
                    } else {
                        completer = this.mTerminationCompleter;
                        this.mTerminationCompleter = null;
                    }
                    if (Logger.isDebugEnabled(TAG)) {
                        Logger.d(TAG, "use count-1,  useCount=" + this.mUseCount + " closed=" + this.mClosed + StringUtils.SPACE + this);
                        if (this.mUseCount == 0) {
                            printGlobalDebugCounts("Surface no longer in use", TOTAL_COUNT.get(), USED_COUNT.decrementAndGet());
                        }
                    }
                } else {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (completer != null) {
            completer.set(null);
        }
    }

    @NonNull
    public ListenableFuture<Void> getCloseFuture() {
        return Futures.nonCancellationPropagating(this.mCloseFuture);
    }

    @Nullable
    public Class<?> getContainerClass() {
        return this.mContainerClass;
    }

    @NonNull
    public Size getPrescribedSize() {
        return this.mPrescribedSize;
    }

    public int getPrescribedStreamFormat() {
        return this.mPrescribedStreamFormat;
    }

    @NonNull
    public final ListenableFuture<Surface> getSurface() {
        synchronized (this.mLock) {
            try {
                if (this.mClosed) {
                    ListenableFuture<Surface> immediateFailedFuture = Futures.immediateFailedFuture(new SurfaceClosedException("DeferrableSurface already closed.", this));
                    return immediateFailedFuture;
                }
                ListenableFuture<Surface> provideSurface = provideSurface();
                return provideSurface;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public ListenableFuture<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    @VisibleForTesting
    public int getUseCount() {
        int i;
        synchronized (this.mLock) {
            i = this.mUseCount;
        }
        return i;
    }

    public void incrementUseCount() throws SurfaceClosedException {
        synchronized (this.mLock) {
            try {
                int i = this.mUseCount;
                if (i == 0) {
                    if (this.mClosed) {
                        throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
                    }
                }
                this.mUseCount = i + 1;
                if (Logger.isDebugEnabled(TAG)) {
                    if (this.mUseCount == 1) {
                        printGlobalDebugCounts("New surface in use", TOTAL_COUNT.get(), USED_COUNT.incrementAndGet());
                    }
                    Logger.d(TAG, "use count+1, useCount=" + this.mUseCount + StringUtils.SPACE + this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mClosed;
        }
        return z;
    }

    @NonNull
    public abstract ListenableFuture<Surface> provideSurface();

    public void setContainerClass(@NonNull Class<?> cls) {
        this.mContainerClass = cls;
    }

    public DeferrableSurface(@NonNull Size size, int i) {
        this.mLock = new Object();
        this.mUseCount = 0;
        this.mClosed = false;
        this.mPrescribedSize = size;
        this.mPrescribedStreamFormat = i;
        ListenableFuture<Void> future = CallbackToFutureAdapter.getFuture(new i5(this, 0));
        this.mTerminationFuture = future;
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new i5(this, 1));
        if (Logger.isDebugEnabled(TAG)) {
            printGlobalDebugCounts("Surface created", TOTAL_COUNT.incrementAndGet(), USED_COUNT.get());
            future.addListener(new e0(19, this, Log.getStackTraceString(new Exception())), CameraXExecutors.directExecutor());
        }
    }
}
