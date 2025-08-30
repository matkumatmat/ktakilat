package com.ktakilat.loan.http.ojk;

public class OjkStatementReq {
    public int scene;
    public String statementType;

    public OjkStatementReq(String str, int i) {
        this.statementType = str;
        this.scene = i;
    }
}
