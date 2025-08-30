package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.List;

@RequiresApi(33)
public class OutputConfigurationCompatApi33Impl extends OutputConfigurationCompatApi28Impl {
    public OutputConfigurationCompatApi33Impl(@NonNull Surface surface) {
        super((Object) new OutputConfiguration(surface));
    }

    @RequiresApi(33)
    public static OutputConfigurationCompatApi33Impl wrap(@NonNull OutputConfiguration outputConfiguration) {
        return new OutputConfigurationCompatApi33Impl((Object) outputConfiguration);
    }

    public /* bridge */ /* synthetic */ void addSurface(@NonNull Surface surface) {
        super.addSurface(surface);
    }

    public /* bridge */ /* synthetic */ void enableSurfaceSharing() {
        super.enableSurfaceSharing();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public long getDynamicRangeProfile() {
        return ((OutputConfiguration) getOutputConfiguration()).getDynamicRangeProfile();
    }

    public /* bridge */ /* synthetic */ int getMaxSharedSurfaceCount() {
        return super.getMaxSharedSurfaceCount();
    }

    public int getMirrorMode() {
        return ((OutputConfiguration) getOutputConfiguration()).getMirrorMode();
    }

    @NonNull
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfiguration);
        return this.mObject;
    }

    @Nullable
    public /* bridge */ /* synthetic */ String getPhysicalCameraId() {
        return super.getPhysicalCameraId();
    }

    public long getStreamUseCase() {
        return ((OutputConfiguration) getOutputConfiguration()).getStreamUseCase();
    }

    @Nullable
    public /* bridge */ /* synthetic */ Surface getSurface() {
        return super.getSurface();
    }

    public /* bridge */ /* synthetic */ int getSurfaceGroupId() {
        return super.getSurfaceGroupId();
    }

    @NonNull
    public /* bridge */ /* synthetic */ List getSurfaces() {
        return super.getSurfaces();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ void removeSurface(@NonNull Surface surface) {
        super.removeSurface(surface);
    }

    public void setDynamicRangeProfile(long j) {
        ((OutputConfiguration) getOutputConfiguration()).setDynamicRangeProfile(j);
    }

    public void setMirrorMode(int i) {
        ((OutputConfiguration) getOutputConfiguration()).setMirrorMode(i);
    }

    public /* bridge */ /* synthetic */ void setPhysicalCameraId(@Nullable String str) {
        super.setPhysicalCameraId(str);
    }

    public void setStreamUseCase(long j) {
        if (j != -1) {
            ((OutputConfiguration) getOutputConfiguration()).setStreamUseCase(j);
        }
    }

    public OutputConfigurationCompatApi33Impl(int i, @NonNull Surface surface) {
        this((Object) new OutputConfiguration(i, surface));
    }

    public OutputConfigurationCompatApi33Impl(@NonNull Object obj) {
        super(obj);
    }
}
