package defpackage;

import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.v1.ApplicationProcessState;

/* renamed from: r9  reason: default package */
public final /* synthetic */ class r9 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ GaugeManager d;
    public final /* synthetic */ String e;
    public final /* synthetic */ ApplicationProcessState f;

    public /* synthetic */ r9(GaugeManager gaugeManager, String str, ApplicationProcessState applicationProcessState, int i) {
        this.c = i;
        this.d = gaugeManager;
        this.e = str;
        this.f = applicationProcessState;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$stopCollectingGauges$3(this.e, this.f);
                return;
            default:
                this.d.lambda$startCollectingGauges$2(this.e, this.f);
                return;
        }
    }
}
