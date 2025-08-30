package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CaptureBundles;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.core.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public class ImagePipeline {
    static final ExifRotationAvailability EXIF_ROTATION_AVAILABILITY = new ExifRotationAvailability();
    static final byte JPEG_QUALITY_MAX_QUALITY = 100;
    static final byte JPEG_QUALITY_MIN_LATENCY = 95;
    private static int sNextRequestId;
    @NonNull
    private final CaptureConfig mCaptureConfig;
    @NonNull
    private final CaptureNode mCaptureNode;
    @NonNull
    private final CaptureNode.In mPipelineIn;
    @NonNull
    private final ProcessingNode mProcessingNode;
    @NonNull
    private final ImageCaptureConfig mUseCaseConfig;

    @VisibleForTesting
    @MainThread
    public ImagePipeline(@NonNull ImageCaptureConfig imageCaptureConfig, @NonNull Size size) {
        this(imageCaptureConfig, size, (CameraEffect) null, false, (Size) null, 35);
    }

    private CameraRequest createCameraRequest(int i, @NonNull CaptureBundle captureBundle, @NonNull TakePictureRequest takePictureRequest, @NonNull TakePictureCallback takePictureCallback) {
        ArrayList arrayList = new ArrayList();
        String valueOf = String.valueOf(captureBundle.hashCode());
        List<CaptureStage> captureStages = captureBundle.getCaptureStages();
        Objects.requireNonNull(captureStages);
        for (CaptureStage captureStage : captureStages) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.mCaptureConfig.getTemplateType());
            builder.addImplementationOptions(this.mCaptureConfig.getImplementationOptions());
            builder.addAllCameraCaptureCallbacks(takePictureRequest.getSessionConfigCameraCaptureCallbacks());
            builder.addSurface(this.mPipelineIn.getSurface());
            builder.setPostviewEnabled(shouldEnablePostview());
            if (ImageUtil.isJpegFormats(this.mPipelineIn.getInputFormat())) {
                if (EXIF_ROTATION_AVAILABILITY.isRotationOptionSupported()) {
                    builder.addImplementationOption(CaptureConfig.OPTION_ROTATION, Integer.valueOf(takePictureRequest.getRotationDegrees()));
                }
                builder.addImplementationOption(CaptureConfig.OPTION_JPEG_QUALITY, Integer.valueOf(getCameraRequestJpegQuality(takePictureRequest)));
            }
            builder.addImplementationOptions(captureStage.getCaptureConfig().getImplementationOptions());
            builder.addTag(valueOf, Integer.valueOf(captureStage.getId()));
            builder.setId(i);
            builder.addCameraCaptureCallback(this.mPipelineIn.getCameraCaptureCallback());
            arrayList.add(builder.build());
        }
        return new CameraRequest(arrayList, takePictureCallback);
    }

    @NonNull
    private CaptureBundle createCaptureBundle() {
        CaptureBundle captureBundle = this.mUseCaseConfig.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
        Objects.requireNonNull(captureBundle);
        return captureBundle;
    }

    @NonNull
    private ProcessingRequest createProcessingRequest(int i, @NonNull CaptureBundle captureBundle, @NonNull TakePictureRequest takePictureRequest, @NonNull TakePictureCallback takePictureCallback, @NonNull ListenableFuture<Void> listenableFuture) {
        return new ProcessingRequest(captureBundle, takePictureRequest.getOutputFileOptions(), takePictureRequest.getCropRect(), takePictureRequest.getRotationDegrees(), takePictureRequest.getJpegQuality(), takePictureRequest.getSensorToBufferTransform(), takePictureCallback, listenableFuture, i);
    }

    private int getOutputFormat() {
        ImageCaptureConfig imageCaptureConfig = this.mUseCaseConfig;
        Config.Option<Integer> option = ImageCaptureConfig.OPTION_BUFFER_FORMAT;
        imageCaptureConfig.getClass();
        Integer num = (Integer) ld.g(imageCaptureConfig, option, (Object) null);
        if (num != null) {
            return num.intValue();
        }
        ImageCaptureConfig imageCaptureConfig2 = this.mUseCaseConfig;
        Config.Option<Integer> option2 = ImageInputConfig.OPTION_INPUT_FORMAT;
        imageCaptureConfig2.getClass();
        Integer num2 = (Integer) ld.g(imageCaptureConfig2, option2, (Object) null);
        if (num2 == null || num2.intValue() != 4101) {
            return 256;
        }
        return 4101;
    }

    private boolean shouldEnablePostview() {
        if (this.mPipelineIn.getPostviewSurface() != null) {
            return true;
        }
        return false;
    }

    @MainThread
    public void close() {
        Threads.checkMainThread();
        this.mCaptureNode.release();
        this.mProcessingNode.release();
    }

    @MainThread
    @NonNull
    public Pair<CameraRequest, ProcessingRequest> createRequests(@NonNull TakePictureRequest takePictureRequest, @NonNull TakePictureCallback takePictureCallback, @NonNull ListenableFuture<Void> listenableFuture) {
        Threads.checkMainThread();
        CaptureBundle createCaptureBundle = createCaptureBundle();
        int i = sNextRequestId;
        sNextRequestId = i + 1;
        return new Pair<>(createCameraRequest(i, createCaptureBundle, takePictureRequest, takePictureCallback), createProcessingRequest(i, createCaptureBundle, takePictureRequest, takePictureCallback, listenableFuture));
    }

    @NonNull
    public SessionConfig.Builder createSessionConfigBuilder(@NonNull Size size) {
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(this.mUseCaseConfig, size);
        createFrom.addNonRepeatingSurface(this.mPipelineIn.getSurface());
        if (this.mPipelineIn.getPostviewSurface() != null) {
            createFrom.setPostviewSurface(this.mPipelineIn.getPostviewSurface());
        }
        return createFrom;
    }

    @VisibleForTesting
    public boolean expectsMetadata() {
        return this.mCaptureNode.getSafeCloseImageReaderProxy().getImageReaderProxy() instanceof MetadataImageReader;
    }

    public int getCameraRequestJpegQuality(@NonNull TakePictureRequest takePictureRequest) {
        boolean z;
        if (takePictureRequest.getOnDiskCallback() != null) {
            z = true;
        } else {
            z = false;
        }
        boolean hasCropping = TransformUtils.hasCropping(takePictureRequest.getCropRect(), this.mPipelineIn.getSize());
        if (!z || !hasCropping) {
            return takePictureRequest.getJpegQuality();
        }
        if (takePictureRequest.getCaptureMode() == 0) {
            return 100;
        }
        return 95;
    }

    @MainThread
    public int getCapacity() {
        Threads.checkMainThread();
        return this.mCaptureNode.getCapacity();
    }

    @VisibleForTesting
    @NonNull
    public CaptureNode getCaptureNode() {
        return this.mCaptureNode;
    }

    @VisibleForTesting
    @Nullable
    public Size getPostviewSize() {
        return this.mPipelineIn.getPostviewSize();
    }

    @VisibleForTesting
    @NonNull
    public ProcessingNode getProcessingNode() {
        return this.mProcessingNode;
    }

    @MainThread
    public void notifyCaptureError(@NonNull TakePictureManager.CaptureError captureError) {
        Threads.checkMainThread();
        this.mPipelineIn.getErrorEdge().accept(captureError);
    }

    @MainThread
    public void setOnImageCloseListener(@NonNull ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.checkMainThread();
        this.mCaptureNode.setOnImageCloseListener(onImageCloseListener);
    }

    @MainThread
    public void submitProcessingRequest(@NonNull ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        this.mPipelineIn.getRequestEdge().accept(processingRequest);
    }

    @MainThread
    public ImagePipeline(@NonNull ImageCaptureConfig imageCaptureConfig, @NonNull Size size, @Nullable CameraEffect cameraEffect, boolean z) {
        this(imageCaptureConfig, size, cameraEffect, z, (Size) null, 35);
    }

    @MainThread
    public ImagePipeline(@NonNull ImageCaptureConfig imageCaptureConfig, @NonNull Size size, @Nullable CameraEffect cameraEffect, boolean z, @Nullable Size size2, int i) {
        CameraEffect cameraEffect2 = cameraEffect;
        Threads.checkMainThread();
        this.mUseCaseConfig = imageCaptureConfig;
        this.mCaptureConfig = CaptureConfig.Builder.createFrom(imageCaptureConfig).build();
        CaptureNode captureNode = new CaptureNode();
        this.mCaptureNode = captureNode;
        Executor ioExecutor = imageCaptureConfig.getIoExecutor(CameraXExecutors.ioExecutor());
        Objects.requireNonNull(ioExecutor);
        ProcessingNode processingNode = new ProcessingNode(ioExecutor, cameraEffect2 != null ? new InternalImageProcessor(cameraEffect2) : null);
        this.mProcessingNode = processingNode;
        CaptureNode.In of = CaptureNode.In.of(size, imageCaptureConfig.getInputFormat(), getOutputFormat(), z, imageCaptureConfig.getImageReaderProxyProvider(), size2, i);
        this.mPipelineIn = of;
        processingNode.transform(captureNode.transform(of));
    }
}
