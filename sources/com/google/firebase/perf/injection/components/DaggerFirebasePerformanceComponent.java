package com.google.firebase.perf.injection.components;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.FirebasePerformance_Factory;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesConfigResolverFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseAppFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesSessionManagerFactory;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFirebasePerformanceComponent {

    public static final class Builder {
        private FirebasePerformanceModule firebasePerformanceModule;

        public FirebasePerformanceComponent build() {
            FirebasePerformanceModule firebasePerformanceModule2 = this.firebasePerformanceModule;
            if (firebasePerformanceModule2 != null) {
                return new FirebasePerformanceComponentImpl(firebasePerformanceModule2);
            }
            throw new IllegalStateException(FirebasePerformanceModule.class.getCanonicalName() + " must be set");
        }

        public Builder firebasePerformanceModule(FirebasePerformanceModule firebasePerformanceModule2) {
            firebasePerformanceModule2.getClass();
            this.firebasePerformanceModule = firebasePerformanceModule2;
            return this;
        }

        private Builder() {
        }
    }

    public static final class FirebasePerformanceComponentImpl implements FirebasePerformanceComponent {
        private final FirebasePerformanceComponentImpl firebasePerformanceComponentImpl;
        private Provider<FirebasePerformance> firebasePerformanceProvider;
        private Provider<ConfigResolver> providesConfigResolverProvider;
        private Provider<FirebaseApp> providesFirebaseAppProvider;
        private Provider<FirebaseInstallationsApi> providesFirebaseInstallationsProvider;
        private Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> providesRemoteConfigComponentProvider;
        private Provider<RemoteConfigManager> providesRemoteConfigManagerProvider;
        private Provider<SessionManager> providesSessionManagerProvider;
        private Provider<com.google.firebase.inject.Provider<TransportFactory>> providesTransportFactoryProvider;

        /* JADX WARNING: type inference failed for: r0v6, types: [dagger.internal.DoubleCheck, javax.inject.Provider<com.google.firebase.perf.FirebasePerformance>, java.lang.Object] */
        private void initialize(FirebasePerformanceModule firebasePerformanceModule) {
            this.providesFirebaseAppProvider = FirebasePerformanceModule_ProvidesFirebaseAppFactory.create(firebasePerformanceModule);
            this.providesRemoteConfigComponentProvider = FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory.create(firebasePerformanceModule);
            this.providesFirebaseInstallationsProvider = FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory.create(firebasePerformanceModule);
            this.providesTransportFactoryProvider = FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory.create(firebasePerformanceModule);
            this.providesRemoteConfigManagerProvider = FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory.create(firebasePerformanceModule);
            this.providesConfigResolverProvider = FirebasePerformanceModule_ProvidesConfigResolverFactory.create(firebasePerformanceModule);
            FirebasePerformanceModule_ProvidesSessionManagerFactory create = FirebasePerformanceModule_ProvidesSessionManagerFactory.create(firebasePerformanceModule);
            this.providesSessionManagerProvider = create;
            FirebasePerformance_Factory create2 = FirebasePerformance_Factory.create(this.providesFirebaseAppProvider, this.providesRemoteConfigComponentProvider, this.providesFirebaseInstallationsProvider, this.providesTransportFactoryProvider, this.providesRemoteConfigManagerProvider, this.providesConfigResolverProvider, create);
            create2.getClass();
            ? obj = new Object();
            obj.b = DoubleCheck.c;
            obj.f647a = create2;
            this.firebasePerformanceProvider = obj;
        }

        public FirebasePerformance getFirebasePerformance() {
            return (FirebasePerformance) this.firebasePerformanceProvider.get();
        }

        private FirebasePerformanceComponentImpl(FirebasePerformanceModule firebasePerformanceModule) {
            this.firebasePerformanceComponentImpl = this;
            initialize(firebasePerformanceModule);
        }
    }

    private DaggerFirebasePerformanceComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }
}
