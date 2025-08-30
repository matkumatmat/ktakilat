package defpackage;

import androidx.camera.core.impl.DeferrableSurface;

/* renamed from: nf  reason: default package */
public final /* synthetic */ class nf implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ DeferrableSurface d;

    public /* synthetic */ nf(DeferrableSurface deferrableSurface, int i) {
        this.c = i;
        this.d = deferrableSurface;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.close();
                return;
            default:
                this.d.decrementUseCount();
                return;
        }
    }
}
