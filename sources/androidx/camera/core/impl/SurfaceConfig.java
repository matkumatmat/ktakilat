package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.internal.utils.SizeUtil;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SurfaceConfig {
    public static final long DEFAULT_STREAM_USE_CASE_VALUE = 0;

    public enum ConfigSize {
        VGA(0),
        s720p(1),
        PREVIEW(2),
        s1440p(3),
        RECORD(4),
        MAXIMUM(5),
        ULTRA_MAXIMUM(6),
        NOT_SUPPORT(7);
        
        final int mId;

        private ConfigSize(int i) {
            this.mId = i;
        }

        public int getId() {
            return this.mId;
        }
    }

    public enum ConfigType {
        PRIV,
        YUV,
        JPEG,
        JPEG_R,
        RAW
    }

    @NonNull
    public static SurfaceConfig create(@NonNull ConfigType configType, @NonNull ConfigSize configSize) {
        return new AutoValue_SurfaceConfig(configType, configSize, 0);
    }

    @NonNull
    public static ConfigType getConfigType(int i) {
        if (i == 35) {
            return ConfigType.YUV;
        }
        if (i == 256) {
            return ConfigType.JPEG;
        }
        if (i == 4101) {
            return ConfigType.JPEG_R;
        }
        if (i == 32) {
            return ConfigType.RAW;
        }
        return ConfigType.PRIV;
    }

    @NonNull
    public static SurfaceConfig transformSurfaceConfig(int i, int i2, @NonNull Size size, @NonNull SurfaceSizeDefinition surfaceSizeDefinition) {
        ConfigType configType = getConfigType(i2);
        ConfigSize configSize = ConfigSize.NOT_SUPPORT;
        int area = SizeUtil.getArea(size);
        if (i == 1) {
            if (area <= SizeUtil.getArea(surfaceSizeDefinition.getS720pSize(i2))) {
                configSize = ConfigSize.s720p;
            } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getS1440pSize(i2))) {
                configSize = ConfigSize.s1440p;
            }
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getAnalysisSize())) {
            configSize = ConfigSize.VGA;
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getPreviewSize())) {
            configSize = ConfigSize.PREVIEW;
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getRecordSize())) {
            configSize = ConfigSize.RECORD;
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getMaximumSize(i2))) {
            configSize = ConfigSize.MAXIMUM;
        } else {
            Size ultraMaximumSize = surfaceSizeDefinition.getUltraMaximumSize(i2);
            if (ultraMaximumSize != null && area <= SizeUtil.getArea(ultraMaximumSize)) {
                configSize = ConfigSize.ULTRA_MAXIMUM;
            }
        }
        return create(configType, configSize);
    }

    @NonNull
    public abstract ConfigSize getConfigSize();

    @NonNull
    public abstract ConfigType getConfigType();

    public abstract long getStreamUseCase();

    public final boolean isSupported(@NonNull SurfaceConfig surfaceConfig) {
        ConfigType configType = surfaceConfig.getConfigType();
        if (surfaceConfig.getConfigSize().getId() > getConfigSize().getId() || configType != getConfigType()) {
            return false;
        }
        return true;
    }

    @NonNull
    public static SurfaceConfig create(@NonNull ConfigType configType, @NonNull ConfigSize configSize, long j) {
        return new AutoValue_SurfaceConfig(configType, configSize, j);
    }
}
