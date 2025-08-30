package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.Objects;

@RequiresApi(28)
class OutputConfigurationCompatApi28Impl extends OutputConfigurationCompatApi26Impl {

    public static final class OutputConfigurationParamsApi28 {
        long mDynamicRangeProfile = 1;
        @NonNull
        final OutputConfiguration mOutputConfiguration;

        public OutputConfigurationParamsApi28(@NonNull OutputConfiguration outputConfiguration) {
            this.mOutputConfiguration = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi28)) {
                return false;
            }
            OutputConfigurationParamsApi28 outputConfigurationParamsApi28 = (OutputConfigurationParamsApi28) obj;
            if (!Objects.equals(this.mOutputConfiguration, outputConfigurationParamsApi28.mOutputConfiguration) || this.mDynamicRangeProfile != outputConfigurationParamsApi28.mDynamicRangeProfile) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.mOutputConfiguration.hashCode() ^ 31;
            int i = (hashCode << 5) - hashCode;
            long j = this.mDynamicRangeProfile;
            return ((int) (j ^ (j >>> 32))) ^ i;
        }
    }

    public OutputConfigurationCompatApi28Impl(@NonNull Surface surface) {
        this((Object) new OutputConfigurationParamsApi28(new OutputConfiguration(surface)));
    }

    @RequiresApi(28)
    public static OutputConfigurationCompatApi28Impl wrap(@NonNull OutputConfiguration outputConfiguration) {
        return new OutputConfigurationCompatApi28Impl((Object) new OutputConfigurationParamsApi28(outputConfiguration));
    }

    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi28) this.mObject).mDynamicRangeProfile;
    }

    public int getMaxSharedSurfaceCount() {
        return ((OutputConfiguration) getOutputConfiguration()).getMaxSharedSurfaceCount();
    }

    @NonNull
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi28);
        return ((OutputConfigurationParamsApi28) this.mObject).mOutputConfiguration;
    }

    @Nullable
    public String getPhysicalCameraId() {
        return null;
    }

    public void removeSurface(@NonNull Surface surface) {
        ((OutputConfiguration) getOutputConfiguration()).removeSurface(surface);
    }

    public void setDynamicRangeProfile(long j) {
        ((OutputConfigurationParamsApi28) this.mObject).mDynamicRangeProfile = j;
    }

    public void setPhysicalCameraId(@Nullable String str) {
        ((OutputConfiguration) getOutputConfiguration()).setPhysicalCameraId(str);
    }

    public OutputConfigurationCompatApi28Impl(int i, @NonNull Surface surface) {
        this((Object) new OutputConfigurationParamsApi28(new OutputConfiguration(i, surface)));
    }

    public OutputConfigurationCompatApi28Impl(@NonNull Object obj) {
        super(obj);
    }
}
