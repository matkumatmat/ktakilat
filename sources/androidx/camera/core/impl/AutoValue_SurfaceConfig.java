package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.SurfaceConfig;

final class AutoValue_SurfaceConfig extends SurfaceConfig {
    private final SurfaceConfig.ConfigSize configSize;
    private final SurfaceConfig.ConfigType configType;
    private final long streamUseCase;

    public AutoValue_SurfaceConfig(SurfaceConfig.ConfigType configType2, SurfaceConfig.ConfigSize configSize2, long j) {
        if (configType2 != null) {
            this.configType = configType2;
            if (configSize2 != null) {
                this.configSize = configSize2;
                this.streamUseCase = j;
                return;
            }
            throw new NullPointerException("Null configSize");
        }
        throw new NullPointerException("Null configType");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceConfig)) {
            return false;
        }
        SurfaceConfig surfaceConfig = (SurfaceConfig) obj;
        if (!this.configType.equals(surfaceConfig.getConfigType()) || !this.configSize.equals(surfaceConfig.getConfigSize()) || this.streamUseCase != surfaceConfig.getStreamUseCase()) {
            return false;
        }
        return true;
    }

    @NonNull
    public SurfaceConfig.ConfigSize getConfigSize() {
        return this.configSize;
    }

    @NonNull
    public SurfaceConfig.ConfigType getConfigType() {
        return this.configType;
    }

    public long getStreamUseCase() {
        return this.streamUseCase;
    }

    public int hashCode() {
        long j = this.streamUseCase;
        return ((((this.configType.hashCode() ^ 1000003) * 1000003) ^ this.configSize.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SurfaceConfig{configType=");
        sb.append(this.configType);
        sb.append(", configSize=");
        sb.append(this.configSize);
        sb.append(", streamUseCase=");
        return ba.p(sb, this.streamUseCase, "}");
    }
}
