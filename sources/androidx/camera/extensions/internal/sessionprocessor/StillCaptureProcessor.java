package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.Version;
import androidx.camera.extensions.internal.compat.workaround.CaptureOutputSurfaceForCaptureProcessor;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StillCaptureProcessor {
    private static final String TAG = "StillCaptureProcessor";
    private static final long UNSPECIFIED_TIMESTAMP = -1;
    CaptureOutputSurfaceForCaptureProcessor mCaptureOutputSurface;
    @NonNull
    final CaptureProcessorImpl mCaptureProcessorImpl;
    @NonNull
    final CaptureResultImageMatcher mCaptureResultImageMatcher = new CaptureResultImageMatcher();
    @GuardedBy("mLock")
    @NonNull
    HashMap<Integer, Pair<ImageReference, TotalCaptureResult>> mCaptureResults = new HashMap<>();
    @GuardedBy("mLock")
    boolean mIsClosed;
    private boolean mIsPostviewConfigured;
    final Object mLock = new Object();
    @GuardedBy("mLock")
    OnCaptureResultCallback mOnCaptureResultCallback = null;
    @GuardedBy("mLock")
    TotalCaptureResult mSourceCaptureResult = null;
    long mTimeStampForOutputImage;

    public interface OnCaptureResultCallback {
        void onCaptureCompleted(long j, @NonNull List<Pair<CaptureResult.Key, Object>> list);

        void onCaptureProcessProgressed(int i);

        void onError(@NonNull Exception exc);

        void onProcessCompleted();
    }

    public StillCaptureProcessor(@NonNull CaptureProcessorImpl captureProcessorImpl, @NonNull Surface surface, @NonNull Size size, @Nullable OutputSurface outputSurface, boolean z) {
        boolean z2;
        boolean z3 = false;
        this.mIsClosed = false;
        this.mTimeStampForOutputImage = -1;
        this.mCaptureProcessorImpl = captureProcessorImpl;
        CaptureOutputSurfaceForCaptureProcessor captureOutputSurfaceForCaptureProcessor = new CaptureOutputSurfaceForCaptureProcessor(surface, size, z);
        this.mCaptureOutputSurface = captureOutputSurfaceForCaptureProcessor;
        captureProcessorImpl.onOutputSurface(captureOutputSurfaceForCaptureProcessor.getSurface(), 35);
        captureProcessorImpl.onImageFormatUpdate(35);
        if (outputSurface != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mIsPostviewConfigured = z2;
        if (outputSurface != null) {
            Version version = Version.VERSION_1_4;
            if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) {
                Preconditions.checkArgument(outputSurface.getImageFormat() == 35 ? true : z3);
                captureProcessorImpl.onResolutionUpdate(size, outputSurface.getSize());
                captureProcessorImpl.onPostviewOutputSurface(outputSurface.getSurface());
                return;
            }
        }
        captureProcessorImpl.onResolutionUpdate(size);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ae, code lost:
        androidx.camera.core.Logger.d(TAG, "CaptureProcessorImpl.process() finish");
        r6 = r4.mOnCaptureResultCallback;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b7, code lost:
        if (r6 != null) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b9, code lost:
        r6.onProcessCompleted();
        r4.mOnCaptureResultCallback = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00be, code lost:
        clearCaptureResults();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c1, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c3, code lost:
        throw r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0013, B:42:0x0091] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$process$1(boolean r5, java.util.HashMap r6, final androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.OnCaptureResultCallback r7) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            r1 = 0
            boolean r2 = r4.mIsClosed     // Catch:{ Exception -> 0x002b }
            if (r2 == 0) goto L_0x002d
            java.lang.String r5 = "StillCaptureProcessor"
            java.lang.String r6 = "Ignore process() in closed state."
            androidx.camera.core.Logger.d(r5, r6)     // Catch:{ Exception -> 0x002b }
            java.lang.String r5 = "StillCaptureProcessor"
            java.lang.String r6 = "CaptureProcessorImpl.process() finish"
            androidx.camera.core.Logger.d(r5, r6)     // Catch:{ all -> 0x0020 }
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$OnCaptureResultCallback r5 = r4.mOnCaptureResultCallback     // Catch:{ all -> 0x0020 }
            if (r5 == 0) goto L_0x0023
            r5.onProcessCompleted()     // Catch:{ all -> 0x0020 }
            r4.mOnCaptureResultCallback = r1     // Catch:{ all -> 0x0020 }
            goto L_0x0023
        L_0x0020:
            r5 = move-exception
            goto L_0x00c2
        L_0x0023:
            r4.clearCaptureResults()     // Catch:{ all -> 0x0020 }
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0028:
            r5 = move-exception
            goto L_0x00ae
        L_0x002b:
            r5 = move-exception
            goto L_0x008d
        L_0x002d:
            java.lang.String r2 = "StillCaptureProcessor"
            java.lang.String r3 = "CaptureProcessorImpl.process() begin"
            androidx.camera.core.Logger.d(r2, r3)     // Catch:{ Exception -> 0x002b }
            androidx.camera.extensions.internal.Version r2 = androidx.camera.extensions.internal.Version.VERSION_1_4     // Catch:{ Exception -> 0x002b }
            boolean r3 = androidx.camera.extensions.internal.ExtensionVersion.isMinimumCompatibleVersion(r2)     // Catch:{ Exception -> 0x002b }
            if (r3 == 0) goto L_0x0057
            boolean r2 = androidx.camera.extensions.internal.ClientVersion.isMinimumCompatibleVersion(r2)     // Catch:{ Exception -> 0x002b }
            if (r2 == 0) goto L_0x0057
            if (r5 == 0) goto L_0x0057
            boolean r5 = r4.mIsPostviewConfigured     // Catch:{ Exception -> 0x002b }
            if (r5 == 0) goto L_0x0057
            androidx.camera.extensions.impl.CaptureProcessorImpl r5 = r4.mCaptureProcessorImpl     // Catch:{ Exception -> 0x002b }
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$1 r2 = new androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$1     // Catch:{ Exception -> 0x002b }
            r2.<init>(r7)     // Catch:{ Exception -> 0x002b }
            java.util.concurrent.Executor r3 = androidx.camera.core.impl.utils.executor.CameraXExecutors.directExecutor()     // Catch:{ Exception -> 0x002b }
            r5.processWithPostview(r6, r2, r3)     // Catch:{ Exception -> 0x002b }
            goto L_0x0079
        L_0x0057:
            androidx.camera.extensions.internal.Version r5 = androidx.camera.extensions.internal.Version.VERSION_1_3     // Catch:{ Exception -> 0x002b }
            boolean r2 = androidx.camera.extensions.internal.ExtensionVersion.isMinimumCompatibleVersion(r5)     // Catch:{ Exception -> 0x002b }
            if (r2 == 0) goto L_0x0074
            boolean r5 = androidx.camera.extensions.internal.ClientVersion.isMinimumCompatibleVersion(r5)     // Catch:{ Exception -> 0x002b }
            if (r5 == 0) goto L_0x0074
            androidx.camera.extensions.impl.CaptureProcessorImpl r5 = r4.mCaptureProcessorImpl     // Catch:{ Exception -> 0x002b }
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$2 r2 = new androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$2     // Catch:{ Exception -> 0x002b }
            r2.<init>(r7)     // Catch:{ Exception -> 0x002b }
            java.util.concurrent.Executor r3 = androidx.camera.core.impl.utils.executor.CameraXExecutors.directExecutor()     // Catch:{ Exception -> 0x002b }
            r5.process(r6, r2, r3)     // Catch:{ Exception -> 0x002b }
            goto L_0x0079
        L_0x0074:
            androidx.camera.extensions.impl.CaptureProcessorImpl r5 = r4.mCaptureProcessorImpl     // Catch:{ Exception -> 0x002b }
            r5.process(r6)     // Catch:{ Exception -> 0x002b }
        L_0x0079:
            java.lang.String r5 = "StillCaptureProcessor"
            java.lang.String r6 = "CaptureProcessorImpl.process() finish"
            androidx.camera.core.Logger.d(r5, r6)     // Catch:{ all -> 0x0020 }
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$OnCaptureResultCallback r5 = r4.mOnCaptureResultCallback     // Catch:{ all -> 0x0020 }
            if (r5 == 0) goto L_0x0089
            r5.onProcessCompleted()     // Catch:{ all -> 0x0020 }
            r4.mOnCaptureResultCallback = r1     // Catch:{ all -> 0x0020 }
        L_0x0089:
            r4.clearCaptureResults()     // Catch:{ all -> 0x0020 }
            goto L_0x00ac
        L_0x008d:
            java.lang.String r6 = "StillCaptureProcessor"
            java.lang.String r2 = "mCaptureProcessorImpl.process exception "
            androidx.camera.core.Logger.e(r6, r2, r5)     // Catch:{ all -> 0x0028 }
            r4.mOnCaptureResultCallback = r1     // Catch:{ all -> 0x0028 }
            if (r7 == 0) goto L_0x009b
            r7.onError(r5)     // Catch:{ all -> 0x0028 }
        L_0x009b:
            java.lang.String r5 = "StillCaptureProcessor"
            java.lang.String r6 = "CaptureProcessorImpl.process() finish"
            androidx.camera.core.Logger.d(r5, r6)     // Catch:{ all -> 0x0020 }
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$OnCaptureResultCallback r5 = r4.mOnCaptureResultCallback     // Catch:{ all -> 0x0020 }
            if (r5 == 0) goto L_0x0089
            r5.onProcessCompleted()     // Catch:{ all -> 0x0020 }
            r4.mOnCaptureResultCallback = r1     // Catch:{ all -> 0x0020 }
            goto L_0x0089
        L_0x00ac:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x00ae:
            java.lang.String r6 = "StillCaptureProcessor"
            java.lang.String r7 = "CaptureProcessorImpl.process() finish"
            androidx.camera.core.Logger.d(r6, r7)     // Catch:{ all -> 0x0020 }
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$OnCaptureResultCallback r6 = r4.mOnCaptureResultCallback     // Catch:{ all -> 0x0020 }
            if (r6 == 0) goto L_0x00be
            r6.onProcessCompleted()     // Catch:{ all -> 0x0020 }
            r4.mOnCaptureResultCallback = r1     // Catch:{ all -> 0x0020 }
        L_0x00be:
            r4.clearCaptureResults()     // Catch:{ all -> 0x0020 }
            throw r5     // Catch:{ all -> 0x0020 }
        L_0x00c2:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.lambda$process$1(boolean, java.util.HashMap, androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$OnCaptureResultCallback):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$startCapture$0(java.util.List r6, androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.OnCaptureResultCallback r7, boolean r8, androidx.camera.extensions.internal.sessionprocessor.ImageReference r9, android.hardware.camera2.TotalCaptureResult r10, int r11) {
        /*
            r5 = this;
            java.lang.String r0 = "mCaptureResult has capture stage Id: "
            java.lang.String r1 = "onImageReferenceIncoming  captureStageId="
            java.lang.Object r2 = r5.mLock
            monitor-enter(r2)
            boolean r3 = r5.mIsClosed     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0019
            r9.decrement()     // Catch:{ all -> 0x0017 }
            java.lang.String r6 = "StillCaptureProcessor"
            java.lang.String r7 = "Ignore image in closed state"
            androidx.camera.core.Logger.d(r6, r7)     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return
        L_0x0017:
            r6 = move-exception
            goto L_0x0062
        L_0x0019:
            java.lang.String r3 = "StillCaptureProcessor"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0017 }
            r4.<init>(r1)     // Catch:{ all -> 0x0017 }
            r4.append(r11)     // Catch:{ all -> 0x0017 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0017 }
            androidx.camera.core.Logger.d(r3, r1)     // Catch:{ all -> 0x0017 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.ImageReference, android.hardware.camera2.TotalCaptureResult>> r1 = r5.mCaptureResults     // Catch:{ all -> 0x0017 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0017 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0017 }
            r3.<init>(r9, r10)     // Catch:{ all -> 0x0017 }
            r1.put(r11, r3)     // Catch:{ all -> 0x0017 }
            java.lang.String r9 = "StillCaptureProcessor"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0017 }
            r10.<init>(r0)     // Catch:{ all -> 0x0017 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.ImageReference, android.hardware.camera2.TotalCaptureResult>> r11 = r5.mCaptureResults     // Catch:{ all -> 0x0017 }
            java.util.Set r11 = r11.keySet()     // Catch:{ all -> 0x0017 }
            r10.append(r11)     // Catch:{ all -> 0x0017 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0017 }
            androidx.camera.core.Logger.d(r9, r10)     // Catch:{ all -> 0x0017 }
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.ImageReference, android.hardware.camera2.TotalCaptureResult>> r9 = r5.mCaptureResults     // Catch:{ all -> 0x0017 }
            java.util.Set r9 = r9.keySet()     // Catch:{ all -> 0x0017 }
            boolean r6 = r9.containsAll(r6)     // Catch:{ all -> 0x0017 }
            if (r6 == 0) goto L_0x0060
            java.util.HashMap<java.lang.Integer, android.util.Pair<androidx.camera.extensions.internal.sessionprocessor.ImageReference, android.hardware.camera2.TotalCaptureResult>> r6 = r5.mCaptureResults     // Catch:{ all -> 0x0017 }
            r5.process(r6, r7, r8)     // Catch:{ all -> 0x0017 }
        L_0x0060:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return
        L_0x0062:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.lambda$startCapture$0(java.util.List, androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$OnCaptureResultCallback, boolean, androidx.camera.extensions.internal.sessionprocessor.ImageReference, android.hardware.camera2.TotalCaptureResult, int):void");
    }

    public void clearCaptureResults() {
        synchronized (this.mLock) {
            try {
                for (Pair<ImageReference, TotalCaptureResult> pair : this.mCaptureResults.values()) {
                    ((ImageReference) pair.first).decrement();
                }
                this.mCaptureResults.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void close() {
        synchronized (this.mLock) {
            Logger.d(TAG, "Close the StillCaptureProcessor");
            this.mIsClosed = true;
            clearCaptureResults();
            this.mCaptureResultImageMatcher.clearImageReferenceListener();
            this.mCaptureResultImageMatcher.clear();
            this.mCaptureOutputSurface.close();
        }
    }

    public void notifyCaptureResult(@NonNull TotalCaptureResult totalCaptureResult, int i) {
        Long l;
        this.mCaptureResultImageMatcher.captureResultIncoming(totalCaptureResult, i);
        if (this.mTimeStampForOutputImage == -1 && (l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP)) != null) {
            long longValue = l.longValue();
            this.mTimeStampForOutputImage = longValue;
            this.mCaptureOutputSurface.setOutputImageTimestamp(longValue);
        }
        synchronized (this.mLock) {
            try {
                if (this.mSourceCaptureResult == null) {
                    this.mSourceCaptureResult = totalCaptureResult;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyImage(@NonNull ImageReference imageReference) {
        this.mCaptureResultImageMatcher.imageIncoming(imageReference);
    }

    public void process(@NonNull Map<Integer, Pair<ImageReference, TotalCaptureResult>> map, @NonNull OnCaptureResultCallback onCaptureResultCallback, boolean z) {
        HashMap hashMap = new HashMap();
        synchronized (this.mLock) {
            try {
                for (Integer next : map.keySet()) {
                    Pair pair = map.get(next);
                    hashMap.put(next, new Pair(((ImageReference) pair.first).get(), (TotalCaptureResult) pair.second));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        CameraXExecutors.ioExecutor().execute(new f(this, z, hashMap, onCaptureResultCallback));
    }

    public void startCapture(boolean z, @NonNull List<Integer> list, @NonNull OnCaptureResultCallback onCaptureResultCallback) {
        Logger.d(TAG, "Start the capture: enablePostview=" + z);
        this.mTimeStampForOutputImage = -1;
        synchronized (this.mLock) {
            Preconditions.checkState(!this.mIsClosed, "StillCaptureProcessor is closed. Can't invoke startCapture()");
            this.mOnCaptureResultCallback = onCaptureResultCallback;
            clearCaptureResults();
        }
        this.mCaptureResultImageMatcher.clear();
        this.mCaptureResultImageMatcher.setImageReferenceListener(new g(this, list, onCaptureResultCallback, z));
    }
}
