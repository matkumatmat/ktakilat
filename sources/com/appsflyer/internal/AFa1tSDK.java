package com.appsflyer.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFAdRevenueData;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFLogger;
import com.appsflyer.AFPurchaseDetails;
import com.appsflyer.AppsFlyerConsent;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidationCallback;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFb1bSDK;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.google.android.gms.common.GoogleApiAvailability;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFa1tSDK extends AppsFlyerLib {
    private static int $10 = 0;
    private static int $11 = 1;
    static AppsFlyerInAppPurchaseValidatorListener AFAdRevenueData = null;
    private static int AFInAppEventParameterName = 0;
    private static int AFInAppEventType = ((AFInAppEventParameterName + 83) % 128);
    private static int[] AFKeystoreWrapper;
    @VisibleForTesting
    private static AFa1tSDK areAllFieldsValid = new AFa1tSDK();
    public static final String getMonetizationNetwork = "348";
    public static final String getRevenue = "6.17";
    Application component1;
    private long component2 = -1;
    private long component3 = TimeUnit.SECONDS.toMillis(5);
    boolean component4 = false;
    @NonNull
    private final AFc1eSDK copy = new AFc1eSDK();
    private Map<Long, String> copydefault;
    private AFf1mSDK equals;
    public volatile AppsFlyerConversionListener getCurrencyIso4217Code = null;
    long getMediationNetwork = -1;
    private SharedPreferences hashCode;
    private boolean toString;

    /* renamed from: com.appsflyer.internal.AFa1tSDK$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] getRevenue;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r0 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                getRevenue = r0
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = getRevenue     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.AnonymousClass3.<clinit>():void");
        }
    }

    public class AFa1ySDK implements Runnable {
        private final AFh1rSDK getCurrencyIso4217Code;

        public AFa1ySDK(AFh1rSDK aFh1rSDK) {
            this.getCurrencyIso4217Code = aFh1rSDK;
        }

        public final void run() {
            AFa1tSDK aFa1tSDK = AFa1tSDK.this;
            AFa1tSDK.getMonetizationNetwork(new Object[]{aFa1tSDK, this.getCurrencyIso4217Code}, 974724333, -974724320, System.identityHashCode(aFa1tSDK));
        }
    }

    static {
        areAllFieldsValid();
    }

    @VisibleForTesting
    public AFa1tSDK() {
        AFAdRevenueData().v().AFAdRevenueData();
        AFAdRevenueData().v().getMonetizationNetwork();
        AFe1lSDK copydefault2 = AFAdRevenueData().copydefault();
        copydefault2.AFAdRevenueData.add(new AFa1vSDK());
    }

    private static /* synthetic */ Object AFLogger(Object[] objArr) {
        AFa1tSDK aFa1tSDK = objArr[0];
        String[] strArr = objArr[1];
        int i = AFInAppEventParameterName + 69;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            aFa1tSDK.AFAdRevenueData().copy().getMediationNetwork("setUserEmails", strArr);
            aFa1tSDK.setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
            return null;
        }
        aFa1tSDK.AFAdRevenueData().copy().getMediationNetwork("setUserEmails", strArr);
        aFa1tSDK.setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002a, code lost:
        if (r5 == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0038, code lost:
        if (r5 == false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ java.lang.Object areAllFieldsValid(java.lang.Object[] r5) {
        /*
            r0 = 0
            r1 = r5[r0]
            com.appsflyer.internal.AFa1tSDK r1 = (com.appsflyer.internal.AFa1tSDK) r1
            r2 = 1
            r5 = r5[r2]
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            int r3 = AFInAppEventParameterName
            int r3 = r3 + 29
            int r4 = r3 % 128
            AFInAppEventType = r4
            int r3 = r3 % 2
            java.lang.String r4 = "setDisableAdvertisingIdentifiers: "
            if (r3 != 0) goto L_0x002d
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.afDebugLog(r3)
            r3 = 66
            int r3 = r3 / r0
            if (r5 != 0) goto L_0x003b
            goto L_0x003a
        L_0x002d:
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.afDebugLog(r3)
            if (r5 != 0) goto L_0x003b
        L_0x003a:
            r0 = 1
        L_0x003b:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.appsflyer.internal.AFb1jSDK.getRevenue = r0
            com.appsflyer.internal.AFc1dSDK r0 = r1.AFAdRevenueData()
            com.appsflyer.internal.AFc1kSDK r2 = r0.afInfoLog()
            r2.areAllFieldsValid = r5
            r2 = 0
            if (r5 == 0) goto L_0x0055
            com.appsflyer.internal.AFc1kSDK r5 = r0.afInfoLog()
            r5.component3 = r2
            return r2
        L_0x0055:
            com.appsflyer.internal.AFe1lSDK r5 = r0.copydefault()
            com.appsflyer.internal.AFe1eSDK r0 = new com.appsflyer.internal.AFe1eSDK
            com.appsflyer.internal.AFc1dSDK r1 = r1.AFAdRevenueData()
            r0.<init>(r1)
            java.util.concurrent.Executor r1 = r5.getRevenue
            com.appsflyer.internal.AFe1lSDK$5 r3 = new com.appsflyer.internal.AFe1lSDK$5
            r3.<init>(r0)
            r1.execute(r3)
            int r5 = AFInAppEventParameterName
            int r5 = r5 + 57
            int r0 = r5 % 128
            AFInAppEventType = r0
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0079
            return r2
        L_0x0079:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.areAllFieldsValid(java.lang.Object[]):java.lang.Object");
    }

    public static synchronized SharedPreferences c_(Context context) {
        SharedPreferences sharedPreferences;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        synchronized (AFa1tSDK.class) {
            try {
                AFInAppEventParameterName = (AFInAppEventType + 63) % 128;
                if (((AFa1tSDK) getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).hashCode == null) {
                    allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    ((AFa1tSDK) getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).hashCode = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    AFInAppEventParameterName = (AFInAppEventType + 35) % 128;
                }
                sharedPreferences = ((AFa1tSDK) getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).hashCode;
                AFInAppEventParameterName = (AFInAppEventType + 103) % 128;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return sharedPreferences;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if ((r4 instanceof android.app.Activity) != false) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        if ((r4 instanceof android.app.Activity) != false) goto L_0x001a;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.appsflyer.internal.AFh1qSDK component1(android.content.Context r4) {
        /*
            r3 = this;
            int r0 = AFInAppEventType
            int r0 = r0 + 9
            int r1 = r0 % 128
            AFInAppEventParameterName = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L_0x0016
            boolean r0 = r4 instanceof android.app.Activity
            r2 = 87
            int r2 = r2 / 0
            if (r0 == 0) goto L_0x0037
            goto L_0x001a
        L_0x0016:
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0037
        L_0x001a:
            com.appsflyer.internal.AFh1qSDK r0 = new com.appsflyer.internal.AFh1qSDK
            android.app.Activity r4 = (android.app.Activity) r4
            com.appsflyer.internal.AFc1dSDK r2 = r3.AFAdRevenueData()
            com.appsflyer.internal.AFi1kSDK r2 = r2.w()
            r0.<init>(r4, r2)
            int r4 = AFInAppEventType
            int r4 = r4 + 105
            int r2 = r4 % 128
            AFInAppEventParameterName = r2
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x0036
            return r0
        L_0x0036:
            throw r1
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.component1(android.content.Context):com.appsflyer.internal.AFh1qSDK");
    }

    private static /* synthetic */ Object component2(Object[] objArr) {
        AppsFlyerProperties.EmailsCryptType emailsCryptType = objArr[1];
        String[] strArr = objArr[2];
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        objArr[0].AFAdRevenueData().copy().getMediationNetwork("setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        Object obj = null;
        for (String str : strArr) {
            AFInAppEventType = (AFInAppEventParameterName + 35) % 128;
            if (AnonymousClass3.getRevenue[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(AFj1cSDK.getMonetizationNetwork(str));
                AFInAppEventParameterName = (AFInAppEventType + 111) % 128;
                obj = "sha256_el_arr";
            } else {
                arrayList2.add(str);
                obj = "plain_el_arr";
            }
        }
        hashMap.put(obj, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
        int i = AFInAppEventParameterName + 87;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            return null;
        }
        throw null;
    }

    private static /* synthetic */ Object component3(Object[] objArr) {
        String str;
        AFi1pSDK aFi1pSDK;
        AFa1tSDK aFa1tSDK = objArr[0];
        String str2 = objArr[1];
        AppsFlyerConversionListener appsFlyerConversionListener = objArr[2];
        Context context = objArr[3];
        int i = AFInAppEventType + 117;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            boolean z = aFa1tSDK.toString;
            throw null;
        } else if (aFa1tSDK.toString) {
            return aFa1tSDK;
        } else {
            aFa1tSDK.toString = true;
            aFa1tSDK.AFAdRevenueData().registerClient().AFAdRevenueData(str2);
            if (context != null) {
                AFInAppEventType = (AFInAppEventParameterName + 25) % 128;
                aFa1tSDK.getMediationNetwork(context);
                Application O_ = AFj1iSDK.O_(context);
                if (O_ == null) {
                    return aFa1tSDK;
                }
                aFa1tSDK.component1 = O_;
                aFa1tSDK.AFAdRevenueData().getMonetizationNetwork().execute(new a(aFa1tSDK, 0));
                aFa1tSDK.AFAdRevenueData().areAllFieldsValid().getMediationNetwork = System.currentTimeMillis();
                AFe1lSDK copydefault2 = aFa1tSDK.AFAdRevenueData().copydefault();
                copydefault2.getRevenue.execute(new Runnable(new AFe1eSDK(aFa1tSDK.AFAdRevenueData())) {
                    private /* synthetic */ AFe1sSDK getMonetizationNetwork;

                    /*  JADX ERROR: Method generation error
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                    /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                    public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFe1lSDK.5.run():void, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                AFi1tSDK i2 = aFa1tSDK.AFAdRevenueData().i();
                if (Build.VERSION.SDK_INT >= 31) {
                    aFi1pSDK = new AFi1sSDK(i2.getCurrencyIso4217Code);
                } else {
                    aFi1pSDK = new AFi1qSDK(i2.getCurrencyIso4217Code);
                }
                i2.getMediationNetwork = aFi1pSDK;
                aFa1tSDK.AFAdRevenueData().afRDLog().AFAdRevenueData(new b(aFa1tSDK));
                aFa1tSDK.AFAdRevenueData().component1().getCurrencyIso4217Code(aFa1tSDK.getMonetizationNetwork());
                AFj1sSDK AFLogger = aFa1tSDK.AFAdRevenueData().AFLogger();
                a aVar = new a(aFa1tSDK, 1);
                AFi1aSDK AFAdRevenueData2 = AFLogger.AFAdRevenueData(aVar);
                Runnable AFAdRevenueData3 = AFLogger.AFAdRevenueData(AFAdRevenueData2, aVar);
                AFLogger.getMediationNetwork((AFj1qSDK) AFAdRevenueData2);
                AFLogger.getMediationNetwork((AFj1qSDK) new AFj1oSDK(AFLogger.getMediationNetwork.getRevenue(), AFAdRevenueData3));
                AFLogger.getMediationNetwork((AFj1qSDK) new AFj1vSDK(AFAdRevenueData3, AFLogger.getMediationNetwork, new AFj1wSDK()));
                AFLogger.getMediationNetwork((AFj1qSDK) new AFj1tSDK(AFAdRevenueData3, AFLogger.getMediationNetwork));
                AFLogger.getMediationNetwork((AFj1qSDK) new AFj1uSDK(AFLogger.getMediationNetwork.getMonetizationNetwork(), AFLogger.getMediationNetwork.getRevenue(), AFAdRevenueData3));
                AFLogger.getMediationNetwork(AFAdRevenueData3);
                if (!AFLogger.getMonetizationNetwork()) {
                    Context context2 = AFLogger.getMediationNetwork.AFInAppEventType().getMonetizationNetwork;
                    AFc1dSDK aFc1dSDK = AFLogger.getMediationNetwork;
                    List<ResolveInfo> queryIntentContentProviders = context2.getPackageManager().queryIntentContentProviders(new Intent("com.appsflyer.referrer.INSTALL_PROVIDER"), 0);
                    if (queryIntentContentProviders != null && !queryIntentContentProviders.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (ResolveInfo resolveInfo : queryIntentContentProviders) {
                            AFInAppEventParameterName = (AFInAppEventType + 59) % 128;
                            ProviderInfo providerInfo = resolveInfo.providerInfo;
                            if (providerInfo != null) {
                                arrayList.add(new AFj1rSDK(providerInfo, AFAdRevenueData3, aFc1dSDK));
                            } else {
                                AFLogger.INSTANCE.w(AFg1cSDK.PREINSTALL, "com.appsflyer.referrer.INSTALL_PROVIDER Action is set for non ContentProvider component");
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            AFLogger.getCurrencyIso4217Code.addAll(arrayList);
                            AFLogger aFLogger = AFLogger.INSTANCE;
                            AFg1cSDK aFg1cSDK = AFg1cSDK.PREINSTALL;
                            StringBuilder sb = new StringBuilder("Detected ");
                            sb.append(arrayList.size());
                            sb.append(" valid preinstall provider(s)");
                            aFLogger.d(aFg1cSDK, sb.toString());
                        }
                    }
                }
                for (AFj1qSDK revenue : AFLogger.getRevenue()) {
                    AFInAppEventType = (AFInAppEventParameterName + 29) % 128;
                    revenue.getRevenue(AFLogger.getMediationNetwork.AFInAppEventType().getMonetizationNetwork);
                }
                aFa1tSDK.AFAdRevenueData().registerClient().AFAdRevenueData(aFa1tSDK.AFAdRevenueData().getRevenue());
                if (aFa1tSDK.AFAdRevenueData().afWarnLog().getCurrencyIso4217Code()) {
                    aFa1tSDK.AFAdRevenueData().afWarnLog().getMediationNetwork();
                }
            } else {
                AFLogger.INSTANCE.w(AFg1cSDK.REFERRER, "context is null, Google Install Referrer will be not initialized");
            }
            AFd1pSDK copy2 = aFa1tSDK.AFAdRevenueData().copy();
            if (appsFlyerConversionListener == null) {
                str = "null";
            } else {
                AFInAppEventParameterName = (AFInAppEventType + 101) % 128;
                str = "conversionDataListener";
            }
            copy2.getMediationNetwork("init", str2, str);
            AFLogger.INSTANCE.force(AFg1cSDK.GENERAL, "Initializing AppsFlyer SDK: (v6.17.0." + getMonetizationNetwork + ")");
            aFa1tSDK.getCurrencyIso4217Code = appsFlyerConversionListener;
            return aFa1tSDK;
        }
    }

    private static /* synthetic */ Object component4(Object[] objArr) {
        AFInAppEventType = (AFInAppEventParameterName + 123) % 128;
        AFa1oSDK d = objArr[0].AFAdRevenueData().d();
        d.getCurrencyIso4217Code = objArr[1];
        d.getRevenue = objArr[2];
        int i = AFInAppEventParameterName + 103;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            return null;
        }
        throw null;
    }

    private static /* synthetic */ Object copy(Object[] objArr) {
        AFa1tSDK aFa1tSDK = objArr[0];
        AFh1fSDK aFh1fSDK = new AFh1fSDK();
        aFh1fSDK.areAllFieldsValid = objArr[2];
        aFh1fSDK.getMonetizationNetwork = objArr[3];
        aFa1tSDK.getMonetizationNetwork((AFh1rSDK) aFh1fSDK, aFa1tSDK.component1(objArr[1]));
        int i = AFInAppEventParameterName + 15;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            int i2 = 49 / 0;
        }
        return null;
    }

    private static /* synthetic */ Object copydefault(Object[] objArr) {
        AFa1tSDK aFa1tSDK = objArr[0];
        Context context = objArr[1];
        int i = AFInAppEventParameterName + 1;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            aFa1tSDK.AFAdRevenueData().afDebugLog().AFAdRevenueData();
            AFInAppEventParameterName = (AFInAppEventType + 17) % 128;
            return null;
        }
        aFa1tSDK.AFAdRevenueData().afDebugLog().AFAdRevenueData();
        throw null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d_(Context context, Intent intent) {
        getMonetizationNetwork(new Object[]{this, context, intent}, 507699176, -507699170, System.identityHashCode(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void equals() {
        AFInAppEventType = (AFInAppEventParameterName + 27) % 128;
        AFAdRevenueData().AFInAppEventParameterName().AFAdRevenueData();
        component2();
        int i = AFInAppEventType + 17;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void getCurrencyIso4217Code(AFf1nSDK aFf1nSDK) {
        AFInAppEventParameterName = (AFInAppEventType + 1) % 128;
        AFc1dSDK AFAdRevenueData2 = AFAdRevenueData();
        if (aFf1nSDK == AFf1nSDK.SUCCESS) {
            int i = AFInAppEventParameterName + 75;
            AFInAppEventType = i % 128;
            if (i % 2 != 0) {
                AFAdRevenueData2.afRDLog().getCurrencyIso4217Code();
            } else {
                AFAdRevenueData2.afRDLog().getCurrencyIso4217Code();
                throw null;
            }
        }
        if (!(!AFAdRevenueData2.copy().getMonetizationNetwork())) {
            AFAdRevenueData2.v().AFAdRevenueData();
            return;
        }
        AFInAppEventParameterName = (AFInAppEventType + 69) % 128;
        AFAdRevenueData2.v().getMediationNetwork();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void getRevenue(AFc1dSDK aFc1dSDK) {
        int i = AFInAppEventParameterName + 95;
        AFInAppEventType = i % 128;
        int i2 = i % 2;
        aFc1dSDK.AFInAppEventParameterName().getMediationNetwork();
        if (i2 == 0) {
            throw null;
        }
    }

    private static /* synthetic */ Object hashCode(Object[] objArr) {
        AFa1tSDK aFa1tSDK = objArr[0];
        AFh1iSDK aFh1iSDK = new AFh1iSDK();
        aFa1tSDK.getMediationNetwork(objArr[1]);
        aFh1iSDK.areAllFieldsValid = null;
        aFh1iSDK.getMonetizationNetwork = null;
        aFh1iSDK.component3 = objArr[2];
        aFh1iSDK.getMediationNetwork = null;
        aFa1tSDK.AFAdRevenueData((AFh1rSDK) aFh1iSDK);
        int i = AFInAppEventParameterName + 101;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            int i2 = 32 / 0;
        }
        return null;
    }

    private static /* synthetic */ Object toString(Object[] objArr) {
        AFInAppEventParameterName = (AFInAppEventType + 71) % 128;
        objArr[0].start(objArr[1], objArr[2], (AppsFlyerRequestListener) null);
        int i = AFInAppEventParameterName + 65;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            return null;
        }
        throw null;
    }

    public final AFc1dSDK AFAdRevenueData() {
        int i = AFInAppEventParameterName;
        AFc1eSDK aFc1eSDK = this.copy;
        int i2 = i + 85;
        AFInAppEventType = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 84 / 0;
        }
        return aFc1eSDK;
    }

    public final void addPushNotificationDeepLinkPath(String... strArr) {
        AFInAppEventParameterName = (AFInAppEventType + 41) % 128;
        List asList = Arrays.asList(strArr);
        List<List<String>> list = AFAdRevenueData().d().getMediationNetwork;
        if (!list.contains(asList)) {
            list.add(asList);
        }
        AFInAppEventType = (AFInAppEventParameterName + 33) % 128;
    }

    public final void anonymizeUser(boolean z) {
        int i = AFInAppEventType + 1;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            AFd1pSDK copy2 = AFAdRevenueData().copy();
            String[] strArr = new String[0];
            strArr[1] = String.valueOf(z);
            copy2.getMediationNetwork("anonymizeUser", strArr);
        } else {
            AFAdRevenueData().copy().getMediationNetwork("anonymizeUser", String.valueOf(z));
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
        AFInAppEventParameterName = (AFInAppEventType + 69) % 128;
    }

    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        getMonetizationNetwork(new Object[]{this, str, map}, 1307261109, -1307261102, System.identityHashCode(this));
    }

    public final void b_(Context context, Intent intent) {
        AFj1jSDK aFj1jSDK = new AFj1jSDK(intent);
        if (aFj1jSDK.getRevenue("appsflyer_preinstall") != null) {
            getMonetizationNetwork(new Object[]{aFj1jSDK.getRevenue("appsflyer_preinstall")}, 998031041, -998031039, (int) System.currentTimeMillis());
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        String revenue = aFj1jSDK.getRevenue("referrer");
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(revenue)));
        if (revenue != null) {
            int i = AFInAppEventParameterName + 41;
            AFInAppEventType = i % 128;
            if (i % 2 != 0) {
                getRevenue(context).getMediationNetwork("referrer", revenue);
                AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
                instance.set("AF_REFERRER", revenue);
                instance.getMediationNetwork = revenue;
                if (AppsFlyerProperties.getInstance().AFAdRevenueData()) {
                    AFLogger.afInfoLog("onReceive: isLaunchCalled");
                    getCurrencyIso4217Code(context, AFh1xSDK.onReceive);
                    getMediationNetwork(revenue);
                }
            } else {
                getRevenue(context).getMediationNetwork("referrer", revenue);
                AppsFlyerProperties instance2 = AppsFlyerProperties.getInstance();
                instance2.set("AF_REFERRER", revenue);
                instance2.getMediationNetwork = revenue;
                AppsFlyerProperties.getInstance().AFAdRevenueData();
                throw null;
            }
        }
        int i2 = AFInAppEventType + 63;
        AFInAppEventParameterName = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    public final void disableAppSetId() {
        getMonetizationNetwork(new Object[]{this}, -2040336732, 2040336751, System.identityHashCode(this));
    }

    public final void enableFacebookDeferredApplinks(boolean z) {
        int i = AFInAppEventParameterName + 107;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            AFAdRevenueData().e().getCurrencyIso4217Code(z);
            int i2 = AFInAppEventType + 1;
            AFInAppEventParameterName = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
            return;
        }
        AFAdRevenueData().e().getCurrencyIso4217Code(z);
        throw null;
    }

    public final void enableTCFDataCollection(boolean z) {
        int i = AFInAppEventParameterName + 43;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            getMonetizationNetwork(new Object[]{AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION, Boolean.toString(z)}, -692563571, 692563575, (int) System.currentTimeMillis());
            int i2 = 36 / 0;
            return;
        }
        getMonetizationNetwork(new Object[]{AppsFlyerProperties.ENABLE_TCF_DATA_COLLECTION, Boolean.toString(z)}, -692563571, 692563575, (int) System.currentTimeMillis());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        getMediationNetwork(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        return com.appsflyer.internal.AFb1iSDK.getRevenue(AFAdRevenueData().getRevenue().getMonetizationNetwork);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001c, code lost:
        if (r4 == null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002c, code lost:
        if (r4 == null) goto L_0x002e;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getAppsFlyerUID(@androidx.annotation.NonNull android.content.Context r4) {
        /*
            r3 = this;
            int r0 = AFInAppEventParameterName
            int r0 = r0 + 103
            int r1 = r0 % 128
            AFInAppEventType = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = "getAppsFlyerUID"
            if (r0 != 0) goto L_0x001f
            com.appsflyer.internal.AFc1dSDK r0 = r3.AFAdRevenueData()
            com.appsflyer.internal.AFd1pSDK r0 = r0.copy()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.getMediationNetwork(r2, r1)
            if (r4 != 0) goto L_0x003d
            goto L_0x002e
        L_0x001f:
            com.appsflyer.internal.AFc1dSDK r0 = r3.AFAdRevenueData()
            com.appsflyer.internal.AFd1pSDK r0 = r0.copy()
            java.lang.String[] r1 = new java.lang.String[r1]
            r0.getMediationNetwork(r2, r1)
            if (r4 != 0) goto L_0x003d
        L_0x002e:
            int r4 = AFInAppEventType
            int r4 = r4 + 69
            int r0 = r4 % 128
            AFInAppEventParameterName = r0
            int r4 = r4 % 2
            r0 = 0
            if (r4 != 0) goto L_0x003c
            return r0
        L_0x003c:
            throw r0
        L_0x003d:
            r3.getMediationNetwork((android.content.Context) r4)
            com.appsflyer.internal.AFc1dSDK r4 = r3.AFAdRevenueData()
            com.appsflyer.internal.AFc1pSDK r4 = r4.getRevenue()
            com.appsflyer.internal.AFc1qSDK r4 = r4.getMonetizationNetwork
            java.lang.String r4 = com.appsflyer.internal.AFb1iSDK.getRevenue(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.getAppsFlyerUID(android.content.Context):java.lang.String");
    }

    public final String getAttributionId(Context context) {
        return (String) getMonetizationNetwork(new Object[]{this, context}, -1689317276, 1689317287, System.identityHashCode(this));
    }

    public final String getHostName() {
        AFInAppEventType = (AFInAppEventParameterName + 21) % 128;
        String mediationNetwork = AFAdRevenueData().AFKeystoreWrapper().getMediationNetwork();
        AFInAppEventType = (AFInAppEventParameterName + 71) % 128;
        return mediationNetwork;
    }

    public final String getHostPrefix() {
        AFInAppEventParameterName = (AFInAppEventType + 3) % 128;
        String currencyIso4217Code = AFAdRevenueData().AFKeystoreWrapper().getCurrencyIso4217Code();
        int i = AFInAppEventParameterName + 67;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            return currencyIso4217Code;
        }
        throw null;
    }

    public final void getMediationNetwork(@NonNull Context context) {
        int i = AFInAppEventType;
        AFInAppEventParameterName = (i + 121) % 128;
        AFc1eSDK aFc1eSDK = this.copy;
        if (context != null) {
            int i2 = (i + 113) % 128;
            AFInAppEventParameterName = i2;
            AFc1iSDK aFc1iSDK = aFc1eSDK.AFAdRevenueData;
            if (context != null) {
                AFInAppEventType = (i2 + 117) % 128;
                aFc1iSDK.getMonetizationNetwork = context.getApplicationContext();
                AFInAppEventType = (AFInAppEventParameterName + 19) % 128;
            }
        }
    }

    public final synchronized AFf1mSDK getMonetizationNetwork() {
        try {
            int i = AFInAppEventType;
            int i2 = i + 17;
            AFInAppEventParameterName = i2 % 128;
            if (i2 % 2 == 0) {
                if (this.equals == null) {
                    this.equals = new b(this);
                    AFInAppEventParameterName = (i + 119) % 128;
                }
            } else {
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.equals;
    }

    public final String getOutOfStore(Context context) {
        AFInAppEventParameterName = (AFInAppEventType + 115) % 128;
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_STORE_FROM_API);
        if (string != null) {
            AFInAppEventType = (AFInAppEventParameterName + 107) % 128;
            return string;
        }
        String revenue = getRevenue(context, "AF_STORE");
        if (revenue != null) {
            int i = AFInAppEventParameterName + 99;
            AFInAppEventType = i % 128;
            if (i % 2 == 0) {
                int i2 = 63 / 0;
            }
            return revenue;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    public final String getSdkVersion() {
        int i = AFInAppEventParameterName + 97;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            AFAdRevenueData().copy().getMediationNetwork("getSdkVersion", new String[1]);
        } else {
            AFAdRevenueData().copy().getMediationNetwork("getSdkVersion", new String[0]);
        }
        String component12 = AFc1pSDK.component1();
        AFInAppEventParameterName = (AFInAppEventType + 87) % 128;
        return component12;
    }

    public final AppsFlyerLib init(@NonNull String str, AppsFlyerConversionListener appsFlyerConversionListener, @NonNull Context context) {
        return (AppsFlyerLib) getMonetizationNetwork(new Object[]{this, str, appsFlyerConversionListener, context}, -235242605, 235242617, System.identityHashCode(this));
    }

    public final boolean isPreInstalledApp(Context context) {
        int i = AFInAppEventParameterName + 77;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            getMediationNetwork(context);
            AFAdRevenueData().getRevenue();
            return AFc1pSDK.AFAdRevenueData(context);
        }
        getMediationNetwork(context);
        AFAdRevenueData().getRevenue();
        AFc1pSDK.AFAdRevenueData(context);
        throw null;
    }

    @Deprecated
    public final boolean isStopped() {
        return ((Boolean) getMonetizationNetwork(new Object[]{this}, -1621727139, 1621727154, System.identityHashCode(this))).booleanValue();
    }

    public final void logAdRevenue(@NonNull AFAdRevenueData aFAdRevenueData, @Nullable Map<String, Object> map) {
        AFInAppEventType = (AFInAppEventParameterName + 95) % 128;
        if (!this.toString) {
            AFAdRevenueData("logAdRevenue");
        } else if (!aFAdRevenueData.areAllFieldsValid()) {
            int i = AFInAppEventType + 81;
            AFInAppEventParameterName = i % 128;
            if (i % 2 == 0) {
                AFLogger.INSTANCE.w(AFg1cSDK.AD_REVENUE, "Invalid ad revenue parameters provided");
                AFInAppEventType = (AFInAppEventParameterName + 111) % 128;
                return;
            }
            AFLogger.INSTANCE.w(AFg1cSDK.AD_REVENUE, "Invalid ad revenue parameters provided");
            throw null;
        } else if (AFAdRevenueData().registerClient().AFAdRevenueData()) {
            AFInAppEventParameterName = (AFInAppEventType + 93) % 128;
            AFLogger.INSTANCE.w(AFg1cSDK.AD_REVENUE, "SDK is stopped");
        } else if (AFk1ySDK.getMediationNetwork(AFAdRevenueData().registerClient().getMediationNetwork())) {
            AFInAppEventParameterName = (AFInAppEventType + 41) % 128;
            copy();
            int i2 = AFInAppEventParameterName + 51;
            AFInAppEventType = i2 % 128;
            if (i2 % 2 == 0) {
                int i3 = 27 / 0;
            }
        } else {
            AFAdRevenueData((AFh1rSDK) new AFh1lSDK(aFAdRevenueData, map));
        }
    }

    public final void logEvent(Context context, String str, Map<String, Object> map) {
        AFInAppEventParameterName = (AFInAppEventType + 103) % 128;
        logEvent(context, str, map, (AppsFlyerRequestListener) null);
        int i = AFInAppEventType + 57;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            int i2 = 63 / 0;
        }
    }

    public final void logLocation(Context context, double d, double d2) {
        AFAdRevenueData().copy().getMediationNetwork("logLocation", String.valueOf(d), String.valueOf(d2));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGITUDE, Double.toString(d2));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d));
        getMonetizationNetwork(new Object[]{this, context, AFInAppEventType.LOCATION_COORDINATES, hashMap}, 1732368696, -1732368678, System.identityHashCode(this));
        int i = AFInAppEventParameterName + 93;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            int i2 = 71 / 0;
        }
    }

    public final void logSession(Context context) {
        AFInAppEventParameterName = (AFInAppEventType + 67) % 128;
        AFAdRevenueData().copy().getMediationNetwork("logSession", new String[0]);
        AFAdRevenueData().copy().getCurrencyIso4217Code();
        getCurrencyIso4217Code(context, AFh1xSDK.logSession);
        getMonetizationNetwork(new Object[]{this, context, null, null}, 1732368696, -1732368678, System.identityHashCode(this));
        int i = AFInAppEventParameterName + 87;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            int i2 = 16 / 0;
        }
    }

    public final void onPause(Context context) {
        getMonetizationNetwork(new Object[]{this, context}, -1480636038, 1480636052, System.identityHashCode(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r5 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        if (r5 != null) goto L_0x0017;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void performOnAppAttribution(@androidx.annotation.NonNull android.content.Context r4, @androidx.annotation.NonNull java.net.URI r5) {
        /*
            r3 = this;
            int r0 = AFInAppEventParameterName
            int r0 = r0 + 35
            int r1 = r0 % 128
            AFInAppEventType = r1
            int r0 = r0 % 2
            java.lang.String r1 = "\""
            if (r0 != 0) goto L_0x0015
            r0 = 52
            int r0 = r0 / 0
            if (r5 == 0) goto L_0x006e
            goto L_0x0017
        L_0x0015:
            if (r5 == 0) goto L_0x006e
        L_0x0017:
            java.lang.String r0 = r5.toString()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0022
            goto L_0x006e
        L_0x0022:
            if (r4 != 0) goto L_0x0043
            com.appsflyer.internal.AFc1dSDK r5 = r3.AFAdRevenueData()
            com.appsflyer.internal.AFa1oSDK r5 = r5.d()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Context is \""
            r0.<init>(r2)
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            com.appsflyer.deeplink.DeepLinkResult$Error r0 = com.appsflyer.deeplink.DeepLinkResult.Error.NETWORK
            r5.AFAdRevenueData(r4, r0)
            return
        L_0x0043:
            r3.getMediationNetwork((android.content.Context) r4)
            com.appsflyer.internal.AFc1dSDK r4 = r3.AFAdRevenueData()
            com.appsflyer.internal.AFa1oSDK r4 = r4.d()
            com.appsflyer.internal.AFc1dSDK r0 = r3.AFAdRevenueData()
            com.appsflyer.internal.AFa1gSDK r0 = r0.afVerboseLog()
            com.appsflyer.internal.AFa1jSDK r0 = com.appsflyer.internal.AFa1jSDK.getCurrencyIso4217Code((com.appsflyer.internal.AFa1gSDK) r0)
            java.lang.String r5 = r5.toString()
            android.net.Uri r5 = android.net.Uri.parse(r5)
            r4.f_(r0, r5)
            int r4 = AFInAppEventType
            int r4 = r4 + 113
            int r4 = r4 % 128
            AFInAppEventParameterName = r4
            return
        L_0x006e:
            com.appsflyer.internal.AFc1dSDK r4 = r3.AFAdRevenueData()
            com.appsflyer.internal.AFa1oSDK r4 = r4.d()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Link is \""
            r0.<init>(r2)
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            com.appsflyer.deeplink.DeepLinkResult$Error r0 = com.appsflyer.deeplink.DeepLinkResult.Error.NETWORK
            r4.AFAdRevenueData(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.performOnAppAttribution(android.content.Context, java.net.URI):void");
    }

    public final void performOnDeepLinking(@NonNull Intent intent, @NonNull Context context) {
        int i = AFInAppEventType;
        int i2 = i + 55;
        AFInAppEventParameterName = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        } else if (intent == null) {
            AFAdRevenueData().d().AFAdRevenueData("performOnDeepLinking was called with null intent", DeepLinkResult.Error.DEVELOPER_ERROR);
        } else if (context == null) {
            AFInAppEventParameterName = (i + 29) % 128;
            AFAdRevenueData().d().AFAdRevenueData("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
        } else {
            Context applicationContext = context.getApplicationContext();
            getMediationNetwork(applicationContext);
            AFAdRevenueData().getMonetizationNetwork().execute(new m0(this, 18, applicationContext, intent));
            int i3 = AFInAppEventType + 59;
            AFInAppEventParameterName = i3 % 128;
            if (i3 % 2 != 0) {
                throw null;
            }
        }
    }

    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        int i = AFInAppEventType + 79;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            AFAdRevenueData().copy().getMediationNetwork("registerConversionListener", new String[0]);
        } else {
            AFAdRevenueData().copy().getMediationNetwork("registerConversionListener", new String[0]);
        }
        getRevenue(appsFlyerConversionListener);
    }

    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        AFAdRevenueData().copy().getMediationNetwork("registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            int i = AFInAppEventParameterName + 25;
            AFInAppEventType = i % 128;
            if (i % 2 != 0) {
                AFLogger.afDebugLog("registerValidatorListener null listener");
            } else {
                AFLogger.afDebugLog("registerValidatorListener null listener");
                throw null;
            }
        } else {
            AFAdRevenueData = appsFlyerInAppPurchaseValidatorListener;
            AFInAppEventParameterName = (AFInAppEventType + 11) % 128;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
        if (r4.AFAdRevenueData(r5, r6, r2) != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0038, code lost:
        if (r4.AFAdRevenueData(r5, r6, "purchases") != false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendInAppPurchaseData(android.content.Context r4, java.util.Map<java.lang.String, java.lang.Object> r5, com.appsflyer.PurchaseHandler.PurchaseValidationCallback r6) {
        /*
            r3 = this;
            int r0 = AFInAppEventParameterName
            int r0 = r0 + 101
            int r1 = r0 % 128
            AFInAppEventType = r1
            int r0 = r0 % 2
            java.lang.String r1 = "purchases"
            if (r0 != 0) goto L_0x0025
            r3.getMediationNetwork((android.content.Context) r4)
            com.appsflyer.internal.AFc1dSDK r4 = r3.AFAdRevenueData()
            com.appsflyer.PurchaseHandler r4 = r4.component4()
            r0 = 0
            java.lang.String[] r2 = new java.lang.String[r0]
            r2[r0] = r1
            boolean r0 = r4.AFAdRevenueData(r5, r6, r2)
            if (r0 == 0) goto L_0x004d
            goto L_0x003a
        L_0x0025:
            r3.getMediationNetwork((android.content.Context) r4)
            com.appsflyer.internal.AFc1dSDK r4 = r3.AFAdRevenueData()
            com.appsflyer.PurchaseHandler r4 = r4.component4()
            java.lang.String[] r0 = new java.lang.String[]{r1}
            boolean r0 = r4.AFAdRevenueData(r5, r6, r0)
            if (r0 == 0) goto L_0x004d
        L_0x003a:
            com.appsflyer.internal.AFe1cSDK r0 = new com.appsflyer.internal.AFe1cSDK
            com.appsflyer.internal.AFc1dSDK r1 = r4.getCurrencyIso4217Code
            r0.<init>(r5, r6, r1)
            com.appsflyer.internal.AFe1lSDK r4 = r4.getRevenue
            java.util.concurrent.Executor r5 = r4.getRevenue
            com.appsflyer.internal.AFe1lSDK$5 r6 = new com.appsflyer.internal.AFe1lSDK$5
            r6.<init>(r0)
            r5.execute(r6)
        L_0x004d:
            int r4 = AFInAppEventParameterName
            int r4 = r4 + 27
            int r5 = r4 % 128
            AFInAppEventType = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x005a
            return
        L_0x005a:
            r4 = 0
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.sendInAppPurchaseData(android.content.Context, java.util.Map, com.appsflyer.PurchaseHandler$PurchaseValidationCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
        if (r4.AFAdRevenueData(r5, r6, r0) != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0039, code lost:
        if (r4.AFAdRevenueData(r5, r6, "subscriptions") != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPurchaseData(android.content.Context r4, java.util.Map<java.lang.String, java.lang.Object> r5, com.appsflyer.PurchaseHandler.PurchaseValidationCallback r6) {
        /*
            r3 = this;
            int r0 = AFInAppEventParameterName
            int r0 = r0 + 43
            int r1 = r0 % 128
            AFInAppEventType = r1
            int r0 = r0 % 2
            java.lang.String r1 = "subscriptions"
            if (r0 != 0) goto L_0x0026
            r3.getMediationNetwork((android.content.Context) r4)
            com.appsflyer.internal.AFc1dSDK r4 = r3.AFAdRevenueData()
            com.appsflyer.PurchaseHandler r4 = r4.component4()
            r0 = 0
            java.lang.String[] r0 = new java.lang.String[r0]
            r2 = 1
            r0[r2] = r1
            boolean r0 = r4.AFAdRevenueData(r5, r6, r0)
            if (r0 == 0) goto L_0x004e
            goto L_0x003b
        L_0x0026:
            r3.getMediationNetwork((android.content.Context) r4)
            com.appsflyer.internal.AFc1dSDK r4 = r3.AFAdRevenueData()
            com.appsflyer.PurchaseHandler r4 = r4.component4()
            java.lang.String[] r0 = new java.lang.String[]{r1}
            boolean r0 = r4.AFAdRevenueData(r5, r6, r0)
            if (r0 == 0) goto L_0x004e
        L_0x003b:
            com.appsflyer.internal.AFe1hSDK r0 = new com.appsflyer.internal.AFe1hSDK
            com.appsflyer.internal.AFc1dSDK r1 = r4.getCurrencyIso4217Code
            r0.<init>(r5, r6, r1)
            com.appsflyer.internal.AFe1lSDK r4 = r4.getRevenue
            java.util.concurrent.Executor r5 = r4.getRevenue
            com.appsflyer.internal.AFe1lSDK$5 r6 = new com.appsflyer.internal.AFe1lSDK$5
            r6.<init>(r0)
            r5.execute(r6)
        L_0x004e:
            int r4 = AFInAppEventType
            int r4 = r4 + 21
            int r4 = r4 % 128
            AFInAppEventParameterName = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.sendPurchaseData(android.content.Context, java.util.Map, com.appsflyer.PurchaseHandler$PurchaseValidationCallback):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendPushNotificationData(@androidx.annotation.Nullable android.app.Activity r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = "c"
            java.lang.String r2 = "pid"
            java.lang.String r3 = "sendPushNotificationData"
            if (r18 == 0) goto L_0x0042
            int r4 = AFInAppEventParameterName
            int r4 = r4 + 119
            int r4 = r4 % 128
            AFInAppEventType = r4
            android.content.Intent r4 = r18.getIntent()
            if (r4 == 0) goto L_0x0042
            com.appsflyer.internal.AFc1dSDK r4 = r17.AFAdRevenueData()
            com.appsflyer.internal.AFd1pSDK r4 = r4.copy()
            java.lang.String r5 = r18.getLocalClassName()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "activity_intent_"
            r6.<init>(r7)
            android.content.Intent r7 = r18.getIntent()
            java.lang.String r7 = r7.toString()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String[] r5 = new java.lang.String[]{r5, r6}
            r4.getMediationNetwork(r3, r5)
            goto L_0x0073
        L_0x0042:
            if (r18 == 0) goto L_0x0062
            int r4 = AFInAppEventParameterName
            int r4 = r4 + 65
            int r4 = r4 % 128
            AFInAppEventType = r4
            com.appsflyer.internal.AFc1dSDK r4 = r17.AFAdRevenueData()
            com.appsflyer.internal.AFd1pSDK r4 = r4.copy()
            java.lang.String r5 = r18.getLocalClassName()
            java.lang.String r6 = "activity_intent_null"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6}
            r4.getMediationNetwork(r3, r5)
            goto L_0x0073
        L_0x0062:
            com.appsflyer.internal.AFc1dSDK r4 = r17.AFAdRevenueData()
            com.appsflyer.internal.AFd1pSDK r4 = r4.copy()
            java.lang.String r5 = "activity_null"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r4.getMediationNetwork(r3, r5)
        L_0x0073:
            com.appsflyer.internal.AFc1dSDK r3 = r17.AFAdRevenueData()
            com.appsflyer.internal.AFc1kSDK r3 = r3.afInfoLog()
            java.lang.String r4 = getMediationNetwork((android.app.Activity) r18)
            r3.getCurrencyIso4217Code = r4
            if (r4 == 0) goto L_0x0194
            long r4 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.copydefault
            java.lang.String r7 = ")"
            if (r6 != 0) goto L_0x009c
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.copydefault = r0
            r10 = r4
            goto L_0x014e
        L_0x009c:
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x013b }
            java.lang.String r8 = "pushPayloadMaxAging"
            r9 = 1800000(0x1b7740, double:8.89318E-318)
            long r8 = r6.getLong(r8, r9)     // Catch:{ all -> 0x013b }
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.copydefault     // Catch:{ all -> 0x013b }
            java.util.Set r6 = r6.keySet()     // Catch:{ all -> 0x013b }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x013b }
            r10 = r4
        L_0x00b4:
            boolean r12 = r6.hasNext()     // Catch:{ all -> 0x0112 }
            if (r12 == 0) goto L_0x014e
            java.lang.Object r12 = r6.next()     // Catch:{ all -> 0x0112 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0112 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x0112 }
            java.lang.String r14 = r3.getCurrencyIso4217Code     // Catch:{ all -> 0x0112 }
            r13.<init>(r14)     // Catch:{ all -> 0x0112 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x0112 }
            java.util.Map<java.lang.Long, java.lang.String> r15 = r1.copydefault     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r15.get(r12)     // Catch:{ all -> 0x0112 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0112 }
            r14.<init>(r15)     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r13.opt(r2)     // Catch:{ all -> 0x0112 }
            r16 = r6
            java.lang.Object r6 = r14.opt(r2)     // Catch:{ all -> 0x0112 }
            boolean r6 = r15.equals(r6)     // Catch:{ all -> 0x0112 }
            if (r6 == 0) goto L_0x0114
            java.lang.Object r6 = r13.opt(r0)     // Catch:{ all -> 0x0112 }
            java.lang.Object r15 = r14.opt(r0)     // Catch:{ all -> 0x0112 }
            boolean r6 = r6.equals(r15)     // Catch:{ all -> 0x0112 }
            if (r6 == 0) goto L_0x0114
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ all -> 0x0112 }
            r0.append(r14)     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ all -> 0x0112 }
            r0.append(r13)     // Catch:{ all -> 0x0112 }
            r0.append(r7)     // Catch:{ all -> 0x0112 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0112 }
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x0112 }
            r0 = 0
            r3.getCurrencyIso4217Code = r0     // Catch:{ all -> 0x0112 }
            return
        L_0x0112:
            r0 = move-exception
            goto L_0x013d
        L_0x0114:
            long r13 = r12.longValue()     // Catch:{ all -> 0x0112 }
            long r13 = r4 - r13
            int r6 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0123
            java.util.Map<java.lang.Long, java.lang.String> r6 = r1.copydefault     // Catch:{ all -> 0x0112 }
            r6.remove(r12)     // Catch:{ all -> 0x0112 }
        L_0x0123:
            long r13 = r12.longValue()     // Catch:{ all -> 0x0112 }
            int r6 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r6 > 0) goto L_0x012f
            long r10 = r12.longValue()     // Catch:{ all -> 0x0112 }
        L_0x012f:
            int r6 = AFInAppEventParameterName
            int r6 = r6 + 83
            int r6 = r6 % 128
            AFInAppEventType = r6
            r6 = r16
            goto L_0x00b4
        L_0x013b:
            r0 = move-exception
            r10 = r4
        L_0x013d:
            java.lang.Class r2 = r0.getClass()
            java.lang.String r2 = r2.getSimpleName()
            java.lang.String r6 = "Error while handling push notification measurement: "
            java.lang.String r2 = r6.concat(r2)
            com.appsflyer.AFLogger.afErrorLog(r2, r0)
        L_0x014e:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r6 = 2
            int r0 = r0.getInt(r2, r6)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.copydefault
            int r2 = r2.size()
            if (r2 != r0) goto L_0x017e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r10)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.copydefault
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            r0.remove(r2)
        L_0x017e:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.copydefault
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            java.lang.String r3 = r3.getCurrencyIso4217Code
            r0.put(r2, r3)
            r17.start(r18)
            int r0 = AFInAppEventType
            int r0 = r0 + 11
            int r0 = r0 % 128
            AFInAppEventParameterName = r0
        L_0x0194:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.sendPushNotificationData(android.app.Activity):void");
    }

    public final void setAdditionalData(Map<String, Object> map) {
        getMonetizationNetwork(new Object[]{this, map}, -2145945282, 2145945283, System.identityHashCode(this));
    }

    public final void setAndroidIdData(String str) {
        AFInAppEventParameterName = (AFInAppEventType + 13) % 128;
        AFAdRevenueData().copy().getMediationNetwork("setAndroidIdData", str);
        AFAdRevenueData().afInfoLog().AFAdRevenueData = str;
        int i = AFInAppEventType + 41;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            int i2 = 38 / 0;
        }
    }

    public final void setAppId(String str) {
        AFInAppEventParameterName = (AFInAppEventType + 53) % 128;
        AFAdRevenueData().copy().getMediationNetwork("setAppId", str);
        getMonetizationNetwork(new Object[]{"appid", str}, -692563571, 692563575, (int) System.currentTimeMillis());
        AFInAppEventType = (AFInAppEventParameterName + 95) % 128;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0092, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002d, code lost:
        if (r8 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x004a, code lost:
        if (r8 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0058, code lost:
        if (r8.equals(com.appsflyer.AppsFlyerProperties.getInstance().getString(com.appsflyer.AppsFlyerProperties.ONELINK_ID)) == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005a, code lost:
        com.appsflyer.AppsFlyerProperties.getInstance().remove(com.appsflyer.AppsFlyerProperties.ONELINK_DOMAIN);
        com.appsflyer.AppsFlyerProperties.getInstance().remove(com.appsflyer.AppsFlyerProperties.ONELINK_VERSION);
        com.appsflyer.AppsFlyerProperties.getInstance().remove(com.appsflyer.AppsFlyerProperties.ONELINK_SCHEME);
        AFInAppEventParameterName = (AFInAppEventType + 29) % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x007d, code lost:
        getMonetizationNetwork(new java.lang.Object[]{com.appsflyer.AppsFlyerProperties.ONELINK_ID, r8}, -692563571, 692563575, (int) java.lang.System.currentTimeMillis());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setAppInviteOneLink(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 1
            r1 = 2
            int r2 = AFInAppEventType
            int r2 = r2 + 15
            int r3 = r2 % 128
            AFInAppEventParameterName = r3
            int r2 = r2 % r1
            java.lang.String r3 = "oneLinkSlug"
            java.lang.String r4 = "setAppInviteOneLink = "
            java.lang.String r5 = "setAppInviteOneLink"
            if (r2 == 0) goto L_0x0030
            com.appsflyer.internal.AFc1dSDK r2 = r7.AFAdRevenueData()
            com.appsflyer.internal.AFd1pSDK r2 = r2.copy()
            java.lang.String[] r6 = new java.lang.String[r0]
            r6[r0] = r8
            r2.getMediationNetwork(r5, r6)
            java.lang.String r2 = java.lang.String.valueOf(r8)
            java.lang.String r2 = r4.concat(r2)
            com.appsflyer.AFLogger.afInfoLog(r2)
            if (r8 == 0) goto L_0x005a
            goto L_0x004c
        L_0x0030:
            com.appsflyer.internal.AFc1dSDK r2 = r7.AFAdRevenueData()
            com.appsflyer.internal.AFd1pSDK r2 = r2.copy()
            java.lang.String[] r6 = new java.lang.String[]{r8}
            r2.getMediationNetwork(r5, r6)
            java.lang.String r2 = java.lang.String.valueOf(r8)
            java.lang.String r2 = r4.concat(r2)
            com.appsflyer.AFLogger.afInfoLog(r2)
            if (r8 == 0) goto L_0x005a
        L_0x004c:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = r2.getString(r3)
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x007d
        L_0x005a:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r4 = "onelinkDomain"
            r2.remove(r4)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r4 = "onelinkVersion"
            r2.remove(r4)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r4 = "onelinkScheme"
            r2.remove(r4)
            int r2 = AFInAppEventType
            int r2 = r2 + 29
            int r2 = r2 % 128
            AFInAppEventParameterName = r2
        L_0x007d:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r3
            r1[r0] = r8
            long r2 = java.lang.System.currentTimeMillis()
            int r8 = (int) r2
            r0 = -692563571(0xffffffffd6b8518d, float:-1.01330199E14)
            r2 = 692563575(0x2947ae77, float:4.43382E-14)
            getMonetizationNetwork(r1, r0, r2, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.setAppInviteOneLink(java.lang.String):void");
    }

    public final void setCollectAndroidID(boolean z) {
        AFInAppEventParameterName = (AFInAppEventType + 99) % 128;
        AFAdRevenueData().copy().getMediationNetwork("setCollectAndroidID", String.valueOf(z));
        getMonetizationNetwork(new Object[]{AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z)}, -692563571, 692563575, (int) System.currentTimeMillis());
        getMonetizationNetwork(new Object[]{AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z)}, -692563571, 692563575, (int) System.currentTimeMillis());
        int i = AFInAppEventType + 109;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            int i2 = 3 / 0;
        }
    }

    public final void setCollectIMEI(boolean z) {
        AFInAppEventType = (AFInAppEventParameterName + 45) % 128;
        AFAdRevenueData().copy().getMediationNetwork("setCollectIMEI", String.valueOf(z));
        getMonetizationNetwork(new Object[]{AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z)}, -692563571, 692563575, (int) System.currentTimeMillis());
        getMonetizationNetwork(new Object[]{AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z)}, -692563571, 692563575, (int) System.currentTimeMillis());
        int i = AFInAppEventType + 117;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            int i2 = 95 / 0;
        }
    }

    @Deprecated
    public final void setCollectOaid(boolean z) {
        AFInAppEventType = (AFInAppEventParameterName + 125) % 128;
        AFAdRevenueData().copy().getMediationNetwork("setCollectOaid", String.valueOf(z));
        getMonetizationNetwork(new Object[]{AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z)}, -692563571, 692563575, (int) System.currentTimeMillis());
        int i = AFInAppEventType + 85;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            int i2 = 31 / 0;
        }
    }

    public final void setConsentData(@NonNull AppsFlyerConsent appsFlyerConsent) {
        AFInAppEventParameterName = (AFInAppEventType + 77) % 128;
        Objects.requireNonNull(appsFlyerConsent);
        AFAdRevenueData().afInfoLog().component2 = appsFlyerConsent;
        AFInAppEventType = (AFInAppEventParameterName + 45) % 128;
    }

    public final void setCurrencyCode(String str) {
        AFInAppEventParameterName = (AFInAppEventType + 73) % 128;
        AFAdRevenueData().copy().getMediationNetwork("setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
        AFInAppEventType = (AFInAppEventParameterName + 9) % 128;
    }

    public final void setCustomerIdAndLogSession(String str, @NonNull Context context) {
        if (context == null) {
            return;
        }
        if (getMediationNetwork()) {
            setCustomerUserId(str);
            StringBuilder sb = new StringBuilder("CustomerUserId set: ");
            sb.append(str);
            sb.append(" - Initializing AppsFlyer Tacking");
            AFLogger.afInfoLog(sb.toString(), true);
            String referrer = AppsFlyerProperties.getInstance().getReferrer(AFAdRevenueData().component2());
            getCurrencyIso4217Code(context, AFh1xSDK.setCustomerIdAndLogSession);
            AFAdRevenueData().registerClient().getMediationNetwork();
            if (referrer == null) {
                AFInAppEventType = (AFInAppEventParameterName + 35) % 128;
                referrer = "";
            }
            if (context instanceof Activity) {
                ((Activity) context).getIntent();
                AFInAppEventType = (AFInAppEventParameterName + 107) % 128;
            }
            getMonetizationNetwork(new Object[]{this, context, referrer}, 1659672083, -1659672066, System.identityHashCode(this));
            return;
        }
        setCustomerUserId(str);
        AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
    }

    public final void setCustomerUserId(String str) {
        AFInAppEventParameterName = (AFInAppEventType + 65) % 128;
        AFAdRevenueData().copy().getMediationNetwork("setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        getMonetizationNetwork(new Object[]{AppsFlyerProperties.APP_USER_ID, str}, -692563571, 692563575, (int) System.currentTimeMillis());
        getCurrencyIso4217Code(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
        AFInAppEventParameterName = (AFInAppEventType + 33) % 128;
    }

    public final void setDebugLog(boolean z) {
        AFLogger.LogLevel logLevel;
        AFInAppEventType = (AFInAppEventParameterName + 115) % 128;
        if (z) {
            logLevel = AFLogger.LogLevel.DEBUG;
            AFInAppEventParameterName = (AFInAppEventType + 101) % 128;
        } else {
            logLevel = AFLogger.LogLevel.NONE;
        }
        setLogLevel(logLevel);
    }

    public final void setDisableAdvertisingIdentifiers(boolean z) {
        getMonetizationNetwork(new Object[]{this, Boolean.valueOf(z)}, 2015599714, -2015599705, System.identityHashCode(this));
    }

    public final void setDisableNetworkData(boolean z) {
        AFInAppEventType = (AFInAppEventParameterName + 61) % 128;
        AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(z)));
        getCurrencyIso4217Code(AppsFlyerProperties.DISABLE_NETWORK_DATA, z);
        AFInAppEventParameterName = (AFInAppEventType + 19) % 128;
    }

    public final void setExtension(String str) {
        int i = AFInAppEventParameterName + 101;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            AFd1pSDK copy2 = AFAdRevenueData().copy();
            String[] strArr = new String[0];
            strArr[0] = str;
            copy2.getMediationNetwork("setExtension", strArr);
        } else {
            AFAdRevenueData().copy().getMediationNetwork("setExtension", str);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
        int i2 = AFInAppEventParameterName + 1;
        AFInAppEventType = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    public final void setHost(@Nullable String str, @NonNull String str2) {
        String str3;
        AFInAppEventType = (AFInAppEventParameterName + 13) % 128;
        if (!AFk1ySDK.getCurrencyIso4217Code(str2)) {
            int i = AFInAppEventType + 27;
            AFInAppEventParameterName = i % 128;
            if (i % 2 == 0) {
                if (str != null) {
                    str3 = str.trim();
                } else {
                    str3 = "";
                }
                AFe1zSDK.getMediationNetwork(new AFe1vSDK(str3, str2.trim()));
                return;
            }
            throw null;
        }
        AFLogger.afWarnLog("hostname was empty or null - call for setHost is skipped");
    }

    public final void setImeiData(String str) {
        AFInAppEventParameterName = (AFInAppEventType + 37) % 128;
        AFAdRevenueData().copy().getMediationNetwork("setImeiData", str);
        AFAdRevenueData().registerClient().getMediationNetwork(str);
        AFInAppEventType = (AFInAppEventParameterName + 125) % 128;
    }

    public final void setInstallId(@NonNull String str) {
        AFAdRevenueData().copy().getMediationNetwork("setInstallId", new String[0]);
        if (!this.toString) {
            AFLogger.INSTANCE.d(AFg1cSDK.GENERAL, "AppsFlyerLib.init() method should be called first");
        } else if (!AFAdRevenueData().getRevenue().getMonetizationNetwork("APPSFLYER_ALLOW_CUSTOM_INSTALL_ID", false)) {
            AFLogger.INSTANCE.d(AFg1cSDK.GENERAL, "APPSFLYER_ALLOW_CUSTOM_INSTALL_ID Manifest flag should be set to true first");
        } else if (str == null) {
            AFLogger.INSTANCE.d(AFg1cSDK.GENERAL, "AppsFlyer installId can't be null");
            AFInAppEventParameterName = (AFInAppEventType + 95) % 128;
        } else {
            AFb1iSDK.getCurrencyIso4217Code(str, AFAdRevenueData().component2());
            int i = AFInAppEventType + 25;
            AFInAppEventParameterName = i % 128;
            if (i % 2 != 0) {
                throw null;
            }
        }
    }

    public final void setIsUpdate(boolean z) {
        int i = AFInAppEventParameterName + 31;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            AFd1pSDK copy2 = AFAdRevenueData().copy();
            String[] strArr = new String[0];
            strArr[1] = String.valueOf(z);
            copy2.getMediationNetwork("setIsUpdate", strArr);
        } else {
            AFAdRevenueData().copy().getMediationNetwork("setIsUpdate", String.valueOf(z));
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
        AFInAppEventType = (AFInAppEventParameterName + 51) % 128;
    }

    public final void setLogLevel(@NonNull AFLogger.LogLevel logLevel) {
        boolean z;
        if (logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel()) {
            z = true;
        } else {
            AFInAppEventType = (AFInAppEventParameterName + 51) % 128;
            z = false;
        }
        AFAdRevenueData().copy().getMediationNetwork("log", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
        if (!z) {
            int i = AFInAppEventParameterName + 121;
            AFInAppEventType = i % 128;
            if (i % 2 != 0) {
                AFAdRevenueData().v().getMonetizationNetwork();
            } else {
                AFAdRevenueData().v().getMonetizationNetwork();
                throw null;
            }
        } else {
            AFAdRevenueData().v().component4();
        }
    }

    public final void setMinTimeBetweenSessions(int i) {
        int i2 = AFInAppEventParameterName + 5;
        AFInAppEventType = i2 % 128;
        if (i2 % 2 == 0) {
            this.component3 = TimeUnit.SECONDS.toMillis((long) i);
            int i3 = 15 / 0;
            return;
        }
        this.component3 = TimeUnit.SECONDS.toMillis((long) i);
    }

    public final void setOaidData(String str) {
        int i = AFInAppEventType + 85;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            AFd1pSDK copy2 = AFAdRevenueData().copy();
            String[] strArr = new String[1];
            strArr[1] = str;
            copy2.getMediationNetwork("setOaidData", strArr);
        } else {
            AFAdRevenueData().copy().getMediationNetwork("setOaidData", str);
        }
        AFb1jSDK.getMonetizationNetwork = str;
        AFInAppEventParameterName = (AFInAppEventType + 103) % 128;
    }

    public final void setOneLinkCustomDomain(String... strArr) {
        String str;
        int i = AFInAppEventParameterName + 125;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            Object[] objArr = new Object[0];
            objArr[1] = Arrays.toString(strArr);
            str = String.format("setOneLinkCustomDomain %s", objArr);
        } else {
            str = "setOneLinkCustomDomain " + Arrays.toString(strArr);
        }
        AFLogger.afDebugLog(str);
        AFAdRevenueData().d().component4 = strArr;
    }

    public final void setOutOfStore(String str) {
        String concat;
        int i = AFInAppEventParameterName + 81;
        int i2 = i % 128;
        AFInAppEventType = i2;
        if (i % 2 != 0) {
            boolean z = true;
            if (str != null) {
                int i3 = i2 + 25;
                AFInAppEventParameterName = i3 % 128;
                if (i3 % 2 != 0) {
                    String lowerCase = str.toLowerCase(Locale.getDefault());
                    AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_STORE_FROM_API, lowerCase);
                    concat = "Store API set with value: ".concat(String.valueOf(lowerCase));
                    z = false;
                } else {
                    String lowerCase2 = str.toLowerCase(Locale.getDefault());
                    AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_STORE_FROM_API, lowerCase2);
                    concat = "Store API set with value: ".concat(String.valueOf(lowerCase2));
                }
                AFLogger.afInfoLog(concat, z);
                return;
            }
            AFLogger.afWarnLog("Cannot set setOutOfStore with null", true);
            return;
        }
        throw null;
    }

    public final void setPartnerData(@NonNull String str, Map<String, Object> map) {
        getMonetizationNetwork(new Object[]{this, str, map}, 841587779, -841587759, System.identityHashCode(this));
    }

    public final void setPhoneNumber(String str) {
        int i = AFInAppEventParameterName + 113;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            AFAdRevenueData().afInfoLog().getMediationNetwork = AFj1cSDK.getMonetizationNetwork(str);
            return;
        }
        AFAdRevenueData().afInfoLog().getMediationNetwork = AFj1cSDK.getMonetizationNetwork(str);
        throw null;
    }

    public final void setPluginInfo(@NonNull PluginInfo pluginInfo) {
        int i = AFInAppEventType + 71;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            Objects.requireNonNull(pluginInfo);
            AFAdRevenueData().unregisterClient().AFAdRevenueData(pluginInfo);
            int i2 = 39 / 0;
        } else {
            Objects.requireNonNull(pluginInfo);
            AFAdRevenueData().unregisterClient().AFAdRevenueData(pluginInfo);
        }
        int i3 = AFInAppEventParameterName + 95;
        AFInAppEventType = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 38 / 0;
        }
    }

    public final void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            int i = AFInAppEventType + 3;
            AFInAppEventParameterName = i % 128;
            if (i % 2 != 0) {
                try {
                    jSONObject.put("pid", str);
                    int i2 = 70 / 0;
                } catch (JSONException e) {
                    AFLogger.afErrorLog(e.getMessage(), e);
                }
            } else {
                jSONObject.put("pid", str);
            }
        }
        if (str2 != null) {
            jSONObject.put("c", str2);
        }
        if (str3 != null) {
            jSONObject.put("af_siteid", str3);
        }
        if (jSONObject.has("pid")) {
            AFInAppEventType = (AFInAppEventParameterName + 85) % 128;
            getMonetizationNetwork(new Object[]{"preInstallName", jSONObject.toString()}, -692563571, 692563575, (int) System.currentTimeMillis());
            return;
        }
        AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
        int i3 = AFInAppEventType + 5;
        AFInAppEventParameterName = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 19 / 0;
        }
    }

    public final void setResolveDeepLinkURLs(String... strArr) {
        AFInAppEventType = (AFInAppEventParameterName + 9) % 128;
        String arrays = Arrays.toString(strArr);
        AFLogger.afDebugLog("setResolveDeepLinkURLs " + arrays);
        AFa1oSDK d = AFAdRevenueData().d();
        d.component2.clear();
        d.component2.addAll(Arrays.asList(strArr));
        AFInAppEventParameterName = (AFInAppEventType + 41) % 128;
    }

    @Deprecated
    public final void setSharingFilter(@NonNull String... strArr) {
        AFInAppEventType = (AFInAppEventParameterName + 9) % 128;
        setSharingFilterForPartners(strArr);
        int i = AFInAppEventParameterName + 9;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            throw null;
        }
    }

    @Deprecated
    public final void setSharingFilterForAllPartners() {
        int i = AFInAppEventType + 87;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            setSharingFilterForPartners("all");
        } else {
            setSharingFilterForPartners("all");
        }
        int i2 = AFInAppEventParameterName + 27;
        AFInAppEventType = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    public final void setSharingFilterForPartners(String... strArr) {
        AFAdRevenueData().afInfoLog().getRevenue = new AFb1uSDK(strArr);
        AFInAppEventParameterName = (AFInAppEventType + 77) % 128;
    }

    public final void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        getMonetizationNetwork(new Object[]{this, emailsCryptType, strArr}, -363126917, 363126927, System.identityHashCode(this));
    }

    public final void start(@NonNull Context context) {
        AFInAppEventType = (AFInAppEventParameterName + 15) % 128;
        start(context, (String) null);
        AFInAppEventType = (AFInAppEventParameterName + 107) % 128;
    }

    public final void stop(boolean z, Context context) {
        AFc1qSDK component22;
        boolean z2;
        getMediationNetwork(context);
        AFc1dSDK AFAdRevenueData2 = AFAdRevenueData();
        AFAdRevenueData2.registerClient().getMediationNetwork(z);
        AFAdRevenueData2.getMonetizationNetwork().submit(new d(AFAdRevenueData2, 0));
        if (z) {
            int i = AFInAppEventParameterName + 15;
            AFInAppEventType = i % 128;
            if (i % 2 == 0) {
                component22 = AFAdRevenueData2.component2();
                z2 = false;
            } else {
                component22 = AFAdRevenueData2.component2();
                z2 = true;
            }
            component22.getCurrencyIso4217Code("is_stop_tracking_used", z2);
        }
        AFInAppEventParameterName = (AFInAppEventType + 51) % 128;
    }

    public final void subscribeForDeepLink(@NonNull DeepLinkListener deepLinkListener) {
        AFInAppEventParameterName = (AFInAppEventType + 47) % 128;
        subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3));
        AFInAppEventParameterName = (AFInAppEventType + 3) % 128;
    }

    public final void unregisterConversionListener() {
        AFInAppEventParameterName = (AFInAppEventType + 79) % 128;
        AFAdRevenueData().copy().getMediationNetwork("unregisterConversionListener", new String[0]);
        this.getCurrencyIso4217Code = null;
        int i = AFInAppEventType + 75;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            throw null;
        }
    }

    public final void updateServerUninstallToken(Context context, String str) {
        boolean z;
        getMediationNetwork(context);
        AFg1ySDK aFg1ySDK = new AFg1ySDK(context);
        if (str == null || str.trim().isEmpty()) {
            AFLogger.INSTANCE.w(AFg1cSDK.UNINSTALL, "Firebase Token is either empty or null and was not registered.");
            return;
        }
        AFLogger.INSTANCE.i(AFg1cSDK.UNINSTALL, "Firebase Refreshed Token = ".concat(str));
        AFf1aSDK revenue = aFg1ySDK.getRevenue();
        if (revenue == null || !str.equals(revenue.getRevenue)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (revenue == null || currentTimeMillis - revenue.AFAdRevenueData > TimeUnit.SECONDS.toMillis(2)) {
                z = true;
            } else {
                z = false;
            }
            AFf1aSDK aFf1aSDK = new AFf1aSDK(str, currentTimeMillis, !z);
            aFg1ySDK.AFAdRevenueData.getMediationNetwork("afUninstallToken", aFf1aSDK.getRevenue);
            aFg1ySDK.AFAdRevenueData.getMonetizationNetwork("afUninstallToken_received_time", aFf1aSDK.AFAdRevenueData);
            aFg1ySDK.AFAdRevenueData.getCurrencyIso4217Code("afUninstallToken_queued", aFf1aSDK.getMediationNetwork);
            if (z) {
                AFc1dSDK AFAdRevenueData2 = ((AFa1tSDK) getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).AFAdRevenueData();
                AFf1tSDK aFf1tSDK = new AFf1tSDK(str, AFAdRevenueData2);
                AFe1lSDK copydefault2 = AFAdRevenueData2.copydefault();
                copydefault2.getRevenue.execute(new Runnable(aFf1tSDK) {
                    private /* synthetic */ AFe1sSDK getMonetizationNetwork;

                    /*  JADX ERROR: Method generation error
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                    /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                    public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFe1lSDK.5.run():void, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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

    public final void validateAndLogInAppPurchase(@NonNull AFPurchaseDetails aFPurchaseDetails, @Nullable Map<String, String> map, @Nullable AppsFlyerInAppPurchaseValidationCallback appsFlyerInAppPurchaseValidationCallback) {
        AFe1lSDK copydefault2 = this.copy.copydefault();
        copydefault2.getRevenue.execute(new Runnable(new AFe1fSDK(this.copy, AppsFlyerProperties.getInstance(), aFPurchaseDetails, map, appsFlyerInAppPurchaseValidationCallback)) {
            private /* synthetic */ AFe1sSDK getMonetizationNetwork;

            /*  JADX ERROR: Method generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
            /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
            public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFe1lSDK.5.run():void, dex: classes.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
        AFInAppEventType = (AFInAppEventParameterName + 65) % 128;
    }

    public final void waitForCustomerUserId(boolean z) {
        AFInAppEventParameterName = (AFInAppEventType + 1) % 128;
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        getCurrencyIso4217Code(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
        AFInAppEventParameterName = (AFInAppEventType + 39) % 128;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void AFAdRevenueData(AFi1fSDK aFi1fSDK) {
        AFf1wSDK aFf1wSDK = new AFf1wSDK(aFi1fSDK, AFAdRevenueData().getRevenue(), AFAdRevenueData());
        AFe1lSDK copydefault2 = AFAdRevenueData().copydefault();
        copydefault2.getRevenue.execute(new Runnable(aFf1wSDK) {
            private /* synthetic */ AFe1sSDK getMonetizationNetwork;

            /*  JADX ERROR: Method generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
            /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
            public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFe1lSDK.5.run():void, dex: classes.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
        int i = AFInAppEventType + 111;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            int i2 = 50 / 0;
        }
    }

    private static void a(int[] iArr, int i, Object[] objArr) {
        int[] iArr2 = iArr;
        AFk1kSDK aFk1kSDK = new AFk1kSDK();
        char[] cArr = new char[4];
        char[] cArr2 = new char[(iArr2.length * 2)];
        int[] iArr3 = AFKeystoreWrapper;
        if (iArr3 != null) {
            int length = iArr3.length;
            int[] iArr4 = new int[length];
            int i2 = 0;
            while (i2 < length) {
                int i3 = ($11 + 113) % 128;
                $10 = i3;
                iArr4[i2] = (int) (((long) iArr3[i2]) ^ 3670241895213185600L);
                i2++;
                $11 = (i3 + 83) % 128;
            }
            iArr3 = iArr4;
        }
        int length2 = iArr3.length;
        int[] iArr5 = new int[length2];
        int[] iArr6 = AFKeystoreWrapper;
        if (iArr6 != null) {
            int length3 = iArr6.length;
            int[] iArr7 = new int[length3];
            for (int i4 = 0; i4 < length3; i4++) {
                iArr7[i4] = (int) (((long) iArr6[i4]) ^ 3670241895213185600L);
            }
            iArr6 = iArr7;
        }
        System.arraycopy(iArr6, 0, iArr5, 0, length2);
        aFk1kSDK.getCurrencyIso4217Code = 0;
        $10 = ($11 + 21) % 128;
        while (true) {
            int i5 = aFk1kSDK.getCurrencyIso4217Code;
            if (i5 < iArr2.length) {
                int i6 = iArr2[i5];
                char c = (char) (i6 >> 16);
                cArr[0] = c;
                char c2 = (char) i6;
                cArr[1] = c2;
                char c3 = (char) (iArr2[i5 + 1] >> 16);
                cArr[2] = c3;
                char c4 = (char) iArr2[i5 + 1];
                cArr[3] = c4;
                aFk1kSDK.AFAdRevenueData = (c << 16) + c2;
                aFk1kSDK.getMonetizationNetwork = (c3 << 16) + c4;
                AFk1kSDK.getMediationNetwork(iArr5);
                for (int i7 = 0; i7 < 16; i7++) {
                    $11 = ($10 + 47) % 128;
                    int i8 = aFk1kSDK.AFAdRevenueData ^ iArr5[i7];
                    aFk1kSDK.AFAdRevenueData = i8;
                    int AFAdRevenueData2 = AFk1kSDK.AFAdRevenueData(i8) ^ aFk1kSDK.getMonetizationNetwork;
                    int i9 = aFk1kSDK.AFAdRevenueData;
                    aFk1kSDK.AFAdRevenueData = AFAdRevenueData2;
                    aFk1kSDK.getMonetizationNetwork = i9;
                }
                int i10 = aFk1kSDK.AFAdRevenueData;
                int i11 = aFk1kSDK.getMonetizationNetwork;
                aFk1kSDK.AFAdRevenueData = i11;
                aFk1kSDK.getMonetizationNetwork = i10;
                int i12 = i10 ^ iArr5[16];
                aFk1kSDK.getMonetizationNetwork = i12;
                int i13 = i11 ^ iArr5[17];
                aFk1kSDK.AFAdRevenueData = i13;
                cArr[0] = (char) (i13 >>> 16);
                cArr[1] = (char) i13;
                cArr[2] = (char) (i12 >>> 16);
                cArr[3] = (char) i12;
                AFk1kSDK.getMediationNetwork(iArr5);
                int i14 = aFk1kSDK.getCurrencyIso4217Code;
                cArr2[i14 * 2] = cArr[0];
                cArr2[(i14 * 2) + 1] = cArr[1];
                cArr2[(i14 * 2) + 2] = cArr[2];
                cArr2[(i14 * 2) + 3] = cArr[3];
                aFk1kSDK.getCurrencyIso4217Code = i14 + 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }

    public static String getRevenue() {
        AFInAppEventType = (AFInAppEventParameterName + 61) % 128;
        String monetizationNetwork = getMonetizationNetwork(AppsFlyerProperties.APP_USER_ID);
        AFInAppEventType = (AFInAppEventParameterName + 11) % 128;
        return monetizationNetwork;
    }

    public final void setUserEmails(String... strArr) {
        getMonetizationNetwork(new Object[]{this, strArr}, 1505056603, -1505056581, System.identityHashCode(this));
    }

    private void getRevenue(AppsFlyerConversionListener appsFlyerConversionListener) {
        int i = AFInAppEventParameterName + 113;
        int i2 = i % 128;
        AFInAppEventType = i2;
        if (i % 2 == 0) {
            throw null;
        } else if (appsFlyerConversionListener == null) {
            AFInAppEventParameterName = (i2 + 125) % 128;
        } else {
            this.getCurrencyIso4217Code = appsFlyerConversionListener;
        }
    }

    public final void logEvent(@NonNull Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        HashMap hashMap = map == null ? null : new HashMap(map);
        getMediationNetwork(context);
        AFh1fSDK aFh1fSDK = new AFh1fSDK();
        aFh1fSDK.areAllFieldsValid = str;
        aFh1fSDK.getCurrencyIso4217Code = appsFlyerRequestListener;
        if (hashMap != null && hashMap.containsKey(AFInAppEventParameterName.TOUCH_OBJ)) {
            HashMap hashMap2 = new HashMap();
            Object obj = hashMap.get(AFInAppEventParameterName.TOUCH_OBJ);
            if (obj instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) obj;
                HashMap hashMap3 = new HashMap();
                hashMap3.put("x", Float.valueOf(motionEvent.getX()));
                hashMap3.put("y", Float.valueOf(motionEvent.getY()));
                hashMap2.put("loc", hashMap3);
                hashMap2.put("pf", Float.valueOf(motionEvent.getPressure()));
                hashMap2.put("rad", Float.valueOf(motionEvent.getTouchMajor() / 2.0f));
            } else {
                hashMap2.put("error", "Parsing failed due to invalid input in 'af_touch_obj'.");
                AFLogger.INSTANCE.w(AFg1cSDK.PREDICT, "Parsing failed due to invalid input in 'af_touch_obj'.", true);
            }
            Map singletonMap = Collections.singletonMap("tch_data", hashMap2);
            hashMap.remove(AFInAppEventParameterName.TOUCH_OBJ);
            aFh1fSDK.getMediationNetwork(singletonMap);
        }
        aFh1fSDK.getMonetizationNetwork = hashMap;
        AFd1pSDK copy2 = AFAdRevenueData().copy();
        Map map2 = aFh1fSDK.getMonetizationNetwork;
        if (map2 == null) {
            map2 = new HashMap();
        }
        copy2.getMediationNetwork("logEvent", str, new JSONObject(map2).toString());
        if (str == null) {
            getCurrencyIso4217Code(context, AFh1xSDK.logEvent);
        }
        getMonetizationNetwork((AFh1rSDK) aFh1fSDK, component1(context));
    }

    public final void start(@NonNull Context context, String str, AppsFlyerRequestListener appsFlyerRequestListener) {
        getMonetizationNetwork(new Object[]{this, context, str, appsFlyerRequestListener}, -1542206359, 1542206364, System.identityHashCode(this));
    }

    public final void subscribeForDeepLink(@NonNull DeepLinkListener deepLinkListener, long j) {
        AFInAppEventType = (AFInAppEventParameterName + 7) % 128;
        AFAdRevenueData().d().getMonetizationNetwork = deepLinkListener;
        AFAdRevenueData().d().component3 = j;
        AFInAppEventParameterName = (AFInAppEventType + 7) % 128;
    }

    private static /* synthetic */ Object equals(Object[] objArr) {
        AFInAppEventParameterName = (AFInAppEventType + 115) % 128;
        boolean AFAdRevenueData2 = objArr[0].AFAdRevenueData().registerClient().AFAdRevenueData();
        int i = AFInAppEventType + 9;
        AFInAppEventParameterName = i % 128;
        if (i % 2 == 0) {
            return Boolean.valueOf(AFAdRevenueData2);
        }
        int i2 = 9 / 0;
        return Boolean.valueOf(AFAdRevenueData2);
    }

    public final void start(@NonNull Context context, String str) {
        getMonetizationNetwork(new Object[]{this, context, str}, -1758296594, 1758296610, System.identityHashCode(this));
    }

    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        getMonetizationNetwork(new Object[]{this, context, str, str2, str3, str4, str5, map}, 203099708, -203099705, System.identityHashCode(this));
    }

    private static /* synthetic */ Object component1(Object[] objArr) {
        Context context = objArr[0];
        AFInAppEventParameterName = (AFInAppEventType + 105) % 128;
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                int i = AFInAppEventParameterName + 35;
                AFInAppEventType = i % 128;
                return i % 2 == 0 ? Boolean.FALSE : Boolean.TRUE;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return Boolean.TRUE;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "WARNING:  Google Play Services is unavailable. ", e);
            return Boolean.FALSE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0044, code lost:
        if (r3.contains("android.permission.INTERNET") == false) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A[Catch:{ Exception -> 0x0029 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void component4(android.content.Context r3) {
        /*
            int r0 = AFInAppEventParameterName
            int r0 = r0 + 5
            int r1 = r0 % 128
            AFInAppEventType = r1
            int r0 = r0 % 2
            java.lang.String r1 = "android.permission.INTERNET"
            if (r0 != 0) goto L_0x002c
            android.content.pm.PackageManager r0 = r3.getPackageManager()     // Catch:{ Exception -> 0x0029 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x0029 }
            r2 = 13800(0x35e8, float:1.9338E-41)
            android.content.pm.PackageInfo r3 = r0.getPackageInfo(r3, r2)     // Catch:{ Exception -> 0x0029 }
            java.lang.String[] r3 = r3.requestedPermissions     // Catch:{ Exception -> 0x0029 }
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch:{ Exception -> 0x0029 }
            boolean r0 = r3.contains(r1)     // Catch:{ Exception -> 0x0029 }
            if (r0 != 0) goto L_0x004f
            goto L_0x0046
        L_0x0029:
            r3 = move-exception
            goto L_0x00a1
        L_0x002c:
            android.content.pm.PackageManager r0 = r3.getPackageManager()     // Catch:{ Exception -> 0x0029 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x0029 }
            r2 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r3 = r0.getPackageInfo(r3, r2)     // Catch:{ Exception -> 0x0029 }
            java.lang.String[] r3 = r3.requestedPermissions     // Catch:{ Exception -> 0x0029 }
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch:{ Exception -> 0x0029 }
            boolean r0 = r3.contains(r1)     // Catch:{ Exception -> 0x0029 }
            if (r0 != 0) goto L_0x004f
        L_0x0046:
            com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ Exception -> 0x0029 }
            com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.GENERAL     // Catch:{ Exception -> 0x0029 }
            java.lang.String r2 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            r0.w(r1, r2)     // Catch:{ Exception -> 0x0029 }
        L_0x004f:
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r0 = r3.contains(r0)     // Catch:{ Exception -> 0x0029 }
            if (r0 != 0) goto L_0x0078
            int r0 = AFInAppEventType
            int r0 = r0 + 23
            int r1 = r0 % 128
            AFInAppEventParameterName = r1
            int r0 = r0 % 2
            java.lang.String r1 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            if (r0 != 0) goto L_0x006d
            com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ Exception -> 0x0029 }
            com.appsflyer.internal.AFg1cSDK r2 = com.appsflyer.internal.AFg1cSDK.GENERAL     // Catch:{ Exception -> 0x0029 }
            r0.w(r2, r1)     // Catch:{ Exception -> 0x0029 }
            goto L_0x0078
        L_0x006d:
            com.appsflyer.AFLogger r3 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ Exception -> 0x0029 }
            com.appsflyer.internal.AFg1cSDK r0 = com.appsflyer.internal.AFg1cSDK.GENERAL     // Catch:{ Exception -> 0x0029 }
            r3.w(r0, r1)     // Catch:{ Exception -> 0x0029 }
            r3 = 0
            throw r3     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r3 = move-exception
            throw r3
        L_0x0078:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0029 }
            r1 = 32
            if (r0 <= r1) goto L_0x0098
            java.lang.String r0 = "com.google.android.gms.permission.AD_ID"
            boolean r3 = r3.contains(r0)     // Catch:{ Exception -> 0x0029 }
            if (r3 == 0) goto L_0x0087
            goto L_0x0098
        L_0x0087:
            com.appsflyer.AFLogger r3 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ Exception -> 0x0029 }
            com.appsflyer.internal.AFg1cSDK r0 = com.appsflyer.internal.AFg1cSDK.GENERAL     // Catch:{ Exception -> 0x0029 }
            java.lang.String r1 = "Permission com.google.android.gms.permission.AD_ID is missing in the AndroidManifest.xml"
            r3.w(r0, r1)     // Catch:{ Exception -> 0x0029 }
            int r3 = AFInAppEventParameterName
            int r3 = r3 + 71
            int r3 = r3 % 128
            AFInAppEventType = r3
        L_0x0098:
            int r3 = AFInAppEventType
            int r3 = r3 + 125
            int r3 = r3 % 128
            AFInAppEventParameterName = r3
            return
        L_0x00a1:
            com.appsflyer.AFLogger r0 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r1 = com.appsflyer.internal.AFg1cSDK.GENERAL
            java.lang.String r2 = "Exception while validation permissions. "
            r0.e(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.component4(android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void copydefault() {
        getMonetizationNetwork(new Object[]{this, new AFh1kSDK()}, 974724333, -974724320, System.identityHashCode(this));
        int i = AFInAppEventType + 71;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            throw null;
        }
    }

    public static String getRevenue(SimpleDateFormat simpleDateFormat, long j) {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j));
        int i = AFInAppEventParameterName + 61;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            return format;
        }
        throw null;
    }

    private static void copy() {
        int i = AFInAppEventType + 55;
        AFInAppEventParameterName = i % 128;
        if (i % 2 == 0) {
            AFLogger.INSTANCE.w(AFg1cSDK.SDK_LIFECYCLE, "ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
        } else {
            AFLogger.INSTANCE.w(AFg1cSDK.SDK_LIFECYCLE, "ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
            throw null;
        }
    }

    private static String getMonetizationNetwork(String str) {
        AFInAppEventParameterName = (AFInAppEventType + 111) % 128;
        String string = AppsFlyerProperties.getInstance().getString(str);
        int i = AFInAppEventType + 1;
        AFInAppEventParameterName = i % 128;
        if (i % 2 == 0) {
            return string;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (r5.areAllFieldsValid == null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r5.areAllFieldsValid == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void AFAdRevenueData(com.appsflyer.internal.AFh1rSDK r5) {
        /*
            r4 = this;
            int r0 = AFInAppEventParameterName
            int r0 = r0 + 3
            int r1 = r0 % 128
            AFInAppEventType = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = r5.areAllFieldsValid
            r3 = 19
            int r3 = r3 / r1
            if (r0 != 0) goto L_0x001b
            goto L_0x001a
        L_0x0016:
            java.lang.String r0 = r5.areAllFieldsValid
            if (r0 != 0) goto L_0x001b
        L_0x001a:
            r1 = 1
        L_0x001b:
            boolean r0 = r4.getMediationNetwork()
            if (r0 == 0) goto L_0x002f
            int r5 = AFInAppEventType
            int r5 = r5 + 87
            int r5 = r5 % 128
            AFInAppEventParameterName = r5
            java.lang.String r5 = "CustomerUserId not set, reporting is disabled"
            com.appsflyer.AFLogger.afInfoLog(r5, r2)
            return
        L_0x002f:
            if (r1 == 0) goto L_0x0071
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "launchProtectEnabled"
            boolean r0 = r0.getBoolean(r1, r2)
            r0 = r0 ^ r2
            if (r0 == r2) goto L_0x005e
            boolean r0 = r4.component1()
            if (r0 == 0) goto L_0x0063
            int r0 = AFInAppEventParameterName
            int r0 = r0 + 117
            int r0 = r0 % 128
            AFInAppEventType = r0
            com.appsflyer.attribution.AppsFlyerRequestListener r5 = r5.getCurrencyIso4217Code
            if (r5 == 0) goto L_0x005d
            int r0 = r0 + 113
            int r0 = r0 % 128
            AFInAppEventParameterName = r0
            r0 = 10
            java.lang.String r1 = "Event timeout. Check 'minTimeBetweenSessions' param"
            r5.onError(r0, r1)
        L_0x005d:
            return
        L_0x005e:
            java.lang.String r0 = "Allowing multiple launches within a 5 second time window."
            com.appsflyer.AFLogger.afInfoLog(r0)
        L_0x0063:
            long r0 = java.lang.System.currentTimeMillis()
            r4.component2 = r0
            int r0 = AFInAppEventParameterName
            int r0 = r0 + 101
            int r0 = r0 % 128
            AFInAppEventType = r0
        L_0x0071:
            com.appsflyer.internal.AFc1dSDK r0 = r4.AFAdRevenueData()
            java.util.concurrent.ScheduledExecutorService r0 = r0.AFAdRevenueData()
            com.appsflyer.internal.AFa1tSDK$AFa1ySDK r1 = new com.appsflyer.internal.AFa1tSDK$AFa1ySDK
            r1.<init>(r5)
            r2 = 0
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.appsflyer.internal.AFj1dSDK.getMediationNetwork(r0, r1, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.AFAdRevenueData(com.appsflyer.internal.AFh1rSDK):void");
    }

    private static void getMediationNetwork(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                }
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("error at timeStampArr", e);
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext()) {
                AFInAppEventParameterName = (AFInAppEventType + 45) % 128;
                if (str != null) {
                    break loop2;
                }
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        if (!(jSONArray2.getLong(i2) == ((Long) arrayList.get(0)).longValue() || jSONArray2.getLong(i2) == ((Long) arrayList.get(1)).longValue())) {
                            AFInAppEventParameterName = (AFInAppEventType + 53) % 128;
                            if (jSONArray2.getLong(i2) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                                i2++;
                                AFInAppEventType = (AFInAppEventParameterName + 15) % 128;
                                str = next;
                            }
                        }
                    }
                    continue;
                } catch (JSONException e2) {
                    AFLogger.afErrorLogForExcManagerOnly("error at manageExtraReferrers", e2);
                }
            }
            break loop2;
        }
        if (str != null) {
            int i3 = AFInAppEventType + 115;
            AFInAppEventParameterName = i3 % 128;
            if (i3 % 2 != 0) {
                jSONObject.remove(str);
                int i4 = 31 / 0;
                return;
            }
            jSONObject.remove(str);
        }
    }

    private static /* synthetic */ Object getMonetizationNetwork(Object[] objArr) {
        AFa1tSDK aFa1tSDK = objArr[0];
        Map map = objArr[1];
        int i = AFInAppEventParameterName + 103;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            if (map != null) {
                aFa1tSDK.AFAdRevenueData().copy().getMediationNetwork("setAdditionalData", map.toString());
                AppsFlyerProperties.getInstance().setCustomData(new JSONObject(map).toString());
                AFInAppEventParameterName = (AFInAppEventType + 45) % 128;
            }
            return null;
        }
        throw null;
    }

    public static Map<String, Object> getRevenue(Map<String, Object> map) {
        Map<String, Object> map2;
        if (map.containsKey("meta")) {
            int i = AFInAppEventType + 117;
            AFInAppEventParameterName = i % 128;
            if (i % 2 == 0) {
                map2 = (Map) map.get("meta");
            } else {
                Map map3 = (Map) map.get("meta");
                throw null;
            }
        } else {
            HashMap hashMap = new HashMap();
            map.put("meta", hashMap);
            map2 = hashMap;
        }
        int i2 = AFInAppEventParameterName + 45;
        AFInAppEventType = i2 % 128;
        if (i2 % 2 != 0) {
            return map2;
        }
        throw null;
    }

    private static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        String str = objArr[0];
        String str2 = objArr[1];
        int i = AFInAppEventParameterName + 1;
        AFInAppEventType = i % 128;
        if (i % 2 == 0) {
            AppsFlyerProperties.getInstance().set(str, str2);
            int i2 = 44 / 0;
        } else {
            AppsFlyerProperties.getInstance().set(str, str2);
        }
        AFInAppEventType = (AFInAppEventParameterName + 81) % 128;
        return null;
    }

    @VisibleForTesting
    @Nullable
    private String getRevenue(Context context, String str) {
        int i = (AFInAppEventType + 15) % 128;
        AFInAppEventParameterName = i;
        if (context == null) {
            AFInAppEventType = (i + 7) % 128;
            return null;
        }
        getMediationNetwork(context);
        String currencyIso4217Code = AFAdRevenueData().getRevenue().getCurrencyIso4217Code(str);
        int i2 = AFInAppEventType + 65;
        AFInAppEventParameterName = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 41 / 0;
        }
        return currencyIso4217Code;
    }

    public static void areAllFieldsValid() {
        AFKeystoreWrapper = new int[]{1173848566, -581264425, 1049631762, -184971919, -1510845523, 293648529, -317712227, 1299495101, -345507000, 2098071530, -62356939, -1430410937, 823748430, 809610160, -1818352164, -849605125, 1727658104, 1621127117};
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r3 == false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        if (r3 != false) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        AFAdRevenueData().v().getCurrencyIso4217Code();
        AFInAppEventParameterName = (AFInAppEventType + 43) % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void getMonetizationNetwork(boolean r3) {
        /*
            r2 = this;
            int r0 = AFInAppEventParameterName
            int r0 = r0 + 95
            int r1 = r0 % 128
            AFInAppEventType = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0013
            r0 = 41
            int r0 = r0 / 0
            if (r3 != 0) goto L_0x0015
            goto L_0x0021
        L_0x0013:
            if (r3 == 0) goto L_0x0021
        L_0x0015:
            com.appsflyer.internal.AFc1dSDK r3 = r2.AFAdRevenueData()
            com.appsflyer.internal.AFg1bSDK r3 = r3.v()
            r3.getRevenue()
            return
        L_0x0021:
            com.appsflyer.internal.AFc1dSDK r3 = r2.AFAdRevenueData()
            com.appsflyer.internal.AFg1bSDK r3 = r3.v()
            r3.getCurrencyIso4217Code()
            int r3 = AFInAppEventType
            int r3 = r3 + 43
            int r3 = r3 % 128
            AFInAppEventParameterName = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.getMonetizationNetwork(boolean):void");
    }

    private boolean component1() {
        return ((Boolean) getMonetizationNetwork(new Object[]{this}, -1610644480, 1610644503, System.identityHashCode(this))).booleanValue();
    }

    private static void getCurrencyIso4217Code(String str, boolean z) {
        int i = AFInAppEventParameterName + 19;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            AppsFlyerProperties.getInstance().set(str, z);
        } else {
            AppsFlyerProperties.getInstance().set(str, z);
            throw null;
        }
    }

    public final AFc1qSDK getRevenue(Context context) {
        int i = AFInAppEventParameterName + 11;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            getMediationNetwork(context);
            AFc1qSDK component22 = AFAdRevenueData().component2();
            int i2 = AFInAppEventParameterName + 121;
            AFInAppEventType = i2 % 128;
            if (i2 % 2 != 0) {
                return component22;
            }
            throw null;
        }
        getMediationNetwork(context);
        AFAdRevenueData().component2();
        throw null;
    }

    private static boolean getCurrencyIso4217Code(String str) {
        int i = AFInAppEventParameterName + 35;
        AFInAppEventType = i % 128;
        int i2 = i % 2;
        boolean z = AppsFlyerProperties.getInstance().getBoolean(str, false);
        AFInAppEventType = (AFInAppEventParameterName + 5) % 128;
        return z;
    }

    private void getCurrencyIso4217Code(Context context, AFh1xSDK aFh1xSDK) {
        getMediationNetwork(context);
        AFh1vSDK areAllFieldsValid2 = AFAdRevenueData().areAllFieldsValid();
        AFh1tSDK revenue = AFh1tSDK.getRevenue(context);
        if (areAllFieldsValid2.getCurrencyIso4217Code()) {
            int i = AFInAppEventType + 5;
            AFInAppEventParameterName = i % 128;
            if (i % 2 == 0) {
                areAllFieldsValid2.AFAdRevenueData.put("api_name", aFh1xSDK.toString());
                areAllFieldsValid2.getMediationNetwork(revenue);
            } else {
                areAllFieldsValid2.AFAdRevenueData.put("api_name", aFh1xSDK.toString());
                areAllFieldsValid2.getMediationNetwork(revenue);
                throw null;
            }
        }
        areAllFieldsValid2.AFAdRevenueData();
        AFInAppEventParameterName = (AFInAppEventType + 19) % 128;
    }

    @SuppressLint({"DiscouragedApi"})
    private static void getMonetizationNetwork(Context context) {
        try {
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.flags & 32768) == 0) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 31) {
                AFInAppEventType = (AFInAppEventParameterName + 61) % 128;
                if (context.getResources().getIdentifier("appsflyer_data_extraction_rules", "xml", context.getPackageName()) != 0) {
                    int i = AFInAppEventType + 119;
                    AFInAppEventParameterName = i % 128;
                    if (i % 2 != 0) {
                        AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "appsflyer_data_extraction_rules.xml detected, using AppsFlyer data extraction rules for AppsFlyer SDK data", false);
                    } else {
                        AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "appsflyer_data_extraction_rules.xml detected, using AppsFlyer data extraction rules for AppsFlyer SDK data", true);
                    }
                } else {
                    AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "'allowBackup' is set to true; appsflyer_data_extraction_rules.xml is NOT detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <data-extraction-rules> both in <device-transfer> and <cloud-backup>.\nIf Appsflyer's Purchase Connector is in use then you also must add to <device-transfer> and <cloud-backup> the following excludes: <exclude domain=\"sharedpref\" path=\"appsflyer-purchase-data\"/> AND <exclude domain=\"database\" path=\"afpurchases.db\"/>", true);
                    AFInAppEventParameterName = (AFInAppEventType + 79) % 128;
                }
            } else if (context.getResources().getIdentifier("appsflyer_backup_rules", "xml", context.getPackageName()) != 0) {
                AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
            } else {
                AFLogger.INSTANCE.w(AFg1cSDK.GENERAL, "'allowBackup' is set to true; appsflyer_backup_rules.xml is NOT detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules.\nIf Appsflyer's Purchase Connector is in use then you also must add the following to your rules: <exclude domain=\"sharedpref\" path=\"appsflyer-purchase-data\"/> AND <exclude domain=\"database\" path=\"afpurchases.db\"/>", true);
            }
        } catch (Throwable th) {
            AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Exception while checking BackupRules: ", th);
        }
    }

    @WorkerThread
    private void component2() {
        int i = AFInAppEventType + 37;
        AFInAppEventParameterName = i % 128;
        if (i % 2 == 0) {
            try {
                AFi1fSDK force = AFAdRevenueData().force();
                if (force != null) {
                    AFInAppEventParameterName = (AFInAppEventType + 77) % 128;
                    if (force.getMediationNetwork()) {
                        force.AFAdRevenueData(new c(this, force));
                    }
                }
            } catch (Throwable th) {
                AFLogger.afErrorLogForExcManagerOnly("Error at attempt to request PIA token", th);
                AFLogger.afRDLog("Get PIA token failed with exception:".concat(String.valueOf(th)));
            }
        } else {
            AFAdRevenueData().force();
            throw null;
        }
    }

    private static /* synthetic */ Object getRevenue(Object[] objArr) {
        AFa1tSDK aFa1tSDK = objArr[0];
        Context context = objArr[1];
        String str = objArr[2];
        String str2 = objArr[3];
        String str3 = objArr[4];
        String str4 = objArr[5];
        String str5 = objArr[6];
        Map map = objArr[7];
        AFInAppEventParameterName = (AFInAppEventType + 117) % 128;
        aFa1tSDK.AFAdRevenueData().copy().getMediationNetwork("validateAndTrackInAppPurchase", str, str2, str3, str4, str5, map == null ? "" : map.toString());
        if (!aFa1tSDK.AFAdRevenueData().registerClient().AFAdRevenueData()) {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1cSDK aFg1cSDK = AFg1cSDK.PURCHASE_VALIDATION;
            StringBuilder u = e.u("Validate in app called with parameters: ", str3, StringUtils.SPACE, str4, StringUtils.SPACE);
            u.append(str5);
            aFLogger.i(aFg1cSDK, u.toString());
        }
        if (!(str == null || str4 == null)) {
            int i = AFInAppEventParameterName;
            AFInAppEventType = (i + 105) % 128;
            if (str2 != null) {
                AFInAppEventType = (i + 39) % 128;
                if (!(str5 == null || str3 == null)) {
                    AFa1ySDK aFa1ySDK = r5;
                    AFa1ySDK aFa1ySDK2 = new AFa1ySDK(context.getApplicationContext(), aFa1tSDK.AFAdRevenueData().registerClient().getMediationNetwork(), str, str2, str3, str4, str5, map);
                    new Thread(aFa1ySDK).start();
                    return null;
                }
            }
        }
        AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFAdRevenueData;
        if (appsFlyerInAppPurchaseValidatorListener != null) {
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
            int i2 = AFInAppEventType + 91;
            AFInAppEventParameterName = i2 % 128;
            if (i2 % 2 != 0) {
                int i3 = 74 / 0;
            }
        }
        return null;
    }

    public final void component4() {
        AFInAppEventType = (AFInAppEventParameterName + 123) % 128;
        if (AFe1bSDK.component3()) {
            int i = AFInAppEventType + 93;
            AFInAppEventParameterName = i % 128;
            if (i % 2 != 0) {
                int i2 = 25 / 0;
                return;
            }
            return;
        }
        AFc1dSDK AFAdRevenueData2 = AFAdRevenueData();
        AFe1lSDK copydefault2 = AFAdRevenueData2.copydefault();
        copydefault2.getRevenue.execute(new Runnable(new AFe1bSDK(AFAdRevenueData2)) {
            private /* synthetic */ AFe1sSDK getMonetizationNetwork;

            /*  JADX ERROR: Method generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
            /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
            public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFe1lSDK.5.run():void, dex: classes.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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

    private static /* synthetic */ Object AFAdRevenueData(Object[] objArr) {
        String str = objArr[0];
        try {
            if (!new JSONObject(str).has("pid")) {
                AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
                int i = AFInAppEventType + 125;
                AFInAppEventParameterName = i % 128;
                if (i % 2 == 0) {
                    return null;
                }
                throw null;
            }
            AFInAppEventType = (AFInAppEventParameterName + 107) % 128;
            getMonetizationNetwork(new Object[]{"preInstallName", str}, -692563571, 692563575, (int) System.currentTimeMillis());
            return null;
        } catch (JSONException e) {
            AFLogger.afErrorLog("Error parsing JSON for preinstall", e);
            return null;
        }
    }

    private static void getCurrencyIso4217Code(@NonNull AFh1rSDK aFh1rSDK, @Nullable AFh1qSDK aFh1qSDK) {
        int i = (AFInAppEventType + 73) % 128;
        AFInAppEventParameterName = i;
        if (aFh1qSDK != null) {
            int i2 = i + 79;
            AFInAppEventType = i2 % 128;
            if (i2 % 2 != 0) {
                aFh1rSDK.getMediationNetwork = aFh1qSDK.getCurrencyIso4217Code;
                aFh1rSDK.component4 = aFh1qSDK.getMediationNetwork;
                return;
            }
            aFh1rSDK.getMediationNetwork = aFh1qSDK.getCurrencyIso4217Code;
            aFh1rSDK.component4 = aFh1qSDK.getMediationNetwork;
            throw null;
        }
    }

    public final void getMediationNetwork(Context context, String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        AFInAppEventType = (AFInAppEventParameterName + 43) % 128;
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String AFAdRevenueData2 = getRevenue(context).AFAdRevenueData("extraReferrers", (String) null);
            if (AFAdRevenueData2 == null) {
                jSONObject = new JSONObject();
                jSONArray = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(AFAdRevenueData2);
                if (jSONObject2.has(str)) {
                    jSONArray2 = new JSONArray((String) jSONObject2.get(str));
                } else {
                    jSONArray2 = new JSONArray();
                }
                JSONObject jSONObject3 = jSONObject2;
                jSONArray = jSONArray2;
                jSONObject = jSONObject3;
            }
            if (((long) jSONArray.length()) < 5) {
                int i = AFInAppEventType + 25;
                AFInAppEventParameterName = i % 128;
                if (i % 2 != 0) {
                    jSONArray.put(currentTimeMillis);
                    int i2 = 87 / 0;
                } else {
                    jSONArray.put(currentTimeMillis);
                }
            }
            if (((long) jSONObject.length()) >= 4) {
                getMediationNetwork(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            getRevenue(context).getMediationNetwork("extraReferrers", jSONObject.toString());
            AFInAppEventType = (AFInAppEventParameterName + 121) % 128;
        } catch (JSONException e) {
            AFLogger.afErrorLogForExcManagerOnly("error at addReferrer", e);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
            sb.append(str);
            sb.append(": ");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    @VisibleForTesting
    public final void getMonetizationNetwork(@NonNull AFh1rSDK aFh1rSDK, @Nullable AFh1qSDK aFh1qSDK) {
        int i;
        getCurrencyIso4217Code(aFh1rSDK, aFh1qSDK);
        if (AFAdRevenueData().registerClient().getMediationNetwork() == null) {
            AFInAppEventParameterName = (AFInAppEventType + 45) % 128;
            AFLogger.afWarnLog("[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
            AppsFlyerRequestListener appsFlyerRequestListener = aFh1rSDK.getCurrencyIso4217Code;
            if (appsFlyerRequestListener != null) {
                int i2 = AFInAppEventType + 105;
                AFInAppEventParameterName = i2 % 128;
                if (i2 % 2 != 0) {
                    i = 108;
                } else {
                    i = 41;
                }
                appsFlyerRequestListener.onError(i, "No dev key");
            }
            AFInAppEventParameterName = (AFInAppEventType + 11) % 128;
            return;
        }
        String referrer = AppsFlyerProperties.getInstance().getReferrer(AFAdRevenueData().component2());
        if (referrer == null) {
            referrer = "";
        } else {
            AFInAppEventType = (AFInAppEventParameterName + 9) % 128;
        }
        aFh1rSDK.component3 = referrer;
        AFAdRevenueData(aFh1rSDK);
    }

    public class AFa1vSDK implements AFe1qSDK {
        public AFa1vSDK() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Unit getRevenue() {
            AFa1tSDK aFa1tSDK = AFa1tSDK.this;
            AFa1tSDK.getMonetizationNetwork(new Object[]{aFa1tSDK, new AFh1kSDK()}, 974724333, -974724320, System.identityHashCode(aFa1tSDK));
            return Unit.f696a;
        }

        public final void getCurrencyIso4217Code(AFe1sSDK<?> aFe1sSDK, AFe1rSDK aFe1rSDK) {
            JSONObject revenue;
            AFf1aSDK revenue2;
            if (aFe1sSDK instanceof AFf1rSDK) {
                AFf1rSDK aFf1rSDK = (AFf1rSDK) aFe1sSDK;
                boolean z = aFe1sSDK instanceof AFf1uSDK;
                if (z && getCurrencyIso4217Code()) {
                    AFf1uSDK aFf1uSDK = (AFf1uSDK) aFe1sSDK;
                    if (aFf1uSDK.getMediationNetwork == AFe1rSDK.SUCCESS || aFf1uSDK.getRevenue == 1) {
                        AFg1rSDK aFg1rSDK = new AFg1rSDK(aFf1uSDK, AFa1tSDK.this.AFAdRevenueData().component2());
                        AFe1lSDK copydefault = AFa1tSDK.this.AFAdRevenueData().copydefault();
                        copydefault.getRevenue.execute(new Runnable(aFg1rSDK) {
                            private /* synthetic */ AFe1sSDK getMonetizationNetwork;

                            /*  JADX ERROR: Method generation error
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                            /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                            public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFe1lSDK.5.run():void, dex: classes.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                AFh1uSDK afErrorLogForExcManagerOnly = AFa1tSDK.this.AFAdRevenueData().afErrorLogForExcManagerOnly();
                if (afErrorLogForExcManagerOnly != null && z) {
                    afErrorLogForExcManagerOnly.getRevenue((AFf1uSDK) aFe1sSDK, new e(this, 0));
                }
                if (aFe1rSDK == AFe1rSDK.SUCCESS) {
                    AFa1tSDK aFa1tSDK = AFa1tSDK.this;
                    aFa1tSDK.getRevenue((Context) aFa1tSDK.component1).getMediationNetwork("sentSuccessfully", "true");
                    if (!(aFe1sSDK instanceof AFf1tSDK) && (revenue2 = new AFg1ySDK(AFa1tSDK.this.component1).getRevenue()) != null && revenue2.getMediationNetwork) {
                        String str = revenue2.getRevenue;
                        AFLogger.INSTANCE.d(AFg1cSDK.UNINSTALL, "Resending Uninstall token to AF servers: ".concat(String.valueOf(str)));
                        AFc1dSDK AFAdRevenueData = ((AFa1tSDK) AFa1tSDK.getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis())).AFAdRevenueData();
                        AFf1tSDK aFf1tSDK = new AFf1tSDK(str, AFAdRevenueData);
                        AFe1lSDK copydefault2 = AFAdRevenueData.copydefault();
                        copydefault2.getRevenue.execute(new Runnable(aFf1tSDK) {
                            private /* synthetic */ AFe1sSDK getMonetizationNetwork;

                            /*  JADX ERROR: Method generation error
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                            /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                            public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFe1lSDK.5.run():void, dex: classes.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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
                    AFd1aSDK<Result> aFd1aSDK = aFf1rSDK.component1;
                    if (!(aFd1aSDK == null || (revenue = AFa1qSDK.getRevenue((String) aFd1aSDK.getBody())) == null)) {
                        AFa1tSDK.this.component4 = revenue.optBoolean("send_background", false);
                    }
                    if (z) {
                        AFa1tSDK.this.getMediationNetwork = System.currentTimeMillis();
                    }
                }
            } else if ((aFe1sSDK instanceof AFg1rSDK) && aFe1rSDK != AFe1rSDK.SUCCESS) {
                AFg1pSDK aFg1pSDK = new AFg1pSDK(AFa1tSDK.this.AFAdRevenueData());
                AFe1lSDK copydefault3 = AFa1tSDK.this.AFAdRevenueData().copydefault();
                copydefault3.getRevenue.execute(new Runnable(aFg1pSDK) {
                    private /* synthetic */ AFe1sSDK getMonetizationNetwork;

                    /*  JADX ERROR: Method generation error
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                    /*  JADX ERROR: Method generation error: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                    public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFe1lSDK.5.run():void, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
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

        public final void getMediationNetwork(AFe1sSDK<?> aFe1sSDK) {
        }

        public final void getMonetizationNetwork(AFe1sSDK<?> aFe1sSDK) {
            if (aFe1sSDK instanceof AFf1uSDK) {
                AFa1tSDK.this.AFAdRevenueData().areAllFieldsValid().getCurrencyIso4217Code(((AFf1rSDK) aFe1sSDK).component2.component2);
            }
        }

        private boolean getCurrencyIso4217Code() {
            return AFa1tSDK.this.getCurrencyIso4217Code != null;
        }
    }

    private static void AFAdRevenueData(String str) {
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.SDK_LIFECYCLE;
        StringBuilder sb = new StringBuilder("ERROR: AppsFlyer SDK is not initialized! The API call '");
        sb.append(str);
        sb.append("()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
        aFLogger.w(aFg1cSDK, sb.toString());
        int i = AFInAppEventType + 115;
        AFInAppEventParameterName = i % 128;
        if (i % 2 != 0) {
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        if (r4.remove("android_id") != null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        if (r4.remove("android_id") != null) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getCurrencyIso4217Code(java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
            r3 = this;
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "collectAndroidIdForceByUser"
            r2 = 0
            boolean r0 = r0.getBoolean(r1, r2)
            if (r0 != 0) goto L_0x0091
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "collectIMEIForceByUser"
            boolean r0 = r0.getBoolean(r1, r2)
            if (r0 == 0) goto L_0x001b
            goto L_0x0091
        L_0x001b:
            java.lang.String r0 = "advertiserId"
            java.lang.Object r0 = r4.get(r0)
            if (r0 == 0) goto L_0x0091
            int r0 = AFInAppEventType
            int r0 = r0 + 41
            int r0 = r0 % 128
            AFInAppEventParameterName = r0
            com.appsflyer.internal.AFc1dSDK r0 = r3.AFAdRevenueData()     // Catch:{ Exception -> 0x0055 }
            com.appsflyer.internal.AFc1kSDK r0 = r0.afInfoLog()     // Catch:{ Exception -> 0x0055 }
            java.lang.String r0 = r0.AFAdRevenueData     // Catch:{ Exception -> 0x0055 }
            boolean r0 = com.appsflyer.internal.AFk1ySDK.getMediationNetwork(r0)     // Catch:{ Exception -> 0x0055 }
            if (r0 == 0) goto L_0x006b
            int r0 = AFInAppEventType
            int r0 = r0 + 29
            int r1 = r0 % 128
            AFInAppEventParameterName = r1
            int r0 = r0 % 2
            java.lang.String r1 = "android_id"
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r4.remove(r1)     // Catch:{ Exception -> 0x0055 }
            r1 = 63
            int r1 = r1 / r2
            if (r0 == 0) goto L_0x006b
            goto L_0x005d
        L_0x0053:
            r4 = move-exception
            throw r4
        L_0x0055:
            r4 = move-exception
            goto L_0x008c
        L_0x0057:
            java.lang.Object r0 = r4.remove(r1)     // Catch:{ Exception -> 0x0055 }
            if (r0 == 0) goto L_0x006b
        L_0x005d:
            int r0 = AFInAppEventType
            int r0 = r0 + 117
            int r0 = r0 % 128
            AFInAppEventParameterName = r0
            java.lang.String r0 = "validateGaidAndIMEI :: removing: android_id"
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ Exception -> 0x0055 }
        L_0x006b:
            com.appsflyer.internal.AFc1dSDK r0 = r3.AFAdRevenueData()     // Catch:{ Exception -> 0x0055 }
            com.appsflyer.internal.AFf1gSDK r0 = r0.registerClient()     // Catch:{ Exception -> 0x0055 }
            java.lang.String r0 = r0.getRevenue()     // Catch:{ Exception -> 0x0055 }
            boolean r0 = com.appsflyer.internal.AFk1ySDK.getMediationNetwork(r0)     // Catch:{ Exception -> 0x0055 }
            if (r0 == 0) goto L_0x008b
            java.lang.String r0 = "imei"
            java.lang.Object r4 = r4.remove(r0)     // Catch:{ Exception -> 0x0055 }
            if (r4 == 0) goto L_0x008b
            java.lang.String r4 = "validateGaidAndIMEI :: removing: imei"
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ Exception -> 0x0055 }
        L_0x008b:
            return
        L_0x008c:
            java.lang.String r0 = "failed to remove IMEI or AndroidID key from params; "
            com.appsflyer.AFLogger.afErrorLog(r0, r4)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.getCurrencyIso4217Code(java.util.Map):void");
    }

    private static void getRevenue(String str) {
        getMonetizationNetwork(new Object[]{str}, 998031041, -998031039, (int) System.currentTimeMillis());
    }

    public final void getRevenue(AFh1rSDK aFh1rSDK) {
        getMonetizationNetwork(new Object[]{this, aFh1rSDK}, 974724333, -974724320, System.identityHashCode(this));
    }

    public static String getMonetizationNetwork(AFc1qSDK aFc1qSDK, String str) {
        int i = AFInAppEventType + 99;
        AFInAppEventParameterName = i % 128;
        if (i % 2 == 0) {
            String AFAdRevenueData2 = aFc1qSDK.AFAdRevenueData("CACHED_CHANNEL", (String) null);
            if (AFAdRevenueData2 != null) {
                return AFAdRevenueData2;
            }
            aFc1qSDK.getMediationNetwork("CACHED_CHANNEL", str);
            AFInAppEventType = (AFInAppEventParameterName + 103) % 128;
            return str;
        }
        aFc1qSDK.AFAdRevenueData("CACHED_CHANNEL", (String) null);
        throw null;
    }

    private static int getMonetizationNetwork(AFc1qSDK aFc1qSDK, String str, boolean z) {
        AFInAppEventType = (AFInAppEventParameterName + 35) % 128;
        int AFAdRevenueData2 = aFc1qSDK.AFAdRevenueData(str, 0);
        if (z) {
            AFAdRevenueData2++;
            aFc1qSDK.getMediationNetwork(str, AFAdRevenueData2);
        }
        int i = AFInAppEventParameterName + 61;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            return AFAdRevenueData2;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0400, code lost:
        if (r0.toString().isEmpty() == false) goto L_0x0404;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x040c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object getMonetizationNetwork(java.lang.Object[] r10, int r11, int r12, int r13) {
        /*
            int r0 = r11 * -464
            int r1 = r12 * -929
            int r1 = r1 + r0
            int r11 = ~r11
            r0 = r12 | r13
            int r2 = ~r0
            r2 = r2 | r11
            int r2 = r2 * -465
            int r2 = r2 + r1
            r13 = r13 | r11
            int r13 = ~r13
            r12 = r12 | r13
            int r12 = r12 * 930
            int r12 = r12 + r2
            r11 = r11 | r0
            int r11 = r11 * 465
            int r11 = r11 + r12
            r12 = 0
            r0 = 2
            r1 = 0
            r2 = 1
            r3 = 0
            switch(r11) {
                case 1: goto L_0x043e;
                case 2: goto L_0x0439;
                case 3: goto L_0x0434;
                case 4: goto L_0x042f;
                case 5: goto L_0x042a;
                case 6: goto L_0x03b3;
                case 7: goto L_0x03ad;
                case 8: goto L_0x03a7;
                case 9: goto L_0x03a1;
                case 10: goto L_0x039b;
                case 11: goto L_0x0372;
                case 12: goto L_0x036c;
                case 13: goto L_0x01fb;
                case 14: goto L_0x01f5;
                case 15: goto L_0x01ef;
                case 16: goto L_0x01e9;
                case 17: goto L_0x01e3;
                case 18: goto L_0x01dd;
                case 19: goto L_0x01b6;
                case 20: goto L_0x0101;
                case 21: goto L_0x00d9;
                case 22: goto L_0x00d3;
                case 23: goto L_0x0032;
                default: goto L_0x0020;
            }
        L_0x0020:
            int r10 = AFInAppEventParameterName
            int r10 = r10 + 69
            int r10 = r10 % 128
            AFInAppEventType = r10
            com.appsflyer.internal.AFa1tSDK r3 = areAllFieldsValid
            int r10 = r10 + 109
            int r10 = r10 % 128
            AFInAppEventParameterName = r10
            goto L_0x0442
        L_0x0032:
            r10 = r10[r1]
            com.appsflyer.internal.AFa1tSDK r10 = (com.appsflyer.internal.AFa1tSDK) r10
            int r11 = AFInAppEventParameterName
            int r11 = r11 + 47
            int r1 = r11 % 128
            AFInAppEventType = r1
            int r11 = r11 % r0
            if (r11 != 0) goto L_0x0048
            long r0 = r10.component2
            int r11 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r11 <= 0) goto L_0x00bd
            goto L_0x004e
        L_0x0048:
            long r0 = r10.component2
            int r11 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r11 <= 0) goto L_0x00bd
        L_0x004e:
            long r11 = java.lang.System.currentTimeMillis()
            long r0 = r10.component2
            long r11 = r11 - r0
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r1 = "yyyy/MM/dd HH:mm:ss.SSS Z"
            r13.<init>(r1, r0)
            long r0 = r10.component2
            java.lang.String r0 = getRevenue((java.text.SimpleDateFormat) r13, (long) r0)
            long r3 = r10.getMediationNetwork
            java.lang.String r13 = getRevenue((java.text.SimpleDateFormat) r13, (long) r3)
            long r3 = r10.component3
            java.lang.String r1 = ";\nLast successful Launch event: "
            java.lang.String r5 = "Last Launch attempt: "
            int r6 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x009f
            boolean r3 = r10.isStopped()
            if (r3 != 0) goto L_0x009f
            long r2 = r10.component3
            java.lang.String r10 = ";\nThis launch is blocked: "
            java.lang.StringBuilder r10 = defpackage.e.u(r5, r0, r1, r13, r10)
            r10.append(r11)
            java.lang.String r11 = " ms < "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r11 = " ms"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            com.appsflyer.AFLogger.afInfoLog(r10)
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
        L_0x009c:
            r3 = r10
            goto L_0x0442
        L_0x009f:
            boolean r10 = r10.isStopped()
            r10 = r10 ^ r2
            if (r10 == r2) goto L_0x00a7
            goto L_0x00d0
        L_0x00a7:
            java.lang.String r10 = ";\nSending launch (+"
            java.lang.StringBuilder r10 = defpackage.e.u(r5, r0, r1, r13, r10)
            r10.append(r11)
            java.lang.String r11 = " ms)"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            com.appsflyer.AFLogger.afInfoLog(r10)
            goto L_0x00d0
        L_0x00bd:
            boolean r10 = r10.isStopped()
            if (r10 != 0) goto L_0x00d0
            java.lang.String r10 = "Sending first launch for this session!"
            com.appsflyer.AFLogger.afInfoLog(r10)
            int r10 = AFInAppEventType
            int r10 = r10 + 23
            int r10 = r10 % 128
            AFInAppEventParameterName = r10
        L_0x00d0:
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            goto L_0x009c
        L_0x00d3:
            java.lang.Object r3 = AFLogger(r10)
            goto L_0x0442
        L_0x00d9:
            r11 = r10[r1]
            com.appsflyer.internal.AFc1qSDK r11 = (com.appsflyer.internal.AFc1qSDK) r11
            r10 = r10[r2]
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            int r12 = AFInAppEventType
            int r12 = r12 + 71
            int r12 = r12 % 128
            AFInAppEventParameterName = r12
            java.lang.String r12 = "appsFlyerCount"
            int r10 = getMonetizationNetwork(r11, r12, r10)
            int r11 = AFInAppEventType
            int r11 = r11 + 115
            int r11 = r11 % 128
            AFInAppEventParameterName = r11
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            goto L_0x0442
        L_0x0101:
            r11 = r10[r1]
            com.appsflyer.internal.AFa1tSDK r11 = (com.appsflyer.internal.AFa1tSDK) r11
            r12 = r10[r2]
            java.lang.String r12 = (java.lang.String) r12
            r10 = r10[r0]
            java.util.Map r10 = (java.util.Map) r10
            com.appsflyer.internal.AFc1dSDK r11 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFc1kSDK r11 = r11.afInfoLog()
            com.appsflyer.internal.AFb1qSDK r13 = r11.getMonetizationNetwork
            if (r13 != 0) goto L_0x0120
            com.appsflyer.internal.AFb1qSDK r13 = new com.appsflyer.internal.AFb1qSDK
            r13.<init>()
            r11.getMonetizationNetwork = r13
        L_0x0120:
            com.appsflyer.internal.AFb1qSDK r11 = r11.getMonetizationNetwork
            if (r12 == 0) goto L_0x01af
            int r13 = AFInAppEventParameterName
            int r13 = r13 + 7
            int r13 = r13 % 128
            AFInAppEventType = r13
            boolean r13 = r12.isEmpty()
            if (r13 == r2) goto L_0x01af
            if (r10 == 0) goto L_0x0191
            boolean r13 = r10.isEmpty()
            if (r13 == 0) goto L_0x013b
            goto L_0x0191
        L_0x013b:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "Setting partner data for "
            r13.<init>(r0)
            r13.append(r12)
            java.lang.String r0 = ": "
            r13.append(r0)
            r13.append(r10)
            java.lang.String r13 = r13.toString()
            com.appsflyer.AFLogger.afDebugLog(r13)
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>(r10)
            java.lang.String r13 = r13.toString()
            int r13 = r13.length()
            r0 = 1000(0x3e8, float:1.401E-42)
            if (r13 <= r0) goto L_0x0185
            java.lang.String r10 = "Partner data 1000 characters limit exceeded"
            com.appsflyer.AFLogger.afWarnLog(r10)
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.lang.String r0 = "limit exceeded: "
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r13 = r0.concat(r13)
            java.lang.String r0 = "error"
            r10.put(r0, r13)
            java.util.Map<java.lang.String, java.lang.Object> r11 = r11.AFAdRevenueData
            r11.put(r12, r10)
            goto L_0x0442
        L_0x0185:
            java.util.Map<java.lang.String, java.lang.Object> r13 = r11.getCurrencyIso4217Code
            r13.put(r12, r10)
            java.util.Map<java.lang.String, java.lang.Object> r10 = r11.AFAdRevenueData
            r10.remove(r12)
            goto L_0x0442
        L_0x0191:
            java.util.Map<java.lang.String, java.lang.Object> r10 = r11.getCurrencyIso4217Code
            java.lang.Object r10 = r10.remove(r12)
            if (r10 != 0) goto L_0x019c
            java.lang.String r10 = "Partner data is missing or `null`"
            goto L_0x01aa
        L_0x019c:
            java.lang.String r10 = "Cleared partner data for "
            java.lang.String r10 = r10.concat(r12)
            int r11 = AFInAppEventParameterName
            int r11 = r11 + 101
            int r11 = r11 % 128
            AFInAppEventType = r11
        L_0x01aa:
            com.appsflyer.AFLogger.afWarnLog(r10)
            goto L_0x0442
        L_0x01af:
            java.lang.String r10 = "Partner ID is missing or `null`"
            com.appsflyer.AFLogger.afWarnLog(r10)
            goto L_0x0442
        L_0x01b6:
            r10 = r10[r1]
            com.appsflyer.internal.AFa1tSDK r10 = (com.appsflyer.internal.AFa1tSDK) r10
            int r11 = AFInAppEventType
            int r11 = r11 + 85
            int r12 = r11 % 128
            AFInAppEventParameterName = r12
            int r11 = r11 % r0
            if (r11 == 0) goto L_0x01d1
            com.appsflyer.internal.AFc1dSDK r10 = r10.AFAdRevenueData()
            com.appsflyer.internal.AFc1kSDK r10 = r10.afInfoLog()
            r10.component1 = r1
            goto L_0x0442
        L_0x01d1:
            com.appsflyer.internal.AFc1dSDK r10 = r10.AFAdRevenueData()
            com.appsflyer.internal.AFc1kSDK r10 = r10.afInfoLog()
            r10.component1 = r2
            goto L_0x0442
        L_0x01dd:
            java.lang.Object r3 = copy(r10)
            goto L_0x0442
        L_0x01e3:
            java.lang.Object r3 = hashCode(r10)
            goto L_0x0442
        L_0x01e9:
            java.lang.Object r3 = toString(r10)
            goto L_0x0442
        L_0x01ef:
            java.lang.Object r3 = equals(r10)
            goto L_0x0442
        L_0x01f5:
            java.lang.Object r3 = copydefault(r10)
            goto L_0x0442
        L_0x01fb:
            r11 = r10[r1]
            com.appsflyer.internal.AFa1tSDK r11 = (com.appsflyer.internal.AFa1tSDK) r11
            r10 = r10[r2]
            com.appsflyer.internal.AFh1rSDK r10 = (com.appsflyer.internal.AFh1rSDK) r10
            com.appsflyer.internal.AFc1dSDK r4 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFc1iSDK r4 = r4.AFInAppEventType()
            android.content.Context r4 = r4.getMonetizationNetwork
            if (r4 != 0) goto L_0x022a
            int r10 = AFInAppEventParameterName
            int r10 = r10 + 125
            int r10 = r10 % 128
            AFInAppEventType = r10
            com.appsflyer.AFLogger r10 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r11 = com.appsflyer.internal.AFg1cSDK.ATTRIBUTION
            java.lang.String r12 = "sendWithEvent - got null context. skipping event/launch."
            r10.d(r11, r12, r2)
            int r10 = AFInAppEventType
            int r10 = r10 + 67
            int r10 = r10 % 128
            AFInAppEventParameterName = r10
            goto L_0x0442
        L_0x022a:
            com.appsflyer.internal.AFc1dSDK r5 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFf1gSDK r5 = r5.registerClient()
            java.lang.String r5 = r5.getMediationNetwork()
            com.appsflyer.attribution.AppsFlyerRequestListener r6 = r10.getCurrencyIso4217Code
            if (r5 == 0) goto L_0x0353
            int r7 = AFInAppEventParameterName
            int r7 = r7 + 49
            int r7 = r7 % 128
            AFInAppEventType = r7
            int r5 = r5.length()
            if (r5 != 0) goto L_0x024a
            goto L_0x0353
        L_0x024a:
            com.appsflyer.internal.AFc1qSDK r5 = r11.getRevenue((android.content.Context) r4)
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()
            r6.saveProperties(r5)
            com.appsflyer.internal.AFc1dSDK r6 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFf1gSDK r6 = r6.registerClient()
            boolean r6 = r6.AFAdRevenueData()
            if (r6 != 0) goto L_0x0278
            com.appsflyer.AFLogger r6 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r7 = com.appsflyer.internal.AFg1cSDK.GENERAL
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.String r8 = "sendWithEvent from activity: "
            java.lang.String r4 = r8.concat(r4)
            r6.i(r7, r4, r2)
        L_0x0278:
            boolean r4 = r10.getMediationNetwork()
            java.util.Map r6 = r11.getMediationNetwork((com.appsflyer.internal.AFh1rSDK) r10)
            com.appsflyer.internal.AFc1dSDK r7 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFf1gSDK r7 = r7.registerClient()
            boolean r7 = r7.AFAdRevenueData()
            if (r7 == 0) goto L_0x029f
            int r7 = AFInAppEventParameterName
            int r7 = r7 + 7
            int r7 = r7 % 128
            AFInAppEventType = r7
            com.appsflyer.AFLogger r7 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r8 = com.appsflyer.internal.AFg1cSDK.GENERAL
            java.lang.String r9 = "AppsFlyerLib.sendWithEvent"
            r7.i(r8, r9)
        L_0x029f:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r5
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r0[r2] = r5
            long r7 = java.lang.System.currentTimeMillis()
            int r5 = (int) r7
            r7 = -1175980247(0xffffffffb9e7f729, float:-4.4243902E-4)
            r8 = 1175980268(0x461808ec, float:9730.23)
            java.lang.Object r0 = getMonetizationNetwork(r0, r7, r8, r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r11.getCurrencyIso4217Code((java.util.Map<java.lang.String, java.lang.Object>) r6)
            com.appsflyer.internal.AFa1uSDK r5 = new com.appsflyer.internal.AFa1uSDK
            com.appsflyer.internal.AFc1dSDK r7 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFh1rSDK r10 = r10.getMediationNetwork(r6)
            com.appsflyer.internal.AFh1rSDK r10 = r10.AFAdRevenueData(r0)
            com.appsflyer.internal.AFc1dSDK r0 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFa1aSDK r0 = r0.e()
            java.util.Map r0 = r0.getMonetizationNetwork()
            r5.<init>(r7, r10, r0)
            if (r4 != 0) goto L_0x02df
            goto L_0x0340
        L_0x02df:
            com.appsflyer.internal.AFj1qSDK[] r10 = r11.component3()
            int r0 = r10.length
            r4 = 0
        L_0x02e5:
            if (r1 >= r0) goto L_0x0316
            r6 = r10[r1]
            com.appsflyer.internal.AFj1qSDK$AFa1ySDK r7 = r6.component4
            com.appsflyer.internal.AFj1qSDK$AFa1ySDK r8 = com.appsflyer.internal.AFj1qSDK.AFa1ySDK.STARTED
            if (r7 != r8) goto L_0x030c
            com.appsflyer.AFLogger r4 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r7 = com.appsflyer.internal.AFg1cSDK.REFERRER
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Failed to get "
            r8.<init>(r9)
            java.lang.String r6 = r6.component2
            r8.append(r6)
            java.lang.String r6 = " referrer, wait ..."
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r4.d(r7, r6)
            r4 = 1
        L_0x030c:
            int r1 = r1 + r2
            int r6 = AFInAppEventType
            int r6 = r6 + 45
            int r6 = r6 % 128
            AFInAppEventParameterName = r6
            goto L_0x02e5
        L_0x0316:
            com.appsflyer.internal.AFc1dSDK r10 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFa1aSDK r10 = r10.e()
            boolean r10 = r10.getCurrencyIso4217Code()
            r10 = r10 ^ r2
            if (r10 == r2) goto L_0x0330
            com.appsflyer.AFLogger r10 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r0 = com.appsflyer.internal.AFg1cSDK.REFERRER
            java.lang.String r1 = "fetching Facebook deferred AppLink data, wait ..."
            r10.d(r0, r1)
            r1 = 1
            goto L_0x0331
        L_0x0330:
            r1 = r4
        L_0x0331:
            com.appsflyer.internal.AFc1dSDK r10 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFf1gSDK r10 = r10.registerClient()
            boolean r10 = r10.getMonetizationNetwork()
            if (r10 == 0) goto L_0x0340
            r1 = 1
        L_0x0340:
            com.appsflyer.internal.AFc1dSDK r10 = r11.AFAdRevenueData()
            java.util.concurrent.ScheduledExecutorService r10 = r10.AFAdRevenueData()
            if (r1 == 0) goto L_0x034c
            r12 = 500(0x1f4, double:2.47E-321)
        L_0x034c:
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.appsflyer.internal.AFj1dSDK.getMediationNetwork(r10, r5, r12, r11)
            goto L_0x0442
        L_0x0353:
            com.appsflyer.AFLogger r10 = com.appsflyer.AFLogger.INSTANCE
            com.appsflyer.internal.AFg1cSDK r11 = com.appsflyer.internal.AFg1cSDK.GENERAL
            java.lang.String r12 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            r10.i(r11, r12, r2)
            java.lang.String r12 = "AppsFlyer will not track this event."
            r10.i(r11, r12, r2)
            if (r6 == 0) goto L_0x0442
            r10 = 41
            java.lang.String r11 = "No dev key"
            r6.onError(r10, r11)
            goto L_0x0442
        L_0x036c:
            java.lang.Object r3 = component3(r10)
            goto L_0x0442
        L_0x0372:
            r11 = r10[r1]
            com.appsflyer.internal.AFa1tSDK r11 = (com.appsflyer.internal.AFa1tSDK) r11
            r10 = r10[r2]
            android.content.Context r10 = (android.content.Context) r10
            int r12 = AFInAppEventParameterName
            int r12 = r12 + 95
            int r12 = r12 % 128
            AFInAppEventType = r12
            r11.getMediationNetwork((android.content.Context) r10)
            com.appsflyer.internal.AFc1dSDK r11 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFc1pSDK r11 = r11.getRevenue()
            java.lang.String r3 = r11.getCurrencyIso4217Code((android.content.Context) r10)
            int r10 = AFInAppEventParameterName
            int r10 = r10 + 123
            int r10 = r10 % 128
            AFInAppEventType = r10
            goto L_0x0442
        L_0x039b:
            java.lang.Object r3 = component2(r10)
            goto L_0x0442
        L_0x03a1:
            java.lang.Object r3 = areAllFieldsValid(r10)
            goto L_0x0442
        L_0x03a7:
            java.lang.Object r3 = component1((java.lang.Object[]) r10)
            goto L_0x0442
        L_0x03ad:
            java.lang.Object r3 = component4((java.lang.Object[]) r10)
            goto L_0x0442
        L_0x03b3:
            r11 = r10[r1]
            com.appsflyer.internal.AFa1tSDK r11 = (com.appsflyer.internal.AFa1tSDK) r11
            r12 = r10[r2]
            android.content.Context r12 = (android.content.Context) r12
            r10 = r10[r0]
            android.content.Intent r10 = (android.content.Intent) r10
            r11.getMediationNetwork((android.content.Context) r12)
            com.appsflyer.internal.AFc1dSDK r13 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFa1oSDK r13 = r13.d()
            com.appsflyer.internal.AFc1dSDK r11 = r11.AFAdRevenueData()
            com.appsflyer.internal.AFc1qSDK r11 = r11.component2()
            if (r10 == 0) goto L_0x03ed
            int r0 = AFInAppEventParameterName
            int r0 = r0 + r2
            int r0 = r0 % 128
            AFInAppEventType = r0
            java.lang.String r0 = r10.getAction()
            java.lang.String r4 = "android.intent.action.VIEW"
            boolean r0 = r4.equals(r0)
            if (r0 == r2) goto L_0x03e8
            goto L_0x03ed
        L_0x03e8:
            android.net.Uri r0 = r10.getData()
            goto L_0x03ee
        L_0x03ed:
            r0 = r3
        L_0x03ee:
            if (r0 == 0) goto L_0x0403
            int r4 = AFInAppEventType
            int r4 = r4 + 19
            int r4 = r4 % 128
            AFInAppEventParameterName = r4
            java.lang.String r0 = r0.toString()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0403
            goto L_0x0404
        L_0x0403:
            r2 = 0
        L_0x0404:
            java.lang.String r0 = "ddl_sent"
            boolean r11 = r11.getMediationNetwork((java.lang.String) r0, (boolean) r1)
            if (r11 == 0) goto L_0x041c
            int r11 = AFInAppEventParameterName
            int r11 = r11 + 105
            int r11 = r11 % 128
            AFInAppEventType = r11
            if (r2 != 0) goto L_0x041c
            java.lang.String r10 = "No direct deep link"
            r13.AFAdRevenueData(r10, r3)
            goto L_0x0442
        L_0x041c:
            com.appsflyer.internal.AFc1dSDK r11 = r13.areAllFieldsValid
            com.appsflyer.internal.AFa1gSDK r11 = r11.afVerboseLog()
            com.appsflyer.internal.AFa1jSDK r11 = com.appsflyer.internal.AFa1jSDK.getCurrencyIso4217Code((com.appsflyer.internal.AFa1gSDK) r11)
            r13.e_(r11, r10, r12)
            goto L_0x0442
        L_0x042a:
            java.lang.Object r3 = getMediationNetwork((java.lang.Object[]) r10)
            goto L_0x0442
        L_0x042f:
            java.lang.Object r3 = getCurrencyIso4217Code((java.lang.Object[]) r10)
            goto L_0x0442
        L_0x0434:
            java.lang.Object r3 = getRevenue((java.lang.Object[]) r10)
            goto L_0x0442
        L_0x0439:
            java.lang.Object r3 = AFAdRevenueData((java.lang.Object[]) r10)
            goto L_0x0442
        L_0x043e:
            java.lang.Object r3 = getMonetizationNetwork((java.lang.Object[]) r10)
        L_0x0442:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1tSDK.getMonetizationNetwork(java.lang.Object[], int, int, int):java.lang.Object");
    }

    public final boolean getMediationNetwork() {
        AFInAppEventType = (AFInAppEventParameterName + 47) % 128;
        if (!getCurrencyIso4217Code(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID)) {
            return false;
        }
        int i = AFInAppEventType + 69;
        AFInAppEventParameterName = i % 128;
        if (i % 2 == 0) {
            return getRevenue() == null;
        }
        getRevenue();
        throw null;
    }

    private static /* synthetic */ Object getMediationNetwork(Object[] objArr) {
        AFa1tSDK aFa1tSDK = objArr[0];
        Context context = objArr[1];
        String str = objArr[2];
        final AppsFlyerRequestListener appsFlyerRequestListener = objArr[3];
        if (aFa1tSDK.AFAdRevenueData().afDebugLog().getCurrencyIso4217Code()) {
            return null;
        }
        if (!aFa1tSDK.toString) {
            AFInAppEventParameterName = (AFInAppEventType + 33) % 128;
            AFAdRevenueData("start");
            if (str == null) {
                int i = AFInAppEventType + 19;
                AFInAppEventParameterName = i % 128;
                if (i % 2 == 0) {
                    if (appsFlyerRequestListener != null) {
                        appsFlyerRequestListener.onError(41, "No dev key");
                    }
                    return null;
                }
                throw null;
            }
        }
        aFa1tSDK.getMediationNetwork(context);
        final AFh1vSDK areAllFieldsValid2 = aFa1tSDK.AFAdRevenueData().areAllFieldsValid();
        areAllFieldsValid2.getMediationNetwork(AFh1tSDK.getRevenue(context));
        if (aFa1tSDK.component1 == null) {
            AFInAppEventType = (AFInAppEventParameterName + 23) % 128;
            Application O_ = AFj1iSDK.O_(context);
            if (O_ == null) {
                return null;
            }
            int i2 = AFInAppEventType + 119;
            AFInAppEventParameterName = i2 % 128;
            if (i2 % 2 == 0) {
                aFa1tSDK.component1 = O_;
            } else {
                aFa1tSDK.component1 = O_;
                throw null;
            }
        }
        aFa1tSDK.AFAdRevenueData().copy().getMediationNetwork("start", str);
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.GENERAL;
        String str2 = getMonetizationNetwork;
        aFLogger.i(aFg1cSDK, "Starting AppsFlyer: (v6.17.0." + str2 + ")");
        StringBuilder sb = new StringBuilder("Build Number: ");
        sb.append(str2);
        aFLogger.i(aFg1cSDK, sb.toString());
        AppsFlyerProperties.getInstance().loadProperties(aFa1tSDK.AFAdRevenueData().component2());
        if (!TextUtils.isEmpty(str)) {
            AFInAppEventParameterName = (AFInAppEventType + 45) % 128;
            aFa1tSDK.AFAdRevenueData().registerClient().AFAdRevenueData(str);
            AFInAppEventParameterName = (AFInAppEventType + 109) % 128;
        } else if (TextUtils.isEmpty(aFa1tSDK.AFAdRevenueData().registerClient().getMediationNetwork())) {
            copy();
            if (appsFlyerRequestListener != null) {
                appsFlyerRequestListener.onError(41, "No dev key");
            }
            return null;
        }
        aFa1tSDK.AFAdRevenueData().component1().getCurrencyIso4217Code(aFa1tSDK.getMonetizationNetwork());
        aFa1tSDK.component4();
        getMonetizationNetwork(aFa1tSDK.component1.getBaseContext());
        aFa1tSDK.AFAdRevenueData().e().getRevenue();
        aFa1tSDK.copy.afDebugLog().AFAdRevenueData(context, new AFb1bSDK.AFa1zSDK() {
            public final void getCurrencyIso4217Code() {
                Context context = AFa1tSDK.this.AFAdRevenueData().AFInAppEventType().getMonetizationNetwork;
                AFLogger.afInfoLog("onBecameBackground");
                AFh1vSDK aFh1vSDK = areAllFieldsValid2;
                long currentTimeMillis = System.currentTimeMillis();
                long j = aFh1vSDK.component3;
                if (j != 0) {
                    long j2 = currentTimeMillis - j;
                    if (j2 > 0 && j2 < 1000) {
                        j2 = 1000;
                    }
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(j2);
                    aFh1vSDK.toString = seconds;
                    aFh1vSDK.getCurrencyIso4217Code.getMonetizationNetwork("prev_session_dur", seconds);
                } else {
                    AFLogger.afInfoLog("Metrics: fg ts is missing");
                }
                AFLogger.afInfoLog("callStatsBackground background call");
                AFa1tSDK.this.AFAdRevenueData().afRDLog().AFAdRevenueData();
                AFd1pSDK copy = AFa1tSDK.this.AFAdRevenueData().copy();
                if (copy.component4()) {
                    copy.getMediationNetwork();
                    if (context != null && !AppsFlyerLib.getInstance().isStopped()) {
                        copy.o_(context.getPackageName(), context.getPackageManager());
                    }
                    copy.AFAdRevenueData();
                } else {
                    AFLogger.afDebugLog("RD status is OFF");
                }
                AFa1tSDK.this.AFAdRevenueData().equals().getRevenue();
                AFa1tSDK.this.AFAdRevenueData().afVerboseLog().getMonetizationNetwork();
                AFa1tSDK.this.AFAdRevenueData().getMediationNetwork().getRevenue();
                AFh1uSDK afErrorLogForExcManagerOnly = AFa1tSDK.this.AFAdRevenueData().afErrorLogForExcManagerOnly();
                if (afErrorLogForExcManagerOnly != null) {
                    afErrorLogForExcManagerOnly.getMediationNetwork();
                }
            }

            public final void getRevenue(@NonNull AFh1qSDK aFh1qSDK) {
                Intent intent;
                areAllFieldsValid2.AFAdRevenueData();
                AFc1dSDK AFAdRevenueData2 = AFa1tSDK.this.AFAdRevenueData();
                AFAdRevenueData2.component1().getCurrencyIso4217Code(AFa1tSDK.this.getMonetizationNetwork());
                AFa1tSDK.this.component4();
                int AFAdRevenueData3 = AFAdRevenueData2.getRevenue().getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0);
                AFLogger.afInfoLog("onBecameForeground");
                if (AFAdRevenueData3 < 2) {
                    AFa1tSDK.this.AFAdRevenueData().equals().getCurrencyIso4217Code();
                }
                AFh1iSDK aFh1iSDK = new AFh1iSDK();
                if (aFh1qSDK != null) {
                    AFa1tSDK.this.AFAdRevenueData().d().e_(AFa1jSDK.AFAdRevenueData(aFh1iSDK), aFh1qSDK.getRevenue, AFAdRevenueData2.AFInAppEventType().getMonetizationNetwork);
                    AFh1uSDK afErrorLogForExcManagerOnly = AFAdRevenueData2.afErrorLogForExcManagerOnly();
                    if (!(afErrorLogForExcManagerOnly == null || (intent = aFh1qSDK.getRevenue) == null)) {
                        afErrorLogForExcManagerOnly.u_(intent, AFa1tSDK.this.AFAdRevenueData().d());
                    }
                }
                AFa1tSDK aFa1tSDK = AFa1tSDK.this;
                aFh1iSDK.getCurrencyIso4217Code = appsFlyerRequestListener;
                aFa1tSDK.getMonetizationNetwork((AFh1rSDK) aFh1iSDK, aFh1qSDK);
                AFa1tSDK.this.AFAdRevenueData().getMediationNetwork().getRevenue();
                AFa1tSDK.this.AFAdRevenueData().getMediationNetwork().AFAdRevenueData.getCurrencyIso4217Code("didSendRevenueTriggerOnLastBackground", false);
            }
        });
        int i3 = AFInAppEventParameterName + 105;
        AFInAppEventType = i3 % 128;
        if (i3 % 2 != 0) {
            return null;
        }
        throw null;
    }

    private static int getCurrencyIso4217Code(AFc1qSDK aFc1qSDK, boolean z) {
        AFInAppEventType = (AFInAppEventParameterName + 125) % 128;
        int monetizationNetwork = getMonetizationNetwork(aFc1qSDK, "appsFlyerInAppEventCount", z);
        int i = AFInAppEventParameterName + 123;
        AFInAppEventType = i % 128;
        if (i % 2 != 0) {
            return monetizationNetwork;
        }
        throw null;
    }

    public static boolean getCurrencyIso4217Code(Context context) {
        return ((Boolean) getMonetizationNetwork(new Object[]{context}, -1675611583, 1675611591, (int) System.currentTimeMillis())).booleanValue();
    }

    @VisibleForTesting
    private void getCurrencyIso4217Code(Context context, String str) {
        getMonetizationNetwork(new Object[]{this, context, str}, 1659672083, -1659672066, System.identityHashCode(this));
    }

    private void getCurrencyIso4217Code(Context context, String str, Map<String, Object> map) {
        getMonetizationNetwork(new Object[]{this, context, str, map}, 1732368696, -1732368678, System.identityHashCode(this));
    }

    private static void getCurrencyIso4217Code(String str, String str2) {
        getMonetizationNetwork(new Object[]{str, str2}, -692563571, 692563575, (int) System.currentTimeMillis());
    }

    public static AFa1tSDK getCurrencyIso4217Code() {
        return (AFa1tSDK) getMonetizationNetwork(new Object[0], -631580017, 631580017, (int) System.currentTimeMillis());
    }

    @NonNull
    private AFj1qSDK[] component3() {
        int i = AFInAppEventType + 121;
        AFInAppEventParameterName = i % 128;
        if (i % 2 == 0) {
            AFj1qSDK[] revenue = AFAdRevenueData().AFLogger().getRevenue();
            int i2 = AFInAppEventParameterName + 65;
            AFInAppEventType = i2 % 128;
            if (i2 % 2 != 0) {
                return revenue;
            }
            throw null;
        }
        AFAdRevenueData().AFLogger().getRevenue();
        throw null;
    }

    private void getMediationNetwork(String str) {
        AFh1rSDK AFAdRevenueData2 = new AFh1jSDK().AFAdRevenueData(AFAdRevenueData().getRevenue().getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0));
        AFAdRevenueData2.component3 = str;
        if (str != null) {
            AFInAppEventType = (AFInAppEventParameterName + 31) % 128;
            if (str.length() > 5) {
                AFInAppEventParameterName = (AFInAppEventType + 59) % 128;
                if (AFAdRevenueData().AFLogger().getCurrencyIso4217Code(AFAdRevenueData2)) {
                    AFj1dSDK.getMediationNetwork(AFAdRevenueData().AFAdRevenueData(), new AFa1ySDK(AFAdRevenueData2), 5, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    @WorkerThread
    @NonNull
    public final Map<String, Object> getMediationNetwork(AFh1rSDK aFh1rSDK) {
        String str;
        AFh1rSDK aFh1rSDK2 = aFh1rSDK;
        boolean z = false;
        Context context = AFAdRevenueData().AFInAppEventType().getMonetizationNetwork;
        AFc1qSDK revenue = getRevenue(context);
        AFg1qSDK component32 = AFAdRevenueData().component3();
        boolean AFAdRevenueData2 = AFAdRevenueData().registerClient().AFAdRevenueData();
        boolean mediationNetwork = aFh1rSDK.getMediationNetwork();
        Map<String, Object> map = aFh1rSDK2.AFAdRevenueData;
        long time = new Date().getTime();
        Object[] objArr = new Object[1];
        a(new int[]{1293966833, -1332243105, 2001922811, -600378744, 548813369, -684723692}, 13 - (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1)), objArr);
        map.put(((String) objArr[0]).intern(), Long.toString(time));
        if (AFAdRevenueData2) {
            AFInAppEventParameterName = (AFInAppEventType + 83) % 128;
            try {
                AFLogger.INSTANCE.i(AFg1cSDK.GENERAL, "AppsFlyer SDK Reporting has been stopped", true);
            } catch (Throwable th) {
                AFLogger.INSTANCE.e(AFg1cSDK.GENERAL, "Error while preparing to send event", th, true, true, true);
            }
        } else {
            AFLogger aFLogger = AFLogger.INSTANCE;
            AFg1cSDK aFg1cSDK = AFg1cSDK.GENERAL;
            StringBuilder sb = new StringBuilder("******* sendTrackingWithEvent: ");
            if (!mediationNetwork) {
                str = aFh1rSDK2.areAllFieldsValid;
            } else {
                AFInAppEventType = (AFInAppEventParameterName + 7) % 128;
                str = "Launch";
            }
            sb.append(str);
            aFLogger.i(aFg1cSDK, sb.toString(), true);
        }
        component4(context);
        int intValue = ((Integer) getMonetizationNetwork(new Object[]{revenue, Boolean.valueOf(mediationNetwork)}, -1175980247, 1175980268, (int) System.currentTimeMillis())).intValue();
        if (aFh1rSDK2.areAllFieldsValid != null) {
            z = true;
        }
        int currencyIso4217Code = getCurrencyIso4217Code(revenue, z);
        if (mediationNetwork) {
            int i = AFInAppEventType;
            AFInAppEventParameterName = (i + 69) % 128;
            if (intValue == 1) {
                AFInAppEventParameterName = (i + 61) % 128;
                AppsFlyerProperties.getInstance().getCurrencyIso4217Code = true;
            }
        }
        component32.getRevenue(map, intValue, currencyIso4217Code);
        return map;
    }

    private static String getMediationNetwork(Activity activity) {
        Intent intent;
        int i = AFInAppEventType + 37;
        AFInAppEventParameterName = i % 128;
        String str = null;
        if (i % 2 == 0) {
            if (!(activity == null || (intent = activity.getIntent()) == null)) {
                AFInAppEventType = (AFInAppEventParameterName + 99) % 128;
                try {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        int i2 = AFInAppEventType + 39;
                        AFInAppEventParameterName = i2 % 128;
                        if (i2 % 2 == 0) {
                            str = extras.getString("af");
                            if (str != null) {
                                AFLogger.INSTANCE.w(AFg1cSDK.ENGAGEMENT, "Push Notification received af payload = ".concat(str));
                                extras.remove("af");
                                activity.setIntent(intent.putExtras(extras));
                                AFInAppEventType = (AFInAppEventParameterName + 29) % 128;
                            }
                        } else {
                            String string = extras.getString("af");
                            try {
                                throw null;
                            } catch (Throwable th) {
                                str = string;
                                th = th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    AFLogger.INSTANCE.e(AFg1cSDK.ENGAGEMENT, th.getMessage(), th);
                    return str;
                }
            }
            return str;
        }
        throw null;
    }

    public static int getMonetizationNetwork(AFc1qSDK aFc1qSDK, boolean z) {
        return ((Integer) getMonetizationNetwork(new Object[]{aFc1qSDK, Boolean.valueOf(z)}, -1175980247, 1175980268, (int) System.currentTimeMillis())).intValue();
    }
}
