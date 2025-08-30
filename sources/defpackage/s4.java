package defpackage;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* renamed from: s4  reason: default package */
public final /* synthetic */ class s4 implements Deferred.DeferredHandler, SynchronizationGuard.CriticalSection {
    public final /* synthetic */ long c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ s4(Uploader uploader, Iterable iterable, TransportContext transportContext, long j) {
        this.d = uploader;
        this.e = iterable;
        this.f = transportContext;
        this.c = j;
    }

    public Object execute() {
        return ((Uploader) this.d).lambda$logAndUpdateState$4((Iterable) this.e, (TransportContext) this.f, this.c);
    }

    public void handle(Provider provider) {
        ((CrashlyticsNativeComponent) provider.get()).prepareNativeSession((String) this.d, (String) this.e, this.c, (StaticSessionData) this.f);
    }

    public /* synthetic */ s4(String str, String str2, long j, StaticSessionData staticSessionData) {
        this.d = str;
        this.e = str2;
        this.c = j;
        this.f = staticSessionData;
    }
}
