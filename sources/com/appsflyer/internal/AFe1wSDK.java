package com.appsflyer.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00028\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b"}, d2 = {"Lcom/appsflyer/internal/AFe1wSDK;", "", "", "p0", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCurrencyIso4217Code", "Ljava/lang/String;", "getMonetizationNetwork", "AFAdRevenueData", "getMediationNetwork", "getRevenue"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum AFe1wSDK {
    API("api"),
    RC("rc"),
    DEFAULT("");
    
    @NotNull
    public final String getCurrencyIso4217Code;

    private AFe1wSDK(String str) {
        this.getCurrencyIso4217Code = str;
    }
}
