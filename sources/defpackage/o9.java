package defpackage;

import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.metadata.EventMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* renamed from: o9  reason: default package */
public final /* synthetic */ class o9 implements Runnable {
    public final /* synthetic */ int c = 0;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    public /* synthetic */ o9(CallbackToFutureAdapter.Completer completer, Object obj, boolean z, ListenableFuture listenableFuture) {
        this.e = completer;
        this.f = obj;
        this.d = z;
        this.g = listenableFuture;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                Futures.lambda$makeTimeoutFuture$4((CallbackToFutureAdapter.Completer) this.e, this.f, this.d, (ListenableFuture) this.g);
                return;
            default:
                ((SessionReportingCoordinator) this.e).lambda$persistEvent$0((CrashlyticsReport.Session.Event) this.f, (EventMetadata) this.g, this.d);
                return;
        }
    }

    public /* synthetic */ o9(SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsReport.Session.Event event, EventMetadata eventMetadata, boolean z) {
        this.e = sessionReportingCoordinator;
        this.f = event;
        this.g = eventMetadata;
        this.d = z;
    }
}
