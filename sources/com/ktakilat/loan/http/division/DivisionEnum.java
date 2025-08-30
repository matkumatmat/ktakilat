package com.ktakilat.loan.http.division;

public enum DivisionEnum {
    PROVINCE(1),
    CITY(2),
    DISTRUCT(3);
    
    private int mValue;

    private DivisionEnum(int i) {
        this.mValue = i;
    }

    public int getValue() {
        return this.mValue;
    }
}
