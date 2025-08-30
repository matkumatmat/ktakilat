package defpackage;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.video.Recorder;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;

/* renamed from: q2  reason: default package */
public final /* synthetic */ class q2 implements Consumer {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ q2(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void accept(Object obj) {
        switch (this.c) {
            case 0:
                CameraUseCaseAdapter.lambda$createExtraPreview$0((Surface) this.d, (SurfaceTexture) this.e, (SurfaceRequest.Result) obj);
                return;
            case 1:
                ((DefaultSurfaceProcessor) this.d).lambda$onOutputSurface$3((SurfaceOutput) this.e, (SurfaceOutput.Event) obj);
                return;
            case 2:
                ((DualSurfaceProcessor) this.d).lambda$onOutputSurface$2((SurfaceOutput) this.e, (SurfaceOutput.Event) obj);
                return;
            default:
                ((Recorder) this.d).lambda$updateEncoderCallbacks$11((CallbackToFutureAdapter.Completer) this.e, (Throwable) obj);
                return;
        }
    }
}
