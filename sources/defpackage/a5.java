package defpackage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import com.google.firebase.perf.FirebasePerfRegistrar;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar;

/* renamed from: a5  reason: default package */
public final /* synthetic */ class a5 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f220a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a5(Object obj, int i) {
        this.f220a = i;
        this.b = obj;
    }

    public final Object create(ComponentContainer componentContainer) {
        switch (this.f220a) {
            case 0:
                return DefaultHeartBeatController.lambda$component$3((Qualified) this.b, componentContainer);
            case 1:
                return FirebaseMessagingRegistrar.lambda$getComponents$0((Qualified) this.b, componentContainer);
            case 2:
                return FirebasePerfRegistrar.lambda$getComponents$0((Qualified) this.b, componentContainer);
            case 3:
                return RemoteConfigRegistrar.lambda$getComponents$0((Qualified) this.b, componentContainer);
            default:
                return ((CrashlyticsRegistrar) this.b).buildCrashlytics(componentContainer);
        }
    }
}
