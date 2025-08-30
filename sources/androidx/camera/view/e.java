package androidx.camera.view;

import android.view.Surface;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class e implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ e(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return ((PendingValue) this.d).lambda$setValue$0(this.e, completer);
            default:
                return ((TextureViewImplementation) this.d).lambda$tryToProvidePreviewSurface$1((Surface) this.e, completer);
        }
    }
}
