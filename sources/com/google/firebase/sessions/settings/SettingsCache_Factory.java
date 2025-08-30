package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"com.google.firebase.sessions.SessionConfigsDataStore"})
public final class SettingsCache_Factory implements Factory<SettingsCache> {
    private final Provider<DataStore<Preferences>> dataStoreProvider;

    public SettingsCache_Factory(Provider<DataStore<Preferences>> provider) {
        this.dataStoreProvider = provider;
    }

    public static SettingsCache_Factory create(Provider<DataStore<Preferences>> provider) {
        return new SettingsCache_Factory(provider);
    }

    public static SettingsCache newInstance(DataStore<Preferences> dataStore) {
        return new SettingsCache(dataStore);
    }

    public SettingsCache get() {
        return newInstance((DataStore) this.dataStoreProvider.get());
    }
}
