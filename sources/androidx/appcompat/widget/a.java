package androidx.appcompat.widget;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ TooltipCompatHandler d;

    public /* synthetic */ a(TooltipCompatHandler tooltipCompatHandler, int i) {
        this.c = i;
        this.d = tooltipCompatHandler;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$new$0();
                return;
            default:
                this.d.hide();
                return;
        }
    }
}
