package com.ktakilat.loan.http.forget_pwd;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.ktakilat.cbase.checkvalue.NotEmpty;
import com.ktakilat.cbase.checkvalue.NotNull;
import com.ktakilat.cbase.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;

public class CheckOtpForgetPwdResp {
    private String authStatus;
    private String ektp;
    @NotNull
    private Boolean isNeedCheckEktp;
    @NotEmpty
    private String mobileNo;
    @NotEmpty
    private String token;
    @NotEmpty
    private String userId;

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

    public String getMobileNo() {
        return this.mobileNo;
    }

    public Boolean getNeedCheckEktp() {
        return this.isNeedCheckEktp;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAuthStatus(String str) {
        this.authStatus = str;
    }

    public void setEktp(String str) {
        this.ektp = str;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public void setNeedCheckEktp(Boolean bool) {
        this.isNeedCheckEktp = bool;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
