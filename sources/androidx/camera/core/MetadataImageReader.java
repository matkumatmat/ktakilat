package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MetadataImageReader implements ImageReaderProxy, ForwardingImageProxy.OnImageCloseListener {
    private static final String TAG = "MetadataImageReader";
    @GuardedBy("mLock")
    private final List<ImageProxy> mAcquiredImageProxies;
    private CameraCaptureCallback mCameraCaptureCallback;
    @GuardedBy("mLock")
    private boolean mClosed;
    @GuardedBy("mLock")
    @Nullable
    private Executor mExecutor;
    @GuardedBy("mLock")
    private int mImageProxiesIndex;
    @GuardedBy("mLock")
    private final ImageReaderProxy mImageReaderProxy;
    @GuardedBy("mLock")
    @Nullable
    ImageReaderProxy.OnImageAvailableListener mListener;
    private final Object mLock;
    @GuardedBy("mLock")
    private final List<ImageProxy> mMatchedImageProxies;
    @GuardedBy("mLock")
    private final LongSparseArray<ImageInfo> mPendingImageInfos;
    @GuardedBy("mLock")
    private final LongSparseArray<ImageProxy> mPendingImages;
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener;
    @GuardedBy("mLock")
    private int mUnAcquiredAvailableImageCount;

    public MetadataImageReader(int i, int i2, int i3, int i4) {
        this(createImageReaderProxy(i, i2, i3, i4));
    }

    private static ImageReaderProxy createImageReaderProxy(int i, int i2, int i3, int i4) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(i, i2, i3, i4));
    }

    private void dequeImageProxy(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            try {
                int indexOf = this.mMatchedImageProxies.indexOf(imageProxy);
                if (indexOf >= 0) {
                    this.mMatchedImageProxies.remove(indexOf);
                    int i = this.mImageProxiesIndex;
                    if (indexOf <= i) {
                        this.mImageProxiesIndex = i - 1;
                    }
                }
                this.mAcquiredImageProxies.remove(imageProxy);
                if (this.mUnAcquiredAvailableImageCount > 0) {
                    imageIncoming(this.mImageReaderProxy);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void enqueueImageProxy(SettableImageProxy settableImageProxy) {
        ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
        Executor executor;
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.size() < getMaxImages()) {
                    settableImageProxy.addOnImageCloseListener(this);
                    this.mMatchedImageProxies.add(settableImageProxy);
                    onImageAvailableListener = this.mListener;
                    executor = this.mExecutor;
                } else {
                    Logger.d("TAG", "Maximum image number reached.");
                    settableImageProxy.close();
                    onImageAvailableListener = null;
                    executor = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (onImageAvailableListener == null) {
            return;
        }
        if (executor != null) {
            executor.execute(new ib(4, this, onImageAvailableListener));
        } else {
            onImageAvailableListener.onImageAvailable(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$enqueueImageProxy$1(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        onImageAvailableListener.onImageAvailable(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            this.mUnAcquiredAvailableImageCount++;
        }
        imageIncoming(imageReaderProxy);
    }

    private void matchImages() {
        synchronized (this.mLock) {
            try {
                for (int size = this.mPendingImageInfos.size() - 1; size >= 0; size--) {
                    ImageInfo valueAt = this.mPendingImageInfos.valueAt(size);
                    long timestamp = valueAt.getTimestamp();
                    ImageProxy imageProxy = this.mPendingImages.get(timestamp);
                    if (imageProxy != null) {
                        this.mPendingImages.remove(timestamp);
                        this.mPendingImageInfos.removeAt(size);
                        enqueueImageProxy(new SettableImageProxy(imageProxy, valueAt));
                    }
                }
                removeStaleData();
            } finally {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeStaleData() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            android.util.LongSparseArray<androidx.camera.core.ImageProxy> r1 = r7.mPendingImages     // Catch:{ all -> 0x005b }
            int r1 = r1.size()     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x007e
            android.util.LongSparseArray<androidx.camera.core.ImageInfo> r1 = r7.mPendingImageInfos     // Catch:{ all -> 0x005b }
            int r1 = r1.size()     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x0014
            goto L_0x007e
        L_0x0014:
            android.util.LongSparseArray<androidx.camera.core.ImageProxy> r1 = r7.mPendingImages     // Catch:{ all -> 0x005b }
            r2 = 0
            long r3 = r1.keyAt(r2)     // Catch:{ all -> 0x005b }
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x005b }
            android.util.LongSparseArray<androidx.camera.core.ImageInfo> r5 = r7.mPendingImageInfos     // Catch:{ all -> 0x005b }
            long r5 = r5.keyAt(r2)     // Catch:{ all -> 0x005b }
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x005b }
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x005b }
            r1 = r1 ^ 1
            androidx.core.util.Preconditions.checkArgument(r1)     // Catch:{ all -> 0x005b }
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0060
            android.util.LongSparseArray<androidx.camera.core.ImageProxy> r1 = r7.mPendingImages     // Catch:{ all -> 0x005b }
            int r1 = r1.size()     // Catch:{ all -> 0x005b }
            int r1 = r1 + -1
        L_0x003e:
            if (r1 < 0) goto L_0x007c
            android.util.LongSparseArray<androidx.camera.core.ImageProxy> r2 = r7.mPendingImages     // Catch:{ all -> 0x005b }
            long r2 = r2.keyAt(r1)     // Catch:{ all -> 0x005b }
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x005d
            android.util.LongSparseArray<androidx.camera.core.ImageProxy> r2 = r7.mPendingImages     // Catch:{ all -> 0x005b }
            java.lang.Object r2 = r2.valueAt(r1)     // Catch:{ all -> 0x005b }
            androidx.camera.core.ImageProxy r2 = (androidx.camera.core.ImageProxy) r2     // Catch:{ all -> 0x005b }
            r2.close()     // Catch:{ all -> 0x005b }
            android.util.LongSparseArray<androidx.camera.core.ImageProxy> r2 = r7.mPendingImages     // Catch:{ all -> 0x005b }
            r2.removeAt(r1)     // Catch:{ all -> 0x005b }
            goto L_0x005d
        L_0x005b:
            r1 = move-exception
            goto L_0x0080
        L_0x005d:
            int r1 = r1 + -1
            goto L_0x003e
        L_0x0060:
            android.util.LongSparseArray<androidx.camera.core.ImageInfo> r1 = r7.mPendingImageInfos     // Catch:{ all -> 0x005b }
            int r1 = r1.size()     // Catch:{ all -> 0x005b }
            int r1 = r1 + -1
        L_0x0068:
            if (r1 < 0) goto L_0x007c
            android.util.LongSparseArray<androidx.camera.core.ImageInfo> r2 = r7.mPendingImageInfos     // Catch:{ all -> 0x005b }
            long r5 = r2.keyAt(r1)     // Catch:{ all -> 0x005b }
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0079
            android.util.LongSparseArray<androidx.camera.core.ImageInfo> r2 = r7.mPendingImageInfos     // Catch:{ all -> 0x005b }
            r2.removeAt(r1)     // Catch:{ all -> 0x005b }
        L_0x0079:
            int r1 = r1 + -1
            goto L_0x0068
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x007e:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x0080:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.MetadataImageReader.removeStaleData():void");
    }

    @Nullable
    public ImageProxy acquireLatestImage() {
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.isEmpty()) {
                    return null;
                }
                if (this.mImageProxiesIndex < this.mMatchedImageProxies.size()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < this.mMatchedImageProxies.size() - 1; i++) {
                        if (!this.mAcquiredImageProxies.contains(this.mMatchedImageProxies.get(i))) {
                            arrayList.add(this.mMatchedImageProxies.get(i));
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((ImageProxy) it.next()).close();
                    }
                    int size = this.mMatchedImageProxies.size();
                    List<ImageProxy> list = this.mMatchedImageProxies;
                    this.mImageProxiesIndex = size;
                    ImageProxy imageProxy = list.get(size - 1);
                    this.mAcquiredImageProxies.add(imageProxy);
                    return imageProxy;
                }
                throw new IllegalStateException("Maximum image number reached.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public ImageProxy acquireNextImage() {
        synchronized (this.mLock) {
            try {
                if (this.mMatchedImageProxies.isEmpty()) {
                    return null;
                }
                if (this.mImageProxiesIndex < this.mMatchedImageProxies.size()) {
                    List<ImageProxy> list = this.mMatchedImageProxies;
                    int i = this.mImageProxiesIndex;
                    this.mImageProxiesIndex = i + 1;
                    ImageProxy imageProxy = list.get(i);
                    this.mAcquiredImageProxies.add(imageProxy);
                    return imageProxy;
                }
                throw new IllegalStateException("Maximum image number reached.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mImageReaderProxy.clearOnImageAvailableListener();
            this.mListener = null;
            this.mExecutor = null;
            this.mUnAcquiredAvailableImageCount = 0;
        }
    }

    public void close() {
        synchronized (this.mLock) {
            try {
                if (!this.mClosed) {
                    Iterator it = new ArrayList(this.mMatchedImageProxies).iterator();
                    while (it.hasNext()) {
                        ((ImageProxy) it.next()).close();
                    }
                    this.mMatchedImageProxies.clear();
                    this.mImageReaderProxy.close();
                    this.mClosed = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public CameraCaptureCallback getCameraCaptureCallback() {
        return this.mCameraCaptureCallback;
    }

    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mImageReaderProxy.getHeight();
        }
        return height;
    }

    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mImageReaderProxy.getImageFormat();
        }
        return imageFormat;
    }

    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mImageReaderProxy.getMaxImages();
        }
        return maxImages;
    }

    @Nullable
    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mImageReaderProxy.getSurface();
        }
        return surface;
    }

    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mImageReaderProxy.getWidth();
        }
        return width;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void imageIncoming(androidx.camera.core.impl.ImageReaderProxy r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mClosed     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r7 = move-exception
            goto L_0x0060
        L_0x000b:
            android.util.LongSparseArray<androidx.camera.core.ImageProxy> r1 = r6.mPendingImages     // Catch:{ all -> 0x0009 }
            int r1 = r1.size()     // Catch:{ all -> 0x0009 }
            java.util.List<androidx.camera.core.ImageProxy> r2 = r6.mMatchedImageProxies     // Catch:{ all -> 0x0009 }
            int r2 = r2.size()     // Catch:{ all -> 0x0009 }
            int r1 = r1 + r2
            int r2 = r7.getMaxImages()     // Catch:{ all -> 0x0009 }
            if (r1 < r2) goto L_0x0027
            java.lang.String r7 = "MetadataImageReader"
            java.lang.String r1 = "Skip to acquire the next image because the acquired image count has reached the max images count."
            androidx.camera.core.Logger.d(r7, r1)     // Catch:{ all -> 0x0009 }
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0027:
            androidx.camera.core.ImageProxy r2 = r7.acquireNextImage()     // Catch:{ IllegalStateException -> 0x0048 }
            if (r2 == 0) goto L_0x0051
            int r3 = r6.mUnAcquiredAvailableImageCount     // Catch:{ all -> 0x0009 }
            int r3 = r3 + -1
            r6.mUnAcquiredAvailableImageCount = r3     // Catch:{ all -> 0x0009 }
            int r1 = r1 + 1
            android.util.LongSparseArray<androidx.camera.core.ImageProxy> r3 = r6.mPendingImages     // Catch:{ all -> 0x0009 }
            androidx.camera.core.ImageInfo r4 = r2.getImageInfo()     // Catch:{ all -> 0x0009 }
            long r4 = r4.getTimestamp()     // Catch:{ all -> 0x0009 }
            r3.put(r4, r2)     // Catch:{ all -> 0x0009 }
            r6.matchImages()     // Catch:{ all -> 0x0009 }
            goto L_0x0051
        L_0x0046:
            r7 = move-exception
            goto L_0x005f
        L_0x0048:
            r2 = move-exception
            java.lang.String r3 = "MetadataImageReader"
            java.lang.String r4 = "Failed to acquire next image."
            androidx.camera.core.Logger.d(r3, r4, r2)     // Catch:{ all -> 0x0046 }
            r2 = 0
        L_0x0051:
            if (r2 == 0) goto L_0x005d
            int r2 = r6.mUnAcquiredAvailableImageCount     // Catch:{ all -> 0x0009 }
            if (r2 <= 0) goto L_0x005d
            int r2 = r7.getMaxImages()     // Catch:{ all -> 0x0009 }
            if (r1 < r2) goto L_0x0027
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x005f:
            throw r7     // Catch:{ all -> 0x0009 }
        L_0x0060:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.MetadataImageReader.imageIncoming(androidx.camera.core.impl.ImageReaderProxy):void");
    }

    public void onImageClose(@NonNull ImageProxy imageProxy) {
        synchronized (this.mLock) {
            dequeImageProxy(imageProxy);
        }
    }

    public void resultIncoming(CameraCaptureResult cameraCaptureResult) {
        synchronized (this.mLock) {
            try {
                if (!this.mClosed) {
                    this.mPendingImageInfos.put(cameraCaptureResult.getTimestamp(), new CameraCaptureResultImageInfo(cameraCaptureResult));
                    matchImages();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mListener = (ImageReaderProxy.OnImageAvailableListener) Preconditions.checkNotNull(onImageAvailableListener);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
            this.mImageReaderProxy.setOnImageAvailableListener(this.mTransformedListener, executor);
        }
    }

    public MetadataImageReader(@NonNull ImageReaderProxy imageReaderProxy) {
        this.mLock = new Object();
        this.mCameraCaptureCallback = new CameraCaptureCallback() {
            public void onCaptureCompleted(int i, @NonNull CameraCaptureResult cameraCaptureResult) {
                super.onCaptureCompleted(i, cameraCaptureResult);
                MetadataImageReader.this.resultIncoming(cameraCaptureResult);
            }
        };
        this.mUnAcquiredAvailableImageCount = 0;
        this.mTransformedListener = new v2(this, 1);
        this.mClosed = false;
        this.mPendingImageInfos = new LongSparseArray<>();
        this.mPendingImages = new LongSparseArray<>();
        this.mAcquiredImageProxies = new ArrayList();
        this.mImageReaderProxy = imageReaderProxy;
        this.mImageProxiesIndex = 0;
        this.mMatchedImageProxies = new ArrayList(getMaxImages());
    }
}
