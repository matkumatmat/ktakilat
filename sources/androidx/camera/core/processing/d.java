package androidx.camera.core.processing;

import androidx.camera.core.processing.SurfaceEdge;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class d implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ d(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return ((SurfaceEdge.SettableSurface) this.d).lambda$new$0(completer);
            default:
                return ((SurfaceOutputImpl) this.d).lambda$new$0(completer);
        }
    }
}
