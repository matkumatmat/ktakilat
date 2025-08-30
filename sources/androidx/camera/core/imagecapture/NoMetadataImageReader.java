package androidx.camera.core.imagecapture;

import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.streamsharing.VirtualCameraCaptureResult;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

public class NoMetadataImageReader implements ImageReaderProxy {
    @Nullable
    private ProcessingRequest mPendingRequest;
    @NonNull
    private final ImageReaderProxy mWrappedImageReader;

    public NoMetadataImageReader(@NonNull ImageReaderProxy imageReaderProxy) {
        this.mWrappedImageReader = imageReaderProxy;
    }

    @Nullable
    private ImageProxy createImageProxyWithEmptyMetadata(@Nullable ImageProxy imageProxy) {
        TagBundle tagBundle;
        if (imageProxy == null) {
            return null;
        }
        if (this.mPendingRequest == null) {
            tagBundle = TagBundle.emptyBundle();
        } else {
            tagBundle = TagBundle.create(new Pair(this.mPendingRequest.getTagBundleKey(), this.mPendingRequest.getStageIds().get(0)));
        }
        this.mPendingRequest = null;
        return new SettableImageProxy(imageProxy, new Size(imageProxy.getWidth(), imageProxy.getHeight()), new CameraCaptureResultImageInfo(new VirtualCameraCaptureResult(tagBundle, imageProxy.getImageInfo().getTimestamp())));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnImageAvailableListener$0(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, ImageReaderProxy imageReaderProxy) {
        onImageAvailableListener.onImageAvailable(this);
    }

    public void acceptProcessingRequest(@NonNull ProcessingRequest processingRequest) {
        boolean z;
        if (this.mPendingRequest == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Pending request should be null");
        this.mPendingRequest = processingRequest;
    }

    @Nullable
    public ImageProxy acquireLatestImage() {
        return createImageProxyWithEmptyMetadata(this.mWrappedImageReader.acquireLatestImage());
    }

    @Nullable
    public ImageProxy acquireNextImage() {
        return createImageProxyWithEmptyMetadata(this.mWrappedImageReader.acquireNextImage());
    }

    public void clearOnImageAvailableListener() {
        this.mWrappedImageReader.clearOnImageAvailableListener();
    }

    public void clearProcessingRequest() {
        this.mPendingRequest = null;
    }

    public void close() {
        this.mWrappedImageReader.close();
    }

    public int getHeight() {
        return this.mWrappedImageReader.getHeight();
    }

    public int getImageFormat() {
        return this.mWrappedImageReader.getImageFormat();
    }

    public int getMaxImages() {
        return this.mWrappedImageReader.getMaxImages();
    }

    @Nullable
    public Surface getSurface() {
        return this.mWrappedImageReader.getSurface();
    }

    public int getWidth() {
        return this.mWrappedImageReader.getWidth();
    }

    public void setOnImageAvailableListener(@NonNull ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, @NonNull Executor executor) {
        this.mWrappedImageReader.setOnImageAvailableListener(new zc(this, onImageAvailableListener, 0), executor);
    }
}
