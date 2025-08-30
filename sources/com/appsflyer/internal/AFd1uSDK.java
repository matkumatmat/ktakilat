package com.appsflyer.internal;

import android.os.Build;
import android.widget.ExpandableListView;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFd1vSDK;
import com.facebook.internal.ServerProtocol;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.util.Constants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class AFd1uSDK implements AFd1vSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int AFLogger = 1;
    private static boolean copy = true;
    private static int copydefault;
    private static int equals = -771284898;
    private static char[] hashCode = {8636, 8652, 8639, 8648, 8626};
    private static boolean toString = true;
    @NotNull
    private final Lazy AFAdRevenueData = LazyKt.b(new Function0<AFf1oSDK>(this) {
        private /* synthetic */ AFd1uSDK getMediationNetwork;

        {
            this.getMediationNetwork = r1;
        }

        @NotNull
        /* renamed from: getCurrencyIso4217Code */
        public final AFf1oSDK invoke() {
            AFf1oSDK component1 = AFd1uSDK.getCurrencyIso4217Code(this.getMediationNetwork).component1();
            Intrinsics.checkNotNullExpressionValue(component1, "");
            return component1;
        }
    });
    @NotNull
    private final Lazy areAllFieldsValid = LazyKt.b(new Function0<ExecutorService>(this) {
        private /* synthetic */ AFd1uSDK getMonetizationNetwork;

        {
            this.getMonetizationNetwork = r1;
        }

        @NotNull
        /* renamed from: AFAdRevenueData */
        public final ExecutorService invoke() {
            ExecutorService monetizationNetwork = AFd1uSDK.getCurrencyIso4217Code(this.getMonetizationNetwork).getMonetizationNetwork();
            Intrinsics.checkNotNullExpressionValue(monetizationNetwork, "");
            return monetizationNetwork;
        }
    });
    @NotNull
    private final String component1 = "6.17.0";
    @Nullable
    private AFd1vSDK.AFa1ySDK component2;
    @NotNull
    private final Lazy component3 = LazyKt.b(new Function0<AFd1ySDK>(this) {
        private /* synthetic */ AFd1uSDK getMediationNetwork;

        {
            this.getMediationNetwork = r1;
        }

        @NotNull
        /* renamed from: AFAdRevenueData */
        public final AFd1ySDK invoke() {
            return new AFd1ySDK(this.getMediationNetwork.getRevenue());
        }
    });
    @NotNull
    private final Lazy component4 = LazyKt.b(new Function0<AFc1bSDK>(this) {
        private /* synthetic */ AFd1uSDK getRevenue;

        {
            this.getRevenue = r1;
        }

        @NotNull
        /* renamed from: getRevenue */
        public final AFc1bSDK invoke() {
            AFc1iSDK AFInAppEventType = AFd1uSDK.getCurrencyIso4217Code(this.getRevenue).AFInAppEventType();
            Intrinsics.checkNotNullExpressionValue(AFInAppEventType, "");
            return new AFc1bSDK(AFInAppEventType);
        }
    });
    @NotNull
    private final Lazy getCurrencyIso4217Code = LazyKt.b(new Function0<AFf1gSDK>(this) {
        private /* synthetic */ AFd1uSDK getCurrencyIso4217Code;

        {
            this.getCurrencyIso4217Code = r1;
        }

        @NotNull
        /* renamed from: getRevenue */
        public final AFf1gSDK invoke() {
            AFf1gSDK registerClient = AFd1uSDK.getCurrencyIso4217Code(this.getCurrencyIso4217Code).registerClient();
            Intrinsics.checkNotNullExpressionValue(registerClient, "");
            return registerClient;
        }
    });
    @NotNull
    private AFc1dSDK getMediationNetwork;
    @NotNull
    private final Lazy getMonetizationNetwork = LazyKt.b(new Function0<AFc1pSDK>(this) {
        private /* synthetic */ AFd1uSDK getRevenue;

        {
            this.getRevenue = r1;
        }

        @NotNull
        /* renamed from: getCurrencyIso4217Code */
        public final AFc1pSDK invoke() {
            AFc1pSDK revenue = AFd1uSDK.getCurrencyIso4217Code(this.getRevenue).getRevenue();
            Intrinsics.checkNotNullExpressionValue(revenue, "");
            return revenue;
        }
    });
    @NotNull
    private final Lazy getRevenue = LazyKt.b(new Function0<AFc1qSDK>(this) {
        private /* synthetic */ AFd1uSDK AFAdRevenueData;

        {
            this.AFAdRevenueData = r1;
        }

        @NotNull
        /* renamed from: AFAdRevenueData */
        public final AFc1qSDK invoke() {
            AFc1qSDK component2 = AFd1uSDK.getCurrencyIso4217Code(this.AFAdRevenueData).component2();
            Intrinsics.checkNotNullExpressionValue(component2, "");
            return component2;
        }
    });

    public AFd1uSDK(@NotNull AFc1dSDK aFc1dSDK) {
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        this.getMediationNetwork = aFc1dSDK;
    }

    private final ExecutorService areAllFieldsValid() {
        AFLogger = (copydefault + 47) % 128;
        ExecutorService executorService = (ExecutorService) this.areAllFieldsValid.getValue();
        AFLogger = (copydefault + 37) % 128;
        return executorService;
    }

    private final AFh1dSDK component1() {
        return (AFh1dSDK) getMediationNetwork(new Object[]{this}, 855295870, -855295867, System.identityHashCode(this));
    }

    private final AFc1qSDK component2() {
        int i = copydefault + 19;
        AFLogger = i % 128;
        if (i % 2 != 0) {
            return (AFc1qSDK) this.getRevenue.getValue();
        }
        AFc1qSDK aFc1qSDK = (AFc1qSDK) this.getRevenue.getValue();
        throw null;
    }

    @NotNull
    private AFd1xSDK component3() {
        return (AFd1xSDK) getMediationNetwork(new Object[]{this}, -704520981, 704520985, System.identityHashCode(this));
    }

    private final AFf1gSDK component4() {
        int i = AFLogger + 17;
        copydefault = i % 128;
        if (i % 2 == 0) {
            AFf1gSDK aFf1gSDK = (AFf1gSDK) this.getCurrencyIso4217Code.getValue();
            AFLogger = (copydefault + 117) % 128;
            return aFf1gSDK;
        }
        AFf1gSDK aFf1gSDK2 = (AFf1gSDK) this.getCurrencyIso4217Code.getValue();
        throw null;
    }

    private final synchronized void copy() {
        boolean z = false;
        synchronized (this) {
            try {
                AFh1dSDK aFh1dSDK = (AFh1dSDK) getMediationNetwork(new Object[]{this}, 855295870, -855295867, System.identityHashCode(this));
                if (aFh1dSDK != null) {
                    int i = copydefault + 57;
                    AFLogger = i % 128;
                    if (i % 2 != 0) {
                        if (aFh1dSDK.AFAdRevenueData == -1) {
                            component2().getMonetizationNetwork("af_send_exc_to_server_window");
                        } else if (component2().getCurrencyIso4217Code("af_send_exc_to_server_window", -1) == -1) {
                            AFLogger = (copydefault + 119) % 128;
                            getRevenue(aFh1dSDK);
                        }
                        z = getMonetizationNetwork(aFh1dSDK);
                    } else {
                        throw null;
                    }
                }
                AFd1vSDK.AFa1ySDK aFa1ySDK = this.component2;
                if (aFa1ySDK != null) {
                    copydefault = (AFLogger + 73) % 128;
                    aFa1ySDK.onConfigurationChanged(z);
                    return;
                }
                copydefault = (AFLogger + 107) % 128;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00af, code lost:
        if (r2 != null) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (r2 != null) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0191, code lost:
        if (r2.intValue() != -1) goto L_0x0193;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fb A[Catch:{ all -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0139 A[Catch:{ all -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0146 A[Catch:{ all -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016c A[Catch:{ all -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0171 A[Catch:{ all -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x018c A[Catch:{ all -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x018d A[Catch:{ all -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0195 A[Catch:{ all -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a5 A[Catch:{ all -> 0x001c }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01c1 A[Catch:{ all -> 0x001c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void copydefault() {
        /*
            r11 = this;
            r0 = 0
            r1 = 1
            monitor-enter(r11)
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x001c }
            r2[r0] = r11     // Catch:{ all -> 0x001c }
            int r3 = java.lang.System.identityHashCode(r11)     // Catch:{ all -> 0x001c }
            r4 = 855295870(0x32fac77e, float:2.9194549E-8)
            r5 = -855295867(0xffffffffcd053885, float:-1.39692112E8)
            java.lang.Object r2 = getMediationNetwork(r2, r4, r5, r3)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFh1dSDK r2 = (com.appsflyer.internal.AFh1dSDK) r2     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x001f
            long r2 = r2.getMediationNetwork     // Catch:{ all -> 0x001c }
            goto L_0x0021
        L_0x001c:
            r0 = move-exception
            goto L_0x0227
        L_0x001f:
            r2 = -1
        L_0x0021:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x001c }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x001c }
            long r6 = r6.toSeconds(r7)     // Catch:{ all -> 0x001c }
            r8 = 2
            int r9 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0077
            int r0 = AFLogger     // Catch:{ all -> 0x001c }
            int r0 = r0 + 47
            int r1 = r0 % 128
            copydefault = r1     // Catch:{ all -> 0x001c }
            int r0 = r0 % r8
            if (r0 == 0) goto L_0x0059
            com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.EXCEPTION_MANAGER     // Catch:{ all -> 0x001c }
            java.lang.String r3 = "TTL is already passed"
            r6 = 0
            r4 = 0
            r5 = 4
            com.appsflyer.internal.AFg1gSDK.v$default(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFc1qSDK r0 = r11.component2()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "af_send_exc_to_server_window"
            r0.getMonetizationNetwork(r1)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFc1aSDK r0 = r11.getRevenue()     // Catch:{ all -> 0x001c }
            r0.getMonetizationNetwork()     // Catch:{ all -> 0x001c }
            monitor-exit(r11)
            return
        L_0x0059:
            com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.EXCEPTION_MANAGER     // Catch:{ all -> 0x001c }
            java.lang.String r3 = "TTL is already passed"
            r6 = 0
            r4 = 0
            r5 = 4
            com.appsflyer.internal.AFg1gSDK.v$default(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFc1qSDK r0 = r11.component2()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "af_send_exc_to_server_window"
            r0.getMonetizationNetwork(r1)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFc1aSDK r0 = r11.getRevenue()     // Catch:{ all -> 0x001c }
            r0.getMonetizationNetwork()     // Catch:{ all -> 0x001c }
            monitor-exit(r11)
            return
        L_0x0077:
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x001c }
            r2[r0] = r11     // Catch:{ all -> 0x001c }
            int r3 = java.lang.System.identityHashCode(r11)     // Catch:{ all -> 0x001c }
            java.lang.Object r2 = getMediationNetwork(r2, r4, r5, r3)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFh1dSDK r2 = (com.appsflyer.internal.AFh1dSDK) r2     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x01f0
            boolean r2 = r11.getMediationNetwork((com.appsflyer.internal.AFh1dSDK) r2)     // Catch:{ all -> 0x001c }
            if (r2 != r1) goto L_0x01f0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x001c }
            r2[r0] = r11     // Catch:{ all -> 0x001c }
            int r3 = java.lang.System.identityHashCode(r11)     // Catch:{ all -> 0x001c }
            java.lang.Object r2 = getMediationNetwork(r2, r4, r5, r3)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFh1dSDK r2 = (com.appsflyer.internal.AFh1dSDK) r2     // Catch:{ all -> 0x001c }
            r3 = -1
            r6 = 0
            if (r2 == 0) goto L_0x0157
            int r7 = AFLogger     // Catch:{ all -> 0x001c }
            int r7 = r7 + 111
            int r9 = r7 % 128
            copydefault = r9     // Catch:{ all -> 0x001c }
            int r7 = r7 % r8
            if (r7 == 0) goto L_0x00b4
            java.lang.String r2 = r2.getRevenue     // Catch:{ all -> 0x001c }
            r7 = 76
            int r7 = r7 / r0
            if (r2 == 0) goto L_0x0157
            goto L_0x00b8
        L_0x00b2:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x001c }
        L_0x00b4:
            java.lang.String r2 = r2.getRevenue     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0157
        L_0x00b8:
            java.lang.String r7 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r7)     // Catch:{ all -> 0x001c }
            kotlin.text.Regex r7 = new kotlin.text.Regex     // Catch:{ all -> 0x001c }
            java.lang.String r9 = "(\\d+).(\\d+).(\\d+).*"
            r7.<init>((java.lang.String) r9)     // Catch:{ all -> 0x001c }
            kotlin.text.MatchResult r2 = r7.matchEntire(r2)     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0151
            kotlin.text.MatcherMatchResult$groups$1 r7 = r2.a()     // Catch:{ all -> 0x001c }
            kotlin.text.MatchGroup r7 = r7.a(r1)     // Catch:{ all -> 0x001c }
            if (r7 == 0) goto L_0x00eb
            java.lang.String r7 = r7.f750a     // Catch:{ all -> 0x001c }
            if (r7 == 0) goto L_0x00eb
            int r9 = copydefault     // Catch:{ all -> 0x001c }
            int r9 = r9 + 119
            int r9 = r9 % 128
            AFLogger = r9     // Catch:{ all -> 0x001c }
            java.lang.Integer r7 = kotlin.text.StringsKt.toIntOrNull(r7)     // Catch:{ all -> 0x001c }
            if (r7 == 0) goto L_0x00eb
            int r7 = r7.intValue()     // Catch:{ all -> 0x001c }
            goto L_0x00ec
        L_0x00eb:
            r7 = 0
        L_0x00ec:
            r9 = 1000000(0xf4240, float:1.401298E-39)
            int r7 = r7 * r9
            kotlin.text.MatcherMatchResult$groups$1 r9 = r2.a()     // Catch:{ all -> 0x001c }
            kotlin.text.MatchGroup r8 = r9.a(r8)     // Catch:{ all -> 0x001c }
            if (r8 == 0) goto L_0x0120
            int r9 = copydefault     // Catch:{ all -> 0x001c }
            int r10 = r9 + 95
            int r10 = r10 % 128
            AFLogger = r10     // Catch:{ all -> 0x001c }
            java.lang.String r8 = r8.f750a     // Catch:{ all -> 0x001c }
            if (r8 == 0) goto L_0x0120
            int r9 = r9 + 113
            int r9 = r9 % 128
            AFLogger = r9     // Catch:{ all -> 0x001c }
            java.lang.Integer r8 = kotlin.text.StringsKt.toIntOrNull(r8)     // Catch:{ all -> 0x001c }
            if (r8 == 0) goto L_0x0120
            int r8 = r8.intValue()     // Catch:{ all -> 0x001c }
            int r9 = AFLogger     // Catch:{ all -> 0x001c }
            int r9 = r9 + 87
            int r9 = r9 % 128
            copydefault = r9     // Catch:{ all -> 0x001c }
            goto L_0x0121
        L_0x0120:
            r8 = 0
        L_0x0121:
            int r8 = r8 * 1000
            int r8 = r8 + r7
            kotlin.text.MatcherMatchResult$groups$1 r2 = r2.a()     // Catch:{ all -> 0x001c }
            r7 = 3
            kotlin.text.MatchGroup r2 = r2.a(r7)     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0146
            java.lang.String r2 = r2.f750a     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0146
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0146
            int r7 = copydefault     // Catch:{ all -> 0x001c }
            int r7 = r7 + 123
            int r7 = r7 % 128
            AFLogger = r7     // Catch:{ all -> 0x001c }
            int r2 = r2.intValue()     // Catch:{ all -> 0x001c }
            goto L_0x014f
        L_0x0146:
            int r2 = copydefault     // Catch:{ all -> 0x001c }
            int r2 = r2 + 85
            int r2 = r2 % 128
            AFLogger = r2     // Catch:{ all -> 0x001c }
            r2 = 0
        L_0x014f:
            int r8 = r8 + r2
            goto L_0x0152
        L_0x0151:
            r8 = -1
        L_0x0152:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x001c }
            goto L_0x0158
        L_0x0157:
            r2 = r6
        L_0x0158:
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x001c }
            r7[r0] = r11     // Catch:{ all -> 0x001c }
            int r8 = java.lang.System.identityHashCode(r11)     // Catch:{ all -> 0x001c }
            java.lang.Object r7 = getMediationNetwork(r7, r4, r5, r8)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFh1dSDK r7 = (com.appsflyer.internal.AFh1dSDK) r7     // Catch:{ all -> 0x001c }
            if (r7 == 0) goto L_0x0171
            java.lang.String r7 = r7.getRevenue     // Catch:{ all -> 0x001c }
            if (r7 == 0) goto L_0x0171
            kotlin.Pair r7 = com.appsflyer.internal.AFd1rSDK.getRevenue((java.lang.String) r7)     // Catch:{ all -> 0x001c }
            goto L_0x0172
        L_0x0171:
            r7 = r6
        L_0x0172:
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ all -> 0x001c }
            r8[r0] = r11     // Catch:{ all -> 0x001c }
            int r9 = java.lang.System.identityHashCode(r11)     // Catch:{ all -> 0x001c }
            java.lang.Object r8 = getMediationNetwork(r8, r4, r5, r9)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFh1dSDK r8 = (com.appsflyer.internal.AFh1dSDK) r8     // Catch:{ all -> 0x001c }
            if (r8 == 0) goto L_0x018a
            java.lang.String r8 = r8.getRevenue     // Catch:{ all -> 0x001c }
            if (r8 == 0) goto L_0x018a
            kotlin.Pair r6 = com.appsflyer.internal.AFd1rSDK.getMediationNetwork(r8)     // Catch:{ all -> 0x001c }
        L_0x018a:
            if (r2 != 0) goto L_0x018d
            goto L_0x0193
        L_0x018d:
            int r2 = r2.intValue()     // Catch:{ all -> 0x001c }
            if (r2 == r3) goto L_0x01a3
        L_0x0193:
            if (r7 != 0) goto L_0x01a3
            com.appsflyer.internal.AFc1aSDK r2 = r11.getRevenue()     // Catch:{ all -> 0x001c }
            java.lang.String r3 = r11.component1     // Catch:{ all -> 0x001c }
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ all -> 0x001c }
            r2.getRevenue(r3)     // Catch:{ all -> 0x001c }
            goto L_0x0200
        L_0x01a3:
            if (r7 == 0) goto L_0x01c1
            com.appsflyer.internal.AFc1aSDK r2 = r11.getRevenue()     // Catch:{ all -> 0x001c }
            java.lang.Object r3 = r7.getFirst()     // Catch:{ all -> 0x001c }
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ all -> 0x001c }
            int r3 = r3.intValue()     // Catch:{ all -> 0x001c }
            java.lang.Object r6 = r7.getSecond()     // Catch:{ all -> 0x001c }
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ all -> 0x001c }
            int r6 = r6.intValue()     // Catch:{ all -> 0x001c }
            r2.AFAdRevenueData((int) r3, (int) r6)     // Catch:{ all -> 0x001c }
            goto L_0x0200
        L_0x01c1:
            if (r6 == 0) goto L_0x01df
            com.appsflyer.internal.AFc1aSDK r2 = r11.getRevenue()     // Catch:{ all -> 0x001c }
            java.lang.Object r3 = r6.getFirst()     // Catch:{ all -> 0x001c }
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ all -> 0x001c }
            int r3 = r3.intValue()     // Catch:{ all -> 0x001c }
            java.lang.Object r6 = r6.getSecond()     // Catch:{ all -> 0x001c }
            java.lang.Number r6 = (java.lang.Number) r6     // Catch:{ all -> 0x001c }
            int r6 = r6.intValue()     // Catch:{ all -> 0x001c }
            r2.AFAdRevenueData((int) r3, (int) r6)     // Catch:{ all -> 0x001c }
            goto L_0x0200
        L_0x01df:
            com.appsflyer.internal.AFc1qSDK r2 = r11.component2()     // Catch:{ all -> 0x001c }
            java.lang.String r3 = "af_send_exc_to_server_window"
            r2.getMonetizationNetwork(r3)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFc1aSDK r2 = r11.getRevenue()     // Catch:{ all -> 0x001c }
            r2.getMonetizationNetwork()     // Catch:{ all -> 0x001c }
            goto L_0x0200
        L_0x01f0:
            com.appsflyer.internal.AFc1qSDK r2 = r11.component2()     // Catch:{ all -> 0x001c }
            java.lang.String r3 = "af_send_exc_to_server_window"
            r2.getMonetizationNetwork(r3)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFc1aSDK r2 = r11.getRevenue()     // Catch:{ all -> 0x001c }
            r2.getMonetizationNetwork()     // Catch:{ all -> 0x001c }
        L_0x0200:
            com.appsflyer.internal.AFd1vSDK$AFa1ySDK r2 = r11.component2     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0225
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x001c }
            r1[r0] = r11     // Catch:{ all -> 0x001c }
            int r3 = java.lang.System.identityHashCode(r11)     // Catch:{ all -> 0x001c }
            java.lang.Object r1 = getMediationNetwork(r1, r4, r5, r3)     // Catch:{ all -> 0x001c }
            com.appsflyer.internal.AFh1dSDK r1 = (com.appsflyer.internal.AFh1dSDK) r1     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0220
            int r0 = AFLogger     // Catch:{ all -> 0x001c }
            int r0 = r0 + 71
            int r0 = r0 % 128
            copydefault = r0     // Catch:{ all -> 0x001c }
            boolean r0 = r11.getMonetizationNetwork((com.appsflyer.internal.AFh1dSDK) r1)     // Catch:{ all -> 0x001c }
        L_0x0220:
            r2.onConfigurationChanged(r0)     // Catch:{ all -> 0x001c }
            monitor-exit(r11)
            return
        L_0x0225:
            monitor-exit(r11)
            return
        L_0x0227:
            monitor-exit(r11)     // Catch:{ all -> 0x001c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1uSDK.copydefault():void");
    }

    private final void equals() {
        AFh1dSDK aFh1dSDK;
        int i = copydefault + 119;
        AFLogger = i % 128;
        if (i % 2 == 0) {
            aFh1dSDK = (AFh1dSDK) getMediationNetwork(new Object[]{this}, 855295870, -855295867, System.identityHashCode(this));
            int i2 = 59 / 0;
            if (aFh1dSDK == null) {
                return;
            }
        } else {
            aFh1dSDK = (AFh1dSDK) getMediationNetwork(new Object[]{this}, 855295870, -855295867, System.identityHashCode(this));
            if (aFh1dSDK == null) {
                return;
            }
        }
        if (getCurrencyIso4217Code(aFh1dSDK)) {
            int i3 = AFLogger + 33;
            copydefault = i3 % 128;
            if (i3 % 2 == 0) {
                String mediationNetwork = component4().getMediationNetwork();
                if (mediationNetwork != null) {
                    String jSONObject = new JSONObject((Map) getMediationNetwork(new Object[]{AFAdRevenueData(aFh1dSDK), getRevenue().getMediationNetwork()}, -1072478634, 1072478634, (int) System.currentTimeMillis())).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "");
                    Intrinsics.checkNotNullExpressionValue(mediationNetwork, "");
                    getCurrencyIso4217Code(jSONObject, mediationNetwork);
                    return;
                }
                return;
            }
            component4().getMediationNetwork();
            throw null;
        }
        AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "skipping", false, 4, (Object) null);
    }

    public static final /* synthetic */ AFc1dSDK getCurrencyIso4217Code(AFd1uSDK aFd1uSDK) {
        int i = AFLogger + 117;
        int i2 = i % 128;
        copydefault = i2;
        int i3 = i % 2;
        AFc1dSDK aFc1dSDK = aFd1uSDK.getMediationNetwork;
        if (i3 == 0) {
            AFLogger = (i2 + 47) % 128;
            return aFc1dSDK;
        }
        throw null;
    }

    public static Object getMediationNetwork(Object[] objArr, int i, int i2, int i3) {
        int i4 = ~i;
        int i5 = ~i2;
        int i6 = i4 | i5;
        int i7 = (((~i6) | (~(i4 | i3))) * 345) + (i2 * -344) + (i * -344);
        int i8 = ~(i4 | (~i3));
        int i9 = ((~(i6 | i3)) * 345) + (((~(i | i5)) | i8) * 345) + i7;
        if (i9 == 1) {
            return getCurrencyIso4217Code(objArr);
        }
        if (i9 == 2) {
            return AFAdRevenueData(objArr);
        }
        if (i9 == 3) {
            return getRevenue(objArr);
        }
        if (i9 != 4) {
            Map map = objArr[0];
            List list = objArr[1];
            int i10 = AFLogger + 43;
            copydefault = i10 % 128;
            if (i10 % 2 != 0) {
                Pair[] pairArr = new Pair[2];
                pairArr[0] = new Pair("deviceInfo", map);
                pairArr[0] = new Pair("excs", AFd1tSDK.getCurrencyIso4217Code(list));
                return MapsKt.e(pairArr);
            }
            return MapsKt.e(new Pair("deviceInfo", map), new Pair("excs", AFd1tSDK.getCurrencyIso4217Code(list)));
        }
        copydefault = (AFLogger + 59) % 128;
        AFd1xSDK aFd1xSDK = (AFd1xSDK) objArr[0].component3.getValue();
        AFLogger = (copydefault + 5) % 128;
        return aFd1xSDK;
    }

    private final AFf1oSDK getMonetizationNetwork() {
        AFLogger = (copydefault + 99) % 128;
        AFf1oSDK aFf1oSDK = (AFf1oSDK) this.AFAdRevenueData.getValue();
        copydefault = (AFLogger + 11) % 128;
        return aFf1oSDK;
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFLogger = (copydefault + 29) % 128;
        AFi1wSDK aFi1wSDK = objArr[0].getMonetizationNetwork().getMediationNetwork.getCurrencyIso4217Code;
        if (aFi1wSDK != null) {
            int i = AFLogger + 37;
            copydefault = i % 128;
            if (i % 2 == 0) {
                AFh1cSDK aFh1cSDK = aFi1wSDK.getMonetizationNetwork;
                if (aFh1cSDK != null) {
                    return aFh1cSDK.getRevenue;
                }
            } else {
                AFh1cSDK aFh1cSDK2 = aFi1wSDK.getMonetizationNetwork;
                throw null;
            }
        }
        return null;
    }

    public final void AFAdRevenueData(@Nullable AFd1vSDK.AFa1ySDK aFa1ySDK) {
        int i = AFLogger + 21;
        copydefault = i % 128;
        if (i % 2 == 0) {
            this.component2 = aFa1ySDK;
            areAllFieldsValid().execute(new j(this, 1));
            return;
        }
        this.component2 = aFa1ySDK;
        areAllFieldsValid().execute(new j(this, 1));
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r10, int[] r11, java.lang.String r12, int r13, java.lang.Object[] r14) {
        /*
            if (r12 == 0) goto L_0x000e
            int r0 = $11
            int r0 = r0 + 39
            int r0 = r0 % 128
            $10 = r0
            char[] r12 = r12.toCharArray()
        L_0x000e:
            char[] r12 = (char[]) r12
            if (r10 == 0) goto L_0x0018
            java.lang.String r0 = "ISO-8859-1"
            byte[] r10 = r10.getBytes(r0)
        L_0x0018:
            byte[] r10 = (byte[]) r10
            com.appsflyer.internal.AFk1nSDK r0 = new com.appsflyer.internal.AFk1nSDK
            r0.<init>()
            char[] r1 = hashCode
            r2 = -5879130172463570806(0xae692241d207208a, double:-4.0430553008327965E-85)
            r4 = 0
            if (r1 == 0) goto L_0x0054
            int r5 = $11
            int r5 = r5 + 61
            int r6 = r5 % 128
            $10 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x003a
            int r5 = r1.length
            char[] r6 = new char[r5]
            r7 = 1
            goto L_0x003e
        L_0x003a:
            int r5 = r1.length
            char[] r6 = new char[r5]
            r7 = 0
        L_0x003e:
            if (r7 >= r5) goto L_0x0053
            int r8 = $11
            int r8 = r8 + 97
            int r8 = r8 % 128
            $10 = r8
            char r8 = r1[r7]
            long r8 = (long) r8
            long r8 = r8 ^ r2
            int r9 = (int) r8
            char r8 = (char) r9
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x003e
        L_0x0053:
            r1 = r6
        L_0x0054:
            int r5 = equals
            long r5 = (long) r5
            long r2 = r2 ^ r5
            int r3 = (int) r2
            boolean r2 = copy
            if (r2 == 0) goto L_0x008b
            int r11 = r10.length
            r0.getMonetizationNetwork = r11
            char[] r11 = new char[r11]
            r0.AFAdRevenueData = r4
        L_0x0064:
            int r12 = r0.AFAdRevenueData
            int r2 = r0.getMonetizationNetwork
            if (r12 >= r2) goto L_0x0083
            int r5 = $10
            int r5 = r5 + 19
            int r5 = r5 % 128
            $11 = r5
            int r2 = r2 + -1
            int r2 = r2 - r12
            byte r2 = r10[r2]
            int r2 = r2 + r13
            char r2 = r1[r2]
            int r2 = r2 - r3
            char r2 = (char) r2
            r11[r12] = r2
            int r12 = r12 + 1
            r0.AFAdRevenueData = r12
            goto L_0x0064
        L_0x0083:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r11)
            r14[r4] = r10
            return
        L_0x008b:
            boolean r10 = toString
            if (r10 == 0) goto L_0x00c7
            int r10 = r12.length
            r0.getMonetizationNetwork = r10
            char[] r10 = new char[r10]
            r0.AFAdRevenueData = r4
        L_0x0096:
            int r11 = r0.AFAdRevenueData
            int r2 = r0.getMonetizationNetwork
            if (r11 >= r2) goto L_0x00ad
            int r2 = r2 + -1
            int r2 = r2 - r11
            char r2 = r12[r2]
            int r2 = r2 - r13
            char r2 = r1[r2]
            int r2 = r2 - r3
            char r2 = (char) r2
            r10[r11] = r2
            int r11 = r11 + 1
            r0.AFAdRevenueData = r11
            goto L_0x0096
        L_0x00ad:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r10)
            int r10 = $11
            int r10 = r10 + 27
            int r12 = r10 % 128
            $10 = r12
            int r10 = r10 % 2
            if (r10 == 0) goto L_0x00c4
            r10 = 15
            int r10 = r10 / r4
            r14[r4] = r11
            return
        L_0x00c4:
            r14[r4] = r11
            return
        L_0x00c7:
            int r10 = r11.length
            r0.getMonetizationNetwork = r10
            char[] r10 = new char[r10]
            r0.AFAdRevenueData = r4
        L_0x00ce:
            int r12 = r0.AFAdRevenueData
            int r2 = r0.getMonetizationNetwork
            if (r12 >= r2) goto L_0x00e5
            int r2 = r2 + -1
            int r2 = r2 - r12
            r2 = r11[r2]
            int r2 = r2 - r13
            char r2 = r1[r2]
            int r2 = r2 - r3
            char r2 = (char) r2
            r10[r12] = r2
            int r12 = r12 + 1
            r0.AFAdRevenueData = r12
            goto L_0x00ce
        L_0x00e5:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r10)
            r14[r4] = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1uSDK.a(java.lang.String, int[], java.lang.String, int, java.lang.Object[]):void");
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        AFd1uSDK aFd1uSDK = objArr[0];
        copydefault = (AFLogger + 43) % 128;
        Intrinsics.checkNotNullParameter(aFd1uSDK, "");
        aFd1uSDK.equals();
        int i = copydefault + 69;
        AFLogger = i % 128;
        if (i % 2 == 0) {
            int i2 = 22 / 0;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void getMonetizationNetwork(AFd1uSDK aFd1uSDK) {
        AFLogger = (copydefault + 9) % 128;
        Intrinsics.checkNotNullParameter(aFd1uSDK, "");
        aFd1uSDK.copy();
        AFLogger = (copydefault + 51) % 128;
    }

    @WorkerThread
    private final void getCurrencyIso4217Code(String str, String str2) {
        AFLogger = (copydefault + 53) % 128;
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        ((AFd1xSDK) getMediationNetwork(new Object[]{this}, -704520981, 704520985, System.identityHashCode(this))).getMediationNetwork(bytes, MapsKt.d(new Pair(HttpHeaders.AUTHORIZATION, AFj1cSDK.getRevenue(str, str2))), Constants.MAX_URL_LENGTH);
        int i = copydefault + 95;
        AFLogger = i % 128;
        if (i % 2 == 0) {
            int i2 = 81 / 0;
        }
    }

    private final boolean getMonetizationNetwork(AFh1dSDK aFh1dSDK) {
        copydefault = (AFLogger + 67) % 128;
        long currentTimeMillis = System.currentTimeMillis();
        long currencyIso4217Code = component2().getCurrencyIso4217Code("af_send_exc_to_server_window", -1);
        if (aFh1dSDK.getMediationNetwork < TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis)) {
            copydefault = (AFLogger + 25) % 128;
            return false;
        } else if (currencyIso4217Code == -1 || currencyIso4217Code < currentTimeMillis) {
            return false;
        } else {
            return getMediationNetwork(aFh1dSDK);
        }
    }

    public final void AFAdRevenueData() {
        int i = copydefault + 61;
        AFLogger = i % 128;
        if (i % 2 != 0) {
            areAllFieldsValid().execute(new j(this, 0));
            copydefault = (AFLogger + 81) % 128;
            return;
        }
        areAllFieldsValid().execute(new j(this, 0));
        throw null;
    }

    @NotNull
    public final AFc1aSDK getRevenue() {
        int i = copydefault + 41;
        AFLogger = i % 128;
        if (i % 2 != 0) {
            return (AFc1aSDK) this.component4.getValue();
        }
        AFc1aSDK aFc1aSDK = (AFc1aSDK) this.component4.getValue();
        throw null;
    }

    private final void getRevenue(AFh1dSDK aFh1dSDK) {
        int i;
        AFc1qSDK component22;
        int i2 = copydefault + 115;
        AFLogger = i2 % 128;
        if (i2 % 2 == 0) {
            i = aFh1dSDK.getCurrencyIso4217Code;
            int i3 = aFh1dSDK.AFAdRevenueData;
            component22 = component2();
            component22.getMonetizationNetwork("af_send_exc_to_server_window", System.currentTimeMillis() ^ TimeUnit.DAYS.toMillis((long) i3));
        } else {
            i = aFh1dSDK.getCurrencyIso4217Code;
            int i4 = aFh1dSDK.AFAdRevenueData;
            long currentTimeMillis = System.currentTimeMillis();
            component22 = component2();
            component22.getMonetizationNetwork("af_send_exc_to_server_window", TimeUnit.DAYS.toMillis((long) i4) + currentTimeMillis);
        }
        component22.getMediationNetwork("af_send_exc_min", i);
    }

    private static /* synthetic */ Object AFAdRevenueData(Object[] objArr) {
        AFd1uSDK aFd1uSDK = objArr[0];
        int i = AFLogger + 79;
        copydefault = i % 128;
        if (i % 2 != 0) {
            aFd1uSDK.areAllFieldsValid().execute(new j(aFd1uSDK, 2));
            int i2 = 76 / 0;
        } else {
            aFd1uSDK.areAllFieldsValid().execute(new j(aFd1uSDK, 2));
        }
        int i3 = copydefault + 21;
        AFLogger = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 93 / 0;
        }
        return null;
    }

    private final boolean getCurrencyIso4217Code(AFh1dSDK aFh1dSDK) {
        long currentTimeMillis = System.currentTimeMillis();
        long currencyIso4217Code = component2().getCurrencyIso4217Code("af_send_exc_to_server_window", -1);
        if (aFh1dSDK.getMediationNetwork < TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis)) {
            return false;
        }
        if (currencyIso4217Code != -1) {
            copydefault = (AFLogger + 27) % 128;
            if (currencyIso4217Code >= currentTimeMillis) {
                int AFAdRevenueData2 = component2().AFAdRevenueData("af_send_exc_min", -1);
                if (AFAdRevenueData2 == -1 || getRevenue().getCurrencyIso4217Code() < AFAdRevenueData2) {
                    return false;
                }
                return getMediationNetwork(aFh1dSDK);
            }
        }
        copydefault = (AFLogger + 13) % 128;
        return false;
    }

    private final AFc1pSDK getMediationNetwork() {
        copydefault = (AFLogger + 87) % 128;
        AFc1pSDK aFc1pSDK = (AFc1pSDK) this.getMonetizationNetwork.getValue();
        AFLogger = (copydefault + 59) % 128;
        return aFc1pSDK;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.appsflyer.internal.AFh1dSDK} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void getMediationNetwork(com.appsflyer.internal.AFd1uSDK r6, java.lang.Throwable r7, java.lang.String r8) {
        /*
            r0 = 0
            r1 = 1
            int r2 = copydefault
            int r2 = r2 + 101
            int r3 = r2 % 128
            AFLogger = r3
            int r2 = r2 % 2
            r3 = -855295867(0xffffffffcd053885, float:-1.39692112E8)
            r4 = 855295870(0x32fac77e, float:2.9194549E-8)
            java.lang.String r5 = ""
            if (r2 != 0) goto L_0x0033
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r2[r0] = r6
            int r5 = java.lang.System.identityHashCode(r6)
            java.lang.Object r2 = getMediationNetwork(r2, r4, r3, r5)
            com.appsflyer.internal.AFh1dSDK r2 = (com.appsflyer.internal.AFh1dSDK) r2
            r3 = 90
            int r3 = r3 / r0
            if (r2 == 0) goto L_0x0062
            goto L_0x004d
        L_0x0033:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r2[r0] = r6
            int r0 = java.lang.System.identityHashCode(r6)
            java.lang.Object r0 = getMediationNetwork(r2, r4, r3, r0)
            r2 = r0
            com.appsflyer.internal.AFh1dSDK r2 = (com.appsflyer.internal.AFh1dSDK) r2
            if (r2 == 0) goto L_0x0062
        L_0x004d:
            boolean r0 = r6.getMonetizationNetwork((com.appsflyer.internal.AFh1dSDK) r2)
            if (r0 != r1) goto L_0x0062
            com.appsflyer.internal.AFc1aSDK r6 = r6.getRevenue()
            r6.AFAdRevenueData((java.lang.Throwable) r7, (java.lang.String) r8)
            int r6 = copydefault
            int r6 = r6 + 91
            int r6 = r6 % 128
            AFLogger = r6
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1uSDK.getMediationNetwork(com.appsflyer.internal.AFd1uSDK, java.lang.Throwable, java.lang.String):void");
    }

    private final Map<String, String> AFAdRevenueData(AFh1dSDK aFh1dSDK) {
        Object[] objArr = new Object[1];
        a("", (int[]) null, (String) null, ExpandableListView.getPackedPositionType(0) + 127, objArr);
        Map<String, String> e = MapsKt.e(new Pair(((String) objArr[0]).intern(), Build.BRAND), new Pair("model", Build.MODEL), new Pair("app_id", getMediationNetwork().getRevenue.getMonetizationNetwork.getPackageName()), new Pair("p_ex", new AFa1vSDK().getMonetizationNetwork()), new Pair("api", String.valueOf(Build.VERSION.SDK_INT)), new Pair(ServerProtocol.DIALOG_PARAM_SDK_VERSION, this.component1), new Pair("uid", AFb1iSDK.getRevenue(getMediationNetwork().getMonetizationNetwork)), new Pair("exc_config", aFh1dSDK.getMonetizationNetwork()));
        int i = copydefault + 125;
        AFLogger = i % 128;
        if (i % 2 != 0) {
            return e;
        }
        throw null;
    }

    public final void getMediationNetwork(@NotNull Throwable th, @NotNull String str) {
        copydefault = (AFLogger + 75) % 128;
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        areAllFieldsValid().execute(new m0(this, 19, th, str));
        AFLogger = (copydefault + 53) % 128;
    }

    public final void getCurrencyIso4217Code() {
        getMediationNetwork(new Object[]{this}, 58037992, -58037990, System.identityHashCode(this));
    }

    /* access modifiers changed from: private */
    public static final void getMediationNetwork(AFd1uSDK aFd1uSDK) {
        copydefault = (AFLogger + 83) % 128;
        Intrinsics.checkNotNullParameter(aFd1uSDK, "");
        aFd1uSDK.copydefault();
        AFLogger = (copydefault + 105) % 128;
    }

    private final boolean getMediationNetwork(AFh1dSDK aFh1dSDK) {
        new AFd1sSDK();
        String str = this.component1;
        String str2 = aFh1dSDK.getRevenue;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        boolean mediationNetwork = AFd1sSDK.getMediationNetwork(str, str2);
        AFLogger = (copydefault + 79) % 128;
        return mediationNetwork;
    }

    private static Map<String, Object> getMediationNetwork(Map<String, ? extends Object> map, List<AFc1cSDK> list) {
        return (Map) getMediationNetwork(new Object[]{map, list}, -1072478634, 1072478634, (int) System.currentTimeMillis());
    }

    /* access modifiers changed from: private */
    public static final void AFAdRevenueData(AFd1uSDK aFd1uSDK) {
        getMediationNetwork(new Object[]{aFd1uSDK}, 801406437, -801406436, (int) System.currentTimeMillis());
    }
}
