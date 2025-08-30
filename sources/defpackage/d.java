package defpackage;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.abt.component.AbtRegistrar;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.google.firebase.perf.FirebasePerfRegistrar;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;

/* renamed from: d  reason: default package */
public final /* synthetic */ class d implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f341a;

    public /* synthetic */ d(int i) {
        this.f341a = i;
    }

    public final Object create(ComponentContainer componentContainer) {
        switch (this.f341a) {
            case 0:
                return AbtRegistrar.lambda$getComponents$0(componentContainer);
            case 1:
                return DefaultUserAgentPublisher.lambda$component$0(componentContainer);
            case 2:
                return ExecutorsRegistrar.BG_EXECUTOR.get();
            case 3:
                return ExecutorsRegistrar.BLOCKING_EXECUTOR.get();
            case 4:
                return ExecutorsRegistrar.LITE_EXECUTOR.get();
            case 5:
                return UiExecutor.INSTANCE;
            case 6:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
            case 7:
                return FirebasePerfRegistrar.providesFirebasePerformance(componentContainer);
            case 8:
                return FirebaseSessionsRegistrar.getComponents$lambda$0(componentContainer);
            case 9:
                return FirebaseSessionsRegistrar.getComponents$lambda$1(componentContainer);
            case 10:
                return TransportRuntime.initialize((Context) componentContainer.get(Context.class));
            case 11:
                return TransportRuntime.initialize((Context) componentContainer.get(Context.class));
            default:
                return TransportRuntime.initialize((Context) componentContainer.get(Context.class));
        }
    }
}
