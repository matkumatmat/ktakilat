package defpackage;

import com.google.firebase.perf.session.gauges.MemoryGaugeCollector;
import com.google.firebase.perf.util.Timer;

/* renamed from: pc  reason: default package */
public final /* synthetic */ class pc implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ MemoryGaugeCollector d;
    public final /* synthetic */ Timer e;

    public /* synthetic */ pc(MemoryGaugeCollector memoryGaugeCollector, Timer timer, int i) {
        this.c = i;
        this.d = memoryGaugeCollector;
        this.e = timer;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$scheduleMemoryMetricCollectionWithRate$0(this.e);
                return;
            default:
                this.d.lambda$scheduleMemoryMetricCollectionOnce$1(this.e);
                return;
        }
    }
}
