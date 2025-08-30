package com.appsflyer.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AFh1wSDK extends AFg1gSDK {
    @NotNull
    private final AFc1dSDK getMonetizationNetwork;
    private final boolean getRevenue = true;

    public AFh1wSDK(@NotNull AFc1dSDK aFc1dSDK) {
        Intrinsics.checkNotNullParameter(aFc1dSDK, "");
        this.getMonetizationNetwork = aFc1dSDK;
    }

    public final void d(@NotNull AFg1cSDK aFg1cSDK, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            this.getMonetizationNetwork.copy().getMonetizationNetwork("D", getRevenue(str, aFg1cSDK));
        }
    }

    public final void e(@NotNull AFg1cSDK aFg1cSDK, @NotNull String str, @NotNull Throwable th, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(th, "");
        if (z4) {
            this.getMonetizationNetwork.copy().getMonetizationNetwork(ExifInterface.LONGITUDE_EAST, getRevenue(str, aFg1cSDK));
        }
        if (z4) {
            this.getMonetizationNetwork.copy().getMonetizationNetwork(th);
        }
    }

    public final void force(@NotNull AFg1cSDK aFg1cSDK, @NotNull String str) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.getMonetizationNetwork.copy().getMonetizationNetwork("F", getRevenue(str, aFg1cSDK));
    }

    public final boolean getShouldExtendMsg() {
        return this.getRevenue;
    }

    public final void i(@NotNull AFg1cSDK aFg1cSDK, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            this.getMonetizationNetwork.copy().getMonetizationNetwork("I", getRevenue(str, aFg1cSDK));
        }
    }

    public final void v(@NotNull AFg1cSDK aFg1cSDK, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            this.getMonetizationNetwork.copy().getMonetizationNetwork(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, getRevenue(str, aFg1cSDK));
        }
    }

    public final void w(@NotNull AFg1cSDK aFg1cSDK, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(aFg1cSDK, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z) {
            this.getMonetizationNetwork.copy().getMonetizationNetwork(ExifInterface.LONGITUDE_WEST, getRevenue(str, aFg1cSDK));
        }
    }
}
