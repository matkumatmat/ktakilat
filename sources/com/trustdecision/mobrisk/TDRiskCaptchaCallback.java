package com.trustdecision.mobrisk;

public interface TDRiskCaptchaCallback {
    void onFailed(int i, String str);

    void onReady();

    void onSuccess(String str);
}
