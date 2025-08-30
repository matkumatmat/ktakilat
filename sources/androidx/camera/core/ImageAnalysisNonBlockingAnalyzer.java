package androidx.camera.core;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.impl.ImageReaderProxy;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

final class ImageAnalysisNonBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    final Executor mBackgroundExecutor;
    @VisibleForTesting
    @GuardedBy("mLock")
    @Nullable
    ImageProxy mCachedImage;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    @Nullable
    private CacheAnalyzingImageProxy mPostedImage;

    public static class CacheAnalyzingImageProxy extends ForwardingImageProxy {
        final WeakReference<ImageAnalysisNonBlockingAnalyzer> mNonBlockingAnalyzerWeakReference;

        public CacheAnalyzingImageProxy(@NonNull ImageProxy imageProxy, @NonNull ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
            super(imageProxy);
            this.mNonBlockingAnalyzerWeakReference = new WeakReference<>(imageAnalysisNonBlockingAnalyzer);
            addOnImageCloseListener(new e(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(ImageProxy imageProxy) {
            ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer = this.mNonBlockingAnalyzerWeakReference.get();
            if (imageAnalysisNonBlockingAnalyzer != null) {
                imageAnalysisNonBlockingAnalyzer.mBackgroundExecutor.execute(new f(imageAnalysisNonBlockingAnalyzer));
            }
        }
    }

    public ImageAnalysisNonBlockingAnalyzer(Executor executor) {
        this.mBackgroundExecutor = executor;
    }

    @Nullable
    public ImageProxy acquireImage(@NonNull ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireLatestImage();
    }

    public void analyzeCachedImage() {
        synchronized (this.mLock) {
            try {
                this.mPostedImage = null;
                ImageProxy imageProxy = this.mCachedImage;
                if (imageProxy != null) {
                    this.mCachedImage = null;
                    onValidImageAvailable(imageProxy);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearCache() {
        synchronized (this.mLock) {
            try {
                ImageProxy imageProxy = this.mCachedImage;
                if (imageProxy != null) {
                    imageProxy.close();
                    this.mCachedImage = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onValidImageAvailable(@androidx.annotation.NonNull androidx.camera.core.ImageProxy r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mIsAttached     // Catch:{ all -> 0x000c }
            if (r1 != 0) goto L_0x000e
            r7.close()     // Catch:{ all -> 0x000c }
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return
        L_0x000c:
            r7 = move-exception
            goto L_0x0050
        L_0x000e:
            androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy r1 = r6.mPostedImage     // Catch:{ all -> 0x000c }
            if (r1 == 0) goto L_0x0037
            androidx.camera.core.ImageInfo r1 = r7.getImageInfo()     // Catch:{ all -> 0x000c }
            long r1 = r1.getTimestamp()     // Catch:{ all -> 0x000c }
            androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy r3 = r6.mPostedImage     // Catch:{ all -> 0x000c }
            androidx.camera.core.ImageInfo r3 = r3.getImageInfo()     // Catch:{ all -> 0x000c }
            long r3 = r3.getTimestamp()     // Catch:{ all -> 0x000c }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x002c
            r7.close()     // Catch:{ all -> 0x000c }
            goto L_0x0035
        L_0x002c:
            androidx.camera.core.ImageProxy r1 = r6.mCachedImage     // Catch:{ all -> 0x000c }
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ all -> 0x000c }
        L_0x0033:
            r6.mCachedImage = r7     // Catch:{ all -> 0x000c }
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return
        L_0x0037:
            androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy r1 = new androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy     // Catch:{ all -> 0x000c }
            r1.<init>(r7, r6)     // Catch:{ all -> 0x000c }
            r6.mPostedImage = r1     // Catch:{ all -> 0x000c }
            com.google.common.util.concurrent.ListenableFuture r7 = r6.analyzeImage(r1)     // Catch:{ all -> 0x000c }
            androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$1 r2 = new androidx.camera.core.ImageAnalysisNonBlockingAnalyzer$1     // Catch:{ all -> 0x000c }
            r2.<init>(r1)     // Catch:{ all -> 0x000c }
            java.util.concurrent.Executor r1 = androidx.camera.core.impl.utils.executor.CameraXExecutors.directExecutor()     // Catch:{ all -> 0x000c }
            androidx.camera.core.impl.utils.futures.Futures.addCallback(r7, r2, r1)     // Catch:{ all -> 0x000c }
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            return
        L_0x0050:
            monitor-exit(r0)     // Catch:{ all -> 0x000c }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageAnalysisNonBlockingAnalyzer.onValidImageAvailable(androidx.camera.core.ImageProxy):void");
    }
}
