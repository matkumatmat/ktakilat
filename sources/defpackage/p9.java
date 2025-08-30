package defpackage;

import java.util.concurrent.ScheduledFuture;

/* renamed from: p9  reason: default package */
public final /* synthetic */ class p9 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ ScheduledFuture d;

    public /* synthetic */ p9(ScheduledFuture scheduledFuture, int i) {
        this.c = i;
        this.d = scheduledFuture;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.cancel(true);
                return;
            default:
                this.d.cancel(true);
                return;
        }
    }
}
