package defpackage;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: i1  reason: default package */
public final /* synthetic */ class i1 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ AtomicReference d;

    public /* synthetic */ i1(AtomicReference atomicReference, int i) {
        this.c = i;
        this.d = atomicReference;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.set(completer);
            case 1:
                return this.d.set(completer);
            case 2:
                return this.d.set(completer);
            default:
                return this.d.set(completer);
        }
    }
}
