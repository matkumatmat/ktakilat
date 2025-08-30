package defpackage;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Consumer;

/* renamed from: tf  reason: default package */
public final /* synthetic */ class tf implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Consumer d;
    public final /* synthetic */ Surface e;

    public /* synthetic */ tf(Consumer consumer, Surface surface, int i) {
        this.c = i;
        this.d = consumer;
        this.e = surface;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.accept(SurfaceRequest.Result.of(3, this.e));
                return;
            default:
                this.d.accept(SurfaceRequest.Result.of(4, this.e));
                return;
        }
    }
}
