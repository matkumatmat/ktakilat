package com.appsflyer.internal;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AFd1sSDK {
    public static boolean getMediationNetwork(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        int monetizationNetwork = AFj1aSDK.getMonetizationNetwork(str);
        int monetizationNetwork2 = AFj1aSDK.getMonetizationNetwork(str2);
        Pair<Integer, Integer> revenue = AFd1rSDK.getRevenue(str2);
        Pair<Integer, Integer> mediationNetwork = AFd1rSDK.getMediationNetwork(str2);
        if (monetizationNetwork2 == -1 || revenue != null) {
            if (mediationNetwork != null) {
                if (mediationNetwork.getFirst().intValue() > monetizationNetwork || monetizationNetwork > mediationNetwork.getSecond().intValue()) {
                    return false;
                }
                return true;
            } else if (revenue == null || revenue.getFirst().intValue() > monetizationNetwork || monetizationNetwork > revenue.getSecond().intValue()) {
                return false;
            } else {
                return true;
            }
        } else if (monetizationNetwork2 == monetizationNetwork) {
            return true;
        } else {
            return false;
        }
    }
}
