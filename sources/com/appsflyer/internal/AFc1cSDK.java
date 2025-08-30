package com.appsflyer.internal;

import android.util.Base64;
import com.google.firebase.messaging.Constants;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\f¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018"}, d2 = {"Lcom/appsflyer/internal/AFc1cSDK;", "", "", "p0", "p1", "p2", "", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lorg/json/JSONObject;", "getRevenue", "()Lorg/json/JSONObject;", "AFAdRevenueData", "()Ljava/lang/String;", "toString", "getMediationNetwork", "I", "getMonetizationNetwork", "Ljava/lang/String;", "getCurrencyIso4217Code", "AFa1ySDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFc1cSDK {
    @NotNull
    public static final AFa1ySDK AFa1ySDK = new AFa1ySDK((DefaultConstructorMarker) null);
    @NotNull
    public String AFAdRevenueData;
    int getMediationNetwork;
    @NotNull
    final String getMonetizationNetwork;
    @NotNull
    public String getRevenue;

    @SourceDebugExtension({"SMAP\nExceptionInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionInfo.kt\ncom/appsflyer/internal/components/monitorsdk/exmanager/ExceptionInfo$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,94:1\n13579#2,2:95\n*S KotlinDebug\n*F\n+ 1 ExceptionInfo.kt\ncom/appsflyer/internal/components/monitorsdk/exmanager/ExceptionInfo$Companion\n*L\n65#1:95,2\n*E\n"})
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000f"}, d2 = {"Lcom/appsflyer/internal/AFc1cSDK$AFa1ySDK;", "", "<init>", "()V", "", "p0", "", "", "p1", "", "getMediationNetwork", "(Ljava/lang/Integer;[Ljava/lang/String;)Z", "Lcom/appsflyer/internal/AFc1cSDK;", "getRevenue", "(Ljava/lang/String;)Lcom/appsflyer/internal/AFc1cSDK;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AFa1ySDK {
        private AFa1ySDK() {
        }

        private static boolean getMediationNetwork(Integer num, String... strArr) {
            boolean z;
            boolean z2;
            if (num == null) {
                z = true;
            } else {
                z = false;
            }
            int length = strArr.length;
            for (int i = 0; i < 3; i++) {
                String str = strArr[i];
                if (z || str == null || str.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            return z;
        }

        @Nullable
        public static AFc1cSDK getRevenue(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "");
            List<String> G = StringsKt__StringsKt.split$default(str, new String[]{StringUtils.LF}, false, 0, 6, (Object) null);
            if (G.size() != 4) {
                return null;
            }
            String str2 = null;
            String str3 = null;
            String str4 = null;
            Integer num = null;
            for (String str5 : G) {
                if (!StringsKt.I(str5, "label=", false)) {
                    if (!StringsKt.I(str5, "hashName=", false)) {
                        if (!StringsKt.I(str5, "stackTrace=", false)) {
                            if (!StringsKt.I(str5, "c=", false)) {
                                break;
                            }
                            String substring = str5.substring(2);
                            Intrinsics.checkNotNullExpressionValue(substring, "");
                            num = Integer.valueOf(Integer.parseInt(StringsKt.Q(substring).toString()));
                        } else {
                            str4 = getRevenue(str5, "stackTrace=");
                        }
                    } else {
                        str3 = getRevenue(str5, "hashName=");
                    }
                } else {
                    str2 = getRevenue(str5, "label=");
                }
            }
            if (getMediationNetwork(num, str2, str3, str4)) {
                return null;
            }
            Intrinsics.c(str2);
            Intrinsics.c(str3);
            Intrinsics.c(str4);
            Intrinsics.c(num);
            return new AFc1cSDK(str2, str3, str4, num.intValue());
        }

        public /* synthetic */ AFa1ySDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static String getRevenue(String str, String str2) {
            String substring = str.substring(str2.length());
            Intrinsics.checkNotNullExpressionValue(substring, "");
            String obj = StringsKt.Q(substring).toString();
            Intrinsics.checkNotNullParameter(obj, "");
            Charset charset = Charsets.UTF_8;
            byte[] bytes = obj.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            Intrinsics.checkNotNullParameter(bytes, "");
            byte[] decode = Base64.decode(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(decode, "");
            return new String(decode, charset);
        }
    }

    public AFc1cSDK(@NotNull String str, @NotNull String str2, @NotNull String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.getRevenue = str;
        this.getMonetizationNetwork = str2;
        this.AFAdRevenueData = str3;
        this.getMediationNetwork = i;
    }

    @NotNull
    public final String AFAdRevenueData() {
        String str = this.getRevenue;
        Intrinsics.checkNotNullParameter(str, "");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        String encodeToString = Base64.encodeToString(bytes, 2);
        String str2 = this.getMonetizationNetwork;
        Intrinsics.checkNotNullParameter(str2, "");
        byte[] bytes2 = str2.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "");
        String encodeToString2 = Base64.encodeToString(bytes2, 2);
        String str3 = this.AFAdRevenueData;
        Intrinsics.checkNotNullParameter(str3, "");
        byte[] bytes3 = str3.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes3, "");
        String encodeToString3 = Base64.encodeToString(bytes3, 2);
        int i = this.getMediationNetwork;
        StringBuilder u = e.u("label=", encodeToString, "\nhashName=", encodeToString2, "\nstackTrace=");
        u.append(encodeToString3);
        u.append("\nc=");
        u.append(i);
        return u.toString();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFc1cSDK)) {
            return false;
        }
        AFc1cSDK aFc1cSDK = (AFc1cSDK) obj;
        if (Intrinsics.a(this.getRevenue, aFc1cSDK.getRevenue) && Intrinsics.a(this.getMonetizationNetwork, aFc1cSDK.getMonetizationNetwork) && Intrinsics.a(this.AFAdRevenueData, aFc1cSDK.AFAdRevenueData) && this.getMediationNetwork == aFc1cSDK.getMediationNetwork) {
            return true;
        }
        return false;
    }

    @NotNull
    public final JSONObject getRevenue() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, this.getRevenue);
        jSONObject.put("hash_name", this.getMonetizationNetwork);
        jSONObject.put("st", this.AFAdRevenueData);
        jSONObject.put("c", String.valueOf(this.getMediationNetwork));
        return jSONObject;
    }

    public final int hashCode() {
        int hashCode = this.getMonetizationNetwork.hashCode();
        return ((this.AFAdRevenueData.hashCode() + ((hashCode + (this.getRevenue.hashCode() * 31)) * 31)) * 31) + this.getMediationNetwork;
    }

    @NotNull
    public final String toString() {
        String str = this.getRevenue;
        String str2 = this.getMonetizationNetwork;
        String str3 = this.AFAdRevenueData;
        int i = this.getMediationNetwork;
        StringBuilder u = e.u("ExceptionInfo(label=", str, ", hashName=", str2, ", stackTrace=");
        u.append(str3);
        u.append(", counter=");
        u.append(i);
        u.append(")");
        return u.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFc1cSDK(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? 1 : i);
    }
}
