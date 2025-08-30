package com.ktakilat.loan.http.verify;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.loan.http.user.UserLoginResp;
import java.util.ArrayList;
import java.util.List;

public class VerifyEktpResp {
    private String authStatus;
    private UserLoginResp loginResp;
    private String successfulValidationToken;

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

    public UserLoginResp getLoginResp() {
        return this.loginResp;
    }

    public String getSuccessfulValidationToken() {
        return this.successfulValidationToken;
    }

    public void setAuthStatus(String str) {
        this.authStatus = str;
    }

    public void setLoginResp(UserLoginResp userLoginResp) {
        this.loginResp = userLoginResp;
    }

    public void setSuccessfulValidationToken(String str) {
        this.successfulValidationToken = str;
    }
}
