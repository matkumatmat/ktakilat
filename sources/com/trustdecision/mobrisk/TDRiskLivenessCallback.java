package com.trustdecision.mobrisk;

public interface TDRiskLivenessCallback {
    void onError(String str, String str2, String str3);

    void onSuccess(String str);
}
