package com.ktakilat.loan.http.operation;

public class RestartDialogConfigReq {
    private String numberOfPops = "C";

    public String getNumberOfPops() {
        return this.numberOfPops;
    }

    public void setNumberOfPops(String str) {
        this.numberOfPops = str;
    }
}
