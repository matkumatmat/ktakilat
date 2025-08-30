package com.appsflyer.internal.components.network.http.exceptions;

import androidx.annotation.NonNull;
import com.appsflyer.internal.AFd1hSDK;
import java.io.IOException;

public class HttpException extends IOException {
    private final AFd1hSDK getRevenue;

    public HttpException(@NonNull Throwable th, @NonNull AFd1hSDK aFd1hSDK) {
        super(th.getMessage(), th);
        this.getRevenue = aFd1hSDK;
    }

    @NonNull
    public AFd1hSDK getMetrics() {
        return this.getRevenue;
    }
}
