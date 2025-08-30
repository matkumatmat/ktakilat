package com.ktakilat.loan.http.pop;

public class FetchItem {
    private String popUpsCode;
    private int tempType;
    private int triggerMethod;

    public String getPopUpsCode() {
        return this.popUpsCode;
    }

    public int getTempType() {
        return this.tempType;
    }

    public int getTriggerMethod() {
        return this.triggerMethod;
    }

    public void setPopUpsCode(String str) {
        this.popUpsCode = str;
    }

    public void setTempType(int i) {
        this.tempType = i;
    }

    public void setTriggerMethod(int i) {
        this.triggerMethod = i;
    }
}
