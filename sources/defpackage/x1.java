package defpackage;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import org.apache.commons.lang3.function.FailableLongConsumer;
import org.apache.commons.lang3.function.FailableRunnable;

/* renamed from: x1  reason: default package */
public final /* synthetic */ class x1 implements CallbackToFutureAdapter.Resolver, FailableRunnable {
    public final /* synthetic */ long c;
    public final /* synthetic */ Object d;

    public /* synthetic */ x1(Object obj, long j) {
        this.d = obj;
        this.c = j;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((Camera2CameraControlImpl) this.d).lambda$waitForSessionUpdateId$3(this.c, completer);
    }

    public void run() {
        ((FailableLongConsumer) this.d).accept(this.c);
    }
}
