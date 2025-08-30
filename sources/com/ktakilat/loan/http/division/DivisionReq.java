package com.ktakilat.loan.http.division;

public class DivisionReq {
    public Boolean isTop;
    public Integer parentId;
    public Integer type;

    public DivisionReq(Integer num, Boolean bool, Integer num2) {
        this.type = num;
        this.isTop = bool;
        this.parentId = num2;
    }
}
