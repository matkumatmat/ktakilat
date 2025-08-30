package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.LongSparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CaptureResultImageMatcher {
    private static final int INVALID_TIMESTAMP = -1;
    @GuardedBy("mLock")
    Map<TotalCaptureResult, Integer> mCaptureStageIdMap = new HashMap();
    @GuardedBy("mLock")
    ImageReferenceListener mImageReferenceListener;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private final LongSparseArray<List<TotalCaptureResult>> mPendingCaptureResults = new LongSparseArray<>();
    @GuardedBy("mLock")
    private final LongSparseArray<List<ImageReference>> mPendingImages = new LongSparseArray<>();

    public interface ImageReferenceListener {
        void onImageReferenceIncoming(@NonNull ImageReference imageReference, @NonNull TotalCaptureResult totalCaptureResult, int i);
    }

    private <T> void addToList(LongSparseArray<List<T>> longSparseArray, long j, T t) {
        List list = longSparseArray.get(j);
        if (list == null) {
            list = new ArrayList();
            longSparseArray.put(j, list);
        }
        list.add(t);
    }

    private long getTimeStampFromCaptureResult(TotalCaptureResult totalCaptureResult) {
        Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l != null) {
            return l.longValue();
        }
        return -1;
    }

    private void matchImages() {
        TotalCaptureResult totalCaptureResult;
        ImageReference imageReference;
        boolean z;
        synchronized (this.mLock) {
            try {
                int size = this.mPendingCaptureResults.size() - 1;
                while (true) {
                    if (size < 0) {
                        totalCaptureResult = null;
                        imageReference = null;
                        break;
                    }
                    List valueAt = this.mPendingCaptureResults.valueAt(size);
                    if (!valueAt.isEmpty()) {
                        totalCaptureResult = (TotalCaptureResult) valueAt.get(0);
                        long timeStampFromCaptureResult = getTimeStampFromCaptureResult(totalCaptureResult);
                        if (timeStampFromCaptureResult == this.mPendingCaptureResults.keyAt(size)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Preconditions.checkState(z);
                        List list = this.mPendingImages.get(timeStampFromCaptureResult);
                        if (list != null && !list.isEmpty()) {
                            imageReference = (ImageReference) list.get(0);
                            removeFromList(this.mPendingImages, timeStampFromCaptureResult, imageReference);
                            valueAt.remove(totalCaptureResult);
                            if (valueAt.isEmpty()) {
                                this.mPendingCaptureResults.removeAt(size);
                            }
                        }
                    }
                    size--;
                }
                removeStaleData();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (imageReference != null && totalCaptureResult != null) {
            notifyImage(imageReference, totalCaptureResult);
        }
    }

    private void notifyImage(ImageReference imageReference, TotalCaptureResult totalCaptureResult) {
        ImageReferenceListener imageReferenceListener;
        Integer num;
        synchronized (this.mLock) {
            try {
                imageReferenceListener = this.mImageReferenceListener;
                if (imageReferenceListener != null) {
                    num = this.mCaptureStageIdMap.get(totalCaptureResult);
                } else {
                    imageReference.decrement();
                    imageReferenceListener = null;
                    num = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (imageReferenceListener != null) {
            imageReferenceListener.onImageReferenceIncoming(imageReference, totalCaptureResult, num.intValue());
        }
    }

    private <T> void removeFromList(LongSparseArray<List<T>> longSparseArray, long j, T t) {
        List list = longSparseArray.get(j);
        if (list != null) {
            list.remove(t);
            if (list.isEmpty()) {
                longSparseArray.remove(j);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0090, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeStaleData() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r1 = r7.mPendingImages     // Catch:{ all -> 0x0067 }
            int r1 = r1.size()     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x008f
            android.util.LongSparseArray<java.util.List<android.hardware.camera2.TotalCaptureResult>> r1 = r7.mPendingCaptureResults     // Catch:{ all -> 0x0067 }
            int r1 = r1.size()     // Catch:{ all -> 0x0067 }
            if (r1 != 0) goto L_0x0015
            goto L_0x008f
        L_0x0015:
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r1 = r7.mPendingImages     // Catch:{ all -> 0x0067 }
            r2 = 0
            long r3 = r1.keyAt(r2)     // Catch:{ all -> 0x0067 }
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0067 }
            android.util.LongSparseArray<java.util.List<android.hardware.camera2.TotalCaptureResult>> r5 = r7.mPendingCaptureResults     // Catch:{ all -> 0x0067 }
            long r5 = r5.keyAt(r2)     // Catch:{ all -> 0x0067 }
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0067 }
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x0067 }
            r1 = r1 ^ 1
            androidx.core.util.Preconditions.checkArgument(r1)     // Catch:{ all -> 0x0067 }
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0071
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r1 = r7.mPendingImages     // Catch:{ all -> 0x0067 }
            int r1 = r1.size()     // Catch:{ all -> 0x0067 }
            int r1 = r1 + -1
        L_0x003f:
            if (r1 < 0) goto L_0x008d
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r2 = r7.mPendingImages     // Catch:{ all -> 0x0067 }
            long r2 = r2.keyAt(r1)     // Catch:{ all -> 0x0067 }
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x006e
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r2 = r7.mPendingImages     // Catch:{ all -> 0x0067 }
            java.lang.Object r2 = r2.valueAt(r1)     // Catch:{ all -> 0x0067 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0067 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0067 }
        L_0x0057:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0069
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0067 }
            androidx.camera.extensions.internal.sessionprocessor.ImageReference r3 = (androidx.camera.extensions.internal.sessionprocessor.ImageReference) r3     // Catch:{ all -> 0x0067 }
            r3.decrement()     // Catch:{ all -> 0x0067 }
            goto L_0x0057
        L_0x0067:
            r1 = move-exception
            goto L_0x0091
        L_0x0069:
            android.util.LongSparseArray<java.util.List<androidx.camera.extensions.internal.sessionprocessor.ImageReference>> r2 = r7.mPendingImages     // Catch:{ all -> 0x0067 }
            r2.removeAt(r1)     // Catch:{ all -> 0x0067 }
        L_0x006e:
            int r1 = r1 + -1
            goto L_0x003f
        L_0x0071:
            android.util.LongSparseArray<java.util.List<android.hardware.camera2.TotalCaptureResult>> r1 = r7.mPendingCaptureResults     // Catch:{ all -> 0x0067 }
            int r1 = r1.size()     // Catch:{ all -> 0x0067 }
            int r1 = r1 + -1
        L_0x0079:
            if (r1 < 0) goto L_0x008d
            android.util.LongSparseArray<java.util.List<android.hardware.camera2.TotalCaptureResult>> r2 = r7.mPendingCaptureResults     // Catch:{ all -> 0x0067 }
            long r5 = r2.keyAt(r1)     // Catch:{ all -> 0x0067 }
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x008a
            android.util.LongSparseArray<java.util.List<android.hardware.camera2.TotalCaptureResult>> r2 = r7.mPendingCaptureResults     // Catch:{ all -> 0x0067 }
            r2.removeAt(r1)     // Catch:{ all -> 0x0067 }
        L_0x008a:
            int r1 = r1 + -1
            goto L_0x0079
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x0067 }
            return
        L_0x008f:
            monitor-exit(r0)     // Catch:{ all -> 0x0067 }
            return
        L_0x0091:
            monitor-exit(r0)     // Catch:{ all -> 0x0067 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.CaptureResultImageMatcher.removeStaleData():void");
    }

    public void captureResultIncoming(@NonNull TotalCaptureResult totalCaptureResult) {
        captureResultIncoming(totalCaptureResult, 0);
    }

    public void clear() {
        synchronized (this.mLock) {
            try {
                this.mPendingCaptureResults.clear();
                for (int i = 0; i < this.mPendingImages.size(); i++) {
                    for (ImageReference decrement : this.mPendingImages.get(this.mPendingImages.keyAt(i))) {
                        decrement.decrement();
                    }
                }
                this.mPendingImages.clear();
                this.mCaptureStageIdMap.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearImageReferenceListener() {
        synchronized (this.mLock) {
            this.mImageReferenceListener = null;
        }
    }

    public void imageIncoming(@NonNull ImageReference imageReference) {
        synchronized (this.mLock) {
            addToList(this.mPendingImages, imageReference.get().getTimestamp(), imageReference);
        }
        matchImages();
    }

    public void setImageReferenceListener(@NonNull ImageReferenceListener imageReferenceListener) {
        synchronized (this.mLock) {
            this.mImageReferenceListener = imageReferenceListener;
        }
    }

    public void captureResultIncoming(@NonNull TotalCaptureResult totalCaptureResult, int i) {
        synchronized (this.mLock) {
            try {
                long timeStampFromCaptureResult = getTimeStampFromCaptureResult(totalCaptureResult);
                if (timeStampFromCaptureResult != -1) {
                    addToList(this.mPendingCaptureResults, timeStampFromCaptureResult, totalCaptureResult);
                    this.mCaptureStageIdMap.put(totalCaptureResult, Integer.valueOf(i));
                    matchImages();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
