package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.OutputSurfaceConfiguration;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.extensions.CameraExtensionsControl;
import androidx.camera.extensions.CameraExtensionsInfo;
import androidx.camera.extensions.internal.ExtensionsUtils;
import androidx.camera.extensions.internal.RequestOptionConfig;
import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

abstract class SessionProcessorBase implements SessionProcessor, CameraExtensionsInfo, CameraExtensionsControl {
    protected static final int EXTENSION_STRENGTH_UNKNOWN = -1;
    private static final String TAG = "SessionProcessorBase";
    private String mCameraId;
    @GuardedBy("mLock")
    protected int mExtensionStrength = -1;
    @Nullable
    private HandlerThread mImageReaderHandlerThread;
    @GuardedBy("mLock")
    @NonNull
    private final Map<Integer, ImageReader> mImageReaderMap = new HashMap();
    protected final Object mLock = new Object();
    @GuardedBy("mLock")
    private final Map<Integer, Camera2OutputConfig> mOutputConfigMap = new HashMap();
    @NonNull
    private final Set<Integer> mSupportedCameraOperations;
    @GuardedBy("mLock")
    private final List<DeferrableSurface> mSurfacesList = new ArrayList();

    public static class ImageRefHolder implements ImageReference {
        private final Image mImage;
        private final Object mImageLock = new Object();
        private int mRefCount = 1;

        public ImageRefHolder(@NonNull Image image) {
            this.mImage = image;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean decrement() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.mImageLock
                monitor-enter(r0)
                int r1 = r3.mRefCount     // Catch:{ all -> 0x000a }
                if (r1 > 0) goto L_0x000c
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                r0 = 0
                return r0
            L_0x000a:
                r1 = move-exception
                goto L_0x0019
            L_0x000c:
                r2 = 1
                int r1 = r1 - r2
                r3.mRefCount = r1     // Catch:{ all -> 0x000a }
                if (r1 > 0) goto L_0x0017
                android.media.Image r1 = r3.mImage     // Catch:{ all -> 0x000a }
                r1.close()     // Catch:{ all -> 0x000a }
            L_0x0017:
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                return r2
            L_0x0019:
                monitor-exit(r0)     // Catch:{ all -> 0x000a }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.SessionProcessorBase.ImageRefHolder.decrement():boolean");
        }

        @Nullable
        public Image get() {
            return this.mImage;
        }

        public boolean increment() {
            synchronized (this.mImageLock) {
                try {
                    int i = this.mRefCount;
                    if (i <= 0) {
                        return false;
                    }
                    this.mRefCount = i + 1;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public SessionProcessorBase(@NonNull List<CaptureRequest.Key> list) {
        this.mSupportedCameraOperations = getSupportedCameraOperations(list);
    }

    @NonNull
    private static SessionProcessorSurface createOutputConfigSurface(@NonNull Camera2OutputConfig camera2OutputConfig, Map<Integer, ImageReader> map) {
        if (camera2OutputConfig instanceof SurfaceOutputConfig) {
            return new SessionProcessorSurface(((SurfaceOutputConfig) camera2OutputConfig).getSurface(), camera2OutputConfig.getId());
        }
        if (camera2OutputConfig instanceof ImageReaderOutputConfig) {
            ImageReaderOutputConfig imageReaderOutputConfig = (ImageReaderOutputConfig) camera2OutputConfig;
            ImageReader newInstance = ImageReader.newInstance(imageReaderOutputConfig.getSize().getWidth(), imageReaderOutputConfig.getSize().getHeight(), imageReaderOutputConfig.getImageFormat(), imageReaderOutputConfig.getMaxImages());
            map.put(Integer.valueOf(camera2OutputConfig.getId()), newInstance);
            SessionProcessorSurface sessionProcessorSurface = new SessionProcessorSurface(newInstance.getSurface(), camera2OutputConfig.getId());
            sessionProcessorSurface.getTerminationFuture().addListener(new e(newInstance), CameraXExecutors.directExecutor());
            return sessionProcessorSurface;
        } else if (camera2OutputConfig instanceof MultiResolutionImageReaderOutputConfig) {
            throw new UnsupportedOperationException("MultiResolutionImageReader not supported yet");
        } else {
            throw new UnsupportedOperationException("Unsupported Camera2OutputConfig:" + camera2OutputConfig);
        }
    }

    private Set<Integer> getSupportedCameraOperations(@NonNull List<CaptureRequest.Key> list) {
        HashSet hashSet = new HashSet();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            if (list.contains(CaptureRequest.CONTROL_ZOOM_RATIO) || list.contains(CaptureRequest.SCALER_CROP_REGION)) {
                hashSet.add(0);
            }
        } else if (list.contains(CaptureRequest.SCALER_CROP_REGION)) {
            hashSet.add(0);
        }
        if (list.containsAll(Arrays.asList(new CaptureRequest.Key[]{CaptureRequest.CONTROL_AF_TRIGGER, CaptureRequest.CONTROL_AF_MODE}))) {
            hashSet.add(1);
        }
        if (list.contains(CaptureRequest.CONTROL_AF_REGIONS)) {
            hashSet.add(2);
        }
        if (list.contains(CaptureRequest.CONTROL_AE_REGIONS)) {
            hashSet.add(3);
        }
        if (list.contains(CaptureRequest.CONTROL_AWB_REGIONS)) {
            hashSet.add(4);
        }
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
        if (list.containsAll(Arrays.asList(new CaptureRequest.Key[]{key, CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER}))) {
            hashSet.add(5);
        }
        if (list.containsAll(Arrays.asList(new CaptureRequest.Key[]{key, CaptureRequest.FLASH_MODE}))) {
            hashSet.add(6);
        }
        if (list.contains(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION)) {
            hashSet.add(7);
        }
        if (i >= 34 && list.contains(CaptureRequest.EXTENSION_STRENGTH)) {
            hashSet.add(8);
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setImageProcessor$1(ImageProcessor imageProcessor, int i, String str, ImageReader imageReader) {
        try {
            Image acquireNextImage = imageReader.acquireNextImage();
            ImageProcessor imageProcessor2 = imageProcessor;
            int i2 = i;
            imageProcessor2.onNextImageAvailable(i2, acquireNextImage.getTimestamp(), new ImageRefHolder(acquireNextImage), str);
        } catch (IllegalStateException e) {
            Logger.e(TAG, "Failed to acquire next image.", e);
        }
    }

    public final void deInitSession() {
        Logger.e(TAG, "deInitSession: cameraId=" + this.mCameraId);
        deInitSessionInternal();
        synchronized (this.mLock) {
            try {
                for (DeferrableSurface close : this.mSurfacesList) {
                    close.close();
                }
                this.mSurfacesList.clear();
                this.mImageReaderMap.clear();
                this.mOutputConfigMap.clear();
                this.mExtensionStrength = -1;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        HandlerThread handlerThread = this.mImageReaderHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mImageReaderHandlerThread = null;
        }
    }

    public abstract void deInitSessionInternal();

    public /* synthetic */ LiveData getCurrentExtensionMode() {
        return j2.a(this);
    }

    public /* synthetic */ LiveData getExtensionStrength() {
        return j2.b(this);
    }

    public /* synthetic */ Pair getRealtimeCaptureLatency() {
        return oe.a(this);
    }

    public /* synthetic */ Map getSupportedPostviewSize(Size size) {
        return oe.c(this, size);
    }

    @NonNull
    public final SessionConfig initSession(@NonNull CameraInfo cameraInfo, @NonNull OutputSurfaceConfiguration outputSurfaceConfiguration) {
        CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) cameraInfo;
        Camera2SessionConfig initSessionInternal = initSessionInternal(cameraInfoInternal.getCameraId(), ExtensionsUtils.getCameraCharacteristicsMap(cameraInfoInternal), outputSurfaceConfiguration);
        SessionConfig.Builder builder = new SessionConfig.Builder();
        synchronized (this.mLock) {
            try {
                for (Camera2OutputConfig next : initSessionInternal.getOutputConfigs()) {
                    SessionProcessorSurface createOutputConfigSurface = createOutputConfigSurface(next, this.mImageReaderMap);
                    this.mSurfacesList.add(createOutputConfigSurface);
                    this.mOutputConfigMap.put(Integer.valueOf(next.getId()), next);
                    SessionConfig.OutputConfig.Builder surfaceGroupId = SessionConfig.OutputConfig.builder(createOutputConfigSurface).setPhysicalCameraId(next.getPhysicalCameraId()).setSurfaceGroupId(next.getSurfaceGroupId());
                    List<Camera2OutputConfig> surfaceSharingOutputConfigs = next.getSurfaceSharingOutputConfigs();
                    if (surfaceSharingOutputConfigs != null && !surfaceSharingOutputConfigs.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (Camera2OutputConfig next2 : surfaceSharingOutputConfigs) {
                            this.mOutputConfigMap.put(Integer.valueOf(next2.getId()), next2);
                            arrayList.add(createOutputConfigSurface(next2, this.mImageReaderMap));
                        }
                        surfaceGroupId.setSharedSurfaces(arrayList);
                    }
                    builder.addOutputConfig(surfaceGroupId.build());
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        RequestOptionConfig.Builder builder2 = new RequestOptionConfig.Builder();
        for (CaptureRequest.Key next3 : initSessionInternal.getSessionParameters().keySet()) {
            builder2.setCaptureRequestOption(next3, initSessionInternal.getSessionParameters().get(next3));
        }
        builder.setImplementationOptions(builder2.build());
        builder.setTemplateType(initSessionInternal.getSessionTemplateId());
        builder.setSessionType(initSessionInternal.getSessionType());
        HandlerThread handlerThread = new HandlerThread("CameraX-extensions_image_reader");
        this.mImageReaderHandlerThread = handlerThread;
        handlerThread.start();
        this.mCameraId = cameraInfoInternal.getCameraId();
        Logger.d(TAG, "initSession: cameraId=" + this.mCameraId);
        return builder.build();
    }

    @NonNull
    public abstract Camera2SessionConfig initSessionInternal(@NonNull String str, @NonNull Map<String, CameraCharacteristics> map, @NonNull OutputSurfaceConfiguration outputSurfaceConfiguration);

    public /* synthetic */ boolean isCurrentExtensionModeAvailable() {
        return j2.c(this);
    }

    public /* synthetic */ boolean isExtensionStrengthAvailable() {
        return j2.d(this);
    }

    public /* synthetic */ void setExtensionStrength(int i) {
        i2.a(this, i);
    }

    public void setImageProcessor(int i, @NonNull ImageProcessor imageProcessor) {
        ImageReader imageReader;
        String str;
        synchronized (this.mLock) {
            imageReader = this.mImageReaderMap.get(Integer.valueOf(i));
            Camera2OutputConfig camera2OutputConfig = this.mOutputConfigMap.get(Integer.valueOf(i));
            if (camera2OutputConfig == null) {
                str = null;
            } else {
                str = camera2OutputConfig.getPhysicalCameraId();
            }
        }
        if (imageReader != null) {
            imageReader.setOnImageAvailableListener(new d(imageProcessor, i, str), new Handler(this.mImageReaderHandlerThread.getLooper()));
        }
    }

    public /* synthetic */ int startTrigger(Config config, TagBundle tagBundle, SessionProcessor.CaptureCallback captureCallback) {
        return oe.d(this, config, tagBundle, captureCallback);
    }

    @NonNull
    public Set<Integer> getSupportedCameraOperations() {
        return this.mSupportedCameraOperations;
    }
}
