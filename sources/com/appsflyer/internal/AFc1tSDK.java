package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFileCacheManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileCacheManager.kt\ncom/appsflyer/internal/cache/FileCacheManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,328:1\n1855#2,2:329\n1855#2,2:332\n1855#2:334\n1856#2:337\n1855#2,2:339\n1855#2:341\n1856#2:344\n6442#3:331\n13579#3,2:342\n18#4:335\n26#5:336\n1#6:338\n*S KotlinDebug\n*F\n+ 1 FileCacheManager.kt\ncom/appsflyer/internal/cache/FileCacheManager\n*L\n105#1:329,2\n182#1:332,2\n200#1:334\n200#1:337\n256#1:339,2\n289#1:341\n289#1:344\n180#1:331\n292#1:342,2\n206#1:335\n206#1:336\n*E\n"})
public final class AFc1tSDK implements AFc1vSDK {
    @NotNull
    private final AFc1iSDK AFAdRevenueData;
    @NotNull
    private final AFc1qSDK getCurrencyIso4217Code;
    @NotNull
    private final AFc1sSDK getMediationNetwork = new AFc1sSDK(CollectionsKt.t(new AFc1uSDK("ConversionsCache", CollectionsKt.s(AFe1mSDK.CONVERSION), 1), new AFc1uSDK("AttrCache", CollectionsKt.s(AFe1mSDK.ATTR), 1), new AFc1uSDK("OtherCache", CollectionsKt.t(AFe1mSDK.LAUNCH, AFe1mSDK.INAPP, AFe1mSDK.ADREVENUE, AFe1mSDK.ARS_VALIDATE, AFe1mSDK.PURCHASE_VALIDATE, AFe1mSDK.MANUAL_PURCHASE_VALIDATION, AFe1mSDK.SDK_SERVICES), 40)));
    @NotNull
    private final Map<String, Integer> getRevenue = MapsKt.f(new Pair("ConversionsCache", 0), new Pair("AttrCache", 0), new Pair("OtherCache", 0));

    public AFc1tSDK(@NotNull AFc1iSDK aFc1iSDK, @NotNull AFc1qSDK aFc1qSDK) {
        Intrinsics.checkNotNullParameter(aFc1iSDK, "");
        Intrinsics.checkNotNullParameter(aFc1qSDK, "");
        this.AFAdRevenueData = aFc1iSDK;
        this.getCurrencyIso4217Code = aFc1qSDK;
    }

    private final boolean getCurrencyIso4217Code(File file) {
        try {
            file.delete();
            getMonetizationNetwork();
            return true;
        } catch (Exception e) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, ba.o("Could not delete ", file.getName(), " from cache"), e, false, false, false, false, 120, (Object) null);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        kotlin.io.CloseableKt.a(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.appsflyer.internal.AFc1rSDK getMediationNetwork(java.io.File r9) {
        /*
            r0 = 0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0029 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0029 }
            r2.<init>(r9)     // Catch:{ Exception -> 0x0029 }
            java.nio.charset.Charset r3 = java.nio.charset.Charset.defaultCharset()     // Catch:{ Exception -> 0x0029 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0029 }
            long r2 = r9.length()     // Catch:{ all -> 0x002c }
            int r3 = (int) r2     // Catch:{ all -> 0x002c }
            char[] r2 = new char[r3]     // Catch:{ all -> 0x002c }
            r1.read(r2)     // Catch:{ all -> 0x002c }
            com.appsflyer.internal.AFc1rSDK r3 = new com.appsflyer.internal.AFc1rSDK     // Catch:{ all -> 0x002c }
            r3.<init>(r2)     // Catch:{ all -> 0x002c }
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x002c }
            r3.getMediationNetwork = r9     // Catch:{ all -> 0x002c }
            kotlin.io.CloseableKt.a(r1, r0)     // Catch:{ Exception -> 0x0029 }
            r0 = r3
            goto L_0x0040
        L_0x0029:
            r9 = move-exception
            r4 = r9
            goto L_0x0033
        L_0x002c:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x002e }
        L_0x002e:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r1, r9)     // Catch:{ Exception -> 0x0029 }
            throw r2     // Catch:{ Exception -> 0x0029 }
        L_0x0033:
            com.appsflyer.AFLogger r1 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.CACHE
            r7 = 1
            r8 = 0
            java.lang.String r3 = "Error while loading request from cache"
            r5 = 0
            r6 = 0
            r1.e(r2, r3, r4, r5, r6, r7, r8)
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1tSDK.getMediationNetwork(java.io.File):com.appsflyer.internal.AFc1rSDK");
    }

    private final void getMonetizationNetwork() {
        for (AFc1uSDK aFc1uSDK : this.getMediationNetwork.AFAdRevenueData) {
            String str = aFc1uSDK.getCurrencyIso4217Code;
            Context context = this.AFAdRevenueData.getMonetizationNetwork;
            Intrinsics.c(context);
            File file = new File(new File(context.getFilesDir(), "AFRequestCache"), str);
            int i = 0;
            if (!file.exists()) {
                file.mkdirs();
                this.getRevenue.put(aFc1uSDK.getCurrencyIso4217Code, 0);
            } else {
                Map<String, Integer> map = this.getRevenue;
                String str2 = aFc1uSDK.getCurrencyIso4217Code;
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    i = listFiles.length;
                }
                map.put(str2, Integer.valueOf(i));
            }
        }
    }

    @WorkerThread
    public final void AFAdRevenueData() {
        try {
            if (this.getCurrencyIso4217Code.AFAdRevenueData("AF_CACHE_VERSION", -1) == 1) {
                Context context = this.AFAdRevenueData.getMonetizationNetwork;
                Intrinsics.c(context);
                if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
                    Context context2 = this.AFAdRevenueData.getMonetizationNetwork;
                    Intrinsics.c(context2);
                    new File(context2.getFilesDir(), "AFRequestCache").mkdir();
                }
            } else {
                this.getCurrencyIso4217Code.getMediationNetwork("AF_CACHE_VERSION", 1);
                Context context3 = this.AFAdRevenueData.getMonetizationNetwork;
                Intrinsics.c(context3);
                if (new File(context3.getFilesDir(), "AFRequestCache").exists()) {
                    Context context4 = this.AFAdRevenueData.getMonetizationNetwork;
                    Intrinsics.c(context4);
                    FilesKt.b(new File(context4.getFilesDir(), "AFRequestCache"));
                    Context context5 = this.AFAdRevenueData.getMonetizationNetwork;
                    Intrinsics.c(context5);
                    new File(context5.getFilesDir(), "AFRequestCache").mkdir();
                }
            }
            getMonetizationNetwork();
        } catch (Exception e) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not init cache", e, false, false, false, false, 120, (Object) null);
        }
    }

    @NotNull
    @WorkerThread
    public final List<AFc1rSDK> getRevenue() {
        AFg1gSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Get Cached Requests", false, 4, (Object) null);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            Context context = this.AFAdRevenueData.getMonetizationNetwork;
            Intrinsics.c(context);
            if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
                Context context2 = this.AFAdRevenueData.getMonetizationNetwork;
                Intrinsics.c(context2);
                new File(context2.getFilesDir(), "AFRequestCache").mkdir();
            }
            for (AFc1uSDK aFc1uSDK : this.getMediationNetwork.AFAdRevenueData) {
                String str = aFc1uSDK.getCurrencyIso4217Code;
                Context context3 = this.AFAdRevenueData.getMonetizationNetwork;
                Intrinsics.c(context3);
                File file = new File(new File(context3.getFilesDir(), "AFRequestCache"), str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    listFiles = new File[0];
                }
                CollectionsKt.g(arrayList2, listFiles);
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                File file2 = (File) it.next();
                AFLogger aFLogger = AFLogger.INSTANCE;
                AFg1cSDK aFg1cSDK = AFg1cSDK.CACHE;
                String name = file2.getName();
                AFg1gSDK.i$default(aFLogger, aFg1cSDK, "Found cached request: " + name, false, 4, (Object) null);
                AFc1rSDK mediationNetwork = getMediationNetwork(file2);
                if (mediationNetwork != null) {
                    arrayList.add(mediationNetwork);
                }
            }
        } catch (Exception e) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not get cached requests", e, false, false, false, false, 120, (Object) null);
        }
        AFg1gSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, ba.l(arrayList.size(), "Found ", " Cached Requests"), false, 4, (Object) null);
        return arrayList;
    }

    private final AFc1uSDK getCurrencyIso4217Code(AFe1mSDK aFe1mSDK) {
        Object obj;
        Iterator it = this.getMediationNetwork.AFAdRevenueData.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((AFc1uSDK) obj).getRevenue.contains(aFe1mSDK)) {
                break;
            }
        }
        return (AFc1uSDK) obj;
    }

    @WorkerThread
    public final void getMediationNetwork() {
        try {
            Context context = this.AFAdRevenueData.getMonetizationNetwork;
            Intrinsics.c(context);
            if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
                Context context2 = this.AFAdRevenueData.getMonetizationNetwork;
                Intrinsics.c(context2);
                new File(context2.getFilesDir(), "AFRequestCache").mkdir();
                return;
            }
            for (AFc1uSDK aFc1uSDK : this.getMediationNetwork.AFAdRevenueData) {
                String str = aFc1uSDK.getCurrencyIso4217Code;
                Context context3 = this.AFAdRevenueData.getMonetizationNetwork;
                Intrinsics.c(context3);
                File[] listFiles = new File(new File(context3.getFilesDir(), "AFRequestCache"), str).listFiles();
                if (listFiles != null) {
                    Intrinsics.checkNotNullExpressionValue(listFiles, "");
                    for (File file : listFiles) {
                        AFLogger aFLogger = AFLogger.INSTANCE;
                        AFg1cSDK aFg1cSDK = AFg1cSDK.CACHE;
                        AFg1gSDK.i$default(aFLogger, aFg1cSDK, "ClearCache : Found cached request " + file.getName(), false, 4, (Object) null);
                        AFg1gSDK.i$default(aFLogger, aFg1cSDK, "Deleting " + file.getName() + " from cache", false, 4, (Object) null);
                        file.delete();
                    }
                }
            }
            Context context4 = this.AFAdRevenueData.getMonetizationNetwork;
            Intrinsics.c(context4);
            FilesKt.b(new File(context4.getFilesDir(), "AFRequestCache"));
            getMonetizationNetwork();
        } catch (Exception e) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, "Could not clearCache request", e, false, false, false, false, 120, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x01da  */
    @androidx.annotation.WorkerThread
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String AFAdRevenueData(@org.jetbrains.annotations.NotNull com.appsflyer.internal.AFc1rSDK r27) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            java.lang.String r2 = "AFRequestCache"
            java.lang.String r3 = "Cache overflown for type "
            java.lang.String r4 = "Cache request: done, cacheKey: "
            java.lang.String r5 = "Caching request with URL: "
            java.lang.String r6 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)
            r7 = 0
            com.appsflyer.internal.AFe1mSDK r8 = r0.getMonetizationNetwork     // Catch:{ Exception -> 0x003a }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)     // Catch:{ Exception -> 0x003a }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x003a }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x003a }
            com.appsflyer.internal.AFc1iSDK r11 = r1.AFAdRevenueData     // Catch:{ Exception -> 0x003a }
            android.content.Context r11 = r11.getMonetizationNetwork     // Catch:{ Exception -> 0x003a }
            kotlin.jvm.internal.Intrinsics.c(r11)     // Catch:{ Exception -> 0x003a }
            java.io.File r11 = r11.getFilesDir()     // Catch:{ Exception -> 0x003a }
            r10.<init>(r11, r2)     // Catch:{ Exception -> 0x003a }
            java.lang.String r8 = r1.getMediationNetwork((com.appsflyer.internal.AFe1mSDK) r8)     // Catch:{ Exception -> 0x003a }
            r9.<init>(r10, r8)     // Catch:{ Exception -> 0x003a }
            boolean r8 = r9.exists()     // Catch:{ Exception -> 0x003a }
            if (r8 != 0) goto L_0x0040
            r9.mkdirs()     // Catch:{ Exception -> 0x003a }
            goto L_0x0040
        L_0x003a:
            r0 = move-exception
            r19 = r0
            r15 = r7
            goto L_0x01d8
        L_0x0040:
            com.appsflyer.AFLogger r8 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ Exception -> 0x003a }
            com.appsflyer.internal.AFg1cSDK r16 = com.appsflyer.internal.AFg1cSDK.CACHE     // Catch:{ Exception -> 0x003a }
            java.lang.String r10 = r0.getRevenue     // Catch:{ Exception -> 0x003a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003a }
            r11.<init>(r5)     // Catch:{ Exception -> 0x003a }
            r11.append(r10)     // Catch:{ Exception -> 0x003a }
            java.lang.String r12 = r11.toString()     // Catch:{ Exception -> 0x003a }
            r15 = 0
            r13 = 0
            r14 = 4
            r10 = r8
            r11 = r16
            com.appsflyer.internal.AFg1gSDK.i$default(r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x003a }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x003a }
            java.lang.String r5 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x003a }
            java.io.File r15 = new java.io.File     // Catch:{ Exception -> 0x003a }
            r15.<init>(r9, r5)     // Catch:{ Exception -> 0x003a }
            r15.createNewFile()     // Catch:{ Exception -> 0x01c7 }
            java.io.OutputStreamWriter r9 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x01c7 }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r11 = r15.getPath()     // Catch:{ Exception -> 0x01c7 }
            r14 = 1
            r10.<init>(r11, r14)     // Catch:{ Exception -> 0x01c7 }
            java.nio.charset.Charset r11 = java.nio.charset.Charset.defaultCharset()     // Catch:{ Exception -> 0x01c7 }
            r9.<init>(r10, r11)     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r10 = "version="
            r9.write(r10)     // Catch:{ all -> 0x01cd }
            java.lang.String r10 = r0.AFAdRevenueData     // Catch:{ all -> 0x01cd }
            r9.write(r10)     // Catch:{ all -> 0x01cd }
            r10 = 10
            r9.write(r10)     // Catch:{ all -> 0x01cd }
            java.lang.String r11 = "url="
            r9.write(r11)     // Catch:{ all -> 0x01cd }
            java.lang.String r11 = r0.getRevenue     // Catch:{ all -> 0x01cd }
            r9.write(r11)     // Catch:{ all -> 0x01cd }
            r9.write(r10)     // Catch:{ all -> 0x01cd }
            java.lang.String r11 = "data="
            r9.write(r11)     // Catch:{ all -> 0x01cd }
            byte[] r11 = r27.getMediationNetwork()     // Catch:{ all -> 0x01cd }
            r12 = 2
            java.lang.String r11 = android.util.Base64.encodeToString(r11, r12)     // Catch:{ all -> 0x01cd }
            r9.write(r11)     // Catch:{ all -> 0x01cd }
            r9.write(r10)     // Catch:{ all -> 0x01cd }
            com.appsflyer.internal.AFe1mSDK r11 = r0.getMonetizationNetwork     // Catch:{ all -> 0x01cd }
            java.lang.String r12 = "type="
            r9.write(r12)     // Catch:{ all -> 0x01cd }
            java.lang.String r11 = r11.name()     // Catch:{ all -> 0x01cd }
            r9.write(r11)     // Catch:{ all -> 0x01cd }
            r9.write(r10)     // Catch:{ all -> 0x01cd }
            r9.flush()     // Catch:{ all -> 0x01cd }
            kotlin.Unit r10 = kotlin.Unit.f696a     // Catch:{ all -> 0x01cd }
            kotlin.io.CloseableKt.a(r9, r7)     // Catch:{ Exception -> 0x01c7 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c7 }
            r9.<init>(r4)     // Catch:{ Exception -> 0x01c7 }
            r9.append(r5)     // Catch:{ Exception -> 0x01c7 }
            java.lang.String r12 = r9.toString()     // Catch:{ Exception -> 0x01c7 }
            r4 = 0
            r13 = 0
            r9 = 4
            r10 = r8
            r11 = r16
            r17 = 1
            r14 = r9
            r18 = r15
            r15 = r4
            com.appsflyer.internal.AFg1gSDK.i$default(r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x00f5 }
            com.appsflyer.internal.AFe1mSDK r0 = r0.getMonetizationNetwork     // Catch:{ Exception -> 0x00f5 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)     // Catch:{ Exception -> 0x00f5 }
            com.appsflyer.internal.AFc1uSDK r4 = r1.getCurrencyIso4217Code((com.appsflyer.internal.AFe1mSDK) r0)     // Catch:{ Exception -> 0x00f5 }
            if (r4 == 0) goto L_0x00fc
            int r4 = r4.AFAdRevenueData     // Catch:{ Exception -> 0x00f5 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x00fd
        L_0x00f5:
            r0 = move-exception
            r19 = r0
            r15 = r18
            goto L_0x01d8
        L_0x00fc:
            r4 = r7
        L_0x00fd:
            if (r4 == 0) goto L_0x01c5
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x00f5 }
            java.util.Map<java.lang.String, java.lang.Integer> r6 = r1.getRevenue     // Catch:{ Exception -> 0x00f5 }
            com.appsflyer.internal.AFc1uSDK r9 = r1.getCurrencyIso4217Code((com.appsflyer.internal.AFe1mSDK) r0)     // Catch:{ Exception -> 0x00f5 }
            if (r9 == 0) goto L_0x01bd
            java.lang.String r9 = r9.getCurrencyIso4217Code     // Catch:{ Exception -> 0x00f5 }
            if (r9 == 0) goto L_0x01bd
            java.lang.Object r6 = r6.get(r9)     // Catch:{ Exception -> 0x00f5 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x00f5 }
            if (r6 == 0) goto L_0x011c
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x00f5 }
            goto L_0x011d
        L_0x011c:
            r6 = 0
        L_0x011d:
            if (r6 < r4) goto L_0x01b9
            int r6 = r6 + 1
            int r6 = r6 - r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f5 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00f5 }
            r4.append(r0)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r3 = ", removing "
            r4.append(r3)     // Catch:{ Exception -> 0x00f5 }
            r4.append(r6)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r3 = " item(s)"
            r4.append(r3)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r12 = r4.toString()     // Catch:{ Exception -> 0x00f5 }
            r15 = 0
            r13 = 0
            r14 = 4
            r10 = r8
            r11 = r16
            com.appsflyer.internal.AFg1gSDK.i$default(r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x00f5 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00f5 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00f5 }
            com.appsflyer.internal.AFc1iSDK r8 = r1.AFAdRevenueData     // Catch:{ Exception -> 0x00f5 }
            android.content.Context r8 = r8.getMonetizationNetwork     // Catch:{ Exception -> 0x00f5 }
            kotlin.jvm.internal.Intrinsics.c(r8)     // Catch:{ Exception -> 0x00f5 }
            java.io.File r8 = r8.getFilesDir()     // Catch:{ Exception -> 0x00f5 }
            r4.<init>(r8, r2)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r0 = r1.getMediationNetwork((com.appsflyer.internal.AFe1mSDK) r0)     // Catch:{ Exception -> 0x00f5 }
            r3.<init>(r4, r0)     // Catch:{ Exception -> 0x00f5 }
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x00f5 }
            if (r0 != 0) goto L_0x0166
            r3.mkdirs()     // Catch:{ Exception -> 0x00f5 }
        L_0x0166:
            java.io.File[] r0 = r3.listFiles()     // Catch:{ Exception -> 0x00f5 }
            if (r0 == 0) goto L_0x01b9
            com.appsflyer.internal.AFc1tSDK$1 r2 = new com.appsflyer.internal.AFc1tSDK$1     // Catch:{ Exception -> 0x00f5 }
            r2.<init>()     // Catch:{ Exception -> 0x00f5 }
            java.util.List r0 = kotlin.collections.ArraysKt.x(r0, r2)     // Catch:{ Exception -> 0x00f5 }
            if (r0 == 0) goto L_0x01b9
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x00f5 }
            java.util.List r0 = kotlin.collections.CollectionsKt.A(r0, r6)     // Catch:{ Exception -> 0x00f5 }
            if (r0 == 0) goto L_0x01b9
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x00f5 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00f5 }
        L_0x0185:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x00f5 }
            if (r2 == 0) goto L_0x01b9
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x00f5 }
            java.io.File r2 = (java.io.File) r2     // Catch:{ Exception -> 0x00f5 }
            r2.delete()     // Catch:{ Exception -> 0x00f5 }
            com.appsflyer.AFLogger r8 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ Exception -> 0x00f5 }
            com.appsflyer.internal.AFg1cSDK r9 = com.appsflyer.internal.AFg1cSDK.CACHE     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x00f5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f5 }
            r3.<init>()     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r4 = "Cache entry "
            r3.append(r4)     // Catch:{ Exception -> 0x00f5 }
            r3.append(r2)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r2 = " removed"
            r3.append(r2)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r10 = r3.toString()     // Catch:{ Exception -> 0x00f5 }
            r13 = 0
            r11 = 0
            r12 = 4
            com.appsflyer.internal.AFg1gSDK.i$default(r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x0185
        L_0x01b9:
            r26.getMonetizationNetwork()     // Catch:{ Exception -> 0x00f5 }
            goto L_0x01c5
        L_0x01bd:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r2 = "Cache do not support this type of events"
            r0.<init>(r2)     // Catch:{ Exception -> 0x00f5 }
            throw r0     // Catch:{ Exception -> 0x00f5 }
        L_0x01c5:
            r7 = r5
            goto L_0x01f2
        L_0x01c7:
            r0 = move-exception
            r18 = r15
            r19 = r0
            goto L_0x01d8
        L_0x01cd:
            r0 = move-exception
            r18 = r15
            r2 = r0
            throw r2     // Catch:{ all -> 0x01d2 }
        L_0x01d2:
            r0 = move-exception
            r3 = r0
            kotlin.io.CloseableKt.a(r9, r2)     // Catch:{ Exception -> 0x00f5 }
            throw r3     // Catch:{ Exception -> 0x00f5 }
        L_0x01d8:
            if (r15 == 0) goto L_0x01dd
            r15.delete()
        L_0x01dd:
            com.appsflyer.AFLogger r16 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r17 = com.appsflyer.internal.AFg1cSDK.CACHE
            r22 = 0
            r23 = 0
            java.lang.String r18 = "Could not cache request"
            r20 = 0
            r21 = 0
            r24 = 120(0x78, float:1.68E-43)
            r25 = 0
            com.appsflyer.internal.AFg1gSDK.e$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
        L_0x01f2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1tSDK.AFAdRevenueData(com.appsflyer.internal.AFc1rSDK):java.lang.String");
    }

    private final String getMediationNetwork(AFe1mSDK aFe1mSDK) {
        String str;
        AFc1uSDK currencyIso4217Code = getCurrencyIso4217Code(aFe1mSDK);
        if (currencyIso4217Code != null && (str = currencyIso4217Code.getCurrencyIso4217Code) != null) {
            return str;
        }
        throw new UnsupportedOperationException("Cache do not support this type of events");
    }

    @WorkerThread
    public final boolean AFAdRevenueData(@Nullable String str) {
        if (str == null) {
            return false;
        }
        Context context = this.AFAdRevenueData.getMonetizationNetwork;
        Intrinsics.c(context);
        if (!new File(context.getFilesDir(), "AFRequestCache").exists()) {
            Context context2 = this.AFAdRevenueData.getMonetizationNetwork;
            Intrinsics.c(context2);
            new File(context2.getFilesDir(), "AFRequestCache").mkdir();
            return true;
        }
        AFg1gSDK.i$default(AFLogger.INSTANCE, AFg1cSDK.CACHE, ba.o("Deleting ", str, " from cache"), false, 4, (Object) null);
        for (AFc1uSDK aFc1uSDK : this.getMediationNetwork.AFAdRevenueData) {
            String str2 = aFc1uSDK.getCurrencyIso4217Code;
            Context context3 = this.AFAdRevenueData.getMonetizationNetwork;
            Intrinsics.c(context3);
            File file = new File(new File(new File(context3.getFilesDir(), "AFRequestCache"), str2), str);
            if (file.exists()) {
                return getCurrencyIso4217Code(file);
            }
        }
        return true;
    }
}
