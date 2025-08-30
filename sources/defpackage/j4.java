package defpackage;

import androidx.core.widget.ContentLoadingProgressBar;

/* renamed from: j4  reason: default package */
public final /* synthetic */ class j4 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ ContentLoadingProgressBar d;

    public /* synthetic */ j4(ContentLoadingProgressBar contentLoadingProgressBar, int i) {
        this.c = i;
        this.d = contentLoadingProgressBar;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$new$0();
                return;
            case 1:
                this.d.lambda$new$1();
                return;
            case 2:
                this.d.showOnUiThread();
                return;
            default:
                this.d.hideOnUiThread();
                return;
        }
    }
}
