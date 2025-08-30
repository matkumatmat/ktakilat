package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;

public interface VideoOutput {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public enum SourceState {
        ACTIVE_STREAMING,
        ACTIVE_NON_STREAMING,
        INACTIVE
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    VideoCapabilities getMediaCapabilities(@NonNull CameraInfo cameraInfo);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Observable<MediaSpec> getMediaSpec();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Observable<StreamInfo> getStreamInfo();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Observable<Boolean> isSourceStreamRequired();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    void onSourceStateChanged(@NonNull SourceState sourceState);

    void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase);
}
