package com.ktakilat.loan.http.verify;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.loan.http.user.UserLoginResp;
import java.util.ArrayList;
import java.util.List;

public class VerifyOtpResp {
    private String authStatus;
    private String ektp;
    private UserLoginResp loginResp;
    private int result;
    private String successfulValidationToken;
    private String twoFactorVerificationToken;

    public String getAuthStatus() {
        return this.authStatus;
    }

    public List<String> getAuthStatusList() {
        ArrayList arrayList = new ArrayList(0);
        if (!TextUtils.isEmpty(getAuthStatus())) {
            return JsonUtil.b(getAuthStatus(), new TypeToken<List<String>>() {
            });
        }
        return arrayList;
    }

    public String getEktp() {
        return this.ektp;
    }

    public UserLoginResp getLoginResp() {
        return this.loginResp;
    }

    public int getResult() {
        return this.result;
    }

    public String getSuccessfulValidationToken() {
        return this.successfulValidationToken;
    }

    public String getTwoFactorVerificationToken() {
        return this.twoFactorVerificationToken;
    }

    public void setAuthStatus(String str) {
        this.authStatus = str;
    }

    public void setEktp(String str) {
        this.ektp = str;
    }

    public void setLoginResp(UserLoginResp userLoginResp) {
        this.loginResp = userLoginResp;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setSuccessfulValidationToken(String str) {
        this.successfulValidationToken = str;
    }

    public void setTwoFactorVerificationToken(String str) {
        this.twoFactorVerificationToken = str;
    }
}
