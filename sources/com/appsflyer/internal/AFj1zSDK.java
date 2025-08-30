package com.appsflyer.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.ExecutorService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nMetaReferrer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MetaReferrer.kt\ncom/appsflyer/internal/referrer/MetaReferrer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,295:1\n1#2:296\n*E\n"})
public final class AFj1zSDK extends AFi1dSDK {
    @NotNull
    private final Runnable component3;
    @NotNull
    private final AFj1ySDK getCurrencyIso4217Code;
    @NotNull
    private final AFc1pSDK getMediationNetwork;
    @NotNull
    private final ExecutorService getMonetizationNetwork;
    @Nullable
    private String hashCode;

    public /* synthetic */ class AFa1vSDK {
        public static final /* synthetic */ int[] getMonetizationNetwork;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.appsflyer.internal.AFj1ySDK[] r0 = com.appsflyer.internal.AFj1ySDK.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.appsflyer.internal.AFj1ySDK r1 = com.appsflyer.internal.AFj1ySDK.FACEBOOK     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.appsflyer.internal.AFj1ySDK r1 = com.appsflyer.internal.AFj1ySDK.INSTAGRAM     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.appsflyer.internal.AFj1ySDK r1 = com.appsflyer.internal.AFj1ySDK.FACEBOOK_LITE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                getMonetizationNetwork = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1zSDK.AFa1vSDK.<clinit>():void");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AFj1zSDK(@org.jetbrains.annotations.NotNull com.appsflyer.internal.AFc1pSDK r3, @org.jetbrains.annotations.NotNull java.util.concurrent.ExecutorService r4, @org.jetbrains.annotations.NotNull com.appsflyer.internal.AFj1ySDK r5, @org.jetbrains.annotations.NotNull java.lang.Runnable r6, @org.jetbrains.annotations.NotNull java.lang.Runnable r7) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int[] r0 = com.appsflyer.internal.AFj1xSDK.AFa1ySDK.getMonetizationNetwork
            int r1 = r5.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x002e
            r1 = 2
            if (r0 == r1) goto L_0x002b
            r1 = 3
            if (r0 != r1) goto L_0x0025
            java.lang.String r0 = "facebook_lite"
            goto L_0x0030
        L_0x0025:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L_0x002b:
            java.lang.String r0 = "instagram"
            goto L_0x0030
        L_0x002e:
            java.lang.String r0 = "facebook"
        L_0x0030:
            java.lang.String r1 = "app"
            r2.<init>(r1, r0, r3, r6)
            r2.getMediationNetwork = r3
            r2.getMonetizationNetwork = r4
            r2.getCurrencyIso4217Code = r5
            r2.component3 = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1zSDK.<init>(com.appsflyer.internal.AFc1pSDK, java.util.concurrent.ExecutorService, com.appsflyer.internal.AFj1ySDK, java.lang.Runnable, java.lang.Runnable):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        if (r0 == null) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean AFAdRevenueData(android.content.Context r12) {
        /*
            r11 = this;
            boolean r0 = r11.getRevenue()
            r1 = 0
            if (r0 != 0) goto L_0x0014
            com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.META_REFERRER
            java.lang.String r4 = "Referrer collection disallowed by counter."
            r5 = 0
            r6 = 4
            r7 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r2, r3, r4, r5, r6, r7)
            return r1
        L_0x0014:
            com.appsflyer.internal.AFc1pSDK r0 = r11.getMediationNetwork
            java.lang.String r2 = "com.facebook.sdk.ApplicationId"
            java.lang.String r0 = r0.getCurrencyIso4217Code((java.lang.String) r2)
            java.lang.String r2 = "fb"
            r3 = 0
            if (r0 == 0) goto L_0x0026
            java.lang.String r0 = kotlin.text.StringsKt.z(r0, r2)
            goto L_0x0027
        L_0x0026:
            r0 = r3
        L_0x0027:
            if (r0 == 0) goto L_0x002f
            int r4 = r0.length()
            if (r4 != 0) goto L_0x003c
        L_0x002f:
            com.appsflyer.AFLogger r5 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r6 = com.appsflyer.internal.AFg1cSDK.META_REFERRER
            java.lang.String r7 = "Facebook app id Manifest metadata is not found."
            r8 = 0
            r9 = 4
            r10 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r5, r6, r7, r8, r9, r10)
            r0 = r3
        L_0x003c:
            if (r0 != 0) goto L_0x008d
            com.appsflyer.internal.AFc1pSDK r0 = r11.getMediationNetwork
            java.lang.String r4 = "facebook_application_id"
            java.lang.String r0 = r0.getRevenue(r4)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = kotlin.text.StringsKt.z(r0, r2)
            goto L_0x004e
        L_0x004d:
            r0 = r3
        L_0x004e:
            if (r0 == 0) goto L_0x0056
            int r4 = r0.length()
            if (r4 != 0) goto L_0x0063
        L_0x0056:
            com.appsflyer.AFLogger r5 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r6 = com.appsflyer.internal.AFg1cSDK.META_REFERRER
            java.lang.String r7 = "Facebook app id string resource is not found."
            r8 = 0
            r9 = 4
            r10 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r5, r6, r7, r8, r9, r10)
            r0 = r3
        L_0x0063:
            if (r0 != 0) goto L_0x008d
            com.appsflyer.internal.AFc1pSDK r0 = r11.getMediationNetwork
            java.lang.String r4 = "com.appsflyer.FacebookApplicationId"
            java.lang.String r0 = r0.getCurrencyIso4217Code((java.lang.String) r4)
            if (r0 == 0) goto L_0x0074
            java.lang.String r0 = kotlin.text.StringsKt.z(r0, r2)
            goto L_0x0075
        L_0x0074:
            r0 = r3
        L_0x0075:
            if (r0 == 0) goto L_0x007d
            int r2 = r0.length()
            if (r2 != 0) goto L_0x008a
        L_0x007d:
            com.appsflyer.AFLogger r4 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r5 = com.appsflyer.internal.AFg1cSDK.META_REFERRER
            java.lang.String r6 = "AF Facebook app id Manifest metadata is not found."
            r7 = 0
            r8 = 4
            r9 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r4, r5, r6, r7, r8, r9)
            r0 = r3
        L_0x008a:
            if (r0 != 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r3 = r0
        L_0x008e:
            r11.hashCode = r3
            if (r3 != 0) goto L_0x009f
            com.appsflyer.AFLogger r4 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r5 = com.appsflyer.internal.AFg1cSDK.META_REFERRER
            java.lang.String r6 = "Referrer collection disallowed by missing Facebook app id."
            r7 = 0
            r8 = 4
            r9 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r4, r5, r6, r7, r8, r9)
            return r1
        L_0x009f:
            boolean r12 = r11.getCurrencyIso4217Code(r12)
            if (r12 != 0) goto L_0x00b2
            com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.META_REFERRER
            java.lang.String r4 = "Referrer collection disallowed by missing content providers."
            r5 = 0
            r6 = 4
            r7 = 0
            com.appsflyer.internal.AFg1gSDK.d$default(r2, r3, r4, r5, r6, r7)
            return r1
        L_0x00b2:
            r12 = 1
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1zSDK.AFAdRevenueData(android.content.Context):boolean");
    }

    private static boolean component2(Context context) {
        if (context.getPackageManager().resolveContentProvider("com.facebook.lite.provider.InstallReferrerProvider", 0) != null) {
            return true;
        }
        return false;
    }

    private final boolean getCurrencyIso4217Code(Context context) {
        int i = AFa1vSDK.getMonetizationNetwork[this.getCurrencyIso4217Code.ordinal()];
        if (i == 1) {
            return getMediationNetwork(context);
        }
        if (i == 2) {
            return getMonetizationNetwork(context);
        }
        if (i == 3) {
            return component2(context);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static boolean getMediationNetwork(Context context) {
        if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.InstallReferrerProvider", 0) != null) {
            return true;
        }
        return false;
    }

    private static boolean getMonetizationNetwork(Context context) {
        return context.getPackageManager().resolveContentProvider("com.instagram.contentprovider.InstallReferrerProvider", 0) != null;
    }

    @SuppressLint({"NewApi"})
    public final void getRevenue(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        if (!AFAdRevenueData(context)) {
            this.component3.run();
        } else {
            this.getMonetizationNetwork.execute(new h(4, this, context));
        }
    }

    /* JADX WARNING: type inference failed for: r16v0 */
    /* JADX WARNING: type inference failed for: r16v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r16v2 */
    /* JADX WARNING: type inference failed for: r16v3, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r16v5 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x021a, code lost:
        if (r11 != null) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x021c, code lost:
        r11.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0220, code lost:
        if (r11 != null) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0222, code lost:
        r11.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x023d, code lost:
        if (r11 != null) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0240, code lost:
        if (r11 != null) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x027f, code lost:
        if (r11 != null) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0282, code lost:
        if (r11 != null) goto L_0x0222;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ea A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ec A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0282  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void getMonetizationNetwork(com.appsflyer.internal.AFj1zSDK r32, android.content.Context r33) {
        /*
            r1 = r32
            r0 = r33
            r2 = 1
            java.lang.String r3 = " provider"
            java.lang.String r4 = "actual_timestamp"
            java.lang.String r5 = "install_referrer"
            java.lang.String r6 = "is_ct"
            java.lang.String r7 = "Error while collecting Meta Install Referrer for "
            java.lang.String r8 = "Collected "
            java.lang.String r9 = "No such column, "
            java.lang.String r10 = "content://com.facebook.katana.provider.InstallReferrerProvider/"
            java.lang.String r11 = "content://com.instagram.contentprovider.InstallReferrerProvider/"
            java.lang.String r12 = "content://com.facebook.lite.provider.InstallReferrerProvider/"
            java.lang.String r13 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r13)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r13)
            long r14 = java.lang.System.currentTimeMillis()
            r1.component1 = r14
            com.appsflyer.internal.AFj1qSDK$AFa1ySDK r14 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.STARTED
            r1.component4 = r14
            com.appsflyer.internal.AFj1qSDK$5 r14 = new com.appsflyer.internal.AFj1qSDK$5
            r14.<init>()
            r1.addObserver(r14)
            java.lang.String r14 = r1.hashCode
            kotlin.jvm.internal.Intrinsics.c(r14)
            r16 = 0
            com.appsflyer.internal.AFj1ySDK r15 = r1.getCurrencyIso4217Code     // Catch:{ all -> 0x0243 }
            int[] r17 = com.appsflyer.internal.AFj1zSDK.AFa1vSDK.getMonetizationNetwork     // Catch:{ all -> 0x0243 }
            int r15 = r15.ordinal()     // Catch:{ all -> 0x0243 }
            r15 = r17[r15]     // Catch:{ all -> 0x0243 }
            r18 = r7
            r7 = 2
            if (r15 == r2) goto L_0x00ba
            if (r15 == r7) goto L_0x008c
            r10 = 3
            if (r15 != r10) goto L_0x0086
            boolean r10 = component2(r33)     // Catch:{ all -> 0x006d }
            if (r10 == 0) goto L_0x0074
            com.appsflyer.AFLogger r20 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x006d }
            com.appsflyer.internal.AFg1cSDK r21 = com.appsflyer.internal.AFg1cSDK.META_REFERRER     // Catch:{ all -> 0x006d }
            java.lang.String r22 = "Found Facebook Lite content provider"
            r25 = 0
            r23 = 0
            r24 = 4
            com.appsflyer.internal.AFg1gSDK.d$default(r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x006d }
            java.lang.String r10 = r12.concat(r14)     // Catch:{ all -> 0x006d }
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ all -> 0x006d }
            goto L_0x00e8
        L_0x006d:
            r0 = move-exception
        L_0x006e:
            r20 = r0
            r11 = r16
            goto L_0x0248
        L_0x0074:
            com.appsflyer.AFLogger r20 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x006d }
            com.appsflyer.internal.AFg1cSDK r21 = com.appsflyer.internal.AFg1cSDK.META_REFERRER     // Catch:{ all -> 0x006d }
            java.lang.String r22 = "Facebook Lite content provider not found"
            r25 = 0
            r23 = 0
            r24 = 4
            com.appsflyer.internal.AFg1gSDK.d$default(r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x006d }
        L_0x0083:
            r10 = r16
            goto L_0x00e8
        L_0x0086:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x006d }
            r0.<init>()     // Catch:{ all -> 0x006d }
            throw r0     // Catch:{ all -> 0x006d }
        L_0x008c:
            boolean r10 = getMonetizationNetwork(r33)     // Catch:{ all -> 0x006d }
            if (r10 == 0) goto L_0x00aa
            com.appsflyer.AFLogger r20 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x006d }
            com.appsflyer.internal.AFg1cSDK r21 = com.appsflyer.internal.AFg1cSDK.META_REFERRER     // Catch:{ all -> 0x006d }
            java.lang.String r22 = "Found Instagram content provider"
            r25 = 0
            r23 = 0
            r24 = 4
            com.appsflyer.internal.AFg1gSDK.d$default(r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x006d }
            java.lang.String r10 = r11.concat(r14)     // Catch:{ all -> 0x006d }
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ all -> 0x006d }
            goto L_0x00e8
        L_0x00aa:
            com.appsflyer.AFLogger r20 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x006d }
            com.appsflyer.internal.AFg1cSDK r21 = com.appsflyer.internal.AFg1cSDK.META_REFERRER     // Catch:{ all -> 0x006d }
            java.lang.String r22 = "Instagram content provider not found"
            r25 = 0
            r23 = 0
            r24 = 4
            com.appsflyer.internal.AFg1gSDK.d$default(r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x006d }
            goto L_0x0083
        L_0x00ba:
            boolean r11 = getMediationNetwork(r33)     // Catch:{ all -> 0x006d }
            if (r11 == 0) goto L_0x00d8
            com.appsflyer.AFLogger r20 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x006d }
            com.appsflyer.internal.AFg1cSDK r21 = com.appsflyer.internal.AFg1cSDK.META_REFERRER     // Catch:{ all -> 0x006d }
            java.lang.String r22 = "Found Facebook content provider"
            r25 = 0
            r23 = 0
            r24 = 4
            com.appsflyer.internal.AFg1gSDK.d$default(r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x006d }
            java.lang.String r10 = r10.concat(r14)     // Catch:{ all -> 0x006d }
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ all -> 0x006d }
            goto L_0x00e8
        L_0x00d8:
            com.appsflyer.AFLogger r20 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x006d }
            com.appsflyer.internal.AFg1cSDK r21 = com.appsflyer.internal.AFg1cSDK.META_REFERRER     // Catch:{ all -> 0x006d }
            java.lang.String r22 = "Facebook content provider not found"
            r25 = 0
            r23 = 0
            r24 = 4
            com.appsflyer.internal.AFg1gSDK.d$default(r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x006d }
            goto L_0x0083
        L_0x00e8:
            if (r10 != 0) goto L_0x00ec
            goto L_0x0285
        L_0x00ec:
            android.content.ContentResolver r11 = r33.getContentResolver()     // Catch:{ all -> 0x006d }
            android.content.ContentProviderClient r11 = r11.acquireUnstableContentProviderClient(r10)     // Catch:{ all -> 0x006d }
            java.lang.String[] r28 = new java.lang.String[]{r5, r6, r4}     // Catch:{ all -> 0x0109 }
            if (r11 == 0) goto L_0x010e
            r31 = 0
            r29 = 0
            r30 = 0
            r26 = r11
            r27 = r10
            android.database.Cursor r10 = r26.query(r27, r28, r29, r30, r31)     // Catch:{ all -> 0x0109 }
            goto L_0x0110
        L_0x0109:
            r0 = move-exception
            r20 = r0
            goto L_0x0248
        L_0x010e:
            r10 = r16
        L_0x0110:
            if (r10 == 0) goto L_0x0226
            boolean r12 = r10.moveToFirst()     // Catch:{ all -> 0x0126 }
            if (r12 != 0) goto L_0x011a
            goto L_0x0226
        L_0x011a:
            int r5 = r10.getColumnIndex(r5)     // Catch:{ all -> 0x0126 }
            r12 = -1
            if (r5 == r12) goto L_0x012d
            java.lang.String r5 = r10.getString(r5)     // Catch:{ all -> 0x0126 }
            goto L_0x014d
        L_0x0126:
            r0 = move-exception
            r20 = r0
            r16 = r10
            goto L_0x0248
        L_0x012d:
            com.appsflyer.AFLogger r20 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0126 }
            com.appsflyer.internal.AFg1cSDK r21 = com.appsflyer.internal.AFg1cSDK.META_REFERRER     // Catch:{ all -> 0x0126 }
            com.appsflyer.internal.AFj1ySDK r5 = r1.getCurrencyIso4217Code     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r14.<init>(r9)     // Catch:{ all -> 0x0126 }
            r14.append(r5)     // Catch:{ all -> 0x0126 }
            r14.append(r3)     // Catch:{ all -> 0x0126 }
            java.lang.String r22 = r14.toString()     // Catch:{ all -> 0x0126 }
            r25 = 0
            r23 = 0
            r24 = 4
            com.appsflyer.internal.AFg1gSDK.d$default(r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0126 }
            r5 = r16
        L_0x014d:
            if (r5 == 0) goto L_0x0211
            com.appsflyer.AFLogger r20 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0126 }
            com.appsflyer.internal.AFg1cSDK r21 = com.appsflyer.internal.AFg1cSDK.META_REFERRER     // Catch:{ all -> 0x0126 }
            com.appsflyer.internal.AFj1ySDK r9 = r1.getCurrencyIso4217Code     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r14.<init>(r8)     // Catch:{ all -> 0x0126 }
            r14.append(r9)     // Catch:{ all -> 0x0126 }
            java.lang.String r8 = " attribution data."
            r14.append(r8)     // Catch:{ all -> 0x0126 }
            java.lang.String r22 = r14.toString()     // Catch:{ all -> 0x0126 }
            r25 = 0
            r23 = 0
            r24 = 4
            com.appsflyer.internal.AFg1gSDK.d$default(r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0126 }
            java.util.Map<java.lang.String, java.lang.Object> r8 = r1.AFAdRevenueData     // Catch:{ all -> 0x0126 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r13)     // Catch:{ all -> 0x0126 }
            java.lang.String r9 = "response"
            java.lang.String r14 = "OK"
            r8.put(r9, r14)     // Catch:{ all -> 0x0126 }
            java.util.Map<java.lang.String, java.lang.Object> r8 = r1.AFAdRevenueData     // Catch:{ all -> 0x0126 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r13)     // Catch:{ all -> 0x0126 }
            java.lang.String r9 = "referrer"
            r8.put(r9, r5)     // Catch:{ all -> 0x0126 }
            int r4 = r10.getColumnIndex(r4)     // Catch:{ all -> 0x0126 }
            if (r4 == r12) goto L_0x0194
            long r4 = r10.getLong(r4)     // Catch:{ all -> 0x0126 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0126 }
            goto L_0x0196
        L_0x0194:
            r4 = r16
        L_0x0196:
            if (r4 == 0) goto L_0x01a7
            long r4 = r4.longValue()     // Catch:{ all -> 0x0126 }
            java.util.Map<java.lang.String, java.lang.Object> r8 = r1.AFAdRevenueData     // Catch:{ all -> 0x0126 }
            java.lang.String r9 = "click_ts"
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0126 }
            r8.put(r9, r4)     // Catch:{ all -> 0x0126 }
        L_0x01a7:
            int r4 = r10.getColumnIndex(r6)     // Catch:{ all -> 0x0126 }
            if (r4 == r12) goto L_0x01b5
            int r4 = r10.getInt(r4)     // Catch:{ all -> 0x0126 }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0126 }
        L_0x01b5:
            if (r16 == 0) goto L_0x01d4
            int r4 = r16.intValue()     // Catch:{ all -> 0x0126 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0126 }
            kotlin.Pair r5 = new kotlin.Pair     // Catch:{ all -> 0x0126 }
            r5.<init>(r6, r4)     // Catch:{ all -> 0x0126 }
            kotlin.Pair[] r4 = new kotlin.Pair[r2]     // Catch:{ all -> 0x0126 }
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x0126 }
            java.util.LinkedHashMap r4 = kotlin.collections.MapsKt.f(r4)     // Catch:{ all -> 0x0126 }
            java.util.Map<java.lang.String, java.lang.Object> r5 = r1.AFAdRevenueData     // Catch:{ all -> 0x0126 }
            java.lang.String r6 = "meta_custom"
            r5.put(r6, r4)     // Catch:{ all -> 0x0126 }
        L_0x01d4:
            com.appsflyer.internal.AFj1ySDK r4 = r1.getCurrencyIso4217Code     // Catch:{ all -> 0x0126 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x0126 }
            r4 = r17[r4]     // Catch:{ all -> 0x0126 }
            if (r4 == r2) goto L_0x01ef
            if (r4 == r7) goto L_0x01ec
            r2 = 3
            if (r4 != r2) goto L_0x01e6
            java.lang.String r2 = "com.facebook.lite"
            goto L_0x01f1
        L_0x01e6:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0126 }
            r0.<init>()     // Catch:{ all -> 0x0126 }
            throw r0     // Catch:{ all -> 0x0126 }
        L_0x01ec:
            java.lang.String r2 = "com.instagram.android"
            goto L_0x01f1
        L_0x01ef:
            java.lang.String r2 = "com.facebook.katana"
        L_0x01f1:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r1.AFAdRevenueData     // Catch:{ all -> 0x0126 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r13)     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = "api_ver"
            long r6 = com.appsflyer.internal.AFj1iSDK.AFAdRevenueData(r0, r2)     // Catch:{ all -> 0x0126 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0126 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0126 }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r1.AFAdRevenueData     // Catch:{ all -> 0x0126 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r13)     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = "api_ver_name"
            java.lang.String r0 = com.appsflyer.internal.AFj1iSDK.getMediationNetwork(r0, r2)     // Catch:{ all -> 0x0126 }
            r4.put(r5, r0)     // Catch:{ all -> 0x0126 }
        L_0x0211:
            r10.close()
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r0 < r2) goto L_0x0220
            if (r11 == 0) goto L_0x0285
        L_0x021c:
            r11.release()
            goto L_0x0285
        L_0x0220:
            if (r11 == 0) goto L_0x0285
        L_0x0222:
            r11.release()
            goto L_0x0285
        L_0x0226:
            com.appsflyer.AFLogger r4 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0126 }
            com.appsflyer.internal.AFg1cSDK r5 = com.appsflyer.internal.AFg1cSDK.META_REFERRER     // Catch:{ all -> 0x0126 }
            java.lang.String r6 = "Content provider returned no data"
            r9 = 0
            r7 = 0
            r8 = 4
            com.appsflyer.internal.AFg1gSDK.d$default(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0126 }
            if (r10 == 0) goto L_0x0237
            r10.close()
        L_0x0237:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r0 < r2) goto L_0x0240
            if (r11 == 0) goto L_0x0285
            goto L_0x021c
        L_0x0240:
            if (r11 == 0) goto L_0x0285
            goto L_0x0222
        L_0x0243:
            r0 = move-exception
            r18 = r7
            goto L_0x006e
        L_0x0248:
            com.appsflyer.AFLogger r17 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x028e }
            com.appsflyer.internal.AFg1cSDK r0 = com.appsflyer.internal.AFg1cSDK.META_REFERRER     // Catch:{ all -> 0x028e }
            com.appsflyer.internal.AFj1ySDK r2 = r1.getCurrencyIso4217Code     // Catch:{ all -> 0x028e }
            java.lang.String r2 = r2.name()     // Catch:{ all -> 0x028e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x028e }
            r5 = r18
            r4.<init>(r5)     // Catch:{ all -> 0x028e }
            r4.append(r2)     // Catch:{ all -> 0x028e }
            r4.append(r3)     // Catch:{ all -> 0x028e }
            java.lang.String r19 = r4.toString()     // Catch:{ all -> 0x028e }
            r23 = 0
            r24 = 0
            r25 = 120(0x78, float:1.68E-43)
            r26 = 0
            r21 = 0
            r22 = 0
            r18 = r0
            com.appsflyer.internal.AFg1gSDK.e$default(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x028e }
            if (r16 == 0) goto L_0x0279
            r16.close()
        L_0x0279:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r0 < r2) goto L_0x0282
            if (r11 == 0) goto L_0x0285
            goto L_0x021c
        L_0x0282:
            if (r11 == 0) goto L_0x0285
            goto L_0x0222
        L_0x0285:
            r32.getMediationNetwork()
            java.lang.Runnable r0 = r1.component3
            r0.run()
            return
        L_0x028e:
            r0 = move-exception
            if (r16 == 0) goto L_0x0294
            r16.close()
        L_0x0294:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L_0x02a0
            if (r11 == 0) goto L_0x02a5
            r11.release()
            goto L_0x02a5
        L_0x02a0:
            if (r11 == 0) goto L_0x02a5
            r11.release()
        L_0x02a5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1zSDK.getMonetizationNetwork(com.appsflyer.internal.AFj1zSDK, android.content.Context):void");
    }
}
