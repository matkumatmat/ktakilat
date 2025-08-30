package defpackage;

import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.inject.Provider;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Collections;
import java.util.concurrent.Executors;

/* renamed from: x3  reason: default package */
public final /* synthetic */ class x3 implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f365a;

    public /* synthetic */ x3(int i) {
        this.f365a = i;
    }

    public final Object get() {
        switch (this.f365a) {
            case 0:
                return Collections.emptySet();
            case 1:
                return ExecutorsRegistrar.scheduled(Executors.newFixedThreadPool(4, ExecutorsRegistrar.factory("Firebase Background", 10, ExecutorsRegistrar.bgPolicy())));
            case 2:
                return ExecutorsRegistrar.scheduled(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), ExecutorsRegistrar.factory("Firebase Lite", 0, ExecutorsRegistrar.litePolicy())));
            case 3:
                return ExecutorsRegistrar.scheduled(Executors.newCachedThreadPool(ExecutorsRegistrar.factory("Firebase Blocking", 11)));
            case 4:
                return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.factory("Firebase Scheduler", 0));
            case 5:
                return FirebaseMessaging.lambda$clearTransportFactoryForTest$12();
            case 6:
                return FirebaseMessaging.lambda$static$0();
            case 7:
                return Executors.newSingleThreadScheduledExecutor();
            case 8:
                return GaugeManager.lambda$new$0();
            case 9:
                return GaugeManager.lambda$new$1();
            default:
                return RemoteConfigComponent.lambda$getFetchHandler$0();
        }
    }
}
