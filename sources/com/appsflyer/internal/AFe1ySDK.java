package com.appsflyer.internal;

import androidx.annotation.NonNull;
import org.json.JSONException;

public interface AFe1ySDK<ResponseType> {
    @NonNull
    ResponseType getMonetizationNetwork(String str) throws JSONException;
}
