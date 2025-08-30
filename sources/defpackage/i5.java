package defpackage;

import androidx.camera.core.impl.DeferrableSurface;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* renamed from: i5  reason: default package */
public final /* synthetic */ class i5 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ DeferrableSurface d;

    public /* synthetic */ i5(DeferrableSurface deferrableSurface, int i) {
        this.c = i;
        this.d = deferrableSurface;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.lambda$new$0(completer);
            default:
                return this.d.lambda$new$1(completer);
        }
    }
}
