package com.appsflyer.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFh1cSDK {
    @Nullable
    public AFi1xSDK AFAdRevenueData;
    @Nullable
    public final AFh1bSDK getCurrencyIso4217Code;
    @Nullable
    public final AFh1dSDK getRevenue;

    public AFh1cSDK(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        this.AFAdRevenueData = getCurrencyIso4217Code(jSONObject);
        this.getRevenue = getRevenue(jSONObject);
        this.getCurrencyIso4217Code = getMonetizationNetwork(jSONObject);
    }

    private static JSONObject AFAdRevenueData(JSONObject jSONObject, String str) throws JSONException, NullPointerException {
        JSONObject optJSONObject;
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.getJSONArray(str).optJSONObject(0).optJSONObject("data")) == null) {
            return null;
        }
        return optJSONObject.optJSONObject("v1");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.appsflyer.internal.AFi1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.appsflyer.internal.AFi1xSDK} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.collections.EmptyList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: kotlin.collections.EmptyList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.collections.EmptyList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.appsflyer.internal.AFi1xSDK getCurrencyIso4217Code(org.json.JSONObject r12) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "r_debugger"
            org.json.JSONObject r12 = AFAdRevenueData(r12, r2)     // Catch:{ all -> 0x0052 }
            if (r12 == 0) goto L_0x0066
            java.lang.String r2 = "ttl"
            long r4 = r12.getLong(r2)     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "counter"
            int r8 = r12.getInt(r2)     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "app_ver"
            java.lang.String r9 = r12.optString(r2, r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "sdk_ver"
            java.lang.String r10 = r12.optString(r2, r0)     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "ratio"
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r2 = r12.optDouble(r2, r6)     // Catch:{ all -> 0x0052 }
            float r6 = (float) r2     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = "tags"
            org.json.JSONArray r12 = r12.optJSONArray(r2)     // Catch:{ all -> 0x0052 }
            if (r12 == 0) goto L_0x0056
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)     // Catch:{ all -> 0x0052 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r2.<init>()     // Catch:{ all -> 0x0052 }
            int r3 = r12.length()     // Catch:{ all -> 0x0052 }
            r7 = 0
        L_0x0043:
            if (r7 >= r3) goto L_0x0054
            java.lang.String r11 = r12.getString(r7)     // Catch:{ all -> 0x0052 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)     // Catch:{ all -> 0x0052 }
            r2.add(r11)     // Catch:{ all -> 0x0052 }
            int r7 = r7 + 1
            goto L_0x0043
        L_0x0052:
            r12 = move-exception
            goto L_0x006c
        L_0x0054:
            r7 = r2
            goto L_0x0059
        L_0x0056:
            kotlin.collections.EmptyList r12 = kotlin.collections.EmptyList.INSTANCE     // Catch:{ all -> 0x0052 }
            r7 = r12
        L_0x0059:
            com.appsflyer.internal.AFi1xSDK r12 = new com.appsflyer.internal.AFi1xSDK     // Catch:{ all -> 0x0052 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)     // Catch:{ all -> 0x0052 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch:{ all -> 0x0052 }
            r3 = r12
            r3.<init>(r4, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0052 }
            goto L_0x0067
        L_0x0066:
            r12 = r1
        L_0x0067:
            java.lang.Object r12 = kotlin.Result.m16constructorimpl(r12)     // Catch:{ all -> 0x0052 }
            goto L_0x0076
        L_0x006c:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            kotlin.Result$Failure r12 = kotlin.ResultKt.a(r12)
            java.lang.Object r12 = kotlin.Result.m16constructorimpl(r12)
        L_0x0076:
            boolean r0 = kotlin.Result.m21isFailureimpl(r12)
            if (r0 == 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r1 = r12
        L_0x007e:
            com.appsflyer.internal.AFi1xSDK r1 = (com.appsflyer.internal.AFi1xSDK) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFh1cSDK.getCurrencyIso4217Code(org.json.JSONObject):com.appsflyer.internal.AFi1xSDK");
    }

    private static AFh1bSDK getMonetizationNetwork(JSONObject jSONObject) {
        Object obj;
        AFh1bSDK aFh1bSDK;
        AFh1bSDK aFh1bSDK2 = null;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject AFAdRevenueData2 = AFAdRevenueData(jSONObject, "meta_data");
            if (AFAdRevenueData2 != null) {
                aFh1bSDK = new AFh1bSDK(AFAdRevenueData2.optDouble("send_rate", 1.0d));
            } else {
                aFh1bSDK = null;
            }
            obj = Result.m16constructorimpl(aFh1bSDK);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m16constructorimpl(ResultKt.a(th));
        }
        if (!Result.m21isFailureimpl(obj)) {
            aFh1bSDK2 = obj;
        }
        return aFh1bSDK2;
    }

    private static AFh1dSDK getRevenue(JSONObject jSONObject) {
        Object obj;
        AFh1dSDK aFh1dSDK;
        AFh1dSDK aFh1dSDK2 = null;
        try {
            Result.Companion companion = Result.Companion;
            JSONObject AFAdRevenueData2 = AFAdRevenueData(jSONObject, "exc_mngr");
            if (AFAdRevenueData2 != null) {
                aFh1dSDK = new AFh1dSDK(AFAdRevenueData2.getString("sdk_ver"), AFAdRevenueData2.optInt("min", -1), AFAdRevenueData2.optInt("expire", -1), AFAdRevenueData2.optLong("ttl", -1));
            } else {
                aFh1dSDK = null;
            }
            obj = Result.m16constructorimpl(aFh1dSDK);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m16constructorimpl(ResultKt.a(th));
        }
        if (!Result.m21isFailureimpl(obj)) {
            aFh1dSDK2 = obj;
        }
        return aFh1dSDK2;
    }

    public final boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!AFh1cSDK.class.equals(cls)) {
            return false;
        }
        Intrinsics.d(obj, "");
        AFh1cSDK aFh1cSDK = (AFh1cSDK) obj;
        if (Intrinsics.a(this.getRevenue, aFh1cSDK.getRevenue) && Intrinsics.a(this.getCurrencyIso4217Code, aFh1cSDK.getCurrencyIso4217Code) && Intrinsics.a(this.AFAdRevenueData, aFh1cSDK.AFAdRevenueData)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        AFh1dSDK aFh1dSDK = this.getRevenue;
        int i3 = 0;
        if (aFh1dSDK != null) {
            i = aFh1dSDK.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * 31;
        AFh1bSDK aFh1bSDK = this.getCurrencyIso4217Code;
        if (aFh1bSDK != null) {
            i2 = aFh1bSDK.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i4 + i2) * 31;
        AFi1xSDK aFi1xSDK = this.AFAdRevenueData;
        if (aFi1xSDK != null) {
            i3 = aFi1xSDK.hashCode();
        }
        return i5 + i3;
    }
}
