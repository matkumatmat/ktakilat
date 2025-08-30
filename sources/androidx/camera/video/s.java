package androidx.camera.video;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoOutput;

public abstract /* synthetic */ class s {
    public static VideoCapabilities a(VideoOutput videoOutput, CameraInfo cameraInfo) {
        return VideoCapabilities.EMPTY;
    }

    public static Observable b(VideoOutput videoOutput) {
        return ConstantObservable.withValue(null);
    }

    public static Observable c(VideoOutput videoOutput) {
        return StreamInfo.ALWAYS_ACTIVE_OBSERVABLE;
    }

    public static Observable d(VideoOutput videoOutput) {
        return ConstantObservable.withValue(Boolean.FALSE);
    }

    public static void f(VideoOutput videoOutput, SurfaceRequest surfaceRequest, Timebase timebase) {
        videoOutput.onSurfaceRequested(surfaceRequest);
    }

    public static void e(VideoOutput videoOutput, VideoOutput.SourceState sourceState) {
    }
}
