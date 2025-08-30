package com.ktakilat.loan.http.login;

import com.ktakilat.cbase.checkvalue.NotEmpty;
import com.ktakilat.cbase.checkvalue.NotNull;
import java.util.ArrayList;
import java.util.List;

public class MobileCheckResp {
    @NotNull
    private boolean exist;
    @NotEmpty
    private Integer loginType;
    @NotEmpty
    private List<String> supportedLoginTypes;

    public int getLoginType() {
        Integer num = this.loginType;
        if (num == null || num.intValue() == 0 || this.loginType.intValue() == 3) {
            return 1;
        }
        return this.loginType.intValue();
    }

    public List<String> getSupportedLoginTypes() {
        List<String> list = this.supportedLoginTypes;
        if (list == null) {
            return new ArrayList(0);
        }
        return list;
    }

    public boolean isExist() {
        return this.exist;
    }

    public void setExist(boolean z) {
        this.exist = z;
    }

    public void setLoginType(Integer num) {
        this.loginType = num;
    }

    public void setSupportedLoginTypes(List<String> list) {
        this.supportedLoginTypes = list;
    }
}
