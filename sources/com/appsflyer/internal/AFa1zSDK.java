package com.appsflyer.internal;

import com.appsflyer.AppsFlyerProperties;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\r"}, d2 = {"Lcom/appsflyer/internal/AFa1zSDK;", "", "<init>", "()V", "Lcom/appsflyer/internal/AFc1iSDK;", "p0", "Lcom/appsflyer/internal/AFc1pSDK;", "p1", "", "AFAdRevenueData", "(Lcom/appsflyer/internal/AFc1iSDK;Lcom/appsflyer/internal/AFc1pSDK;)V", "", "getCurrencyIso4217Code", "()Ljava/lang/String;", "getRevenue"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFa1zSDK {
    @NotNull
    public static final AFa1zSDK INSTANCE = new AFa1zSDK();

    private AFa1zSDK() {
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    @kotlin.jvm.JvmStatic
    public static final void AFAdRevenueData(@org.jetbrains.annotations.NotNull com.appsflyer.internal.AFc1iSDK r5, @org.jetbrains.annotations.NotNull com.appsflyer.internal.AFc1pSDK r6) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r1 = com.appsflyer.internal.AFj1iSDK.getMediationNetwork()
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = "OPPO device found"
            com.appsflyer.AFLogger.afRDLog(r1)
            r1 = 23
            goto L_0x001e
        L_0x001c:
            r1 = 18
        L_0x001e:
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r1) goto L_0x00c5
            java.lang.String r1 = "keyPropDisableAFKeystore"
            r3 = 1
            boolean r1 = r0.getBoolean(r1, r3)
            if (r1 != 0) goto L_0x00c5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "OS SDK is="
            r1.<init>(r4)
            r1.append(r2)
            java.lang.String r2 = "; use KeyStore"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.afRDLog(r1)
            com.appsflyer.AFKeystoreWrapper r1 = new com.appsflyer.AFKeystoreWrapper
            android.content.Context r5 = r5.getMonetizationNetwork
            r1.<init>(r5)
            boolean r5 = r1.getRevenue()
            if (r5 != 0) goto L_0x0061
            com.appsflyer.internal.AFc1qSDK r5 = r6.getMonetizationNetwork
            java.lang.String r5 = com.appsflyer.internal.AFb1iSDK.getRevenue(r5)
            r1.getRevenue = r5
            r5 = 0
            r1.AFAdRevenueData = r5
            java.lang.String r5 = r1.getMediationNetwork()
            r1.getRevenue(r5)
            goto L_0x00ac
        L_0x0061:
            java.lang.String r5 = r1.getMediationNetwork()
            java.lang.Object r6 = r1.getMonetizationNetwork
            monitor-enter(r6)
            int r2 = r1.AFAdRevenueData     // Catch:{ all -> 0x0087 }
            int r2 = r2 + r3
            r1.AFAdRevenueData = r2     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "Deleting key with alias: "
            java.lang.String r3 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x0087 }
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ all -> 0x0087 }
            java.lang.Object r2 = r1.getMonetizationNetwork     // Catch:{ KeyStoreException -> 0x0089 }
            monitor-enter(r2)     // Catch:{ KeyStoreException -> 0x0089 }
            java.security.KeyStore r3 = r1.getCurrencyIso4217Code     // Catch:{ all -> 0x0084 }
            r3.deleteEntry(r5)     // Catch:{ all -> 0x0084 }
            monitor-exit(r2)     // Catch:{ all -> 0x0084 }
            goto L_0x00a4
        L_0x0084:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ KeyStoreException -> 0x0089 }
            throw r5     // Catch:{ KeyStoreException -> 0x0089 }
        L_0x0087:
            r5 = move-exception
            goto L_0x00c3
        L_0x0089:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "Exception "
            r2.<init>(r3)     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = r5.getMessage()     // Catch:{ all -> 0x0087 }
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = " occurred"
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0087 }
            com.appsflyer.AFLogger.afErrorLog(r2, r5)     // Catch:{ all -> 0x0087 }
        L_0x00a4:
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            java.lang.String r5 = r1.getMediationNetwork()
            r1.getRevenue(r5)
        L_0x00ac:
            java.lang.String r5 = "KSAppsFlyerId"
            java.lang.String r6 = r1.getMonetizationNetwork()
            r0.set((java.lang.String) r5, (java.lang.String) r6)
            java.lang.String r5 = "KSAppsFlyerRICounter"
            int r6 = r1.AFAdRevenueData()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r0.set((java.lang.String) r5, (java.lang.String) r6)
            return
        L_0x00c3:
            monitor-exit(r6)
            throw r5
        L_0x00c5:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "OS SDK is="
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r6 = "; no KeyStore usage"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.appsflyer.AFLogger.afRDLog(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1zSDK.AFAdRevenueData(com.appsflyer.internal.AFc1iSDK, com.appsflyer.internal.AFc1pSDK):void");
    }

    @Nullable
    public static String getCurrencyIso4217Code() {
        return AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
    }

    @Nullable
    public static String getRevenue() {
        return AppsFlyerProperties.getInstance().getString("KSAppsFlyerRICounter");
    }
}
