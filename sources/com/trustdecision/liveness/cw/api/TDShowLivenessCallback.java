package com.trustdecision.liveness.cw.api;

public interface TDShowLivenessCallback {
    void onError(String str, String str2, String str3);

    void onSuccess(String str);
}
