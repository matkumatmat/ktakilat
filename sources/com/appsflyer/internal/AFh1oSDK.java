package com.appsflyer.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0006X\f¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0006X\f¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0007@\u0006X\f¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0007@\u0006X\f¢\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\f¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0007@\u0006X\f¢\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b8\u0006@\u0006X\f¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00048\u0007@\u0006X\f¢\u0006\u0006\n\u0004\b!\u0010\u001c"}, d2 = {"Lcom/appsflyer/internal/AFh1oSDK;", "", "", "p0", "", "p1", "p2", "p3", "p4", "p5", "p6", "", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)V", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "AFAdRevenueData", "Ljava/lang/String;", "getRevenue", "areAllFieldsValid", "getMediationNetwork", "getMonetizationNetwork", "Ljava/lang/Boolean;", "getCurrencyIso4217Code", "component3", "component1", "Ljava/util/Map;", "component2", "component4"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFh1oSDK {
    @Nullable
    public String AFAdRevenueData;
    @Nullable
    public String areAllFieldsValid;
    @NotNull
    public Map<String, Object> component1;
    @Nullable
    public Boolean component2;
    @Nullable
    public Boolean getCurrencyIso4217Code;
    @Nullable
    public Boolean getMediationNetwork;
    @Nullable
    public Boolean getMonetizationNetwork;
    @Nullable
    public Boolean getRevenue;

    private AFh1oSDK(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str2, @Nullable Boolean bool5, @NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.AFAdRevenueData = str;
        this.getRevenue = bool;
        this.getMonetizationNetwork = bool2;
        this.getMediationNetwork = bool3;
        this.getCurrencyIso4217Code = bool4;
        this.areAllFieldsValid = str2;
        this.component2 = bool5;
        this.component1 = map;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFh1oSDK)) {
            return false;
        }
        AFh1oSDK aFh1oSDK = (AFh1oSDK) obj;
        if (Intrinsics.a(this.AFAdRevenueData, aFh1oSDK.AFAdRevenueData) && Intrinsics.a(this.getRevenue, aFh1oSDK.getRevenue) && Intrinsics.a(this.getMonetizationNetwork, aFh1oSDK.getMonetizationNetwork) && Intrinsics.a(this.getMediationNetwork, aFh1oSDK.getMediationNetwork) && Intrinsics.a(this.getCurrencyIso4217Code, aFh1oSDK.getCurrencyIso4217Code) && Intrinsics.a(this.areAllFieldsValid, aFh1oSDK.areAllFieldsValid) && Intrinsics.a(this.component2, aFh1oSDK.component2) && Intrinsics.a(this.component1, aFh1oSDK.component1)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str = this.AFAdRevenueData;
        int i7 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i8 = i * 31;
        Boolean bool = this.getRevenue;
        if (bool == null) {
            i2 = 0;
        } else {
            i2 = bool.hashCode();
        }
        int i9 = (i8 + i2) * 31;
        Boolean bool2 = this.getMonetizationNetwork;
        if (bool2 == null) {
            i3 = 0;
        } else {
            i3 = bool2.hashCode();
        }
        int i10 = (i9 + i3) * 31;
        Boolean bool3 = this.getMediationNetwork;
        if (bool3 == null) {
            i4 = 0;
        } else {
            i4 = bool3.hashCode();
        }
        int i11 = (i10 + i4) * 31;
        Boolean bool4 = this.getCurrencyIso4217Code;
        if (bool4 == null) {
            i5 = 0;
        } else {
            i5 = bool4.hashCode();
        }
        int i12 = (i11 + i5) * 31;
        String str2 = this.areAllFieldsValid;
        if (str2 == null) {
            i6 = 0;
        } else {
            i6 = str2.hashCode();
        }
        int i13 = (i12 + i6) * 31;
        Boolean bool5 = this.component2;
        if (bool5 != null) {
            i7 = bool5.hashCode();
        }
        return this.component1.hashCode() + ((i13 + i7) * 31);
    }

    @NotNull
    public final String toString() {
        String str = this.AFAdRevenueData;
        Boolean bool = this.getRevenue;
        Boolean bool2 = this.getMonetizationNetwork;
        Boolean bool3 = this.getMediationNetwork;
        Boolean bool4 = this.getCurrencyIso4217Code;
        String str2 = this.areAllFieldsValid;
        Boolean bool5 = this.component2;
        Map<String, Object> map = this.component1;
        return "AdvertisingIdData(advertisingId=" + str + ", isLimited=" + bool + ", isEnabled=" + bool2 + ", isGaidWithGps=" + bool3 + ", isGaidWithSamsungCloudDev=" + bool4 + ", gaidError=" + str2 + ", retry=" + bool5 + ", metadata=" + map + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AFh1oSDK(java.lang.String r10, java.lang.Boolean r11, java.lang.Boolean r12, java.lang.Boolean r13, java.lang.Boolean r14, java.lang.String r15, java.lang.Boolean r16, java.util.Map r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r2 = r16
        L_0x0034:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003e
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            goto L_0x0040
        L_0x003e:
            r0 = r17
        L_0x0040:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r2
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFh1oSDK.<init>(java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public AFh1oSDK() {
        this((String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (Map) null, 255, (DefaultConstructorMarker) null);
    }
}
