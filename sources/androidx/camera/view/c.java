package androidx.camera.view;

import androidx.camera.view.CameraController;
import androidx.camera.view.PreviewViewImplementation;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((CameraController.AnonymousClass2) this.d).lambda$accept$0();
                return;
            default:
                ((PreviewViewImplementation.OnSurfaceNotInUseListener) this.d).onSurfaceNotInUse();
                return;
        }
    }
}
