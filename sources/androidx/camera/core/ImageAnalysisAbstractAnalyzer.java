package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";
    private final Object mAnalyzerLock = new Object();
    protected boolean mIsAttached = true;
    private volatile boolean mOnePixelShiftEnabled;
    @GuardedBy("mAnalyzerLock")
    private Matrix mOriginalSensorToBufferTransformMatrix = new Matrix();
    @GuardedBy("mAnalyzerLock")
    private Rect mOriginalViewPortCropRect = new Rect();
    private volatile int mOutputImageFormat = 1;
    private volatile boolean mOutputImageRotationEnabled;
    @IntRange(from = 0, to = 359)
    private volatile int mPrevBufferRotationDegrees;
    @GuardedBy("mAnalyzerLock")
    @Nullable
    private SafeCloseImageReaderProxy mProcessedImageReaderProxy;
    @GuardedBy("mAnalyzerLock")
    @Nullable
    private ImageWriter mProcessedImageWriter;
    @VisibleForTesting
    @GuardedBy("mAnalyzerLock")
    @Nullable
    ByteBuffer mRGBConvertedBuffer;
    @IntRange(from = 0, to = 359)
    private volatile int mRelativeRotation;
    @GuardedBy("mAnalyzerLock")
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;
    @VisibleForTesting
    @GuardedBy("mAnalyzerLock")
    @Nullable
    ByteBuffer mURotatedBuffer;
    @GuardedBy("mAnalyzerLock")
    private Matrix mUpdatedSensorToBufferTransformMatrix = new Matrix();
    @GuardedBy("mAnalyzerLock")
    private Rect mUpdatedViewPortCropRect = new Rect();
    @GuardedBy("mAnalyzerLock")
    private Executor mUserExecutor;
    @VisibleForTesting
    @GuardedBy("mAnalyzerLock")
    @Nullable
    ByteBuffer mVRotatedBuffer;
    @VisibleForTesting
    @GuardedBy("mAnalyzerLock")
    @Nullable
    ByteBuffer mYRotatedBuffer;

    @GuardedBy("mAnalyzerLock")
    private void createHelperBuffer(@NonNull ImageProxy imageProxy) {
        if (this.mOutputImageFormat == 1) {
            if (this.mYRotatedBuffer == null) {
                this.mYRotatedBuffer = ByteBuffer.allocateDirect(imageProxy.getHeight() * imageProxy.getWidth());
            }
            this.mYRotatedBuffer.position(0);
            if (this.mURotatedBuffer == null) {
                this.mURotatedBuffer = ByteBuffer.allocateDirect((imageProxy.getHeight() * imageProxy.getWidth()) / 4);
            }
            this.mURotatedBuffer.position(0);
            if (this.mVRotatedBuffer == null) {
                this.mVRotatedBuffer = ByteBuffer.allocateDirect((imageProxy.getHeight() * imageProxy.getWidth()) / 4);
            }
            this.mVRotatedBuffer.position(0);
        } else if (this.mOutputImageFormat == 2 && this.mRGBConvertedBuffer == null) {
            this.mRGBConvertedBuffer = ByteBuffer.allocateDirect(imageProxy.getHeight() * imageProxy.getWidth() * 4);
        }
    }

    @NonNull
    private static SafeCloseImageReaderProxy createImageReaderProxy(int i, int i2, int i3, int i4, int i5) {
        boolean z;
        int i6;
        if (i3 == 90 || i3 == 270) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i6 = i2;
        } else {
            i6 = i;
        }
        if (!z) {
            i = i2;
        }
        return new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(i6, i, i4, i5));
    }

    @VisibleForTesting
    @NonNull
    public static Matrix getAdditionalTransformMatrixAppliedByProcessor(int i, int i2, int i3, int i4, @IntRange(from = 0, to = 359) int i5) {
        Matrix matrix = new Matrix();
        if (i5 > 0) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, (float) i, (float) i2), TransformUtils.NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
            matrix.postRotate((float) i5);
            matrix.postConcat(TransformUtils.getNormalizedToBuffer(new RectF(0.0f, 0.0f, (float) i3, (float) i4)));
        }
        return matrix;
    }

    @NonNull
    public static Rect getUpdatedCropRect(@NonNull Rect rect, @NonNull Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$analyzeImage$0(ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        int i;
        if (this.mIsAttached) {
            TagBundle tagBundle = imageProxy.getImageInfo().getTagBundle();
            long timestamp = imageProxy.getImageInfo().getTimestamp();
            if (this.mOutputImageRotationEnabled) {
                i = 0;
            } else {
                i = this.mRelativeRotation;
            }
            SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy2, ImmutableImageInfo.create(tagBundle, timestamp, i, matrix));
            if (!rect.isEmpty()) {
                settableImageProxy.setCropRect(rect);
            }
            analyzer.analyze(settableImageProxy);
            completer.set(null);
            return;
        }
        completer.setException(new OperationCanceledException("ImageAnalysis is detached"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$analyzeImage$1(Executor executor, ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) throws Exception {
        Executor executor2 = executor;
        executor.execute(new c(this, imageProxy, matrix, imageProxy2, rect, analyzer, completer));
        return "analyzeImage";
    }

    @GuardedBy("mAnalyzerLock")
    private void recalculateTransformMatrixAndCropRect(int i, int i2, int i3, int i4) {
        Matrix additionalTransformMatrixAppliedByProcessor = getAdditionalTransformMatrixAppliedByProcessor(i, i2, i3, i4, this.mRelativeRotation);
        this.mUpdatedViewPortCropRect = getUpdatedCropRect(this.mOriginalViewPortCropRect, additionalTransformMatrixAppliedByProcessor);
        this.mUpdatedSensorToBufferTransformMatrix.setConcat(this.mOriginalSensorToBufferTransformMatrix, additionalTransformMatrixAppliedByProcessor);
    }

    @GuardedBy("mAnalyzerLock")
    private void recreateImageReaderProxy(@NonNull ImageProxy imageProxy, @IntRange(from = 0, to = 359) int i) {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mProcessedImageReaderProxy;
        if (safeCloseImageReaderProxy != null) {
            safeCloseImageReaderProxy.safeClose();
            this.mProcessedImageReaderProxy = createImageReaderProxy(imageProxy.getWidth(), imageProxy.getHeight(), i, this.mProcessedImageReaderProxy.getImageFormat(), this.mProcessedImageReaderProxy.getMaxImages());
            if (Build.VERSION.SDK_INT >= 23 && this.mOutputImageFormat == 1) {
                ImageWriter imageWriter = this.mProcessedImageWriter;
                if (imageWriter != null) {
                    ImageWriterCompat.close(imageWriter);
                }
                this.mProcessedImageWriter = ImageWriterCompat.newInstance(this.mProcessedImageReaderProxy.getSurface(), this.mProcessedImageReaderProxy.getMaxImages());
            }
        }
    }

    @Nullable
    public abstract ImageProxy acquireImage(@NonNull ImageReaderProxy imageReaderProxy);

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0073  */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> analyzeImage(@androidx.annotation.NonNull androidx.camera.core.ImageProxy r15) {
        /*
            r14 = this;
            boolean r0 = r14.mOutputImageRotationEnabled
            r1 = 0
            if (r0 == 0) goto L_0x0008
            int r0 = r14.mRelativeRotation
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            java.lang.Object r2 = r14.mAnalyzerLock
            monitor-enter(r2)
            java.util.concurrent.Executor r9 = r14.mUserExecutor     // Catch:{ all -> 0x001b }
            androidx.camera.core.ImageAnalysis$Analyzer r10 = r14.mSubscribedAnalyzer     // Catch:{ all -> 0x001b }
            boolean r3 = r14.mOutputImageRotationEnabled     // Catch:{ all -> 0x001b }
            r11 = 1
            if (r3 == 0) goto L_0x001e
            int r3 = r14.mPrevBufferRotationDegrees     // Catch:{ all -> 0x001b }
            if (r0 == r3) goto L_0x001e
            r12 = 1
            goto L_0x001f
        L_0x001b:
            r15 = move-exception
            goto L_0x00c5
        L_0x001e:
            r12 = 0
        L_0x001f:
            if (r12 == 0) goto L_0x0024
            r14.recreateImageReaderProxy(r15, r0)     // Catch:{ all -> 0x001b }
        L_0x0024:
            boolean r3 = r14.mOutputImageRotationEnabled     // Catch:{ all -> 0x001b }
            if (r3 == 0) goto L_0x002b
            r14.createHelperBuffer(r15)     // Catch:{ all -> 0x001b }
        L_0x002b:
            androidx.camera.core.SafeCloseImageReaderProxy r3 = r14.mProcessedImageReaderProxy     // Catch:{ all -> 0x001b }
            android.media.ImageWriter r4 = r14.mProcessedImageWriter     // Catch:{ all -> 0x001b }
            java.nio.ByteBuffer r5 = r14.mRGBConvertedBuffer     // Catch:{ all -> 0x001b }
            java.nio.ByteBuffer r6 = r14.mYRotatedBuffer     // Catch:{ all -> 0x001b }
            java.nio.ByteBuffer r7 = r14.mURotatedBuffer     // Catch:{ all -> 0x001b }
            java.nio.ByteBuffer r8 = r14.mVRotatedBuffer     // Catch:{ all -> 0x001b }
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            if (r10 == 0) goto L_0x00b9
            if (r9 == 0) goto L_0x00b9
            boolean r2 = r14.mIsAttached
            if (r2 == 0) goto L_0x00b9
            if (r3 == 0) goto L_0x006b
            int r2 = r14.mOutputImageFormat
            r13 = 2
            if (r2 != r13) goto L_0x004e
            boolean r2 = r14.mOnePixelShiftEnabled
            androidx.camera.core.ImageProxy r2 = androidx.camera.core.ImageProcessingUtil.convertYUVToRGB(r15, r3, r5, r0, r2)
            goto L_0x006c
        L_0x004e:
            int r2 = r14.mOutputImageFormat
            if (r2 != r11) goto L_0x006b
            boolean r2 = r14.mOnePixelShiftEnabled
            if (r2 == 0) goto L_0x0059
            androidx.camera.core.ImageProcessingUtil.applyPixelShiftForYUV(r15)
        L_0x0059:
            if (r4 == 0) goto L_0x006b
            if (r6 == 0) goto L_0x006b
            if (r7 == 0) goto L_0x006b
            if (r8 == 0) goto L_0x006b
            r2 = r15
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r0
            androidx.camera.core.ImageProxy r2 = androidx.camera.core.ImageProcessingUtil.rotateYUV(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x006c
        L_0x006b:
            r2 = 0
        L_0x006c:
            if (r2 != 0) goto L_0x006f
            r1 = 1
        L_0x006f:
            if (r1 == 0) goto L_0x0073
            r8 = r15
            goto L_0x0074
        L_0x0073:
            r8 = r2
        L_0x0074:
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.graphics.Matrix r7 = new android.graphics.Matrix
            r7.<init>()
            java.lang.Object r3 = r14.mAnalyzerLock
            monitor-enter(r3)
            if (r12 == 0) goto L_0x009b
            if (r1 != 0) goto L_0x009b
            int r1 = r15.getWidth()     // Catch:{ all -> 0x0099 }
            int r4 = r15.getHeight()     // Catch:{ all -> 0x0099 }
            int r5 = r8.getWidth()     // Catch:{ all -> 0x0099 }
            int r6 = r8.getHeight()     // Catch:{ all -> 0x0099 }
            r14.recalculateTransformMatrixAndCropRect(r1, r4, r5, r6)     // Catch:{ all -> 0x0099 }
            goto L_0x009b
        L_0x0099:
            r15 = move-exception
            goto L_0x00b7
        L_0x009b:
            r14.mPrevBufferRotationDegrees = r0     // Catch:{ all -> 0x0099 }
            android.graphics.Rect r0 = r14.mUpdatedViewPortCropRect     // Catch:{ all -> 0x0099 }
            r2.set(r0)     // Catch:{ all -> 0x0099 }
            android.graphics.Matrix r0 = r14.mUpdatedSensorToBufferTransformMatrix     // Catch:{ all -> 0x0099 }
            r7.set(r0)     // Catch:{ all -> 0x0099 }
            monitor-exit(r3)     // Catch:{ all -> 0x0099 }
            androidx.camera.core.d r0 = new androidx.camera.core.d
            r3 = r0
            r4 = r14
            r5 = r9
            r6 = r15
            r9 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            com.google.common.util.concurrent.ListenableFuture r15 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r0)
            goto L_0x00c4
        L_0x00b7:
            monitor-exit(r3)     // Catch:{ all -> 0x0099 }
            throw r15
        L_0x00b9:
            androidx.core.os.OperationCanceledException r15 = new androidx.core.os.OperationCanceledException
            java.lang.String r0 = "No analyzer or executor currently set."
            r15.<init>(r0)
            com.google.common.util.concurrent.ListenableFuture r15 = androidx.camera.core.impl.utils.futures.Futures.immediateFailedFuture(r15)
        L_0x00c4:
            return r15
        L_0x00c5:
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageAnalysisAbstractAnalyzer.analyzeImage(androidx.camera.core.ImageProxy):com.google.common.util.concurrent.ListenableFuture");
    }

    public void attach() {
        this.mIsAttached = true;
    }

    public abstract void clearCache();

    public void detach() {
        this.mIsAttached = false;
        clearCache();
    }

    public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireImage = acquireImage(imageReaderProxy);
            if (acquireImage != null) {
                onValidImageAvailable(acquireImage);
            }
        } catch (IllegalStateException e) {
            Logger.e(TAG, "Failed to acquire image.", e);
        }
    }

    public abstract void onValidImageAvailable(@NonNull ImageProxy imageProxy);

    public void setAnalyzer(@Nullable Executor executor, @Nullable ImageAnalysis.Analyzer analyzer) {
        if (analyzer == null) {
            clearCache();
        }
        synchronized (this.mAnalyzerLock) {
            this.mSubscribedAnalyzer = analyzer;
            this.mUserExecutor = executor;
        }
    }

    public void setOnePixelShiftEnabled(boolean z) {
        this.mOnePixelShiftEnabled = z;
    }

    public void setOutputImageFormat(int i) {
        this.mOutputImageFormat = i;
    }

    public void setOutputImageRotationEnabled(boolean z) {
        this.mOutputImageRotationEnabled = z;
    }

    public void setProcessedImageReaderProxy(@NonNull SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        synchronized (this.mAnalyzerLock) {
            this.mProcessedImageReaderProxy = safeCloseImageReaderProxy;
        }
    }

    public void setRelativeRotation(int i) {
        this.mRelativeRotation = i;
    }

    public void setSensorToBufferTransformMatrix(@NonNull Matrix matrix) {
        synchronized (this.mAnalyzerLock) {
            this.mOriginalSensorToBufferTransformMatrix = matrix;
            this.mUpdatedSensorToBufferTransformMatrix = new Matrix(this.mOriginalSensorToBufferTransformMatrix);
        }
    }

    public void setViewPortCropRect(@NonNull Rect rect) {
        synchronized (this.mAnalyzerLock) {
            this.mOriginalViewPortCropRect = rect;
            this.mUpdatedViewPortCropRect = new Rect(this.mOriginalViewPortCropRect);
        }
    }
}
