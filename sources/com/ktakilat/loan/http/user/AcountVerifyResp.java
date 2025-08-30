package com.ktakilat.loan.http.user;

import com.ktakilat.cbase.checkvalue.NotEmpty;
import com.ktakilat.cbase.checkvalue.NotNull;

public class AcountVerifyResp {
    @NotNull
    private CodeDto codeDto;
    @NotEmpty
    private String token;
    private boolean type;
    @NotEmpty
    private String userId;

    public static class CodeDto {
        @NotEmpty
        private String mobileNo;

        public String getMobileNo() {
            return this.mobileNo;
        }

        public void setMobileNo(String str) {
            this.mobileNo = str;
        }
    }

    public CodeDto getCodeDto() {
        return this.codeDto;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    public boolean isType() {
        return this.type;
    }

    public void setCodeDto(CodeDto codeDto2) {
        this.codeDto = codeDto2;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setType(boolean z) {
        this.type = z;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
