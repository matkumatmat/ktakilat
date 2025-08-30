package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.processing.Edge;

final class AutoValue_CaptureNode_In extends CaptureNode.In {
    private final Edge<TakePictureManager.CaptureError> errorEdge;
    private final ImageReaderProxyProvider imageReaderProxyProvider;
    private final int inputFormat;
    private final int outputFormat;
    private final int postviewImageFormat;
    private final Size postviewSize;
    private final Edge<ProcessingRequest> requestEdge;
    private final Size size;
    private final boolean virtualCamera;

    public AutoValue_CaptureNode_In(Size size2, int i, int i2, boolean z, @Nullable ImageReaderProxyProvider imageReaderProxyProvider2, @Nullable Size size3, int i3, Edge<ProcessingRequest> edge, Edge<TakePictureManager.CaptureError> edge2) {
        if (size2 != null) {
            this.size = size2;
            this.inputFormat = i;
            this.outputFormat = i2;
            this.virtualCamera = z;
            this.imageReaderProxyProvider = imageReaderProxyProvider2;
            this.postviewSize = size3;
            this.postviewImageFormat = i3;
            if (edge != null) {
                this.requestEdge = edge;
                if (edge2 != null) {
                    this.errorEdge = edge2;
                    return;
                }
                throw new NullPointerException("Null errorEdge");
            }
            throw new NullPointerException("Null requestEdge");
        }
        throw new NullPointerException("Null size");
    }

    public boolean equals(Object obj) {
        ImageReaderProxyProvider imageReaderProxyProvider2;
        Size size2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptureNode.In)) {
            return false;
        }
        CaptureNode.In in = (CaptureNode.In) obj;
        if (!this.size.equals(in.getSize()) || this.inputFormat != in.getInputFormat() || this.outputFormat != in.getOutputFormat() || this.virtualCamera != in.isVirtualCamera() || ((imageReaderProxyProvider2 = this.imageReaderProxyProvider) != null ? !imageReaderProxyProvider2.equals(in.getImageReaderProxyProvider()) : in.getImageReaderProxyProvider() != null) || ((size2 = this.postviewSize) != null ? !size2.equals(in.getPostviewSize()) : in.getPostviewSize() != null) || this.postviewImageFormat != in.getPostviewImageFormat() || !this.requestEdge.equals(in.getRequestEdge()) || !this.errorEdge.equals(in.getErrorEdge())) {
            return false;
        }
        return true;
    }

    @NonNull
    public Edge<TakePictureManager.CaptureError> getErrorEdge() {
        return this.errorEdge;
    }

    @Nullable
    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return this.imageReaderProxyProvider;
    }

    public int getInputFormat() {
        return this.inputFormat;
    }

    public int getOutputFormat() {
        return this.outputFormat;
    }

    public int getPostviewImageFormat() {
        return this.postviewImageFormat;
    }

    @Nullable
    public Size getPostviewSize() {
        return this.postviewSize;
    }

    @NonNull
    public Edge<ProcessingRequest> getRequestEdge() {
        return this.requestEdge;
    }

    public Size getSize() {
        return this.size;
    }

    public int hashCode() {
        int i;
        int i2;
        int hashCode = (((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat) * 1000003;
        if (this.virtualCamera) {
            i = 1231;
        } else {
            i = 1237;
        }
        int i3 = (hashCode ^ i) * 1000003;
        ImageReaderProxyProvider imageReaderProxyProvider2 = this.imageReaderProxyProvider;
        int i4 = 0;
        if (imageReaderProxyProvider2 == null) {
            i2 = 0;
        } else {
            i2 = imageReaderProxyProvider2.hashCode();
        }
        int i5 = (i3 ^ i2) * 1000003;
        Size size2 = this.postviewSize;
        if (size2 != null) {
            i4 = size2.hashCode();
        }
        return ((((((i5 ^ i4) * 1000003) ^ this.postviewImageFormat) * 1000003) ^ this.requestEdge.hashCode()) * 1000003) ^ this.errorEdge.hashCode();
    }

    public boolean isVirtualCamera() {
        return this.virtualCamera;
    }

    public String toString() {
        return "In{size=" + this.size + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + ", virtualCamera=" + this.virtualCamera + ", imageReaderProxyProvider=" + this.imageReaderProxyProvider + ", postviewSize=" + this.postviewSize + ", postviewImageFormat=" + this.postviewImageFormat + ", requestEdge=" + this.requestEdge + ", errorEdge=" + this.errorEdge + "}";
    }
}
