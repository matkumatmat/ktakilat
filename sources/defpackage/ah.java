package defpackage;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoCapabilities;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.s;

/* renamed from: ah  reason: default package */
public final /* synthetic */ class ah implements VideoOutput {
    public final /* synthetic */ VideoCapabilities getMediaCapabilities(CameraInfo cameraInfo) {
        return s.a(this, cameraInfo);
    }

    public final /* synthetic */ Observable getMediaSpec() {
        return s.b(this);
    }

    public final /* synthetic */ Observable getStreamInfo() {
        return s.c(this);
    }

    public final /* synthetic */ Observable isSourceStreamRequired() {
        return s.d(this);
    }

    public final /* synthetic */ void onSourceStateChanged(VideoOutput.SourceState sourceState) {
        s.e(this, sourceState);
    }

    public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        surfaceRequest.willNotProvideSurface();
    }

    public final /* synthetic */ void onSurfaceRequested(SurfaceRequest surfaceRequest, Timebase timebase) {
        s.f(this, surfaceRequest, timebase);
    }
}
