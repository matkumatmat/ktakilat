package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.share.LinkGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class AFe1kSDK extends AFe1dSDK<String> {
    private final String component2;
    private final Map<String, String> copy;
    @Nullable
    private final LinkGenerator.ResponseListener copydefault;
    @NonNull
    private final LinkGenerator equals;
    @NonNull
    private final UUID hashCode;
    @Nullable
    private final String toString;

    public AFe1kSDK(@NonNull AFc1dSDK aFc1dSDK, @NonNull UUID uuid, @NonNull String str, @NonNull Map<String, String> map, @Nullable String str2, @Nullable LinkGenerator.ResponseListener responseListener, @NonNull LinkGenerator linkGenerator) {
        super(AFe1mSDK.ONELINK, new AFe1mSDK[]{AFe1mSDK.RC_CDN}, aFc1dSDK, uuid.toString());
        this.hashCode = uuid;
        this.component2 = str;
        this.copy = new HashMap(map);
        this.copydefault = responseListener;
        this.toString = str2;
        this.equals = linkGenerator;
    }

    public final boolean a_() {
        return false;
    }

    @Nullable
    public final AppsFlyerRequestListener component3() {
        return null;
    }

    public final boolean copydefault() {
        return false;
    }

    public final long getMonetizationNetwork() {
        return 3000;
    }

    public final void getRevenue() {
        AFd1aSDK<Result> aFd1aSDK;
        super.getRevenue();
        LinkGenerator.ResponseListener responseListener = this.copydefault;
        if (responseListener == null) {
            return;
        }
        if (this.getMediationNetwork != AFe1rSDK.SUCCESS || (aFd1aSDK = this.component1) == null) {
            Throwable component4 = component4();
            if (!(component4 instanceof ParsingException)) {
                responseListener.onResponse(this.equals.generateLink());
            } else if (((ParsingException) component4).getRawResponse().isSuccessful()) {
                responseListener.onResponseError("Can't parse one link data");
            } else {
                responseListener.onResponse(this.equals.generateLink());
            }
        } else {
            responseListener.onResponse((String) aFd1aSDK.getBody());
        }
    }

    public final AFd1nSDK<String> getRevenue(@NonNull String str) {
        return this.component4.getMonetizationNetwork(this.component2, this.copy, this.toString, this.hashCode, str);
    }
}
