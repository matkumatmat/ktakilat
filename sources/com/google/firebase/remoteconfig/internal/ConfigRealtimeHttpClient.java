package com.google.firebase.remoteconfig.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.net.HttpHeaders;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.remoteconfig.BuildConfig;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.BooleanUtils;
import org.json.JSONObject;

public class ConfigRealtimeHttpClient {
    private static final String API_KEY_HEADER = "X-Goog-Api-Key";
    @VisibleForTesting
    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = {2, 4, 8, 16, 32, 64, 128, 256};
    private static final Pattern GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private static final String INSTALLATIONS_AUTH_TOKEN_HEADER = "X-Goog-Firebase-Installations-Auth";
    private static final String X_ACCEPT_RESPONSE_STREAMING = "X-Accept-Response-Streaming";
    private static final String X_ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String X_ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String X_GOOGLE_GFE_CAN_RETRY = "X-Google-GFE-Can-Retry";
    private final int ORIGINAL_RETRIES = 8;
    ConfigCacheClient activatedCache;
    private final Clock clock;
    private final ConfigFetchHandler configFetchHandler;
    private final Context context;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    @GuardedBy("this")
    private int httpRetriesRemaining;
    @GuardedBy("this")
    private boolean isHttpConnectionRunning;
    private boolean isInBackground;
    @GuardedBy("this")
    private boolean isRealtimeDisabled;
    @GuardedBy("this")
    private final Set<ConfigUpdateListener> listeners;
    private final ConfigMetadataClient metadataClient;
    private final String namespace;
    private final Random random;
    private final ScheduledExecutorService scheduledExecutorService;

    public ConfigRealtimeHttpClient(FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler2, ConfigCacheClient configCacheClient, Context context2, String str, Set<ConfigUpdateListener> set, ConfigMetadataClient configMetadataClient, ScheduledExecutorService scheduledExecutorService2) {
        this.listeners = set;
        this.isHttpConnectionRunning = false;
        this.scheduledExecutorService = scheduledExecutorService2;
        this.random = new Random();
        this.httpRetriesRemaining = Math.max(8 - configMetadataClient.getRealtimeBackoffMetadata().getNumFailedStreams(), 1);
        this.clock = DefaultClock.getInstance();
        this.firebaseApp = firebaseApp2;
        this.configFetchHandler = configFetchHandler2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.activatedCache = configCacheClient;
        this.context = context2;
        this.namespace = str;
        this.metadataClient = configMetadataClient;
        this.isRealtimeDisabled = false;
        this.isInBackground = false;
    }

    private synchronized boolean canMakeHttpStreamConnection() {
        boolean z;
        if (this.listeners.isEmpty() || this.isHttpConnectionRunning || this.isRealtimeDisabled || this.isInBackground) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    private JSONObject createRequestBody(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("project", extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()));
        hashMap.put("namespace", this.namespace);
        hashMap.put("lastKnownVersionNumber", Long.toString(this.configFetchHandler.getTemplateVersionNumber()));
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_ID, this.firebaseApp.getOptions().getApplicationId());
        hashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, BuildConfig.VERSION_NAME);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.INSTANCE_ID, str);
        return new JSONObject(hashMap);
    }

    /* access modifiers changed from: private */
    public synchronized void enableBackoff() {
        this.isRealtimeDisabled = true;
    }

    private static String extractProjectNumberFromAppId(String str) {
        Matcher matcher = GMP_APP_ID_PATTERN.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    private String getFingerprintHashForPackage() {
        try {
            Context context2 = this.context;
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context2, context2.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e(FirebaseRemoteConfig.TAG, "Could not get fingerprint hash for package: " + this.context.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            this.context.getPackageName();
            return null;
        }
    }

    private long getRandomizedBackoffDurationInMillis(int i) {
        int[] iArr = BACKOFF_TIME_DURATIONS_IN_MINUTES;
        int length = iArr.length;
        if (i >= length) {
            i = length;
        }
        long millis = TimeUnit.MINUTES.toMillis((long) iArr[i - 1]);
        return (millis / 2) + ((long) this.random.nextInt((int) millis));
    }

    private String getRealtimeURL(String str) {
        return e.o("https://firebaseremoteconfigrealtime.googleapis.com/v1/projects/", extractProjectNumberFromAppId(this.firebaseApp.getOptions().getApplicationId()), "/namespaces/", str, ":streamFetchInvalidations");
    }

    private URL getUrl() {
        try {
            return new URL(getRealtimeURL(this.namespace));
        } catch (MalformedURLException unused) {
            Log.e(FirebaseRemoteConfig.TAG, "URL is malformed");
            return null;
        }
    }

    private boolean isStatusCodeRetryable(int i) {
        return i == 408 || i == 429 || i == 502 || i == 503 || i == 504;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ com.google.android.gms.tasks.Task lambda$beginRealtimeHttpStream$1(com.google.android.gms.tasks.Task r12, com.google.android.gms.tasks.Task r13) throws java.lang.Exception {
        /*
            r11 = this;
            r13 = 0
            r0 = 1
            java.lang.String r1 = "Unable to connect to the server. Try again in a few minutes. HTTP status code: %d"
            r2 = 403(0x193, float:5.65E-43)
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 0
            boolean r5 = r12.isSuccessful()     // Catch:{ IOException -> 0x0087, all -> 0x0082 }
            if (r5 == 0) goto L_0x008b
            r11.setIsHttpConnectionRunning(r0)     // Catch:{ IOException -> 0x0087, all -> 0x0082 }
            java.lang.Object r12 = r12.getResult()     // Catch:{ IOException -> 0x0087, all -> 0x0082 }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ IOException -> 0x0087, all -> 0x0082 }
            int r5 = r12.getResponseCode()     // Catch:{ IOException -> 0x007e, all -> 0x007a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x007e, all -> 0x007a }
            if (r5 != r3) goto L_0x0038
            r11.resetRetryCount()     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            com.google.firebase.remoteconfig.internal.ConfigMetadataClient r7 = r11.metadataClient     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            r7.resetRealtimeBackoff()     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            com.google.firebase.remoteconfig.internal.ConfigAutoFetch r7 = r11.startAutoFetch(r12)     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            r7.listenForNotifications()     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            goto L_0x0038
        L_0x0032:
            r4 = move-exception
            goto L_0x0095
        L_0x0035:
            goto L_0x00ec
        L_0x0038:
            r11.closeRealtimeHttpStream(r12)
            r11.setIsHttpConnectionRunning(r13)
            boolean r7 = r11.isStatusCodeRetryable(r5)
            if (r7 == 0) goto L_0x0052
            java.util.Date r8 = new java.util.Date
            com.google.android.gms.common.util.Clock r9 = r11.clock
            long r9 = r9.currentTimeMillis()
            r8.<init>(r9)
            r11.updateBackoffMetadataWithLastFailedStreamConnectionTime(r8)
        L_0x0052:
            if (r7 != 0) goto L_0x0075
            if (r5 != r3) goto L_0x0057
            goto L_0x0075
        L_0x0057:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r13] = r6
            java.lang.String r13 = java.lang.String.format(r1, r0)
            if (r5 != r2) goto L_0x0069
            java.io.InputStream r12 = r12.getErrorStream()
            java.lang.String r13 = r11.parseForbiddenErrorResponseMessage(r12)
        L_0x0069:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r12 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r0 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR
            r12.<init>((int) r5, (java.lang.String) r13, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r0)
        L_0x0070:
            r11.propagateErrors(r12)
            goto L_0x013f
        L_0x0075:
            r11.retryHttpConnectionWhenBackoffEnds()
            goto L_0x013f
        L_0x007a:
            r5 = move-exception
            r6 = r4
            r4 = r5
            goto L_0x0095
        L_0x007e:
            r6 = r4
            goto L_0x00ec
        L_0x0082:
            r12 = move-exception
            r6 = r4
            r4 = r12
            r12 = r6
            goto L_0x0095
        L_0x0087:
            r12 = r4
            r6 = r12
            goto L_0x00ec
        L_0x008b:
            java.io.IOException r5 = new java.io.IOException     // Catch:{ IOException -> 0x0087, all -> 0x0082 }
            java.lang.Exception r12 = r12.getException()     // Catch:{ IOException -> 0x0087, all -> 0x0082 }
            r5.<init>(r12)     // Catch:{ IOException -> 0x0087, all -> 0x0082 }
            throw r5     // Catch:{ IOException -> 0x0087, all -> 0x0082 }
        L_0x0095:
            r11.closeRealtimeHttpStream(r12)
            r11.setIsHttpConnectionRunning(r13)
            if (r6 == 0) goto L_0x00aa
            int r5 = r6.intValue()
            boolean r5 = r11.isStatusCodeRetryable(r5)
            if (r5 == 0) goto L_0x00a8
            goto L_0x00aa
        L_0x00a8:
            r5 = 0
            goto L_0x00ab
        L_0x00aa:
            r5 = 1
        L_0x00ab:
            if (r5 == 0) goto L_0x00bb
            java.util.Date r7 = new java.util.Date
            com.google.android.gms.common.util.Clock r8 = r11.clock
            long r8 = r8.currentTimeMillis()
            r7.<init>(r8)
            r11.updateBackoffMetadataWithLastFailedStreamConnectionTime(r7)
        L_0x00bb:
            if (r5 != 0) goto L_0x00e8
            int r5 = r6.intValue()
            if (r5 == r3) goto L_0x00e8
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r13] = r6
            java.lang.String r13 = java.lang.String.format(r1, r0)
            int r0 = r6.intValue()
            if (r0 != r2) goto L_0x00d9
            java.io.InputStream r12 = r12.getErrorStream()
            java.lang.String r13 = r11.parseForbiddenErrorResponseMessage(r12)
        L_0x00d9:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r12 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException
            int r0 = r6.intValue()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r1 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR
            r12.<init>((int) r0, (java.lang.String) r13, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r1)
            r11.propagateErrors(r12)
            goto L_0x00eb
        L_0x00e8:
            r11.retryHttpConnectionWhenBackoffEnds()
        L_0x00eb:
            throw r4
        L_0x00ec:
            r11.closeRealtimeHttpStream(r12)
            r11.setIsHttpConnectionRunning(r13)
            if (r6 == 0) goto L_0x0101
            int r5 = r6.intValue()
            boolean r5 = r11.isStatusCodeRetryable(r5)
            if (r5 == 0) goto L_0x00ff
            goto L_0x0101
        L_0x00ff:
            r5 = 0
            goto L_0x0102
        L_0x0101:
            r5 = 1
        L_0x0102:
            if (r5 == 0) goto L_0x0112
            java.util.Date r7 = new java.util.Date
            com.google.android.gms.common.util.Clock r8 = r11.clock
            long r8 = r8.currentTimeMillis()
            r7.<init>(r8)
            r11.updateBackoffMetadataWithLastFailedStreamConnectionTime(r7)
        L_0x0112:
            if (r5 != 0) goto L_0x0075
            int r5 = r6.intValue()
            if (r5 != r3) goto L_0x011c
            goto L_0x0075
        L_0x011c:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r13] = r6
            java.lang.String r13 = java.lang.String.format(r1, r0)
            int r0 = r6.intValue()
            if (r0 != r2) goto L_0x0132
            java.io.InputStream r12 = r12.getErrorStream()
            java.lang.String r13 = r11.parseForbiddenErrorResponseMessage(r12)
        L_0x0132:
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r12 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException
            int r0 = r6.intValue()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r1 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR
            r12.<init>((int) r0, (java.lang.String) r13, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r1)
            goto L_0x0070
        L_0x013f:
            com.google.android.gms.tasks.Task r12 = com.google.android.gms.tasks.Tasks.forResult(r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.lambda$beginRealtimeHttpStream$1(com.google.android.gms.tasks.Task, com.google.android.gms.tasks.Task):com.google.android.gms.tasks.Task");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$createRealtimeConnection$0(Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for config update listener connection.", (Throwable) task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for config update listener connection.", (Throwable) task2.getException()));
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) getUrl().openConnection();
            setRequestParams(httpURLConnection, (String) task2.getResult(), ((InstallationTokenResult) task.getResult()).getToken());
            return Tasks.forResult(httpURLConnection);
        } catch (IOException e) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to open HTTP stream connection", (Throwable) e));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void makeRealtimeHttpConnection(long r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.canMakeHttpStreamConnection()     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            int r0 = r3.httpRetriesRemaining     // Catch:{ all -> 0x001e }
            if (r0 <= 0) goto L_0x0020
            int r0 = r0 + -1
            r3.httpRetriesRemaining = r0     // Catch:{ all -> 0x001e }
            java.util.concurrent.ScheduledExecutorService r0 = r3.scheduledExecutorService     // Catch:{ all -> 0x001e }
            com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient$1 r1 = new com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient$1     // Catch:{ all -> 0x001e }
            r1.<init>()     // Catch:{ all -> 0x001e }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x001e }
            r0.schedule(r1, r4, r2)     // Catch:{ all -> 0x001e }
            goto L_0x0030
        L_0x001e:
            r4 = move-exception
            goto L_0x0032
        L_0x0020:
            boolean r4 = r3.isInBackground     // Catch:{ all -> 0x001e }
            if (r4 != 0) goto L_0x0030
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r4 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException     // Catch:{ all -> 0x001e }
            java.lang.String r5 = "Unable to connect to the server. Check your connection and try again."
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r0 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR     // Catch:{ all -> 0x001e }
            r4.<init>((java.lang.String) r5, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r0)     // Catch:{ all -> 0x001e }
            r3.propagateErrors(r4)     // Catch:{ all -> 0x001e }
        L_0x0030:
            monitor-exit(r3)
            return
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x001e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient.makeRealtimeHttpConnection(long):void");
    }

    private String parseForbiddenErrorResponseMessage(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException unused) {
            if (sb.length() == 0) {
                return "Unable to connect to the server, access is forbidden. HTTP status code: 403";
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public synchronized void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        for (ConfigUpdateListener onError : this.listeners) {
            onError.onError(firebaseRemoteConfigException);
        }
    }

    private synchronized void resetRetryCount() {
        this.httpRetriesRemaining = 8;
    }

    private void setCommonRequestHeaders(HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setRequestProperty(INSTALLATIONS_AUTH_TOKEN_HEADER, str);
        httpURLConnection.setRequestProperty(API_KEY_HEADER, this.firebaseApp.getOptions().getApiKey());
        httpURLConnection.setRequestProperty(X_ANDROID_PACKAGE_HEADER, this.context.getPackageName());
        httpURLConnection.setRequestProperty(X_ANDROID_CERT_HEADER, getFingerprintHashForPackage());
        httpURLConnection.setRequestProperty(X_GOOGLE_GFE_CAN_RETRY, BooleanUtils.YES);
        httpURLConnection.setRequestProperty(X_ACCEPT_RESPONSE_STREAMING, "true");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
    }

    private synchronized void setIsHttpConnectionRunning(boolean z) {
        this.isHttpConnectionRunning = z;
    }

    private void updateBackoffMetadataWithLastFailedStreamConnectionTime(Date date) {
        int numFailedStreams = this.metadataClient.getRealtimeBackoffMetadata().getNumFailedStreams() + 1;
        this.metadataClient.setRealtimeBackoffMetadata(numFailedStreams, new Date(date.getTime() + getRandomizedBackoffDurationInMillis(numFailedStreams)));
    }

    @SuppressLint({"VisibleForTests", "DefaultLocale"})
    public void beginRealtimeHttpStream() {
        if (canMakeHttpStreamConnection()) {
            if (new Date(this.clock.currentTimeMillis()).before(this.metadataClient.getRealtimeBackoffMetadata().getBackoffEndTime())) {
                retryHttpConnectionWhenBackoffEnds();
                return;
            }
            Task<HttpURLConnection> createRealtimeConnection = createRealtimeConnection();
            Tasks.whenAllComplete((Task<?>[]) new Task[]{createRealtimeConnection}).continueWith(this.scheduledExecutorService, new t2(4, this, createRealtimeConnection));
        }
    }

    public void closeRealtimeHttpStream(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                httpURLConnection.getInputStream().close();
                if (httpURLConnection.getErrorStream() != null) {
                    httpURLConnection.getErrorStream().close();
                }
            } catch (IOException unused) {
            }
        }
    }

    @SuppressLint({"VisibleForTests"})
    public Task<HttpURLConnection> createRealtimeConnection() {
        Task<InstallationTokenResult> token = this.firebaseInstallations.getToken(false);
        Task<String> id = this.firebaseInstallations.getId();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{token, id}).continueWithTask(this.scheduledExecutorService, new g4(this, 0, token, id));
    }

    @SuppressLint({"VisibleForTests"})
    public Date getBackoffEndTime() {
        return this.metadataClient.getRealtimeBackoffMetadata().getBackoffEndTime();
    }

    @SuppressLint({"VisibleForTests"})
    public int getNumberOfFailedStreams() {
        return this.metadataClient.getRealtimeBackoffMetadata().getNumFailedStreams();
    }

    @SuppressLint({"VisibleForTests"})
    public synchronized void retryHttpConnectionWhenBackoffEnds() {
        makeRealtimeHttpConnection(Math.max(0, this.metadataClient.getRealtimeBackoffMetadata().getBackoffEndTime().getTime() - new Date(this.clock.currentTimeMillis()).getTime()));
    }

    public void setRealtimeBackgroundState(boolean z) {
        this.isInBackground = z;
    }

    @SuppressLint({"VisibleForTests"})
    public void setRequestParams(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
        setCommonRequestHeaders(httpURLConnection, str2);
        byte[] bytes = createRequestBody(str).toString().getBytes("utf-8");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    @SuppressLint({"VisibleForTests"})
    public synchronized ConfigAutoFetch startAutoFetch(HttpURLConnection httpURLConnection) {
        HttpURLConnection httpURLConnection2;
        httpURLConnection2 = httpURLConnection;
        return new ConfigAutoFetch(httpURLConnection2, this.configFetchHandler, this.activatedCache, this.listeners, new ConfigUpdateListener() {
            public void onError(@NonNull FirebaseRemoteConfigException firebaseRemoteConfigException) {
                ConfigRealtimeHttpClient.this.enableBackoff();
                ConfigRealtimeHttpClient.this.propagateErrors(firebaseRemoteConfigException);
            }

            public void onUpdate(@NonNull ConfigUpdate configUpdate) {
            }
        }, this.scheduledExecutorService);
    }

    public void startHttpConnection() {
        makeRealtimeHttpConnection(0);
    }
}
