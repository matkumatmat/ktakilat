package androidx.camera.extensions.internal.sessionprocessor;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

final class AutoValue_SurfaceOutputConfig extends SurfaceOutputConfig {
    private final int id;
    private final String physicalCameraId;
    private final Surface surface;
    private final int surfaceGroupId;
    private final List<Camera2OutputConfig> surfaceSharingOutputConfigs;

    public AutoValue_SurfaceOutputConfig(int i, int i2, @Nullable String str, List<Camera2OutputConfig> list, Surface surface2) {
        this.id = i;
        this.surfaceGroupId = i2;
        this.physicalCameraId = str;
        if (list != null) {
            this.surfaceSharingOutputConfigs = list;
            if (surface2 != null) {
                this.surface = surface2;
                return;
            }
            throw new NullPointerException("Null surface");
        }
        throw new NullPointerException("Null surfaceSharingOutputConfigs");
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceOutputConfig)) {
            return false;
        }
        SurfaceOutputConfig surfaceOutputConfig = (SurfaceOutputConfig) obj;
        if (this.id != surfaceOutputConfig.getId() || this.surfaceGroupId != surfaceOutputConfig.getSurfaceGroupId() || ((str = this.physicalCameraId) != null ? !str.equals(surfaceOutputConfig.getPhysicalCameraId()) : surfaceOutputConfig.getPhysicalCameraId() != null) || !this.surfaceSharingOutputConfigs.equals(surfaceOutputConfig.getSurfaceSharingOutputConfigs()) || !this.surface.equals(surfaceOutputConfig.getSurface())) {
            return false;
        }
        return true;
    }

    public int getId() {
        return this.id;
    }

    @Nullable
    public String getPhysicalCameraId() {
        return this.physicalCameraId;
    }

    @NonNull
    public Surface getSurface() {
        return this.surface;
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
        return ((((i2 ^ i) * 1000003) ^ this.surfaceSharingOutputConfigs.hashCode()) * 1000003) ^ this.surface.hashCode();
    }

    public String toString() {
        return "SurfaceOutputConfig{id=" + this.id + ", surfaceGroupId=" + this.surfaceGroupId + ", physicalCameraId=" + this.physicalCameraId + ", surfaceSharingOutputConfigs=" + this.surfaceSharingOutputConfigs + ", surface=" + this.surface + "}";
    }
}
