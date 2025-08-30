package com.appsflyer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AFg1uSDK {

    public static final class AFa1uSDK {
        @Nullable
        final String getMediationNetwork;
        final float getRevenue;

        public AFa1uSDK(float f, @Nullable String str) {
            this.getRevenue = f;
            this.getMediationNetwork = str;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AFa1uSDK)) {
                return false;
            }
            AFa1uSDK aFa1uSDK = (AFa1uSDK) obj;
            if (Float.compare(this.getRevenue, aFa1uSDK.getRevenue) == 0 && Intrinsics.a(this.getMediationNetwork, aFa1uSDK.getMediationNetwork)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i;
            int floatToIntBits = Float.floatToIntBits(this.getRevenue) * 31;
            String str = this.getMediationNetwork;
            if (str == null) {
                i = 0;
            } else {
                i = str.hashCode();
            }
            return floatToIntBits + i;
        }

        @NotNull
        public final String toString() {
            float f = this.getRevenue;
            String str = this.getMediationNetwork;
            return "BatteryData(level=" + f + ", charging=" + str + ")";
        }
    }

    @NotNull
    AFa1uSDK getRevenue(@NotNull Context context);
}
