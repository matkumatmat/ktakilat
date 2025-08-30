package com.appsflyer.internal;

import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

public final class AFe1lSDK {
    public final List<AFe1qSDK> AFAdRevenueData = new CopyOnWriteArrayList();
    final List<AFe1sSDK<?>> areAllFieldsValid = new ArrayList();
    final Set<AFe1sSDK<?>> component1 = Collections.newSetFromMap(new ConcurrentHashMap());
    final NavigableSet<AFe1sSDK<?>> component2 = new ConcurrentSkipListSet();
    final Set<AFe1mSDK> component3 = Collections.newSetFromMap(new ConcurrentHashMap());
    final NavigableSet<AFe1sSDK<?>> component4 = new ConcurrentSkipListSet();
    final Timer getCurrencyIso4217Code = new Timer(true);
    final ExecutorService getMediationNetwork;
    final Set<AFe1mSDK> getMonetizationNetwork = new CopyOnWriteArraySet();
    public Executor getRevenue;

    public AFe1lSDK(ExecutorService executorService) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "");
        this.getRevenue = newSingleThreadExecutor;
        this.getMediationNetwork = executorService;
    }

    public final boolean AFAdRevenueData(AFe1sSDK<?> aFe1sSDK) {
        return this.getMonetizationNetwork.containsAll(aFe1sSDK.getCurrencyIso4217Code);
    }

    public final void getCurrencyIso4217Code() {
        synchronized (this.component2) {
            try {
                Iterator<AFe1sSDK<?>> it = this.component4.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    AFe1sSDK next = it.next();
                    if (AFAdRevenueData(next)) {
                        it.remove();
                        this.component2.add(next);
                        z = true;
                    }
                }
                if (z) {
                    this.getMediationNetwork.submit(new Runnable() {
                        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
                            r2 = r1.getMonetizationNetwork();
                            r0 = new com.appsflyer.internal.AFe1pSDK(java.lang.Thread.currentThread());
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
                            if (r2 <= 0) goto L_0x0038;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
                            r7.getRevenue.getCurrencyIso4217Code.schedule(r0, r2);
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
                            r2 = r7.getRevenue;
                            r2.getRevenue.execute(new com.appsflyer.internal.AFe1lSDK.AnonymousClass1(r2, r1));
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
                            if (r7.getRevenue.component2.isEmpty() != false) goto L_0x005a;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
                            r2 = r7.getRevenue;
                            r2.getMediationNetwork.submit(new com.appsflyer.internal.AFe1lSDK.AnonymousClass4(r2));
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                            com.appsflyer.AFLogger.INSTANCE.d(com.appsflyer.internal.AFg1cSDK.QUEUE, "starting task execution: ".concat(java.lang.String.valueOf(r1)));
                            r2 = r1.component2();
                            r0.cancel();
                            r3 = r7.getRevenue;
                            r3.getRevenue.execute(new com.appsflyer.internal.AFe1lSDK.AnonymousClass3(r3, r1, r2));
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:19:0x007e, code lost:
                            return;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007f, code lost:
                            r0.cancel();
                            r0 = r7.getRevenue;
                            r0.getRevenue.execute(new com.appsflyer.internal.AFe1lSDK.AnonymousClass3(r0, r1, com.appsflyer.internal.AFe1rSDK.getMediationNetwork));
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
                            return;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
                            com.appsflyer.AFLogger.INSTANCE.d(com.appsflyer.internal.AFg1cSDK.QUEUE, "task was interrupted: ".concat(java.lang.String.valueOf(r1)));
                            r0 = com.appsflyer.internal.AFe1rSDK.getRevenue;
                            r1.getMediationNetwork = r0;
                            r2 = r7.getRevenue;
                            r2.getRevenue.execute(new com.appsflyer.internal.AFe1lSDK.AnonymousClass3(r2, r1, r0));
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b2, code lost:
                            return;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                                r7 = this;
                                com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                                java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r0 = r0.component2
                                monitor-enter(r0)
                                com.appsflyer.internal.AFe1lSDK r1 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x0013 }
                                java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r1 = r1.component2     // Catch:{ all -> 0x0013 }
                                java.lang.Object r1 = r1.pollFirst()     // Catch:{ all -> 0x0013 }
                                com.appsflyer.internal.AFe1sSDK r1 = (com.appsflyer.internal.AFe1sSDK) r1     // Catch:{ all -> 0x0013 }
                                if (r1 != 0) goto L_0x0016
                                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                                return
                            L_0x0013:
                                r1 = move-exception
                                goto L_0x00b3
                            L_0x0016:
                                com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ all -> 0x0013 }
                                java.util.Set<com.appsflyer.internal.AFe1sSDK<?>> r2 = r2.component1     // Catch:{ all -> 0x0013 }
                                r2.add(r1)     // Catch:{ all -> 0x0013 }
                                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                                long r2 = r1.getMonetizationNetwork()
                                com.appsflyer.internal.AFe1pSDK r0 = new com.appsflyer.internal.AFe1pSDK
                                java.lang.Thread r4 = java.lang.Thread.currentThread()
                                r0.<init>(r4)
                                r4 = 0
                                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                                if (r6 <= 0) goto L_0x0038
                                com.appsflyer.internal.AFe1lSDK r4 = com.appsflyer.internal.AFe1lSDK.this
                                java.util.Timer r4 = r4.getCurrencyIso4217Code
                                r4.schedule(r0, r2)
                            L_0x0038:
                                com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this
                                java.util.concurrent.Executor r3 = r2.getRevenue
                                com.appsflyer.internal.AFe1lSDK$1 r4 = new com.appsflyer.internal.AFe1lSDK$1
                                r4.<init>(r1)
                                r3.execute(r4)
                                com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this
                                java.util.NavigableSet<com.appsflyer.internal.AFe1sSDK<?>> r2 = r2.component2
                                boolean r2 = r2.isEmpty()
                                if (r2 != 0) goto L_0x005a
                                com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this
                                java.util.concurrent.ExecutorService r3 = r2.getMediationNetwork
                                com.appsflyer.internal.AFe1lSDK$4 r4 = new com.appsflyer.internal.AFe1lSDK$4
                                r4.<init>()
                                r3.submit(r4)
                            L_0x005a:
                                com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.QUEUE     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                java.lang.String r4 = "starting task execution: "
                                java.lang.String r5 = java.lang.String.valueOf(r1)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                java.lang.String r4 = r4.concat(r5)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                r2.d(r3, r4)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                com.appsflyer.internal.AFe1rSDK r2 = r1.call()     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                r0.cancel()     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                com.appsflyer.internal.AFe1lSDK r3 = com.appsflyer.internal.AFe1lSDK.this     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                java.util.concurrent.Executor r4 = r3.getRevenue     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                com.appsflyer.internal.AFe1lSDK$3 r5 = new com.appsflyer.internal.AFe1lSDK$3     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                r5.<init>(r1, r2)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                r4.execute(r5)     // Catch:{ InterruptedIOException | InterruptedException -> 0x0091, all -> 0x007f }
                                return
                            L_0x007f:
                                r0.cancel()
                                com.appsflyer.internal.AFe1lSDK r0 = com.appsflyer.internal.AFe1lSDK.this
                                com.appsflyer.internal.AFe1rSDK r2 = com.appsflyer.internal.AFe1rSDK.FAILURE
                                java.util.concurrent.Executor r3 = r0.getRevenue
                                com.appsflyer.internal.AFe1lSDK$3 r4 = new com.appsflyer.internal.AFe1lSDK$3
                                r4.<init>(r1, r2)
                                r3.execute(r4)
                                return
                            L_0x0091:
                                com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
                                com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.QUEUE
                                java.lang.String r3 = "task was interrupted: "
                                java.lang.String r4 = java.lang.String.valueOf(r1)
                                java.lang.String r3 = r3.concat(r4)
                                r0.d(r2, r3)
                                com.appsflyer.internal.AFe1rSDK r0 = com.appsflyer.internal.AFe1rSDK.TIMEOUT
                                r1.getMediationNetwork = r0
                                com.appsflyer.internal.AFe1lSDK r2 = com.appsflyer.internal.AFe1lSDK.this
                                java.util.concurrent.Executor r3 = r2.getRevenue
                                com.appsflyer.internal.AFe1lSDK$3 r4 = new com.appsflyer.internal.AFe1lSDK$3
                                r4.<init>(r1, r0)
                                r3.execute(r4)
                                return
                            L_0x00b3:
                                monitor-exit(r0)
                                throw r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1lSDK.AnonymousClass4.run():void");
                        }
                    });
                }
            } finally {
            }
        }
    }

    public final void getMediationNetwork(NavigableSet<AFe1sSDK<?>> navigableSet) {
        AFe1sSDK pollFirst = navigableSet.pollFirst();
        this.getMonetizationNetwork.add(pollFirst.getMonetizationNetwork);
        for (AFe1qSDK mediationNetwork : this.AFAdRevenueData) {
            mediationNetwork.getMediationNetwork(pollFirst);
        }
    }

    @VisibleForTesting
    public static boolean getCurrencyIso4217Code(AFe1sSDK<?> aFe1sSDK) {
        return !(aFe1sSDK instanceof AFf1vSDK) || aFe1sSDK.getMonetizationNetwork != AFe1mSDK.ARS_VALIDATE;
    }
}
