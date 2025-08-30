package androidx.camera.core.processing;

import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((DefaultSurfaceProcessor) this.d).lambda$snapshot$6((AutoValue_DefaultSurfaceProcessor_PendingSnapshot) this.e);
                return;
            default:
                ((SurfaceOutputImpl) this.d).lambda$requestClose$1((AtomicReference) this.e);
                return;
        }
    }
}
