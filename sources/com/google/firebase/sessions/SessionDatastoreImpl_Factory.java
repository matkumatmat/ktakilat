package com.google.firebase.sessions;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"com.google.firebase.annotations.concurrent.Background", "com.google.firebase.sessions.SessionDetailsDataStore"})
public final class SessionDatastoreImpl_Factory implements Factory<SessionDatastoreImpl> {
    private final Provider<CoroutineContext> backgroundDispatcherProvider;
    private final Provider<DataStore<Preferences>> dataStoreProvider;

    public SessionDatastoreImpl_Factory(Provider<CoroutineContext> provider, Provider<DataStore<Preferences>> provider2) {
        this.backgroundDispatcherProvider = provider;
        this.dataStoreProvider = provider2;
    }

    public static SessionDatastoreImpl_Factory create(Provider<CoroutineContext> provider, Provider<DataStore<Preferences>> provider2) {
        return new SessionDatastoreImpl_Factory(provider, provider2);
    }

    public static SessionDatastoreImpl newInstance(CoroutineContext coroutineContext, DataStore<Preferences> dataStore) {
        return new SessionDatastoreImpl(coroutineContext, dataStore);
    }

    public SessionDatastoreImpl get() {
        return newInstance((CoroutineContext) this.backgroundDispatcherProvider.get(), (DataStore) this.dataStoreProvider.get());
    }
}
