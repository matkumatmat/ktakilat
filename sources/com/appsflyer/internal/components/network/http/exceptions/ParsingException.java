package com.appsflyer.internal.components.network.http.exceptions;

import androidx.annotation.NonNull;
import com.appsflyer.internal.AFd1aSDK;
import java.io.IOException;

public class ParsingException extends IOException {
    @NonNull
    private final AFd1aSDK<String> getMonetizationNetwork;

    public ParsingException(String str, Throwable th, @NonNull AFd1aSDK<String> aFd1aSDK) {
        super(str, th);
        this.getMonetizationNetwork = aFd1aSDK;
    }

    @NonNull
    public AFd1aSDK<String> getRawResponse() {
        return this.getMonetizationNetwork;
    }
}
