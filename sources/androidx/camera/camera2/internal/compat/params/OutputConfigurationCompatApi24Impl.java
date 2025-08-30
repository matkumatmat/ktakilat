package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RequiresApi(24)
class OutputConfigurationCompatApi24Impl extends OutputConfigurationCompatBaseImpl {

    public static final class OutputConfigurationParamsApi24 {
        long mDynamicRangeProfile = 1;
        boolean mIsShared;
        @NonNull
        final OutputConfiguration mOutputConfiguration;
        @Nullable
        String mPhysicalCameraId;

        public OutputConfigurationParamsApi24(@NonNull OutputConfiguration outputConfiguration) {
            this.mOutputConfiguration = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi24)) {
                return false;
            }
            OutputConfigurationParamsApi24 outputConfigurationParamsApi24 = (OutputConfigurationParamsApi24) obj;
            if (!Objects.equals(this.mOutputConfiguration, outputConfigurationParamsApi24.mOutputConfiguration) || this.mIsShared != outputConfigurationParamsApi24.mIsShared || this.mDynamicRangeProfile != outputConfigurationParamsApi24.mDynamicRangeProfile || !Objects.equals(this.mPhysicalCameraId, outputConfigurationParamsApi24.mPhysicalCameraId)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            int hashCode = this.mOutputConfiguration.hashCode() ^ 31;
            boolean z = this.mIsShared ^ ((hashCode << 5) - hashCode);
            int i2 = ((z ? 1 : 0) << true) - z;
            String str = this.mPhysicalCameraId;
            if (str == null) {
                i = 0;
            } else {
                i = str.hashCode();
            }
            int i3 = i ^ i2;
            int i4 = (i3 << 5) - i3;
            long j = this.mDynamicRangeProfile;
            return ((int) (j ^ (j >>> 32))) ^ i4;
        }
    }

    public OutputConfigurationCompatApi24Impl(@NonNull Surface surface) {
        this((Object) new OutputConfigurationParamsApi24(new OutputConfiguration(surface)));
    }

    @RequiresApi(24)
    public static OutputConfigurationCompatApi24Impl wrap(@NonNull OutputConfiguration outputConfiguration) {
        return new OutputConfigurationCompatApi24Impl((Object) new OutputConfigurationParamsApi24(outputConfiguration));
    }

    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi24) this.mObject).mIsShared = true;
    }

    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile;
    }

    @NonNull
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi24);
        return ((OutputConfigurationParamsApi24) this.mObject).mOutputConfiguration;
    }

    @Nullable
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId;
    }

    @Nullable
    public Surface getSurface() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurface();
    }

    public int getSurfaceGroupId() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurfaceGroupId();
    }

    @NonNull
    public List<Surface> getSurfaces() {
        return Collections.singletonList(getSurface());
    }

    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi24) this.mObject).mIsShared;
    }

    public void setDynamicRangeProfile(long j) {
        ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile = j;
    }

    public void setPhysicalCameraId(@Nullable String str) {
        ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId = str;
    }

    public OutputConfigurationCompatApi24Impl(int i, @NonNull Surface surface) {
        this((Object) new OutputConfigurationParamsApi24(new OutputConfiguration(i, surface)));
    }

    public OutputConfigurationCompatApi24Impl(@NonNull Object obj) {
        super(obj);
    }
}
