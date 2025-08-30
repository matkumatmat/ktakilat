package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.ImageCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class w implements ImageCapture.ScreenFlashListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f20a;

    public /* synthetic */ w(CallbackToFutureAdapter.Completer completer) {
        this.f20a = completer;
    }

    public final void onCompleted() {
        Camera2CapturePipeline.ScreenFlashTask.lambda$preCapture$0(this.f20a);
    }
}
