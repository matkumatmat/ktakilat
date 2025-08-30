package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1cSDK;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nExceptionManageCacheImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionManageCacheImpl.kt\ncom/appsflyer/internal/components/monitorsdk/exmanager/ExceptionManageCacheImpl\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,130:1\n11653#2,9:131\n13579#2:140\n11653#2,9:141\n13579#2:150\n13580#2:152\n11662#2:153\n13580#2:155\n11662#2:156\n4117#2:158\n4217#2,2:159\n4117#2:165\n4217#2,2:166\n1#3:151\n1#3:154\n1#3:157\n1549#4:161\n1620#4,3:162\n1549#4:168\n1620#4,3:169\n*S KotlinDebug\n*F\n+ 1 ExceptionManageCacheImpl.kt\ncom/appsflyer/internal/components/monitorsdk/exmanager/ExceptionManageCacheImpl\n*L\n69#1:131,9\n69#1:140\n71#1:141,9\n71#1:150\n71#1:152\n71#1:153\n69#1:155\n69#1:156\n101#1:158\n101#1:159,2\n119#1:165\n119#1:166,2\n71#1:151\n69#1:154\n101#1:161\n101#1:162,3\n120#1:168\n120#1:169,3\n*E\n"})
@WorkerThread
public final class AFc1bSDK implements AFc1aSDK {
    @NotNull
    private final AFc1iSDK AFAdRevenueData;

    public AFc1bSDK(@NotNull AFc1iSDK aFc1iSDK) {
        Intrinsics.checkNotNullParameter(aFc1iSDK, "");
        this.AFAdRevenueData = aFc1iSDK;
    }

    private final File getRevenue() {
        Context context = this.AFAdRevenueData.getMonetizationNetwork;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "AFExceptionsCache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Nullable
    public final String AFAdRevenueData(@NotNull Throwable th, @NotNull String str) {
        String str2;
        File file;
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        synchronized (this) {
            File revenue = getRevenue();
            str2 = null;
            if (revenue != null) {
                file = new File(revenue, "6.17.0");
                if (!file.exists()) {
                    file.mkdirs();
                }
            } else {
                file = null;
            }
            if (file != null) {
                try {
                    AFc1cSDK currencyIso4217Code = AFd1qSDK.getCurrencyIso4217Code(th, str);
                    String str3 = currencyIso4217Code.getMonetizationNetwork;
                    File file2 = new File(file, str3);
                    if (file2.exists()) {
                        AFc1cSDK.AFa1ySDK aFa1ySDK = AFc1cSDK.AFa1ySDK;
                        AFc1cSDK revenue2 = AFc1cSDK.AFa1ySDK.getRevenue(FilesKt.c(file2));
                        if (revenue2 != null) {
                            revenue2.getMediationNetwork++;
                            currencyIso4217Code = revenue2;
                        }
                    }
                    FilesKt.d(file2, currencyIso4217Code.AFAdRevenueData());
                    str2 = str3;
                } catch (Exception e) {
                    AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "Could not cache exception\n " + e.getMessage(), false, 4, (Object) null);
                }
            }
        }
        return str2;
    }

    public final int getCurrencyIso4217Code() {
        int i = 0;
        for (AFc1cSDK aFc1cSDK : getMediationNetwork()) {
            i += aFc1cSDK.getMediationNetwork;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c A[Catch:{ all -> 0x0045, all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0072 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.appsflyer.internal.AFc1cSDK> getMediationNetwork() {
        /*
            r13 = this;
            monitor-enter(r13)
            java.io.File r0 = r13.getRevenue()     // Catch:{ all -> 0x0070 }
            r1 = 0
            if (r0 == 0) goto L_0x0093
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x0093
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0070 }
            r2.<init>()     // Catch:{ all -> 0x0070 }
            int r3 = r0.length     // Catch:{ all -> 0x0070 }
            r4 = 0
            r5 = 0
        L_0x0016:
            if (r5 >= r3) goto L_0x0075
            r6 = r0[r5]     // Catch:{ all -> 0x0070 }
            java.io.File[] r6 = r6.listFiles()     // Catch:{ all -> 0x0045 }
            if (r6 == 0) goto L_0x0069
            java.lang.String r7 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ all -> 0x0045 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0045 }
            r7.<init>()     // Catch:{ all -> 0x0045 }
            int r8 = r6.length     // Catch:{ all -> 0x0045 }
            r9 = 0
        L_0x002c:
            if (r9 >= r8) goto L_0x006a
            r10 = r6[r9]     // Catch:{ all -> 0x0045 }
            com.appsflyer.internal.AFc1cSDK$AFa1ySDK r11 = com.appsflyer.internal.AFc1cSDK.AFa1ySDK     // Catch:{ all -> 0x0045 }
            java.lang.String r11 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)     // Catch:{ all -> 0x0045 }
            java.lang.String r10 = kotlin.io.FilesKt.c(r10)     // Catch:{ all -> 0x0045 }
            com.appsflyer.internal.AFc1cSDK r10 = com.appsflyer.internal.AFc1cSDK.AFa1ySDK.getRevenue(r10)     // Catch:{ all -> 0x0045 }
            if (r10 == 0) goto L_0x0047
            r7.add(r10)     // Catch:{ all -> 0x0045 }
            goto L_0x0047
        L_0x0045:
            r6 = move-exception
            goto L_0x004a
        L_0x0047:
            int r9 = r9 + 1
            goto L_0x002c
        L_0x004a:
            com.appsflyer.AFLogger r7 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0070 }
            com.appsflyer.internal.AFg1cSDK r8 = com.appsflyer.internal.AFg1cSDK.EXCEPTION_MANAGER     // Catch:{ all -> 0x0070 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0070 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r9.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r10 = "Could not get stored exceptions\n "
            r9.append(r10)     // Catch:{ all -> 0x0070 }
            r9.append(r6)     // Catch:{ all -> 0x0070 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0070 }
            r12 = 0
            r10 = 0
            r11 = 4
            com.appsflyer.internal.AFg1gSDK.v$default(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0070 }
        L_0x0069:
            r7 = r1
        L_0x006a:
            if (r7 == 0) goto L_0x0072
            r2.add(r7)     // Catch:{ all -> 0x0070 }
            goto L_0x0072
        L_0x0070:
            r0 = move-exception
            goto L_0x0099
        L_0x0072:
            int r5 = r5 + 1
            goto L_0x0016
        L_0x0075:
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)     // Catch:{ all -> 0x0070 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0070 }
            r1.<init>()     // Catch:{ all -> 0x0070 }
            java.util.Iterator r0 = r2.iterator()     // Catch:{ all -> 0x0070 }
        L_0x0083:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x0093
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0070 }
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ all -> 0x0070 }
            kotlin.collections.CollectionsKt.f(r1, r2)     // Catch:{ all -> 0x0070 }
            goto L_0x0083
        L_0x0093:
            if (r1 != 0) goto L_0x0097
            kotlin.collections.EmptyList r1 = kotlin.collections.EmptyList.INSTANCE     // Catch:{ all -> 0x0070 }
        L_0x0097:
            monitor-exit(r13)
            return r1
        L_0x0099:
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1bSDK.getMediationNetwork():java.util.List");
    }

    public final boolean getMonetizationNetwork() {
        return getRevenue(new String[0]);
    }

    public final boolean getRevenue(@NotNull String... strArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(strArr, "");
        synchronized (this) {
            try {
                File revenue = getRevenue();
                z = true;
                if (revenue != null) {
                    if (strArr.length == 0) {
                        AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "delete all exceptions", false, 4, (Object) null);
                        z = FilesKt.b(revenue);
                    } else {
                        AFg1gSDK.v$default(AFLogger.INSTANCE, AFg1cSDK.EXCEPTION_MANAGER, "delete all exceptions except for: " + ArraysKt.v(strArr), false, 4, (Object) null);
                        File[] listFiles = revenue.listFiles();
                        if (listFiles != null) {
                            Intrinsics.checkNotNullExpressionValue(listFiles, "");
                            ArrayList arrayList = new ArrayList();
                            for (File file : listFiles) {
                                if (!ArraysKt.h(strArr, file.getName())) {
                                    arrayList.add(file);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.h(arrayList));
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                File file2 = (File) it.next();
                                Intrinsics.checkNotNullExpressionValue(file2, "");
                                arrayList2.add(Boolean.valueOf(FilesKt.b(file2)));
                            }
                            Set G = CollectionsKt.G(arrayList2);
                            if (G.isEmpty()) {
                                G = Collections.singleton(Boolean.TRUE);
                                Intrinsics.checkNotNullExpressionValue(G, "singleton(...)");
                            }
                            if (G.size() != 1 || !((Boolean) CollectionsKt.l(G)).booleanValue()) {
                                z = false;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final void AFAdRevenueData(int i, int i2) {
        File[] listFiles;
        synchronized (this) {
            try {
                File revenue = getRevenue();
                if (!(revenue == null || (listFiles = revenue.listFiles()) == null)) {
                    Intrinsics.checkNotNullExpressionValue(listFiles, "");
                    ArrayList arrayList = new ArrayList();
                    for (File file : listFiles) {
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "");
                        int monetizationNetwork = AFj1aSDK.getMonetizationNetwork(name);
                        if (i > monetizationNetwork || monetizationNetwork > i2) {
                            arrayList.add(file);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.h(arrayList));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        File file2 = (File) it.next();
                        Intrinsics.checkNotNullExpressionValue(file2, "");
                        arrayList2.add(Boolean.valueOf(FilesKt.b(file2)));
                    }
                }
                Unit unit = Unit.f696a;
            } finally {
            }
        }
    }
}
