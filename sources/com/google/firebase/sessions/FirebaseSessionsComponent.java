package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.Binds;
import com.google.firebase.sessions.dagger.BindsInstance;
import com.google.firebase.sessions.dagger.Component;
import com.google.firebase.sessions.dagger.Module;
import com.google.firebase.sessions.dagger.Provides;
import com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher;
import com.google.firebase.sessions.settings.LocalOverrideSettings;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.sessions.settings.RemoteSettingsFetcher;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.google.firebase.sessions.settings.SettingsProvider;
import java.util.List;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Component(modules = {MainModule.class})
@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001:\u0002\u0016\u0017R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsComponent;", "", "firebaseSessions", "Lcom/google/firebase/sessions/FirebaseSessions;", "getFirebaseSessions", "()Lcom/google/firebase/sessions/FirebaseSessions;", "sessionDatastore", "Lcom/google/firebase/sessions/SessionDatastore;", "getSessionDatastore", "()Lcom/google/firebase/sessions/SessionDatastore;", "sessionFirelogPublisher", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "getSessionFirelogPublisher", "()Lcom/google/firebase/sessions/SessionFirelogPublisher;", "sessionGenerator", "Lcom/google/firebase/sessions/SessionGenerator;", "getSessionGenerator", "()Lcom/google/firebase/sessions/SessionGenerator;", "sessionsSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "getSessionsSettings", "()Lcom/google/firebase/sessions/settings/SessionsSettings;", "Builder", "MainModule", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FirebaseSessionsComponent {

    @Component.Builder
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\u0012\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH'J\u0016\u0010\r\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH'¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsComponent$Builder;", "", "appContext", "Landroid/content/Context;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "blockingDispatcher", "build", "Lcom/google/firebase/sessions/FirebaseSessionsComponent;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "transportFactoryProvider", "Lcom/google/firebase/inject/Provider;", "Lcom/google/android/datatransport/TransportFactory;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Builder {
        @NotNull
        @BindsInstance
        Builder appContext(@NotNull Context context);

        @NotNull
        @BindsInstance
        Builder backgroundDispatcher(@NotNull @Background CoroutineContext coroutineContext);

        @NotNull
        @BindsInstance
        Builder blockingDispatcher(@NotNull @Blocking CoroutineContext coroutineContext);

        @NotNull
        FirebaseSessionsComponent build();

        @NotNull
        @BindsInstance
        Builder firebaseApp(@NotNull FirebaseApp firebaseApp);

        @NotNull
        @BindsInstance
        Builder firebaseInstallationsApi(@NotNull FirebaseInstallationsApi firebaseInstallationsApi);

        @NotNull
        @BindsInstance
        Builder transportFactoryProvider(@NotNull Provider<TransportFactory> provider);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\rH'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0016H'¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsComponent$MainModule;", "", "crashlyticsSettingsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "impl", "Lcom/google/firebase/sessions/settings/RemoteSettingsFetcher;", "eventGDTLoggerInterface", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "Lcom/google/firebase/sessions/EventGDTLogger;", "localOverrideSettings", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "Lcom/google/firebase/sessions/settings/LocalOverrideSettings;", "remoteSettings", "Lcom/google/firebase/sessions/settings/RemoteSettings;", "sessionDatastore", "Lcom/google/firebase/sessions/SessionDatastore;", "Lcom/google/firebase/sessions/SessionDatastoreImpl;", "sessionFirelogPublisher", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "Lcom/google/firebase/sessions/SessionFirelogPublisherImpl;", "sessionLifecycleServiceBinder", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinderImpl;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Module
    public interface MainModule {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsComponent$MainModule$Companion;", "", "()V", "TAG", "", "applicationInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "sessionConfigsDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "appContext", "Landroid/content/Context;", "sessionDetailsDataStore", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "uuidGenerator", "Lcom/google/firebase/sessions/UuidGenerator;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            private static final String TAG = "FirebaseSessions";

            private Companion() {
            }

            @Singleton
            @NotNull
            @Provides
            public final ApplicationInfo applicationInfo(@NotNull FirebaseApp firebaseApp) {
                Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
                return SessionEvents.INSTANCE.getApplicationInfo(firebaseApp);
            }

            @Singleton
            @NotNull
            @SessionConfigsDataStore
            @Provides
            public final DataStore<Preferences> sessionConfigsDataStore(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "appContext");
                return PreferenceDataStoreFactory.create$default(PreferenceDataStoreFactory.INSTANCE, new ReplaceFileCorruptionHandler(FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$1.INSTANCE), (List) null, (CoroutineScope) null, (Function0) new FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$2(context), 6, (Object) null);
            }

            @SessionDetailsDataStore
            @Singleton
            @NotNull
            @Provides
            public final DataStore<Preferences> sessionDetailsDataStore(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "appContext");
                return PreferenceDataStoreFactory.create$default(PreferenceDataStoreFactory.INSTANCE, new ReplaceFileCorruptionHandler(FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$1.INSTANCE), (List) null, (CoroutineScope) null, (Function0) new FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$2(context), 6, (Object) null);
            }

            @Singleton
            @NotNull
            @Provides
            public final TimeProvider timeProvider() {
                return TimeProviderImpl.INSTANCE;
            }

            @Singleton
            @NotNull
            @Provides
            public final UuidGenerator uuidGenerator() {
                return UuidGeneratorImpl.INSTANCE;
            }
        }

        @Binds
        @Singleton
        @NotNull
        CrashlyticsSettingsFetcher crashlyticsSettingsFetcher(@NotNull RemoteSettingsFetcher remoteSettingsFetcher);

        @Binds
        @Singleton
        @NotNull
        EventGDTLoggerInterface eventGDTLoggerInterface(@NotNull EventGDTLogger eventGDTLogger);

        @Binds
        @Singleton
        @NotNull
        @LocalOverrideSettingsProvider
        SettingsProvider localOverrideSettings(@NotNull LocalOverrideSettings localOverrideSettings);

        @RemoteSettingsProvider
        @Binds
        @Singleton
        @NotNull
        SettingsProvider remoteSettings(@NotNull RemoteSettings remoteSettings);

        @Binds
        @Singleton
        @NotNull
        SessionDatastore sessionDatastore(@NotNull SessionDatastoreImpl sessionDatastoreImpl);

        @Binds
        @Singleton
        @NotNull
        SessionFirelogPublisher sessionFirelogPublisher(@NotNull SessionFirelogPublisherImpl sessionFirelogPublisherImpl);

        @Binds
        @Singleton
        @NotNull
        SessionLifecycleServiceBinder sessionLifecycleServiceBinder(@NotNull SessionLifecycleServiceBinderImpl sessionLifecycleServiceBinderImpl);
    }

    @NotNull
    FirebaseSessions getFirebaseSessions();

    @NotNull
    SessionDatastore getSessionDatastore();

    @NotNull
    SessionFirelogPublisher getSessionFirelogPublisher();

    @NotNull
    SessionGenerator getSessionGenerator();

    @NotNull
    SessionsSettings getSessionsSettings();
}
