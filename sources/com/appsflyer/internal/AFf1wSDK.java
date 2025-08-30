package com.appsflyer.internal;

import android.media.AudioTrack;
import android.view.View;
import com.appsflyer.AFLogger;
import com.facebook.internal.NativeProtocol;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0018\u0010\u000fJ\u000f\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u0018\u0010\u001eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lcom/appsflyer/internal/AFf1wSDK;", "Lcom/appsflyer/internal/AFf1uSDK;", "Lcom/appsflyer/internal/AFi1fSDK;", "p0", "Lcom/appsflyer/internal/AFc1pSDK;", "p1", "Lcom/appsflyer/internal/AFc1dSDK;", "p2", "Lcom/appsflyer/internal/AFh1eSDK;", "p3", "<init>", "(Lcom/appsflyer/internal/AFi1fSDK;Lcom/appsflyer/internal/AFc1pSDK;Lcom/appsflyer/internal/AFc1dSDK;Lcom/appsflyer/internal/AFh1eSDK;)V", "Lcom/appsflyer/internal/AFh1rSDK;", "", "areAllFieldsValid", "(Lcom/appsflyer/internal/AFh1rSDK;)V", "", "getMonetizationNetwork", "()J", "", "", "", "copy", "()Ljava/util/Map;", "AFAdRevenueData", "", "copydefault", "()Z", "getMediationNetwork", "", "(I)V", "equals", "Lcom/appsflyer/internal/AFc1pSDK;", "hashCode", "Lcom/appsflyer/internal/AFi1fSDK;", "getRevenue"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFf1wSDK extends AFf1uSDK {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] AFInAppEventParameterName = {10791, 10809, 10763, 10805, 10784, 10788, 10801, 10813, 10802};
    private static int AFKeystoreWrapper = 1;
    private static char AFLogger = 8141;
    private static int registerClient;
    @NotNull
    private final AFc1pSDK equals;
    @NotNull
    private final AFi1fSDK hashCode;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFf1wSDK(AFi1fSDK aFi1fSDK, AFc1pSDK aFc1pSDK, AFc1dSDK aFc1dSDK, AFh1eSDK aFh1eSDK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFi1fSDK, aFc1pSDK, aFc1dSDK, (i & 8) != 0 ? new AFh1eSDK() : aFh1eSDK);
    }

    private static void a(byte b, String str, int i, Object[] objArr) {
        Object obj;
        int i2;
        int i3 = i;
        if (str != null) {
            obj = str.toCharArray();
        } else {
            obj = str;
        }
        char[] cArr = (char[]) obj;
        AFk1mSDK aFk1mSDK = new AFk1mSDK();
        char[] cArr2 = AFInAppEventParameterName;
        if (cArr2 != null) {
            $11 = ($10 + 121) % 128;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i4 = 0; i4 < length; i4++) {
                cArr3[i4] = (char) ((int) (((long) cArr2[i4]) ^ -374623853307093042L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((int) (-374623853307093042L ^ ((long) AFLogger)));
        char[] cArr4 = new char[i3];
        if (i3 % 2 != 0) {
            $10 = ($11 + 109) % 128;
            i2 = i3 - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i3;
        }
        if (i2 > 1) {
            int i5 = $11 + 67;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            aFk1mSDK.AFAdRevenueData = 0;
            while (true) {
                int i7 = aFk1mSDK.AFAdRevenueData;
                if (i7 >= i2) {
                    break;
                }
                int i8 = $11;
                int i9 = (i8 + 57) % 128;
                $10 = i9;
                char c2 = cArr[i7];
                aFk1mSDK.getMonetizationNetwork = c2;
                char c3 = cArr[i7 + 1];
                aFk1mSDK.getCurrencyIso4217Code = c3;
                if (c2 == c3) {
                    int i10 = i8 + 81;
                    $10 = i10 % 128;
                    if (i10 % 2 != 0) {
                        cArr4[i7] = (char) (c2 >>> b);
                        cArr4[i7 >> 1] = (char) (c3 << b);
                    } else {
                        cArr4[i7] = (char) (c2 - b);
                        cArr4[i7 + 1] = (char) (c3 - b);
                    }
                } else {
                    int i11 = c2 / c;
                    aFk1mSDK.getMediationNetwork = i11;
                    int i12 = c2 % c;
                    aFk1mSDK.component1 = i12;
                    int i13 = c3 / c;
                    aFk1mSDK.getRevenue = i13;
                    int i14 = c3 % c;
                    aFk1mSDK.component2 = i14;
                    if (i12 == i14) {
                        int i15 = (i9 + 3) % 128;
                        $11 = i15;
                        int i16 = ((i11 + c) - 1) % c;
                        aFk1mSDK.getMediationNetwork = i16;
                        int i17 = ((i13 + c) - 1) % c;
                        aFk1mSDK.getRevenue = i17;
                        cArr4[i7] = cArr2[(i16 * c) + i12];
                        cArr4[i7 + 1] = cArr2[(i17 * c) + i14];
                        $10 = (i15 + 19) % 128;
                    } else if (i11 == i13) {
                        int i18 = ((i12 + c) - 1) % c;
                        aFk1mSDK.component1 = i18;
                        int i19 = ((i14 + c) - 1) % c;
                        aFk1mSDK.component2 = i19;
                        cArr4[i7] = cArr2[(i11 * c) + i18];
                        cArr4[i7 + 1] = cArr2[(i13 * c) + i19];
                    } else {
                        cArr4[i7] = cArr2[(i11 * c) + i14];
                        cArr4[i7 + 1] = cArr2[(i13 * c) + i12];
                    }
                }
                aFk1mSDK.AFAdRevenueData = i7 + 2;
            }
        }
        for (int i20 = 0; i20 < i3; i20++) {
            cArr4[i20] = (char) (cArr4[i20] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }

    private final void areAllFieldsValid(AFh1rSDK aFh1rSDK) {
        try {
            Map map = (Map) getCurrencyIso4217Code(new Object[]{this});
            if (map != null) {
                int i = AFKeystoreWrapper + 97;
                registerClient = i % 128;
                if (i % 2 == 0) {
                    aFh1rSDK.getMediationNetwork(map);
                } else {
                    aFh1rSDK.getMediationNetwork(map);
                    throw null;
                }
            }
            if (!this.hashCode.AFAdRevenueData()) {
                registerClient = (AFKeystoreWrapper + 3) % 128;
                Map<String, Object> component1 = AFf1rSDK.component1(aFh1rSDK);
                Intrinsics.checkNotNullExpressionValue(component1, "");
                component1.put("pia_disabled", Boolean.TRUE);
            }
        } catch (Throwable th) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PLAY_INTEGRITY_API, "Error while adding PIA data to payload", th, true, false, false, false, 96, (Object) null);
        }
    }

    private final Map<String, Object> copy() {
        return (Map) getCurrencyIso4217Code(new Object[]{this});
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object getCurrencyIso4217Code(Object[] objArr) {
        registerClient = (AFKeystoreWrapper + 75) % 128;
        AFi1hSDK currencyIso4217Code = objArr[0].hashCode.getCurrencyIso4217Code();
        if (currencyIso4217Code == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("pia_timestamp", Long.valueOf(currencyIso4217Code.AFAdRevenueData));
        linkedHashMap2.put("ttr_millis", Long.valueOf(currencyIso4217Code.getRevenue));
        String str = currencyIso4217Code.getCurrencyIso4217Code;
        if (str != null) {
            int i = AFKeystoreWrapper + 117;
            registerClient = i % 128;
            if (i % 2 == 0) {
                linkedHashMap2.put("pia_token", str);
            } else {
                linkedHashMap2.put("pia_token", str);
                throw null;
            }
        }
        String str2 = currencyIso4217Code.getMonetizationNetwork;
        if (str2 != null) {
            registerClient = (AFKeystoreWrapper + 55) % 128;
            linkedHashMap2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, str2);
            registerClient = (AFKeystoreWrapper + 19) % 128;
        }
        linkedHashMap.put("pia", linkedHashMap2);
        return linkedHashMap;
    }

    public final void AFAdRevenueData(int i) {
        int i2 = registerClient + 69;
        AFKeystoreWrapper = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    public final boolean copydefault() {
        int i = (registerClient + 31) % 128;
        AFKeystoreWrapper = i;
        registerClient = (i + 67) % 128;
        return false;
    }

    public final boolean getMediationNetwork() {
        registerClient = (AFKeystoreWrapper + 97) % 128;
        return false;
    }

    public final long getMonetizationNetwork() {
        AFKeystoreWrapper = (registerClient + 63) % 128;
        long millis = TimeUnit.MINUTES.toMillis(1);
        AFKeystoreWrapper = (registerClient + 85) % 128;
        return millis;
    }

    public final void AFAdRevenueData(@NotNull AFh1rSDK aFh1rSDK) {
        Intrinsics.checkNotNullParameter(aFh1rSDK, "");
        Map<String, Object> map = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map, "");
        Object[] objArr = new Object[1];
        a((byte) (View.resolveSize(0, 0) + 107), "\u0005\u0006\u0001\u0005\u0001\u0004\u0000\u0003\u0005\u0004\u0002\u0004", 13 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr);
        map.put(((String) objArr[0]).intern(), String.valueOf(new Date().getTime()));
        super.AFAdRevenueData(aFh1rSDK);
        areAllFieldsValid(aFh1rSDK);
        AFg1qSDK aFg1qSDK = this.toString;
        Map<String, Object> map2 = aFh1rSDK.AFAdRevenueData;
        Intrinsics.checkNotNullExpressionValue(map2, "");
        aFg1qSDK.getRevenue(map2, this.equals.getMonetizationNetwork.AFAdRevenueData("appsFlyerCount", 0), this.equals.getMonetizationNetwork.AFAdRevenueData("appsFlyerInAppEventCount", 0));
        int i = registerClient + 111;
        AFKeystoreWrapper = i % 128;
        if (i % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    private AFf1wSDK(@NotNull AFi1fSDK aFi1fSDK, @NotNull AFc1pSDK aFc1pSDK, @NotNull AFc1dSDK aFc1dSDK, @NotNull AFh1eSDK aFh1eSDK) {
        super(aFh1eSDK, aFc1dSDK);
        Intrinsics.checkNotNullParameter(aFi1fSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        Intrinsics.checkNotNullParameter(aFh1eSDK, "");
        this.hashCode = aFi1fSDK;
        this.equals = aFc1pSDK;
        this.getCurrencyIso4217Code.add(AFe1mSDK.CONVERSION);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AFf1wSDK(@NotNull AFi1fSDK aFi1fSDK, @NotNull AFc1pSDK aFc1pSDK, @NotNull AFc1dSDK aFc1dSDK) {
        this(aFi1fSDK, aFc1pSDK, aFc1dSDK, (AFh1eSDK) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(aFi1fSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
    }
}
