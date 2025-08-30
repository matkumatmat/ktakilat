package com.appsflyer.internal;

import android.content.Context;
import android.database.Cursor;
import com.appsflyer.internal.AFj1qSDK;
import java.util.Map;
import java.util.Observer;

public final class AFj1tSDK extends AFi1bSDK {
    private final AFc1dSDK getMediationNetwork;

    public AFj1tSDK(Runnable runnable, AFc1dSDK aFc1dSDK) {
        super("store", "samsung", runnable);
        this.getMediationNetwork = aFc1dSDK;
    }

    public final void getRevenue(Context context) {
        AnonymousClass2 r0 = new AFb1tSDK<Map<String, Object>>(context, this.getMediationNetwork.getMonetizationNetwork(), "com.sec.android.app.samsungapps.referrer", "FBA3AF4E7757D9016E953FB3EE4671CA2BD9AF725F9A53D52ED4A38EAAA08901") {
            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c3, code lost:
                if (r2 != null) goto L_0x00c5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c5, code lost:
                r2.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d9, code lost:
                if (r2 == null) goto L_0x00dc;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x00dc, code lost:
                r0 = r10.getCurrencyIso4217Code.getPackageManager().resolveContentProvider(r10.getMediationNetwork, 128).packageName;
                r10.getMonetizationNetwork.AFAdRevenueData.put("api_ver", java.lang.Long.valueOf(com.appsflyer.internal.AFj1iSDK.AFAdRevenueData(r10.getCurrencyIso4217Code, r0)));
                r10.getMonetizationNetwork.AFAdRevenueData.put("api_ver_name", com.appsflyer.internal.AFj1iSDK.getMediationNetwork(r10.getCurrencyIso4217Code, r0));
                r10.getMonetizationNetwork.getMediationNetwork();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x0117, code lost:
                return r10.getMonetizationNetwork.AFAdRevenueData;
             */
            /* renamed from: AFAdRevenueData */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.Map<java.lang.String, java.lang.Object> getCurrencyIso4217Code() {
                /*
                    r10 = this;
                    java.lang.String r0 = "FEATURE_NOT_SUPPORTED"
                    java.lang.String r1 = "response"
                    r2 = 0
                    android.content.Context r3 = r10.getCurrencyIso4217Code     // Catch:{ Exception -> 0x0091 }
                    android.content.ContentResolver r4 = r3.getContentResolver()     // Catch:{ Exception -> 0x0091 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r5 = "content://"
                    r3.<init>(r5)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r5 = r10.getMediationNetwork     // Catch:{ Exception -> 0x0091 }
                    r3.append(r5)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0091 }
                    android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0091 }
                    r8 = 0
                    r9 = 0
                    r6 = 0
                    r7 = 0
                    android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0091 }
                    if (r2 == 0) goto L_0x00ba
                    boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x0091 }
                    if (r3 == 0) goto L_0x00b2
                    com.appsflyer.internal.AFj1tSDK r3 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFAdRevenueData     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r4 = "OK"
                    r3.put(r1, r4)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "referrer"
                    com.appsflyer.internal.AFj1tSDK r4 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFAdRevenueData     // Catch:{ Exception -> 0x0091 }
                    E_(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "click_ts"
                    com.appsflyer.internal.AFj1tSDK r4 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFAdRevenueData     // Catch:{ Exception -> 0x0091 }
                    D_(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "install_begin_ts"
                    com.appsflyer.internal.AFj1tSDK r4 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFAdRevenueData     // Catch:{ Exception -> 0x0091 }
                    D_(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "install_end_ts"
                    com.appsflyer.internal.AFj1tSDK r4 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFAdRevenueData     // Catch:{ Exception -> 0x0091 }
                    D_(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "organic_keywords"
                    com.appsflyer.internal.AFj1tSDK r4 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFAdRevenueData     // Catch:{ Exception -> 0x0091 }
                    E_(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "attr_type"
                    com.appsflyer.internal.AFj1tSDK r4 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFAdRevenueData     // Catch:{ Exception -> 0x0091 }
                    E_(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0091 }
                    r3.<init>()     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r4 = "instant"
                    int r5 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0091 }
                    r6 = -1
                    if (r5 == r6) goto L_0x0093
                    java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x0091 }
                    if (r5 == 0) goto L_0x0093
                    boolean r5 = java.lang.Boolean.parseBoolean(r5)     // Catch:{ Exception -> 0x0091 }
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0091 }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x0091 }
                    goto L_0x0093
                L_0x008e:
                    r0 = move-exception
                    goto L_0x0118
                L_0x0091:
                    r3 = move-exception
                    goto L_0x00c9
                L_0x0093:
                    java.lang.String r4 = "click_server_ts"
                    D_(r4, r3, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r4 = "install_begin_server_ts"
                    D_(r4, r3, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r4 = "install_version"
                    E_(r4, r3, r2)     // Catch:{ Exception -> 0x0091 }
                    boolean r4 = r3.isEmpty()     // Catch:{ Exception -> 0x0091 }
                    if (r4 != 0) goto L_0x00c3
                    com.appsflyer.internal.AFj1tSDK r4 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFAdRevenueData     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r5 = "custom"
                    r4.put(r5, r3)     // Catch:{ Exception -> 0x0091 }
                    goto L_0x00c3
                L_0x00b2:
                    com.appsflyer.internal.AFj1tSDK r3 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFAdRevenueData     // Catch:{ Exception -> 0x0091 }
                    r3.put(r1, r0)     // Catch:{ Exception -> 0x0091 }
                    goto L_0x00c3
                L_0x00ba:
                    com.appsflyer.internal.AFj1tSDK r3 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFAdRevenueData     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r4 = "SERVICE_UNAVAILABLE"
                    r3.put(r1, r4)     // Catch:{ Exception -> 0x0091 }
                L_0x00c3:
                    if (r2 == 0) goto L_0x00dc
                L_0x00c5:
                    r2.close()
                    goto L_0x00dc
                L_0x00c9:
                    com.appsflyer.internal.AFj1tSDK r4 = com.appsflyer.internal.AFj1tSDK.this     // Catch:{ all -> 0x008e }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFAdRevenueData     // Catch:{ all -> 0x008e }
                    r4.put(r1, r0)     // Catch:{ all -> 0x008e }
                    java.lang.String r0 = r3.getMessage()     // Catch:{ all -> 0x008e }
                    r1 = 0
                    r4 = 1
                    com.appsflyer.AFLogger.afErrorLog(r0, r3, r1, r4)     // Catch:{ all -> 0x008e }
                    if (r2 == 0) goto L_0x00dc
                    goto L_0x00c5
                L_0x00dc:
                    android.content.Context r0 = r10.getCurrencyIso4217Code
                    android.content.pm.PackageManager r0 = r0.getPackageManager()
                    java.lang.String r1 = r10.getMediationNetwork
                    r2 = 128(0x80, float:1.794E-43)
                    android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r1, r2)
                    java.lang.String r0 = r0.packageName
                    com.appsflyer.internal.AFj1tSDK r1 = com.appsflyer.internal.AFj1tSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r1.AFAdRevenueData
                    android.content.Context r2 = r10.getCurrencyIso4217Code
                    long r2 = com.appsflyer.internal.AFj1iSDK.AFAdRevenueData(r2, r0)
                    java.lang.Long r2 = java.lang.Long.valueOf(r2)
                    java.lang.String r3 = "api_ver"
                    r1.put(r3, r2)
                    com.appsflyer.internal.AFj1tSDK r1 = com.appsflyer.internal.AFj1tSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r1.AFAdRevenueData
                    android.content.Context r2 = r10.getCurrencyIso4217Code
                    java.lang.String r0 = com.appsflyer.internal.AFj1iSDK.getMediationNetwork(r2, r0)
                    java.lang.String r2 = "api_ver_name"
                    r1.put(r2, r0)
                    com.appsflyer.internal.AFj1tSDK r0 = com.appsflyer.internal.AFj1tSDK.this
                    r0.getMediationNetwork()
                    com.appsflyer.internal.AFj1tSDK r0 = com.appsflyer.internal.AFj1tSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r0 = r0.AFAdRevenueData
                    return r0
                L_0x0118:
                    if (r2 == 0) goto L_0x011d
                    r2.close()
                L_0x011d:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1tSDK.AnonymousClass2.getCurrencyIso4217Code():java.util.Map");
            }

            private static void D_(String str, Map<String, Object> map, Cursor cursor) {
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex != -1) {
                    long j = cursor.getLong(columnIndex);
                    if (j != 0) {
                        map.put(str, Long.valueOf(j));
                    }
                }
            }

            private static void E_(String str, Map<String, Object> map, Cursor cursor) {
                String string;
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex != -1 && (string = cursor.getString(columnIndex)) != null) {
                    map.put(str, string);
                }
            }
        };
        AFc1qSDK component2 = this.getMediationNetwork.component2();
        AFa1tSDK aFa1tSDK = (AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis());
        if (((Integer) AFa1tSDK.getMonetizationNetwork(new Object[]{component2, Boolean.FALSE}, -1175980247, 1175980268, (int) System.currentTimeMillis())).intValue() <= 0 && r0.getMediationNetwork()) {
            r0.getRevenue.execute(r0.AFAdRevenueData);
            this.component1 = System.currentTimeMillis();
            this.component4 = AFj1qSDK.AFa1ySDK.STARTED;
            addObserver(new Observer() {
                public final void update(
/*
Method generation error in method: com.appsflyer.internal.AFj1qSDK.5.update(java.util.Observable, java.lang.Object):void, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFj1qSDK.5.update(java.util.Observable, java.lang.Object):void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
        }
    }
}
