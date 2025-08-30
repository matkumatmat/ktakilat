package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.DoubleCheck;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.settings.LocalOverrideSettings;
import com.google.firebase.sessions.settings.LocalOverrideSettings_Factory;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.sessions.settings.RemoteSettingsFetcher;
import com.google.firebase.sessions.settings.RemoteSettingsFetcher_Factory;
import com.google.firebase.sessions.settings.RemoteSettings_Factory;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.google.firebase.sessions.settings.SessionsSettings_Factory;
import com.google.firebase.sessions.settings.SettingsCache;
import com.google.firebase.sessions.settings.SettingsCache_Factory;
import kotlin.coroutines.CoroutineContext;

@DaggerGenerated
public final class DaggerFirebaseSessionsComponent {

    public static final class Builder implements FirebaseSessionsComponent.Builder {
        private Context appContext;
        private CoroutineContext backgroundDispatcher;
        private CoroutineContext blockingDispatcher;
        private FirebaseApp firebaseApp;
        private FirebaseInstallationsApi firebaseInstallationsApi;
        private Provider<TransportFactory> transportFactoryProvider;

        private Builder() {
        }

        public FirebaseSessionsComponent build() {
            Preconditions.checkBuilderRequirement(this.appContext, Context.class);
            Class<CoroutineContext> cls = CoroutineContext.class;
            Preconditions.checkBuilderRequirement(this.backgroundDispatcher, cls);
            Preconditions.checkBuilderRequirement(this.blockingDispatcher, cls);
            Preconditions.checkBuilderRequirement(this.firebaseApp, FirebaseApp.class);
            Preconditions.checkBuilderRequirement(this.firebaseInstallationsApi, FirebaseInstallationsApi.class);
            Preconditions.checkBuilderRequirement(this.transportFactoryProvider, Provider.class);
            return new FirebaseSessionsComponentImpl(this.appContext, this.backgroundDispatcher, this.blockingDispatcher, this.firebaseApp, this.firebaseInstallationsApi, this.transportFactoryProvider);
        }

        public Builder appContext(Context context) {
            this.appContext = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        public Builder backgroundDispatcher(CoroutineContext coroutineContext) {
            this.backgroundDispatcher = (CoroutineContext) Preconditions.checkNotNull(coroutineContext);
            return this;
        }

        public Builder blockingDispatcher(CoroutineContext coroutineContext) {
            this.blockingDispatcher = (CoroutineContext) Preconditions.checkNotNull(coroutineContext);
            return this;
        }

        public Builder firebaseApp(FirebaseApp firebaseApp2) {
            this.firebaseApp = (FirebaseApp) Preconditions.checkNotNull(firebaseApp2);
            return this;
        }

        public Builder firebaseInstallationsApi(FirebaseInstallationsApi firebaseInstallationsApi2) {
            this.firebaseInstallationsApi = (FirebaseInstallationsApi) Preconditions.checkNotNull(firebaseInstallationsApi2);
            return this;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [com.google.firebase.inject.Provider<com.google.android.datatransport.TransportFactory>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.firebase.sessions.DaggerFirebaseSessionsComponent.Builder transportFactoryProvider(com.google.firebase.inject.Provider<com.google.android.datatransport.TransportFactory> r1) {
            /*
                r0 = this;
                java.lang.Object r1 = com.google.firebase.sessions.dagger.internal.Preconditions.checkNotNull(r1)
                com.google.firebase.inject.Provider r1 = (com.google.firebase.inject.Provider) r1
                r0.transportFactoryProvider = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.DaggerFirebaseSessionsComponent.Builder.transportFactoryProvider(com.google.firebase.inject.Provider):com.google.firebase.sessions.DaggerFirebaseSessionsComponent$Builder");
        }
    }

    public static final class FirebaseSessionsComponentImpl implements FirebaseSessionsComponent {
        private javax.inject.Provider<Context> appContextProvider;
        private javax.inject.Provider<ApplicationInfo> applicationInfoProvider;
        private javax.inject.Provider<CoroutineContext> backgroundDispatcherProvider;
        private javax.inject.Provider<EventGDTLogger> eventGDTLoggerProvider;
        private javax.inject.Provider<FirebaseApp> firebaseAppProvider;
        private javax.inject.Provider<FirebaseInstallationsApi> firebaseInstallationsApiProvider;
        private final FirebaseSessionsComponentImpl firebaseSessionsComponentImpl;
        private javax.inject.Provider<FirebaseSessions> firebaseSessionsProvider;
        private javax.inject.Provider<LocalOverrideSettings> localOverrideSettingsProvider;
        private javax.inject.Provider<RemoteSettingsFetcher> remoteSettingsFetcherProvider;
        private javax.inject.Provider<RemoteSettings> remoteSettingsProvider;
        private javax.inject.Provider<DataStore<Preferences>> sessionConfigsDataStoreProvider;
        private javax.inject.Provider<SessionDatastoreImpl> sessionDatastoreImplProvider;
        private javax.inject.Provider<DataStore<Preferences>> sessionDetailsDataStoreProvider;
        private javax.inject.Provider<SessionFirelogPublisherImpl> sessionFirelogPublisherImplProvider;
        private javax.inject.Provider<SessionGenerator> sessionGeneratorProvider;
        private javax.inject.Provider<SessionLifecycleServiceBinderImpl> sessionLifecycleServiceBinderImplProvider;
        private javax.inject.Provider<SessionsSettings> sessionsSettingsProvider;
        private javax.inject.Provider<SettingsCache> settingsCacheProvider;
        private javax.inject.Provider<TimeProvider> timeProvider;
        private javax.inject.Provider<Provider<TransportFactory>> transportFactoryProvider;
        private javax.inject.Provider<UuidGenerator> uuidGeneratorProvider;

        private void initialize(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider) {
            this.firebaseAppProvider = InstanceFactory.create(firebaseApp);
            Factory create = InstanceFactory.create(context);
            this.appContextProvider = create;
            this.localOverrideSettingsProvider = DoubleCheck.provider(LocalOverrideSettings_Factory.create(create));
            this.backgroundDispatcherProvider = InstanceFactory.create(coroutineContext);
            this.firebaseInstallationsApiProvider = InstanceFactory.create(firebaseInstallationsApi);
            javax.inject.Provider<ApplicationInfo> provider2 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory.create(this.firebaseAppProvider));
            this.applicationInfoProvider = provider2;
            this.remoteSettingsFetcherProvider = DoubleCheck.provider(RemoteSettingsFetcher_Factory.create(provider2, this.backgroundDispatcherProvider));
            javax.inject.Provider<DataStore<Preferences>> provider3 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory.create(this.appContextProvider));
            this.sessionConfigsDataStoreProvider = provider3;
            javax.inject.Provider<SettingsCache> provider4 = DoubleCheck.provider(SettingsCache_Factory.create(provider3));
            this.settingsCacheProvider = provider4;
            javax.inject.Provider<RemoteSettings> provider5 = DoubleCheck.provider(RemoteSettings_Factory.create(this.backgroundDispatcherProvider, this.firebaseInstallationsApiProvider, this.applicationInfoProvider, this.remoteSettingsFetcherProvider, provider4));
            this.remoteSettingsProvider = provider5;
            this.sessionsSettingsProvider = DoubleCheck.provider(SessionsSettings_Factory.create(this.localOverrideSettingsProvider, provider5));
            javax.inject.Provider<SessionLifecycleServiceBinderImpl> provider6 = DoubleCheck.provider(SessionLifecycleServiceBinderImpl_Factory.create(this.appContextProvider));
            this.sessionLifecycleServiceBinderImplProvider = provider6;
            this.firebaseSessionsProvider = DoubleCheck.provider(FirebaseSessions_Factory.create(this.firebaseAppProvider, this.sessionsSettingsProvider, this.backgroundDispatcherProvider, provider6));
            javax.inject.Provider<DataStore<Preferences>> provider7 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory.create(this.appContextProvider));
            this.sessionDetailsDataStoreProvider = provider7;
            this.sessionDatastoreImplProvider = DoubleCheck.provider(SessionDatastoreImpl_Factory.create(this.backgroundDispatcherProvider, provider7));
            Factory<TransportFactory> create2 = InstanceFactory.create(provider);
            this.transportFactoryProvider = create2;
            javax.inject.Provider<EventGDTLogger> provider8 = DoubleCheck.provider(EventGDTLogger_Factory.create(create2));
            this.eventGDTLoggerProvider = provider8;
            this.sessionFirelogPublisherImplProvider = DoubleCheck.provider(SessionFirelogPublisherImpl_Factory.create(this.firebaseAppProvider, this.firebaseInstallationsApiProvider, this.sessionsSettingsProvider, provider8, this.backgroundDispatcherProvider));
            this.timeProvider = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory.create());
            javax.inject.Provider<UuidGenerator> provider9 = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory.create());
            this.uuidGeneratorProvider = provider9;
            this.sessionGeneratorProvider = DoubleCheck.provider(SessionGenerator_Factory.create(this.timeProvider, provider9));
        }

        public FirebaseSessions getFirebaseSessions() {
            return (FirebaseSessions) this.firebaseSessionsProvider.get();
        }

        public SessionDatastore getSessionDatastore() {
            return (SessionDatastore) this.sessionDatastoreImplProvider.get();
        }

        public SessionFirelogPublisher getSessionFirelogPublisher() {
            return (SessionFirelogPublisher) this.sessionFirelogPublisherImplProvider.get();
        }

        public SessionGenerator getSessionGenerator() {
            return (SessionGenerator) this.sessionGeneratorProvider.get();
        }

        public SessionsSettings getSessionsSettings() {
            return (SessionsSettings) this.sessionsSettingsProvider.get();
        }

        private FirebaseSessionsComponentImpl(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider) {
            this.firebaseSessionsComponentImpl = this;
            initialize(context, coroutineContext, coroutineContext2, firebaseApp, firebaseInstallationsApi, provider);
        }
    }

    private DaggerFirebaseSessionsComponent() {
    }

    public static FirebaseSessionsComponent.Builder builder() {
        return new Builder();
    }
}
