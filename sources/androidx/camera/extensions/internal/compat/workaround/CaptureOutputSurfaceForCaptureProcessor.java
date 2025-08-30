package androidx.camera.extensions.internal.compat.workaround;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.extensions.internal.compat.quirk.CaptureOutputSurfaceOccupiedQuirk;
import androidx.camera.extensions.internal.compat.quirk.DeviceQuirks;

@OptIn(markerClass = {ExperimentalGetImage.class})
public class CaptureOutputSurfaceForCaptureProcessor {
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "CaptureOutputSurface";
    private static final long UNSPECIFIED_TIMESTAMP = -1;
    @GuardedBy("mLock")
    private final ImageWriter mImageWriter;
    @GuardedBy("mLock")
    private final ImageReaderProxy mIntermediateImageReader;
    @GuardedBy("mLock")
    private boolean mIsClosed;
    private final Object mLock = new Object();
    private final boolean mNeedIntermediaSurface;
    private final boolean mNeedOverrideTimestamp;
    long mOutputImageTimeStamp;
    @NonNull
    private final Surface mOutputSurface;

    @RequiresApi(23)
    public static final class Api23Impl {
        private Api23Impl() {
        }

        public static void setImageTimestamp(@NonNull Image image, long j) {
            image.setTimestamp(j);
        }
    }

    @RequiresApi(29)
    public static final class ImageWriterCompat {
        private ImageWriterCompat() {
        }

        public static void close(ImageWriter imageWriter) {
            imageWriter.close();
        }

        @NonNull
        public static ImageWriter newInstance(@NonNull Surface surface, int i, int i2) {
            return ImageWriter.newInstance(surface, i, i2);
        }

        public static void queueInputImage(@NonNull ImageWriter imageWriter, @NonNull Image image) {
            imageWriter.queueInputImage(image);
        }
    }

    public CaptureOutputSurfaceForCaptureProcessor(@NonNull Surface surface, @NonNull Size size, boolean z) {
        boolean z2 = false;
        this.mIsClosed = false;
        this.mOutputImageTimeStamp = -1;
        this.mNeedOverrideTimestamp = z;
        z2 = (DeviceQuirks.get(CaptureOutputSurfaceOccupiedQuirk.class) != null || z) ? true : z2;
        this.mNeedIntermediaSurface = z2;
        if (Build.VERSION.SDK_INT < 29 || !z2) {
            this.mOutputSurface = surface;
            this.mIntermediateImageReader = null;
            this.mImageWriter = null;
            return;
        }
        Logger.d(TAG, "Enabling intermediate surface");
        ImageReaderProxy createIsolatedReader = ImageReaderProxys.createIsolatedReader(size.getWidth(), size.getHeight(), 35, 2);
        this.mIntermediateImageReader = createIsolatedReader;
        this.mOutputSurface = createIsolatedReader.getSurface();
        this.mImageWriter = ImageWriterCompat.newInstance(surface, 2, 35);
        createIsolatedReader.setOnImageAvailableListener(new v2(this, 0), CameraXExecutors.directExecutor());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$new$0(androidx.camera.core.impl.ImageReaderProxy r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mIsClosed     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r7 = move-exception
            goto L_0x002d
        L_0x000b:
            androidx.camera.core.ImageProxy r7 = r7.acquireNextImage()     // Catch:{ all -> 0x0009 }
            if (r7 == 0) goto L_0x002b
            android.media.Image r7 = r7.getImage()     // Catch:{ all -> 0x0009 }
            if (r7 == 0) goto L_0x002b
            boolean r1 = r6.mNeedOverrideTimestamp     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x0026
            long r1 = r6.mOutputImageTimeStamp     // Catch:{ all -> 0x0009 }
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0026
            androidx.camera.extensions.internal.compat.workaround.CaptureOutputSurfaceForCaptureProcessor.Api23Impl.setImageTimestamp(r7, r1)     // Catch:{ all -> 0x0009 }
        L_0x0026:
            android.media.ImageWriter r1 = r6.mImageWriter     // Catch:{ all -> 0x0009 }
            androidx.camera.extensions.internal.compat.workaround.CaptureOutputSurfaceForCaptureProcessor.ImageWriterCompat.queueInputImage(r1, r7)     // Catch:{ all -> 0x0009 }
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.compat.workaround.CaptureOutputSurfaceForCaptureProcessor.lambda$new$0(androidx.camera.core.impl.ImageReaderProxy):void");
    }

    public void close() {
        synchronized (this.mLock) {
            try {
                this.mIsClosed = true;
                if (Build.VERSION.SDK_INT >= 29 && this.mNeedIntermediaSurface) {
                    this.mIntermediateImageReader.clearOnImageAvailableListener();
                    this.mIntermediateImageReader.close();
                    ImageWriterCompat.close(this.mImageWriter);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public Surface getSurface() {
        return this.mOutputSurface;
    }

    public void setOutputImageTimestamp(long j) {
        if (this.mNeedOverrideTimestamp) {
            this.mOutputImageTimeStamp = j;
        }
    }
}
