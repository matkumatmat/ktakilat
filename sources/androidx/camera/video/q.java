package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class q implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ VideoEncoderSession c;
    public final /* synthetic */ SurfaceRequest d;
    public final /* synthetic */ Timebase e;
    public final /* synthetic */ VideoValidatedEncoderProfilesProxy f;
    public final /* synthetic */ MediaSpec g;

    public /* synthetic */ q(VideoEncoderSession videoEncoderSession, SurfaceRequest surfaceRequest, Timebase timebase, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, MediaSpec mediaSpec) {
        this.c = videoEncoderSession;
        this.d = surfaceRequest;
        this.e = timebase;
        this.f = videoValidatedEncoderProfilesProxy;
        this.g = mediaSpec;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.c.lambda$configure$2(this.d, this.e, this.f, this.g, completer);
    }
}
