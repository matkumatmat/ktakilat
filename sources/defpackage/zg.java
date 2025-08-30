package defpackage;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.impl.VideoCaptureConfig;

/* renamed from: zg  reason: default package */
public final /* synthetic */ class zg implements Runnable {
    public final /* synthetic */ VideoCapture c;
    public final /* synthetic */ SurfaceEdge d;
    public final /* synthetic */ CameraInternal e;
    public final /* synthetic */ VideoCaptureConfig f;
    public final /* synthetic */ Timebase g;

    public /* synthetic */ zg(VideoCapture videoCapture, SurfaceEdge surfaceEdge, CameraInternal cameraInternal, VideoCaptureConfig videoCaptureConfig, Timebase timebase) {
        this.c = videoCapture;
        this.d = surfaceEdge;
        this.e = cameraInternal;
        this.f = videoCaptureConfig;
        this.g = timebase;
    }

    public final void run() {
        this.c.lambda$createPipeline$1(this.d, this.e, this.f, this.g);
    }
}
