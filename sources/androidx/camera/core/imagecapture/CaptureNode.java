package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Node;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import java.util.Objects;

class CaptureNode implements Node<In, ProcessingNode.In> {
    @VisibleForTesting
    static final int MAX_IMAGES = 4;
    private static final String TAG = "CaptureNode";
    ProcessingRequest mCurrentRequest = null;
    @Nullable
    private In mInputEdge;
    /* access modifiers changed from: private */
    @Nullable
    public NoMetadataImageReader mNoMetadataImageReader = null;
    @Nullable
    private ProcessingNode.In mOutputEdge;
    @Nullable
    SafeCloseImageReaderProxy mSafeCloseImageReaderForPostview;
    @Nullable
    SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;

    @AutoValue
    public static abstract class In {
        @NonNull
        private CameraCaptureCallback mCameraCaptureCallback = new CameraCaptureCallback() {
        };
        @Nullable
        private DeferrableSurface mPostviewSurface = null;
        @Nullable
        private DeferrableSurface mSurface;

        @NonNull
        public static In of(Size size, int i, int i2, boolean z, @Nullable ImageReaderProxyProvider imageReaderProxyProvider) {
            return new AutoValue_CaptureNode_In(size, i, i2, z, imageReaderProxyProvider, (Size) null, 35, new Edge(), new Edge());
        }

        @NonNull
        public CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        @NonNull
        public abstract Edge<TakePictureManager.CaptureError> getErrorEdge();

        @Nullable
        public abstract ImageReaderProxyProvider getImageReaderProxyProvider();

        public abstract int getInputFormat();

        public abstract int getOutputFormat();

        public abstract int getPostviewImageFormat();

        @Nullable
        public abstract Size getPostviewSize();

        @Nullable
        public DeferrableSurface getPostviewSurface() {
            return this.mPostviewSurface;
        }

        @NonNull
        public abstract Edge<ProcessingRequest> getRequestEdge();

        public abstract Size getSize();

        @NonNull
        public DeferrableSurface getSurface() {
            DeferrableSurface deferrableSurface = this.mSurface;
            Objects.requireNonNull(deferrableSurface);
            return deferrableSurface;
        }

        public abstract boolean isVirtualCamera();

        public void setCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCameraCaptureCallback = cameraCaptureCallback;
        }

        public void setPostviewSurface(@NonNull Surface surface, @NonNull Size size, int i) {
            this.mPostviewSurface = new ImmediateSurface(surface, size, i);
        }

        public void setSurface(@NonNull Surface surface) {
            boolean z;
            if (this.mSurface == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "The surface is already set.");
            this.mSurface = new ImmediateSurface(surface, getSize(), getInputFormat());
        }

        @NonNull
        public static In of(Size size, int i, int i2, boolean z, @Nullable ImageReaderProxyProvider imageReaderProxyProvider, @Nullable Size size2, int i3) {
            return new AutoValue_CaptureNode_In(size, i, i2, z, imageReaderProxyProvider, size2, i3, new Edge(), new Edge());
        }
    }

    @NonNull
    private static ImageReaderProxy createImageReaderProxy(@Nullable ImageReaderProxyProvider imageReaderProxyProvider, int i, int i2, int i3) {
        if (imageReaderProxyProvider != null) {
            return imageReaderProxyProvider.newInstance(i, i2, i3, 4, 0);
        }
        return ImageReaderProxys.createIsolatedReader(i, i2, i3, 4);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$releaseInputResources$4(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        if (safeCloseImageReaderProxy != null) {
            safeCloseImageReaderProxy.safeClose();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$0(ProcessingRequest processingRequest) {
        onRequestAvailable(processingRequest);
        this.mNoMetadataImageReader.acceptProcessingRequest(processingRequest);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$1(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage != null) {
                onImageProxyAvailable(acquireLatestImage);
                return;
            }
            ProcessingRequest processingRequest = this.mCurrentRequest;
            if (processingRequest != null) {
                sendCaptureError(TakePictureManager.CaptureError.of(processingRequest.getRequestId(), new ImageCaptureException(2, "Failed to acquire latest image", (Throwable) null)));
            }
        } catch (IllegalStateException e) {
            ProcessingRequest processingRequest2 = this.mCurrentRequest;
            if (processingRequest2 != null) {
                sendCaptureError(TakePictureManager.CaptureError.of(processingRequest2.getRequestId(), new ImageCaptureException(2, "Failed to acquire latest image", e)));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$2(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage != null) {
                propagatePostviewImage(acquireLatestImage);
            }
        } catch (IllegalStateException e) {
            Logger.e(TAG, "Failed to acquire latest image of postview", e);
        }
    }

    @MainThread
    private void matchAndPropagateImage(@NonNull ImageProxy imageProxy) {
        Threads.checkMainThread();
        ProcessingNode.In in = this.mOutputEdge;
        Objects.requireNonNull(in);
        in.getEdge().accept(ProcessingNode.InputPacket.of(this.mCurrentRequest, imageProxy));
        ProcessingRequest processingRequest = this.mCurrentRequest;
        this.mCurrentRequest = null;
        processingRequest.onImageCaptured();
    }

    private void propagatePostviewImage(@NonNull ImageProxy imageProxy) {
        if (this.mCurrentRequest == null) {
            Logger.w(TAG, "Postview image is closed due to request completed or aborted");
            imageProxy.close();
            return;
        }
        ProcessingNode.In in = this.mOutputEdge;
        Objects.requireNonNull(in);
        in.getPostviewEdge().accept(ProcessingNode.InputPacket.of(this.mCurrentRequest, imageProxy));
    }

    private void releaseInputResources(@NonNull In in, @NonNull SafeCloseImageReaderProxy safeCloseImageReaderProxy, @Nullable SafeCloseImageReaderProxy safeCloseImageReaderProxy2) {
        in.getSurface().close();
        in.getSurface().getTerminationFuture().addListener(new c(safeCloseImageReaderProxy, 0), CameraXExecutors.mainThreadExecutor());
        if (in.getPostviewSurface() != null) {
            in.getPostviewSurface().close();
            in.getPostviewSurface().getTerminationFuture().addListener(new c(safeCloseImageReaderProxy2, 1), CameraXExecutors.mainThreadExecutor());
        }
    }

    @MainThread
    public int getCapacity() {
        boolean z;
        Threads.checkMainThread();
        if (this.mSafeCloseImageReaderProxy != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    }

    @VisibleForTesting
    @NonNull
    public In getInputEdge() {
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        return in;
    }

    @VisibleForTesting
    @NonNull
    public SafeCloseImageReaderProxy getSafeCloseImageReaderProxy() {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        return safeCloseImageReaderProxy;
    }

    @VisibleForTesting
    @MainThread
    public void onImageProxyAvailable(@NonNull ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (this.mCurrentRequest == null) {
            Logger.w(TAG, "Discarding ImageProxy which was inadvertently acquired: " + imageProxy);
            imageProxy.close();
        } else if (((Integer) imageProxy.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey())) == null) {
            Logger.w(TAG, "Discarding ImageProxy which was acquired for aborted request");
            imageProxy.close();
        } else {
            matchAndPropagateImage(imageProxy);
        }
    }

    @VisibleForTesting
    @MainThread
    public void onRequestAvailable(@NonNull final ProcessingRequest processingRequest) {
        boolean z;
        Threads.checkMainThread();
        boolean z2 = false;
        if (processingRequest.getStageIds().size() == 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "only one capture stage is supported.");
        if (getCapacity() > 0) {
            z2 = true;
        }
        Preconditions.checkState(z2, "Too many acquire images. Close image to be able to process next.");
        this.mCurrentRequest = processingRequest;
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() {
            public void onFailure(@NonNull Throwable th) {
                Threads.checkMainThread();
                if (processingRequest == CaptureNode.this.mCurrentRequest) {
                    Logger.w(CaptureNode.TAG, "request aborted, id=" + CaptureNode.this.mCurrentRequest.getRequestId());
                    if (CaptureNode.this.mNoMetadataImageReader != null) {
                        CaptureNode.this.mNoMetadataImageReader.clearProcessingRequest();
                    }
                    CaptureNode.this.mCurrentRequest = null;
                }
            }

            public void onSuccess(@Nullable Void voidR) {
            }
        }, CameraXExecutors.directExecutor());
    }

    @MainThread
    public void release() {
        Threads.checkMainThread();
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        releaseInputResources(in, safeCloseImageReaderProxy, this.mSafeCloseImageReaderForPostview);
    }

    @MainThread
    public void sendCaptureError(@NonNull TakePictureManager.CaptureError captureError) {
        Threads.checkMainThread();
        ProcessingRequest processingRequest = this.mCurrentRequest;
        if (processingRequest != null && processingRequest.getRequestId() == captureError.getRequestId()) {
            this.mCurrentRequest.onCaptureFailure(captureError.getImageCaptureException());
        }
    }

    @MainThread
    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        boolean z;
        Threads.checkMainThread();
        if (this.mSafeCloseImageReaderProxy != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(onImageCloseListener);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: androidx.camera.core.imagecapture.NoMetadataImageReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: androidx.camera.core.MetadataImageReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: androidx.camera.core.imagecapture.NoMetadataImageReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: androidx.camera.core.imagecapture.NoMetadataImageReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.imagecapture.ProcessingNode.In transform(@androidx.annotation.NonNull androidx.camera.core.imagecapture.CaptureNode.In r10) {
        /*
            r9 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            androidx.camera.core.imagecapture.CaptureNode$In r3 = r9.mInputEdge
            if (r3 != 0) goto L_0x000d
            androidx.camera.core.SafeCloseImageReaderProxy r3 = r9.mSafeCloseImageReaderProxy
            if (r3 != 0) goto L_0x000d
            r3 = 1
            goto L_0x000e
        L_0x000d:
            r3 = 0
        L_0x000e:
            java.lang.String r4 = "CaptureNode does not support recreation yet."
            androidx.core.util.Preconditions.checkState(r3, r4)
            r9.mInputEdge = r10
            android.util.Size r3 = r10.getSize()
            int r4 = r10.getInputFormat()
            boolean r5 = r10.isVirtualCamera()
            androidx.camera.core.imagecapture.CaptureNode$1 r6 = new androidx.camera.core.imagecapture.CaptureNode$1
            r6.<init>()
            if (r5 != 0) goto L_0x0050
            androidx.camera.core.ImageReaderProxyProvider r5 = r10.getImageReaderProxyProvider()
            if (r5 != 0) goto L_0x0050
            androidx.camera.core.MetadataImageReader r5 = new androidx.camera.core.MetadataImageReader
            int r7 = r3.getWidth()
            int r3 = r3.getHeight()
            r8 = 4
            r5.<init>(r7, r3, r4, r8)
            androidx.camera.core.impl.CameraCaptureCallback r3 = r5.getCameraCaptureCallback()
            androidx.camera.core.impl.CameraCaptureCallback[] r4 = new androidx.camera.core.impl.CameraCaptureCallback[r0]
            r4[r1] = r6
            r4[r2] = r3
            androidx.camera.core.impl.CameraCaptureCallback r6 = androidx.camera.core.impl.CameraCaptureCallbacks.createComboCallback((androidx.camera.core.impl.CameraCaptureCallback[]) r4)
            androidx.camera.core.imagecapture.a r3 = new androidx.camera.core.imagecapture.a
            r3.<init>(r9, r1)
            goto L_0x006c
        L_0x0050:
            androidx.camera.core.imagecapture.NoMetadataImageReader r5 = new androidx.camera.core.imagecapture.NoMetadataImageReader
            androidx.camera.core.ImageReaderProxyProvider r7 = r10.getImageReaderProxyProvider()
            int r8 = r3.getWidth()
            int r3 = r3.getHeight()
            androidx.camera.core.impl.ImageReaderProxy r3 = createImageReaderProxy(r7, r8, r3, r4)
            r5.<init>(r3)
            r9.mNoMetadataImageReader = r5
            androidx.camera.core.imagecapture.a r3 = new androidx.camera.core.imagecapture.a
            r3.<init>(r9, r2)
        L_0x006c:
            r10.setCameraCaptureCallback(r6)
            android.view.Surface r4 = r5.getSurface()
            java.util.Objects.requireNonNull(r4)
            r10.setSurface(r4)
            androidx.camera.core.SafeCloseImageReaderProxy r4 = new androidx.camera.core.SafeCloseImageReaderProxy
            r4.<init>(r5)
            r9.mSafeCloseImageReaderProxy = r4
            androidx.camera.core.imagecapture.b r4 = new androidx.camera.core.imagecapture.b
            r4.<init>(r9, r1)
            java.util.concurrent.ScheduledExecutorService r1 = androidx.camera.core.impl.utils.executor.CameraXExecutors.mainThreadExecutor()
            r5.setOnImageAvailableListener(r4, r1)
            android.util.Size r1 = r10.getPostviewSize()
            if (r1 == 0) goto L_0x00d0
            androidx.camera.core.ImageReaderProxyProvider r1 = r10.getImageReaderProxyProvider()
            android.util.Size r4 = r10.getPostviewSize()
            int r4 = r4.getWidth()
            android.util.Size r5 = r10.getPostviewSize()
            int r5 = r5.getHeight()
            int r6 = r10.getPostviewImageFormat()
            androidx.camera.core.impl.ImageReaderProxy r1 = createImageReaderProxy(r1, r4, r5, r6)
            androidx.camera.core.imagecapture.b r4 = new androidx.camera.core.imagecapture.b
            r4.<init>(r9, r2)
            java.util.concurrent.ScheduledExecutorService r2 = androidx.camera.core.impl.utils.executor.CameraXExecutors.mainThreadExecutor()
            r1.setOnImageAvailableListener(r4, r2)
            androidx.camera.core.SafeCloseImageReaderProxy r2 = new androidx.camera.core.SafeCloseImageReaderProxy
            r2.<init>(r1)
            r9.mSafeCloseImageReaderForPostview = r2
            android.view.Surface r1 = r1.getSurface()
            android.util.Size r2 = r10.getPostviewSize()
            int r4 = r10.getPostviewImageFormat()
            r10.setPostviewSurface(r1, r2, r4)
        L_0x00d0:
            androidx.camera.core.processing.Edge r1 = r10.getRequestEdge()
            r1.setListener(r3)
            androidx.camera.core.processing.Edge r1 = r10.getErrorEdge()
            androidx.camera.core.imagecapture.a r2 = new androidx.camera.core.imagecapture.a
            r2.<init>(r9, r0)
            r1.setListener(r2)
            int r0 = r10.getInputFormat()
            int r10 = r10.getOutputFormat()
            androidx.camera.core.imagecapture.ProcessingNode$In r10 = androidx.camera.core.imagecapture.ProcessingNode.In.of(r0, r10)
            r9.mOutputEdge = r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.imagecapture.CaptureNode.transform(androidx.camera.core.imagecapture.CaptureNode$In):androidx.camera.core.imagecapture.ProcessingNode$In");
    }
}
