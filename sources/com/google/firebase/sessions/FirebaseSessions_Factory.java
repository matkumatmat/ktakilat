package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
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
public final class FirebaseSessions_Factory implements Factory<FirebaseSessions> {
    private final Provider<CoroutineContext> backgroundDispatcherProvider;
    private final Provider<FirebaseApp> firebaseAppProvider;
    private final Provider<SessionLifecycleServiceBinder> lifecycleServiceBinderProvider;
    private final Provider<SessionsSettings> settingsProvider;

    public FirebaseSessions_Factory(Provider<FirebaseApp> provider, Provider<SessionsSettings> provider2, Provider<CoroutineContext> provider3, Provider<SessionLifecycleServiceBinder> provider4) {
        this.firebaseAppProvider = provider;
        this.settingsProvider = provider2;
        this.backgroundDispatcherProvider = provider3;
        this.lifecycleServiceBinderProvider = provider4;
    }

    public static FirebaseSessions_Factory create(Provider<FirebaseApp> provider, Provider<SessionsSettings> provider2, Provider<CoroutineContext> provider3, Provider<SessionLifecycleServiceBinder> provider4) {
        return new FirebaseSessions_Factory(provider, provider2, provider3, provider4);
    }

    public static FirebaseSessions newInstance(FirebaseApp firebaseApp, SessionsSettings sessionsSettings, CoroutineContext coroutineContext, SessionLifecycleServiceBinder sessionLifecycleServiceBinder) {
        return new FirebaseSessions(firebaseApp, sessionsSettings, coroutineContext, sessionLifecycleServiceBinder);
    }

    public FirebaseSessions get() {
        return newInstance((FirebaseApp) this.firebaseAppProvider.get(), (SessionsSettings) this.settingsProvider.get(), (CoroutineContext) this.backgroundDispatcherProvider.get(), (SessionLifecycleServiceBinder) this.lifecycleServiceBinderProvider.get());
    }
}
