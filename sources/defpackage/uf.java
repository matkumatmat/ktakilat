package defpackage;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: uf  reason: default package */
public final /* synthetic */ class uf implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ AtomicReference d;
    public final /* synthetic */ String e;

    public /* synthetic */ uf(AtomicReference atomicReference, String str, int i) {
        this.c = i;
        this.d = atomicReference;
        this.e = str;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.set(completer);
            case 1:
                return this.d.set(completer);
            default:
                return this.d.set(completer);
        }
    }
}
