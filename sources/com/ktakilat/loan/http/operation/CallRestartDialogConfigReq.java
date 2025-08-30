package com.ktakilat.loan.http.operation;

public class CallRestartDialogConfigReq {
    private Long id;

    public CallRestartDialogConfigReq(Long l) {
        this.id = l;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }
}
