package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SurfaceEdge {
    private final Rect mCropRect;
    private final int mFormat;
    private final boolean mHasCameraTransform;
    private boolean mHasConsumer = false;
    private boolean mIsClosed = false;
    private final boolean mMirroring;
    @NonNull
    private final Set<Runnable> mOnInvalidatedListeners = new HashSet();
    @Nullable
    private SurfaceRequest mProviderSurfaceRequest;
    private int mRotationDegrees;
    private final Matrix mSensorToBufferTransform;
    @NonNull
    private SettableSurface mSettableSurface;
    private final StreamSpec mStreamSpec;
    private int mTargetRotation;
    private final int mTargets;
    private final List<Consumer<SurfaceRequest.TransformationInfo>> mTransformationUpdatesListeners = new ArrayList();

    public static class SettableSurface extends DeferrableSurface {
        CallbackToFutureAdapter.Completer<Surface> mCompleter;
        @Nullable
        private SurfaceOutputImpl mConsumer;
        private DeferrableSurface mProvider;
        final ListenableFuture<Surface> mSurfaceFuture = CallbackToFutureAdapter.getFuture(new d(this, 0));

        public SettableSurface(@NonNull Size size, int i) {
            super(size, i);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$close$1() {
            SurfaceOutputImpl surfaceOutputImpl = this.mConsumer;
            if (surfaceOutputImpl != null) {
                surfaceOutputImpl.requestClose();
            }
            if (this.mProvider == null) {
                this.mCompleter.setCancelled();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.mCompleter = completer;
            return "SettableFuture hashCode: " + hashCode();
        }

        @MainThread
        public boolean canSetProvider() {
            Threads.checkMainThread();
            if (this.mProvider != null || isClosed()) {
                return false;
            }
            return true;
        }

        public void close() {
            super.close();
            Threads.runOnMain(new c(this, 2));
        }

        @VisibleForTesting
        public boolean hasProvider() {
            if (this.mProvider != null) {
                return true;
            }
            return false;
        }

        @NonNull
        public ListenableFuture<Surface> provideSurface() {
            return this.mSurfaceFuture;
        }

        @MainThread
        public void setConsumer(@NonNull SurfaceOutputImpl surfaceOutputImpl) {
            boolean z;
            if (this.mConsumer == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Consumer can only be linked once.");
            this.mConsumer = surfaceOutputImpl;
        }

        @MainThread
        public boolean setProvider(@NonNull DeferrableSurface deferrableSurface, @NonNull Runnable runnable) throws DeferrableSurface.SurfaceClosedException {
            boolean z;
            Threads.checkMainThread();
            Preconditions.checkNotNull(deferrableSurface);
            DeferrableSurface deferrableSurface2 = this.mProvider;
            boolean z2 = false;
            if (deferrableSurface2 == deferrableSurface) {
                return false;
            }
            if (deferrableSurface2 == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider");
            boolean equals = getPrescribedSize().equals(deferrableSurface.getPrescribedSize());
            Size prescribedSize = getPrescribedSize();
            Size prescribedSize2 = deferrableSurface.getPrescribedSize();
            Preconditions.checkArgument(equals, "The provider's size(" + prescribedSize + ") must match the parent(" + prescribedSize2 + ")");
            if (getPrescribedStreamFormat() == deferrableSurface.getPrescribedStreamFormat()) {
                z2 = true;
            }
            int prescribedStreamFormat = getPrescribedStreamFormat();
            int prescribedStreamFormat2 = deferrableSurface.getPrescribedStreamFormat();
            Preconditions.checkArgument(z2, "The provider's format(" + prescribedStreamFormat + ") must match the parent(" + prescribedStreamFormat2 + ")");
            Preconditions.checkState(isClosed() ^ true, "The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.");
            this.mProvider = deferrableSurface;
            Futures.propagate(deferrableSurface.getSurface(), this.mCompleter);
            deferrableSurface.incrementUseCount();
            getTerminationFuture().addListener(new nf(deferrableSurface, 1), CameraXExecutors.directExecutor());
            deferrableSurface.getCloseFuture().addListener(runnable, CameraXExecutors.mainThreadExecutor());
            return true;
        }
    }

    public SurfaceEdge(int i, int i2, @NonNull StreamSpec streamSpec, @NonNull Matrix matrix, boolean z, @NonNull Rect rect, int i3, int i4, boolean z2) {
        this.mTargets = i;
        this.mFormat = i2;
        this.mStreamSpec = streamSpec;
        this.mSensorToBufferTransform = matrix;
        this.mHasCameraTransform = z;
        this.mCropRect = rect;
        this.mRotationDegrees = i3;
        this.mTargetRotation = i4;
        this.mMirroring = z2;
        this.mSettableSurface = new SettableSurface(streamSpec.getResolution(), i2);
    }

    private void checkAndSetHasConsumer() {
        Preconditions.checkState(!this.mHasConsumer, "Consumer can only be linked once.");
        this.mHasConsumer = true;
    }

    private void checkNotClosed() {
        Preconditions.checkState(!this.mIsClosed, "Edge is already closed.");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ListenableFuture lambda$createSurfaceOutputFuture$2(SettableSurface settableSurface, int i, SurfaceOutput.CameraInputInfo cameraInputInfo, SurfaceOutput.CameraInputInfo cameraInputInfo2, Surface surface) throws Exception {
        Preconditions.checkNotNull(surface);
        try {
            settableSurface.incrementUseCount();
            SurfaceOutputImpl surfaceOutputImpl = new SurfaceOutputImpl(surface, getTargets(), i, this.mStreamSpec.getResolution(), cameraInputInfo, cameraInputInfo2, this.mSensorToBufferTransform);
            surfaceOutputImpl.getCloseFuture().addListener(new c(settableSurface, 1), CameraXExecutors.directExecutor());
            settableSurface.setConsumer(surfaceOutputImpl);
            return Futures.immediateFuture(surfaceOutputImpl);
        } catch (DeferrableSurface.SurfaceClosedException e) {
            return Futures.immediateFailedFuture(e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createSurfaceRequest$0() {
        if (!this.mIsClosed) {
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createSurfaceRequest$1() {
        CameraXExecutors.mainThreadExecutor().execute(new mf(this, 1));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTransformation$3(int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (this.mRotationDegrees != i) {
            this.mRotationDegrees = i;
            z = true;
        } else {
            z = false;
        }
        if (this.mTargetRotation != i2) {
            this.mTargetRotation = i2;
        } else {
            z2 = z;
        }
        if (z2) {
            notifyTransformationInfoUpdate();
        }
    }

    @MainThread
    private void notifyTransformationInfoUpdate() {
        Threads.checkMainThread();
        SurfaceRequest.TransformationInfo of = SurfaceRequest.TransformationInfo.of(this.mCropRect, this.mRotationDegrees, this.mTargetRotation, hasCameraTransform(), this.mSensorToBufferTransform, this.mMirroring);
        SurfaceRequest surfaceRequest = this.mProviderSurfaceRequest;
        if (surfaceRequest != null) {
            surfaceRequest.updateTransformationInfo(of);
        }
        for (Consumer<SurfaceRequest.TransformationInfo> accept : this.mTransformationUpdatesListeners) {
            accept.accept(of);
        }
    }

    @MainThread
    public void addOnInvalidatedListener(@NonNull Runnable runnable) {
        Threads.checkMainThread();
        checkNotClosed();
        this.mOnInvalidatedListeners.add(runnable);
    }

    public void addTransformationUpdateListener(@NonNull Consumer<SurfaceRequest.TransformationInfo> consumer) {
        Preconditions.checkNotNull(consumer);
        this.mTransformationUpdatesListeners.add(consumer);
    }

    @MainThread
    public final void close() {
        Threads.checkMainThread();
        this.mSettableSurface.close();
        this.mIsClosed = true;
    }

    @MainThread
    @NonNull
    public ListenableFuture<SurfaceOutput> createSurfaceOutputFuture(int i, @NonNull SurfaceOutput.CameraInputInfo cameraInputInfo, @Nullable SurfaceOutput.CameraInputInfo cameraInputInfo2) {
        Threads.checkMainThread();
        checkNotClosed();
        checkAndSetHasConsumer();
        SettableSurface settableSurface = this.mSettableSurface;
        return Futures.transformAsync(settableSurface.getSurface(), new b(this, settableSurface, i, cameraInputInfo, cameraInputInfo2), CameraXExecutors.mainThreadExecutor());
    }

    @MainThread
    @NonNull
    public SurfaceRequest createSurfaceRequest(@NonNull CameraInternal cameraInternal) {
        return createSurfaceRequest(cameraInternal, true);
    }

    @MainThread
    public final void disconnect() {
        Threads.checkMainThread();
        checkNotClosed();
        this.mSettableSurface.close();
    }

    @NonNull
    public Rect getCropRect() {
        return this.mCropRect;
    }

    @MainThread
    @NonNull
    public DeferrableSurface getDeferrableSurface() {
        Threads.checkMainThread();
        checkNotClosed();
        checkAndSetHasConsumer();
        return this.mSettableSurface;
    }

    @VisibleForTesting
    @NonNull
    public DeferrableSurface getDeferrableSurfaceForTesting() {
        return this.mSettableSurface;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    @NonNull
    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    @NonNull
    public StreamSpec getStreamSpec() {
        return this.mStreamSpec;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public boolean hasCameraTransform() {
        return this.mHasCameraTransform;
    }

    @VisibleForTesting
    public boolean hasProvider() {
        return this.mSettableSurface.hasProvider();
    }

    @MainThread
    public void invalidate() {
        Threads.checkMainThread();
        checkNotClosed();
        if (!this.mSettableSurface.canSetProvider()) {
            this.mHasConsumer = false;
            this.mSettableSurface.close();
            this.mSettableSurface = new SettableSurface(this.mStreamSpec.getResolution(), this.mFormat);
            for (Runnable run : this.mOnInvalidatedListeners) {
                run.run();
            }
        }
    }

    @VisibleForTesting
    public boolean isClosed() {
        return this.mIsClosed;
    }

    public boolean isMirroring() {
        return this.mMirroring;
    }

    public void removeTransformationUpdateListener(@NonNull Consumer<SurfaceRequest.TransformationInfo> consumer) {
        Preconditions.checkNotNull(consumer);
        this.mTransformationUpdatesListeners.remove(consumer);
    }

    @MainThread
    public void setProvider(@NonNull DeferrableSurface deferrableSurface) throws DeferrableSurface.SurfaceClosedException {
        Threads.checkMainThread();
        checkNotClosed();
        SettableSurface settableSurface = this.mSettableSurface;
        Objects.requireNonNull(settableSurface);
        settableSurface.setProvider(deferrableSurface, new c(settableSurface, 0));
    }

    public void updateTransformation(int i) {
        updateTransformation(i, -1);
    }

    @MainThread
    @NonNull
    public SurfaceRequest createSurfaceRequest(@NonNull CameraInternal cameraInternal, boolean z) {
        Threads.checkMainThread();
        checkNotClosed();
        SurfaceRequest surfaceRequest = new SurfaceRequest(this.mStreamSpec.getResolution(), cameraInternal, z, this.mStreamSpec.getDynamicRange(), this.mStreamSpec.getExpectedFrameRateRange(), new mf(this, 0));
        try {
            DeferrableSurface deferrableSurface = surfaceRequest.getDeferrableSurface();
            SettableSurface settableSurface = this.mSettableSurface;
            Objects.requireNonNull(settableSurface);
            if (settableSurface.setProvider(deferrableSurface, new c(settableSurface, 0))) {
                ListenableFuture<Void> terminationFuture = settableSurface.getTerminationFuture();
                Objects.requireNonNull(deferrableSurface);
                terminationFuture.addListener(new nf(deferrableSurface, 0), CameraXExecutors.directExecutor());
            }
            this.mProviderSurfaceRequest = surfaceRequest;
            notifyTransformationInfoUpdate();
            return surfaceRequest;
        } catch (DeferrableSurface.SurfaceClosedException e) {
            throw new AssertionError("Surface is somehow already closed", e);
        } catch (RuntimeException e2) {
            surfaceRequest.willNotProvideSurface();
            throw e2;
        }
    }

    public void updateTransformation(int i, int i2) {
        Threads.runOnMain(new of(this, i, i2));
    }
}
