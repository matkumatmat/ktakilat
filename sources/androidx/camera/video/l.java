package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.Recorder;

public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ Recorder.SetupVideoTask c;
    public final /* synthetic */ SurfaceRequest d;
    public final /* synthetic */ Timebase e;

    public /* synthetic */ l(Recorder.SetupVideoTask setupVideoTask, SurfaceRequest surfaceRequest, Timebase timebase) {
        this.c = setupVideoTask;
        this.d = surfaceRequest;
        this.e = timebase;
    }

    public final void run() {
        this.c.lambda$setupVideo$0(this.d, this.e);
    }
}
