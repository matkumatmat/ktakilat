package com.google.firebase.perf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.logging.ConsoleUrlGenerator;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FirebasePerformance implements FirebasePerformanceAttributable {
    private static final int MAX_ATTRIBUTE_KEY_LENGTH = 40;
    private static final int MAX_ATTRIBUTE_VALUE_LENGTH = 100;
    private static final int MAX_TRACE_CUSTOM_ATTRIBUTES = 5;
    public static final int MAX_TRACE_NAME_LENGTH = 100;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ConfigResolver configResolver;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final Provider<RemoteConfigComponent> firebaseRemoteConfigProvider;
    private final Map<String, String> mCustomAttributes = new ConcurrentHashMap();
    private final ImmutableBundle mMetadataBundle;
    @Nullable
    private Boolean mPerformanceCollectionForceEnabledState = null;
    private final Provider<TransportFactory> transportFactoryProvider;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {
        public static final String CONNECT = "CONNECT";
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTIONS = "OPTIONS";
        public static final String PATCH = "PATCH";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String TRACE = "TRACE";
    }

    @Inject
    @VisibleForTesting
    public FirebasePerformance(FirebaseApp firebaseApp2, Provider<RemoteConfigComponent> provider, FirebaseInstallationsApi firebaseInstallationsApi2, Provider<TransportFactory> provider2, RemoteConfigManager remoteConfigManager, ConfigResolver configResolver2, SessionManager sessionManager) {
        this.firebaseApp = firebaseApp2;
        this.firebaseRemoteConfigProvider = provider;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.transportFactoryProvider = provider2;
        if (firebaseApp2 == null) {
            this.mPerformanceCollectionForceEnabledState = Boolean.FALSE;
            this.configResolver = configResolver2;
            this.mMetadataBundle = new ImmutableBundle(new Bundle());
            return;
        }
        TransportManager.getInstance().initialize(firebaseApp2, firebaseInstallationsApi2, provider2);
        Context applicationContext = firebaseApp2.getApplicationContext();
        ImmutableBundle extractMetadata = extractMetadata(applicationContext);
        this.mMetadataBundle = extractMetadata;
        remoteConfigManager.setFirebaseRemoteConfigProvider(provider);
        this.configResolver = configResolver2;
        configResolver2.setMetadataBundle(extractMetadata);
        configResolver2.setApplicationContext(applicationContext);
        sessionManager.setApplicationContext(applicationContext);
        this.mPerformanceCollectionForceEnabledState = configResolver2.getIsPerformanceCollectionEnabled();
        AndroidLogger androidLogger = logger;
        if (androidLogger.isLogcatEnabled() && isPerformanceCollectionEnabled()) {
            String generateDashboardUrl = ConsoleUrlGenerator.generateDashboardUrl(firebaseApp2.getOptions().getProjectId(), applicationContext.getPackageName());
            androidLogger.info("Firebase Performance Monitoring is successfully initialized! In a minute, visit the Firebase console to view your data: " + generateDashboardUrl);
        }
    }

    private void checkAttribute(@Nullable String str, @Nullable String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Attribute must not have null key or value.");
        } else if (this.mCustomAttributes.containsKey(str) || this.mCustomAttributes.size() < 5) {
            PerfMetricValidator.validateAttribute(str, str2);
        } else {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("Exceeds max limit of number of attributes - 5");
        }
    }

    private static ImmutableBundle extractMetadata(Context context) {
        Bundle bundle;
        ImmutableBundle immutableBundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            e.getMessage();
            bundle = null;
        }
        if (bundle == null) {
            immutableBundle = new ImmutableBundle();
        }
        return immutableBundle;
    }

    @NonNull
    public static FirebasePerformance getInstance() {
        return (FirebasePerformance) FirebaseApp.getInstance().get(FirebasePerformance.class);
    }

    @NonNull
    public static Trace startTrace(@NonNull String str) {
        Trace create = Trace.create(str);
        create.start();
        return create;
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        return this.mCustomAttributes.get(str);
    }

    @NonNull
    public Map<String, String> getAttributes() {
        return new HashMap(this.mCustomAttributes);
    }

    @VisibleForTesting
    public Boolean getPerformanceCollectionForceEnabledState() {
        return this.mPerformanceCollectionForceEnabledState;
    }

    public boolean isPerformanceCollectionEnabled() {
        Boolean bool = this.mPerformanceCollectionForceEnabledState;
        if (bool != null) {
            return bool.booleanValue();
        }
        return FirebaseApp.getInstance().isDataCollectionDefaultEnabled();
    }

    @NonNull
    public HttpMetric newHttpMetric(@NonNull String str, @NonNull String str2) {
        return new HttpMetric(str, str2, TransportManager.getInstance(), new Timer());
    }

    @NonNull
    public Trace newTrace(@NonNull String str) {
        return Trace.create(str);
    }

    public void putAttribute(@NonNull String str, @NonNull String str2) {
        boolean z = false;
        try {
            str = str.trim();
            str2 = str2.trim();
            checkAttribute(str, str2);
            z = true;
        } catch (Exception e) {
            logger.error("Can not set attribute %s with value %s (%s)", str, str2, e.getMessage());
        }
        if (z) {
            this.mCustomAttributes.put(str, str2);
        }
    }

    public void removeAttribute(@NonNull String str) {
        this.mCustomAttributes.remove(str);
    }

    public void setPerformanceCollectionEnabled(boolean z) {
        setPerformanceCollectionEnabled(Boolean.valueOf(z));
    }

    @NonNull
    public HttpMetric newHttpMetric(@NonNull URL url, @NonNull String str) {
        return new HttpMetric(url, str, TransportManager.getInstance(), new Timer());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setPerformanceCollectionEnabled(@androidx.annotation.Nullable java.lang.Boolean r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.firebase.FirebaseApp.getInstance()     // Catch:{ IllegalStateException -> 0x0054 }
            com.google.firebase.perf.config.ConfigResolver r0 = r1.configResolver     // Catch:{ all -> 0x0019 }
            java.lang.Boolean r0 = r0.getIsPerformanceCollectionDeactivated()     // Catch:{ all -> 0x0019 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x001b
            com.google.firebase.perf.logging.AndroidLogger r2 = logger     // Catch:{ all -> 0x0019 }
            java.lang.String r0 = "Firebase Performance is permanently disabled"
            r2.info(r0)     // Catch:{ all -> 0x0019 }
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            goto L_0x0052
        L_0x001b:
            com.google.firebase.perf.config.ConfigResolver r0 = r1.configResolver     // Catch:{ all -> 0x0019 }
            r0.setIsPerformanceCollectionEnabled(r2)     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x0025
            r1.mPerformanceCollectionForceEnabledState = r2     // Catch:{ all -> 0x0019 }
            goto L_0x002d
        L_0x0025:
            com.google.firebase.perf.config.ConfigResolver r2 = r1.configResolver     // Catch:{ all -> 0x0019 }
            java.lang.Boolean r2 = r2.getIsPerformanceCollectionEnabled()     // Catch:{ all -> 0x0019 }
            r1.mPerformanceCollectionForceEnabledState = r2     // Catch:{ all -> 0x0019 }
        L_0x002d:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0019 }
            java.lang.Boolean r0 = r1.mPerformanceCollectionForceEnabledState     // Catch:{ all -> 0x0019 }
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x003f
            com.google.firebase.perf.logging.AndroidLogger r2 = logger     // Catch:{ all -> 0x0019 }
            java.lang.String r0 = "Firebase Performance is Enabled"
            r2.info(r0)     // Catch:{ all -> 0x0019 }
            goto L_0x0050
        L_0x003f:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0019 }
            java.lang.Boolean r0 = r1.mPerformanceCollectionForceEnabledState     // Catch:{ all -> 0x0019 }
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x0050
            com.google.firebase.perf.logging.AndroidLogger r2 = logger     // Catch:{ all -> 0x0019 }
            java.lang.String r0 = "Firebase Performance is Disabled"
            r2.info(r0)     // Catch:{ all -> 0x0019 }
        L_0x0050:
            monitor-exit(r1)
            return
        L_0x0052:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x0054:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.FirebasePerformance.setPerformanceCollectionEnabled(java.lang.Boolean):void");
    }
}
