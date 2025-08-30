package androidx.camera.view;

import android.graphics.SurfaceTexture;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ h(int i, Object obj, Object obj2) {
        this.c = i;
        this.e = obj;
        this.d = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((PreviewView.AnonymousClass1) this.e).lambda$onSurfaceRequested$0((SurfaceRequest) this.d);
                return;
            case 1:
                ((TextureViewImplementation) this.e).lambda$onSurfaceRequested$0((SurfaceRequest) this.d);
                return;
            default:
                ((PreviewView.OnFrameUpdateListener) this.e).onFrameUpdate(((SurfaceTexture) this.d).getTimestamp());
                return;
        }
    }
}
