package com.ktakilat.loan.http.bank_card;

public class CheckBankCardResp {
    private String bankCode;
    private String errorMsg;
    private boolean needCheck;
    private boolean passed;

    public String getBankCode() {
        return this.bankCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public boolean isNeedCheck() {
        return this.needCheck;
    }

    public boolean isPassed() {
        return this.passed;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setNeedCheck(boolean z) {
        this.needCheck = z;
    }

    public void setPassed(boolean z) {
        this.passed = z;
    }
}
