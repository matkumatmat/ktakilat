package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nRemoteSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteSettings.kt\ncom/google/firebase/sessions/settings/RemoteSettings$updateSettings$2$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,171:1\n1#2:172\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", i = {0, 0, 0, 1, 1, 2}, l = {132, 135, 138, 140, 141, 143}, m = "invokeSuspend", n = {"sessionSamplingRate", "sessionTimeoutSeconds", "cacheDuration", "sessionSamplingRate", "cacheDuration", "cacheDuration"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
public final class RemoteSettings$updateSettings$2$1 extends SuspendLambda implements Function2<JSONObject, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$2$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettings;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, continuation);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e6, code lost:
        if (((java.lang.Integer) r7.element) == null) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e8, code lost:
        r11.L$0 = r1;
        r11.L$1 = r0;
        r11.L$2 = null;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ff, code lost:
        if (r11.this$0.getSettingsCache().updateSessionRestartTimeout((java.lang.Integer) r7.element, r11) != r4) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0101, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0106, code lost:
        if (((java.lang.Double) r1.element) == null) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0108, code lost:
        r11.L$0 = r0;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x011f, code lost:
        if (r11.this$0.getSettingsCache().updateSamplingRate((java.lang.Double) r1.element, r11) != r4) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0121, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0126, code lost:
        if (((java.lang.Integer) r0.element) == null) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0128, code lost:
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x013f, code lost:
        if (r11.this$0.getSettingsCache().updateSessionCacheDuration((java.lang.Integer) r0.element, r11) != r4) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0141, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0142, code lost:
        r12 = kotlin.Unit.f696a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0145, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0146, code lost:
        if (r12 != null) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0148, code lost:
        r12 = r11.this$0.getSettingsCache();
        r0 = new java.lang.Integer(86400);
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0163, code lost:
        if (r12.updateSessionCacheDuration(r0, r11) != r4) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0165, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0166, code lost:
        r12 = r11.this$0.getSettingsCache();
        r2 = new java.lang.Long(java.lang.System.currentTimeMillis());
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0182, code lost:
        if (r12.updateSessionCacheUpdatedTime(r2, r11) != r4) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0184, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0187, code lost:
        return kotlin.Unit.f696a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e0  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.String r0 = "cache_duration"
            java.lang.String r1 = "session_timeout_seconds"
            java.lang.String r2 = "sampling_rate"
            java.lang.String r3 = "sessions_enabled"
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r5 = r11.label
            r6 = 0
            switch(r5) {
                case 0: goto L_0x004e;
                case 1: goto L_0x003d;
                case 2: goto L_0x0030;
                case 3: goto L_0x0027;
                case 4: goto L_0x0022;
                case 5: goto L_0x001d;
                case 6: goto L_0x0018;
                default: goto L_0x0010;
            }
        L_0x0010:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0018:
            kotlin.ResultKt.b(r12)
            goto L_0x0185
        L_0x001d:
            kotlin.ResultKt.b(r12)
            goto L_0x0166
        L_0x0022:
            kotlin.ResultKt.b(r12)
            goto L_0x0142
        L_0x0027:
            java.lang.Object r0 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.b(r12)
            goto L_0x0122
        L_0x0030:
            java.lang.Object r0 = r11.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.b(r12)
            goto L_0x0102
        L_0x003d:
            java.lang.Object r0 = r11.L$2
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r11.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r2 = r11.L$0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            kotlin.ResultKt.b(r12)
            goto L_0x00dd
        L_0x004e:
            kotlin.ResultKt.b(r12)
            java.lang.Object r12 = r11.L$0
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            java.util.Objects.toString(r12)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            java.lang.String r9 = "app_quality"
            boolean r10 = r12.has(r9)
            if (r10 == 0) goto L_0x00c1
            java.lang.Object r12 = r12.get(r9)
            java.lang.String r9 = "null cannot be cast to non-null type org.json.JSONObject"
            kotlin.jvm.internal.Intrinsics.d(r12, r9)
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            boolean r9 = r12.has(r3)     // Catch:{ JSONException -> 0x0087 }
            if (r9 == 0) goto L_0x008a
            java.lang.Object r3 = r12.get(r3)     // Catch:{ JSONException -> 0x0087 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r12 = move-exception
            r3 = r6
            goto L_0x00b9
        L_0x008a:
            r3 = r6
        L_0x008b:
            boolean r9 = r12.has(r2)     // Catch:{ JSONException -> 0x009a }
            if (r9 == 0) goto L_0x009c
            java.lang.Object r2 = r12.get(r2)     // Catch:{ JSONException -> 0x009a }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ JSONException -> 0x009a }
            r5.element = r2     // Catch:{ JSONException -> 0x009a }
            goto L_0x009c
        L_0x009a:
            r12 = move-exception
            goto L_0x00b9
        L_0x009c:
            boolean r2 = r12.has(r1)     // Catch:{ JSONException -> 0x009a }
            if (r2 == 0) goto L_0x00aa
            java.lang.Object r1 = r12.get(r1)     // Catch:{ JSONException -> 0x009a }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ JSONException -> 0x009a }
            r7.element = r1     // Catch:{ JSONException -> 0x009a }
        L_0x00aa:
            boolean r1 = r12.has(r0)     // Catch:{ JSONException -> 0x009a }
            if (r1 == 0) goto L_0x00c2
            java.lang.Object r12 = r12.get(r0)     // Catch:{ JSONException -> 0x009a }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ JSONException -> 0x009a }
            r8.element = r12     // Catch:{ JSONException -> 0x009a }
            goto L_0x00c2
        L_0x00b9:
            java.lang.String r0 = "SessionConfigFetcher"
            java.lang.String r1 = "Error parsing the configs remotely fetched: "
            android.util.Log.e(r0, r1, r12)
            goto L_0x00c2
        L_0x00c1:
            r3 = r6
        L_0x00c2:
            if (r3 == 0) goto L_0x00e0
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.getSettingsCache()
            r11.L$0 = r5
            r11.L$1 = r7
            r11.L$2 = r8
            r0 = 1
            r11.label = r0
            java.lang.Object r12 = r12.updateSettingsEnabled(r3, r11)
            if (r12 != r4) goto L_0x00da
            return r4
        L_0x00da:
            r2 = r5
            r1 = r7
            r0 = r8
        L_0x00dd:
            r7 = r1
            r1 = r2
            goto L_0x00e2
        L_0x00e0:
            r1 = r5
            r0 = r8
        L_0x00e2:
            T r12 = r7.element
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x0102
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.getSettingsCache()
            T r2 = r7.element
            java.lang.Integer r2 = (java.lang.Integer) r2
            r11.L$0 = r1
            r11.L$1 = r0
            r11.L$2 = r6
            r3 = 2
            r11.label = r3
            java.lang.Object r12 = r12.updateSessionRestartTimeout(r2, r11)
            if (r12 != r4) goto L_0x0102
            return r4
        L_0x0102:
            T r12 = r1.element
            java.lang.Double r12 = (java.lang.Double) r12
            if (r12 == 0) goto L_0x0122
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.getSettingsCache()
            T r1 = r1.element
            java.lang.Double r1 = (java.lang.Double) r1
            r11.L$0 = r0
            r11.L$1 = r6
            r11.L$2 = r6
            r2 = 3
            r11.label = r2
            java.lang.Object r12 = r12.updateSamplingRate(r1, r11)
            if (r12 != r4) goto L_0x0122
            return r4
        L_0x0122:
            T r12 = r0.element
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x0145
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.getSettingsCache()
            T r0 = r0.element
            java.lang.Integer r0 = (java.lang.Integer) r0
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 4
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheDuration(r0, r11)
            if (r12 != r4) goto L_0x0142
            return r4
        L_0x0142:
            kotlin.Unit r12 = kotlin.Unit.f696a
            goto L_0x0146
        L_0x0145:
            r12 = r6
        L_0x0146:
            if (r12 != 0) goto L_0x0166
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.getSettingsCache()
            java.lang.Integer r0 = new java.lang.Integer
            r1 = 86400(0x15180, float:1.21072E-40)
            r0.<init>(r1)
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 5
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheDuration(r0, r11)
            if (r12 != r4) goto L_0x0166
            return r4
        L_0x0166:
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.getSettingsCache()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = new java.lang.Long
            r2.<init>(r0)
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r0 = 6
            r11.label = r0
            java.lang.Object r12 = r12.updateSessionCacheUpdatedTime(r2, r11)
            if (r12 != r4) goto L_0x0185
            return r4
        L_0x0185:
            kotlin.Unit r12 = kotlin.Unit.f696a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull JSONObject jSONObject, @Nullable Continuation<? super Unit> continuation) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, continuation)).invokeSuspend(Unit.f696a);
    }
}
