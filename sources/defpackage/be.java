package defpackage;

import androidx.camera.core.imagecapture.RequestWithCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* renamed from: be  reason: default package */
public final /* synthetic */ class be implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ RequestWithCallback d;

    public /* synthetic */ be(RequestWithCallback requestWithCallback, int i) {
        this.c = i;
        this.d = requestWithCallback;
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
