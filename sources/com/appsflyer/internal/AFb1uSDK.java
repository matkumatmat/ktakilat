package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

public final class AFb1uSDK {
    public final String[] getMediationNetwork;

    public AFb1uSDK(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            this.getMediationNetwork = null;
            return;
        }
        Pattern compile = Pattern.compile("[\\w]{1,45}");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str == null || !compile.matcher(str).matches()) {
                AFLogger.afWarnLog("Invalid partner name: ".concat(String.valueOf(str)));
            } else {
                arrayList.add(str.toLowerCase(Locale.getDefault()));
            }
        }
        if (arrayList.contains("all")) {
            this.getMediationNetwork = new String[]{"all"};
        } else if (!arrayList.isEmpty()) {
            this.getMediationNetwork = (String[]) arrayList.toArray(new String[0]);
        } else {
            this.getMediationNetwork = null;
        }
    }
}
