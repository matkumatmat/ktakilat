package com.ktakilat.loan.http.bank_card;

public class BankCardItem {
    private String code;
    private String name;
    private String permataCode;
    private String permataName;

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getPermataCode() {
        return this.permataCode;
    }

    public String getPermataName() {
        return this.permataName;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPermataCode(String str) {
        this.permataCode = str;
    }

    public void setPermataName(String str) {
        this.permataName = str;
    }
}
