package defpackage;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* renamed from: f5  reason: default package */
public final /* synthetic */ class f5 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CallbackToFutureAdapter.Completer d;

    public /* synthetic */ f5(int i, CallbackToFutureAdapter.Completer completer) {
        this.c = i;
        this.d = completer;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.setException(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
                return;
            default:
                this.d.set(null);
                return;
        }
    }
}
