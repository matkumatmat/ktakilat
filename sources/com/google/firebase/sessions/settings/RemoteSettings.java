package com.google.firebase.sessions.settings;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nRemoteSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteSettings.kt\ncom/google/firebase/sessions/settings/RemoteSettings\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,171:1\n120#2,10:172\n*S KotlinDebug\n*F\n+ 1 RemoteSettings.kt\ncom/google/firebase/sessions/settings/RemoteSettings\n*L\n75#1:172,10\n*E\n"})
@Singleton
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u0000 (2\u00020\u0001:\u0001(B7\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\r\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\u0011\u0010&\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "lazySettingsCache", "Ldagger/Lazy;", "Lcom/google/firebase/sessions/settings/SettingsCache;", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Ldagger/Lazy;)V", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", "samplingRate", "", "getSamplingRate", "()Ljava/lang/Double;", "sessionEnabled", "", "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "settingsCache", "getSettingsCache", "()Lcom/google/firebase/sessions/settings/SettingsCache;", "clearCachedSettings", "", "clearCachedSettings$com_google_firebase_firebase_sessions", "isSettingsStale", "removeForwardSlashesIn", "", "s", "updateSettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RemoteSettings implements SettingsProvider {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String FORWARD_SLASH_STRING = "/";
    @NotNull
    @Deprecated
    public static final String TAG = "SessionConfigFetcher";
    @NotNull
    private final ApplicationInfo appInfo;
    @NotNull
    private final CoroutineContext backgroundDispatcher;
    @NotNull
    private final CrashlyticsSettingsFetcher configsFetcher;
    @NotNull
    private final Mutex fetchInProgress = MutexKt.a();
    @NotNull
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    @NotNull
    private final Lazy<SettingsCache> lazySettingsCache;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", "", "()V", "FORWARD_SLASH_STRING", "", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public RemoteSettings(@NotNull @Background CoroutineContext coroutineContext, @NotNull FirebaseInstallationsApi firebaseInstallationsApi2, @NotNull ApplicationInfo applicationInfo, @NotNull CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, @NotNull Lazy<SettingsCache> lazy) {
        Intrinsics.checkNotNullParameter(coroutineContext, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi2, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(applicationInfo, "appInfo");
        Intrinsics.checkNotNullParameter(crashlyticsSettingsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(lazy, "lazySettingsCache");
        this.backgroundDispatcher = coroutineContext;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.appInfo = applicationInfo;
        this.configsFetcher = crashlyticsSettingsFetcher;
        this.lazySettingsCache = lazy;
    }

    /* access modifiers changed from: private */
    public final SettingsCache getSettingsCache() {
        SettingsCache settingsCache = this.lazySettingsCache.get();
        Intrinsics.checkNotNullExpressionValue(settingsCache, "lazySettingsCache.get()");
        return settingsCache;
    }

    private final String removeForwardSlashesIn(String str) {
        return new Regex(FORWARD_SLASH_STRING).replace((CharSequence) str, "");
    }

    @VisibleForTesting
    public final void clearCachedSettings$com_google_firebase_firebase_sessions() {
        BuildersKt.b(CoroutineScopeKt.a(this.backgroundDispatcher), (MainCoroutineDispatcher) null, (CoroutineStart) null, new RemoteSettings$clearCachedSettings$1(this, (Continuation<? super RemoteSettings$clearCachedSettings$1>) null), 3);
    }

    @Nullable
    public Double getSamplingRate() {
        return getSettingsCache().sessionSamplingRate();
    }

    @Nullable
    public Boolean getSessionEnabled() {
        return getSettingsCache().sessionsEnabled();
    }

    @Nullable
    /* renamed from: getSessionRestartTimeout-FghU774  reason: not valid java name */
    public Duration m10getSessionRestartTimeoutFghU774() {
        Integer sessionRestartTimeout = getSettingsCache().sessionRestartTimeout();
        if (sessionRestartTimeout == null) {
            return null;
        }
        Duration.Companion companion = Duration.d;
        return new Duration(DurationKt.c(sessionRestartTimeout.intValue(), DurationUnit.SECONDS));
    }

    public boolean isSettingsStale() {
        return getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0093 A[SYNTHETIC, Splitter:B:38:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0099 A[SYNTHETIC, Splitter:B:42:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updateSettings(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            boolean r6 = r0 instanceof com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            if (r6 == 0) goto L_0x001b
            r6 = r0
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r6 = (com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1) r6
            int r7 = r6.label
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r7 & r8
            if (r9 == 0) goto L_0x001b
            int r7 = r7 - r8
            r6.label = r7
            goto L_0x0020
        L_0x001b:
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r6 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            r6.<init>(r1, r0)
        L_0x0020:
            java.lang.Object r0 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r8 = r6.label
            r9 = 0
            if (r8 == 0) goto L_0x0060
            if (r8 == r5) goto L_0x0054
            if (r8 == r4) goto L_0x0045
            if (r8 != r3) goto L_0x003d
            java.lang.Object r2 = r6.L$0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.b(r0)     // Catch:{ all -> 0x0039 }
            r5 = r9
            goto L_0x014e
        L_0x0039:
            r0 = move-exception
        L_0x003a:
            r3 = r9
            goto L_0x015c
        L_0x003d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0045:
            java.lang.Object r8 = r6.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r10 = r6.L$0
            com.google.firebase.sessions.settings.RemoteSettings r10 = (com.google.firebase.sessions.settings.RemoteSettings) r10
            kotlin.ResultKt.b(r0)     // Catch:{ all -> 0x0051 }
            goto L_0x00aa
        L_0x0051:
            r0 = move-exception
            r2 = r8
            goto L_0x003a
        L_0x0054:
            java.lang.Object r8 = r6.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r10 = r6.L$0
            com.google.firebase.sessions.settings.RemoteSettings r10 = (com.google.firebase.sessions.settings.RemoteSettings) r10
            kotlin.ResultKt.b(r0)
            goto L_0x0089
        L_0x0060:
            kotlin.ResultKt.b(r0)
            kotlinx.coroutines.sync.Mutex r0 = r1.fetchInProgress
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x0078
            com.google.firebase.sessions.settings.SettingsCache r0 = r16.getSettingsCache()
            boolean r0 = r0.hasCacheExpired$com_google_firebase_firebase_sessions()
            if (r0 != 0) goto L_0x0078
            kotlin.Unit r0 = kotlin.Unit.f696a
            return r0
        L_0x0078:
            kotlinx.coroutines.sync.Mutex r0 = r1.fetchInProgress
            r6.L$0 = r1
            r6.L$1 = r0
            r6.label = r5
            java.lang.Object r8 = r0.d(r6)
            if (r8 != r7) goto L_0x0087
            return r7
        L_0x0087:
            r8 = r0
            r10 = r1
        L_0x0089:
            com.google.firebase.sessions.settings.SettingsCache r0 = r10.getSettingsCache()     // Catch:{ all -> 0x0159 }
            boolean r0 = r0.hasCacheExpired$com_google_firebase_firebase_sessions()     // Catch:{ all -> 0x0159 }
            if (r0 != 0) goto L_0x0099
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0051 }
            r8.c(r9)
            return r0
        L_0x0099:
            com.google.firebase.sessions.InstallationId$Companion r0 = com.google.firebase.sessions.InstallationId.Companion     // Catch:{ all -> 0x0159 }
            com.google.firebase.installations.FirebaseInstallationsApi r11 = r10.firebaseInstallationsApi     // Catch:{ all -> 0x0159 }
            r6.L$0 = r10     // Catch:{ all -> 0x0159 }
            r6.L$1 = r8     // Catch:{ all -> 0x0159 }
            r6.label = r4     // Catch:{ all -> 0x0159 }
            java.lang.Object r0 = r0.create(r11, r6)     // Catch:{ all -> 0x0159 }
            if (r0 != r7) goto L_0x00aa
            return r7
        L_0x00aa:
            com.google.firebase.sessions.InstallationId r0 = (com.google.firebase.sessions.InstallationId) r0     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = r0.getFid()     // Catch:{ all -> 0x0159 }
            java.lang.String r11 = ""
            boolean r11 = kotlin.jvm.internal.Intrinsics.a(r0, r11)     // Catch:{ all -> 0x0159 }
            if (r11 == 0) goto L_0x00c5
            java.lang.String r0 = "SessionConfigFetcher"
            java.lang.String r2 = "Error getting Firebase Installation ID. Skipping this Session Event."
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x0051 }
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0051 }
            r8.c(r9)
            return r0
        L_0x00c5:
            java.lang.String r11 = "X-Crashlytics-Installation-ID"
            kotlin.Pair r12 = new kotlin.Pair     // Catch:{ all -> 0x0159 }
            r12.<init>(r11, r0)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = "X-Crashlytics-Device-Model"
            java.lang.String r11 = "%s/%s"
            java.lang.Object[] r13 = new java.lang.Object[r4]     // Catch:{ all -> 0x0159 }
            java.lang.String r14 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0159 }
            r13[r2] = r14     // Catch:{ all -> 0x0159 }
            java.lang.String r14 = android.os.Build.MODEL     // Catch:{ all -> 0x0159 }
            r13[r5] = r14     // Catch:{ all -> 0x0159 }
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r4)     // Catch:{ all -> 0x0159 }
            java.lang.String r11 = java.lang.String.format(r11, r13)     // Catch:{ all -> 0x0159 }
            java.lang.String r13 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)     // Catch:{ all -> 0x0159 }
            java.lang.String r11 = r10.removeForwardSlashesIn(r11)     // Catch:{ all -> 0x0159 }
            kotlin.Pair r13 = new kotlin.Pair     // Catch:{ all -> 0x0159 }
            r13.<init>(r0, r11)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = "X-Crashlytics-OS-Build-Version"
            java.lang.String r11 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x0159 }
            java.lang.String r14 = "INCREMENTAL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r14)     // Catch:{ all -> 0x0159 }
            java.lang.String r11 = r10.removeForwardSlashesIn(r11)     // Catch:{ all -> 0x0159 }
            kotlin.Pair r14 = new kotlin.Pair     // Catch:{ all -> 0x0159 }
            r14.<init>(r0, r11)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = "X-Crashlytics-OS-Display-Version"
            java.lang.String r11 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0159 }
            java.lang.String r15 = "RELEASE"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r15)     // Catch:{ all -> 0x0159 }
            java.lang.String r11 = r10.removeForwardSlashesIn(r11)     // Catch:{ all -> 0x0159 }
            kotlin.Pair r15 = new kotlin.Pair     // Catch:{ all -> 0x0159 }
            r15.<init>(r0, r11)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = "X-Crashlytics-API-Client-Version"
            com.google.firebase.sessions.ApplicationInfo r11 = r10.appInfo     // Catch:{ all -> 0x0159 }
            java.lang.String r11 = r11.getSessionSdkVersion()     // Catch:{ all -> 0x0159 }
            kotlin.Pair r9 = new kotlin.Pair     // Catch:{ all -> 0x0159 }
            r9.<init>(r0, r11)     // Catch:{ all -> 0x0159 }
            r0 = 5
            kotlin.Pair[] r0 = new kotlin.Pair[r0]     // Catch:{ all -> 0x0159 }
            r0[r2] = r12     // Catch:{ all -> 0x0159 }
            r0[r5] = r13     // Catch:{ all -> 0x0159 }
            r0[r4] = r14     // Catch:{ all -> 0x0159 }
            r0[r3] = r15     // Catch:{ all -> 0x0159 }
            r2 = 4
            r0[r2] = r9     // Catch:{ all -> 0x0159 }
            java.util.Map r0 = kotlin.collections.MapsKt.e(r0)     // Catch:{ all -> 0x0159 }
            com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher r2 = r10.configsFetcher     // Catch:{ all -> 0x0159 }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1 r4 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1     // Catch:{ all -> 0x0159 }
            r5 = 0
            r4.<init>(r10, r5)     // Catch:{ all -> 0x0159 }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2 r9 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2     // Catch:{ all -> 0x0159 }
            r9.<init>(r5)     // Catch:{ all -> 0x0159 }
            r6.L$0 = r8     // Catch:{ all -> 0x0159 }
            r6.L$1 = r5     // Catch:{ all -> 0x0159 }
            r6.label = r3     // Catch:{ all -> 0x0159 }
            java.lang.Object r0 = r2.doConfigFetch(r0, r4, r9, r6)     // Catch:{ all -> 0x0159 }
            if (r0 != r7) goto L_0x014d
            return r7
        L_0x014d:
            r2 = r8
        L_0x014e:
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0156 }
            r2.c(r5)
            kotlin.Unit r0 = kotlin.Unit.f696a
            return r0
        L_0x0156:
            r0 = move-exception
        L_0x0157:
            r3 = 0
            goto L_0x015c
        L_0x0159:
            r0 = move-exception
            r2 = r8
            goto L_0x0157
        L_0x015c:
            r2.c(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.updateSettings(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
