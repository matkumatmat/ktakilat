package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class SessionGenerator_Factory implements Factory<SessionGenerator> {
    private final Provider<TimeProvider> timeProvider;
    private final Provider<UuidGenerator> uuidGeneratorProvider;

    public SessionGenerator_Factory(Provider<TimeProvider> provider, Provider<UuidGenerator> provider2) {
        this.timeProvider = provider;
        this.uuidGeneratorProvider = provider2;
    }

    public static SessionGenerator_Factory create(Provider<TimeProvider> provider, Provider<UuidGenerator> provider2) {
        return new SessionGenerator_Factory(provider, provider2);
    }

    public static SessionGenerator newInstance(TimeProvider timeProvider2, UuidGenerator uuidGenerator) {
        return new SessionGenerator(timeProvider2, uuidGenerator);
    }

    public SessionGenerator get() {
        return newInstance((TimeProvider) this.timeProvider.get(), (UuidGenerator) this.uuidGeneratorProvider.get());
    }
}
