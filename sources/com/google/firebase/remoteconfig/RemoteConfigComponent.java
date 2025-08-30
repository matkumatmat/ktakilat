package com.google.firebase.remoteconfig;

import android.app.Application;
import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHandler;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
public class RemoteConfigComponent {
    public static final String ACTIVATE_FILE_NAME = "activate";
    public static final long CONNECTION_TIMEOUT_IN_SECONDS = 60;
    public static final String DEFAULTS_FILE_NAME = "defaults";
    private static final Clock DEFAULT_CLOCK = DefaultClock.getInstance();
    @VisibleForTesting
    public static final String DEFAULT_NAMESPACE = "firebase";
    private static final Random DEFAULT_RANDOM = new Random();
    public static final String FETCH_FILE_NAME = "fetch";
    private static final String FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX = "frc";
    private static final String PREFERENCES_FILE_NAME = "settings";
    private static final Map<String, FirebaseRemoteConfig> frcNamespaceInstancesStatic = new HashMap();
    @Nullable
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final String appId;
    private final Context context;
    @GuardedBy("this")
    private Map<String, String> customHeaders;
    private final ScheduledExecutorService executor;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    @GuardedBy("this")
    private final Map<String, FirebaseRemoteConfig> frcNamespaceInstances;

    public static class GlobalBackgroundListener implements BackgroundDetector.BackgroundStateChangeListener {
        private static final AtomicReference<GlobalBackgroundListener> INSTANCE = new AtomicReference<>();

        private GlobalBackgroundListener() {
        }

        /* access modifiers changed from: private */
        public static void ensureBackgroundListenerIsRegistered(Context context) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference<GlobalBackgroundListener> atomicReference = INSTANCE;
            if (atomicReference.get() == null) {
                GlobalBackgroundListener globalBackgroundListener = new GlobalBackgroundListener();
                while (!atomicReference.compareAndSet((Object) null, globalBackgroundListener)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                BackgroundDetector.initialize(application);
                BackgroundDetector.getInstance().addListener(globalBackgroundListener);
            }
        }

        public void onBackgroundStateChanged(boolean z) {
            RemoteConfigComponent.notifyRCInstances(z);
        }
    }

    public RemoteConfigComponent(Context context2, @Blocking ScheduledExecutorService scheduledExecutorService, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider) {
        this(context2, scheduledExecutorService, firebaseApp2, firebaseInstallationsApi, firebaseABTesting, provider, true);
    }

    private ConfigCacheClient getCacheClient(String str, String str2) {
        return ConfigCacheClient.getInstance(this.executor, ConfigStorageClient.getInstance(this.context, ba.r(e.u("frc_", this.appId, "_", str, "_"), str2, ".json")));
    }

    private ConfigGetParameterHandler getGetHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(this.executor, configCacheClient, configCacheClient2);
    }

    @VisibleForTesting
    public static ConfigMetadataClient getMetadataClient(Context context2, String str, String str2) {
        return new ConfigMetadataClient(context2.getSharedPreferences(e.o("frc_", str, "_", str2, "_settings"), 0));
    }

    @Nullable
    private static Personalization getPersonalization(FirebaseApp firebaseApp2, String str, Provider<AnalyticsConnector> provider) {
        if (!isPrimaryApp(firebaseApp2) || !str.equals(DEFAULT_NAMESPACE)) {
            return null;
        }
        return new Personalization(provider);
    }

    private static boolean isAbtSupported(FirebaseApp firebaseApp2, String str) {
        if (!str.equals(DEFAULT_NAMESPACE) || !isPrimaryApp(firebaseApp2)) {
            return false;
        }
        return true;
    }

    private static boolean isPrimaryApp(FirebaseApp firebaseApp2) {
        return firebaseApp2.getName().equals(FirebaseApp.DEFAULT_APP_NAME);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ AnalyticsConnector lambda$getFetchHandler$0() {
        return null;
    }

    /* access modifiers changed from: private */
    public static synchronized void notifyRCInstances(boolean z) {
        synchronized (RemoteConfigComponent.class) {
            for (FirebaseRemoteConfig configUpdateBackgroundState : frcNamespaceInstancesStatic.values()) {
                configUpdateBackgroundState.setConfigUpdateBackgroundState(z);
            }
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public synchronized FirebaseRemoteConfig get(String str) {
        ConfigCacheClient cacheClient;
        ConfigCacheClient cacheClient2;
        ConfigCacheClient cacheClient3;
        ConfigMetadataClient metadataClient;
        ConfigGetParameterHandler getHandler;
        try {
            cacheClient = getCacheClient(str, FETCH_FILE_NAME);
            cacheClient2 = getCacheClient(str, ACTIVATE_FILE_NAME);
            cacheClient3 = getCacheClient(str, DEFAULTS_FILE_NAME);
            metadataClient = getMetadataClient(this.context, this.appId, str);
            getHandler = getGetHandler(cacheClient2, cacheClient3);
            Personalization personalization = getPersonalization(this.firebaseApp, str, this.analyticsConnector);
            if (personalization != null) {
                getHandler.addListener(new vd(personalization));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return get(this.firebaseApp, str, this.firebaseInstallations, this.firebaseAbt, this.executor, cacheClient, cacheClient2, cacheClient3, getFetchHandler(str, cacheClient, metadataClient), getHandler, metadataClient);
    }

    public FirebaseRemoteConfig getDefault() {
        return get(DEFAULT_NAMESPACE);
    }

    @VisibleForTesting
    public synchronized ConfigFetchHandler getFetchHandler(String str, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        FirebaseInstallationsApi firebaseInstallationsApi;
        Provider x3Var;
        try {
            firebaseInstallationsApi = this.firebaseInstallations;
            if (isPrimaryApp(this.firebaseApp)) {
                x3Var = this.analyticsConnector;
            } else {
                x3Var = new x3(10);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return new ConfigFetchHandler(firebaseInstallationsApi, x3Var, this.executor, DEFAULT_CLOCK, DEFAULT_RANDOM, configCacheClient, getFrcBackendApiClient(this.firebaseApp.getOptions().getApiKey(), str, configMetadataClient), configMetadataClient, this.customHeaders);
    }

    @VisibleForTesting
    public ConfigFetchHttpClient getFrcBackendApiClient(String str, String str2, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHttpClient(this.context, this.firebaseApp.getOptions().getApplicationId(), str, str2, configMetadataClient.getFetchTimeoutInSeconds(), configMetadataClient.getFetchTimeoutInSeconds());
    }

    public synchronized ConfigRealtimeHandler getRealtime(FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context2, String str, ConfigMetadataClient configMetadataClient) {
        ConfigRealtimeHandler configRealtimeHandler;
        synchronized (this) {
            configRealtimeHandler = new ConfigRealtimeHandler(firebaseApp2, firebaseInstallationsApi, configFetchHandler, configCacheClient, context2, str, configMetadataClient, this.executor);
        }
        return configRealtimeHandler;
    }

    @VisibleForTesting
    public synchronized void setCustomHeaders(Map<String, String> map) {
        this.customHeaders = map;
    }

    @VisibleForTesting
    public RemoteConfigComponent(Context context2, ScheduledExecutorService scheduledExecutorService, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider, boolean z) {
        this.frcNamespaceInstances = new HashMap();
        this.customHeaders = new HashMap();
        this.context = context2;
        this.executor = scheduledExecutorService;
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.analyticsConnector = provider;
        this.appId = firebaseApp2.getOptions().getApplicationId();
        GlobalBackgroundListener.ensureBackgroundListenerIsRegistered(context2);
        if (z) {
            Tasks.call(scheduledExecutorService, new q1(this, 6));
        }
    }

    @VisibleForTesting
    public synchronized FirebaseRemoteConfig get(FirebaseApp firebaseApp2, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor2, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        FirebaseRemoteConfig firebaseRemoteConfig;
        String str2 = str;
        synchronized (this) {
            try {
                if (!this.frcNamespaceInstances.containsKey(str2)) {
                    Context context2 = this.context;
                    FirebaseABTesting firebaseABTesting2 = isAbtSupported(firebaseApp2, str) ? firebaseABTesting : null;
                    FirebaseRemoteConfig firebaseRemoteConfig2 = r10;
                    FirebaseRemoteConfig firebaseRemoteConfig3 = new FirebaseRemoteConfig(context2, firebaseApp2, firebaseInstallationsApi, firebaseABTesting2, executor2, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient, getRealtime(firebaseApp2, firebaseInstallationsApi, configFetchHandler, configCacheClient2, this.context, str, configMetadataClient));
                    firebaseRemoteConfig2.startLoadingConfigsFromDisk();
                    this.frcNamespaceInstances.put(str2, firebaseRemoteConfig2);
                    frcNamespaceInstancesStatic.put(str2, firebaseRemoteConfig2);
                }
                firebaseRemoteConfig = this.frcNamespaceInstances.get(str2);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return firebaseRemoteConfig;
    }
}
