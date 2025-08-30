package androidx.camera.extensions.internal.sessionprocessor;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

final class AutoValue_ImageReaderOutputConfig extends ImageReaderOutputConfig {
    private final int id;
    private final int imageFormat;
    private final int maxImages;
    private final String physicalCameraId;
    private final Size size;
    private final int surfaceGroupId;
    private final List<Camera2OutputConfig> surfaceSharingOutputConfigs;

    public AutoValue_ImageReaderOutputConfig(int i, int i2, @Nullable String str, List<Camera2OutputConfig> list, Size size2, int i3, int i4) {
        this.id = i;
        this.surfaceGroupId = i2;
        this.physicalCameraId = str;
        if (list != null) {
            this.surfaceSharingOutputConfigs = list;
            if (size2 != null) {
                this.size = size2;
                this.imageFormat = i3;
                this.maxImages = i4;
                return;
            }
            throw new NullPointerException("Null size");
        }
        throw new NullPointerException("Null surfaceSharingOutputConfigs");
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageReaderOutputConfig)) {
            return false;
        }
        ImageReaderOutputConfig imageReaderOutputConfig = (ImageReaderOutputConfig) obj;
        if (this.id == imageReaderOutputConfig.getId() && this.surfaceGroupId == imageReaderOutputConfig.getSurfaceGroupId() && ((str = this.physicalCameraId) != null ? str.equals(imageReaderOutputConfig.getPhysicalCameraId()) : imageReaderOutputConfig.getPhysicalCameraId() == null) && this.surfaceSharingOutputConfigs.equals(imageReaderOutputConfig.getSurfaceSharingOutputConfigs()) && this.size.equals(imageReaderOutputConfig.getSize()) && this.imageFormat == imageReaderOutputConfig.getImageFormat() && this.maxImages == imageReaderOutputConfig.getMaxImages()) {
            return true;
        }
        return false;
    }

    public int getId() {
        return this.id;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public int getMaxImages() {
        return this.maxImages;
    }

    @Nullable
    public String getPhysicalCameraId() {
        return this.physicalCameraId;
    }

    @NonNull
    public Size getSize() {
        return this.size;
    }

    public int getSurfaceGroupId() {
        return this.surfaceGroupId;
    }

    @NonNull
    public List<Camera2OutputConfig> getSurfaceSharingOutputConfigs() {
        return this.surfaceSharingOutputConfigs;
    }

    public int hashCode() {
        int i;
        int i2 = (((this.id ^ 1000003) * 1000003) ^ this.surfaceGroupId) * 1000003;
        String str = this.physicalCameraId;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return ((((((((i2 ^ i) * 1000003) ^ this.surfaceSharingOutputConfigs.hashCode()) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.imageFormat) * 1000003) ^ this.maxImages;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImageReaderOutputConfig{id=");
        sb.append(this.id);
        sb.append(", surfaceGroupId=");
        sb.append(this.surfaceGroupId);
        sb.append(", physicalCameraId=");
        sb.append(this.physicalCameraId);
        sb.append(", surfaceSharingOutputConfigs=");
        sb.append(this.surfaceSharingOutputConfigs);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", imageFormat=");
        sb.append(this.imageFormat);
        sb.append(", maxImages=");
        return ba.q(sb, "}", this.maxImages);
    }
}
