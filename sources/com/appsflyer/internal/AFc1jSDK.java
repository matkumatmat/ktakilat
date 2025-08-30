package com.appsflyer.internal;

import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AFc1jSDK implements AFc1qSDK {
    /* access modifiers changed from: private */
    @NotNull
    public final AFc1hSDK<SharedPreferences> getMediationNetwork;
    @NotNull
    private final Lazy getMonetizationNetwork = LazyKt.b(new Function0<SharedPreferences>(this) {
        private /* synthetic */ AFc1jSDK getMonetizationNetwork;

        {
            this.getMonetizationNetwork = r1;
        }

        @NotNull
        /* renamed from: l_ */
        public final SharedPreferences invoke() {
            return (SharedPreferences) this.getMonetizationNetwork.getMediationNetwork.getMonetizationNetwork.invoke();
        }
    });

    public AFc1jSDK(@NotNull AFc1hSDK<SharedPreferences> aFc1hSDK) {
        Intrinsics.checkNotNullParameter(aFc1hSDK, "");
        this.getMediationNetwork = aFc1hSDK;
    }

    public final void getCurrencyIso4217Code(@Nullable String str, boolean z) {
        ((SharedPreferences) this.getMonetizationNetwork.getValue()).edit().putBoolean(str, z).apply();
    }

    public final void getMediationNetwork(@Nullable String str, @Nullable String str2) {
        ((SharedPreferences) this.getMonetizationNetwork.getValue()).edit().putString(str, str2).apply();
    }

    public final void getMonetizationNetwork(@Nullable String str, long j) {
        ((SharedPreferences) this.getMonetizationNetwork.getValue()).edit().putLong(str, j).apply();
    }

    @Nullable
    public final String AFAdRevenueData(@Nullable String str, @Nullable String str2) {
        try {
            return ((SharedPreferences) this.getMonetizationNetwork.getValue()).getString(str, str2);
        } catch (ClassCastException e) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, e.B("Unexpected data type found for key ", str), e, false, false, false, false, 120, (Object) null);
            return str2;
        }
    }

    public final long getCurrencyIso4217Code(@Nullable String str, long j) {
        try {
            return ((SharedPreferences) this.getMonetizationNetwork.getValue()).getLong(str, j);
        } catch (ClassCastException e) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, e.B("Unexpected data type found for key ", str), e, false, false, false, false, 120, (Object) null);
            return j;
        }
    }

    public final boolean getMediationNetwork(@Nullable String str, boolean z) {
        try {
            return ((SharedPreferences) this.getMonetizationNetwork.getValue()).getBoolean(str, z);
        } catch (ClassCastException e) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, e.B("Unexpected data type found for key ", str), e, false, false, false, false, 120, (Object) null);
            return z;
        }
    }

    public final void getMonetizationNetwork(@Nullable String str) {
        ((SharedPreferences) this.getMonetizationNetwork.getValue()).edit().remove(str).apply();
    }

    public final int AFAdRevenueData(@Nullable String str, int i) {
        try {
            return ((SharedPreferences) this.getMonetizationNetwork.getValue()).getInt(str, i);
        } catch (ClassCastException e) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.PREFERENCES, e.B("Unexpected data type found for key ", str), e, false, false, false, false, 120, (Object) null);
            return i;
        }
    }

    public final void getMediationNetwork(@Nullable String str, int i) {
        ((SharedPreferences) this.getMonetizationNetwork.getValue()).edit().putInt(str, i).apply();
    }

    public final boolean getMediationNetwork(@Nullable String str) {
        return ((SharedPreferences) this.getMonetizationNetwork.getValue()).contains(str);
    }
}
