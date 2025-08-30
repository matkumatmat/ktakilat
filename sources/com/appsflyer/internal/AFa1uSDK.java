package com.appsflyer.internal;

import com.appsflyer.internal.AFe1tSDK;
import com.appsflyer.internal.AFe1uSDK;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFa1uSDK implements Runnable {
    @Nullable
    private final Map<String, Object> getMediationNetwork;
    @NotNull
    private final AFc1dSDK getMonetizationNetwork;
    @NotNull
    private final AFh1rSDK getRevenue;

    public AFa1uSDK(@NotNull AFc1dSDK aFc1dSDK, @NotNull AFh1rSDK aFh1rSDK, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        this.getMonetizationNetwork = aFc1dSDK;
        this.getRevenue = aFh1rSDK;
        this.getMediationNetwork = map;
    }

    public final void run() {
        AFf1uSDK aFf1uSDK;
        if (this.getRevenue.getMediationNetwork()) {
            AFf1uSDK aFf1uSDK2 = new AFf1uSDK(this.getRevenue, this.getMonetizationNetwork);
            aFf1uSDK2.copydefault = this.getMediationNetwork;
            aFf1uSDK = aFf1uSDK2;
        } else if (this.getRevenue instanceof AFh1lSDK) {
            aFf1uSDK = new AFf1sSDK((AFh1lSDK) this.getRevenue, this.getMonetizationNetwork);
        } else {
            aFf1uSDK = new AFf1rSDK(this.getRevenue, this.getMonetizationNetwork);
        }
        AFe1lSDK copydefault = this.getMonetizationNetwork.copydefault();
        copydefault.getRevenue.execute(new Runnable(aFf1uSDK) {
            private /* synthetic */ AFe1sSDK getMonetizationNetwork;

            {
                this.getMonetizationNetwork = r2;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r0 = r0.component2
                    monitor-enter(r0)
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.Set<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component1     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x002d
                    com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                    java.lang.String r4 = "tried to add already running task: "
                    r3.<init>(r4)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r4 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    r3.append(r4)     // Catch:{ all -> 0x002a }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002a }
                    r1.d(r2, r3)     // Catch:{ all -> 0x002a }
                    monitor-exit(r0)     // Catch:{ all -> 0x002a }
                    return
                L_0x002a:
                    r1 = move-exception
                    goto L_0x01a9
                L_0x002d:
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component2     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                    if (r1 != 0) goto L_0x0190
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component4     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x0047
                    goto L_0x0190
                L_0x0047:
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    java.util.Set<com.appsflyer.internal.AFe1mSDK> r3 = r2.AFAdRevenueData     // Catch:{ all -> 0x002a }
                    java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x002a }
                L_0x0051:
                    boolean r4 = r3.hasNext()     // Catch:{ all -> 0x002a }
                    if (r4 == 0) goto L_0x006b
                    java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1mSDK r4 = (com.appsflyer.internal.AFe1mSDK) r4     // Catch:{ all -> 0x002a }
                    java.util.Set<com.appsflyer.internal.AFe1mSDK> r5 = r1.component3     // Catch:{ all -> 0x002a }
                    boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x002a }
                    if (r5 == 0) goto L_0x0051
                    java.util.Set<com.appsflyer.internal.AFe1mSDK> r5 = r2.getCurrencyIso4217Code     // Catch:{ all -> 0x002a }
                    r5.add(r4)     // Catch:{ all -> 0x002a }
                    goto L_0x0051
                L_0x006b:
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.AFAdRevenueData(r2)     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x0080
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component2     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.add(r2)     // Catch:{ all -> 0x002a }
                    goto L_0x00a8
                L_0x0080:
                    com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component4     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    boolean r1 = r1.add(r2)     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x00a8
                    com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                    java.lang.String r5 = "new task was blocked: "
                    r4.<init>(r5)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r5 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    r4.append(r5)     // Catch:{ all -> 0x002a }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002a }
                    r2.d(r3, r4)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r2 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    r2.AFAdRevenueData()     // Catch:{ all -> 0x002a }
                L_0x00a8:
                    if (r1 == 0) goto L_0x00bb
                    com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r2.component2     // Catch:{ all -> 0x002a }
                    java.util.List<com.appsflyer.internal.AFe1sSDK<?>> r2 = r2.areAllFieldsValid     // Catch:{ all -> 0x002a }
                    r3.addAll(r2)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x002a }
                    java.util.List<com.appsflyer.internal.AFe1sSDK<?>> r2 = r2.areAllFieldsValid     // Catch:{ all -> 0x002a }
                    r2.clear()     // Catch:{ all -> 0x002a }
                    goto L_0x00d2
                L_0x00bb:
                    com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                    java.lang.String r5 = "task not added, it's already in the queue: "
                    r4.<init>(r5)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r5 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    r4.append(r5)     // Catch:{ all -> 0x002a }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x002a }
                    r2.d(r3, r4)     // Catch:{ all -> 0x002a }
                L_0x00d2:
                    monitor-exit(r0)     // Catch:{ all -> 0x002a }
                    if (r1 == 0) goto L_0x0178
                    com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                    java.util.Set<com.appsflyer.internal.AFe1mSDK> r0 = r0.component3
                    com.appsflyer.internal.AFe1sSDK r1 = r6.getMonetizationNetwork
                    com.appsflyer.internal.AFe1mSDK r1 = r1.getMonetizationNetwork
                    r0.add(r1)
                    com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
                    com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.QUEUE
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    java.lang.String r3 = "new task added: "
                    r2.<init>(r3)
                    com.appsflyer.internal.AFe1sSDK r3 = r6.getMonetizationNetwork
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r0.d(r1, r2)
                    com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                    java.util.List<com.appsflyer.internal.AFe1qSDK> r0 = r0.AFAdRevenueData
                    java.util.Iterator r0 = r0.iterator()
                L_0x00ff:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L_0x010c
                    java.lang.Object r1 = r0.next()
                    com.appsflyer.internal.AFe1qSDK r1 = (com.appsflyer.internal.AFe1qSDK) r1
                    goto L_0x00ff
                L_0x010c:
                    com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                    java.util.concurrent.ExecutorService r1 = r0.getMediationNetwork
                    com.appsflyer.internal.AFe1lSDK$4 r2 = new com.appsflyer.internal.AFe1lSDK$4
                    r2.<init>()
                    r1.submit(r2)
                    com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r0.component2
                    monitor-enter(r1)
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r2 = r0.component2     // Catch:{ all -> 0x015a }
                    int r2 = r2.size()     // Catch:{ all -> 0x015a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                    int r3 = r3.size()     // Catch:{ all -> 0x015a }
                    int r2 = r2 + r3
                    int r2 = r2 + -40
                L_0x012c:
                    if (r2 <= 0) goto L_0x0174
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                    boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x015a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r4 = r0.component2     // Catch:{ all -> 0x015a }
                    boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x015a }
                    if (r4 != 0) goto L_0x0162
                    if (r3 != 0) goto L_0x0162
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                    java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x015a }
                    com.appsflyer.internal.AFe1sSDK r3 = (com.appsflyer.internal.AFe1sSDK) r3     // Catch:{ all -> 0x015a }
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r4 = r0.component4     // Catch:{ all -> 0x015a }
                    java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x015a }
                    com.appsflyer.internal.AFe1sSDK r4 = (com.appsflyer.internal.AFe1sSDK) r4     // Catch:{ all -> 0x015a }
                    int r3 = r3.getCurrencyIso4217Code((com.appsflyer.internal.AFe1sSDK<?>) r4)     // Catch:{ all -> 0x015a }
                    if (r3 <= 0) goto L_0x015c
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                    r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                    goto L_0x0171
                L_0x015a:
                    r0 = move-exception
                    goto L_0x0176
                L_0x015c:
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                    r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                    goto L_0x0171
                L_0x0162:
                    if (r4 != 0) goto L_0x016a
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component2     // Catch:{ all -> 0x015a }
                    r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                    goto L_0x0171
                L_0x016a:
                    if (r3 != 0) goto L_0x0171
                    java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r3 = r0.component4     // Catch:{ all -> 0x015a }
                    r0.getMediationNetwork(r3)     // Catch:{ all -> 0x015a }
                L_0x0171:
                    int r2 = r2 + -1
                    goto L_0x012c
                L_0x0174:
                    monitor-exit(r1)     // Catch:{ all -> 0x015a }
                    return
                L_0x0176:
                    monitor-exit(r1)
                    throw r0
                L_0x0178:
                    com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
                    com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.QUEUE
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    java.lang.String r3 = "QUEUE: tried to add already pending task: "
                    r2.<init>(r3)
                    com.appsflyer.internal.AFe1sSDK r3 = r6.getMonetizationNetwork
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r0.w(r1, r2)
                    return
                L_0x0190:
                    com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ all -> 0x002a }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                    java.lang.String r4 = "tried to add already scheduled task: "
                    r3.<init>(r4)     // Catch:{ all -> 0x002a }
                    com.appsflyer.internal.AFe1sSDK r4 = r6.getMonetizationNetwork     // Catch:{ all -> 0x002a }
                    r3.append(r4)     // Catch:{ all -> 0x002a }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x002a }
                    r1.d(r2, r3)     // Catch:{ all -> 0x002a }
                    monitor-exit(r0)     // Catch:{ all -> 0x002a }
                    return
                L_0x01a9:
                    monitor-exit(r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1lSDK.AnonymousClass5.run():void");
            }
        });
        this.getMonetizationNetwork.AFKeystoreWrapper();
        if (AFe1zSDK.AFAdRevenueData()) {
            AFe1uSDK mediationNetwork = this.getMonetizationNetwork.getMediationNetwork();
            AFh1rSDK aFh1rSDK = this.getRevenue;
            Intrinsics.checkNotNullParameter(aFh1rSDK, "");
            if (AFj1iSDK.getRevenue(mediationNetwork.getRevenue.getMonetizationNetwork)) {
                AFe1tSDK.AFa1zSDK aFa1zSDK = AFe1tSDK.AFa1zSDK;
                AFe1tSDK revenue = AFe1tSDK.AFa1zSDK.getRevenue(aFh1rSDK);
                if (revenue != null) {
                    mediationNetwork.getMediationNetwork(revenue, AFe1uSDK.AnonymousClass3.getRevenue);
                }
            }
        }
    }
}
