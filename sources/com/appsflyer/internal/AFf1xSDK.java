package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFj1qSDK;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nResolveDdlTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ResolveDdlTask.kt\ncom/appsflyer/internal/components/queue/tasks/ResolveDdlTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,278:1\n1#2:279\n1#2:290\n1603#3,9:280\n1855#3:289\n1856#3:291\n1612#3:292\n1855#3,2:296\n3792#4:293\n4307#4,2:294\n*S KotlinDebug\n*F\n+ 1 ResolveDdlTask.kt\ncom/appsflyer/internal/components/queue/tasks/ResolveDdlTask\n*L\n104#1:290\n104#1:280,9\n104#1:289\n104#1:291\n104#1:292\n202#1:296,2\n197#1:293\n197#1:294,2\n*E\n"})
public final class AFf1xSDK extends AFe1dSDK<AFa1mSDK> {
    private int AFInAppEventParameterName;
    @NotNull
    private final List<AFj1qSDK> AFInAppEventType = new ArrayList();
    private int AFKeystoreWrapper;
    private int AFLogger;
    @NotNull
    private final AFa1pSDK component2;
    @NotNull
    private final AFh1vSDK copy;
    @NotNull
    private final AFc1kSDK copydefault;
    @NotNull
    private final AFc1pSDK equals;
    @NotNull
    private final AFa1oSDK hashCode;
    @NotNull
    private final CountDownLatch registerClient = new CountDownLatch(1);
    @NotNull
    private final AFj1sSDK toString;

    public /* synthetic */ class AFa1tSDK {
        public static final /* synthetic */ int[] AFAdRevenueData;
        public static final /* synthetic */ int[] getRevenue;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        static {
            /*
                com.appsflyer.internal.AFe1rSDK[] r0 = com.appsflyer.internal.AFe1rSDK.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.appsflyer.internal.AFe1rSDK r2 = com.appsflyer.internal.AFe1rSDK.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.appsflyer.internal.AFe1rSDK r3 = com.appsflyer.internal.AFe1rSDK.FAILURE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                getRevenue = r0
                com.appsflyer.internal.AFj1qSDK$AFa1ySDK[] r0 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.appsflyer.internal.AFj1qSDK$AFa1ySDK r3 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.FINISHED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.appsflyer.internal.AFj1qSDK$AFa1ySDK r1 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.STARTED     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                AFAdRevenueData = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1xSDK.AFa1tSDK.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFf1xSDK(@NotNull AFa1pSDK aFa1pSDK, @NotNull AFc1dSDK aFc1dSDK) {
        super(AFe1mSDK.DLSDK, new AFe1mSDK[]{AFe1mSDK.RC_CDN, AFe1mSDK.FETCH_ADVERTISING_ID}, aFc1dSDK, "DdlSdk");
        int i;
        Intrinsics.checkNotNullParameter(aFa1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        this.component2 = aFa1pSDK;
        AFc1pSDK revenue = aFc1dSDK.getRevenue();
        Intrinsics.checkNotNullExpressionValue(revenue, "");
        this.equals = revenue;
        AFc1kSDK afInfoLog = aFc1dSDK.afInfoLog();
        Intrinsics.checkNotNullExpressionValue(afInfoLog, "");
        this.copydefault = afInfoLog;
        AFa1oSDK d = aFc1dSDK.d();
        Intrinsics.checkNotNullExpressionValue(d, "");
        this.hashCode = d;
        AFh1vSDK areAllFieldsValid = aFc1dSDK.areAllFieldsValid();
        Intrinsics.checkNotNullExpressionValue(areAllFieldsValid, "");
        this.copy = areAllFieldsValid;
        AFj1sSDK AFLogger2 = aFc1dSDK.AFLogger();
        Intrinsics.checkNotNullExpressionValue(AFLogger2, "");
        this.toString = AFLogger2;
        AFj1qSDK[] revenue2 = AFLogger2.getRevenue();
        Intrinsics.checkNotNullExpressionValue(revenue2, "");
        ArrayList arrayList = new ArrayList();
        for (AFj1qSDK aFj1qSDK : revenue2) {
            if (!(aFj1qSDK == null || aFj1qSDK.component4 == AFj1qSDK.AFa1ySDK.NOT_STARTED)) {
                arrayList.add(aFj1qSDK);
            }
        }
        this.AFInAppEventParameterName = arrayList.size();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AFj1qSDK aFj1qSDK2 = (AFj1qSDK) it.next();
            AFj1qSDK.AFa1ySDK aFa1ySDK = aFj1qSDK2.component4;
            if (aFa1ySDK == null) {
                i = -1;
            } else {
                i = AFa1tSDK.AFAdRevenueData[aFa1ySDK.ordinal()];
            }
            if (i == 1) {
                AFg1gSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, aFj1qSDK2.AFAdRevenueData.get("source") + " referrer collected earlier", false, 4, (Object) null);
                Intrinsics.checkNotNullExpressionValue(aFj1qSDK2, "");
                getMediationNetwork(aFj1qSDK2);
            } else if (i == 2) {
                aFj1qSDK2.addObserver(new k(aFj1qSDK2, this));
            }
        }
    }

    private static Map<String, String> AFAdRevenueData(AFb1mSDK aFb1mSDK) {
        String str;
        if (aFb1mSDK == null || (str = aFb1mSDK.getMonetizationNetwork) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(str, "");
        Boolean bool = aFb1mSDK.getMediationNetwork;
        if (bool != null && bool.booleanValue()) {
            return null;
        }
        return MapsKt.e(new Pair("type", "unhashed"), new Pair("value", str));
    }

    private final boolean copy() {
        List list;
        int i;
        Object obj = this.component2.AFAdRevenueData.get("referrers");
        if (obj instanceof List) {
            list = (List) obj;
        } else {
            list = null;
        }
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        if (i >= this.AFInAppEventParameterName || this.component2.AFAdRevenueData.containsKey("referrers")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void getMonetizationNetwork(AFj1qSDK aFj1qSDK, AFf1xSDK aFf1xSDK, Observable observable, Object obj) {
        Intrinsics.checkNotNullParameter(aFf1xSDK, "");
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.DDL;
        Object obj2 = aFj1qSDK.AFAdRevenueData.get("source");
        AFg1gSDK.d$default(aFLogger, aFg1cSDK, obj2 + " referrer collected via observer", false, 4, (Object) null);
        Intrinsics.d(observable, "");
        aFf1xSDK.getMediationNetwork((AFj1qSDK) observable);
    }

    public final boolean a_() {
        return false;
    }

    public final /* bridge */ /* synthetic */ AppsFlyerRequestListener component3() {
        return null;
    }

    public final boolean copydefault() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01d7  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFe1rSDK getCurrencyIso4217Code() {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r0 = ""
            java.lang.String r2 = "Error occurred. Server response code = "
            com.appsflyer.internal.AFe1rSDK r3 = com.appsflyer.internal.AFe1rSDK.FAILURE
            r4 = 1
            r5 = 0
            com.appsflyer.internal.AFe1rSDK r6 = super.getCurrencyIso4217Code()     // Catch:{ Exception -> 0x017c }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch:{ Exception -> 0x017c }
            com.appsflyer.internal.AFh1vSDK r3 = r1.copy     // Catch:{ Exception -> 0x0052 }
            int r7 = r1.AFLogger     // Catch:{ Exception -> 0x0052 }
            java.lang.String r8 = "ddl"
            r9 = 0
            r11 = 2
            if (r7 <= 0) goto L_0x006d
            if (r7 <= r11) goto L_0x001f
            goto L_0x006d
        L_0x001f:
            int r7 = r7 - r4
            long[] r12 = r3.component2     // Catch:{ Exception -> 0x0052 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0052 }
            r12[r7] = r13     // Catch:{ Exception -> 0x0052 }
            long[] r12 = r3.component1     // Catch:{ Exception -> 0x0052 }
            r13 = r12[r7]     // Catch:{ Exception -> 0x0052 }
            int r12 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r12 == 0) goto L_0x0056
            long[] r12 = r3.component4     // Catch:{ Exception -> 0x0052 }
            long[] r15 = r3.component2     // Catch:{ Exception -> 0x0052 }
            r16 = r15[r7]     // Catch:{ Exception -> 0x0052 }
            long r16 = r16 - r13
            r12[r7] = r16     // Catch:{ Exception -> 0x0052 }
            java.util.Map<java.lang.String, java.lang.Object> r7 = r3.getMonetizationNetwork     // Catch:{ Exception -> 0x0052 }
            java.lang.String r13 = "net"
            r7.put(r13, r12)     // Catch:{ Exception -> 0x0052 }
            java.util.Map<java.lang.String, java.lang.Object> r7 = r3.getMonetizationNetwork     // Catch:{ Exception -> 0x0052 }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x0052 }
            r12.<init>(r7)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFc1qSDK r3 = r3.getCurrencyIso4217Code     // Catch:{ Exception -> 0x0052 }
            java.lang.String r7 = r12.toString()     // Catch:{ Exception -> 0x0052 }
            r3.getMediationNetwork((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0081
        L_0x0052:
            r0 = move-exception
            r3 = r6
            goto L_0x017d
        L_0x0056:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
            java.lang.String r12 = "Metrics: ddlStart["
            r3.<init>(r12)     // Catch:{ Exception -> 0x0052 }
            r3.append(r7)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r7 = "] ts is missing"
            r3.append(r7)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0081
        L_0x006d:
            java.lang.String r3 = "Unexpected ddl requestCount - end"
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0052 }
            java.lang.String r13 = "Metrics: Unexpected ddl requestCount = "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r7 = r13.concat(r7)     // Catch:{ Exception -> 0x0052 }
            r12.<init>(r7)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r3, r12)     // Catch:{ Exception -> 0x0052 }
        L_0x0081:
            int[] r3 = com.appsflyer.internal.AFf1xSDK.AFa1tSDK.getRevenue     // Catch:{ Exception -> 0x0052 }
            int r7 = r6.ordinal()     // Catch:{ Exception -> 0x0052 }
            r3 = r3[r7]     // Catch:{ Exception -> 0x0052 }
            if (r3 == r4) goto L_0x00cc
            if (r3 == r11) goto L_0x008f
            goto L_0x022b
        L_0x008f:
            com.appsflyer.AFLogger r12 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFg1cSDK r13 = com.appsflyer.internal.AFg1cSDK.DDL     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFd1aSDK<Result> r0 = r1.component1     // Catch:{ Exception -> 0x0052 }
            if (r0 == 0) goto L_0x00a0
            int r0 = r0.getStatusCode()     // Catch:{ Exception -> 0x0052 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0052 }
            goto L_0x00a1
        L_0x00a0:
            r0 = r5
        L_0x00a1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0052 }
            r3.append(r0)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r14 = r3.toString()     // Catch:{ Exception -> 0x0052 }
            r16 = 4
            r17 = 0
            r15 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.deeplink.DeepLinkResult r0 = new com.appsflyer.deeplink.DeepLinkResult     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.deeplink.DeepLinkResult$Error r2 = com.appsflyer.deeplink.DeepLinkResult.Error.HTTP_STATUS_CODE     // Catch:{ Exception -> 0x0052 }
            r0.<init>(r5, r2)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFh1vSDK r2 = r1.copy     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFa1oSDK r3 = r1.hashCode     // Catch:{ Exception -> 0x0052 }
            long r7 = r3.component3     // Catch:{ Exception -> 0x0052 }
            r2.getMediationNetwork(r0, r7)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFa1oSDK r2 = r1.hashCode     // Catch:{ Exception -> 0x0052 }
            r2.getRevenue(r0)     // Catch:{ Exception -> 0x0052 }
            goto L_0x022b
        L_0x00cc:
            com.appsflyer.internal.AFd1aSDK<Result> r2 = r1.component1     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.Intrinsics.c(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.Object r2 = r2.getBody()     // Catch:{ Exception -> 0x0052 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFa1mSDK r2 = (com.appsflyer.internal.AFa1mSDK) r2     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.deeplink.DeepLink r0 = r2.getCurrencyIso4217Code     // Catch:{ Exception -> 0x0052 }
            if (r0 == 0) goto L_0x00f3
            com.appsflyer.deeplink.DeepLinkResult r2 = new com.appsflyer.deeplink.DeepLinkResult     // Catch:{ Exception -> 0x0052 }
            r2.<init>(r0, r5)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFh1vSDK r0 = r1.copy     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFa1oSDK r3 = r1.hashCode     // Catch:{ Exception -> 0x0052 }
            long r7 = r3.component3     // Catch:{ Exception -> 0x0052 }
            r0.getMediationNetwork(r2, r7)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFa1oSDK r0 = r1.hashCode     // Catch:{ Exception -> 0x0052 }
            r0.getRevenue(r2)     // Catch:{ Exception -> 0x0052 }
            goto L_0x022b
        L_0x00f3:
            int r0 = r1.AFLogger     // Catch:{ Exception -> 0x0052 }
            if (r0 > r4) goto L_0x0167
            boolean r0 = r2.getRevenue()     // Catch:{ Exception -> 0x0052 }
            if (r0 == 0) goto L_0x0167
            boolean r0 = r18.copy()     // Catch:{ Exception -> 0x0052 }
            if (r0 == 0) goto L_0x0167
            com.appsflyer.AFLogger r11 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFg1cSDK r12 = com.appsflyer.internal.AFg1cSDK.DDL     // Catch:{ Exception -> 0x0052 }
            java.lang.String r13 = "Waiting for referrers..."
            r15 = 4
            r16 = 0
            r14 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0052 }
            java.util.concurrent.CountDownLatch r0 = r1.registerClient     // Catch:{ Exception -> 0x0052 }
            r0.await()     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFh1vSDK r0 = r1.copy     // Catch:{ Exception -> 0x0052 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0052 }
            long[] r7 = r0.component2     // Catch:{ Exception -> 0x0052 }
            r11 = 0
            r11 = r7[r11]     // Catch:{ Exception -> 0x0052 }
            int r7 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x0141
            java.util.Map<java.lang.String, java.lang.Object> r7 = r0.getMonetizationNetwork     // Catch:{ Exception -> 0x0052 }
            java.lang.String r9 = "rfr_wait"
            long r2 = r2 - r11
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0052 }
            r7.put(r9, r2)     // Catch:{ Exception -> 0x0052 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = r0.getMonetizationNetwork     // Catch:{ Exception -> 0x0052 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0052 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFc1qSDK r0 = r0.getCurrencyIso4217Code     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0052 }
            r0.getMediationNetwork((java.lang.String) r8, (java.lang.String) r2)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0146
        L_0x0141:
            java.lang.String r0 = "Metrics: ddlEnd[0] ts is missing"
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ Exception -> 0x0052 }
        L_0x0146:
            int r0 = r1.AFKeystoreWrapper     // Catch:{ Exception -> 0x0052 }
            int r2 = r1.AFInAppEventParameterName     // Catch:{ Exception -> 0x0052 }
            if (r0 != r2) goto L_0x0162
            com.appsflyer.deeplink.DeepLinkResult r0 = new com.appsflyer.deeplink.DeepLinkResult     // Catch:{ Exception -> 0x0052 }
            r0.<init>(r5, r5)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFh1vSDK r2 = r1.copy     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFa1oSDK r3 = r1.hashCode     // Catch:{ Exception -> 0x0052 }
            long r7 = r3.component3     // Catch:{ Exception -> 0x0052 }
            r2.getMediationNetwork(r0, r7)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFa1oSDK r2 = r1.hashCode     // Catch:{ Exception -> 0x0052 }
            r2.getRevenue(r0)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFe1rSDK r0 = com.appsflyer.internal.AFe1rSDK.SUCCESS     // Catch:{ Exception -> 0x0052 }
            return r0
        L_0x0162:
            com.appsflyer.internal.AFe1rSDK r0 = r18.getCurrencyIso4217Code()     // Catch:{ Exception -> 0x0052 }
            return r0
        L_0x0167:
            com.appsflyer.deeplink.DeepLinkResult r0 = new com.appsflyer.deeplink.DeepLinkResult     // Catch:{ Exception -> 0x0052 }
            r0.<init>(r5, r5)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFh1vSDK r2 = r1.copy     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFa1oSDK r3 = r1.hashCode     // Catch:{ Exception -> 0x0052 }
            long r7 = r3.component3     // Catch:{ Exception -> 0x0052 }
            r2.getMediationNetwork(r0, r7)     // Catch:{ Exception -> 0x0052 }
            com.appsflyer.internal.AFa1oSDK r2 = r1.hashCode     // Catch:{ Exception -> 0x0052 }
            r2.getRevenue(r0)     // Catch:{ Exception -> 0x0052 }
            goto L_0x022b
        L_0x017c:
            r0 = move-exception
        L_0x017d:
            java.lang.Throwable r2 = r0.getCause()
            boolean r6 = r2 instanceof java.lang.InterruptedException
            if (r6 == 0) goto L_0x0186
            goto L_0x0188
        L_0x0186:
            boolean r4 = r2 instanceof java.io.InterruptedIOException
        L_0x0188:
            if (r4 == 0) goto L_0x01d7
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException
            r0.<init>()
            java.lang.String r2 = "[DDL] Timeout"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r2, r0)
            com.appsflyer.AFLogger r6 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r7 = com.appsflyer.internal.AFg1cSDK.DDL
            int r0 = r1.AFLogger
            com.appsflyer.internal.AFa1oSDK r2 = r1.hashCode
            long r2 = r2.component3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r8 = "Timeout, didn't manage to find deferred deeplink after "
            r4.<init>(r8)
            r4.append(r0)
            java.lang.String r0 = " attempt(s) within "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = " milliseconds"
            r4.append(r0)
            java.lang.String r8 = r4.toString()
            r10 = 4
            r11 = 0
            r9 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r6, r7, r8, r9, r10, r11)
            com.appsflyer.deeplink.DeepLinkResult r0 = new com.appsflyer.deeplink.DeepLinkResult
            com.appsflyer.deeplink.DeepLinkResult$Error r2 = com.appsflyer.deeplink.DeepLinkResult.Error.TIMEOUT
            r0.<init>(r5, r2)
            com.appsflyer.internal.AFh1vSDK r2 = r1.copy
            com.appsflyer.internal.AFa1oSDK r3 = r1.hashCode
            long r3 = r3.component3
            r2.getMediationNetwork(r0, r3)
            com.appsflyer.internal.AFa1oSDK r2 = r1.hashCode
            r2.getRevenue(r0)
            com.appsflyer.internal.AFe1rSDK r6 = com.appsflyer.internal.AFe1rSDK.TIMEOUT
            goto L_0x022b
        L_0x01d7:
            boolean r2 = r2 instanceof java.io.IOException
            if (r2 == 0) goto L_0x01fd
            com.appsflyer.AFLogger r6 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r7 = com.appsflyer.internal.AFg1cSDK.DDL
            r10 = 4
            r11 = 0
            java.lang.String r8 = "Http Exception: the request was not sent to the server"
            r9 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r6, r7, r8, r9, r10, r11)
            com.appsflyer.deeplink.DeepLinkResult r0 = new com.appsflyer.deeplink.DeepLinkResult
            com.appsflyer.deeplink.DeepLinkResult$Error r2 = com.appsflyer.deeplink.DeepLinkResult.Error.NETWORK
            r0.<init>(r5, r2)
            com.appsflyer.internal.AFh1vSDK r2 = r1.copy
            com.appsflyer.internal.AFa1oSDK r4 = r1.hashCode
            long r4 = r4.component3
            r2.getMediationNetwork(r0, r4)
            com.appsflyer.internal.AFa1oSDK r2 = r1.hashCode
            r2.getRevenue(r0)
            goto L_0x022a
        L_0x01fd:
            com.appsflyer.AFLogger r6 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r7 = com.appsflyer.internal.AFg1cSDK.DDL
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unexpected Exception: "
            r2.<init>(r4)
            r2.append(r0)
            java.lang.String r8 = r2.toString()
            r10 = 4
            r11 = 0
            r9 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r6, r7, r8, r9, r10, r11)
            com.appsflyer.deeplink.DeepLinkResult r0 = new com.appsflyer.deeplink.DeepLinkResult
            com.appsflyer.deeplink.DeepLinkResult$Error r2 = com.appsflyer.deeplink.DeepLinkResult.Error.UNEXPECTED
            r0.<init>(r5, r2)
            com.appsflyer.internal.AFh1vSDK r2 = r1.copy
            com.appsflyer.internal.AFa1oSDK r4 = r1.hashCode
            long r4 = r4.component3
            r2.getMediationNetwork(r0, r4)
            com.appsflyer.internal.AFa1oSDK r2 = r1.hashCode
            r2.getRevenue(r0)
        L_0x022a:
            r6 = r3
        L_0x022b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1xSDK.getCurrencyIso4217Code():com.appsflyer.internal.AFe1rSDK");
    }

    public final boolean getMediationNetwork() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0104 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFd1nSDK<com.appsflyer.internal.AFa1mSDK> getRevenue(@org.jetbrains.annotations.NotNull java.lang.String r13) {
        /*
            r12 = this;
            r0 = 2
            r1 = 0
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r2)
            int r13 = r12.AFLogger
            r3 = 1
            int r13 = r13 + r3
            r12.AFLogger = r13
            com.appsflyer.AFLogger r4 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r5 = com.appsflyer.internal.AFg1cSDK.DDL
            java.lang.String r6 = "Preparing request "
            java.lang.String r6 = defpackage.ba.k(r13, r6)
            r8 = 4
            r9 = 0
            r7 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r4, r5, r6, r7, r8, r9)
            com.appsflyer.internal.AFa1pSDK r13 = r12.component2
            java.util.Map<java.lang.String, java.lang.Object> r13 = r13.AFAdRevenueData
            int r4 = r12.AFLogger
            r5 = 0
            if (r4 != r3) goto L_0x00c7
            com.appsflyer.internal.AFc1pSDK r4 = r12.equals
            com.appsflyer.internal.AFc1qSDK r4 = r4.getMonetizationNetwork
            java.lang.String r6 = "appsFlyerCount"
            int r4 = r4.AFAdRevenueData((java.lang.String) r6, (int) r1)
            if (r4 != 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0034:
            r4 = 0
        L_0x0035:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            java.lang.String r6 = "is_first"
            r13.put(r6, r4)
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r4 = r4.getLanguage()
            java.util.Locale r6 = java.util.Locale.getDefault()
            java.lang.String r6 = r6.getCountry()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = "-"
            r7.append(r4)
            r7.append(r6)
            java.lang.String r4 = r7.toString()
            java.lang.String r6 = "lang"
            r13.put(r6, r4)
            java.lang.String r4 = "os"
            java.lang.String r6 = android.os.Build.VERSION.RELEASE
            r13.put(r4, r6)
            java.lang.String r4 = "type"
            java.lang.String r6 = android.os.Build.MODEL
            r13.put(r4, r6)
            com.appsflyer.internal.AFc1pSDK r4 = r12.equals
            com.appsflyer.internal.AFc1qSDK r4 = r4.getMonetizationNetwork
            java.lang.String r4 = com.appsflyer.internal.AFb1iSDK.getRevenue(r4)
            java.lang.String r6 = "request_id"
            r13.put(r6, r4)
            com.appsflyer.internal.AFc1kSDK r4 = r12.copydefault
            com.appsflyer.internal.AFb1uSDK r4 = r4.getRevenue
            if (r4 == 0) goto L_0x0094
            java.lang.String[] r4 = r4.getMediationNetwork
            if (r4 == 0) goto L_0x0094
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            java.lang.String r6 = "sharing_filter"
            r13.put(r6, r4)
        L_0x0094:
            com.appsflyer.internal.AFc1pSDK r4 = r12.equals
            com.appsflyer.internal.AFc1kSDK r4 = r4.getCurrencyIso4217Code
            com.appsflyer.internal.AFh1oSDK r4 = r4.component3
            if (r4 == 0) goto L_0x00a6
            com.appsflyer.internal.AFb1mSDK r6 = new com.appsflyer.internal.AFb1mSDK
            java.lang.String r7 = r4.AFAdRevenueData
            java.lang.Boolean r4 = r4.getRevenue
            r6.<init>(r7, r4)
            goto L_0x00a7
        L_0x00a6:
            r6 = r5
        L_0x00a7:
            java.util.Map r4 = AFAdRevenueData(r6)
            if (r4 == 0) goto L_0x00b2
            java.lang.String r6 = "gaid"
            r13.put(r6, r4)
        L_0x00b2:
            com.appsflyer.internal.AFc1pSDK r4 = r12.equals
            com.appsflyer.internal.AFc1iSDK r4 = r4.getRevenue
            android.content.Context r4 = r4.getMonetizationNetwork
            com.appsflyer.internal.AFb1mSDK r4 = com.appsflyer.internal.AFb1jSDK.getMediationNetwork(r4)
            java.util.Map r4 = AFAdRevenueData(r4)
            if (r4 == 0) goto L_0x00c7
            java.lang.String r6 = "oaid"
            r13.put(r6, r4)
        L_0x00c7:
            long r6 = java.lang.System.currentTimeMillis()
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.util.Locale r8 = java.util.Locale.US
            java.lang.String r9 = "yyyy-MM-dd'T'HH:mm:ss.SSS"
            r4.<init>(r9, r8)
            java.lang.String r8 = "UTC"
            java.util.TimeZone r8 = java.util.TimeZone.getTimeZone(r8)
            r4.setTimeZone(r8)
            java.util.Date r8 = new java.util.Date
            r8.<init>(r6)
            java.lang.String r4 = r4.format(r8)
            java.lang.String r6 = "timestamp"
            r13.put(r6, r4)
            int r4 = r12.AFLogger
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r7 = "request_count"
            r13.put(r7, r4)
            java.util.List<com.appsflyer.internal.AFj1qSDK> r4 = r12.AFInAppEventType
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x0104:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x0154
            java.lang.Object r8 = r4.next()
            com.appsflyer.internal.AFj1qSDK r8 = (com.appsflyer.internal.AFj1qSDK) r8
            com.appsflyer.internal.AFj1qSDK$AFa1ySDK r9 = r8.component4
            com.appsflyer.internal.AFj1qSDK$AFa1ySDK r10 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.FINISHED
            if (r9 != r10) goto L_0x014d
            java.util.Map<java.lang.String, java.lang.Object> r9 = r8.AFAdRevenueData
            java.lang.String r10 = "referrer"
            java.lang.Object r9 = r9.get(r10)
            boolean r10 = r9 instanceof java.lang.String
            if (r10 == 0) goto L_0x0125
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x0126
        L_0x0125:
            r9 = r5
        L_0x0126:
            if (r9 == 0) goto L_0x014d
            java.util.Map<java.lang.String, java.lang.Object> r8 = r8.AFAdRevenueData
            java.lang.String r10 = "source"
            java.lang.Object r8 = r8.get(r10)
            kotlin.jvm.internal.Intrinsics.d(r8, r2)
            java.lang.String r8 = (java.lang.String) r8
            kotlin.Pair r11 = new kotlin.Pair
            r11.<init>(r10, r8)
            kotlin.Pair r8 = new kotlin.Pair
            java.lang.String r10 = "value"
            r8.<init>(r10, r9)
            kotlin.Pair[] r9 = new kotlin.Pair[r0]
            r9[r1] = r11
            r9[r3] = r8
            java.util.Map r8 = kotlin.collections.MapsKt.e(r9)
            goto L_0x014e
        L_0x014d:
            r8 = r5
        L_0x014e:
            if (r8 == 0) goto L_0x0104
            r7.add(r8)
            goto L_0x0104
        L_0x0154:
            boolean r1 = r7.isEmpty()
            if (r1 != 0) goto L_0x015f
            java.lang.String r1 = "referrers"
            r13.put(r1, r7)
        L_0x015f:
            com.appsflyer.internal.AFa1pSDK r13 = r12.component2
            com.appsflyer.internal.AFj1fSDK r1 = new com.appsflyer.internal.AFj1fSDK
            com.appsflyer.internal.AFc1pSDK r3 = r12.equals
            r1.<init>(r3, r5, r0, r5)
            com.appsflyer.internal.AFf1gSDK r3 = r12.component3
            java.lang.String r3 = r3.getMediationNetwork()
            com.appsflyer.internal.AFa1pSDK r4 = r12.component2
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFAdRevenueData
            java.lang.Object r4 = r4.get(r6)
            kotlin.jvm.internal.Intrinsics.d(r4, r2)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r1 = r1.AFAdRevenueData((java.lang.String) r3, (java.lang.String) r4)
            r13.component1 = r1
            com.appsflyer.internal.AFh1vSDK r13 = r12.copy
            int r1 = r12.AFLogger
            if (r1 <= 0) goto L_0x01c7
            if (r1 <= r0) goto L_0x018a
            goto L_0x01c7
        L_0x018a:
            int r1 = r1 + -1
            long[] r0 = r13.component1
            long r3 = java.lang.System.currentTimeMillis()
            r0[r1] = r3
            if (r1 != 0) goto L_0x01db
            long r3 = r13.component3
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x01c1
            java.util.Map<java.lang.String, java.lang.Object> r0 = r13.getMonetizationNetwork
            long[] r5 = r13.component1
            r6 = r5[r1]
            long r6 = r6 - r3
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            java.lang.String r3 = "from_fg"
            r0.put(r3, r1)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r13.getMonetizationNetwork
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r0)
            com.appsflyer.internal.AFc1qSDK r13 = r13.getCurrencyIso4217Code
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "ddl"
            r13.getMediationNetwork((java.lang.String) r1, (java.lang.String) r0)
            goto L_0x01db
        L_0x01c1:
            java.lang.String r13 = "Metrics: fg ts is missing"
            com.appsflyer.AFLogger.afInfoLog(r13)
            goto L_0x01db
        L_0x01c7:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "Metrics: Unexpected ddl requestCount = "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r0 = r0.concat(r1)
            r13.<init>(r0)
            java.lang.String r0 = "Unexpected ddl requestCount - start"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r13)
        L_0x01db:
            com.appsflyer.internal.AFd1oSDK r13 = r12.component4
            com.appsflyer.internal.AFa1pSDK r0 = r12.component2
            com.appsflyer.internal.AFd1nSDK r13 = r13.AFAdRevenueData(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r2)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1xSDK.getRevenue(java.lang.String):com.appsflyer.internal.AFd1nSDK");
    }

    private final void getMediationNetwork(AFj1qSDK aFj1qSDK) {
        if (getMonetizationNetwork(aFj1qSDK)) {
            this.AFInAppEventType.add(aFj1qSDK);
            this.registerClient.countDown();
            AFg1gSDK.d$default(AFLogger.INSTANCE, AFg1cSDK.DDL, "Added non-organic ".concat(aFj1qSDK.getClass().getSimpleName()), false, 4, (Object) null);
            return;
        }
        int i = this.AFKeystoreWrapper + 1;
        this.AFKeystoreWrapper = i;
        if (i == this.AFInAppEventParameterName) {
            this.registerClient.countDown();
        }
    }

    private static boolean getMonetizationNetwork(AFj1qSDK aFj1qSDK) {
        Object obj = aFj1qSDK.AFAdRevenueData.get("click_ts");
        Long l = obj instanceof Long ? (Long) obj : null;
        if (l != null) {
            if (System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l.longValue()) < TimeUnit.DAYS.toMillis(1)) {
                return true;
            }
        }
        return false;
    }

    public final long getMonetizationNetwork() {
        return this.hashCode.component3;
    }
}
