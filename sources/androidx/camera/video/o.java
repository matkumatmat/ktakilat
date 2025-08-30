package androidx.camera.video;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class o implements Encoder.SurfaceInput.OnSurfaceUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoEncoderSession f35a;
    public final /* synthetic */ CallbackToFutureAdapter.Completer b;
    public final /* synthetic */ SurfaceRequest c;

    public /* synthetic */ o(VideoEncoderSession videoEncoderSession, CallbackToFutureAdapter.Completer completer, SurfaceRequest surfaceRequest) {
        this.f35a = videoEncoderSession;
        this.b = completer;
        this.c = surfaceRequest;
    }

    public final void onSurfaceUpdate(Surface surface) {
        this.f35a.lambda$configureVideoEncoderInternal$5(this.b, this.c, surface);
    }
}
