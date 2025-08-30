package defpackage;

import com.google.firebase.perf.session.gauges.CpuGaugeCollector;
import com.google.firebase.perf.util.Timer;

/* renamed from: m4  reason: default package */
public final /* synthetic */ class m4 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CpuGaugeCollector d;
    public final /* synthetic */ Timer e;

    public /* synthetic */ m4(CpuGaugeCollector cpuGaugeCollector, Timer timer, int i) {
        this.c = i;
        this.d = cpuGaugeCollector;
        this.e = timer;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$scheduleCpuMetricCollectionWithRate$0(this.e);
                return;
            default:
                this.d.lambda$scheduleCpuMetricCollectionOnce$1(this.e);
                return;
        }
    }
}
