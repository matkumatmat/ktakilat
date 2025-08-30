package com.google.firebase.sessions.settings;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class LocalOverrideSettings_Factory implements Factory<LocalOverrideSettings> {
    private final Provider<Context> appContextProvider;

    public LocalOverrideSettings_Factory(Provider<Context> provider) {
        this.appContextProvider = provider;
    }

    public static LocalOverrideSettings_Factory create(Provider<Context> provider) {
        return new LocalOverrideSettings_Factory(provider);
    }

    public static LocalOverrideSettings newInstance(Context context) {
        return new LocalOverrideSettings(context);
    }

    public LocalOverrideSettings get() {
        return newInstance((Context) this.appContextProvider.get());
    }
}
