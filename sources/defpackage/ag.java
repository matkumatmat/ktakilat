package defpackage;

import androidx.appcompat.widget.Toolbar;

/* renamed from: ag  reason: default package */
public final /* synthetic */ class ag implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Toolbar d;

    public /* synthetic */ ag(Toolbar toolbar, int i) {
        this.c = i;
        this.d = toolbar;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.collapseActionView();
                return;
            default:
                this.d.invalidateMenu();
                return;
        }
    }
}
