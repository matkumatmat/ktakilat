package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Background"})
public final class SessionFirelogPublisherImpl_Factory implements Factory<SessionFirelogPublisherImpl> {
    private final Provider<CoroutineContext> backgroundDispatcherProvider;
    private final Provider<EventGDTLoggerInterface> eventGDTLoggerProvider;
    private final Provider<FirebaseApp> firebaseAppProvider;
    private final Provider<FirebaseInstallationsApi> firebaseInstallationsProvider;
    private final Provider<SessionsSettings> sessionSettingsProvider;

    public SessionFirelogPublisherImpl_Factory(Provider<FirebaseApp> provider, Provider<FirebaseInstallationsApi> provider2, Provider<SessionsSettings> provider3, Provider<EventGDTLoggerInterface> provider4, Provider<CoroutineContext> provider5) {
        this.firebaseAppProvider = provider;
        this.firebaseInstallationsProvider = provider2;
        this.sessionSettingsProvider = provider3;
        this.eventGDTLoggerProvider = provider4;
        this.backgroundDispatcherProvider = provider5;
    }

    public static SessionFirelogPublisherImpl_Factory create(Provider<FirebaseApp> provider, Provider<FirebaseInstallationsApi> provider2, Provider<SessionsSettings> provider3, Provider<EventGDTLoggerInterface> provider4, Provider<CoroutineContext> provider5) {
        return new SessionFirelogPublisherImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SessionFirelogPublisherImpl newInstance(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, SessionsSettings sessionsSettings, EventGDTLoggerInterface eventGDTLoggerInterface, CoroutineContext coroutineContext) {
        return new SessionFirelogPublisherImpl(firebaseApp, firebaseInstallationsApi, sessionsSettings, eventGDTLoggerInterface, coroutineContext);
    }

    public SessionFirelogPublisherImpl get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsProvider.get(), (SessionsSettings) this.sessionSettingsProvider.get(), (EventGDTLoggerInterface) this.eventGDTLoggerProvider.get(), (CoroutineContext) this.backgroundDispatcherProvider.get());
    }
}
