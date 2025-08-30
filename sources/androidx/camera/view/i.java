package androidx.camera.view;

import androidx.camera.view.RotationProvider;

public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ RotationProvider.ListenerWrapper c;
    public final /* synthetic */ int d;

    public /* synthetic */ i(RotationProvider.ListenerWrapper listenerWrapper, int i) {
        this.c = listenerWrapper;
        this.d = i;
    }

    public final void run() {
        this.c.lambda$onRotationChanged$0(this.d);
    }
}
