package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.MeteringRepeatingSession;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class e implements CallbackToFutureAdapter.Resolver, MeteringRepeatingSession.SurfaceResetCallback {
    public final /* synthetic */ int c;
    public final /* synthetic */ Camera2CameraImpl d;

    public /* synthetic */ e(Camera2CameraImpl camera2CameraImpl, int i) {
        this.c = i;
        this.d = camera2CameraImpl;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.lambda$release$5(completer);
            case 2:
                return this.d.lambda$getOrCreateUserReleaseFuture$6(completer);
            case 3:
                return this.d.lambda$openCameraConfigAndClose$1(completer);
            default:
                return this.d.lambda$isMeteringRepeatingAttached$14(completer);
        }
    }

    public void onSurfaceReset() {
        this.d.lambda$addOrRemoveMeteringRepeatingUseCase$17();
    }
}
