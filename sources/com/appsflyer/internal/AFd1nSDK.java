package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

public final class AFd1nSDK<ResponseBody> {
    private final AtomicBoolean AFAdRevenueData = new AtomicBoolean(false);
    private final AFe1ySDK<ResponseBody> getCurrencyIso4217Code;
    private final AFd1jSDK getMediationNetwork;
    private final ExecutorService getMonetizationNetwork;
    public final AFd1cSDK getRevenue;

    public AFd1nSDK(AFd1cSDK aFd1cSDK, ExecutorService executorService, AFd1jSDK aFd1jSDK, AFe1ySDK<ResponseBody> aFe1ySDK) {
        this.getRevenue = aFd1cSDK;
        this.getMonetizationNetwork = executorService;
        this.getMediationNetwork = aFd1jSDK;
        this.getCurrencyIso4217Code = aFe1ySDK;
    }

    public final AFd1aSDK<ResponseBody> getMediationNetwork() throws IOException {
        if (!this.AFAdRevenueData.getAndSet(true)) {
            AFd1aSDK<String> monetizationNetwork = this.getMediationNetwork.getMonetizationNetwork(this.getRevenue);
            try {
                return new AFd1aSDK(this.getCurrencyIso4217Code.getMonetizationNetwork(monetizationNetwork.getBody()), monetizationNetwork.getMediationNetwork, monetizationNetwork.AFAdRevenueData, monetizationNetwork.getCurrencyIso4217Code, monetizationNetwork.getRevenue);
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("could not parse raw response - execute", e);
                throw new ParsingException(e.getMessage(), e, monetizationNetwork);
            }
        } else {
            throw new IllegalStateException("Http call is already executed");
        }
    }
}
