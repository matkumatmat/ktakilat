package com.ktakilat.loan.http.bank_card;

public class CheckBankCardReq {
    public String bankNo;
    public String mobileNo;

    public CheckBankCardReq(String str) {
        this.bankNo = str;
    }

    public CheckBankCardReq(String str, String str2) {
        this.bankNo = str2;
        this.mobileNo = str;
    }
}
