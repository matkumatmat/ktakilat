package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"com.google.firebase.sessions.SessionDetailsDataStore"})
public final class FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory implements Factory<DataStore<Preferences>> {
    private final Provider<Context> appContextProvider;

    public FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory create(Provider<Context> provider) {
        return new FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(provider);
    }

    public static DataStore<Preferences> sessionDetailsDataStore(Context context) {
        return (DataStore) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.Companion.sessionDetailsDataStore(context));
    }

    public DataStore<Preferences> get() {
        return sessionDetailsDataStore((Context) this.appContextProvider.get());
    }
}
