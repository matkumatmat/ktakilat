package defpackage;

import com.google.firebase.perf.metrics.AppStartTrace;

/* renamed from: d0  reason: default package */
public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ AppStartTrace d;

    public /* synthetic */ d0(AppStartTrace appStartTrace, int i) {
        this.c = i;
        this.d = appStartTrace;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.recordOnDrawFrontOfQueue();
                return;
            case 1:
                this.d.recordPreDraw();
                return;
            case 2:
                this.d.recordPreDrawFrontOfQueue();
                return;
            default:
                this.d.logAppStartTrace();
                return;
        }
    }
}
