package defpackage;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* renamed from: og  reason: default package */
public final /* synthetic */ class og implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ int c;
    public final /* synthetic */ Uploader d;
    public final /* synthetic */ TransportContext e;

    public /* synthetic */ og(Uploader uploader, TransportContext transportContext, int i) {
        this.c = i;
        this.d = uploader;
        this.e = transportContext;
    }

    public final Object execute() {
        switch (this.c) {
            case 0:
                return this.d.lambda$logAndUpdateState$2(this.e);
            default:
                return this.d.lambda$logAndUpdateState$3(this.e);
        }
    }
}
