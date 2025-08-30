package defpackage;

import com.google.firebase.perf.transport.TransportManager;

/* renamed from: cg  reason: default package */
public final /* synthetic */ class cg implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ TransportManager d;

    public /* synthetic */ cg(TransportManager transportManager, int i) {
        this.c = i;
        this.d = transportManager;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onUpdateAppState$1();
                return;
            default:
                this.d.syncInit();
                return;
        }
    }
}
