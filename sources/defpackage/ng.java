package defpackage;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: ng  reason: default package */
public final /* synthetic */ class ng implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ Uploader c;
    public final /* synthetic */ TransportContext d;
    public final /* synthetic */ int e;

    public /* synthetic */ ng(Uploader uploader, TransportContext transportContext, int i) {
        this.c = uploader;
        this.d = transportContext;
        this.e = i;
    }

    public final Object execute() {
        return this.c.lambda$upload$0(this.d, this.e);
    }
}
