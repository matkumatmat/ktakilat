package androidx.camera.camera2.internal.compat.params;

import android.annotation.SuppressLint;
import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

@RequiresApi(26)
class OutputConfigurationCompatApi26Impl extends OutputConfigurationCompatApi24Impl {
    private static final String MAX_SHARED_SURFACES_COUNT_FIELD = "MAX_SURFACES_COUNT";
    private static final String SURFACES_FIELD = "mSurfaces";

    public static final class OutputConfigurationParamsApi26 {
        long mDynamicRangeProfile = 1;
        @NonNull
        final OutputConfiguration mOutputConfiguration;
        @Nullable
        String mPhysicalCameraId;

        public OutputConfigurationParamsApi26(@NonNull OutputConfiguration outputConfiguration) {
            this.mOutputConfiguration = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi26)) {
                return false;
            }
            OutputConfigurationParamsApi26 outputConfigurationParamsApi26 = (OutputConfigurationParamsApi26) obj;
            if (!Objects.equals(this.mOutputConfiguration, outputConfigurationParamsApi26.mOutputConfiguration) || this.mDynamicRangeProfile != outputConfigurationParamsApi26.mDynamicRangeProfile || !Objects.equals(this.mPhysicalCameraId, outputConfigurationParamsApi26.mPhysicalCameraId)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            int hashCode = this.mOutputConfiguration.hashCode() ^ 31;
            int i2 = (hashCode << 5) - hashCode;
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

    public OutputConfigurationCompatApi26Impl(@NonNull Surface surface) {
        this((Object) new OutputConfigurationParamsApi26(new OutputConfiguration(surface)));
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private static int getMaxSharedSurfaceCountApi26() throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = OutputConfiguration.class.getDeclaredField(MAX_SHARED_SURFACES_COUNT_FIELD);
        declaredField.setAccessible(true);
        return declaredField.getInt((Object) null);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private static List<Surface> getMutableSurfaceListApi26(OutputConfiguration outputConfiguration) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = OutputConfiguration.class.getDeclaredField(SURFACES_FIELD);
        declaredField.setAccessible(true);
        return (List) declaredField.get(outputConfiguration);
    }

    @RequiresApi(26)
    public static OutputConfigurationCompatApi26Impl wrap(@NonNull OutputConfiguration outputConfiguration) {
        return new OutputConfigurationCompatApi26Impl((Object) new OutputConfigurationParamsApi26(outputConfiguration));
    }

    public void addSurface(@NonNull Surface surface) {
        ((OutputConfiguration) getOutputConfiguration()).addSurface(surface);
    }

    public void enableSurfaceSharing() {
        ((OutputConfiguration) getOutputConfiguration()).enableSurfaceSharing();
    }

    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi26) this.mObject).mDynamicRangeProfile;
    }

    public int getMaxSharedSurfaceCount() {
        try {
            return getMaxSharedSurfaceCountApi26();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            Logger.e("OutputConfigCompat", "Unable to retrieve max shared surface count.", e);
            return super.getMaxSharedSurfaceCount();
        }
    }

    @NonNull
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi26);
        return ((OutputConfigurationParamsApi26) this.mObject).mOutputConfiguration;
    }

    @Nullable
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi26) this.mObject).mPhysicalCameraId;
    }

    @NonNull
    public List<Surface> getSurfaces() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurfaces();
    }

    public final boolean isSurfaceSharingEnabled() {
        throw new AssertionError("isSurfaceSharingEnabled() should not be called on API >= 26");
    }

    public void removeSurface(@NonNull Surface surface) {
        if (getSurface() != surface) {
            try {
                if (!getMutableSurfaceListApi26((OutputConfiguration) getOutputConfiguration()).remove(surface)) {
                    throw new IllegalArgumentException("Surface is not part of this output configuration");
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                Logger.e("OutputConfigCompat", "Unable to remove surface from this output configuration.", e);
            }
        } else {
            throw new IllegalArgumentException("Cannot remove surface associated with this output configuration");
        }
    }

    public void setDynamicRangeProfile(long j) {
        ((OutputConfigurationParamsApi26) this.mObject).mDynamicRangeProfile = j;
    }

    public void setPhysicalCameraId(@Nullable String str) {
        ((OutputConfigurationParamsApi26) this.mObject).mPhysicalCameraId = str;
    }

    public OutputConfigurationCompatApi26Impl(int i, @NonNull Surface surface) {
        this((Object) new OutputConfigurationParamsApi26(new OutputConfiguration(i, surface)));
    }

    public OutputConfigurationCompatApi26Impl(@NonNull Object obj) {
        super(obj);
    }
}
