package com.facebook.appevents;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import bolts.AppLinks;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
    private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
    private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
    private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    /* access modifiers changed from: private */
    public static final String TAG = "com.facebook.appevents.AppEventsLogger";
    private static String anonymousAppDeviceGUID;
    /* access modifiers changed from: private */
    public static ScheduledThreadPoolExecutor backgroundExecutor;
    private static FlushBehavior flushBehavior = FlushBehavior.AUTO;
    private static boolean isActivateAppEventRequested;
    private static boolean isOpenedByAppLink;
    private static String pushNotificationsRegistrationId;
    private static String sourceApplication;
    private static Object staticLock = new Object();
    private final AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;

    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    public static class PersistedAppSessionInfo {
        private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
        private static final Runnable appSessionInfoFlushRunnable = new Runnable() {
            public void run() {
                PersistedAppSessionInfo.saveAppSessionInformation(FacebookSdk.getApplicationContext());
            }
        };
        private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap = null;
        private static boolean hasChanges = false;
        private static boolean isLoaded = false;
        private static final Object staticLock = new Object();

        private static FacebookTimeSpentData getTimeSpentData(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
            restoreAppSessionInformation(context);
            FacebookTimeSpentData facebookTimeSpentData = appSessionInfoMap.get(accessTokenAppIdPair);
            if (facebookTimeSpentData != null) {
                return facebookTimeSpentData;
            }
            FacebookTimeSpentData facebookTimeSpentData2 = new FacebookTimeSpentData();
            appSessionInfoMap.put(accessTokenAppIdPair, facebookTimeSpentData2);
            return facebookTimeSpentData2;
        }

        public static void onResume(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j, String str) {
            synchronized (staticLock) {
                getTimeSpentData(context, accessTokenAppIdPair).onResume(appEventsLogger, j, str);
                onTimeSpentDataUpdate();
            }
        }

        public static void onSuspend(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j) {
            synchronized (staticLock) {
                getTimeSpentData(context, accessTokenAppIdPair).onSuspend(appEventsLogger, j);
                onTimeSpentDataUpdate();
            }
        }

        private static void onTimeSpentDataUpdate() {
            if (!hasChanges) {
                hasChanges = true;
                AppEventsLogger.backgroundExecutor.schedule(appSessionInfoFlushRunnable, 30, TimeUnit.SECONDS);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0075 A[Catch:{ all -> 0x003c }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x008b A[Catch:{ all -> 0x003c }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00a3 A[Catch:{ all -> 0x003c }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void restoreAppSessionInformation(android.content.Context r9) {
            /*
                java.lang.String r0 = "Got unexpected exception restoring app session info: "
                java.lang.Object r1 = staticLock
                monitor-enter(r1)
                boolean r2 = isLoaded     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x00ad
                r2 = 0
                r3 = 1
                r4 = 0
                java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ FileNotFoundException -> 0x0097, Exception -> 0x004e, all -> 0x004c }
                java.lang.String r6 = "AppEventsLogger.persistedsessioninfo"
                java.io.FileInputStream r6 = r9.openFileInput(r6)     // Catch:{ FileNotFoundException -> 0x0097, Exception -> 0x004e, all -> 0x004c }
                r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0097, Exception -> 0x004e, all -> 0x004c }
                java.lang.Object r4 = r5.readObject()     // Catch:{ FileNotFoundException -> 0x004a, Exception -> 0x0048 }
                java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ FileNotFoundException -> 0x004a, Exception -> 0x0048 }
                appSessionInfoMap = r4     // Catch:{ FileNotFoundException -> 0x004a, Exception -> 0x0048 }
                com.facebook.LoggingBehavior r4 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ FileNotFoundException -> 0x004a, Exception -> 0x0048 }
                java.lang.String r6 = "AppEvents"
                java.lang.String r7 = "App session info loaded"
                com.facebook.internal.Logger.log(r4, r6, r7)     // Catch:{ FileNotFoundException -> 0x004a, Exception -> 0x0048 }
                com.facebook.internal.Utility.closeQuietly(r5)     // Catch:{ all -> 0x003c }
                java.lang.String r0 = "AppEventsLogger.persistedsessioninfo"
                r9.deleteFile(r0)     // Catch:{ all -> 0x003c }
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r9 = appSessionInfoMap     // Catch:{ all -> 0x003c }
                if (r9 != 0) goto L_0x003f
                java.util.HashMap r9 = new java.util.HashMap     // Catch:{ all -> 0x003c }
                r9.<init>()     // Catch:{ all -> 0x003c }
                appSessionInfoMap = r9     // Catch:{ all -> 0x003c }
                goto L_0x003f
            L_0x003c:
                r9 = move-exception
                goto L_0x00af
            L_0x003f:
                isLoaded = r3     // Catch:{ all -> 0x003c }
            L_0x0041:
                hasChanges = r2     // Catch:{ all -> 0x003c }
                goto L_0x00ad
            L_0x0045:
                r0 = move-exception
                r4 = r5
                goto L_0x007f
            L_0x0048:
                r4 = move-exception
                goto L_0x0052
            L_0x004a:
                r4 = r5
                goto L_0x0097
            L_0x004c:
                r0 = move-exception
                goto L_0x007f
            L_0x004e:
                r5 = move-exception
                r8 = r5
                r5 = r4
                r4 = r8
            L_0x0052:
                java.lang.String r6 = com.facebook.appevents.AppEventsLogger.TAG     // Catch:{ all -> 0x0045 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
                r7.<init>(r0)     // Catch:{ all -> 0x0045 }
                java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0045 }
                r7.append(r0)     // Catch:{ all -> 0x0045 }
                java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0045 }
                android.util.Log.w(r6, r0)     // Catch:{ all -> 0x0045 }
                com.facebook.internal.Utility.closeQuietly(r5)     // Catch:{ all -> 0x003c }
                java.lang.String r0 = "AppEventsLogger.persistedsessioninfo"
                r9.deleteFile(r0)     // Catch:{ all -> 0x003c }
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r9 = appSessionInfoMap     // Catch:{ all -> 0x003c }
                if (r9 != 0) goto L_0x007c
                java.util.HashMap r9 = new java.util.HashMap     // Catch:{ all -> 0x003c }
                r9.<init>()     // Catch:{ all -> 0x003c }
                appSessionInfoMap = r9     // Catch:{ all -> 0x003c }
            L_0x007c:
                isLoaded = r3     // Catch:{ all -> 0x003c }
                goto L_0x0041
            L_0x007f:
                com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x003c }
                java.lang.String r4 = "AppEventsLogger.persistedsessioninfo"
                r9.deleteFile(r4)     // Catch:{ all -> 0x003c }
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r9 = appSessionInfoMap     // Catch:{ all -> 0x003c }
                if (r9 != 0) goto L_0x0092
                java.util.HashMap r9 = new java.util.HashMap     // Catch:{ all -> 0x003c }
                r9.<init>()     // Catch:{ all -> 0x003c }
                appSessionInfoMap = r9     // Catch:{ all -> 0x003c }
            L_0x0092:
                isLoaded = r3     // Catch:{ all -> 0x003c }
                hasChanges = r2     // Catch:{ all -> 0x003c }
                throw r0     // Catch:{ all -> 0x003c }
            L_0x0097:
                com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x003c }
                java.lang.String r0 = "AppEventsLogger.persistedsessioninfo"
                r9.deleteFile(r0)     // Catch:{ all -> 0x003c }
                java.util.Map<com.facebook.appevents.AccessTokenAppIdPair, com.facebook.appevents.FacebookTimeSpentData> r9 = appSessionInfoMap     // Catch:{ all -> 0x003c }
                if (r9 != 0) goto L_0x00aa
                java.util.HashMap r9 = new java.util.HashMap     // Catch:{ all -> 0x003c }
                r9.<init>()     // Catch:{ all -> 0x003c }
                appSessionInfoMap = r9     // Catch:{ all -> 0x003c }
            L_0x00aa:
                isLoaded = r3     // Catch:{ all -> 0x003c }
                goto L_0x0041
            L_0x00ad:
                monitor-exit(r1)     // Catch:{ all -> 0x003c }
                return
            L_0x00af:
                monitor-exit(r1)     // Catch:{ all -> 0x003c }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventsLogger.PersistedAppSessionInfo.restoreAppSessionInformation(android.content.Context):void");
        }

        public static void saveAppSessionInformation(Context context) {
            synchronized (staticLock) {
                if (hasChanges) {
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput(PERSISTED_SESSION_INFO_FILENAME, 0)));
                        try {
                            objectOutputStream2.writeObject(appSessionInfoMap);
                            hasChanges = false;
                            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info saved");
                            Utility.closeQuietly(objectOutputStream2);
                        } catch (Exception e) {
                            e = e;
                            objectOutputStream = objectOutputStream2;
                            try {
                                String access$200 = AppEventsLogger.TAG;
                                Log.w(access$200, "Got unexpected exception while writing app session info: " + e.toString());
                                Utility.closeQuietly(objectOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                Utility.closeQuietly(objectOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream = objectOutputStream2;
                            Utility.closeQuietly(objectOutputStream);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        String access$2002 = AppEventsLogger.TAG;
                        Log.w(access$2002, "Got unexpected exception while writing app session info: " + e.toString());
                        Utility.closeQuietly(objectOutputStream);
                    }
                }
            }
        }
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this(Utility.getActivityName(context), str, accessToken);
    }

    public static void activateApp(Application application) {
        activateApp(application, (String) null);
    }

    public static void clearUserID() {
        AnalyticsUserIDStore.setUserID((String) null);
    }

    @Deprecated
    public static void deactivateApp(Context context) {
        if (ActivityLifecycleTracker.isTracking()) {
            Log.w(TAG, "deactivateApp events are being logged automatically. There's no need to call deactivateApp, this is safe to remove.");
        } else {
            deactivateApp(context, Utility.getMetadataApplicationId(context));
        }
    }

    public static void eagerFlush() {
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    public static Executor getAnalyticsExecutor() {
        if (backgroundExecutor == null) {
            initializeTimersIfNeeded();
        }
        return backgroundExecutor;
    }

    public static String getAnonymousAppDeviceGUID(Context context) {
        if (anonymousAppDeviceGUID == null) {
            synchronized (staticLock) {
                try {
                    if (anonymousAppDeviceGUID == null) {
                        String string = context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getString("anonymousAppDeviceGUID", (String) null);
                        anonymousAppDeviceGUID = string;
                        if (string == null) {
                            anonymousAppDeviceGUID = "XZ" + UUID.randomUUID().toString();
                            context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID).apply();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return anonymousAppDeviceGUID;
    }

    public static FlushBehavior getFlushBehavior() {
        FlushBehavior flushBehavior2;
        synchronized (staticLock) {
            flushBehavior2 = flushBehavior;
        }
        return flushBehavior2;
    }

    public static String getPushNotificationsRegistrationId() {
        String str;
        synchronized (staticLock) {
            str = pushNotificationsRegistrationId;
        }
        return str;
    }

    public static String getSourceApplication() {
        String str;
        if (isOpenedByAppLink) {
            str = "Applink";
        } else {
            str = "Unclassified";
        }
        if (sourceApplication != null) {
            return ba.r(e.s(str, "("), sourceApplication, ")");
        }
        return str;
    }

    public static String getUserID() {
        return AnalyticsUserIDStore.getUserID();
    }

    public static void initializeLib(Context context, String str) {
        backgroundExecutor.execute(new Runnable(new AppEventsLogger(context, str, (AccessToken) null)) {
            final /* synthetic */ AppEventsLogger val$logger;

            {
                this.val$logger = r1;
            }

            public void run() {
                Bundle bundle = new Bundle();
                try {
                    bundle.putInt("core_lib_included", 1);
                } catch (ClassNotFoundException unused) {
                }
                try {
                    bundle.putInt("login_lib_included", 1);
                } catch (ClassNotFoundException unused2) {
                }
                try {
                    bundle.putInt("share_lib_included", 1);
                } catch (ClassNotFoundException unused3) {
                }
                try {
                    bundle.putInt("places_lib_included", 1);
                } catch (ClassNotFoundException unused4) {
                }
                try {
                    bundle.putInt("messenger_lib_included", 1);
                } catch (ClassNotFoundException unused5) {
                }
                try {
                    bundle.putInt("applinks_lib_included", 1);
                } catch (ClassNotFoundException unused6) {
                }
                try {
                    bundle.putInt("all_lib_included", 1);
                } catch (ClassNotFoundException unused7) {
                }
                this.val$logger.logSdkEvent(AnalyticsEvents.EVENT_SDK_INITIALIZE, (Double) null, bundle);
            }
        });
    }

    private static void initializeTimersIfNeeded() {
        synchronized (staticLock) {
            try {
                if (backgroundExecutor == null) {
                    backgroundExecutor = new ScheduledThreadPoolExecutor(1);
                    backgroundExecutor.scheduleAtFixedRate(new Runnable() {
                        public void run() {
                            HashSet hashSet = new HashSet();
                            for (AccessTokenAppIdPair applicationId : AppEventQueue.getKeySet()) {
                                hashSet.add(applicationId.getApplicationId());
                            }
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                FetchedAppSettingsManager.queryAppSettings((String) it.next(), true);
                            }
                        }
                    }, 0, 86400, TimeUnit.SECONDS);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void logAppSessionResumeEvent(long j, String str) {
        PersistedAppSessionInfo.onResume(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, j, str);
    }

    /* access modifiers changed from: private */
    public void logAppSessionSuspendEvent(long j) {
        PersistedAppSessionInfo.onSuspend(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, j);
    }

    public static AppEventsLogger newLogger(Context context) {
        return new AppEventsLogger(context, (String) null, (AccessToken) null);
    }

    private static void notifyDeveloperError(String str) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
    }

    public static void onContextStop() {
        AppEventQueue.persistToDisk();
    }

    public static void resetSourceApplication() {
        sourceApplication = null;
        isOpenedByAppLink = false;
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior2) {
        synchronized (staticLock) {
            flushBehavior = flushBehavior2;
        }
    }

    public static void setPushNotificationsRegistrationId(String str) {
        synchronized (staticLock) {
            try {
                if (!Utility.stringsEqualOrEmpty(pushNotificationsRegistrationId, str)) {
                    pushNotificationsRegistrationId = str;
                    AppEventsLogger newLogger = newLogger(FacebookSdk.getApplicationContext());
                    newLogger.logEvent(AppEventsConstants.EVENT_NAME_PUSH_TOKEN_OBTAINED);
                    if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                        newLogger.flush();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void setSourceApplication(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            String packageName = callingActivity.getPackageName();
            if (packageName.equals(activity.getPackageName())) {
                resetSourceApplication();
                return;
            }
            sourceApplication = packageName;
        }
        Intent intent = activity.getIntent();
        if (intent == null || intent.getBooleanExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false)) {
            resetSourceApplication();
            return;
        }
        Bundle appLinkData = AppLinks.getAppLinkData(intent);
        if (appLinkData == null) {
            resetSourceApplication();
            return;
        }
        isOpenedByAppLink = true;
        Bundle bundle = appLinkData.getBundle("referer_app_link");
        if (bundle == null) {
            sourceApplication = null;
            return;
        }
        sourceApplication = bundle.getString("package");
        intent.putExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
    }

    public static void setUserID(String str) {
        AnalyticsUserIDStore.setUserID(str);
    }

    public static void updateUserProperties(Bundle bundle, GraphRequest.Callback callback) {
        updateUserProperties(bundle, FacebookSdk.getApplicationId(), callback);
    }

    public void flush() {
        AppEventQueue.flush(FlushReason.EXPLICIT);
    }

    public String getApplicationId() {
        return this.accessTokenAppId.getApplicationId();
    }

    public boolean isValidForAccessToken(AccessToken accessToken) {
        return this.accessTokenAppId.equals(new AccessTokenAppIdPair(accessToken));
    }

    public void logEvent(String str) {
        logEvent(str, (Bundle) null);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            Log.w(TAG, "You are logging purchase events while auto-logging of in-app purchase is enabled in the SDK. Make sure you don't log duplicate events");
        }
        logPurchase(bigDecimal, currency, (Bundle) null, false);
    }

    public void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        logPurchase(bigDecimal, currency, bundle, true);
    }

    public void logPushNotificationOpen(Bundle bundle) {
        logPushNotificationOpen(bundle, (String) null);
    }

    public void logSdkEvent(String str, Double d, Bundle bundle) {
        logEvent(str, d, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    public static void activateApp(Application application, String str) {
        if (FacebookSdk.isInitialized()) {
            AnalyticsUserIDStore.initStore();
            if (str == null) {
                str = FacebookSdk.getApplicationId();
            }
            FacebookSdk.publishInstallAsync(application, str);
            ActivityLifecycleTracker.startTracking(application, str);
            return;
        }
        throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
    }

    public static AppEventsLogger newLogger(Context context, AccessToken accessToken) {
        return new AppEventsLogger(context, (String) null, accessToken);
    }

    public void logEvent(String str, double d) {
        logEvent(str, d, (Bundle) null);
    }

    public void logPushNotificationOpen(Bundle bundle, String str) {
        String str2;
        try {
            String string = bundle.getString(PUSH_PAYLOAD_KEY);
            if (!Utility.isNullOrEmpty(string)) {
                str2 = new JSONObject(string).getString("campaign");
                if (str2 == null) {
                    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
                    return;
                }
                Bundle c = e.c(APP_EVENT_PUSH_PARAMETER_CAMPAIGN, str2);
                if (str != null) {
                    c.putString(APP_EVENT_PUSH_PARAMETER_ACTION, str);
                }
                logEvent(APP_EVENT_NAME_PUSH_OPENED, c);
            }
        } catch (JSONException unused) {
            str2 = null;
        }
    }

    public AppEventsLogger(String str, String str2, AccessToken accessToken) {
        Validate.sdkInitialized();
        this.contextName = str;
        accessToken = accessToken == null ? AccessToken.getCurrentAccessToken() : accessToken;
        if (accessToken == null || (str2 != null && !str2.equals(accessToken.getApplicationId()))) {
            this.accessTokenAppId = new AccessTokenAppIdPair((String) null, str2 == null ? Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext()) : str2);
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
        }
        initializeTimersIfNeeded();
    }

    public static AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
        return new AppEventsLogger(context, str, accessToken);
    }

    public static void updateUserProperties(final Bundle bundle, final String str, final GraphRequest.Callback callback) {
        final String userID = getUserID();
        if (userID == null || userID.isEmpty()) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "AppEventsLogger userID cannot be null or empty");
        } else {
            getAnalyticsExecutor().execute(new Runnable() {
                public void run() {
                    Bundle bundle = new Bundle();
                    bundle.putString("user_unique_id", userID);
                    bundle.putBundle("custom_data", bundle);
                    AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                    if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null)) {
                        bundle.putString("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                    }
                    Bundle bundle2 = new Bundle();
                    try {
                        JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(convertToJSON);
                        bundle2.putString("data", jSONArray.toString());
                        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                        Locale locale = Locale.US;
                        GraphRequest graphRequest = new GraphRequest(currentAccessToken, e.l(str, "/user_properties"), bundle2, HttpMethod.POST, callback);
                        graphRequest.setSkipClientToken(true);
                        graphRequest.executeAsync();
                    } catch (JSONException e) {
                        throw new FacebookException("Failed to construct request", (Throwable) e);
                    }
                }
            });
        }
    }

    public void logEvent(String str, Bundle bundle) {
        logEvent(str, (Double) null, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    @Deprecated
    public static void deactivateApp(Context context, String str) {
        if (ActivityLifecycleTracker.isTracking()) {
            Log.w(TAG, "deactivateApp events are being logged automatically. There's no need to call deactivateApp, this is safe to remove.");
        } else if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        } else {
            resetSourceApplication();
            AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, (AccessToken) null);
            final long currentTimeMillis = System.currentTimeMillis();
            backgroundExecutor.execute(new Runnable(appEventsLogger) {
                final /* synthetic */ AppEventsLogger val$logger;

                {
                    this.val$logger = r1;
                }

                public void run() {
                    this.val$logger.logAppSessionSuspendEvent(currentTimeMillis);
                }
            });
        }
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        return new AppEventsLogger(context, str, (AccessToken) null);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            Log.w(TAG, "You are logging purchase events while auto-logging of in-app purchase is enabled in the SDK. Make sure you don't log duplicate events");
        }
        logPurchase(bigDecimal, currency, bundle, false);
    }

    public void logEvent(String str, double d, Bundle bundle) {
        logEvent(str, Double.valueOf(d), bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
    }

    private void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        if (bigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
        } else if (currency == null) {
            notifyDeveloperError("currency cannot be null");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            bundle2.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
            logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, Double.valueOf(bigDecimal.doubleValue()), bundle2, z, ActivityLifecycleTracker.getCurrentSessionGuid());
            eagerFlush();
        }
    }

    @Deprecated
    public static void activateApp(Context context) {
        if (ActivityLifecycleTracker.isTracking()) {
            Log.w(TAG, "activateApp events are being logged automatically. There's no need to call activateApp explicitly, this is safe to remove.");
            return;
        }
        FacebookSdk.sdkInitialize(context);
        activateApp(context, Utility.getMetadataApplicationId(context));
    }

    private void logEvent(String str, Double d, Bundle bundle, boolean z, @Nullable UUID uuid) {
        try {
            logEvent(FacebookSdk.getApplicationContext(), new AppEvent(this.contextName, str, d, bundle, z, uuid), this.accessTokenAppId);
        } catch (JSONException e) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e.toString());
        } catch (FacebookException e2) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", e2.toString());
        }
    }

    @Deprecated
    public static void activateApp(Context context, String str) {
        if (ActivityLifecycleTracker.isTracking()) {
            Log.w(TAG, "activateApp events are being logged automatically. There's no need to call activateApp explicitly, this is safe to remove.");
        } else if (context == null || str == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        } else {
            AnalyticsUserIDStore.initStore();
            if (context instanceof Activity) {
                setSourceApplication((Activity) context);
            } else {
                resetSourceApplication();
            }
            FacebookSdk.publishInstallAsync(context, str);
            AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, (AccessToken) null);
            final long currentTimeMillis = System.currentTimeMillis();
            final String sourceApplication2 = getSourceApplication();
            backgroundExecutor.execute(new Runnable(appEventsLogger) {
                final /* synthetic */ AppEventsLogger val$logger;

                {
                    this.val$logger = r1;
                }

                public void run() {
                    this.val$logger.logAppSessionResumeEvent(currentTimeMillis, sourceApplication2);
                }
            });
        }
    }

    private static void logEvent(Context context, AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        AppEventQueue.add(accessTokenAppIdPair, appEvent);
        if (!appEvent.getIsImplicit() && !isActivateAppEventRequested) {
            if (appEvent.getName() == AppEventsConstants.EVENT_NAME_ACTIVATED_APP) {
                isActivateAppEventRequested = true;
            } else {
                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }
    }

    public static void setSourceApplication(String str, boolean z) {
        sourceApplication = str;
        isOpenedByAppLink = z;
    }
}
