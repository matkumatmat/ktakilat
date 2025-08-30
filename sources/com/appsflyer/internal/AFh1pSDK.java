package com.appsflyer.internal;

import android.content.Intent;
import android.graphics.ImageFormat;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.WorkerThread;
import com.appsflyer.migration.internal.MigrationDataProvider;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class AFh1pSDK implements AFh1uSDK {
    @NotNull
    private final AFj1sSDK AFAdRevenueData;
    private boolean component1;
    private boolean component2;
    @NotNull
    private final AFc1pSDK getCurrencyIso4217Code;
    @Nullable
    private Long getMediationNetwork;
    @Nullable
    private JSONObject getMonetizationNetwork;
    @Nullable
    private Long getRevenue;

    public /* synthetic */ class AFa1tSDK {
        public static final /* synthetic */ int[] getMediationNetwork;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.appsflyer.internal.AFe1mSDK[] r0 = com.appsflyer.internal.AFe1mSDK.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.appsflyer.internal.AFe1mSDK r1 = com.appsflyer.internal.AFe1mSDK.LAUNCH     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.appsflyer.internal.AFe1mSDK r1 = com.appsflyer.internal.AFe1mSDK.ATTR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                getMediationNetwork = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFh1pSDK.AFa1tSDK.<clinit>():void");
        }
    }

    public AFh1pSDK(@NotNull AFc1pSDK aFc1pSDK, @NotNull AFj1sSDK aFj1sSDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFj1sSDK, "");
        this.getCurrencyIso4217Code = aFc1pSDK;
        this.AFAdRevenueData = aFj1sSDK;
    }

    private final void getMonetizationNetwork(String str, AFh1rSDK aFh1rSDK, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, jSONObject);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("branch", hashMap);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("external", hashMap2);
        aFh1rSDK.getMediationNetwork(hashMap3);
        Map<String, Object> map = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map, "");
        AFe1mSDK currencyIso4217Code = aFh1rSDK.getCurrencyIso4217Code();
        Intrinsics.checkNotNullExpressionValue(currencyIso4217Code, "");
        getMonetizationNetwork(map, currencyIso4217Code);
    }

    public final void getCurrencyIso4217Code(@NotNull AFh1rSDK aFh1rSDK) {
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        JSONObject attributionData = MigrationDataProvider.getAttributionData();
        if (attributionData != null) {
            getMonetizationNetwork("attr", aFh1rSDK, attributionData);
            this.component2 = true;
        }
        MigrationDataProvider.clear();
    }

    @WorkerThread
    public final void getMediationNetwork(@NotNull AFh1rSDK aFh1rSDK) {
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        JSONObject jSONObject = this.getMonetizationNetwork;
        if (jSONObject != null) {
            Intrinsics.c(jSONObject);
            getMonetizationNetwork("attr", aFh1rSDK, jSONObject);
        } else {
            JSONObject currencyIso4217Code = getCurrencyIso4217Code();
            if (currencyIso4217Code != null) {
                getMonetizationNetwork("attr", aFh1rSDK, currencyIso4217Code);
            }
        }
        MigrationDataProvider.clear();
    }

    @WorkerThread
    public final void getRevenue(@NotNull AFf1uSDK aFf1uSDK, @NotNull Function0<Unit> function0) {
        JSONObject currencyIso4217Code;
        Intrinsics.checkNotNullParameter(aFf1uSDK, "");
        Intrinsics.checkNotNullParameter(function0, "");
        if (this.getCurrencyIso4217Code.getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0) == 1 && aFf1uSDK.getMonetizationNetwork == AFe1mSDK.CONVERSION && this.AFAdRevenueData.AFAdRevenueData() && !getMonetizationNetwork() && (currencyIso4217Code = getCurrencyIso4217Code()) != null) {
            this.getMonetizationNetwork = currencyIso4217Code;
            function0.invoke();
        }
    }

    public final void u_(@NotNull Intent intent, @NotNull AFa1oSDK aFa1oSDK) {
        Intrinsics.checkNotNullParameter(intent, "");
        Intrinsics.checkNotNullParameter(aFa1oSDK, "");
        if (MigrationDataProvider.waitForDeepLinkingData(0) != null) {
            this.component1 = true;
            return;
        }
        Uri data = intent.getData();
        if (data != null) {
            try {
                Object[] objArr = new Object[2];
                objArr[1] = aFa1oSDK;
                objArr[0] = data;
                Map map = AFa1kSDK.i;
                Object obj = map.get(-1523018365);
                if (obj == null) {
                    obj = ((Class) AFa1kSDK.getCurrencyIso4217Code(KeyEvent.getDeadChar(0, 0), (char) (-1 - ImageFormat.getBitsPerPixel(0)), 38 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)))).getDeclaredConstructor(new Class[]{Uri.class, AFa1oSDK.class});
                    map.put(-1523018365, obj);
                }
                Object newInstance = ((Constructor) obj).newInstance(objArr);
                Object obj2 = map.get(1191605722);
                if (obj2 == null) {
                    obj2 = ((Class) AFa1kSDK.getCurrencyIso4217Code(-1 - MotionEvent.axisFromString(""), (char) TextUtils.indexOf("", ""), 37 - TextUtils.indexOf("", ""))).getMethod("getRevenue", (Class[]) null);
                    map.put(1191605722, obj2);
                }
                Object invoke = ((Method) obj2).invoke(newInstance, (Object[]) null);
                Object obj3 = map.get(1984406162);
                if (obj3 == null) {
                    obj3 = ((Class) AFa1kSDK.getCurrencyIso4217Code((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 37, (char) (TextUtils.indexOf("", "") + 44102), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 50)).getMethod("getRevenue", (Class[]) null);
                    map.put(1984406162, obj3);
                }
                this.component1 = !((Boolean) ((Method) obj3).invoke(invoke, (Object[]) null)).booleanValue();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    private final JSONObject getCurrencyIso4217Code() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject waitForAttributionData = MigrationDataProvider.waitForAttributionData(3000);
        if (waitForAttributionData != null) {
            this.getMediationNetwork = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        }
        return waitForAttributionData;
    }

    public final void getMediationNetwork() {
        this.component1 = false;
        MigrationDataProvider.clear();
    }

    private final void getMonetizationNetwork(Map<String, Object> map, AFe1mSDK aFe1mSDK) {
        Long l;
        int i = AFa1tSDK.getMediationNetwork[aFe1mSDK.ordinal()];
        if (i == 1) {
            l = this.getRevenue;
        } else if (i != 2) {
            l = null;
        } else {
            l = this.getMediationNetwork;
        }
        if (l != null) {
            long longValue = l.longValue();
            Map<String, Object> revenue = AFa1tSDK.getRevenue(map);
            Intrinsics.checkNotNullExpressionValue(revenue, "");
            revenue.put("migration", MapsKt.d(new Pair("delay", Long.valueOf(longValue))));
        }
    }

    public final boolean getRevenue() {
        return this.component1;
    }

    public final boolean getMonetizationNetwork() {
        return this.component2;
    }

    @WorkerThread
    public final void getMonetizationNetwork(@NotNull AFh1rSDK aFh1rSDK) {
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject waitForDeepLinkingData = MigrationDataProvider.waitForDeepLinkingData(3000);
        if (waitForDeepLinkingData != null) {
            this.getRevenue = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            getMonetizationNetwork("dl", aFh1rSDK, waitForDeepLinkingData);
        }
        MigrationDataProvider.clear();
    }
}
