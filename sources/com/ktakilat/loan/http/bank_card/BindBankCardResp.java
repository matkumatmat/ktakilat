package com.ktakilat.loan.http.bank_card;

public class BindBankCardResp {
    private BankCardItem bankCard;
    private String mobileNo;
    private String password;
    private String userId;

    public BankCardItem getBankCard() {
        return this.bankCard;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setBankCard(BankCardItem bankCardItem) {
        this.bankCard = bankCardItem;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
